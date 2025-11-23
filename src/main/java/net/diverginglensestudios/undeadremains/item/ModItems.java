/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.custom.Other.ModBoatEntity;
import net.diverginglensestudios.undeadremains.item.armor.ModArmorMaterials;
import net.diverginglensestudios.undeadremains.item.armor.ModSimpleArmorItem;
import net.diverginglensestudios.undeadremains.item.armor.custom.*;
import net.diverginglensestudios.undeadremains.item.custom.*;
import net.diverginglensestudios.undeadremains.sound.ModSounds;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        UndeadRemains.MOD_ID);
        // Normal Items
        public static final RegistryObject<Item> FOSSIL = ITEMS.register("fossil",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RARE_FOSSIL = ITEMS.register("rare_fossil",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_FOSSIL = ITEMS.register("raw_fossil",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_DEEPSLATE_FOSSIL = ITEMS.register("raw_deepslate_fossil",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE = ITEMS.register("metatorbernite",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SPIKE = ITEMS.register("spike",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> XANARIAN_SPINE = ITEMS.register("xanarian_spine",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> XANARIAN_HORN = ITEMS.register("xanarian_horn",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> XANARIAN_LEATHER = ITEMS.register("xanarian_leather",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_LANGRITE = ITEMS.register("raw_langrite",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> LANGRITE_INGOT = ITEMS.register("langrite_ingot",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> EMPTY_FUEL_CELL = ITEMS.register("empty_fuel_cell",
                        () -> new Item(new Item.Properties()));
        // Advanced Items
        public static final RegistryObject<Item> METATORBERNITE_GRENADE = ITEMS.register("metatorbernite_grenade",
                        () -> new MetatorberniteGrenadeItem(new Item.Properties()));

        // Food Items
        public static final RegistryObject<Item> THE_FOSSILS_EYE = ITEMS.register("the_fossils_eye",
                        () -> new Item(new Item.Properties().food(ModFoods.THE_FOSSILS_EYE)));
        public static final RegistryObject<Item> THE_QUARTZ_MODIFIED_FOSSILS_EYE = ITEMS.register(
                        "the_quartz_modified_fossils_eye",
                        () -> new Item(new Item.Properties().food(ModFoods.THE_QUARTZ_MODIFIED_FOSSILS_EYE)));
        public static final RegistryObject<Item> FOSSILIZED_DRUMSTICK = ITEMS.register("fossilized_drumstick",
                        () -> new ModFoodItem(new Item.Properties().food(ModFoods.FOSSILIZED_DRUMSTICK), 200));
        public static final RegistryObject<Item> GOLD_BLOCK_MODIFIED_FOSSILIZED_DRUMSTICK = ITEMS.register(
                        "gold_block_modified_fossilized_drumstick",
                        () -> new ModFoodItem(
                                        new Item.Properties().food(ModFoods.GOLD_BLOCK_MODIFIED_FOSSILIZED_DRUMSTICK),
                                        200));
        public static final RegistryObject<Item> RAW_XANARIAN_MEAT = ITEMS.register("raw_xanarian_meat",
                        () -> new Item(new Item.Properties().food(ModFoods.RAW_XANARIAN_MEAT)));

        public static final RegistryObject<Item> XANARIAN_MEAT = ITEMS.register("xanarian_meat",
                        () -> new Item(new Item.Properties().food(ModFoods.XANARIAN_MEAT)));

        public static final RegistryObject<Item> XANARIAN_SHISH_KEBAB = ITEMS.register("xanarian_shish_kebab",
                        () -> new Item(new Item.Properties().food(ModFoods.XANARIAN_SHISH_KEBAB)));

        public static final RegistryObject<Item> XANARIAN_KEBAB_WRAP = ITEMS.register("xanarian_kebab_wrap",
                        () -> new Item(new Item.Properties().food(ModFoods.XANARIAN_KEBAB_WRAP)));

        public static final RegistryObject<Item> XANARIAN_KEBAB = ITEMS.register("xanarian_kebab",
                        () -> new Item(new Item.Properties().food(ModFoods.XANARIAN_KEBAB)));

        public static final RegistryObject<Item> WRAP = ITEMS.register("wrap",
                        () -> new Item(new Item.Properties().food(ModFoods.WRAP)));

        // Fuel Items
        public static final RegistryObject<Item> METATURBONITE = ITEMS.register("metaturbonite",
                        () -> new FuelItem(new Item.Properties().rarity(Rarity.RARE), 25000));

        // Tools
        public static final RegistryObject<Item> FOSSIL_SWORD = ITEMS.register("fossil_sword",
                        () -> new SwordItem(ModToolTiers.FOSSIL, 4 - 1, 1 - 4, new Item.Properties()));
        public static final RegistryObject<Item> FOSSIL_PICKAXE = ITEMS.register("fossil_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.FOSSIL, (int) 3.5f - 1, 1.2f - 4, new Item.Properties()));
        public static final RegistryObject<Item> FOSSIL_AXE = ITEMS.register("fossil_axe",
                        () -> new AxeItem(ModToolTiers.FOSSIL, 9 - 1, 0.8f - 4, new Item.Properties()));
        public static final RegistryObject<Item> FOSSIL_SHOVEL = ITEMS.register("fossil_shovel",
                        () -> new ShovelItem(ModToolTiers.FOSSIL, 4 - 1, 1 - 4, new Item.Properties()));
        public static final RegistryObject<Item> FOSSIL_HOE = ITEMS.register("fossil_hoe",
                        () -> new HoeItem(ModToolTiers.FOSSIL, 1 - 1, 2.5f - 4, new Item.Properties()));

        public static final RegistryObject<Item> RARE_FOSSIL_SWORD = ITEMS.register("rare_fossil_sword",
                        () -> new SwordItem(ModToolTiers.RARE_FOSSIL, 5 - 1, 1.6f - 4, new Item.Properties()));
        public static final RegistryObject<Item> RARE_FOSSIL_PICKAXE = ITEMS.register("rare_fossil_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.RARE_FOSSIL, 6 - 1, 1 - 4, new Item.Properties()));
        public static final RegistryObject<Item> RARE_FOSSIL_AXE = ITEMS.register("rare_fossil_axe",
                        () -> new AxeItem(ModToolTiers.RARE_FOSSIL, 12 - 1, 0.8f - 4, new Item.Properties()));
        public static final RegistryObject<Item> RARE_FOSSIL_SHOVEL = ITEMS.register("rare_fossil_shovel",
                        () -> new ShovelItem(ModToolTiers.RARE_FOSSIL, 6 - 1, 1 - 4, new Item.Properties()));
        public static final RegistryObject<Item> RARE_FOSSIL_HOE = ITEMS.register("rare_fossil_hoe",
                        () -> new HoeItem(ModToolTiers.RARE_FOSSIL, (int) 1.5f - 1, 4 - 4, new Item.Properties()));

        public static final RegistryObject<Item> METATORBERNITE_SWORDAXE = ITEMS.register("metatorbernite_swordaxe",
                        () -> new SwordAxeItem(ModToolTiers.METATORBERNITE, 4, 2, BlockTags.MINEABLE_WITH_AXE,
                                        new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE_PICKAXE = ITEMS.register("metatorbernite_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.METATORBERNITE, 1 - 1, 1 - 4, new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE_SHOVEL = ITEMS.register("metatorbernite_shovel",
                        () -> new ShovelItem(ModToolTiers.METATORBERNITE, 0 - 1, 0 - 4, new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE_HOE = ITEMS.register("metatorbernite_hoe",
                        () -> new HoeItem(ModToolTiers.METATORBERNITE, 0 - 1, 0 - 4, new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE_TOOL = ITEMS.register("metatorbernite_tool",
                        () -> new MetatorberniteToolItem(ModToolTiers.METATORBERNITE, 1 - 1, 0 - 4,
                                        new Item.Properties()));

        public static final RegistryObject<Item> LANGRITE_SWORD = ITEMS.register("langrite_sword",
                        () -> new SwordItem(ModToolTiers.LANGRITE, 8 - 1, 2 - 4, new Item.Properties()));
        public static final RegistryObject<Item> LANGRITE_PICKAXE = ITEMS.register("langrite_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.LANGRITE, 6 - 1, 1.5f - 4, new Item.Properties()));
        public static final RegistryObject<Item> LANGRITE_AXE = ITEMS.register("langrite_axe",
                        () -> new AxeItem(ModToolTiers.LANGRITE, 10 - 1, 1.5f - 4, new Item.Properties()));
        public static final RegistryObject<Item> LANGRITE_SHOVEL = ITEMS.register("langrite_shovel",
                        () -> new ShovelItem(ModToolTiers.LANGRITE, (int) 6.5 - 1, 1 - 4, new Item.Properties()));
        public static final RegistryObject<Item> LANGRITE_HOE = ITEMS.register("langrite_hoe",
                        () -> new HoeItem(ModToolTiers.LANGRITE, 2 - 1, 5 - 4, new Item.Properties()));

        public static final RegistryObject<Item> HARVESTER = ITEMS.register("harvester",
                        () -> new SwordItem(ModToolTiers.LANGRITE, 20 - 1, 0.35f - 4,
                                        new Item.Properties().rarity(Rarity.RARE)));

        public static final RegistryObject<Item> SPIKE_BAT = ITEMS.register("spike_bat",
                        () -> new SwordItem(ModToolTiers.SPIKE, 4 - 1, 1 - 4, new Item.Properties()));

        public static final RegistryObject<Item> AMETHYST_MODIFIED_FOSSIL_SWORD = ITEMS.register(
                        "amethyst_modified_fossil_sword",
                        () -> new AmethystFossilSwordItem(ModToolTiers.FOSSIL, 5 - 1, 1.3f - 4,
                                        new Item.Properties().stacksTo(1)));
        public static final RegistryObject<Item> BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE = ITEMS.register(
                        "blaze_rod_modified_fossil_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.BLAZE_ROD_MODIFIED_FOSSIL, 4 - 1, 1.2f - 4,
                                        new Item.Properties()));
        public static final RegistryObject<Item> RABBIT_FOOT_MODIFIED_FOSSIL_AXE = ITEMS.register(
                        "rabbit_foot_modified_fossil_axe",
                        () -> new ModifiedFossilAxeItem(ModToolTiers.RABBIT_FOOT_MODIFIED_FOSSIL, 9 - 1, 1 - 4,
                                        new Item.Properties()));
        public static final RegistryObject<Item> NAUTILUS_SHELL_MODIFIED_FOSSIL_SHOVEL = ITEMS.register(
                        "nautilus_shell_modified_fossil_shovel",
                        () -> new ModifiedFossilShovel(ModToolTiers.NAUTILUS_SHELL_MODIFIED_FOSSIL, 4 - 1, 1 - 4,
                                        new Item.Properties()));
        public static final RegistryObject<Item> SLIME_BALL_MODIFIED_FOSSIL_HOE = ITEMS.register(
                        "slime_ball_modified_fossil_hoe",
                        () -> new FossilHoeItem(ModToolTiers.SLIME_BALL_MODIFIED_FOSSIL, new Item.Properties()));
        // ArmorFossilHoeItem
        // Fossil
        public static final RegistryObject<Item> FOSSIL_HELMET = ITEMS.register("fossil_helmet",
                        () -> new ModSimpleArmorItem(ModArmorMaterials.FOSSIL, ArmorItem.Type.HELMET,
                                        new Item.Properties()));
        public static final RegistryObject<Item> FOSSIL_CHESTPLATE = ITEMS.register("fossil_chestplate",
                        () -> new ArmorItem(ModArmorMaterials.FOSSIL, ArmorItem.Type.CHESTPLATE,
                                        new Item.Properties()));
        public static final RegistryObject<Item> FOSSIL_LEGGINGS = ITEMS.register("fossil_leggings",
                        () -> new ArmorItem(ModArmorMaterials.FOSSIL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> FOSSIL_BOOTS = ITEMS.register("fossil_boots",
                        () -> new ArmorItem(ModArmorMaterials.FOSSIL, ArmorItem.Type.BOOTS, new Item.Properties()));
        // RARE_FOSSIL
        public static final RegistryObject<Item> RARE_FOSSIL_HELMET = ITEMS.register("rare_fossil_helmet",
                        () -> new RareFossilArmorItem(ArmorItem.Type.HELMET));
        public static final RegistryObject<Item> RARE_FOSSIL_CHESTPLATE = ITEMS.register("rare_fossil_chestplate",
                        () -> new RareFossilArmorItem(ArmorItem.Type.CHESTPLATE));
        public static final RegistryObject<Item> RARE_FOSSIL_LEGGINGS = ITEMS.register("rare_fossil_leggings",
                        () -> new RareFossilArmorItem(ArmorItem.Type.LEGGINGS));
        public static final RegistryObject<Item> RARE_FOSSIL_BOOTS = ITEMS.register("rare_fossil_boots",
                        () -> new RareFossilArmorItem(ArmorItem.Type.BOOTS));
        // LANGRITE
        public static final RegistryObject<Item> LANGRITE_HELMET = ITEMS.register("langrite_helmet",
                        () -> new LangriteArmorItem(ArmorItem.Type.HELMET));
        public static final RegistryObject<Item> LANGRITE_CHESTPLATE = ITEMS.register("langrite_chestplate",
                        () -> new LangriteArmorItem(ArmorItem.Type.CHESTPLATE));
        public static final RegistryObject<Item> LANGRITE_LEGGINGS = ITEMS.register("langrite_leggings",
                        () -> new LangriteArmorItem(ArmorItem.Type.LEGGINGS));
        public static final RegistryObject<Item> LANGRITE_BOOTS = ITEMS.register("langrite_boots",
                        () -> new LangriteArmorItem(ArmorItem.Type.BOOTS));
        // METATORBERNITE
        public static final RegistryObject<Item> METATORBERNITE_HELMET = ITEMS.register("metatorbernite_helmet",
                        () -> new ModSimpleArmorItem(ModArmorMaterials.METATORBERNITE, ArmorItem.Type.HELMET,
                                        new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE_CHESTPLATE = ITEMS.register("metatorbernite_chestplate",
                        () -> new ArmorItem(ModArmorMaterials.METATORBERNITE, ArmorItem.Type.CHESTPLATE,
                                        new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE_LEGGINGS = ITEMS.register("metatorbernite_leggings",
                        () -> new ArmorItem(ModArmorMaterials.METATORBERNITE, ArmorItem.Type.LEGGINGS,
                                        new Item.Properties()));
        public static final RegistryObject<Item> METATORBERNITE_BOOTS = ITEMS.register("metatorbernite_boots",
                        () -> new ArmorItem(ModArmorMaterials.METATORBERNITE, ArmorItem.Type.BOOTS,
                                        new Item.Properties()));
        // GasMask
        public static final RegistryObject<Item> GAS_MASK = ITEMS.register("gas_mask",
                        () -> new GasMaskItem(ArmorItem.Type.HELMET));
        public static final RegistryObject<Item> METATORBERNITE_GAS_MASK = ITEMS.register("metatorbernite_gas_mask",
                        () -> new MetatorberniteGasMaskItem(ArmorItem.Type.HELMET));
        // Sunglasses
        public static final RegistryObject<Item> SUNGLASSES = ITEMS.register("sunglasses",
                        () -> new ArmorItem(ModArmorMaterials.SUNGLASSES, ArmorItem.Type.HELMET,
                                        new Item.Properties()));

        // Xanarian_Spine_Chestplate
        public static final RegistryObject<Item> XANARIAN_SPINE_CHESTPLATE = ITEMS.register("xanarian_spine_chestplate",
                        () -> new ArmorItem(ModArmorMaterials.XANARIAN, ArmorItem.Type.CHESTPLATE,
                                        new Item.Properties()));

        // Cow_Zombie_Armor
        public static final RegistryObject<Item> COW_HELMET = ITEMS.register("cow_helmet",
                        () -> new CowArmorItem(ArmorItem.Type.HELMET));
        public static final RegistryObject<Item> COW_CHESTPLATE = ITEMS.register("cow_chestplate",
                        () -> new CowArmorItem(ArmorItem.Type.CHESTPLATE));
        public static final RegistryObject<Item> COW_LEGGINGS = ITEMS.register("cow_leggings",
                        () -> new CowArmorItem(ArmorItem.Type.LEGGINGS));
        public static final RegistryObject<Item> COW_BOOTS = ITEMS.register("cow_boots",
                        () -> new CowArmorItem(ArmorItem.Type.BOOTS));
        // Modified fossil

        public static final RegistryObject<Item> LIGHTNING_ROD_MODIFIED_FOSSIL_HELMET = ITEMS.register(
                        "lightning_rod_modified_fossil_helmet",
                        () -> new LightningRodModifiedFossilHelmetItem(ArmorItem.Type.HELMET));
        public static final RegistryObject<Item> CLOCK_MODIFIED_FOSSIL_CHESTPLATE = ITEMS.register(
                        "clock_modified_fossil_chestplate",
                        () -> new ModSimpleArmorItem(ModArmorMaterials.CLOCK_MODIFIED_FOSSIL, ArmorItem.Type.CHESTPLATE,
                                        new Item.Properties()));
        public static final RegistryObject<Item> SCUTE_MODIFIED_FOSSIL_LEGGINGS = ITEMS.register(
                        "scute_modified_fossil_leggings",
                        () -> new ModSimpleArmorItem(ModArmorMaterials.SCUTE_MODIFIED_FOSSIL, ArmorItem.Type.LEGGINGS,
                                        new Item.Properties()));
        public static final RegistryObject<Item> SCULK_SHARD_MODIFIED_FOSSIL_BOOTS = ITEMS.register(
                        "sculk_shard_modified_fossil_boots",
                        () -> new ModSimpleArmorItem(ModArmorMaterials.SCULK_SHARD_MODIFIED_FOSSIL,
                                        ArmorItem.Type.BOOTS, new Item.Properties()));

        // Saplings
        public static final RegistryObject<Item> ASH_SAPLING_ITEM = ITEMS.register("ash_sapling",
                        () -> new BlockItem(ModBlocks.ASH_SAPLING.get(), new Item.Properties()));

        public static final RegistryObject<Item> CALIPO_SAPLING_ITEM = ITEMS.register("calipo_sapling",
                        () -> new BlockItem(ModBlocks.CALIPO_SAPLING.get(), new Item.Properties()));

        public static final RegistryObject<Item> CREEPER_SAPLING_ITEM = ITEMS.register("creeper_sapling",
                        () -> new BlockItem(ModBlocks.CREEPER_SAPLING.get(), new Item.Properties()));

        // Music
        public static final RegistryObject<Item> UNDYING_WHISPERS_MUSIC_DISC = ITEMS.register(
                        "undying_whispers_music_disc",
                        () -> new RecordItem(6, ModSounds.UNDYING_WHISPERS, new Item.Properties().stacksTo(1), 2440));

        // Spawn Eggs
        public static final RegistryObject<Item> UNDEADARCHEOLOGIST_SPAWN_EGG = ITEMS.register(
                        "undeadarcheologist_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.UNDEAD_ARCHEOLOGIST, 0x6B5B44, 0xA0A48B,
                                        new Item.Properties()));

        public static final RegistryObject<Item> FOSSILIZED_ZOMBIE_SPAWN_EGG = ITEMS.register(
                        "fossilized_zombie_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.FOSSILIZED_ZOMBIE, 0x5A4A3A, 0x8A7D66,
                                        new Item.Properties()));

        public static final RegistryObject<Item> TREE_ZOMBIE_SPAWN_EGG = ITEMS.register("tree_zombie_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.TREE_ZOMBIE, 0x090F1B, 0x517138,
                                        new Item.Properties()));

        public static final RegistryObject<Item> SUPREME_ZOMBIE_SPAWN_EGG = ITEMS.register("supreme_zombie_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.SUPREME_ZOMBIE, 0x9BB6C2, 0x8F7BA4,
                                        new Item.Properties()));

        public static final RegistryObject<Item> COW_ZOMBIE_SPAWN_EGG = ITEMS.register("cow_zombie_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.COW_ZOMBIE, 0x443626, 0xA1A1A1, new Item.Properties()));

        public static final RegistryObject<Item> SPIKE_SPAWN_EGG = ITEMS.register("spike_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.SPIKE, 0x5e5847, 0xc9b198, new Item.Properties()));

        public static final RegistryObject<Item> HAMMER_ZOMBIE_SPAWN_EGG = ITEMS.register("hammer_zombie_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.HAMMER_ZOMBIE, 0x382e33, 0x417536,
                                        new Item.Properties()));

        public static final RegistryObject<Item> FOUR_EYED_XANARIAN_SPAWN_EGG = ITEMS.register(
                        "four_eyed_xanarian_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.FOUR_EYED_XANARIAN, 0xce141e, 0x717212,
                                        new Item.Properties()));

        public static final RegistryObject<Item> XANARIAN_SPAWN_EGG = ITEMS.register("xanarian_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.XANARIAN, 0xce141e, 0x717212, new Item.Properties()));

        public static final RegistryObject<Item> HORNED_XANARIAN_SPAWN_EGG = ITEMS.register("horned_xanarian_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.HORNED_XANARIAN, 0xce141e, 0x717212,
                                        new Item.Properties()));

        public static final RegistryObject<Item> SUPREME_KNIGHT_SPAWN_EGG = ITEMS.register("supreme_knight_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.SAHN_UZAL, 0x47488B, 0x7961AB, new Item.Properties()));

        public static final RegistryObject<Item> BIG_WOODLING_SPAWN_EGG = ITEMS.register("big_woodling_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.BIG_WOODLING, 0x090F1B, 0x517138,
                                        new Item.Properties()));

        public static final RegistryObject<Item> SMALL_WOODLING_SPAWN_EGG = ITEMS.register("small_woodling_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.SMALL_WOODLING, 0x090F1B, 0x517138,
                                        new Item.Properties()));

        public static final RegistryObject<Item> STRAY_ZOMBIE_SPAWN_EGG = ITEMS.register("stray_zombie_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.STRAY_ZOMBIE, 0x394061, 0x394061,
                                        new Item.Properties()));

        public static final RegistryObject<Item> XANARIAN_CANNIBAL_SPAWN_EGG = ITEMS.register(
                        "xanarian_cannibal_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntities.XANARIAN_CANNIBAL, 0x394061, 0x394061,
                                        new Item.Properties()));

        // Signs
        public static final RegistryObject<Item> ASH_SIGN = ITEMS.register("ash_sign",
                        () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.ASH_SIGN.get(),
                                        ModBlocks.ASH_WALL_SIGN.get()));
        public static final RegistryObject<Item> ASH_HANGING_SIGN = ITEMS.register("ash_hanging_sign",
                        () -> new HangingSignItem(ModBlocks.ASH_HANGING_SIGN.get(),
                                        ModBlocks.ASH_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
        public static final RegistryObject<Item> CALIPO_SIGN = ITEMS.register("calipo_sign",
                        () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.CALIPO_SIGN.get(),
                                        ModBlocks.CALIPO_WALL_SIGN.get()));
        public static final RegistryObject<Item> CALIPO_HANGING_SIGN = ITEMS.register("calipo_hanging_sign",
                        () -> new HangingSignItem(ModBlocks.CALIPO_HANGING_SIGN.get(),
                                        ModBlocks.CALIPO_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

        // Boats
        public static final RegistryObject<Item> ASH_BOAT = ITEMS.register("ash_boat",
                        () -> new ModBoatItem(false, ModBoatEntity.Type.ASH, new Item.Properties()));
        public static final RegistryObject<Item> ASH_CHEST_BOAT = ITEMS.register("ash_chest_boat",
                        () -> new ModBoatItem(true, ModBoatEntity.Type.ASH, new Item.Properties()));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
