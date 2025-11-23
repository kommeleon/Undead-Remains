/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.custom;

import java.util.List;
import java.util.Random;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.FossilizedZombieEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.SupremeZombieEntity;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;

public class FossilLuckyBlock extends Block {

    public FossilLuckyBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        super.destroy(pLevel, pPos, pState);
        if (pLevel instanceof ServerLevel serverLevel) {
            Random random = new Random();
            int choice = random.nextInt(7) + 1; // Number of events
            if (choice == 1) {////////// EVENT_1//////////
                SupremeZombieEntity customEntity = new SupremeZombieEntity(ModEntities.SUPREME_ZOMBIE.get(),
                        serverLevel);
                customEntity.moveTo(pPos.getX() + 0.5, pPos.getY(), pPos.getZ() + 0.5, 0, 0);
                serverLevel.addFreshEntity(customEntity);

            } else if (choice == 2) {////////// EVENT_2//////////
                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (lightningBolt != null) {
                    lightningBolt.moveTo(pPos.getX() + 0.5, pPos.getY(), pPos.getZ() + 0.5);
                    lightningBolt.setVisualOnly(false); // Ensures it causes fire and damage
                    serverLevel.addFreshEntity(lightningBolt);
                }
            } else if (choice == 3) {////////// EVENT_3//////////
                // Drop a random Rare Fossil Armor piece
                ItemStack armorDrop;
                int armorChoice = random.nextInt(4); // 0-3 for different armor pieces
                switch (armorChoice) {
                    case 0 -> armorDrop = new ItemStack(ModItems.RARE_FOSSIL_HELMET.get());
                    case 1 -> armorDrop = new ItemStack(ModItems.RARE_FOSSIL_CHESTPLATE.get());
                    case 2 -> armorDrop = new ItemStack(ModItems.RARE_FOSSIL_LEGGINGS.get());
                    case 3 -> armorDrop = new ItemStack(ModItems.RARE_FOSSIL_BOOTS.get());
                    default -> armorDrop = ItemStack.EMPTY;
                }
                if (!armorDrop.isEmpty()) {
                    Block.popResource(serverLevel, pPos, armorDrop);
                }

            } else if (choice == 4) {////////// EVENT_4//////////
                ItemStack toolDrop;
                int toolChoice = random.nextInt(5); // 0-4 for different armor pieces
                switch (toolChoice) {
                    case 0 -> toolDrop = new ItemStack(ModItems.RARE_FOSSIL_AXE.get());
                    case 1 -> toolDrop = new ItemStack(ModItems.RARE_FOSSIL_HOE.get());
                    case 2 -> toolDrop = new ItemStack(ModItems.RARE_FOSSIL_PICKAXE.get());
                    case 3 -> toolDrop = new ItemStack(ModItems.RARE_FOSSIL_SHOVEL.get());
                    case 4 -> toolDrop = new ItemStack(ModItems.RARE_FOSSIL_SWORD.get());
                    default -> toolDrop = ItemStack.EMPTY;
                }
                if (!toolDrop.isEmpty()) {
                    Block.popResource(serverLevel, pPos, toolDrop);
                }

            } else if (choice == 5) {////////// EVENT_5//////////
                int mobcount = 0;
                while (mobcount < 10) {// amount of mobs spawned
                    FossilizedZombieEntity customEntity = new FossilizedZombieEntity(
                            ModEntities.FOSSILIZED_ZOMBIE.get(), serverLevel);
                    customEntity.moveTo(pPos.getX() + 0.5, pPos.getY(), pPos.getZ() + 0.5, 0, 0);
                    serverLevel.addFreshEntity(customEntity);
                    mobcount++;
                }

            } else if (choice == 6) {////////// EVENT_6//////////
                serverLevel.levelEvent(2001, pPos, Block.getId(ModBlocks.FOSSIL_BLOCK.get().defaultBlockState())); // Particle
                                                                                                                   // effect
                serverLevel.playSound(null, pPos, SoundEvents.CHICKEN_HURT, SoundSource.BLOCKS, 1.0F, 1.0F);
                ItemStack drop = new ItemStack(ModItems.FOSSILIZED_DRUMSTICK.get(), random.nextInt(6) + 1);
                Block.popResource(serverLevel, pPos, drop);

            } else if (choice == 7) { ///////// EVENT_7 /////////
                serverLevel.setBlock(pPos, Blocks.SMITHING_TABLE.defaultBlockState(), 3);
                ItemStack toolDrop;
                ItemStack bonusDrop = ItemStack.EMPTY;
                int toolChoice = random.nextInt(5); // 0-4 for different tools
                switch (toolChoice) {
                    case 0 -> { // Axe
                        toolDrop = new ItemStack(ModItems.FOSSIL_AXE.get());
                        bonusDrop = new ItemStack(Items.RABBIT_FOOT);
                    }
                    case 1 -> { // Hoe
                        toolDrop = new ItemStack(ModItems.FOSSIL_HOE.get());
                        bonusDrop = new ItemStack(Items.SLIME_BALL);
                    }
                    case 2 -> { // Pickaxe
                        toolDrop = new ItemStack(ModItems.FOSSIL_PICKAXE.get());
                        bonusDrop = new ItemStack(Items.BLAZE_ROD);
                    }
                    case 3 -> { // Shovel
                        toolDrop = new ItemStack(ModItems.FOSSIL_SHOVEL.get());
                        bonusDrop = new ItemStack(Items.NAUTILUS_SHELL);
                    }
                    case 4 -> { // Sword
                        toolDrop = new ItemStack(ModItems.FOSSIL_SWORD.get());
                        bonusDrop = new ItemStack(Items.AMETHYST_SHARD);
                    }
                    default -> toolDrop = ItemStack.EMPTY;
                }
                if (!toolDrop.isEmpty()) {
                    Block.popResource(serverLevel, pPos, toolDrop);
                }
                if (!bonusDrop.isEmpty()) {
                    Block.popResource(serverLevel, pPos, bonusDrop);
                }
            } else if (choice == 8) { ///////// EVENT_8 /////////
                serverLevel.setBlock(pPos, Blocks.SMITHING_TABLE.defaultBlockState(), 3);
                ItemStack toolDrop;
                ItemStack bonusDrop = ItemStack.EMPTY;
                int toolChoice = random.nextInt(4);
                switch (toolChoice) {
                    case 0 -> { // helmet
                        toolDrop = new ItemStack(ModItems.FOSSIL_HELMET.get());
                        bonusDrop = new ItemStack(Items.LIGHTNING_ROD);
                    }
                    case 1 -> { // chestplate
                        toolDrop = new ItemStack(ModItems.FOSSIL_CHESTPLATE.get());
                        bonusDrop = new ItemStack(Items.CLOCK);
                    }
                    case 2 -> { // leggings
                        toolDrop = new ItemStack(ModItems.FOSSIL_LEGGINGS.get());
                        bonusDrop = new ItemStack(Items.SCUTE);
                    }
                    case 3 -> { // boots
                        toolDrop = new ItemStack(ModItems.FOSSIL_BOOTS.get());
                        bonusDrop = new ItemStack(Items.ECHO_SHARD);
                    }
                    default -> toolDrop = ItemStack.EMPTY;
                }
                if (!toolDrop.isEmpty()) {
                    Block.popResource(serverLevel, pPos, toolDrop);
                }
                if (!bonusDrop.isEmpty()) {
                    Block.popResource(serverLevel, pPos, bonusDrop);
                }
            }

        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        return List.of(); // Prevents default block drops
    }
}
