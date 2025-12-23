/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.event;

// Import Mod Elements
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.effects.ModEffects;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.BigWoodlingEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.SmallWoodlingEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.StrayZombieEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.TreeZombieEntity;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.core.BlockPos;
// Import Minecraft and Forge Elements
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(modid = UndeadRemains.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onMobDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();

        // Check if it's our TreeZombie
        if (entity instanceof TreeZombieEntity treeZombie) {
            Level level = treeZombie.level();
            if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
                // Spawn Big Woodling
                BigWoodlingEntity bigWoodling = new BigWoodlingEntity(ModEntities.BIG_WOODLING.get(), serverLevel);
                bigWoodling.moveTo(treeZombie.getX(), treeZombie.getY(), treeZombie.getZ(), treeZombie.getYRot(), 0);
                serverLevel.addFreshEntity(bigWoodling);

                // Spawn Small Woodling
                SmallWoodlingEntity smallWoodling = new SmallWoodlingEntity(ModEntities.SMALL_WOODLING.get(),
                        serverLevel);
                smallWoodling.moveTo(treeZombie.getX() + 0.5, treeZombie.getY(), treeZombie.getZ() + 0.5,
                        treeZombie.getYRot(), 0);
                serverLevel.addFreshEntity(smallWoodling);
            }
        }
        // If a normal zombie dies in powder snow, replace it with our StrayZombie
        if (entity instanceof Zombie && !(entity instanceof StrayZombieEntity)) {
            Level level = entity.level();
            if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
                BlockState under = level.getBlockState(entity.blockPosition());
                if (under.is(Blocks.POWDER_SNOW)) {
                    StrayZombieEntity stray = new StrayZombieEntity(ModEntities.STRAY_ZOMBIE.get(), serverLevel);
                    stray.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), 0);
                    serverLevel.addFreshEntity(stray);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!event.getSource().is(DamageTypes.FALL)) {
            return;
        }
        LivingEntity living =  event.getEntity();
        ItemStack chestplate = living.getItemBySlot(EquipmentSlot.CHEST);
        if (chestplate.is(ModItems.XANARIAN_SPINE_CHESTPLATE.get())) {
            event.setAmount(event.getAmount() * 0.5F);
        }
    }

    @SubscribeEvent
    public static void onTridentImpact(ProjectileImpactEvent event) {

        if (!(event.getProjectile() instanceof ThrownTrident trident))
            return;
        if (!trident.isChanneling())
            return; // Only channeling tridents

        Entity owner = trident.getOwner();
        if (!(owner instanceof ServerPlayer living))
            return;

        // Check helmet
        ItemStack helmet = living.getItemBySlot(EquipmentSlot.HEAD);
        if (helmet.getItem() != ModItems.LIGHTNING_ROD_MODIFIED_FOSSIL_HELMET.get())
            return;

        HitResult hit = event.getRayTraceResult();
        if (hit.getType() != HitResult.Type.BLOCK)
            return;

        BlockPos strikePos = BlockPos.containing(hit.getLocation());
        Level level = trident.level();

        // Create lightning
        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
        if (bolt == null)
            return;

        bolt.moveTo(Vec3.atBottomCenterOf(strikePos));
        bolt.setCause(living);

        level.addFreshEntity(bolt);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.THE_FOSSILS_EYE.get(), 12),
                    10, 8, 0.02f));

            // Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.FOSSILIZED_DRUMSTICK.get(), 6),
                    5, 9, 0.035f));

            // Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 8),
                    new ItemStack(ModItems.FOSSIL.get(), 2),
                    2, 12, 0.075f));
        }

        if (event.getType() == VillagerProfession.LIBRARIAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem
                    .createForEnchantment(new EnchantmentInstance(Enchantments.THORNS, 2));

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    enchantedBook,
                    2, 8, 0.02f));
        }

    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.FOSSIL_BOOTS.get(), 1),
                3, 2, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 24),
                new ItemStack(ModItems.FOSSILIZED_DRUMSTICK.get(), 1),
                2, 12, 0.15f));
    }

    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(ModEffects.FOSSILIZED_HEART.get())) {
            event.setCanceled(true);
        }
    }

}
