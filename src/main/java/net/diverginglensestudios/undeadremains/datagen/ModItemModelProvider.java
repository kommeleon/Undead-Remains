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
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
	private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
	static {
		trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
		trimMaterials.put(TrimMaterials.IRON, 0.2F);
		trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
		trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
		trimMaterials.put(TrimMaterials.COPPER, 0.5F);
		trimMaterials.put(TrimMaterials.GOLD, 0.6F);
		trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
		trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
		trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
		trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
	}

	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, UndeadRemains.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleItem(ModItems.FOSSIL);
		simpleItem(ModItems.RARE_FOSSIL);
		simpleItem(ModItems.RAW_DEEPSLATE_FOSSIL);
		simpleItem(ModItems.RAW_FOSSIL);
		simpleItem(ModItems.RAW_LANGRITE);
		simpleItem(ModItems.LANGRITE_INGOT);
		simpleItem(ModItems.METATURBONITE);
		simpleItem(ModItems.EMPTY_FUEL_CELL);
		simpleItem(ModItems.XANARIAN_SPINE);
		simpleItem(ModItems.XANARIAN_HORN);
		simpleItem(ModItems.XANARIAN_LEATHER);
		simpleItem(ModItems.METATORBERNITE);
		simpleItem(ModItems.SUNGLASSES);
		simpleItem(ModItems.SPIKE);
		simpleItem(ModItems.ASH_SIGN);
		simpleItem(ModItems.ASH_HANGING_SIGN);
		simpleItem(ModItems.CALIPO_SIGN);
		simpleItem(ModItems.CALIPO_HANGING_SIGN);
		simpleItem(ModItems.ASH_BOAT);
		simpleItem(ModItems.ASH_CHEST_BOAT);
		simpleItem(ModItems.METATORBERNITE_GRENADE);
		// Food
		simpleItem(ModItems.FOSSILIZED_DRUMSTICK);
		simpleItem(ModItems.GOLD_BLOCK_MODIFIED_FOSSILIZED_DRUMSTICK);
		simpleItem(ModItems.THE_FOSSILS_EYE);
		simpleItem(ModItems.THE_QUARTZ_MODIFIED_FOSSILS_EYE);
		simpleItem(ModItems.RAW_XANARIAN_MEAT);
		simpleItem(ModItems.XANARIAN_MEAT);
		simpleItem(ModItems.XANARIAN_KEBAB);
		simpleItem(ModItems.XANARIAN_SHISH_KEBAB);
		simpleItem(ModItems.XANARIAN_KEBAB_WRAP);
		simpleItem(ModItems.WRAP);
		simpleItem(ModItems.CALIPO_BERRIES);
		simpleItem(ModItems.XANS_LEAF);
		simpleItem(ModItems.XANS_LEAF_SEEDS);
		// Saplings
		saplingItem(ModBlocks.ASH_SAPLING);
		saplingItem(ModBlocks.CALIPO_SAPLING);
		// Music_Discs
		simpleItem(ModItems.UNDYING_WHISPERS_MUSIC_DISC);
		// Doors
		simpleBlockItem(ModBlocks.FOSSIL_DOOR);
		simpleBlockItem(ModBlocks.ASH_DOOR);
		simpleBlockItem(ModBlocks.CALIPO_DOOR);
		// Fences
		fenceItem(ModBlocks.FOSSIL_FENCE, ModBlocks.FOSSIL_BLOCK);
		fenceItem(ModBlocks.ASH_FENCE, ModBlocks.ASH_PLANKS);
		fenceItem(ModBlocks.CALIPO_FENCE, ModBlocks.CALIPO_PLANKS);
		// Buttons
		buttonItem(ModBlocks.FOSSIL_BUTTON, ModBlocks.FOSSIL_BLOCK);
		buttonItem(ModBlocks.ASH_BUTTON, ModBlocks.ASH_PLANKS);
		buttonItem(ModBlocks.CALIPO_BUTTON, ModBlocks.CALIPO_PLANKS);
		// Walls
		wallItem(ModBlocks.FOSSIL_WALL, ModBlocks.FOSSIL_BLOCK);
		wallItem(ModBlocks.LANGSTONE_WALL, ModBlocks.LANGSTONE);
		wallItem(ModBlocks.POLISHED_LANGSTONE_WALL, ModBlocks.POLISHED_LANGSTONE);
		wallItem(ModBlocks.LANGSTONE_BRICK_WALL, ModBlocks.LANGSTONE_BRICKS);
		wallItem(ModBlocks.DEEP_LANGSTONE_WALL, ModBlocks.DEEP_LANGSTONE);
		wallItem(ModBlocks.DEEP_LANGSTONE_BRICK_WALL, ModBlocks.DEEP_LANGSTONE_BRICKS);
		wallItem(ModBlocks.POLISHED_DEEP_LANGSTONE_WALL, ModBlocks.POLISHED_DEEP_LANGSTONE);
		// Weirdly_shaped_blocks
		evenSimplerBlockItem(ModBlocks.FOSSIL_STAIRS);
		evenSimplerBlockItem(ModBlocks.METATORBERNITE_ENRICHER_CONTROLLER);
		evenSimplerBlockItem(ModBlocks.METATORBERNITE_ENRICHER_PART);
		evenSimplerBlockItem(ModBlocks.FOSSIL_SLAB);
		evenSimplerBlockItem(ModBlocks.FOSSIL_PRESSURE_PLATE);
		evenSimplerBlockItem(ModBlocks.FOSSIL_FENCE_GATE);
		evenSimplerBlockItem(ModBlocks.ASH_STAIRS);
		evenSimplerBlockItem(ModBlocks.ASH_SLAB);
		evenSimplerBlockItem(ModBlocks.ASH_PRESSURE_PLATE);
		evenSimplerBlockItem(ModBlocks.ASH_FENCE_GATE);
		evenSimplerBlockItem(ModBlocks.CALIPO_STAIRS);
		evenSimplerBlockItem(ModBlocks.CALIPO_SLAB);
		evenSimplerBlockItem(ModBlocks.CALIPO_PRESSURE_PLATE);
		evenSimplerBlockItem(ModBlocks.CALIPO_FENCE_GATE);
		evenSimplerBlockItem(ModBlocks.LANGSTONE_STAIRS);
		evenSimplerBlockItem(ModBlocks.LANGSTONE_SLAB);
		evenSimplerBlockItem(ModBlocks.POLISHED_LANGSTONE_STAIRS);
		evenSimplerBlockItem(ModBlocks.POLISHED_LANGSTONE_SLAB);
		evenSimplerBlockItem(ModBlocks.LANGSTONE_BRICK_STAIRS);
		evenSimplerBlockItem(ModBlocks.LANGSTONE_BRICK_SLAB);
		evenSimplerBlockItem(ModBlocks.DEEP_LANGSTONE_STAIRS);
		evenSimplerBlockItem(ModBlocks.DEEP_LANGSTONE_SLAB);
		evenSimplerBlockItem(ModBlocks.DEEP_LANGSTONE_BRICK_STAIRS);
		evenSimplerBlockItem(ModBlocks.DEEP_LANGSTONE_BRICK_SLAB);
		evenSimplerBlockItem(ModBlocks.POLISHED_DEEP_LANGSTONE_STAIRS);
		evenSimplerBlockItem(ModBlocks.POLISHED_DEEP_LANGSTONE_SLAB);
		// Trapdoors
		trapdoorItem(ModBlocks.FOSSIL_TRAPDOOR);
		trapdoorItem(ModBlocks.ASH_TRAPDOOR);
		trapdoorItem(ModBlocks.CALIPO_TRAPDOOR);
		// Tools
		handheldItem(ModItems.FOSSIL_SWORD);
		handheldItem(ModItems.AMETHYST_MODIFIED_FOSSIL_SWORD);
		handheldItem(ModItems.FOSSIL_PICKAXE);
		handheldItem(ModItems.BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE);
		handheldItem(ModItems.FOSSIL_AXE);
		handheldItem(ModItems.RABBIT_FOOT_MODIFIED_FOSSIL_AXE);
		handheldItem(ModItems.FOSSIL_SHOVEL);
		handheldItem(ModItems.NAUTILUS_SHELL_MODIFIED_FOSSIL_SHOVEL);
		handheldItem(ModItems.FOSSIL_HOE);
		handheldItem(ModItems.SLIME_BALL_MODIFIED_FOSSIL_HOE);
		handheldItem(ModItems.LANGRITE_SWORD);
		handheldItem(ModItems.LANGRITE_PICKAXE);
		handheldItem(ModItems.LANGRITE_AXE);
		handheldItem(ModItems.LANGRITE_SHOVEL);
		handheldItem(ModItems.LANGRITE_HOE);
		handheldItem(ModItems.METATORBERNITE_SWORDAXE);
		handheldItem(ModItems.METATORBERNITE_PICKAXE);
		handheldItem(ModItems.METATORBERNITE_SHOVEL);
		handheldItem(ModItems.METATORBERNITE_HOE);
		handheldItem(ModItems.METATORBERNITE_TOOL);
		handheldItem(ModItems.RARE_FOSSIL_SWORD);
		handheldItem(ModItems.RARE_FOSSIL_PICKAXE);
		handheldItem(ModItems.RARE_FOSSIL_AXE);
		handheldItem(ModItems.RARE_FOSSIL_SHOVEL);
		handheldItem(ModItems.RARE_FOSSIL_HOE);
		// Armor
		trimmedArmorItem(ModItems.GAS_MASK);
		trimmedArmorItem(ModItems.XANARIAN_SPINE_CHESTPLATE);
		trimmedArmorItem(ModItems.METATORBERNITE_GAS_MASK);
		trimmedArmorItem(ModItems.FOSSIL_HELMET);
		trimmedArmorItem(ModItems.FOSSIL_CHESTPLATE);
		trimmedArmorItem(ModItems.FOSSIL_LEGGINGS);
		trimmedArmorItem(ModItems.LIGHTNING_ROD_MODIFIED_FOSSIL_HELMET);
		trimmedArmorItem(ModItems.CLOCK_MODIFIED_FOSSIL_CHESTPLATE);
		trimmedArmorItem(ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS);
		trimmedArmorItem(ModItems.SCULK_SHARD_MODIFIED_FOSSIL_BOOTS);
		trimmedArmorItem(ModItems.FOSSIL_BOOTS);
		trimmedArmorItem(ModItems.RARE_FOSSIL_HELMET);
		trimmedArmorItem(ModItems.RARE_FOSSIL_CHESTPLATE);
		trimmedArmorItem(ModItems.RARE_FOSSIL_LEGGINGS);
		trimmedArmorItem(ModItems.RARE_FOSSIL_BOOTS);
		trimmedArmorItem(ModItems.LANGRITE_HELMET);
		trimmedArmorItem(ModItems.LANGRITE_CHESTPLATE);
		trimmedArmorItem(ModItems.LANGRITE_LEGGINGS);
		trimmedArmorItem(ModItems.LANGRITE_BOOTS);
		trimmedArmorItem(ModItems.METATORBERNITE_HELMET);
		trimmedArmorItem(ModItems.METATORBERNITE_CHESTPLATE);
		trimmedArmorItem(ModItems.METATORBERNITE_LEGGINGS);
		trimmedArmorItem(ModItems.METATORBERNITE_BOOTS);
		trimmedArmorItem(ModItems.COW_HELMET);
		trimmedArmorItem(ModItems.COW_CHESTPLATE);
		trimmedArmorItem(ModItems.COW_LEGGINGS);
		trimmedArmorItem(ModItems.COW_BOOTS);
		// SpawnEggs
		withExistingParent(ModItems.UNDEADARCHEOLOGIST_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.FOSSILIZED_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.TREE_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.SUPREME_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.COW_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.SPIKE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.HAMMER_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.FOUR_EYED_XANARIAN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.XANARIAN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.HORNED_XANARIAN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.SUPREME_KNIGHT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.SMALL_WOODLING_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.BIG_WOODLING_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.STRAY_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.XANARIAN_CANNIBAL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
		withExistingParent(ModItems.XANARANHA_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
	}

	// Shoutout to El_Redstoniano for making this
	private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
		final String MOD_ID = UndeadRemains.MOD_ID; // Change this to your mod id

		if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
			trimMaterials.entrySet().forEach(entry -> {

				ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
				float trimValue = entry.getValue();

				String armorType = switch (armorItem.getEquipmentSlot()) {
					case HEAD -> "helmet";
					case CHEST -> "chestplate";
					case LEGS -> "leggings";
					case FEET -> "boots";
					default -> "";
				};

				String armorItemPath = "item/" + armorItem;
				String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
				String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
				ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
				ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
				ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

				// This is used for making the ExistingFileHelper acknowledge that this texture
				// exist, so this will
				// avoid an IllegalArgumentException
				existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

				// Trimmed armorItem files
				getBuilder(currentTrimName)
						.parent(new ModelFile.UncheckedModelFile("item/generated"))
						.texture("layer0", armorItemResLoc)
						.texture("layer1", trimResLoc);

				// Non-trimmed armorItem file (normal variant)
				this.withExistingParent(itemRegistryObject.getId().getPath(),
								mcLoc("item/generated"))
						.override()
						.model(new ModelFile.UncheckedModelFile(trimNameResLoc))
						.predicate(mcLoc("trim_type"), trimValue).end()
						.texture("layer0",
								new ResourceLocation(MOD_ID,
										"item/" + itemRegistryObject.getId().getPath()));
			});
		}
	}

	private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(UndeadRemains.MOD_ID, "block/" + item.getId().getPath()));
	}

	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(UndeadRemains.MOD_ID, "item/" + item.getId().getPath()));
	}

	public void evenSimplerBlockItem(RegistryObject<Block> block) {
		this.withExistingParent(UndeadRemains.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
				modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
	}

	public void trapdoorItem(RegistryObject<Block> block) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
				modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
	}

	public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
				.texture("texture", new ResourceLocation(UndeadRemains.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}

	public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
				.texture("texture", new ResourceLocation(UndeadRemains.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}

	public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
		this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
				.texture("wall", new ResourceLocation(UndeadRemains.MOD_ID,
						"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
	}

	private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(UndeadRemains.MOD_ID, "item/" + item.getId().getPath()));
	}

	private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(UndeadRemains.MOD_ID, "item/" + item.getId().getPath()));
	}

	private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(UndeadRemains.MOD_ID, "block/" + item.getId().getPath()));
	}
}
