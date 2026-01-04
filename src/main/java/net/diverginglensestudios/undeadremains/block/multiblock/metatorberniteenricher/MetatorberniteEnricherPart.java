package net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher;

import net.diverginglensestudios.undeadremains.block.multiblock.MultiblockHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

// Part block
public class MetatorberniteEnricherPart extends Block{
    public static final BooleanProperty VISIBLE = BooleanProperty.create("visible");
    public MetatorberniteEnricherPart(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(VISIBLE, true));
    }
        @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VISIBLE);
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
@Override
public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
    super.onRemove(state, world, pos, newState, isMoving);

    // Only run on server
    if (!world.isClientSide()) {
        // Check all surrounding blocks to see if a controller exists
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos checkPos = pos.offset(x, y, z);
                    BlockState checkState = world.getBlockState(checkPos);
                    if (checkState.getBlock() instanceof MetatorberniteEnricherController controller) {
                        // Call your existing use() logic (or a separate method to update)
                        controller.updateMultiblockState(checkPos, world);
                    }
                }
            }
        }
    }
}
   public float getShadeBrightness(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
      return 1.0F;
   }

@Override
public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
    return true; // skylight goes through
}

}