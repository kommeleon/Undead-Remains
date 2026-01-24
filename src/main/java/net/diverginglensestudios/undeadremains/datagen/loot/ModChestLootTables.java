package net.diverginglensestudios.undeadremains.datagen.loot;

import java.util.function.BiConsumer;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModChestLootTables implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        // Example: Add loot to a custom dungeon chest
        consumer.accept(new ResourceLocation("undeadremains", "chests/travelers_tent"),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 2.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.METATURBONITE.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                        .when(LootItemRandomChanceCondition.randomChance(0.01f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModBlocks.CALIPO_LOG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModBlocks.CALIPO_LEAVES.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.CALIPO_BERRIES.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.XANS_LEAF_SEEDS.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f)))));

        consumer.accept(new ResourceLocation("undeadremains", "chests/travelers_hut"),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 2.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.METATURBONITE.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)))
                                        .when(LootItemRandomChanceCondition.randomChance(0.1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(Blocks.DIRT)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModBlocks.CALIPO_LOG.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModBlocks.CALIPO_LEAVES.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.CALIPO_BERRIES.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.XANARIAN_HORN.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.XANARIAN_LEATHER.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.RAW_XANARIAN_MEAT.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(Items.WHEAT_SEEDS)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(ModItems.XANS_LEAF_SEEDS.get())
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0f)))
                                        .when(LootItemRandomChanceCondition.randomChance(1f)))));
    }
}