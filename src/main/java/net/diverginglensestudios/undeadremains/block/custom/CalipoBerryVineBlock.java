/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.custom;

import javax.annotation.Nullable;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class CalipoBerryVineBlock extends CaveVinesBlock{

   public CalipoBerryVineBlock(Properties pProperties) {
      super(pProperties);
   }

   @Override
   protected Block getBodyBlock() {
      return ModBlocks.CALIPO_BERRY_VINE.get();
   }

   @Override
   public InteractionResult use(BlockState p_152980_, Level p_152981_, BlockPos p_152982_, Player p_152983_, InteractionHand p_152984_, BlockHitResult p_152985_) {
   return this.use(p_152983_, p_152980_, p_152981_, p_152982_);
   }

      static InteractionResult use(@Nullable Entity pEntity, BlockState pState, Level pLevel, BlockPos pPos) {
      if (pState.getValue(BERRIES)) {
         Block.popResource(pLevel, pPos, new ItemStack(ModItems.CALIPO_BERRIES.get(), 1));
         float f = Mth.randomBetween(pLevel.random, 0.8F, 1.2F);
         pLevel.playSound((Player)null, pPos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
         BlockState blockstate = pState.setValue(BERRIES, Boolean.valueOf(false));
         pLevel.setBlock(pPos, blockstate, 2);
         pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
         return InteractionResult.sidedSuccess(pLevel.isClientSide);
      } else {
         return InteractionResult.PASS;
      }
   }
   @Override
   public ItemStack getCloneItemStack(BlockGetter p_152966_, BlockPos p_152967_, BlockState p_152968_) {
      return new ItemStack(ModItems.CALIPO_BERRIES.get());
   }

}
