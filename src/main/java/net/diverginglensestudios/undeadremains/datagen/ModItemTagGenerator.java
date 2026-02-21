/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.datagen;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
	public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
			CompletableFuture<TagLookup<Block>> p_275322_,
			@Nullable ExistingFileHelper existingFileHelper) {
		super(p_275343_, p_275729_, p_275322_, UndeadRemains.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider) {
		// TRIMMABLE_ARMOR
		this.tag(ItemTags.TRIMMABLE_ARMOR)
				.add(ModItems.FOSSIL_HELMET.get(),
						ModItems.FOSSIL_CHESTPLATE.get(),
						ModItems.FOSSIL_LEGGINGS.get(),
						ModItems.FOSSIL_BOOTS.get())
				.add(ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS.get(),
						ModItems.SCULK_SHARD_MODIFIED_FOSSIL_BOOTS.get(),
						ModItems.CLOCK_MODIFIED_FOSSIL_CHESTPLATE.get())
				.add(ModItems.RARE_FOSSIL_HELMET.get(),
						ModItems.RARE_FOSSIL_CHESTPLATE.get(),
						ModItems.RARE_FOSSIL_LEGGINGS.get(),
						ModItems.RARE_FOSSIL_BOOTS.get())
				.add(ModItems.LANGRITE_HELMET.get(),
						ModItems.LANGRITE_CHESTPLATE.get(),
						ModItems.LANGRITE_LEGGINGS.get(),
						ModItems.LANGRITE_BOOTS.get())
				.add(ModItems.METATORBERNITE_HELMET.get(),
						ModItems.METATORBERNITE_CHESTPLATE.get(),
						ModItems.METATORBERNITE_LEGGINGS.get(),
						ModItems.METATORBERNITE_BOOTS.get());
		;
		// MUSIC_DISCS
		this.tag(ItemTags.MUSIC_DISCS)
				.add(ModItems.UNDYING_WHISPERS_MUSIC_DISC.get());

		// RAW_MATERIALS
		this.tag(Tags.Items.RAW_MATERIALS)
				.add(ModItems.RAW_LANGRITE.get())
				.add(ModItems.RAW_FOSSIL.get())
				.add(ModItems.RAW_DEEPSLATE_FOSSIL.get());

		// BONES
		this.tag(Tags.Items.BONES)
				.add(ModItems.XANARIAN_SPINE.get());

		// FISHES
		this.tag(ItemTags.FISHES)
				.add(ModItems.RAW_XANARANHA.get());

		// LEATHER
		this.tag(Tags.Items.LEATHER)
				.add(ModItems.XANARIAN_LEATHER.get());

		// INGOTS
		this.tag(Tags.Items.INGOTS)
				.add(ModItems.LANGRITE_INGOT.get());

		// BOATS
		this.tag(ItemTags.BOATS)
				.add(ModItems.ASH_BOAT.get())
				.add(ModItems.ASH_CHEST_BOAT.get());

		// CHEST_BOATS
		this.tag(ItemTags.CHEST_BOATS)
				.add(ModItems.ASH_CHEST_BOAT.get());

		this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
				.add(ModItems.UNDYING_WHISPERS_MUSIC_DISC.get());

		this.tag(ItemTags.TOOLS)
				.add(ModItems.METATORBERNITE_SWORDAXE.get())
				.add(ModItems.FOSSIL_SHOVEL.get())
				.add(ModItems.FOSSIL_PICKAXE.get())
				.add(ModItems.FOSSIL_AXE.get())
				.add(ModItems.FOSSIL_HOE.get())
				.add(ModItems.FOSSIL_SWORD.get())
				.add(ModItems.NAUTILUS_SHELL_MODIFIED_FOSSIL_SHOVEL.get())
				.add(ModItems.BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE.get())
				.add(ModItems.RABBIT_FOOT_MODIFIED_FOSSIL_AXE.get())
				.add(ModItems.SLIME_BALL_MODIFIED_FOSSIL_HOE.get())
				.add(ModItems.AMETHYST_MODIFIED_FOSSIL_SWORD.get())
				.add(ModItems.LANGRITE_SHOVEL.get())
				.add(ModItems.LANGRITE_PICKAXE.get())
				.add(ModItems.LANGRITE_AXE.get())
				.add(ModItems.LANGRITE_HOE.get())
				.add(ModItems.LANGRITE_SWORD.get());

		this.tag(ItemTags.SHOVELS)
				.add(ModItems.FOSSIL_SHOVEL.get())
				.add(ModItems.RARE_FOSSIL_SHOVEL.get())
				.add(ModItems.METATORBERNITE_TOOL.get())
				.add(ModItems.LANGRITE_SHOVEL.get());

		this.tag(ItemTags.PICKAXES)
				.add(ModItems.FOSSIL_PICKAXE.get())
				.add(ModItems.RARE_FOSSIL_PICKAXE.get())
				.add(ModItems.METATORBERNITE_TOOL.get())
				.add(ModItems.LANGRITE_PICKAXE.get());

		this.tag(ItemTags.AXES)
				.add(ModItems.METATORBERNITE_SWORDAXE.get())
				.add(ModItems.FOSSIL_AXE.get())
				.add(ModItems.RARE_FOSSIL_AXE.get())
				.add(ModItems.LANGRITE_AXE.get());

		this.tag(ItemTags.HOES)
				.add(ModItems.FOSSIL_HOE.get())
				.add(ModItems.RARE_FOSSIL_HOE.get())
				.add(ModItems.METATORBERNITE_TOOL.get())
				.add(ModItems.LANGRITE_HOE.get());

		this.tag(ItemTags.SWORDS)
				.add(ModItems.METATORBERNITE_SWORDAXE.get())
				.add(ModItems.FOSSIL_SWORD.get())
				.add(ModItems.RARE_FOSSIL_SWORD.get())
				.add(ModItems.LANGRITE_SWORD.get());

		////////// BLOCKS//////////

		// ASH_WOOD
		this.tag(ModTags.Items.ASH_WOOD)
				.add(ModBlocks.STRIPPED_ASH_WOOD.get().asItem())
				.add(ModBlocks.ASH_WOOD.get().asItem())
				.add(ModBlocks.STRIPPED_ASH_LOG.get().asItem())
				.add(ModBlocks.ASH_LOG.get().asItem());

		// CALIPO_WOOD
		this.tag(ModTags.Items.CALIPO_WOOD)
				.add(ModBlocks.STRIPPED_CALIPO_WOOD.get().asItem())
				.add(ModBlocks.CALIPO_WOOD.get().asItem())
				.add(ModBlocks.STRIPPED_CALIPO_LOG.get().asItem())
				.add(ModBlocks.CALIPO_LOG.get().asItem());

		// LOGS_THAT_BURN
		this.tag(ItemTags.LOGS_THAT_BURN)
				.add(ModBlocks.CALIPO_LOG.get().asItem())
				.add(ModBlocks.CALIPO_WOOD.get().asItem())
				.add(ModBlocks.STRIPPED_CALIPO_LOG.get().asItem())
				.add(ModBlocks.STRIPPED_CALIPO_WOOD.get().asItem())
				.add(ModBlocks.ASH_LOG.get().asItem())
				.add(ModBlocks.ASH_WOOD.get().asItem())
				.add(ModBlocks.STRIPPED_ASH_LOG.get().asItem())
				.add(ModBlocks.STRIPPED_ASH_WOOD.get().asItem());

		// PLANKS
		this.tag(ItemTags.PLANKS)
				.add(ModBlocks.CALIPO_PLANKS.get().asItem())
				.add(ModBlocks.ASH_PLANKS.get().asItem());

		// DIRT
		this.tag(ItemTags.DIRT)
				.add(ModBlocks.LIVING_LANGSTONE.get().asItem());

		// LEAVES
		this.tag(ItemTags.LEAVES)
				.add(ModBlocks.CALIPO_LEAVES.get().asItem())
				.add(ModBlocks.ASH_LEAVES.get().asItem());

		// COMPLETES_FIND_TREE_TUTORIAL
		this.tag(ItemTags.COMPLETES_FIND_TREE_TUTORIAL)
				.add(ModBlocks.CALIPO_LEAVES.get().asItem())
				.add(ModBlocks.ASH_LEAVES.get().asItem());

		this.tag(ItemTags.SIGNS)
				.add(ModBlocks.CALIPO_SIGN.get().asItem())
				.add(ModBlocks.ASH_SIGN.get().asItem());

		this.tag(ItemTags.HANGING_SIGNS)
				.add(ModBlocks.ASH_HANGING_SIGN.get().asItem())
				.add(ModBlocks.CALIPO_HANGING_SIGN.get().asItem());

		this.tag(ItemTags.STAIRS)
				.add(ModBlocks.FOSSIL_STAIRS.get().asItem())
				.add(ModBlocks.ASH_STAIRS.get().asItem());

		this.tag(ItemTags.SLABS)
				.add(ModBlocks.FOSSIL_SLAB.get().asItem())
				.add(ModBlocks.ASH_SLAB.get().asItem());

		this.tag(ItemTags.BUTTONS)
				.add(ModBlocks.FOSSIL_BUTTON.get().asItem())
				.add(ModBlocks.ASH_BUTTON.get().asItem());

		this.tag(ItemTags.FENCES)
				.add(ModBlocks.FOSSIL_FENCE.get().asItem())
				.add(ModBlocks.ASH_FENCE.get().asItem());

		this.tag(ItemTags.FENCE_GATES)
				.add(ModBlocks.FOSSIL_FENCE_GATE.get().asItem())
				.add(ModBlocks.ASH_FENCE_GATE.get().asItem());

		this.tag(ItemTags.DOORS)
				.add(ModBlocks.FOSSIL_DOOR.get().asItem())
				.add(ModBlocks.ASH_DOOR.get().asItem());

		this.tag(ItemTags.TRAPDOORS)
				.add(ModBlocks.FOSSIL_TRAPDOOR.get().asItem())
				.add(ModBlocks.ASH_TRAPDOOR.get().asItem());

		this.tag(ItemTags.WALLS)
				.add(ModBlocks.FOSSIL_WALL.get().asItem());

		// Custom Forge Tags
		this.tag(ItemTags.create(new ResourceLocation("forge", "raw_fossil")))
				.add(ModItems.RAW_FOSSIL.get())
				.add(ModItems.RAW_DEEPSLATE_FOSSIL.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "raw_langrite")))
				.add(ModItems.RAW_FOSSIL.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "fossil")))
				.add(ModItems.FOSSIL.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "spike")))
				.add(ModItems.SPIKE.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "metatorbernite")))
				.add(ModItems.METATORBERNITE.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "langrite")))
				.add(ModItems.LANGRITE_INGOT.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "raw_materials")))
				.add(ModItems.RAW_DEEPSLATE_FOSSIL.get())
				.add(ModItems.RAW_LANGRITE.get())
				.add(ModItems.RAW_FOSSIL.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "raw_materials/fossil")))
				.add(ModItems.RAW_DEEPSLATE_FOSSIL.get())
				.add(ModItems.RAW_FOSSIL.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "armors")))
				.add(ModItems.FOSSIL_HELMET.get(),
						ModItems.FOSSIL_CHESTPLATE.get(),
						ModItems.FOSSIL_LEGGINGS.get(),
						ModItems.FOSSIL_BOOTS.get())
				.add(ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS.get())
				.add(ModItems.RARE_FOSSIL_HELMET.get(),
						ModItems.RARE_FOSSIL_CHESTPLATE.get(),
						ModItems.RARE_FOSSIL_LEGGINGS.get(),
						ModItems.RARE_FOSSIL_BOOTS.get())
				.add(ModItems.LANGRITE_HELMET.get(),
						ModItems.LANGRITE_CHESTPLATE.get(),
						ModItems.LANGRITE_LEGGINGS.get(),
						ModItems.LANGRITE_BOOTS.get())
				.add(ModItems.METATORBERNITE_HELMET.get(),
						ModItems.METATORBERNITE_CHESTPLATE.get(),
						ModItems.METATORBERNITE_LEGGINGS.get(),
						ModItems.METATORBERNITE_BOOTS.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "armors/helmets")))
				.add(ModItems.FOSSIL_HELMET.get())
				.add(ModItems.RARE_FOSSIL_HELMET.get())
				.add(ModItems.METATORBERNITE_HELMET.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "armors/chestplate")))
				.add(ModItems.FOSSIL_CHESTPLATE.get())
				.add(ModItems.RARE_FOSSIL_CHESTPLATE.get())
				.add(ModItems.METATORBERNITE_CHESTPLATE.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "armors/leggings")))
				.add(ModItems.FOSSIL_LEGGINGS.get())
				.add(ModItems.RARE_FOSSIL_LEGGINGS.get())
				.add(ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS.get())
				.add(ModItems.METATORBERNITE_LEGGINGS.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "armors/boots")))
				.add(ModItems.FOSSIL_BOOTS.get())
				.add(ModItems.RARE_FOSSIL_BOOTS.get())
				.add(ModItems.METATORBERNITE_BOOTS.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "storage_blocks")))
				.add(ModBlocks.FOSSIL_BLOCK.get().asItem())
				.add(ModBlocks.RAW_FOSSIL_BLOCK.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "storage_blocks/raw_fossil")))
				.add(ModBlocks.RAW_FOSSIL_BLOCK.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "storage_blocks/fossil")))
				.add(ModBlocks.FOSSIL_BLOCK.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "ores_in_ground/stone")))
				.add(ModBlocks.FOSSIL_ORE.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "ores_in_ground/deepslate")))
				.add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "ore_rates/singular")))
				.add(ModBlocks.FOSSIL_ORE.get().asItem())
				.add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "ores/fossil")))
				.add(ModBlocks.FOSSIL_ORE.get().asItem())
				.add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "ores")))
				.add(ModBlocks.FOSSIL_ORE.get().asItem())
				.add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "fossil_ores")))
				.add(ModBlocks.FOSSIL_ORE.get().asItem())
				.add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get().asItem());

		this.tag(ItemTags.create(new ResourceLocation("forge", "metatorbernite")))
				.add(ModItems.METATORBERNITE.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "langrite_ingots")))
				.add(ModItems.LANGRITE_INGOT.get());

		this.tag(ItemTags.create(new ResourceLocation("forge", "meat")))
				.add(ModItems.XANARIAN_MEAT.get())
				.add(ModItems.RAW_XANARIAN_MEAT.get());

		// Custom Minecraft Tags

	}
}
