/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, UndeadRemains.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FOSSIL.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.FOSSIL.get());
                        pOutput.accept(ModItems.RAW_FOSSIL.get());
                        pOutput.accept(ModItems.RAW_DEEPSLATE_FOSSIL.get());

                        pOutput.accept(ModBlocks.FOSSIL_BLOCK.get());
                        pOutput.accept(ModBlocks.FOSSIL_ORE.get());
                        pOutput.accept(ModBlocks.RAW_FOSSIL_BLOCK.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_FOSSIL_ORE.get());

                        pOutput.accept(ModBlocks.FOSSIL_STAIRS.get());
                        pOutput.accept(ModBlocks.FOSSIL_SLAB.get());
                        pOutput.accept(ModBlocks.FOSSIL_BUTTON.get());
                        pOutput.accept(ModBlocks.FOSSIL_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.FOSSIL_FENCE.get());
                        pOutput.accept(ModBlocks.FOSSIL_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.FOSSIL_WALL.get());

                        pOutput.accept(ModBlocks.FOSSIL_DOOR.get());
                        pOutput.accept(ModBlocks.FOSSIL_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.FOSSIL_LUCKY_BLOCK.get());

                        pOutput.accept(ModItems.FOSSILIZED_DRUMSTICK.get());

                        pOutput.accept(ModItems.FOSSIL_SWORD.get());
                        pOutput.accept(ModItems.FOSSIL_PICKAXE.get());
                        pOutput.accept(ModItems.FOSSIL_AXE.get());
                        pOutput.accept(ModItems.FOSSIL_SHOVEL.get());
                        pOutput.accept(ModItems.FOSSIL_HOE.get());

                        pOutput.accept(ModItems.FOSSIL_HELMET.get());
                        pOutput.accept(ModItems.FOSSIL_CHESTPLATE.get());
                        pOutput.accept(ModItems.FOSSIL_LEGGINGS.get());
                        pOutput.accept(ModItems.FOSSIL_BOOTS.get());

                        pOutput.accept(ModItems.AMETHYST_MODIFIED_FOSSIL_SWORD.get());
                        pOutput.accept(ModItems.BLAZE_ROD_MODIFIED_FOSSIL_PICKAXE.get());
                        pOutput.accept(ModItems.RABBIT_FOOT_MODIFIED_FOSSIL_AXE.get());
                        pOutput.accept(ModItems.NAUTILUS_SHELL_MODIFIED_FOSSIL_SHOVEL.get());
                        pOutput.accept(ModItems.SLIME_BALL_MODIFIED_FOSSIL_HOE.get());
                        pOutput.accept(ModItems.LIGHTNING_ROD_MODIFIED_FOSSIL_HELMET.get());
                        pOutput.accept(ModItems.CLOCK_MODIFIED_FOSSIL_CHESTPLATE.get());
                        pOutput.accept(ModItems.SCUTE_MODIFIED_FOSSIL_LEGGINGS.get());
                        pOutput.accept(ModItems.SCULK_SHARD_MODIFIED_FOSSIL_BOOTS.get());
                        pOutput.accept(ModItems.GOLD_BLOCK_MODIFIED_FOSSILIZED_DRUMSTICK.get());
                        pOutput.accept(ModItems.THE_QUARTZ_MODIFIED_FOSSILS_EYE.get());

                        pOutput.accept(ModItems.RARE_FOSSIL.get());

                        pOutput.accept(ModItems.RARE_FOSSIL_SWORD.get());
                        pOutput.accept(ModItems.RARE_FOSSIL_PICKAXE.get());
                        pOutput.accept(ModItems.RARE_FOSSIL_AXE.get());
                        pOutput.accept(ModItems.RARE_FOSSIL_SHOVEL.get());
                        pOutput.accept(ModItems.RARE_FOSSIL_HOE.get());

                        pOutput.accept(ModItems.RARE_FOSSIL_HELMET.get());
                        pOutput.accept(ModItems.RARE_FOSSIL_CHESTPLATE.get());
                        pOutput.accept(ModItems.RARE_FOSSIL_LEGGINGS.get());
                        pOutput.accept(ModItems.RARE_FOSSIL_BOOTS.get());

                        pOutput.accept(ModBlocks.SUPREME_BRICKS.get());
                        pOutput.accept(ModBlocks.SUPREME_TILES.get());
                        pOutput.accept(ModBlocks.CHISELED_SUPREME_BRICKS.get());
                        pOutput.accept(ModBlocks.SUPREME_PILAR.get());

                        pOutput.accept(ModItems.METATORBERNITE.get());
                        pOutput.accept(ModItems.METATURBONITE.get());
                        pOutput.accept(ModItems.EMPTY_FUEL_CELL.get());

                        pOutput.accept(ModBlocks.METATORBERNITE_BLOCK.get());
                        pOutput.accept(ModBlocks.METATORBERNITE_ORE.get());

                        pOutput.accept(ModItems.METATORBERNITE_HELMET.get());
                        pOutput.accept(ModItems.METATORBERNITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.METATORBERNITE_LEGGINGS.get());
                        pOutput.accept(ModItems.METATORBERNITE_BOOTS.get());

                        pOutput.accept(ModItems.METATORBERNITE_SWORDAXE.get());
                        pOutput.accept(ModItems.METATORBERNITE_TOOL.get());

                        pOutput.accept(ModBlocks.METATORBERNITE_LUCKY_BLOCK.get());

                        pOutput.accept(ModItems.GAS_MASK.get());
                        pOutput.accept(ModItems.METATORBERNITE_GAS_MASK.get());
                        pOutput.accept(ModItems.METATORBERNITE_GRENADE.get());

                        pOutput.accept(ModItems.RAW_LANGRITE.get());
                        pOutput.accept(ModItems.LANGRITE_INGOT.get());
                        pOutput.accept(ModBlocks.LANGRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_LANGRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.LANGRITE_ORE.get());

                        pOutput.accept(ModItems.LANGRITE_SWORD.get());
                        pOutput.accept(ModItems.LANGRITE_PICKAXE.get());
                        pOutput.accept(ModItems.LANGRITE_AXE.get());
                        pOutput.accept(ModItems.LANGRITE_SHOVEL.get());
                        pOutput.accept(ModItems.LANGRITE_HOE.get());
                        pOutput.accept(ModItems.HARVESTER.get());

                        pOutput.accept(ModItems.LANGRITE_HELMET.get());
                        pOutput.accept(ModItems.LANGRITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.LANGRITE_LEGGINGS.get());
                        pOutput.accept(ModItems.LANGRITE_BOOTS.get());

                        pOutput.accept(ModBlocks.LIVING_LANGSTONE.get());
                        pOutput.accept(ModBlocks.LANGSTONE.get());
                        pOutput.accept(ModBlocks.LANGSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.LANGSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.LANGSTONE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_LANGSTONE.get());
                        pOutput.accept(ModBlocks.POLISHED_LANGSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_LANGSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_LANGSTONE_WALL.get());
                        pOutput.accept(ModBlocks.LANGSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.LANGSTONE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.LANGSTONE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.LANGSTONE_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.CHISELED_LANGSTONE.get());
                        pOutput.accept(ModBlocks.CRACKED_LANGSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.LANGSTONE_PILAR.get());

                        pOutput.accept(ModBlocks.DEEP_LANGSTONE.get());
                        pOutput.accept(ModBlocks.DEEP_LANGSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.DEEP_LANGSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.DEEP_LANGSTONE_WALL.get());
                        pOutput.accept(ModBlocks.CHISELED_DEEP_LANGSTONE.get());
                        pOutput.accept(ModBlocks.CRACKED_DEEP_LANGSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.DEEP_LANGSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.DEEP_LANGSTONE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.DEEP_LANGSTONE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.DEEP_LANGSTONE_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_DEEP_LANGSTONE.get());
                        pOutput.accept(ModBlocks.POLISHED_DEEP_LANGSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_DEEP_LANGSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_DEEP_LANGSTONE_WALL.get());

                        pOutput.accept(ModItems.SUNGLASSES.get());

                        pOutput.accept(ModItems.THE_FOSSILS_EYE.get());

                        pOutput.accept(ModItems.COW_HELMET.get());
                        pOutput.accept(ModItems.COW_CHESTPLATE.get());
                        pOutput.accept(ModItems.COW_LEGGINGS.get());
                        pOutput.accept(ModItems.COW_BOOTS.get());

                        pOutput.accept(ModItems.SPIKE.get());
                        pOutput.accept(ModItems.SPIKE_BAT.get());

                        pOutput.accept(ModItems.XANARIAN_SPINE.get());
                        pOutput.accept(ModItems.XANARIAN_HORN.get());
                        pOutput.accept(ModItems.XANARIAN_LEATHER.get());
                        pOutput.accept(ModItems.XANARIAN_SPINE_CHESTPLATE.get());
                        pOutput.accept(ModItems.RAW_XANARIAN_MEAT.get());
                        pOutput.accept(ModItems.XANARIAN_MEAT.get());
                        pOutput.accept(ModItems.XANARIAN_SHISH_KEBAB.get());
                        pOutput.accept(ModItems.XANARIAN_KEBAB_WRAP.get());
                        pOutput.accept(ModItems.XANARIAN_KEBAB.get());
                        pOutput.accept(ModItems.WRAP.get());

                        pOutput.accept(ModItems.UNDYING_WHISPERS_MUSIC_DISC.get());

                        pOutput.accept(ModItems.UNDEADARCHEOLOGIST_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FOSSILIZED_ZOMBIE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.TREE_ZOMBIE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.BIG_WOODLING_SPAWN_EGG.get());
                        pOutput.accept(ModItems.SMALL_WOODLING_SPAWN_EGG.get());
                        pOutput.accept(ModItems.SUPREME_ZOMBIE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.COW_ZOMBIE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.SPIKE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.HAMMER_ZOMBIE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.STRAY_ZOMBIE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FOUR_EYED_XANARIAN_SPAWN_EGG.get());
                        pOutput.accept(ModItems.XANARIAN_SPAWN_EGG.get());
                        pOutput.accept(ModItems.XANARIAN_CANNIBAL_SPAWN_EGG.get());
                        pOutput.accept(ModItems.HORNED_XANARIAN_SPAWN_EGG.get());
                        pOutput.accept(ModItems.SUPREME_KNIGHT_SPAWN_EGG.get());

                        pOutput.accept(ModBlocks.FOSSIL_ALTAR.get());
                        pOutput.accept(ModBlocks.FOSSIL_POLISHER.get());

                        pOutput.accept(ModItems.CALIPO_SAPLING_ITEM.get());
                        pOutput.accept(ModBlocks.CALIPO_LOG.get());
                        pOutput.accept(ModBlocks.CALIPO_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CALIPO_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CALIPO_WOOD.get());
                        pOutput.accept(ModBlocks.CALIPO_PLANKS.get());
                        pOutput.accept(ModBlocks.CALIPO_LEAVES.get());

                        pOutput.accept(ModBlocks.CALIPO_STAIRS.get());
                        pOutput.accept(ModBlocks.CALIPO_SLAB.get());
                        pOutput.accept(ModBlocks.CALIPO_BUTTON.get());
                        pOutput.accept(ModBlocks.CALIPO_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.CALIPO_FENCE.get());
                        pOutput.accept(ModBlocks.CALIPO_FENCE_GATE.get());
                        pOutput.accept(ModItems.CALIPO_SIGN.get());
                        pOutput.accept(ModItems.CALIPO_HANGING_SIGN.get());
                        pOutput.accept(ModBlocks.CALIPO_DOOR.get());
                        pOutput.accept(ModBlocks.CALIPO_TRAPDOOR.get());

                        pOutput.accept(ModItems.CALIPO_BERRIES.get());
                        pOutput.accept(ModItems.XANS_LEAF_SEEDS.get());
                        pOutput.accept(ModItems.XANS_LEAF.get());

                        pOutput.accept(ModBlocks.CALIPO_GRASS.get());    
                        pOutput.accept(ModBlocks.XELKS_FLOWER.get());
                        pOutput.accept(ModBlocks.LYXOR_FLOWER.get());
                        pOutput.accept(ModBlocks.ROXA_FLOWER.get());
                        pOutput.accept(ModBlocks.XANAS_FLOWER.get());
                        pOutput.accept(ModItems.ASH_SAPLING_ITEM.get());
                        pOutput.accept(ModBlocks.ASH_LEAVES.get());

                        pOutput.accept(ModBlocks.ASH_LOG.get());
                        pOutput.accept(ModBlocks.ASH_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_ASH_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_ASH_WOOD.get());
                        pOutput.accept(ModBlocks.ASH_PLANKS.get());

                        pOutput.accept(ModBlocks.ASH_STAIRS.get());
                        pOutput.accept(ModBlocks.ASH_SLAB.get());
                        pOutput.accept(ModBlocks.ASH_BUTTON.get());
                        pOutput.accept(ModBlocks.ASH_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.ASH_FENCE.get());
                        pOutput.accept(ModBlocks.ASH_FENCE_GATE.get());
                        pOutput.accept(ModItems.ASH_SIGN.get());
                        pOutput.accept(ModItems.ASH_HANGING_SIGN.get());
                        pOutput.accept(ModItems.ASH_BOAT.get());
                        pOutput.accept(ModItems.ASH_CHEST_BOAT.get());
                        pOutput.accept(ModBlocks.ASH_DOOR.get());
                        pOutput.accept(ModBlocks.ASH_TRAPDOOR.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
