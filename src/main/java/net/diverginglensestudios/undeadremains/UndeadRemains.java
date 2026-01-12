package net.diverginglensestudios.undeadremains; //This line of code specifies what the code is actually doing, and how it is called

//Import the stuff you need from the core game and from Forge and other Logging tools.
import com.mojang.logging.LogUtils;

import net.diverginglensestudios.undeadremains.block.ModBlocks;
import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.diverginglensestudios.undeadremains.effects.ModEffects;
import net.diverginglensestudios.undeadremains.effects.ModPotions;
import net.diverginglensestudios.undeadremains.entity.ModEntities;
import net.diverginglensestudios.undeadremains.entity.client.*;
import net.diverginglensestudios.undeadremains.entity.client.BigWoodling.BigWoodlingRenderer;
import net.diverginglensestudios.undeadremains.entity.client.Cm_Falling_Block.Cm_Falling_Block_Renderer;
import net.diverginglensestudios.undeadremains.entity.client.CowZombie.CowZombieRenderer;
import net.diverginglensestudios.undeadremains.entity.client.FossilizedZombie.FossilizedZombieRenderer;
import net.diverginglensestudios.undeadremains.entity.client.FourEyedXanarian.FourEyedXanarianRenderer;
import net.diverginglensestudios.undeadremains.entity.client.HammerZombie.HammerZombieRenderer;
import net.diverginglensestudios.undeadremains.entity.client.SahnUzal.SahnUzalRenderer;
import net.diverginglensestudios.undeadremains.entity.client.SmallWoodling.SmallWoodlingRenderer;
import net.diverginglensestudios.undeadremains.entity.client.Spike.SpikeRenderer;
import net.diverginglensestudios.undeadremains.entity.client.StrayZombie.StrayZombieRenderer;
import net.diverginglensestudios.undeadremains.entity.client.SupremeKnight.SupremeKnightRenderer;
import net.diverginglensestudios.undeadremains.entity.client.SupremeZombie.SupremeZombieRenderer;
import net.diverginglensestudios.undeadremains.entity.client.TreeZombie.TreeZombieRenderer;
import net.diverginglensestudios.undeadremains.entity.client.UndeadArcheologist.UndeadArcheologistRenderer;
import net.diverginglensestudios.undeadremains.entity.client.Xanarian.XanarianRenderer;
import net.diverginglensestudios.undeadremains.entity.client.XanarianCannibal.XanarianCannibalRenderer;
import net.diverginglensestudios.undeadremains.entity.client.horned_xanarian.HornedXanarianRenderer;
import net.diverginglensestudios.undeadremains.item.ModCreativeModTabs;
import net.diverginglensestudios.undeadremains.item.ModItems;
import net.diverginglensestudios.undeadremains.loot.ModLootTableModifiers;
import net.diverginglensestudios.undeadremains.particles.MetatorberniteParticles;
import net.diverginglensestudios.undeadremains.particles.ModParticles;
import net.diverginglensestudios.undeadremains.recipe.ModRecipes;
import net.diverginglensestudios.undeadremains.screen.GemPolishingStationScreen;
import net.diverginglensestudios.undeadremains.screen.MetatorberniteEnricherScreen;
import net.diverginglensestudios.undeadremains.screen.ModMenuTypes;
import net.diverginglensestudios.undeadremains.sound.ModSounds;
import net.diverginglensestudios.undeadremains.util.BetterBrewingRecipe;
import net.diverginglensestudios.undeadremains.util.ModWoodTypes;
import net.diverginglensestudios.undeadremains.worldgen.biome.ModOverworldRegion;
import net.diverginglensestudios.undeadremains.worldgen.biome.surface.ModSurfaceRules;
import net.diverginglensestudios.undeadremains.worldgen.tree.ModFoliagePlacers;
import net.diverginglensestudios.undeadremains.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import org.slf4j.Logger;

/*
This is a multi line comment
*/

@Mod(UndeadRemains.MOD_ID) // The value here should match an entry in the META-INF/mods.toml file
public class UndeadRemains { // Define the Class for the Mod
        public static final String MOD_ID = "undeadremains"; // Set the name, so forge recognizes and can access the
                                                             // mod.
        public static final Logger LOGGER = LogUtils.getLogger();

        public UndeadRemains() {
                IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

                ModCreativeModTabs.register(modEventBus);

                ModItems.register(modEventBus);
                ModBlocks.register(modEventBus);

                ModLootTableModifiers.register(modEventBus);
                // ModTerrablender.registerBiomes();

                ModSounds.register(modEventBus);
                ModEntities.register(modEventBus);

                ModBlockEntities.register(modEventBus);
                ModMenuTypes.register(modEventBus);

                ModRecipes.register(modEventBus);
                ModParticles.register(modEventBus);

                ModEffects.register(modEventBus);
                ModPotions.register(modEventBus);

                ModFoliagePlacers.register(modEventBus);
                ModTrunkPlacerTypes.register(modEventBus);

                modEventBus.addListener(this::commonSetup);

                MinecraftForge.EVENT_BUS.register(this);
                // modEventBus.addListener(this::addCreative);
        }

        private void commonSetup(final FMLCommonSetupEvent event) {
                event.enqueueWork(() -> {
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ROXA_FLOWER.getId(), ModBlocks.POTTED_ROXA_FLOWER);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.XANAS_FLOWER.getId(), ModBlocks.POTTED_XANAS_FLOWER);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.XELKS_FLOWER.getId(), ModBlocks.POTTED_XELKS_FLOWER);
                        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                                        ModItems.FOSSIL.get(), ModPotions.FOSSILIZED_HEART_POTION.get()));
                        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID,
                                        ModSurfaceRules.makeRules());
                        Regions.register(new ModOverworldRegion(new ResourceLocation(UndeadRemains.MOD_ID, "overworld"),
                                        2));
                });
        }

        // private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        // event.accept(ModItems.FOSSIL);
        // event.accept(ModItems.RAW_FOSSIL);
        // }
        // }

        // You can use SubscribeEvent and let the Event Bus discover methods to call
        @SubscribeEvent
        public void onServerStarting(ServerStartingEvent event) {

        }

        // You can use EventBusSubscriber to automatically register all static methods
        // in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
                @SubscribeEvent
                public static void onClientSetup(FMLClientSetupEvent event) {
                        Sheets.addWoodType(ModWoodTypes.ASH);
                        EntityRenderers.register(ModEntities.XANARIAN_CANNIBAL.get(),
                                        pContext -> new XanarianCannibalRenderer(pContext));
                        EntityRenderers.register(ModEntities.UNDEAD_ARCHEOLOGIST.get(),
                                        pContext -> new UndeadArcheologistRenderer(pContext));
                        EntityRenderers.register(ModEntities.BIG_WOODLING.get(),
                                        pContext -> new BigWoodlingRenderer(pContext));
                        EntityRenderers.register(ModEntities.SMALL_WOODLING.get(),
                                        pContext -> new SmallWoodlingRenderer(pContext));
                        EntityRenderers.register(ModEntities.STRAY_ZOMBIE.get(),
                                        pContext -> new StrayZombieRenderer(pContext));
                        EntityRenderers.register(ModEntities.TREE_ZOMBIE.get(),
                                        pContext -> new TreeZombieRenderer(pContext));
                        EntityRenderers.register(ModEntities.SUPREME_KNIGHT.get(),
                                        pContext -> new SupremeKnightRenderer(pContext));
                        EntityRenderers.register(ModEntities.SAHN_UZAL.get(),
                                        pContext -> new SahnUzalRenderer(pContext));
                        EntityRenderers.register(ModEntities.FOSSILIZED_ZOMBIE.get(),
                                        pContext -> new FossilizedZombieRenderer(pContext));
                        EntityRenderers.register(ModEntities.SUPREME_ZOMBIE.get(),
                                        pContext -> new SupremeZombieRenderer(pContext));
                        EntityRenderers.register(ModEntities.COW_ZOMBIE.get(),
                                        pContext -> new CowZombieRenderer(pContext));
                        EntityRenderers.register(ModEntities.SPIKE.get(), pContext -> new SpikeRenderer(pContext));
                        EntityRenderers.register(ModEntities.HAMMER_ZOMBIE.get(),
                                        pContext -> new HammerZombieRenderer(pContext));
                        EntityRenderers.register(ModEntities.FOUR_EYED_XANARIAN.get(),
                                        pContext -> new FourEyedXanarianRenderer(pContext));
                        EntityRenderers.register(ModEntities.XANARIAN.get(),
                                        pContext -> new XanarianRenderer(pContext));
                        EntityRenderers.register(ModEntities.HORNED_XANARIAN.get(),
                                        pContext -> new HornedXanarianRenderer(pContext));
                        EntityRenderers.register(ModEntities.MOD_BOAT.get(),
                                        pContext -> new ModBoatRenderer(pContext, false));
                        EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(),
                                        pContext -> new ModBoatRenderer(pContext, true));
                        EntityRenderers.register(ModEntities.CM_FALLING_BLOCK.get(),
                                        pContext -> new Cm_Falling_Block_Renderer(pContext));
                        EntityRenderers.register(ModEntities.CUSTOMEFFECTCLOUD.get(),
                                        pContext -> new NoopRenderer(pContext));
                        EntityRenderers.register(ModEntities.METATORBERNITE_GRENADE_PROJECTILE.get(),
                                        ThrownItemRenderer::new);
                        MenuScreens.register(ModMenuTypes.GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
                        MenuScreens.register(ModMenuTypes.METATORBERNITE_ENRICHER_MENU.get(), MetatorberniteEnricherScreen::new);
                }

                @SubscribeEvent
                public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
                        event.registerSpriteSet(ModParticles.METATORBERNITE_PARTICLES.get(),
                                        MetatorberniteParticles.Provider::new);
                }
        }
}
