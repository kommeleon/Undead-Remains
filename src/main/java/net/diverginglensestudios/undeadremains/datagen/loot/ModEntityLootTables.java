/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.datagen.loot;

import java.util.stream.Stream;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModEntityLootTables extends EntityLootSubProvider {

        public ModEntityLootTables() {
                super(FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected Stream<EntityType<?>> getKnownEntityTypes() {
                return Stream.of(
                                ModEntities.UNDEAD_ARCHEOLOGIST.get(),
                                ModEntities.FOSSILIZED_ZOMBIE.get(),
                                ModEntities.TREE_ZOMBIE.get(),
                                ModEntities.BIG_WOODLING.get(),
                                ModEntities.SMALL_WOODLING.get(),
                                ModEntities.SUPREME_ZOMBIE.get(),
                                ModEntities.COW_ZOMBIE.get(),
                                ModEntities.SPIKE.get(),
                                ModEntities.HAMMER_ZOMBIE.get(),
                                ModEntities.STRAY_ZOMBIE.get(),
                                ModEntities.FOUR_EYED_XANARIAN.get(),
                                ModEntities.XANARIAN.get(),
                                ModEntities.HORNED_XANARIAN.get());
        }

        @Override
        public void generate() {

                this.add(ModEntities.UNDEAD_ARCHEOLOGIST.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModItems.SUNGLASSES.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.3f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.THE_FOSSILS_EYE.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.3f)))));

                this.add(ModEntities.FOSSILIZED_ZOMBIE.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Items.DIRT)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Items.GRAVEL)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModItems.RAW_FOSSIL.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(0.1f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.THE_FOSSILS_EYE.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.3f)))));

                this.add(ModEntities.TREE_ZOMBIE.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModBlocks.ASH_LOG.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f)))));

                this.add(ModEntities.BIG_WOODLING.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.ASH_SAPLING_ITEM.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModBlocks.ASH_LEAVES.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f)))));

                this.add(ModEntities.SMALL_WOODLING.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.ASH_SAPLING_ITEM.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModBlocks.ASH_LEAVES.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f)))));

                this.add(ModEntities.SUPREME_ZOMBIE.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModItems.RARE_FOSSIL.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.05f)))));

                this.add(ModEntities.COW_ZOMBIE.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Items.LEATHER)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModItems.COW_HELMET.get())
                                                                                .setWeight(25)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F))))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.COW_CHESTPLATE.get())
                                                                                .setWeight(25)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F))))
                                                                .add(LootItem.lootTableItem(ModItems.COW_LEGGINGS.get())
                                                                                .setWeight(25)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F))))
                                                                .add(LootItem.lootTableItem(ModItems.COW_BOOTS.get())
                                                                                .setWeight(25)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F))))
                                                                .when(LootItemRandomChanceCondition
                                                                                .randomChance(0.5f))));

                this.add(ModEntities.SPIKE.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(ModItems.SPIKE.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                1.0f,
                                                                                                                3.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f)))));

                this.add(ModEntities.HAMMER_ZOMBIE.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f)))));

                this.add(ModEntities.STRAY_ZOMBIE.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(Blocks.PACKED_ICE)
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.1f)))));

                this.add(ModEntities.FOUR_EYED_XANARIAN.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.XANARIAN_SPINE.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.XANARIAN_LEATHER.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.6f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.RAW_XANARIAN_MEAT.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                3.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.9f)))));

                this.add(ModEntities.HORNED_XANARIAN.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.XANARIAN_SPINE.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.XANARIAN_LEATHER.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.9f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.XANARIAN_HORN.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.RAW_XANARIAN_MEAT.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                3.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.9f)))));

                this.add(ModEntities.XANARIAN.get(),
                                LootTable.lootTable()
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.XANARIAN_SPINE.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                ConstantValue.exactly(
                                                                                                                1.0F)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.1f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.XANARIAN_LEATHER.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                2.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.9f))))
                                                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                                                .add(LootItem.lootTableItem(
                                                                                ModItems.RAW_XANARIAN_MEAT.get())
                                                                                .apply(SetItemCountFunction.setCount(
                                                                                                UniformGenerator.between(
                                                                                                                0.0f,
                                                                                                                3.0f)))
                                                                                .when(LootItemRandomChanceCondition
                                                                                                .randomChance(0.9f)))));

        }
}