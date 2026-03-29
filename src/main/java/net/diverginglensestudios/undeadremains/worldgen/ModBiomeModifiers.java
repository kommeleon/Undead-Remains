/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen;

import java.util.List;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.Tags.Biomes;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
	public static final ResourceKey<BiomeModifier> ADD_FOSSIL_ORE = registerKey("add_fossil_ore");

	public static final ResourceKey<BiomeModifier> ADD_METATORBERNITE_ORE = registerKey("add_metatorbernite_ore");

	public static final ResourceKey<BiomeModifier> ADD_TREE_ASH = registerKey("add_tree_ash");

	public static final ResourceKey<BiomeModifier> ADD_TREE_CALIPO = registerKey("add_tree_calipo");

	public static final ResourceKey<BiomeModifier> ADD_FOSSILIZED_ZOMBIE = registerKey("add_fossilized_zombie");
	public static final ResourceKey<BiomeModifier> ADD_COW_ZOMBIE = registerKey("add_cow_zombie");
	public static final ResourceKey<BiomeModifier> ADD_UNDEAD_ARCHEOLOGIST = registerKey("add_undead_archeologist");
	public static final ResourceKey<BiomeModifier> ADD_SPIKE = registerKey("add_spike");
	public static final ResourceKey<BiomeModifier> ADD_TREE_ZOMBIE = registerKey("add_tree_zombie");
	public static final ResourceKey<BiomeModifier> ADD_HAMMER_ZOMBIE = registerKey("add_hammer_zombie");
	public static final ResourceKey<BiomeModifier> ADD_STRAY_ZOMBIE = registerKey("add_stray_zombie");

	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		var biomes = context.lookup(Registries.BIOME);

		context.register(ADD_FOSSIL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.FOSSIL_ORE_PLACED_KEY)),
				GenerationStep.Decoration.UNDERGROUND_ORES));

		context.register(ADD_METATORBERNITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.METATORBERNITE_ORE_PLACED_KEY)),
				GenerationStep.Decoration.UNDERGROUND_ORES));


		context.register(ADD_UNDEAD_ARCHEOLOGIST, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				List.of(new MobSpawnSettings.SpawnerData(ModEntities.UNDEAD_ARCHEOLOGIST.get(), 100, 2, 4))));

		context.register(ADD_FOSSILIZED_ZOMBIE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				List.of(new MobSpawnSettings.SpawnerData(ModEntities.FOSSILIZED_ZOMBIE.get(), 100, 2, 4))));

		context.register(ADD_COW_ZOMBIE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				List.of(new MobSpawnSettings.SpawnerData(ModEntities.COW_ZOMBIE.get(), 100, 2, 4))));

		context.register(ADD_SPIKE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				List.of(new MobSpawnSettings.SpawnerData(ModEntities.SPIKE.get(), 100, 2, 4))));

		context.register(ADD_TREE_ZOMBIE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_FOREST),
				List.of(new MobSpawnSettings.SpawnerData(ModEntities.TREE_ZOMBIE.get(), 100, 2, 4))));

		context.register(ADD_HAMMER_ZOMBIE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
				biomes.getOrThrow(BiomeTags.HAS_SWAMP_HUT),
				List.of(new MobSpawnSettings.SpawnerData(ModEntities.HAMMER_ZOMBIE.get(), 100, 2, 4))));

		context.register(ADD_STRAY_ZOMBIE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
				biomes.getOrThrow(Biomes.IS_COLD),
				List.of(new MobSpawnSettings.SpawnerData(ModEntities.STRAY_ZOMBIE.get(), 100, 2, 4))));
	}

	private static ResourceKey<BiomeModifier> registerKey(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(UndeadRemains.MOD_ID, name));
	}
}
