/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen.biome;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(UndeadRemains.MOD_ID, "overworld"), 5));
    }
}