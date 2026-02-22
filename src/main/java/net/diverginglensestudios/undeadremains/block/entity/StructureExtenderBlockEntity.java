/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StructureExtenderBlockEntity extends BlockEntity {

	private static final int MAX_DISTANCE = 300;

	public StructureExtenderBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(ModBlockEntities.STRUCTURE_EXTENDER_BE.get(), pPos, pBlockState);
	}

	public static void tick(ServerLevel pLevel, BlockPos pPos, BlockState pState, StructureExtenderBlockEntity pBlockEntity) {
		BlockState aboveState = pLevel.getBlockState(pPos.above());
		BlockState belowState = pLevel.getBlockState(pPos.below());

		if (pLevel.hasNeighborSignal(pPos)) {
			return;
		} else if (isSolid(pLevel, pPos.above())) {
			extend(pLevel, pPos, Direction.DOWN, aboveState);
		} else if (isSolid(pLevel, pPos.below())) {
			extend(pLevel, pPos, Direction.UP, belowState);
		}
	}

	private static void extend(ServerLevel level, BlockPos startPos, Direction direction, BlockState fillState) {
		BlockPos.MutableBlockPos checkPos = startPos.mutable();
		int distance = 0;

		while (distance < MAX_DISTANCE) {
			checkPos.move(direction);
			distance++;

			if (level.getBlockState(checkPos).isSolid()) {
				break;
			}
		}

		if (distance >= MAX_DISTANCE) {
			return;
		}

		BlockPos.MutableBlockPos placePos = startPos.mutable();

		for (int i = 0; i < distance; i++) {
			level.setBlock(placePos, fillState, 3);
			placePos.move(direction);
		}
	}

	private static boolean isSolid(ServerLevel level, BlockPos pos) {
		return level.getBlockState(pos).isSolid();
	}
}
