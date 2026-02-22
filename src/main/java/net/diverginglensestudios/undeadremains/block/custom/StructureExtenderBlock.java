package net.diverginglensestudios.undeadremains.block.custom;

import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.diverginglensestudios.undeadremains.block.entity.StructureExtenderBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class StructureExtenderBlock extends BaseEntityBlock {

	public StructureExtenderBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new StructureExtenderBlockEntity(pPos, pState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
		if (pLevel.isClientSide) {
			return null;
		}
		return createTickerHelper(pBlockEntityType, ModBlockEntities.STRUCTURE_EXTENDER_BE.get(),
				(pLevel1, pPos, pState1, pBlockEntity) -> StructureExtenderBlockEntity.tick((net.minecraft.server.level.ServerLevel) pLevel1, pPos, pState1, pBlockEntity));
	}
}