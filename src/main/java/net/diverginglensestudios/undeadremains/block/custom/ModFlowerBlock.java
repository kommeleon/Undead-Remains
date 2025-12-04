/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModFlowerBlock extends FlowerBlock {
    private final String placeableTag;
    public ModFlowerBlock(MobEffect pSuspiciousStewEffect, int pEffectDuration, String placeableTag, Properties pProperties) {
        super(pSuspiciousStewEffect, pEffectDuration, pProperties);
    this.placeableTag = placeableTag;
    }
    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        
        return pState.is(BlockTags.create(new ResourceLocation("forge", this.placeableTag)));
    }
}
