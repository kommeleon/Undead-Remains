package net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;

public class MetatorberniteEnricherBlockEntity extends BlockEntity {

    public MetatorberniteEnricherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.METATORBERNITE_ENRICHER.get(), pos, state);
    }

}