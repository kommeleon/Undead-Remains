/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.Continentalness;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.Erosion;
import terrablender.api.ParameterUtils.Humidity;
import terrablender.api.ParameterUtils.ParameterPointListBuilder;
import terrablender.api.ParameterUtils.Temperature;
import terrablender.api.ParameterUtils.Weirdness;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
	public ModOverworldRegion(ResourceLocation name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}


	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
	{
		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
		new ParameterPointListBuilder()
				.temperature(Temperature.span(Temperature.NEUTRAL, Temperature.NEUTRAL))
				.humidity(Humidity.span(Humidity.NEUTRAL, Humidity.HUMID))
				.continentalness(Continentalness.FAR_INLAND)
				.erosion(Erosion.EROSION_0, Erosion.EROSION_1)
				.depth(Depth.SURFACE, Depth.SURFACE)
				.weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
				.build().forEach(point -> builder.add(point, ModBiomes.ANCIENT_ASH_FOREST));

		new ParameterPointListBuilder()
				.temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
				.humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
				.continentalness(Continentalness.FAR_INLAND)
				.erosion(Erosion.EROSION_4, Erosion.EROSION_6)
				.depth(Depth.SURFACE, Depth.SURFACE)
				.weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_ASCENDING)
				.build().forEach(point -> builder.add(point, ModBiomes.BONE_VALLEY));


		// Add our points to the mapper
		builder.build().forEach(mapper);
	}
}
