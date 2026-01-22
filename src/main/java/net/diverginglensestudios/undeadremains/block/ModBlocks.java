/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.custom.*;
import net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher.MetatorberniteEnricherController;
import net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher.MetatorberniteEnricherPart;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.util.ModWoodTypes;
import net.diverginglensestudios.undeadremains.worldgen.tree.*;
import net.minecraft.client.resources.model.Material;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
//test
public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        UndeadRemains.MOD_ID);

        ////////////////////BLOCKS////////////////////
        // Normal Blocks
        public static final RegistryObject<Block> FOSSIL_BLOCK = registerBlock("fossil_block",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BONE_BLOCK)));

        public static final RegistryObject<Block> RAW_FOSSIL_BLOCK = registerBlock("raw_fossil_block",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BONE_BLOCK)));

        public static final RegistryObject<Block> METATORBERNITE_BLOCK = registerBlock("metatorbernite_block",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));

        public static final RegistryObject<Block> LANGRITE_BLOCK = registerBlock("langrite_block",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.STONE)));

        public static final RegistryObject<Block> RAW_LANGRITE_BLOCK = registerBlock("raw_langrite_block",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.STONE)));

        public static final RegistryObject<Block> LANGRITE_ORE = registerBlock("langrite_ore",
                        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                                        .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

        public static final RegistryObject<Block> LANGSTONE = registerBlock("langstone",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
        public static final RegistryObject<Block> CHISELED_LANGSTONE = registerBlock("chiseled_langstone",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
        public static final RegistryObject<Block> POLISHED_LANGSTONE = registerBlock("polished_langstone",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
        public static final RegistryObject<Block> LANGSTONE_BRICKS = registerBlock("langstone_bricks",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
        public static final RegistryObject<Block> CRACKED_LANGSTONE_BRICKS = registerBlock("cracked_langstone_bricks",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
        public static final RegistryObject<Block> POLISHED_DEEP_LANGSTONE = registerBlock("polished_deep_langstone",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
        public static final RegistryObject<Block> SUPREME_BRICKS = registerBlock("supreme_bricks",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.REINFORCED_DEEPSLATE)
                                        .sound(SoundType.STONE)));
        public static final RegistryObject<Block> CHISELED_SUPREME_BRICKS = registerBlock("chiseled_supreme_bricks",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.REINFORCED_DEEPSLATE)
                                        .sound(SoundType.STONE)));
        public static final RegistryObject<Block> SUPREME_TILES = registerBlock("supreme_tiles",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.REINFORCED_DEEPSLATE)
                                        .sound(SoundType.STONE)));

        public static final RegistryObject<Block> LANGSTONE_PILAR = registerBlock("langstone_pilar",
                        () -> new RotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));
        public static final RegistryObject<Block> SUPREME_PILAR = registerBlock("supreme_pilar",
                        () -> new RotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(SoundType.STONE)));

        public static final RegistryObject<Block> DEEP_LANGSTONE = registerBlock("deep_langstone",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)
                                        .sound(SoundType.STONE)));

        public static final RegistryObject<Block> DEEP_LANGSTONE_BRICKS = registerBlock("deep_langstone_bricks",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)
                                        .sound(SoundType.STONE)));

        public static final RegistryObject<Block> CRACKED_DEEP_LANGSTONE_BRICKS = registerBlock(
                        "cracked_deep_langstone_bricks",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)
                                        .sound(SoundType.STONE)));

        public static final RegistryObject<Block> CHISELED_DEEP_LANGSTONE = registerBlock("chiseled_deep_langstone",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)
                                        .sound(SoundType.STONE)));

        public static final RegistryObject<Block> LIVING_LANGSTONE = registerBlock("living_langstone",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.GRASS)));

        public static final RegistryObject<Block> FOSSIL_ORE = registerBlock("fossil_ore",
                        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                                        .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

        public static final RegistryObject<Block> DEEPSLATE_FOSSIL_ORE = registerBlock("deepslate_fossil_ore",
                        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                                        .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

        public static final RegistryObject<Block> METATORBERNITE_ORE = registerBlock("metatorbernite_ore",
                        () -> new MetatorberniteOreBlock(
                                        BlockBehaviour.Properties.copy(Blocks.COAL_ORE).sound(SoundType.STONE)));

        // Advanced Blocks

        public static final RegistryObject<Block> FOSSIL_POLISHER = registerBlock("fossil_polisher",
                        () -> new FossilPolishingStationBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> FOSSIL_ALTAR = registerBlock("fossil_altar",
                        () -> new FossilAltarBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noLootTable()));

        public static final RegistryObject<Block> FOSSIL_LUCKY_BLOCK = registerBlock("fossil_lucky_block",
                        () -> new FossilLuckyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BONE_BLOCK)));

        public static final RegistryObject<Block> METATORBERNITE_LUCKY_BLOCK = registerBlock(
                        "metatorbernite_lucky_block",
                        () -> new MetatorberniteLuckyBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

        // Differenty shaped blocks
        // Fossil
        public static final RegistryObject<Block> FOSSIL_STAIRS = registerBlock("fossil_stairs",
                        () -> new StairBlock(() -> ModBlocks.FOSSIL_BLOCK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BONE_BLOCK)));
        public static final RegistryObject<Block> FOSSIL_SLAB = registerBlock("fossil_slab",
                        () -> new SlabBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BONE_BLOCK)));
        public static final RegistryObject<Block> FOSSIL_BUTTON = registerBlock("fossil_button",
                        () -> new ButtonBlock(
                                        BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.BONE_BLOCK),
                                        BlockSetType.IRON, 10, true));
        public static final RegistryObject<Block> FOSSIL_PRESSURE_PLATE = registerBlock("fossil_pressure_plate",
                        () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                                        BlockSetType.IRON));
        public static final RegistryObject<Block> FOSSIL_FENCE = registerBlock("fossil_fence",
                        () -> new FenceBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
        public static final RegistryObject<Block> FOSSIL_FENCE_GATE = registerBlock("fossil_fence_gate",
                        () -> new FenceGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                                        SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
        public static final RegistryObject<Block> FOSSIL_WALL = registerBlock("fossil_wall",
                        () -> new WallBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
        public static final RegistryObject<Block> FOSSIL_DOOR = registerBlock("fossil_door",
                        () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)
                                        .noOcclusion(), BlockSetType.IRON));
        public static final RegistryObject<Block> FOSSIL_TRAPDOOR = registerBlock("fossil_trapdoor",
                        () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                                        .sound(SoundType.AMETHYST).noOcclusion(), BlockSetType.IRON));

        // langstone
        public static final RegistryObject<Block> LANGSTONE_STAIRS = registerBlock("langstone_stairs",
                        () -> new StairBlock(() -> ModBlocks.LANGSTONE.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
        public static final RegistryObject<Block> LANGSTONE_SLAB = registerBlock("langstone_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
        public static final RegistryObject<Block> LANGSTONE_WALL = registerBlock("langstone_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

        // deep_langstone
        public static final RegistryObject<Block> DEEP_LANGSTONE_STAIRS = registerBlock("deep_langstone_stairs",
                        () -> new StairBlock(() -> ModBlocks.LANGSTONE.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
        public static final RegistryObject<Block> DEEP_LANGSTONE_SLAB = registerBlock("deep_langstone_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
        public static final RegistryObject<Block> DEEP_LANGSTONE_WALL = registerBlock("deep_langstone_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));

        // polished_deep_langstone
        public static final RegistryObject<Block> POLISHED_DEEP_LANGSTONE_STAIRS = registerBlock(
                        "polished_deep_langstone_stairs",
                        () -> new StairBlock(() -> ModBlocks.LANGSTONE.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
        public static final RegistryObject<Block> POLISHED_DEEP_LANGSTONE_SLAB = registerBlock(
                        "polished_deep_langstone_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
        public static final RegistryObject<Block> POLISHED_DEEP_LANGSTONE_WALL = registerBlock(
                        "polished_deep_langstone_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));

        // deep_langstone_bricks
        public static final RegistryObject<Block> DEEP_LANGSTONE_BRICK_STAIRS = registerBlock(
                        "deep_langstone_brick_stairs",
                        () -> new StairBlock(() -> ModBlocks.LANGSTONE.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
        public static final RegistryObject<Block> DEEP_LANGSTONE_BRICK_SLAB = registerBlock("deep_langstone_brick_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
        public static final RegistryObject<Block> DEEP_LANGSTONE_BRICK_WALL = registerBlock("deep_langstone_brick_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));

        // polished_langstone
        public static final RegistryObject<Block> POLISHED_LANGSTONE_STAIRS = registerBlock("polished_langstone_stairs",
                        () -> new StairBlock(() -> ModBlocks.POLISHED_LANGSTONE.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
        public static final RegistryObject<Block> POLISHED_LANGSTONE_SLAB = registerBlock("polished_langstone_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
        public static final RegistryObject<Block> POLISHED_LANGSTONE_WALL = registerBlock("polished_langstone_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

        // langstone_brick
        public static final RegistryObject<Block> LANGSTONE_BRICK_STAIRS = registerBlock("langstone_brick_stairs",
                        () -> new StairBlock(() -> ModBlocks.LANGSTONE_BRICKS.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
        public static final RegistryObject<Block> LANGSTONE_BRICK_SLAB = registerBlock("langstone_brick_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
        public static final RegistryObject<Block> LANGSTONE_BRICK_WALL = registerBlock("langstone_brick_wall",
                        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

        // Wood
        public static final RegistryObject<Block> ASH_LOG = registerBlock("ash_log",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

        public static final RegistryObject<Block> ASH_WOOD = registerBlock("ash_wood",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));

        public static final RegistryObject<Block> STRIPPED_ASH_LOG = registerBlock("stripped_ash_log",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));

        public static final RegistryObject<Block> STRIPPED_ASH_WOOD = registerBlock("stripped_ash_wood",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

        public static final RegistryObject<Block> ASH_PLANKS = registerBlock("ash_planks",
                        () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));

        public static final RegistryObject<Block> ASH_LEAVES = registerBlock("ash_leaves",
                        () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), 60, 30));

        public static final RegistryObject<Block> CALIPO_LOG = registerBlock("calipo_log",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.MANGROVE_LOG).strength(3f)));

        public static final RegistryObject<Block> CALIPO_WOOD = registerBlock("calipo_wood",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.MANGROVE_WOOD).strength(3f)));

        public static final RegistryObject<Block> STRIPPED_CALIPO_LOG = registerBlock("stripped_calipo_log",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.STRIPPED_MANGROVE_LOG).strength(3f)));

        public static final RegistryObject<Block> STRIPPED_CALIPO_WOOD = registerBlock("stripped_calipo_wood",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.STRIPPED_MANGROVE_WOOD).strength(3f)));

        public static final RegistryObject<Block> CALIPO_PLANKS = registerBlock("calipo_planks",
                        () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS), 20, 5));

        public static final RegistryObject<Block> CALIPO_LEAVES = registerBlock("calipo_leaves",
                        () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_LEAVES), 60, 30));

        // Differently Shaped Wood
        // Calipo
        public static final RegistryObject<Block> CALIPO_SIGN = BLOCKS.register("calipo_sign",
                        () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN),
                                        ModWoodTypes.CALIPO));

        public static final RegistryObject<Block> CALIPO_WALL_SIGN = BLOCKS.register("calipo_wall_sign",
                        () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN),
                                        ModWoodTypes.CALIPO));

        public static final RegistryObject<Block> CALIPO_HANGING_SIGN = BLOCKS.register("calipo_hanging_sign",
                        () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN),
                                        ModWoodTypes.CALIPO));

        public static final RegistryObject<Block> CALIPO_WALL_HANGING_SIGN = BLOCKS.register("calipo_wall_hanging_sign",
                        () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN),
                                        ModWoodTypes.CALIPO));

        public static final RegistryObject<Block> CALIPO_STAIRS = registerBlock("calipo_stairs",
                        () -> new ModFlammableStairBlock(() -> ModBlocks.CALIPO_PLANKS.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD), 20,
                                        5));

        public static final RegistryObject<Block> CALIPO_SLAB = registerBlock("calipo_slab",
                        () -> new ModFlammableSlabBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD), 20, 5));

        public static final RegistryObject<Block> CALIPO_BUTTON = registerBlock("calipo_button",
                        () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                                        BlockSetType.OAK, 10, true));

        public static final RegistryObject<Block> CALIPO_PRESSURE_PLATE = registerBlock("calipo_pressure_plate",
                        () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                                        BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)
                                                        .sound(SoundType.WOOD),
                                        BlockSetType.OAK));

        public static final RegistryObject<Block> CALIPO_FENCE = registerBlock("calipo_fence",
                        () -> new ModFlammableFenceBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD), 20, 5));

        public static final RegistryObject<Block> CALIPO_FENCE_GATE = registerBlock("calipo_fence_gate",
                        () -> new ModFlammableFenceGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD),
                                        SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE, 20, 5));

        public static final RegistryObject<Block> CALIPO_DOOR = registerBlock("calipo_door",
                        () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD)
                                        .noOcclusion(), BlockSetType.OAK));

        public static final RegistryObject<Block> CALIPO_TRAPDOOR = registerBlock("calipo_trapdoor",
                        () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)
                                        .sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

        // Ash
        public static final RegistryObject<Block> ASH_SIGN = BLOCKS.register("ash_sign",
                        () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN),
                                        ModWoodTypes.ASH));

        public static final RegistryObject<Block> ASH_WALL_SIGN = BLOCKS.register("ash_wall_sign",
                        () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN),
                                        ModWoodTypes.ASH));

        public static final RegistryObject<Block> ASH_HANGING_SIGN = BLOCKS.register("ash_hanging_sign",
                        () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN),
                                        ModWoodTypes.ASH));

        public static final RegistryObject<Block> ASH_WALL_HANGING_SIGN = BLOCKS.register("ash_wall_hanging_sign",
                        () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN),
                                        ModWoodTypes.ASH));

        public static final RegistryObject<Block> ASH_STAIRS = registerBlock("ash_stairs",
                        () -> new ModFlammableStairBlock(() -> ModBlocks.ASH_PLANKS.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD), 20,
                                        5));

        public static final RegistryObject<Block> ASH_SLAB = registerBlock("ash_slab",
                        () -> new ModFlammableSlabBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD), 20, 5));

        public static final RegistryObject<Block> ASH_BUTTON = registerBlock("ash_button",
                        () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                                        BlockSetType.OAK, 10, true));

        public static final RegistryObject<Block> ASH_PRESSURE_PLATE = registerBlock("ash_pressure_plate",
                        () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                                        BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)
                                                        .sound(SoundType.WOOD),
                                        BlockSetType.OAK));

        public static final RegistryObject<Block> ASH_FENCE = registerBlock("ash_fence",
                        () -> new ModFlammableFenceBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD), 20, 5));

        public static final RegistryObject<Block> ASH_FENCE_GATE = registerBlock("ash_fence_gate",
                        () -> new ModFlammableFenceGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD),
                                        SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE, 20, 5));

        public static final RegistryObject<Block> ASH_DOOR = registerBlock("ash_door",
                        () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD)
                                        .noOcclusion(), BlockSetType.OAK));

        public static final RegistryObject<Block> ASH_TRAPDOOR = registerBlock("ash_trapdoor",
                        () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)
                                        .sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

        // Crops
        public static final RegistryObject<Block> CALIPO_BERRY_VINE = registerBlock("calipo_berry_vine",
                        () -> new CalipoBerryVineBlock(BlockBehaviour.Properties.copy(Blocks.CAVE_VINES)));

        public static final RegistryObject<Block> XANS_LEAVES = registerBlock("xans_leaves",
                        () -> new XansLeavesBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                                        .sound(SoundType.CROP).noOcclusion().noCollission()));



        // Plants
        public static final RegistryObject<Block> XANAS_FLOWER = registerBlock("xanas_flower",
                        () -> new ModFlowerBlock(MobEffects.SLOW_FALLING, 200,"supports_xanarian_foliage", BlockBehaviour.Properties.copy(Blocks.ALLIUM)));

        public static final RegistryObject<Block> POTTED_XANAS_FLOWER = BLOCKS.register("potted_xanas_flower",
                () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.XANAS_FLOWER,
                        BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

        public static final RegistryObject<Block> ROXA_FLOWER = registerBlock("roxa_flower",
                () -> new ModFlowerBlock(MobEffects.SLOW_FALLING, 200,"supports_xanarian_foliage", BlockBehaviour.Properties.copy(Blocks.ALLIUM)));

        public static final RegistryObject<Block> POTTED_ROXA_FLOWER = BLOCKS.register("potted_roxa_flower",
                () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ROXA_FLOWER,
                        BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

        public static final RegistryObject<Block> XELKS_FLOWER = registerBlock("xelks_flower",
                () -> new ModFlowerBlock(MobEffects.SLOW_FALLING, 200,"supports_xanarian_foliage", BlockBehaviour.Properties.copy(Blocks.ALLIUM)));

        public static final RegistryObject<Block> POTTED_XELKS_FLOWER = BLOCKS.register("potted_xelks_flower",
                () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.XELKS_FLOWER,
                        BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

        public static final RegistryObject<Block> LYXOR_FLOWER = registerBlock("lyxor_flower",
                () -> new ModFlowerBlock(MobEffects.SLOW_FALLING, 200,"supports_xanarian_foliage", BlockBehaviour.Properties.copy(Blocks.ALLIUM).lightLevel((state) -> 2)));

        public static final RegistryObject<Block> CALIPO_GRASS = registerBlock("calipo_grass",
                () -> new ModFlowerBlock(MobEffects.SLOW_FALLING, 200,"supports_xanarian_foliage", BlockBehaviour.Properties.copy(Blocks.GRASS)));
        // Saplings
        public static final RegistryObject<Block> ASH_SAPLING = BLOCKS.register("ash_sapling",
                        () -> new SaplingBlock(new AshTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                                        .noOcclusion().noCollission()));

        public static final RegistryObject<Block> CALIPO_SAPLING = BLOCKS.register("calipo_sapling",
                        () -> new ModSaplingBlock(new CalipoTreeGrower(),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion().noCollission(),
                                        ModBlocks.LIVING_LANGSTONE, false));

public static final RegistryObject<Block> METATORBERNITE_ENRICHER_CONTROLLER = BLOCKS.register(
    "metatorbernite_enricher_controller",
    () -> new MetatorberniteEnricherController(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK))
);

public static final RegistryObject<Block> METATORBERNITE_ENRICHER_PART = BLOCKS.register(
    "metatorbernite_enricher_part",
    () -> new MetatorberniteEnricherPart(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion())
);
        ////////////////////BLOCKS////////////////////

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
                RegistryObject<T> toReturn = BLOCKS.register(name, block);
                registerBlockItem(name, toReturn);
                return toReturn;
        }

        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
                return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}
