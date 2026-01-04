package net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher;

import net.diverginglensestudios.undeadremains.block.multiblock.MultiblockHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class MetatorberniteEnricherController extends Block {
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
            if (MultiblockHelper.isMetatorberniteEnricherComplete(world, pos)) {
                System.out.println("Metatorbernite Enricher is complete!");
                world.setBlock(pos, state.setValue(MetatorberniteEnricherController.COMPLETE, true), 3);
            } else {
                System.out.println("Metatorbernite Enricher is incomplete!");
                world.setBlock(pos, state.setValue(MetatorberniteEnricherController.COMPLETE, false), 3);
            }
        }
        return InteractionResult.sidedSuccess(world.isClientSide());
    }
}

