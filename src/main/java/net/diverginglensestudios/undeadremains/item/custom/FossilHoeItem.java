package net.diverginglensestudios.undeadremains.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FossilHoeItem extends HoeItem {

    public FossilHoeItem(Tier tier, Properties properties) {
        super(tier, 1-1, 2.5f-4, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if (!level.isClientSide && player != null) {
            BlockState state = level.getBlockState(pos);

            // Check if this is a crop and fully grown
            if (state.getBlock() instanceof CropBlock crop) {
                if (crop.isMaxAge(state)) {
                    // Drop the normal drops
                    crop.playerWillDestroy(level, pos, state, player);

                    // Break and drop items
                    level.destroyBlock(pos, true, player);

                    // Try to replant
                    if (level instanceof ServerLevel serverLevel) {
                        BlockState replanted = crop.defaultBlockState();
                        serverLevel.setBlock(pos, replanted, 3);
                    }

                    // Damage the hoe slightly
                    ItemStack stack = context.getItemInHand();
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.useOn(context);
    }
}
