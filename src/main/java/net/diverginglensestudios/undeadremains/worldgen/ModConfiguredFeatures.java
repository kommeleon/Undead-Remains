/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.util.ModTags;
import net.diverginglensestudios.undeadremains.worldgen.tree.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class ModConfiguredFeatures {
	//Keys
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_FOSSIL_ORE_KEY = registerKey("fossil_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> XANAS_LANGRITE_ORE_KEY = registerKey("langrite_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_METATORBERNITE_ORE_KEY = registerKey("metatorbernie_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> ASH_KEY = registerKey("ash");
	public static final ResourceKey<ConfiguredFeature<?,?>> BONETREE_KEY = registerKey("bonetree_key");
	public static final ResourceKey<ConfiguredFeature<?,?>> CALIPO_KEY = registerKey("calipo");
	public static final ResourceKey<ConfiguredFeature<?,?>> CREEPER_KEY = registerKey("creeper_key");
	public static final ResourceKey<ConfiguredFeature<?, ?>> XANAS_FLOWER_KEY =registerKey("xanas_flower_key");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		RuleTest langstoneReplaceables = new TagMatchTest(ModTags.Blocks.LANGSTONE_REPLACEABLES);

//Flowers
		register(context, XANAS_FLOWER_KEY, Feature.FLOWER,
				new RandomPatchConfiguration(32,6,2, PlacementUtils.onlyWhenEmpty(
						Feature.SIMPLE_BLOCK,new SimpleBlockConfiguration(new WeightedStateProvider(
								new SimpleWeightedRandomList.Builder<BlockState>()
										.add(ModBlocks.XANAS_FLOWER.get().defaultBlockState(), 1)
										.add(ModBlocks.XELKS_FLOWER.get().defaultBlockState(), 1)
										.add(ModBlocks.LYXOR_FLOWER.get().defaultBlockState(), 1)
										.add(ModBlocks.ROXA_FLOWER.get().defaultBlockState(), 1)
										.add(ModBlocks.CALIPO_GRASS.get().defaultBlockState(), 1)
										.build())))));

//ORES
		List<OreConfiguration.TargetBlockState> overworldFossilOres = List.of(OreConfiguration.target(stoneReplaceable,
						ModBlocks.FOSSIL_ORE.get().defaultBlockState()),
				OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_FOSSIL_ORE.get().defaultBlockState()));
		register(context, OVERWORLD_FOSSIL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldFossilOres, 9));

		List<OreConfiguration.TargetBlockState> overworldMetatorbernietOres = List.of(OreConfiguration.target(stoneReplaceable,
						ModBlocks.METATORBERNITE_ORE.get().defaultBlockState()),
				OreConfiguration.target(deepslateReplaceables, ModBlocks.METATORBERNITE_ORE.get().defaultBlockState()));
		register(context, OVERWORLD_METATORBERNITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMetatorbernietOres, 4));

		List<OreConfiguration.TargetBlockState> xanasLangriteOres = List.of(OreConfiguration.target(langstoneReplaceables,
				ModBlocks.LANGRITE_ORE.get().defaultBlockState()));
		register(context, XANAS_LANGRITE_ORE_KEY, Feature.ORE, new OreConfiguration(xanasLangriteOres, 4));

//TREE
		register(context, ASH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ModBlocks.ASH_LOG.get()),
				new FancyTrunkPlacer(5, 4, 3),
				BlockStateProvider.simple(ModBlocks.ASH_LEAVES.get()),
				new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),
				new TwoLayersFeatureSize(1,0, 2)).build());

		register(context, BONETREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(Blocks.BONE_BLOCK),
				new FancyTrunkPlacer(5, 4, 3),
				BlockStateProvider.simple(Blocks.AIR),
				new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),
				new TwoLayersFeatureSize(1,0, 2)).build());

		register(context, CREEPER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ModBlocks.CALIPO_LOG.get()),
				new CreeperTrunkPlacer(2, 1, 1),
				BlockStateProvider.simple(ModBlocks.CALIPO_LEAVES.get()),
				new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
				new TwoLayersFeatureSize(1, 0, 1)
		).build());


		register(context, CALIPO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(ModBlocks.CALIPO_LOG.get()),
				new StraightTrunkPlacer(5, 3, 6), //height=value1+randint(value2)+randint(value3)
				BlockStateProvider.simple(ModBlocks.CALIPO_LEAVES.get()),
				new CalipoFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0),8 ),
				new TwoLayersFeatureSize(2, 0, 2)).dirt(BlockStateProvider.simple(ModBlocks.LIVING_LANGSTONE.get())).forceDirt().build());
	}


	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UndeadRemains.MOD_ID, name));
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
																						  ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}
