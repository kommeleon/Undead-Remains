/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
	public static final ResourceKey<PlacedFeature> FOSSIL_ORE_PLACED_KEY = registerKey("fossil_ore_placed");
	public static final ResourceKey<PlacedFeature> LANGRITE_ORE_PLACED_KEY = registerKey("langrite_ore_placed");
	public static final ResourceKey<PlacedFeature> METATORBERNITE_ORE_PLACED_KEY = registerKey(
			"metatorbernite_ore_placed");
	public static final ResourceKey<PlacedFeature> ASH_PLACED_KEY = registerKey("ash_placed");
	public static final ResourceKey<PlacedFeature> BONETREE_PLACED_KEY = registerKey("bonetree_placed");
	public static final ResourceKey<PlacedFeature> DEAD_ASH_PLACED_KEY = registerKey("dead_ash_placed");
	public static final ResourceKey<PlacedFeature> BURNING_ASH_PLACED_KEY = registerKey("burning_ash_placed");
	public static final ResourceKey<PlacedFeature> CALIPO_PLACED_KEY = registerKey("calipo_placed");
	public static final ResourceKey<PlacedFeature> XANAS_FLOWER_PLACED_KEY = registerKey("xanas_flower_placed");

	public static void bootstrap(BootstapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
		// FLOWERS
		register(context, XANAS_FLOWER_PLACED_KEY,
				configuredFeatures.getOrThrow(ModConfiguredFeatures.XANAS_FLOWER_KEY),
				List.of(
						CountOnEveryLayerPlacement.of(10),
						InSquarePlacement.spread(),
						PlacementUtils.FULL_RANGE,
						BlockPredicateFilter.forPredicate(BlockPredicate
								.wouldSurvive(ModBlocks.XANAS_FLOWER.get().defaultBlockState(), BlockPos.ZERO)),
						BiomeFilter.biome()));

		// ORES
		register(context, FOSSIL_ORE_PLACED_KEY,
				configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_FOSSIL_ORE_KEY),
				ModOrePlacement.commonOrePlacement(12,
						HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

		register(context, LANGRITE_ORE_PLACED_KEY,
				configuredFeatures.getOrThrow(ModConfiguredFeatures.XANAS_LANGRITE_ORE_KEY),
				ModOrePlacement.commonOrePlacement(10,
						HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(190))));

		register(context, METATORBERNITE_ORE_PLACED_KEY,
				configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_METATORBERNITE_ORE_KEY),
				ModOrePlacement.commonOrePlacement(6,
						HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-10))));

		// TREES
		register(context, BONETREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BONETREE_KEY),
				VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2)));

		register(context, ASH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASH_KEY),
				List.of(
						CountOnEveryLayerPlacement.of(15),
						InSquarePlacement.spread(),
						BlockPredicateFilter.forPredicate(BlockPredicate
								.wouldSurvive(ModBlocks.ASH_SAPLING.get().defaultBlockState(), BlockPos.ZERO)),
						BiomeFilter.biome()));

		register(context, CALIPO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CALIPO_KEY),
				List.of(
						CountOnEveryLayerPlacement.of(15),
						InSquarePlacement.spread(),
						BlockPredicateFilter.forPredicate(BlockPredicate
								.wouldSurvive(ModBlocks.CALIPO_SAPLING.get().defaultBlockState(), BlockPos.ZERO)),
						BiomeFilter.biome()));

	}

	private static ResourceKey<PlacedFeature> registerKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(UndeadRemains.MOD_ID, name));
	}

	private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
			Holder<ConfiguredFeature<?, ?>> configuration,
			List<PlacementModifier> modifiers) {
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}
}
