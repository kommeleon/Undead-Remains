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
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
        // FOSSIL_SMELTABLES
        private static final List<ItemLike> FOSSIL_SMELTABLES = List.of(
                        ModItems.RAW_FOSSIL.get(),
                        ModItems.RAW_DEEPSLATE_FOSSIL.get());
        // LANGRITE_SMELTABLES
        private static final List<ItemLike> LANGRITE_SMELTABLES = List.of(
                        ModItems.RAW_LANGRITE.get());
        // FOSSIL_BLOCK_SMELTABLES
        private static final List<ItemLike> FOSSIL_BLOCK_SMELTABLES = List.of(
                        ModBlocks.RAW_FOSSIL_BLOCK.get());

        // XANARIAN_MEAT_SMELTABLES
        private static final List<ItemLike> XANARIAN_MEAT_SMELTABLES = List.of(
                        ModItems.RAW_XANARIAN_MEAT.get());


        public ModRecipeProvider(PackOutput pOutput) {
                super(pOutput);
        }

        @Override
        protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
                //////////////////// SMELTING////////////////////
                // ORE SMELTING//
                oreSmelting(pWriter, FOSSIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL.get(), 0.25f, 200,
                                "fossil");
                oreSmelting(pWriter, LANGRITE_SMELTABLES, RecipeCategory.MISC, ModItems.LANGRITE_INGOT.get(), 0.25f,
                                200, "langrite");
                oreSmelting(pWriter, FOSSIL_BLOCK_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL.get(), 2.5f, 2000,
                                "fossil");
                oreSmelting(pWriter, XANARIAN_MEAT_SMELTABLES, RecipeCategory.MISC, ModItems.XANARIAN_MEAT.get(), 0.25f, 100,
                                "xanarian_meat");
                // ORE SMELTING//

                // Item SMOKING //
                itemSmoking(pWriter, XANARIAN_MEAT_SMELTABLES, RecipeCategory.MISC, ModItems.XANARIAN_MEAT.get(), 0.25f, 100,
                                "xanarian_meat");
                // Item SMOKING //

                // ORE BLASTING//
                oreBlasting(pWriter, FOSSIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL.get(), 0.25f, 100,
                                "fossil");
                oreBlasting(pWriter, LANGRITE_SMELTABLES, RecipeCategory.MISC, ModItems.LANGRITE_INGOT.get(), 0.25f,
                                100, "langrite");
                oreBlasting(pWriter, FOSSIL_BLOCK_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL.get(), 2.5f, 1000,
                                "fossil");
                // ORE BLASTING//
                //////////////////// SMELTING////////////////////

                //////////////////// SMITHING////////////////////
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_SWORD.get(),
                                /* addition */Items.AMETHYST_SHARD,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.AMETHYST_MODIFIED_FOSSIL_SWORD.get(),
                                /* unlock item */Items.AMETHYST_SHARD);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_AXE.get(),
                                /* addition */Items.RABBIT_FOOT,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.RABBIT_FOOT_MODIFIED_FOSSIL_AXE.get(),
                                /* unlock item */Items.RABBIT_FOOT);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_PICKAXE.get(),
                                /* addition */Items.BLAZE_ROD,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE.get(),
                                /* unlock item */Items.BLAZE_ROD);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_SHOVEL.get(),
                                /* addition */Items.NAUTILUS_SHELL,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.NAUTILUS_SHELL_MODIFIED_FOSSIL_SHOVEL.get(),
                                /* unlock item */Items.NAUTILUS_SHELL);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_HOE.get(),
                                /* addition */Items.SLIME_BALL,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.SLIME_BALL_MODIFIED_FOSSIL_HOE.get(),
                                /* unlock item */Items.SLIME_BALL);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_HELMET.get(),
                                /* addition */Items.LIGHTNING_ROD,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.LIGHTNING_ROD_MODIFIED_FOSSIL_HELMET.get(),
                                /* unlock item */Items.LIGHTNING_ROD);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_CHESTPLATE.get(),
                                /* addition */Items.CLOCK,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.CLOCK_MODIFIED_FOSSIL_CHESTPLATE.get(),
                                /* unlock item */Items.CLOCK);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_LEGGINGS.get(),
                                /* addition */Items.SCUTE,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS.get(),
                                /* unlock item */Items.SCUTE);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.FOSSIL_BOOTS.get(),
                                /* addition */Items.ECHO_SHARD,
                                /* category */RecipeCategory.COMBAT,
                                /* result */ModItems.SCULK_SHARD_MODIFIED_FOSSIL_BOOTS.get(),
                                /* unlock item */Items.ECHO_SHARD);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(), /* base */ModItems.THE_FOSSILS_EYE.get(),
                                /* addition */Items.QUARTZ,
                                /* category */RecipeCategory.FOOD,
                                /* result */ModItems.THE_QUARTZ_MODIFIED_FOSSILS_EYE.get(),
                                /* unlock item */Items.QUARTZ);
                customSmithing(pWriter, /* template */ModItems.FOSSIL.get(),
                                /* base */ModItems.FOSSILIZED_DRUMSTICK.get(),
                                /* addition */Blocks.GOLD_BLOCK.asItem(),
                                /* category */RecipeCategory.FOOD,
                                /* result */ModItems.GOLD_BLOCK_MODIFIED_FOSSILIZED_DRUMSTICK.get(),
                                /* unlock item */Blocks.GOLD_BLOCK.asItem());
                //////////////////// SMITHING////////////////////
                //////////////////// STONECUTTING////////////////
                // LANGSTONE
                stonecutting(Ingredient.of(ModBlocks.SUPREME_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.SUPREME_TILES.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.SUPREME_BRICKS.get()),
                                                has(ModBlocks.SUPREME_BRICKS.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.SUPREME_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.SUPREME_PILAR.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.SUPREME_BRICKS.get()),
                                                has(ModBlocks.SUPREME_BRICKS.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.SUPREME_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.CHISELED_SUPREME_BRICKS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.SUPREME_BRICKS.get()),
                                                has(ModBlocks.SUPREME_BRICKS.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.LANGSTONE_STAIRS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE.get()), has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.LANGSTONE_WALL.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE.get()), has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.LANGSTONE_SLAB.get(), 2)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE.get()), has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.FOSSIL_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.FOSSIL_STAIRS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.FOSSIL_BLOCK.get()), has(ModBlocks.FOSSIL_BLOCK.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.FOSSIL_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.FOSSIL_WALL.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.FOSSIL_BLOCK.get()), has(ModBlocks.FOSSIL_BLOCK.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.FOSSIL_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.FOSSIL_SLAB.get(), 2)
                                .unlockedBy(getHasName(ModBlocks.FOSSIL_BLOCK.get()), has(ModBlocks.FOSSIL_BLOCK.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.LANGSTONE_BRICK_STAIRS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE_BRICKS.get()),
                                                has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.LANGSTONE_BRICK_WALL.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE_BRICKS.get()),
                                                has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.LANGSTONE_BRICK_SLAB.get(), 2)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE_BRICKS.get()),
                                                has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.POLISHED_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.POLISHED_LANGSTONE_STAIRS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.POLISHED_LANGSTONE.get()),
                                                has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.POLISHED_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.POLISHED_LANGSTONE_WALL.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.POLISHED_LANGSTONE.get()),
                                                has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.POLISHED_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.POLISHED_LANGSTONE_SLAB.get(), 2)
                                .unlockedBy(getHasName(ModBlocks.POLISHED_LANGSTONE.get()),
                                                has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.LANGSTONE_PILAR.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE.get()), has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.CHISELED_LANGSTONE.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.LANGSTONE.get()), has(ModBlocks.LANGSTONE.get()))
                                .save(pWriter);
                // DEEP LANGSTONE
                stonecutting(Ingredient.of(ModBlocks.DEEP_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.DEEP_LANGSTONE_STAIRS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.DEEP_LANGSTONE.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.DEEP_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.DEEP_LANGSTONE_WALL.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.DEEP_LANGSTONE.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.DEEP_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.DEEP_LANGSTONE_SLAB.get(), 2)
                                .unlockedBy(getHasName(ModBlocks.DEEP_LANGSTONE.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.DEEP_LANGSTONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.DEEP_LANGSTONE_BRICK_STAIRS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.DEEP_LANGSTONE_BRICKS.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.DEEP_LANGSTONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.DEEP_LANGSTONE_BRICK_WALL.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.DEEP_LANGSTONE_BRICKS.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.DEEP_LANGSTONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.DEEP_LANGSTONE_BRICK_SLAB.get(), 2)
                                .unlockedBy(getHasName(ModBlocks.DEEP_LANGSTONE_BRICKS.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.POLISHED_DEEP_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.POLISHED_DEEP_LANGSTONE_STAIRS.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.POLISHED_DEEP_LANGSTONE.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.POLISHED_DEEP_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.POLISHED_DEEP_LANGSTONE_WALL.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.POLISHED_DEEP_LANGSTONE.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.POLISHED_DEEP_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.POLISHED_DEEP_LANGSTONE_SLAB.get(), 2)
                                .unlockedBy(getHasName(ModBlocks.POLISHED_DEEP_LANGSTONE.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                stonecutting(Ingredient.of(ModBlocks.DEEP_LANGSTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.CHISELED_DEEP_LANGSTONE.get(), 1)
                                .unlockedBy(getHasName(ModBlocks.DEEP_LANGSTONE.get()),
                                                has(ModBlocks.DEEP_LANGSTONE.get()))
                                .save(pWriter);
                //////////////////// STONECUTTING////////////////
                //////////////////// SHAPED////////////////////
                // ITEMS//
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_FUEL_CELL.get())
                                .pattern("III")
                                .pattern(" B ")
                                .pattern("III")
                                .define('I', Items.IRON_NUGGET)
                                .define('B', Items.GLASS_BOTTLE)
                                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW)
                                .pattern(" I ")
                                .pattern(" S ")
                                .pattern(" B ")
                                .define('I', ModItems.SPIKE.get())
                                .define('S', Items.STICK)
                                .define('B', Items.FEATHER)
                                .unlockedBy(getHasName(ModItems.SPIKE.get()), has(ModItems.SPIKE.get()))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .unlockedBy(getHasName(Items.FEATHER), has(Items.FEATHER))
                                .save(pWriter);
                // ITEMS//
                // BLOCKS//
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_SIGN.get())
                                .pattern("WWW")
                                .pattern("WWW")
                                .pattern(" S ")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "rods/wooden"))))
                                .define('W', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_SIGN.get()), has(ModBlocks.ASH_SIGN.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_SIGN.get())
                                .pattern("WWW")
                                .pattern("WWW")
                                .pattern(" S ")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "rods/wooden"))))
                                .define('W', ModBlocks.CALIPO_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_SIGN.get()), has(ModBlocks.CALIPO_SIGN.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_HANGING_SIGN.get())
                                .pattern("C C")
                                .pattern("WWW")
                                .pattern("WWW")
                                .define('C', Items.CHAIN)
                                .define('W', ModBlocks.CALIPO_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_HANGING_SIGN.get()),
                                                has(ModBlocks.CALIPO_HANGING_SIGN.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_WOOD.get(), 3)
                                .pattern("WW ")
                                .pattern("WW ")
                                .pattern("   ")
                                .define('W', ModBlocks.ASH_LOG.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_LOG.get()), has(ModBlocks.ASH_LOG.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_HANGING_SIGN.get())
                                .pattern("C C")
                                .pattern("WWW")
                                .pattern("WWW")
                                .define('C', Items.CHAIN)
                                .define('W', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_HANGING_SIGN.get()),
                                                has(ModBlocks.ASH_HANGING_SIGN.get()))
                                .save(pWriter);
                // BLOCKS//
                // ARMOR//
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_HELMET.get())
                                .pattern("SSS")
                                .pattern("S S")
                                .pattern("   ")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_CHESTPLATE.get())
                                .pattern("S S")
                                .pattern("SSS")
                                .pattern("SSS")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_LEGGINGS.get())
                                .pattern("SSS")
                                .pattern("S S")
                                .pattern("S S")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_BOOTS.get())
                                .pattern("   ")
                                .pattern("S S")
                                .pattern("S S")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_HELMET.get())
                                .pattern("SSS")
                                .pattern("S S")
                                .pattern("   ")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .unlockedBy(getHasName(ModItems.LANGRITE_INGOT.get()),
                                                has(ModItems.LANGRITE_INGOT.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_CHESTPLATE.get())
                                .pattern("S S")
                                .pattern("SSS")
                                .pattern("SSS")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .unlockedBy(getHasName(ModItems.LANGRITE_INGOT.get()),
                                                has(ModItems.LANGRITE_INGOT.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_LEGGINGS.get())
                                .pattern("SSS")
                                .pattern("S S")
                                .pattern("S S")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .unlockedBy(getHasName(ModItems.LANGRITE_INGOT.get()),
                                                has(ModItems.LANGRITE_INGOT.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_BOOTS.get())
                                .pattern("   ")
                                .pattern("S S")
                                .pattern("S S")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .unlockedBy(getHasName(ModItems.LANGRITE_INGOT.get()),
                                                has(ModItems.LANGRITE_INGOT.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUNGLASSES.get())
                                .pattern("A A")
                                .pattern("SAS")
                                .pattern("   ")
                                .define('S', Items.GLASS)
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GAS_MASK.get())
                                .pattern("Q Q")
                                .pattern("ADA")
                                .pattern("YYY")
                                .define('A', Ingredient.of(ItemTags.create(new ResourceLocation("minecraft", "coals"))))
                                .define('D', Items.LEATHER_HELMET)
                                .define('Q', Items.LEATHER)
                                .define('Y', Items.GLASS_BOTTLE)
                                .unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE))
                                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_HELMET.get())
                                .pattern("SSS")
                                .pattern("S S")
                                .pattern("   ")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_CHESTPLATE.get())
                                .pattern("S S")
                                .pattern("SSS")
                                .pattern("SSS")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_LEGGINGS.get())
                                .pattern("SSS")
                                .pattern("S S")
                                .pattern("S S")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_BOOTS.get())
                                .pattern("   ")
                                .pattern("S S")
                                .pattern("S S")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_GAS_MASK.get())
                                .pattern("   ")
                                .pattern("ADA")
                                .pattern("YYY")
                                .define('A', Ingredient.of(ItemTags.create(new ResourceLocation("minecraft", "coals"))))
                                .define('D', ModItems.METATORBERNITE_HELMET.get())
                                .define('Y', Items.GLASS_BOTTLE)
                                .unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE))
                                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                                .save(pWriter);
                // ARMOR//
                // TOOLS//
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_SWORD.get())
                                .pattern(" S ")
                                .pattern(" S ")
                                .pattern(" A ")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_PICKAXE.get())
                                .pattern("SSS")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_AXE.get())
                                .pattern("SS ")
                                .pattern("SA ")
                                .pattern(" A ")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_HOE.get())
                                .pattern("SS ")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FOSSIL_SHOVEL.get())
                                .pattern(" S ")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "fossil"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_SWORD.get())
                                .pattern(" S ")
                                .pattern(" S ")
                                .pattern(" A ")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_PICKAXE.get())
                                .pattern("SSS")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_AXE.get())
                                .pattern("SS ")
                                .pattern("SA ")
                                .pattern(" A ")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_HOE.get())
                                .pattern("SS ")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LANGRITE_SHOVEL.get())
                                .pattern(" S ")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', ModItems.LANGRITE_INGOT.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_SWORDAXE.get())
                                .pattern(" S ")
                                .pattern("SSS")
                                .pattern(" A ")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_PICKAXE.get())
                                .pattern("SSS")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_SHOVEL.get())
                                .pattern(" S ")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METATORBERNITE_HOE.get())
                                .pattern("SS ")
                                .pattern(" A ")
                                .pattern(" A ")
                                .define('S', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "metatorbernite"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPIKE_BAT.get())
                                .pattern("SAS")
                                .pattern("SAS")
                                .pattern(" A ")
                                .define('S', Ingredient.of(ItemTags.create(new ResourceLocation("forge", "spike"))))
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.SPIKE.get()),
                                                has(ItemTags.create(new ResourceLocation("forge", "spike"))))
                                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                                .save(pWriter);
                // TOOLS//
                // BLOCKS//
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_POLISHER.get())
                                .pattern("QQA")
                                .pattern("QYA")
                                .pattern("DDD")
                                .define('A', Ingredient
                                                .of(ItemTags.create(new ResourceLocation("minecraft", "planks"))))
                                .define('D', Blocks.DEEPSLATE)
                                .define('Q', Items.IRON_INGOT)
                                .define('Y', Blocks.STONECUTTER)
                                .unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE))
                                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                                .unlockedBy(getHasName(Blocks.STONECUTTER), has(Blocks.STONECUTTER))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_ALTAR.get())
                                .pattern("AAA")
                                .pattern("CRC")
                                .pattern("AAA")
                                .define('C', ModItems.EMPTY_FUEL_CELL.get())
                                .define('A', Items.IRON_INGOT)
                                .define('R', Items.REDSTONE)
                                .unlockedBy(getHasName(ModItems.RARE_FOSSIL.get()), has(ModItems.RARE_FOSSIL.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_LUCKY_BLOCK.get())
                                .pattern("SSS")
                                .pattern("SAS")
                                .pattern("SSS")
                                .define('S', ModItems.RARE_FOSSIL.get())
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModItems.FOSSIL.get()))
                                .define('A', Items.RABBIT_FOOT)
                                .unlockedBy(getHasName(Items.RABBIT_FOOT), has(ModItems.RARE_FOSSIL.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_PRESSURE_PLATE.get())
                                .pattern("   ")
                                .pattern("   ")
                                .pattern("SS ")
                                .define('S', ModItems.FOSSIL.get())
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModItems.FOSSIL.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_TRAPDOOR.get(), 2)
                                .pattern("   ")
                                .pattern("SSS")
                                .pattern("SSS")
                                .define('S', ModItems.FOSSIL.get())
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModItems.FOSSIL.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_FENCE.get(), 3)
                                .pattern("   ")
                                .pattern("SAS")
                                .pattern("SAS")
                                .define('S', ModItems.FOSSIL.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModItems.FOSSIL.get()))
                                .unlockedBy(getHasName(Items.STICK), has(ModItems.FOSSIL.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_FENCE_GATE.get(), 1)
                                .pattern("   ")
                                .pattern("ASA")
                                .pattern("ASA")
                                .define('S', ModItems.FOSSIL.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .unlockedBy(getHasName(Items.STICK), has(ModItems.FOSSIL.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_DOOR.get(), 3)
                                .pattern("SS ")
                                .pattern("SS ")
                                .pattern("SS ")
                                .define('S', ModItems.FOSSIL.get())
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModItems.FOSSIL.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_FENCE.get(), 3)
                                .pattern("   ")
                                .pattern("SAS")
                                .pattern("SAS")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .unlockedBy(getHasName(Items.STICK), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_FENCE_GATE.get(), 1)
                                .pattern("   ")
                                .pattern("ASA")
                                .pattern("ASA")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .unlockedBy(getHasName(Items.STICK), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_DOOR.get(), 3)
                                .pattern("SS ")
                                .pattern("SS ")
                                .pattern("SS ")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_PRESSURE_PLATE.get(), 1)
                                .pattern("   ")
                                .pattern("   ")
                                .pattern("SS ")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_SLAB.get(), 6)
                                .pattern("   ")
                                .pattern("   ")
                                .pattern("SSS")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_STAIRS.get(), 4)
                                .pattern("S  ")
                                .pattern("SS ")
                                .pattern("SSS")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ASH_TRAPDOOR.get(), 2)
                                .pattern("   ")
                                .pattern("SSS")
                                .pattern("SSS")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ASH_BOAT.get())
                                .pattern("   ")
                                .pattern("SS ")
                                .pattern("SSS")
                                .define('S', ModBlocks.ASH_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_FENCE.get(), 3)
                                .pattern("   ")
                                .pattern("SAS")
                                .pattern("SAS")
                                .define('S', ModBlocks.CALIPO_PLANKS.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .unlockedBy(getHasName(Items.STICK), has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_WOOD.get(), 3)
                                .pattern("WW ")
                                .pattern("WW ")
                                .pattern("   ")
                                .define('W', ModBlocks.CALIPO_LOG.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_LOG.get()), has(ModBlocks.CALIPO_LOG.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_FENCE_GATE.get())
                                .pattern("   ")
                                .pattern("ASA")
                                .pattern("ASA")
                                .define('S', ModBlocks.CALIPO_PLANKS.get())
                                .define('A', Items.STICK)
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .unlockedBy(getHasName(Items.STICK), has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_DOOR.get(), 3)
                                .pattern("SS ")
                                .pattern("SS ")
                                .pattern("SS ")
                                .define('S', ModBlocks.CALIPO_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_PRESSURE_PLATE.get())
                                .pattern("   ")
                                .pattern("   ")
                                .pattern("SS ")
                                .define('S', ModBlocks.CALIPO_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_SLAB.get(), 6)
                                .pattern("   ")
                                .pattern("   ")
                                .pattern("SSS")
                                .define('S', ModBlocks.CALIPO_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_STAIRS.get(), 4)
                                .pattern("S  ")
                                .pattern("SS ")
                                .pattern("SSS")
                                .define('S', ModBlocks.CALIPO_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALIPO_TRAPDOOR.get(), 2)
                                .pattern("   ")
                                .pattern("SSS")
                                .pattern("SSS")
                                .define('S', ModBlocks.CALIPO_PLANKS.get())
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                // BLOCKS//
                //////////////////// SHAPED////////////////////
                //////////////////// SHAPELESS////////////////////
                // SHAPELESS ITEM//
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.METATORBERNITE_GRENADE.get(), 4)// resulting
                                                                                                               // items
                                .requires(ModItems.METATORBERNITE.get())// required items
                                .requires(Items.GLASS_BOTTLE)// required items
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ModItems.METATORBERNITE.get()))
                                .save(pWriter);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.ASH_BUTTON.get(), 1)// resulting items
                                .requires(ModBlocks.ASH_PLANKS.get())// required items
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CALIPO_BUTTON.get(), 1)// resulting
                                                                                                       // items
                                .requires(ModBlocks.CALIPO_PLANKS.get())// required items
                                .unlockedBy(getHasName(ModBlocks.CALIPO_PLANKS.get()),
                                                has(ModBlocks.CALIPO_PLANKS.get()))
                                .save(pWriter);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ASH_CHEST_BOAT.get(), 1)// resulting
                                                                                                       // items
                                .requires(Items.CHEST)// required items
                                .requires(ModItems.ASH_BOAT.get())// required items
                                .unlockedBy(getHasName(ModBlocks.ASH_PLANKS.get()), has(ModBlocks.ASH_PLANKS.get()))
                                .save(pWriter);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FOSSIL.get(), 9)
                                .requires(ModBlocks.FOSSIL_BLOCK.get())
                                .unlockedBy(getHasName(ModBlocks.FOSSIL_BLOCK.get()), has(ModBlocks.FOSSIL_BLOCK.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":fossil_from_fossil_block");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.METATORBERNITE.get(), 9)
                                .requires(ModBlocks.METATORBERNITE_BLOCK.get())
                                .unlockedBy(getHasName(ModBlocks.METATORBERNITE_BLOCK.get()),
                                                has(ModBlocks.METATORBERNITE_BLOCK.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":metatorbernite_from_metatorbernite_block");
                // SHAPELESS ITEM//
                // SHAPELESS ARMOR//
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.METATORBERNITE_GAS_MASK.get(), 1)
                                .requires(ModItems.GAS_MASK.get())
                                .requires(ModItems.METATORBERNITE_HELMET.get())
                                .unlockedBy(getHasName(ModItems.GAS_MASK.get()), has(ModItems.GAS_MASK.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":metatorbernite_gas_mak_from_gas_mask");
                // SHAPELESS ARMOR//
                // SHAPELESS BLOCK//
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.ASH_PLANKS.get(), 4)
                                .requires(ModTags.Items.ASH_WOOD)
                                .unlockedBy(getHasName(ModBlocks.ASH_LOG.get()), has(ModBlocks.ASH_LOG.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":ash_planks_from_wood");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CALIPO_PLANKS.get(), 4)
                                .requires(ModTags.Items.CALIPO_WOOD)
                                .unlockedBy(getHasName(ModBlocks.CALIPO_LOG.get()), has(ModBlocks.CALIPO_LOG.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":calipo_planks_from_wood");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.FOSSIL_BLOCK.get(), 1)
                                .requires(ModItems.FOSSIL.get(), 9)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModItems.FOSSIL.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":fossil_block_from_fossil");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SUPREME_BRICKS.get(), 1)
                                .requires(ModItems.RARE_FOSSIL.get(), 9)
                                .unlockedBy(getHasName(ModItems.RARE_FOSSIL.get()), has(ModItems.RARE_FOSSIL.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":rare_fossil_bricks_from_rare_fossil");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RAW_FOSSIL_BLOCK.get(), 1)
                                .requires(ModItems.RAW_FOSSIL.get(), 9)
                                .unlockedBy(getHasName(ModItems.RAW_FOSSIL.get()), has(ModItems.RAW_FOSSIL.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":raw_fossil_block_from_raw_fossil");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RAW_FOSSIL_BLOCK.get(), 1)
                                .requires(ModItems.RAW_DEEPSLATE_FOSSIL.get(), 9)
                                .unlockedBy(getHasName(ModItems.RAW_DEEPSLATE_FOSSIL.get()),
                                                has(ModItems.RAW_DEEPSLATE_FOSSIL.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":raw_fossil_block_from_raw_deepslate_fossil");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.METATORBERNITE_BLOCK.get(), 1)
                                .requires(ModItems.METATORBERNITE.get(), 9)
                                .unlockedBy(getHasName(ModItems.METATORBERNITE.get()),
                                                has(ModItems.METATORBERNITE.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":metatorbernite_block_from_metatorbernite");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.FOSSIL_BUTTON.get(), 1)
                                .requires(ModItems.FOSSIL.get(), 1)
                                .unlockedBy(getHasName(ModItems.FOSSIL.get()), has(ModItems.FOSSIL.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":fossil_button_from_fossil");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RAW_LANGRITE_BLOCK.get(), 1)
                                .requires(ModItems.RAW_LANGRITE.get(), 9)
                                .unlockedBy(getHasName(ModItems.RAW_LANGRITE.get()), has(ModItems.RAW_LANGRITE.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":raw_langrite_block_from_raw_langrite");
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LANGRITE_BLOCK.get(), 1)
                                .requires(ModItems.LANGRITE_INGOT.get(), 9)
                                .unlockedBy(getHasName(ModItems.LANGRITE_INGOT.get()),
                                                has(ModItems.LANGRITE_INGOT.get()))
                                .save(pWriter, UndeadRemains.MOD_ID + ":langrite_block_from_langrite");
                // SHAPELESS BLOCK//
                // SHAPELESS FOOD//
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.XANARIAN_KEBAB.get(), 1)// resulting
                                                                                                       // items
                                .requires(ModItems.XANARIAN_MEAT.get())// required items
                                .requires(Items.BREAD)// required items
                                .unlockedBy(getHasName(ModItems.XANARIAN_MEAT.get()),
                                                has(ModItems.XANARIAN_MEAT.get()))
                                .save(pWriter);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.XANARIAN_SHISH_KEBAB.get(), 1)// resulting
                                                                                                             // items
                                .requires(ModItems.XANARIAN_MEAT.get())// required items
                                .requires(Items.STICK)// required items
                                .unlockedBy(getHasName(ModItems.XANARIAN_MEAT.get()),
                                                has(ModItems.XANARIAN_MEAT.get()))
                                .save(pWriter);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.XANARIAN_KEBAB_WRAP.get(), 1)// resulting
                                                                                                            // items
                                .requires(ModItems.XANARIAN_MEAT.get())// required items
                                .requires(ModItems.WRAP.get())// required items
                                .unlockedBy(getHasName(ModItems.XANARIAN_MEAT.get()),
                                                has(ModItems.XANARIAN_MEAT.get()))
                                .save(pWriter);

                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WRAP.get(), 1)// resulting
                                                                                             // items
                                .requires(Items.STICK)// required items
                                .requires(Items.BREAD)// required items
                                .unlockedBy(getHasName(Items.BREAD),
                                                has(Items.BREAD))
                                .save(pWriter);
                //////////////////// SHAPELESS////////////////////
        }

        public static SingleItemRecipeBuilder stonecutting(Ingredient pIngredient, RecipeCategory pCategory,
                        ItemLike pResult, int count) {
                return new SingleItemRecipeBuilder(pCategory, RecipeSerializer.STONECUTTER, pIngredient, pResult,
                                count);
        }

        protected static void customSmithing(Consumer<FinishedRecipe> finishedRecipeConsumer, Item template, Item base,
                        Item addition, RecipeCategory category, Item result, Item unlockItem) {
                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(template),
                                Ingredient.of(base),
                                Ingredient.of(addition),
                                category,
                                result)
                                .unlocks("has_correct_item", has(unlockItem))
                                .save(finishedRecipeConsumer, getItemName(result) + "_smithing");
        }

        protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                        RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme,
                        String pGroup) {
                oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                                pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void itemSmoking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                        RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme,
                        String pGroup) {
                oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMOKING_RECIPE, pIngredients, pCategory, pResult,
                                pExperience, pCookingTIme, pGroup, "_from_smoking");
        }

        protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                        RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,
                        String pGroup) {
                oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                                pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                        RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                        List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience,
                        int pCookingTime, String pGroup, String pRecipeName) {
                for (ItemLike itemlike : pIngredients) {
                        SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                                        pExperience, pCookingTime, pCookingSerializer)
                                        .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                                        .save(pFinishedRecipeConsumer, UndeadRemains.MOD_ID + ":" + getItemName(pResult)
                                                        + pRecipeName + "_" + getItemName(itemlike));
                }
        }
}
