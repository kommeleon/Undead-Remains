/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.block.entity;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.block.multiblock.metatorberniteenricher.MetatorberniteEnricherBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UndeadRemains.MOD_ID);

        public static final RegistryObject<BlockEntityType<MetatorberniteEnricherBlockEntity>> METATORBERNITE_ENRICHER =
        BLOCK_ENTITIES.register("metatorbernite_enricher",
            () -> BlockEntityType.Builder.of(MetatorberniteEnricherBlockEntity::new,
                    ModBlocks.METATORBERNITE_ENRICHER_CONTROLLER.get())
                    .build(null)
        );

    public static final RegistryObject<BlockEntityType<FossilPolishingStationBlockEntity>> FOSSIL_POLISHING_BE =
            BLOCK_ENTITIES.register("fossil_polishing_be", () ->
                    BlockEntityType.Builder.<FossilPolishingStationBlockEntity>of(FossilPolishingStationBlockEntity::new,
                            ModBlocks.FOSSIL_POLISHER.get()).build(null));


    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.<ModSignBlockEntity>of(ModSignBlockEntity::new,
                            ModBlocks.ASH_SIGN.get(), ModBlocks.ASH_WALL_SIGN.get(),ModBlocks.CALIPO_SIGN.get(), ModBlocks.CALIPO_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.<ModHangingSignBlockEntity>of(ModHangingSignBlockEntity::new,
                            ModBlocks.ASH_HANGING_SIGN.get(), ModBlocks.ASH_WALL_HANGING_SIGN.get(), ModBlocks.CALIPO_HANGING_SIGN.get(), ModBlocks.CALIPO_WALL_HANGING_SIGN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
