/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.custom;

import net.diverginglensestudios.undeadremains.entity.custom.Other.CustomEffectCloudEntity;
import net.diverginglensestudios.undeadremains.particles.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.entity.player.Player;

public class MetatorberniteOreBlock extends Block{
    
    public MetatorberniteOreBlock(Properties pProperties) {
        super(pProperties);
    }

   @Override
   public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest,
           FluidState fluid) {

        this.spawnLingeringCloud(level, pos, state);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);

    }

    private void spawnLingeringCloud(LevelAccessor level, BlockPos pos, BlockState state) {
        if (!(level instanceof ServerLevel serverLevel)) return; // Ensure it's running on the server
       

        CustomEffectCloudEntity areaEffectCloud = new CustomEffectCloudEntity(serverLevel,
        pos.getX() + 0.5, // Center the cloud in the block
        pos.getY() + 0.5,
        pos.getZ() + 0.5);

        areaEffectCloud.setRadius(3.0F);
        areaEffectCloud.setRadiusOnUse(-0.5F);
        areaEffectCloud.setWaitTime(10);
        areaEffectCloud.setDuration(200); // Duration in ticks (10 seconds)
        areaEffectCloud.setRadiusPerTick(-areaEffectCloud.getRadius() / areaEffectCloud.getDuration());
        areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1));
        areaEffectCloud.setParticle(ModParticles.METATORBERNITE_PARTICLES.get());
        areaEffectCloud.setDimensions(3F, 2F);
        serverLevel.addFreshEntity(areaEffectCloud);
    
}
    private boolean isBrokenWithSilkTouch(Player player) {
        if (player != null) {
            ItemStack heldItem = player.getMainHandItem();
            return heldItem.isEnchanted() && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) > 0;
        }
        return false;
    }
    }

