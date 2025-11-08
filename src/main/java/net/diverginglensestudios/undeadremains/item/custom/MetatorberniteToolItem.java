/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/


package net.diverginglensestudios.undeadremains.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

/**
 * Multi-tool that behaves as a pickaxe, shovel and hoe.
 * Right-click: try hoe (till) first, then shovel (path).
 * Mining: respects tool tags (pickaxe/shovel/hoe).
 */
public class MetatorberniteToolItem extends PickaxeItem {

    public MetatorberniteToolItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction face = context.getClickedFace();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        // Only act on top face and when space above is free (same behavior as vanilla hoes/shovels)
        if (face != Direction.UP) return InteractionResult.PASS;
        if (!level.isEmptyBlock(pos.above())) return InteractionResult.PASS;

        BlockState targetState = level.getBlockState(pos);

        // HOE behavior (tilling) — try first
        if (canTill(targetState)) {
            level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!level.isClientSide()) {
                level.setBlock(pos, Blocks.FARMLAND.defaultBlockState(), 11);
                if (player != null) stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(context.getHand()));
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        // SHOVEL behavior (make path) — only from grass block to avoid conflict with dirt which should be tilled
        if (canMakePath(targetState)) {
            level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!level.isClientSide()) {
                level.setBlock(pos, Blocks.DIRT_PATH.defaultBlockState(), 11);
                if (player != null) stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(context.getHand()));
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return InteractionResult.PASS;
    }

    private boolean canTill(BlockState state) {
        // Tillable: grass block, dirt, coarse dirt (coarse dirt can't be tilled in vanilla but adjust if desired)
        return state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT);
    }

    private boolean canMakePath(BlockState state) {
        // Only create a path from grass block to avoid conflicting with dirt which should be tilled
        return state.is(Blocks.GRASS_BLOCK);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        // Prefer correct tool tag: pickaxe > shovel > hoe
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return super.getDestroySpeed(stack, state);
        }
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL) || state.is(BlockTags.MINEABLE_WITH_HOE)) {
            return this.speed;
        }
        return super.getDestroySpeed(stack, state);
    }
}