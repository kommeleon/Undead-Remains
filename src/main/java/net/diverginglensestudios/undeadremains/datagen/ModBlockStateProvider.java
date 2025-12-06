/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.datagen;

import java.util.function.Function;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.block.custom.CalipoBerryVineBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UndeadRemains.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //BlockWithItem
        blockWithItem(ModBlocks.FOSSIL_BLOCK);
        blockWithItem(ModBlocks.LANGSTONE_BRICKS);
        blockWithItem(ModBlocks.LANGSTONE);
        blockWithItem(ModBlocks.POLISHED_LANGSTONE);
        blockWithItem(ModBlocks.CHISELED_LANGSTONE);
        blockWithItem(ModBlocks.CRACKED_LANGSTONE_BRICKS);
        blockWithItem(ModBlocks.DEEP_LANGSTONE);
        blockWithItem(ModBlocks.DEEP_LANGSTONE_BRICKS);
        blockWithItem(ModBlocks.POLISHED_DEEP_LANGSTONE);
        blockWithItem(ModBlocks.CRACKED_DEEP_LANGSTONE_BRICKS);
        blockWithItem(ModBlocks.CHISELED_DEEP_LANGSTONE);
        blockWithItem(ModBlocks.RAW_FOSSIL_BLOCK);
        blockWithItem(ModBlocks.FOSSIL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_FOSSIL_ORE);
        blockWithItem(ModBlocks.LANGRITE_BLOCK);
        blockWithItem(ModBlocks.RAW_LANGRITE_BLOCK);
        blockWithItem(ModBlocks.LANGRITE_ORE);
        blockWithItem(ModBlocks.ASH_PLANKS);
        blockWithItem(ModBlocks.CALIPO_PLANKS);
        blockWithItem(ModBlocks.FOSSIL_LUCKY_BLOCK);
        blockWithItem(ModBlocks.METATORBERNITE_LUCKY_BLOCK);
        blockWithItem(ModBlocks.METATORBERNITE_ORE);
        blockWithItem(ModBlocks.METATORBERNITE_BLOCK);
        blockWithItem(ModBlocks.SUPREME_BRICKS);
        blockWithItem(ModBlocks.SUPREME_TILES);
        blockWithItem(ModBlocks.CHISELED_SUPREME_BRICKS);

        //BlockItem
        blockItem(ModBlocks.LIVING_LANGSTONE);

        //Saplings
        saplingBlock(ModBlocks.ASH_SAPLING);
        saplingBlock(ModBlocks.CALIPO_SAPLING);
        saplingBlock(ModBlocks.CREEPER_SAPLING);

        glowVineBlock(ModBlocks.CALIPO_BERRY_VINE);


       simpleBlockWithItem(ModBlocks.FOSSIL_POLISHER.get(),
       new ModelFile.UncheckedModelFile(modLoc("block/fossil_polisher")));

       simpleBlockWithItem(ModBlocks.FOSSIL_ALTAR.get(),
       new ModelFile.UncheckedModelFile(modLoc("block/fossil_altar")));

simpleBlock(ModBlocks.LIVING_LANGSTONE.get(), models().cubeBottomTop(
        "living_langstone",
        modLoc("block/living_langstone_side"),
        modLoc("block/langstone"),
        modLoc("block/living_langstone_top")
));


        logBlock(((RotatedPillarBlock) ModBlocks.ASH_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.LANGSTONE_PILAR.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.SUPREME_PILAR.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.CALIPO_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.ASH_WOOD.get()), blockTexture(ModBlocks.ASH_LOG.get()), blockTexture(ModBlocks.ASH_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.CALIPO_WOOD.get()), blockTexture(ModBlocks.CALIPO_LOG.get()), blockTexture(ModBlocks.CALIPO_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ASH_LOG.get()), blockTexture(ModBlocks.STRIPPED_ASH_LOG.get()),
                new ResourceLocation(UndeadRemains.MOD_ID, "block/stripped_ash_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CALIPO_LOG.get()), blockTexture(ModBlocks.STRIPPED_CALIPO_LOG.get()),
                new ResourceLocation(UndeadRemains.MOD_ID, "block/stripped_calipo_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ASH_WOOD.get()), blockTexture(ModBlocks.STRIPPED_ASH_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_ASH_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CALIPO_WOOD.get()), blockTexture(ModBlocks.STRIPPED_CALIPO_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_CALIPO_LOG.get()));

        leavesBlock(ModBlocks.ASH_LEAVES);
        leavesBlock(ModBlocks.CALIPO_LEAVES);
        //BlockItem

        blockItem(ModBlocks.LANGSTONE_PILAR);
        blockItem(ModBlocks.SUPREME_PILAR);
        blockItem(ModBlocks.ASH_LOG);
        blockItem(ModBlocks.ASH_WOOD);
        blockItem(ModBlocks.STRIPPED_ASH_LOG);
        blockItem(ModBlocks.STRIPPED_ASH_WOOD);
        blockItem(ModBlocks.CALIPO_LOG);
        blockItem(ModBlocks.CALIPO_WOOD);
        blockItem(ModBlocks.STRIPPED_CALIPO_LOG);
        blockItem(ModBlocks.STRIPPED_CALIPO_WOOD);

        //Flowers
        simpleBlockWithItem(ModBlocks.XANAS_FLOWER.get(), models().cross(blockTexture(ModBlocks.XANAS_FLOWER.get()).getPath(),
                blockTexture(ModBlocks.XANAS_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_XANAS_FLOWER.get(), models().singleTexture("potted_xanas_flower", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.XANAS_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.ROXA_FLOWER.get(), models().cross(blockTexture(ModBlocks.ROXA_FLOWER.get()).getPath(),
                blockTexture(ModBlocks.ROXA_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_ROXA_FLOWER.get(), models().singleTexture("potted_roxa_flower", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.ROXA_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.LYXOR_FLOWER.get(), models().cross(blockTexture(ModBlocks.LYXOR_FLOWER.get()).getPath(),
                blockTexture(ModBlocks.LYXOR_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.XELKS_FLOWER.get(), models().cross(blockTexture(ModBlocks.XELKS_FLOWER.get()).getPath(),
                blockTexture(ModBlocks.XELKS_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_XELKS_FLOWER.get(), models().singleTexture("potted_xelks_flower", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.XELKS_FLOWER.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.CALIPO_GRASS.get(), models().cross(blockTexture(ModBlocks.CALIPO_GRASS.get()).getPath(),
                blockTexture(ModBlocks.CALIPO_GRASS.get())).renderType("cutout"));

        //DifferentlyShapedBlocks
        signBlock(((StandingSignBlock) ModBlocks.ASH_SIGN.get()), ((WallSignBlock) ModBlocks.ASH_WALL_SIGN.get()),
                blockTexture(ModBlocks.ASH_PLANKS.get()));

        signBlock(((StandingSignBlock) ModBlocks.CALIPO_SIGN.get()), ((WallSignBlock) ModBlocks.CALIPO_WALL_SIGN.get()),
                blockTexture(ModBlocks.CALIPO_PLANKS.get()));

        hangingSignBlock(ModBlocks.ASH_HANGING_SIGN.get(), ModBlocks.ASH_WALL_HANGING_SIGN.get(),blockTexture(ModBlocks.ASH_PLANKS.get()));
        hangingSignBlock(ModBlocks.CALIPO_HANGING_SIGN.get(), ModBlocks.CALIPO_WALL_HANGING_SIGN.get(),blockTexture(ModBlocks.CALIPO_PLANKS.get()));

        wallBlock(((WallBlock) ModBlocks.FOSSIL_WALL.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.LANGSTONE_WALL.get()), blockTexture(ModBlocks.LANGSTONE.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_LANGSTONE_WALL.get()), blockTexture(ModBlocks.POLISHED_LANGSTONE.get()));
        wallBlock(((WallBlock) ModBlocks.LANGSTONE_BRICK_WALL.get()), blockTexture(ModBlocks.LANGSTONE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.DEEP_LANGSTONE_BRICK_WALL.get()), blockTexture(ModBlocks.DEEP_LANGSTONE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.DEEP_LANGSTONE_WALL.get()), blockTexture(ModBlocks.DEEP_LANGSTONE.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_DEEP_LANGSTONE_WALL.get()), blockTexture(ModBlocks.POLISHED_DEEP_LANGSTONE.get()));

        stairsBlock(((StairBlock) ModBlocks.ASH_STAIRS.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.POLISHED_LANGSTONE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_LANGSTONE.get()));
        stairsBlock(((StairBlock) ModBlocks.LANGSTONE_BRICK_STAIRS.get()), blockTexture(ModBlocks.LANGSTONE_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocks.LANGSTONE_STAIRS.get()), blockTexture(ModBlocks.LANGSTONE.get()));
        stairsBlock(((StairBlock) ModBlocks.DEEP_LANGSTONE_BRICK_STAIRS.get()), blockTexture(ModBlocks.DEEP_LANGSTONE_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocks.DEEP_LANGSTONE_STAIRS.get()), blockTexture(ModBlocks.DEEP_LANGSTONE.get()));
        stairsBlock(((StairBlock) ModBlocks.POLISHED_DEEP_LANGSTONE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_DEEP_LANGSTONE.get()));

        slabBlock(((SlabBlock) ModBlocks.ASH_SLAB.get()), blockTexture(ModBlocks.ASH_PLANKS.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_DEEP_LANGSTONE_SLAB.get()), blockTexture(ModBlocks.POLISHED_DEEP_LANGSTONE.get()), blockTexture(ModBlocks.POLISHED_DEEP_LANGSTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.DEEP_LANGSTONE_SLAB.get()), blockTexture(ModBlocks.DEEP_LANGSTONE.get()), blockTexture(ModBlocks.DEEP_LANGSTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.DEEP_LANGSTONE_BRICK_SLAB.get()), blockTexture(ModBlocks.DEEP_LANGSTONE_BRICKS.get()), blockTexture(ModBlocks.DEEP_LANGSTONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.LANGSTONE_SLAB.get()), blockTexture(ModBlocks.LANGSTONE.get()), blockTexture(ModBlocks.LANGSTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_LANGSTONE_SLAB.get()), blockTexture(ModBlocks.POLISHED_LANGSTONE.get()), blockTexture(ModBlocks.POLISHED_LANGSTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.LANGSTONE_BRICK_SLAB.get()), blockTexture(ModBlocks.LANGSTONE_BRICKS.get()), blockTexture(ModBlocks.LANGSTONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.CALIPO_SLAB.get()), blockTexture(ModBlocks.CALIPO_PLANKS.get()), blockTexture(ModBlocks.CALIPO_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.ASH_BUTTON.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ASH_PRESSURE_PLATE.get()),
                blockTexture(ModBlocks.ASH_PLANKS.get()));
        
        fenceBlock(((FenceBlock) ModBlocks.ASH_FENCE.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));

        fenceGateBlock(((FenceGateBlock) ModBlocks.ASH_FENCE_GATE.get()), blockTexture(ModBlocks.ASH_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.ASH_DOOR.get()), 
                modLoc("block/ash_door_bottom"),modLoc("block/ash_door_top"), "cutout");

        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ASH_TRAPDOOR.get()), 
                modLoc("block/ash_trapdoor"), true, "cutout");

        stairsBlock(((StairBlock) ModBlocks.CALIPO_STAIRS.get()), blockTexture(ModBlocks.CALIPO_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.CALIPO_BUTTON.get()), blockTexture(ModBlocks.CALIPO_PLANKS.get()));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CALIPO_PRESSURE_PLATE.get()),
                blockTexture(ModBlocks.CALIPO_PLANKS.get()));
        
        fenceBlock(((FenceBlock) ModBlocks.CALIPO_FENCE.get()), blockTexture(ModBlocks.CALIPO_PLANKS.get()));

        fenceGateBlock(((FenceGateBlock) ModBlocks.CALIPO_FENCE_GATE.get()), blockTexture(ModBlocks.CALIPO_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.CALIPO_DOOR.get()), 
                modLoc("block/calipo_door_bottom"),modLoc("block/calipo_door_top"), "cutout");

        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CALIPO_TRAPDOOR.get()), 
                modLoc("block/calipo_trapdoor"), true, "cutout");
        
        stairsBlock(((StairBlock) ModBlocks.FOSSIL_STAIRS.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.FOSSIL_SLAB.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.FOSSIL_BUTTON.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.FOSSIL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.FOSSIL_FENCE.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.FOSSIL_FENCE_GATE.get()), blockTexture(ModBlocks.FOSSIL_BLOCK.get()));


        doorBlockWithRenderType(((DoorBlock) ModBlocks.FOSSIL_DOOR.get()), modLoc("block/fossil_door_bottom"), modLoc("block/fossil_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.FOSSIL_TRAPDOOR.get()), modLoc("block/fossil_trapdoor"), true, "cutout");

}

private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
}

public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
}

public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
}

private String name(Block block) {
        return key(block).getPath();
}

private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
}

private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
}

private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(UndeadRemains.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
}

private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
}
private void glowVineBlock(RegistryObject<Block> blockRegistryObject) {
    Block block = blockRegistryObject.get();
    String baseName = ForgeRegistries.BLOCKS.getKey(block).getPath();
    String noBerriesModel = baseName;
    String berriesModel = baseName + "_berries";
    ModelFile noBerries = models()
            .cross(noBerriesModel,
                    new ResourceLocation(UndeadRemains.MOD_ID, "block/" + baseName))
            .renderType("cutout");
    ModelFile withBerries = models()
            .cross(berriesModel,
                    new ResourceLocation(UndeadRemains.MOD_ID, "block/" + berriesModel))
            .renderType("cutout");
    getVariantBuilder(block).forAllStates(state -> {
        boolean hasBerries = state.getValue(CalipoBerryVineBlock.BERRIES);
        return ConfiguredModel.builder()
                .modelFile(hasBerries ? withBerries : noBerries)
                .build();
    });
}


}
