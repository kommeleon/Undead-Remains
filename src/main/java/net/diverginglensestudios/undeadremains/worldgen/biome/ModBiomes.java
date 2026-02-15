/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.worldgen.biome;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.sound.ModSounds;
import net.diverginglensestudios.undeadremains.worldgen.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
	public static final ResourceKey<Biome> ANCIENT_ASH_FOREST = ResourceKey.create(Registries.BIOME,
			new ResourceLocation(UndeadRemains.MOD_ID, "ancient_ash_forest"));
	public static final ResourceKey<Biome> DEAD_ASH_FOREST = ResourceKey.create(Registries.BIOME,
			new ResourceLocation(UndeadRemains.MOD_ID, "dead_ash_forest"));
	public static final ResourceKey<Biome> CALIPO_FOREST = ResourceKey.create(Registries.BIOME,
			new ResourceLocation(UndeadRemains.MOD_ID, "calipo_forest"));
	public static final ResourceKey<Biome> CREEPER_CAVERNS = ResourceKey.create(Registries.BIOME,
			new ResourceLocation(UndeadRemains.MOD_ID, "creeper_caverns"));
	public static final ResourceKey<Biome> BONE_VALLEY = ResourceKey.create(Registries.BIOME,
			new ResourceLocation(UndeadRemains.MOD_ID, "bone_valley"));

	public static void boostrap(BootstapContext<Biome> context) {
		context.register(ANCIENT_ASH_FOREST, ancientAshForest(context));
		context.register(CREEPER_CAVERNS, creeperCaverns(context));
		context.register(CALIPO_FOREST, calipoForest(context));
		context.register(BONE_VALLEY, boneValley(context));
	}

	public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
		BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
		BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
		BiomeDefaultFeatures.addDefaultSprings(builder);
		BiomeDefaultFeatures.addSurfaceFreezing(builder);
	}
	//////////ANCIENT ASH FOREST//////////
	public static Biome ancientAshForest(BootstapContext<Biome> context) {

		MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.UNDEAD_ARCHEOLOGIST.get(), 2, 3, 5));
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.FOSSILIZED_ZOMBIE.get(), 2, 3, 5));
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.COW_ZOMBIE.get(), 2, 3, 5));
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.SPIKE.get(), 2, 3, 5));


		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

		BiomeDefaultFeatures.farmAnimals(spawnBuilder);
		BiomeDefaultFeatures.commonSpawns(spawnBuilder);

		BiomeGenerationSettings.Builder biomeBuilder =
				new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
		//we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
		globalOverworldGeneration(biomeBuilder);
		BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
		BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
		BiomeDefaultFeatures.addFerns(biomeBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

		biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

		BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
		biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ASH_PLACED_KEY)
				.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreePlacements.CRIMSON_FUNGI);

		return new Biome.BiomeBuilder()
				.hasPrecipitation(true)
				.downfall(0.8f)
				.temperature(0.7f)
				.generationSettings(biomeBuilder.build())
				.mobSpawnSettings(spawnBuilder.build())
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(0x6592c9)
						.waterFogColor(0x3b97a7)
						.skyColor(0xb0d0df)
						.grassColorOverride(0x6bd80e)
						.foliageColorOverride(0x70c027)
						.fogColor(0x93baca)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.backgroundMusic(Musics.GAME).build())
				.build();
	}

	//////////Bone Valley//////////
	public static Biome boneValley(BootstapContext<Biome> context) {

		MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.UNDEAD_ARCHEOLOGIST.get(), 2, 3, 5));
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.FOSSILIZED_ZOMBIE.get(), 2, 3, 5));
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.COW_ZOMBIE.get(), 2, 3, 5));
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.SPIKE.get(), 2, 3, 5));


		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 5, 4, 4));
		spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 5, 4, 4));

		BiomeGenerationSettings.Builder biomeBuilder =
				new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
		//we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
		globalOverworldGeneration(biomeBuilder);

		BiomeDefaultFeatures.addDefaultOres(biomeBuilder);



		biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BONETREE_PLACED_KEY);

		return new Biome.BiomeBuilder()
				.hasPrecipitation(true)
				.downfall(0.8f)
				.temperature(0.7f)
				.generationSettings(biomeBuilder.build())
				.mobSpawnSettings(spawnBuilder.build())
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(0x555756)
						.waterFogColor(0x3b97a7)
						.skyColor(0x7f9394)
						.grassColorOverride(0x384031)
						.foliageColorOverride(0x2c3029)
						.fogColor(0x000000)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.backgroundMusic(Musics.GAME).build())
				.build();
	}
	////////// CALIPO FOREST //////////
	public static Biome calipoForest(BootstapContext<Biome> context) {

		MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


		spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 5, 1, 2));
		spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.FOUR_EYED_XANARIAN.get(), 5, 2, 4));
		spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.XANARIAN.get(), 5, 2, 4));
		spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HORNED_XANARIAN.get(), 5, 2, 4));
		spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.XANARANHA.get(), 20, 5, 8));

		BiomeGenerationSettings.Builder biomeBuilder =
				new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
		//we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
		globalOverworldGeneration(biomeBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
		biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LANGRITE_ORE_PLACED_KEY);


		BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
		biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.XANAS_FLOWER_PLACED_KEY);
		biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CALIPO_PLACED_KEY);

		return new Biome.BiomeBuilder()
				.hasPrecipitation(true)
				.downfall(0.8f)
				.temperature(0.7f)
				.generationSettings(biomeBuilder.build())
				.mobSpawnSettings(spawnBuilder.build())
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(0x6592c9)
						.waterFogColor(0x3b97a7)
						.skyColor(0x9c2780)
						.grassColorOverride(0x6bd80e)
						.foliageColorOverride(0x70c027)
						.fogColor(0x9c2780)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.backgroundMusic(Musics.GAME).build())
				.build();
	}
	////////// CREEPER CAVERNS //////////
	public static Biome creeperCaverns(BootstapContext<Biome> context) {

		MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


		spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 5, 2, 4));
		spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.HORNED_XANARIAN.get(), 5, 1, 2));

		BiomeGenerationSettings.Builder biomeBuilder =
				new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
		//we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
		globalOverworldGeneration(biomeBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
		biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.LANGRITE_ORE_PLACED_KEY);

		BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
		biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CALIPO_PLACED_KEY);

		return new Biome.BiomeBuilder()
				.hasPrecipitation(true)
				.downfall(0.8f)
				.temperature(0.7f)
				.generationSettings(biomeBuilder.build())
				.mobSpawnSettings(spawnBuilder.build())
				.specialEffects((new BiomeSpecialEffects.Builder())
						.waterColor(0x6592c9)
						.waterFogColor(0x3b97a7)
						.skyColor(0x9c2780)
						.grassColorOverride(0x6bd80e)
						.foliageColorOverride(0x70c027)
						.fogColor(0x9c2780)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.backgroundMusic(Musics.GAME).build())
				.build();
	}
}