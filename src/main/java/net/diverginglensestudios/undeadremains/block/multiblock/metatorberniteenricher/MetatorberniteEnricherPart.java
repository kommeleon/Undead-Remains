package net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

// Part block
public class MetatorberniteEnricherPart extends Block {
    public MetatorberniteEnricherPart(Properties properties) {
        super(properties);
    }
    @Override
public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    // Find controller in the center of this 3x3x3
    BlockPos controllerPos = pos; // assume center at some offset
    for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos checkPos = pos.offset(dx, dy, dz);
                if (world.getBlockState(checkPos).getBlock() instanceof MetatorberniteEnricherController controller) {
                    return controller.use(world.getBlockState(checkPos), world, checkPos, player, hand, hit);
                }
            }
        }
    }
    return InteractionResult.PASS;
}
}