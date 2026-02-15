/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.event;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.custom.Fish.XanaranhaEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.*;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.*;
import net.diverginglensestudios.undeadremains.entity.custom.Bosses.*;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UndeadRemains.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ModEntities.UNDEAD_ARCHEOLOGIST.get(), UndeadArcheologistEntity.createAttributes().build());
		event.put(ModEntities.XANARIAN_CANNIBAL.get(), XanarianCannibalEntity.createAttributes().build());
		event.put(ModEntities.STRAY_ZOMBIE.get(), StrayZombieEntity.createAttributes().build());
		event.put(ModEntities.TREE_ZOMBIE.get(), TreeZombieEntity.createAttributes().build());
		event.put(ModEntities.SUPREME_KNIGHT.get(), SupremeKnightEntity.createAttributes().build());
		event.put(ModEntities.SAHN_UZAL.get(), SahnUzalEntity.createAttributes().build());
		event.put(ModEntities.FOSSILIZED_ZOMBIE.get(), FossilizedZombieEntity.createAttributes().build());
		event.put(ModEntities.SUPREME_ZOMBIE.get(), SupremeZombieEntity.createAttributes().build());
		event.put(ModEntities.COW_ZOMBIE.get(), CowZombieEntity.createAttributes().build());
		event.put(ModEntities.SPIKE.get(), SpikeEntity.createAttributes().build());
		event.put(ModEntities.HAMMER_ZOMBIE.get(), HammerZombieEntity.createAttributes().build());
		event.put(ModEntities.FOUR_EYED_XANARIAN.get(), FourEyedXanarianEntity.createAttributes().build());
		event.put(ModEntities.XANARIAN.get(), XanarianEntity.createAttributes().build());
		event.put(ModEntities.HORNED_XANARIAN.get(), HornedXanarianEntity.createAttributes().build());
		event.put(ModEntities.XANARANHA.get(), XanaranhaEntity.createAttributes().build());
		event.put(ModEntities.BIG_WOODLING.get(), BigWoodlingEntity.createAttributes().build());
		event.put(ModEntities.SMALL_WOODLING.get(), SmallWoodlingEntity.createAttributes().build());
	}


	@SubscribeEvent
	public static void onRegisterSpawnPlacements(SpawnPlacementRegisterEvent event) {
		event.register(
				ModEntities.UNDEAD_ARCHEOLOGIST.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.STRAY_ZOMBIE.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.TREE_ZOMBIE.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.FOSSILIZED_ZOMBIE.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.SUPREME_ZOMBIE.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.COW_ZOMBIE.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.SPIKE.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.HAMMER_ZOMBIE.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.XANARANHA.get(),SpawnPlacements.Type.IN_WATER,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,AbstractFish::checkMobSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.FOUR_EYED_XANARIAN.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.XANARIAN.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
		event.register(
				ModEntities.HORNED_XANARIAN.get(),SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Monster::checkMonsterSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
	}

}
