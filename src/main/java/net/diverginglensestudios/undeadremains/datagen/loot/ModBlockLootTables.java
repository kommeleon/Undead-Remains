/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.datagen.loot;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import java.util.Set;

import org.checkerframework.checker.units.qual.g;

public class ModBlockLootTables extends BlockLootSubProvider {
        public ModBlockLootTables() {
                super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
                /* //////////Loottables////////// */

                // Dropself
                this.dropSelf(ModBlocks.SUPREME_BRICKS.get());
                this.dropSelf(ModBlocks.SUPREME_TILES.get());
                this.dropSelf(ModBlocks.SUPREME_PILAR.get());
                this.dropSelf(ModBlocks.CHISELED_SUPREME_BRICKS.get());
                this.dropSelf(ModBlocks.FOSSIL_BLOCK.get());
                this.dropSelf(ModBlocks.LANGSTONE_BRICKS.get());
                this.dropSelf(ModBlocks.LANGSTONE_PILAR.get());
                this.dropSelf(ModBlocks.LANGSTONE_STAIRS.get());
                this.dropSelf(ModBlocks.LANGSTONE_WALL.get());
                this.dropSelf(ModBlocks.CRACKED_LANGSTONE_BRICKS.get());
                this.dropSelf(ModBlocks.POLISHED_LANGSTONE_STAIRS.get());
                this.dropSelf(ModBlocks.POLISHED_LANGSTONE_WALL.get());
                this.dropSelf(ModBlocks.LANGSTONE_BRICK_STAIRS.get());
                this.dropSelf(ModBlocks.LANGSTONE_BRICK_WALL.get());
                this.dropSelf(ModBlocks.DEEP_LANGSTONE_BRICK_STAIRS.get());
                this.dropSelf(ModBlocks.DEEP_LANGSTONE_BRICK_WALL.get());
                this.dropSelf(ModBlocks.DEEP_LANGSTONE_STAIRS.get());
                this.dropSelf(ModBlocks.DEEP_LANGSTONE_WALL.get());
                this.dropSelf(ModBlocks.POLISHED_DEEP_LANGSTONE_STAIRS.get());
                this.dropSelf(ModBlocks.POLISHED_DEEP_LANGSTONE_WALL.get());
                this.dropSelf(ModBlocks.POLISHED_DEEP_LANGSTONE.get());
                this.dropSelf(ModBlocks.POLISHED_LANGSTONE.get());
                this.dropSelf(ModBlocks.CHISELED_LANGSTONE.get());
                this.dropSelf(ModBlocks.LANGRITE_BLOCK.get());
                this.dropSelf(ModBlocks.LANGSTONE.get());
                this.dropSelf(ModBlocks.DEEP_LANGSTONE.get());
                this.dropSelf(ModBlocks.DEEP_LANGSTONE_BRICKS.get());
                this.dropSelf(ModBlocks.CRACKED_DEEP_LANGSTONE_BRICKS.get());
                this.dropSelf(ModBlocks.CHISELED_DEEP_LANGSTONE.get());
                this.dropSelf(ModBlocks.RAW_LANGRITE_BLOCK.get());
                this.dropSelf(ModBlocks.RAW_FOSSIL_BLOCK.get());
                this.dropSelf(ModBlocks.FOSSIL_STAIRS.get());
                this.dropSelf(ModBlocks.FOSSIL_BUTTON.get());
                this.dropSelf(ModBlocks.FOSSIL_PRESSURE_PLATE.get());
                this.dropSelf(ModBlocks.FOSSIL_TRAPDOOR.get());
                this.dropSelf(ModBlocks.FOSSIL_FENCE.get());
                this.dropSelf(ModBlocks.FOSSIL_FENCE_GATE.get());
                this.dropSelf(ModBlocks.FOSSIL_WALL.get());
                this.dropSelf(ModBlocks.ASH_STAIRS.get());
                this.dropSelf(ModBlocks.ASH_BUTTON.get());
                this.dropSelf(ModBlocks.ASH_PRESSURE_PLATE.get());
                this.dropSelf(ModBlocks.ASH_TRAPDOOR.get());
                this.dropSelf(ModBlocks.ASH_FENCE.get());
                this.dropSelf(ModBlocks.ASH_FENCE_GATE.get());
                this.dropSelf(ModBlocks.CALIPO_STAIRS.get());
                this.dropSelf(ModBlocks.CALIPO_BUTTON.get());
                this.dropSelf(ModBlocks.CALIPO_PRESSURE_PLATE.get());
                this.dropSelf(ModBlocks.CALIPO_TRAPDOOR.get());
                this.dropSelf(ModBlocks.CALIPO_FENCE.get());
                this.dropSelf(ModBlocks.CALIPO_FENCE_GATE.get());
                this.dropSelf(ModBlocks.FOSSIL_LUCKY_BLOCK.get());
                this.dropSelf(ModBlocks.METATORBERNITE_LUCKY_BLOCK.get());
                this.dropSelf(ModBlocks.ASH_SAPLING.get());
                this.dropSelf(ModBlocks.CREEPER_SAPLING.get());
                this.dropSelf(ModBlocks.CALIPO_SAPLING.get());
                this.dropSelf(ModBlocks.METATORBERNITE_BLOCK.get());
                this.dropSelf(ModBlocks.FOSSIL_POLISHER.get());
                this.dropSelf(ModBlocks.ASH_LOG.get());
                this.dropSelf(ModBlocks.ASH_WOOD.get());
                this.dropSelf(ModBlocks.STRIPPED_ASH_LOG.get());
                this.dropSelf(ModBlocks.STRIPPED_ASH_WOOD.get());
                this.dropSelf(ModBlocks.ASH_PLANKS.get());
                this.dropSelf(ModBlocks.CALIPO_LOG.get());
                this.dropSelf(ModBlocks.CALIPO_WOOD.get());
                this.dropSelf(ModBlocks.STRIPPED_CALIPO_LOG.get());
                this.dropSelf(ModBlocks.STRIPPED_CALIPO_WOOD.get());
                this.dropSelf(ModBlocks.CALIPO_PLANKS.get());
                this.dropSelf(ModBlocks.XANAS_FLOWER.get());
                this.dropSelf(ModBlocks.ROXA_FLOWER.get());
                this.dropSelf(ModBlocks.LYXOR_FLOWER.get());
                this.dropSelf(ModBlocks.XELKS_FLOWER.get());

                this.dropOther(ModBlocks.CALIPO_BERRY_VINE.get(), Items.AIR);

                this.add(ModBlocks.CALIPO_GRASS.get(),createGrassTable(ModBlocks.CALIPO_GRASS.get(), Items.AIR));

                this.add(ModBlocks.POTTED_XANAS_FLOWER.get(), createPotFlowerItemTable(ModBlocks.XANAS_FLOWER.get()));
                this.add(ModBlocks.POTTED_ROXA_FLOWER.get(), createPotFlowerItemTable(ModBlocks.ROXA_FLOWER.get()));
                this.add(ModBlocks.POTTED_XELKS_FLOWER.get(), createPotFlowerItemTable(ModBlocks.XELKS_FLOWER.get()));

                // SingleItemTable(with silktouch)
                this.add(ModBlocks.LIVING_LANGSTONE.get(),
                                block -> createSingleWithSilkTable(ModBlocks.LIVING_LANGSTONE.get(),
                                                ModBlocks.LANGSTONE.get().asItem()));

                // Ores
                this.add(ModBlocks.FOSSIL_ORE.get(),
                                block -> createFossilLikeOreDrops(ModBlocks.FOSSIL_ORE.get(), ModItems.RAW_FOSSIL.get(),
                                                ModItems.RARE_FOSSIL.get()));

                this.add(ModBlocks.METATORBERNITE_ORE.get(),
                                block -> createNormalOreDrops(ModBlocks.METATORBERNITE_ORE.get(),
                                                ModItems.METATORBERNITE.get(), 1, 3));

                this.add(ModBlocks.DEEPSLATE_FOSSIL_ORE.get(),
                                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_FOSSIL_ORE.get(),
                                                ModItems.RAW_FOSSIL.get()));

                this.add(ModBlocks.LANGRITE_ORE.get(),
                                block -> createNormalOreDrops(ModBlocks.LANGRITE_ORE.get(), ModItems.RAW_LANGRITE.get(),
                                                1, 3));

                // Slabs
                this.add(ModBlocks.FOSSIL_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.FOSSIL_SLAB.get()));
                this.add(ModBlocks.DEEP_LANGSTONE_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.DEEP_LANGSTONE_SLAB.get()));
                this.add(ModBlocks.POLISHED_DEEP_LANGSTONE_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.POLISHED_DEEP_LANGSTONE_SLAB.get()));
                this.add(ModBlocks.DEEP_LANGSTONE_BRICK_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.DEEP_LANGSTONE_BRICK_SLAB.get()));
                this.add(ModBlocks.LANGSTONE_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.LANGSTONE_SLAB.get()));
                this.add(ModBlocks.POLISHED_LANGSTONE_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.POLISHED_LANGSTONE_SLAB.get()));
                this.add(ModBlocks.LANGSTONE_BRICK_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.LANGSTONE_BRICK_SLAB.get()));
                this.add(ModBlocks.ASH_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.ASH_SLAB.get()));
                this.add(ModBlocks.CALIPO_SLAB.get(),
                                block -> createSlabItemTable(ModBlocks.ASH_SLAB.get()));

                // Doors
                this.add(ModBlocks.FOSSIL_DOOR.get(),
                                block -> createDoorTable(ModBlocks.FOSSIL_DOOR.get()));

                this.add(ModBlocks.ASH_DOOR.get(),
                                block -> createDoorTable(ModBlocks.ASH_DOOR.get()));

                this.add(ModBlocks.CALIPO_DOOR.get(),
                                block -> createDoorTable(ModBlocks.CALIPO_DOOR.get()));

                // Leaves
                this.add(ModBlocks.ASH_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.ASH_SAPLING.get(),
                                NORMAL_LEAVES_SAPLING_CHANCES));

                this.add(ModBlocks.CALIPO_LEAVES.get(),
                                block -> createLeavesDrops(block, Blocks.AIR, NORMAL_LEAVES_SAPLING_CHANCES)); // TODO:
                                                                                                               // Change
                                                                                                               // to
                                                                                                               // Sapling!

                // Signs
                this.add(ModBlocks.ASH_SIGN.get(), block -> createSingleItemTable(ModItems.ASH_SIGN.get()));

                this.add(ModBlocks.ASH_WALL_SIGN.get(), block -> createSingleItemTable(ModItems.ASH_SIGN.get()));

                this.add(ModBlocks.ASH_HANGING_SIGN.get(),
                                block -> createSingleItemTable(ModItems.ASH_HANGING_SIGN.get()));

                this.add(ModBlocks.ASH_WALL_HANGING_SIGN.get(),
                                block -> createSingleItemTable(ModItems.ASH_HANGING_SIGN.get()));

                this.add(ModBlocks.CALIPO_SIGN.get(), block -> createSingleItemTable(ModItems.CALIPO_SIGN.get()));

                this.add(ModBlocks.CALIPO_WALL_SIGN.get(), block -> createSingleItemTable(ModItems.CALIPO_SIGN.get()));

                this.add(ModBlocks.CALIPO_HANGING_SIGN.get(),
                                block -> createSingleItemTable(ModItems.CALIPO_HANGING_SIGN.get()));

                this.add(ModBlocks.CALIPO_WALL_HANGING_SIGN.get(),
                                block -> createSingleItemTable(ModItems.CALIPO_HANGING_SIGN.get()));
                /* //////////Loottables////////// */}

        /* //////////Loottable creators////////// */

        protected LootTable.Builder createNormalOreDrops(Block pBlock, Item item, int MinDrop, int MaxDrop) {
                return createSilkTouchDispatchTable(pBlock,
                                this.applyExplosionDecay(pBlock,
                                                LootItem.lootTableItem(item)
                                                                .apply(SetItemCountFunction.setCount(UniformGenerator
                                                                                .between(MinDrop, MaxDrop)))
                                                                .apply(ApplyBonusCount.addOreBonusCount(
                                                                                Enchantments.BLOCK_FORTUNE))));
        }

        protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
                return createSilkTouchDispatchTable(pBlock,
                                this.applyExplosionDecay(pBlock,
                                                LootItem.lootTableItem(item)
                                                                .apply(SetItemCountFunction.setCount(
                                                                                UniformGenerator.between(2.0F, 5.0F)))
                                                                .apply(ApplyBonusCount.addOreBonusCount(
                                                                                Enchantments.BLOCK_FORTUNE))));
        }

        protected LootTable.Builder createSingleWithSilkTable(Block pBlock, Item item) {
                return createSilkTouchDispatchTable(pBlock,
                                this.applyExplosionDecay(pBlock,
                                                LootItem.lootTableItem(item)
                                                                .apply(SetItemCountFunction.setCount(UniformGenerator
                                                                                .between(1.0F, 1.0F)))));
        }

        protected LootTable.Builder createGrassTable(Block pBlock, Item pItem) {
                return createShearsDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(pItem)
                        .when(LootItemRandomChanceCondition.randomChance(0.125F))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));
        }


        protected LootTable.Builder createFossilLikeOreDrops(Block pBlock, Item item, Item seconditem) {
                return LootTable.lootTable()
                                .withPool(LootPool.lootPool() // Regular fossil drop
                                                .setRolls(UniformGenerator.between(1.0F, 1.0F))
                                                .add(LootItem.lootTableItem(item)
                                                                .apply(SetItemCountFunction.setCount(
                                                                                UniformGenerator.between(2.0F, 5.0F)))
                                                                .apply(ApplyBonusCount.addOreBonusCount(
                                                                                Enchantments.BLOCK_FORTUNE))))
                                .withPool(LootPool.lootPool() // Rare fossil drop (1 in 5 chance)
                                                .setRolls(UniformGenerator.between(1.0F, 1.0F))
                                                .add(LootItem.lootTableItem(seconditem)
                                                                .when(LootItemRandomChanceCondition.randomChance(0.2F)) // 20%
                                                                                                                        // chance
                                                ));
                /* //////////Loottable creators////////// */}

        @Override
        protected Iterable<Block> getKnownBlocks() {
                return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }
}
