package net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher;

import javax.annotation.Nullable;

import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.diverginglensestudios.undeadremains.block.multiblock.MultiblockHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class MetatorberniteEnricherController extends BaseEntityBlock {
    public static final BooleanProperty COMPLETE = BooleanProperty.create("complete");
    public MetatorberniteEnricherController(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(COMPLETE, false));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COMPLETE);
    }

@Override
public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    if (!world.isClientSide()) {
        updateMultiblockState(pos, world);
        BlockEntity entity = world.getBlockEntity(pos);
            if(entity instanceof MetatorberniteEnricherBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)player), (MetatorberniteEnricherBlockEntity)entity, pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
    }

    return InteractionResult.sidedSuccess(world.isClientSide());
}

public void updateMultiblockState(BlockPos pos, Level world) {
    BlockState state = world.getBlockState(pos);
    boolean complete = MultiblockHelper.isMetatorberniteEnricherComplete(world, pos);

    // Update controller COMPLETE property if changed
    if (state.getValue(MetatorberniteEnricherController.COMPLETE) != complete) {
        world.setBlock(pos, state.setValue(MetatorberniteEnricherController.COMPLETE, complete), 3 | 16);
    }

    // Update surrounding part blocks’ visibility
    for (int x = -1; x <= 1; x++) {
        for (int y = -1; y <= 1; y++) {
            for (int z = -1; z <= 1; z++) {
                if (x == 0 && y == 0 && z == 0) continue; // skip controller
                BlockPos partPos = pos.offset(x, y, z);
                BlockState partState = world.getBlockState(partPos);
                if (partState.getBlock() instanceof MetatorberniteEnricherPart) {
                    world.setBlock(partPos, partState.setValue(MetatorberniteEnricherPart.VISIBLE, !complete), 3);
                }
            }
        }
    }

    System.out.println("Metatorbernite Enricher is " + (complete ? "complete!" : "incomplete!"));
}
@Override
public RenderShape getRenderShape(BlockState pState) {
    return RenderShape.MODEL;
}

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MetatorberniteEnricherBlockEntity(pPos, pState);
    }

@Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof MetatorberniteEnricherBlockEntity) {
                ((MetatorberniteEnricherBlockEntity) blockEntity).drops();
            }
        }
}

@Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.METATORBERNITE_ENRICHER.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
                
    }
    
}



