/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity;

// Import Mod Elements
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.custom.Fish.XanaranhaEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Other.*;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.*;
import net.diverginglensestudios.undeadremains.entity.custom.Zombies.*;
import net.diverginglensestudios.undeadremains.entity.custom.Bosses.*;

// Import Minecraft and Forge Elements
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UndeadRemains.MOD_ID);

	public static final RegistryObject<EntityType<UndeadArcheologistEntity>> UNDEAD_ARCHEOLOGIST =
			ENTITY_TYPES.register("undead_archeologist",  () -> EntityType.Builder.of(UndeadArcheologistEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 2f).build("undead_archeologist"));

	public static final RegistryObject<EntityType<SupremeKnightEntity>> SUPREME_KNIGHT =
			ENTITY_TYPES.register("supreme_knight",  () -> EntityType.Builder.of(SupremeKnightEntity::new, MobCategory.MONSTER)
					.sized(2f, 4f).build("supreme_knight"));

	public static final RegistryObject<EntityType<SahnUzalEntity>> SAHN_UZAL =
			ENTITY_TYPES.register("sahn_uzal",  () -> EntityType.Builder.of(SahnUzalEntity::new, MobCategory.MONSTER)
					.sized(2f, 4f).build("sahn_uzal"));

	public static final RegistryObject<EntityType<FossilizedZombieEntity>> FOSSILIZED_ZOMBIE =
			ENTITY_TYPES.register("fossilized_zombie", () -> EntityType.Builder.<FossilizedZombieEntity>of(FossilizedZombieEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 2f).build("fossilized_zombie"));

	public static final RegistryObject<EntityType<CowZombieEntity>> COW_ZOMBIE =
			ENTITY_TYPES.register("cow_zombie", () -> EntityType.Builder.<CowZombieEntity>of(CowZombieEntity::new, MobCategory.MONSTER)
					.sized(1.5f, 2f).build("cow_zombie"));

	public static final RegistryObject<EntityType<SpikeEntity>> SPIKE =
			ENTITY_TYPES.register("spike", () -> EntityType.Builder.<SpikeEntity>of(SpikeEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 2f).build("spike"));

	public static final RegistryObject<EntityType<StrayZombieEntity>> STRAY_ZOMBIE =
			ENTITY_TYPES.register("stray_zombie", () -> EntityType.Builder.<StrayZombieEntity>of(StrayZombieEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 2f).build("stray_zombie"));

	public static final RegistryObject<EntityType<TreeZombieEntity>> TREE_ZOMBIE =
			ENTITY_TYPES.register("tree_zombie", () -> EntityType.Builder.<TreeZombieEntity>of(TreeZombieEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 2f).build("tree_zombie"));

	public static final RegistryObject<EntityType<BigWoodlingEntity>> BIG_WOODLING =
			ENTITY_TYPES.register("big_woodling", () -> EntityType.Builder.<BigWoodlingEntity>of(BigWoodlingEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 1f).build("big_woodling"));

	public static final RegistryObject<EntityType<SmallWoodlingEntity>> SMALL_WOODLING =
			ENTITY_TYPES.register("small_woodling", () -> EntityType.Builder.<SmallWoodlingEntity>of(SmallWoodlingEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 1f).build("small_woodling"));

	public static final RegistryObject<EntityType<HammerZombieEntity>> HAMMER_ZOMBIE =
			ENTITY_TYPES.register("hammer_zombie", () -> EntityType.Builder.<HammerZombieEntity>of(HammerZombieEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 2f).build("hammer_zombie"));

	public static final RegistryObject<EntityType<FourEyedXanarianEntity>> FOUR_EYED_XANARIAN =
			ENTITY_TYPES.register("four_eyed_xanarian", () -> EntityType.Builder.<FourEyedXanarianEntity>of(FourEyedXanarianEntity::new, MobCategory.MONSTER)
					.sized(1.4f, 2.5f).build("four_eyed_xanarian"));

	public static final RegistryObject<EntityType<XanarianEntity>> XANARIAN =
			ENTITY_TYPES.register("xanarian", () -> EntityType.Builder.<XanarianEntity>of(XanarianEntity::new, MobCategory.MONSTER)
					.sized(1.4f, 4f).build("xanarian"));

	public static final RegistryObject<EntityType<HornedXanarianEntity>> HORNED_XANARIAN =
			ENTITY_TYPES.register("horned_xanarian", () -> EntityType.Builder.<HornedXanarianEntity>of(HornedXanarianEntity::new, MobCategory.MONSTER)
					.sized(1.5f, 4.5f).build("horned_xanarian"));

	public static final RegistryObject<EntityType<XanarianCannibalEntity>> XANARIAN_CANNIBAL =
			ENTITY_TYPES.register("xanarian_cannibal", () -> EntityType.Builder.<XanarianCannibalEntity>of(XanarianCannibalEntity::new, MobCategory.MONSTER)
					.sized(1.4f, 2.5f).build("xanarian_cannibal"));

	public static final RegistryObject<EntityType<XanaranhaEntity>> XANARANHA =
			ENTITY_TYPES.register("xanaranha", () -> EntityType.Builder.<XanaranhaEntity>of(XanaranhaEntity::new, MobCategory.WATER_CREATURE)
					.sized(1.4f, 2.5f).build("xanaranha"));

	public static final RegistryObject<EntityType<SupremeZombieEntity>> SUPREME_ZOMBIE =
			ENTITY_TYPES.register("supreme_zombie",  () -> EntityType.Builder.of(SupremeZombieEntity::new, MobCategory.MONSTER)
					.sized(0.6f, 2f).build("supreme_zombie"));

	public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT =
			ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
					.sized(1.375f, 0.5625f).build("mod_boat"));

	public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
			ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
					.sized(1.375f, 0.5625f).build("mod_chest_boat"));

	public static final RegistryObject<EntityType<CustomEffectCloudEntity>> CUSTOMEFFECTCLOUD =
			ENTITY_TYPES.register("customeffectcloud", () -> EntityType.Builder.<CustomEffectCloudEntity>of(CustomEffectCloudEntity::new, MobCategory.MISC)
					.build("customeffectcloud"));

	public static final RegistryObject<EntityType<Cm_Falling_Block_Entity>> CM_FALLING_BLOCK =
			ENTITY_TYPES.register("cm_falling_block", () -> EntityType.Builder.<Cm_Falling_Block_Entity>of(Cm_Falling_Block_Entity::new, MobCategory.MISC)
					.sized(0.98F, 0.98F)
					.clientTrackingRange(10)
					.updateInterval(20)
					.build(":cm_falling_block"));


	public static final RegistryObject<EntityType<MetatorberniteGrenadeProjectileEntity>> METATORBERNITE_GRENADE_PROJECTILE =
			ENTITY_TYPES.register("metatorbernite_grenade_projectile", () -> EntityType.Builder.<MetatorberniteGrenadeProjectileEntity>of(MetatorberniteGrenadeProjectileEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build("metatorbernite_grenade_projectile"));

	public static final RegistryObject<EntityType<MetaturboniteGrenadeProjectileEntity>> METATURBONITE_GRENADE_PROJECTILE =
			ENTITY_TYPES.register("metaturbonite_grenade_projectile", () -> EntityType.Builder.<MetaturboniteGrenadeProjectileEntity>of(MetaturboniteGrenadeProjectileEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build("metaturbonite_grenade_projectile"));




	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}
