/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.datagen;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UndeadRemains.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

//LANGSTONE_REPLACEABLES
this.tag(ModTags.Blocks.LANGSTONE_REPLACEABLES)
        .add(ModBlocks.LANGSTONE.get());

//MINEABLE_WITH_PICKAXE
this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(ModBlocks.LANGSTONE.get())
        .add(ModBlocks.DEEP_LANGSTONE.get())
        .add(ModBlocks.LIVING_LANGSTONE.get())
        .add(ModBlocks.FOSSIL_BLOCK.get())
        .add(ModBlocks.RAW_FOSSIL_BLOCK.get())
        .add(ModBlocks.FOSSIL_ORE.get())
        .add(ModBlocks.LANGRITE_ORE.get())
        .add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get())
        .add(ModBlocks.FOSSIL_LUCKY_BLOCK.get())
        .add(ModBlocks.METATORBERNITE_ORE.get());


//NEEDS_IRON_TOOL
this.tag(BlockTags.NEEDS_IRON_TOOL)
        .add(ModBlocks.RAW_LANGRITE_BLOCK.get())
        .add(ModBlocks.LANGRITE_ORE.get());

//NEEDS_STONE_TOOL
this.tag(BlockTags.NEEDS_STONE_TOOL)
        .add(ModBlocks.RAW_FOSSIL_BLOCK.get())
        .add(ModBlocks.FOSSIL_ORE.get())
        .add(ModBlocks.METATORBERNITE_ORE.get())
        .add(ModBlocks.METATORBERNITE_BLOCK.get())
        .add(ModBlocks.DEEP_LANGSTONE.get());
        

//LOGS_THAT_BURN
this.tag(BlockTags.LOGS_THAT_BURN)
        .add(ModBlocks.CALIPO_LOG.get())
        .add(ModBlocks.CALIPO_WOOD.get())
        .add(ModBlocks.STRIPPED_CALIPO_LOG.get())
        .add(ModBlocks.STRIPPED_CALIPO_WOOD.get())
        .add(ModBlocks.ASH_LOG.get())
        .add(ModBlocks.ASH_WOOD.get())
        .add(ModBlocks.STRIPPED_ASH_LOG.get())
        .add(ModBlocks.STRIPPED_ASH_WOOD.get());

//LOGS
this.tag(BlockTags.LOGS)
        .add(ModBlocks.CALIPO_LOG.get())
        .add(ModBlocks.CALIPO_WOOD.get())
        .add(ModBlocks.STRIPPED_CALIPO_LOG.get())
        .add(ModBlocks.STRIPPED_CALIPO_WOOD.get())
        .add(ModBlocks.ASH_LOG.get())
        .add(ModBlocks.ASH_WOOD.get())
        .add(ModBlocks.STRIPPED_ASH_LOG.get())
        .add(ModBlocks.STRIPPED_ASH_WOOD.get());

//PLANKS
this.tag(BlockTags.PLANKS)
        .add(ModBlocks.CALIPO_PLANKS.get())
        .add(ModBlocks.ASH_PLANKS.get());

//STAIRS
this.tag(BlockTags.STAIRS)
        .add(ModBlocks.ASH_STAIRS.get())
        .add(ModBlocks.CALIPO_STAIRS.get())
        .add(ModBlocks.FOSSIL_STAIRS.get());

//SLABS
this.tag(BlockTags.SLABS)
        .add(ModBlocks.ASH_SLAB.get())
        .add(ModBlocks.CALIPO_SLAB.get())
        .add(ModBlocks.FOSSIL_SLAB.get());

//FENCES
this.tag(BlockTags.FENCES)
        .add(ModBlocks.ASH_FENCE.get())
        .add(ModBlocks.CALIPO_FENCE.get())
        .add(ModBlocks.FOSSIL_FENCE.get());

//FENCE_GATES
this.tag(BlockTags.FENCE_GATES)
        .add(ModBlocks.ASH_FENCE_GATE.get())
        .add(ModBlocks.CALIPO_FENCE_GATE.get())
        .add(ModBlocks.FOSSIL_FENCE_GATE.get());

//BUTTONS
this.tag(BlockTags.BUTTONS)
        .add(ModBlocks.ASH_BUTTON.get())
        .add(ModBlocks.CALIPO_BUTTON.get())
        .add(ModBlocks.FOSSIL_BUTTON.get());

//DOORS
this.tag(BlockTags.DOORS)
        .add(ModBlocks.ASH_DOOR.get())
        .add(ModBlocks.CALIPO_DOOR.get())
        .add(ModBlocks.FOSSIL_DOOR.get());

//WALLS
this.tag(BlockTags.WALLS)
        .add(ModBlocks.LANGSTONE_WALL.get())
        .add(ModBlocks.POLISHED_LANGSTONE_WALL.get())
        .add(ModBlocks.LANGSTONE_BRICK_WALL.get())
        .add(ModBlocks.FOSSIL_WALL.get())
        .add(ModBlocks.DEEP_LANGSTONE_WALL.get())
        .add(ModBlocks.DEEP_LANGSTONE_BRICK_WALL.get())
        .add(ModBlocks.POLISHED_DEEP_LANGSTONE_WALL.get());

//TRAPDOORS
this.tag(BlockTags.TRAPDOORS)
        .add(ModBlocks.ASH_TRAPDOOR.get())
        .add(ModBlocks.CALIPO_TRAPDOOR.get())
        .add(ModBlocks.FOSSIL_TRAPDOOR.get());

//ALL_HANGING_SIGNS
this.tag(BlockTags.ALL_HANGING_SIGNS)
        .add(ModBlocks.ASH_HANGING_SIGN.get())
        .add(ModBlocks.CALIPO_HANGING_SIGN.get());

//SIGNS
this.tag(BlockTags.SIGNS)
        .add(ModBlocks.ASH_SIGN.get())
        .add(ModBlocks.CALIPO_SIGN.get());


//LEAVES
this.tag(BlockTags.LEAVES)
        .add(ModBlocks.CALIPO_LEAVES.get())
        .add(ModBlocks.ASH_LEAVES.get())
        .add(ModBlocks.CALIPO_LEAVES.get());

//DIRT
this.tag(BlockTags.DIRT)
        .add(ModBlocks.LIVING_LANGSTONE.get());

//STORAGE_BLOCKS
this.tag(Tags.Blocks.STORAGE_BLOCKS)
        .add(ModBlocks.METATORBERNITE_BLOCK.get())
        .add(ModBlocks.LANGRITE_BLOCK.get())
        .add(ModBlocks.FOSSIL_BLOCK.get());

//ORES
this.tag(Tags.Blocks.ORES)
        .add(ModBlocks.FOSSIL_ORE.get())
        .add(ModBlocks.LANGRITE_ORE.get())
        .add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get())
        .add(ModBlocks.METATORBERNITE_ORE.get());

//CUSTOM FORGE TAGS

this.tag(BlockTags.create(new ResourceLocation("forge", "storage_blocks/fossil")))
.add(ModBlocks.FOSSIL_BLOCK.get());

this.tag(BlockTags.create(new ResourceLocation("forge", "supports_xanarian_foliage")))
.add(ModBlocks.LIVING_LANGSTONE.get());

this.tag(BlockTags.create(new ResourceLocation("forge", "storage_blocks/raw_fossil")))
.add(ModBlocks.RAW_FOSSIL_BLOCK.get());

//CUSTOM MINECRAFT TAGS

this.tag(BlockTags.create(new ResourceLocation("minecraft", "ash_logs")))
.add(ModBlocks.STRIPPED_ASH_WOOD.get());

}}
