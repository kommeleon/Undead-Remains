/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.event;

// Import Mod Elements
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.block.entity.ModBlockEntities;
import net.diverginglensestudios.undeadremains.block.entity.renderer.FossilPolisherBlockEntityRenderer;
import net.diverginglensestudios.undeadremains.entity.client.DrownedSkeleton.DrownedSkeletonModel;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.client.BigWoodling.BigWoodlingModel;
import net.diverginglensestudios.undeadremains.entity.client.CowZombie.CowZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.FossilizedZombie.FossilizedZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.FourEyedXanarian.FourEyedXanarianModel;
import net.diverginglensestudios.undeadremains.entity.client.HammerZombie.HammerZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.SahnUzal.SahnUzalModel;
import net.diverginglensestudios.undeadremains.entity.client.SmallWoodling.SmallWoodlingModel;
import net.diverginglensestudios.undeadremains.entity.client.Spike.SpikeModel;
import net.diverginglensestudios.undeadremains.entity.client.StrayZombie.StrayZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.Sucker.SuckerModel;
import net.diverginglensestudios.undeadremains.entity.client.SupremeKnight.SupremeKnightModel;
import net.diverginglensestudios.undeadremains.entity.client.SupremeZombie.SupremeZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.TreeZombie.TreeZombieModel;
import net.diverginglensestudios.undeadremains.entity.client.UndeadArcheologist.UndeadArcheologistModel;
import net.diverginglensestudios.undeadremains.entity.client.Xanaranha.XanaranhaModel;
import net.diverginglensestudios.undeadremains.entity.client.Xanarian.XanarianModel;
import net.diverginglensestudios.undeadremains.entity.client.XanarianCannibal.XanarianCannibalModel;
import net.diverginglensestudios.undeadremains.entity.client.horned_xanarian.HornedXanarianModel;

// Import Minecraft and Forge Elements
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UndeadRemains.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
	@SubscribeEvent
	public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModModelLayers.UNDEAD_ARCHEOLOGIST_LAYER, UndeadArcheologistModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.XANARIAN_CANNIBAL_LAYER, XanarianCannibalModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.TREE_ZOMBIE_LAYER, TreeZombieModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.SUPREME_KNIGHT_LAYER, SupremeKnightModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.SAHN_UZAL_LAYER, SahnUzalModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.FOSSILIZED_ZOMBIE_LAYER, FossilizedZombieModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.STRAY_ZOMBIE_LAYER, StrayZombieModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.SUPREME_ZOMBIE_LAYER, SupremeZombieModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.COW_ZOMBIE_LAYER, CowZombieModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.SPIKE_LAYER, SpikeModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.HAMMER_ZOMBIE_LAYER, HammerZombieModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.FOUR_EYED_XANARIAN_LAYER, FourEyedXanarianModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.XANARIAN_LAYER, XanarianModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.HORNED_XANARIAN_LAYER, HornedXanarianModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.XANARANHA_LAYER, XanaranhaModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.SUCKER_LAYER, SuckerModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.BIG_WOODLING_LAYER, BigWoodlingModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.SMALL_WOODLING_LAYER, SmallWoodlingModel::createBodyLayer);
		event.registerLayerDefinition(ModModelLayers.DROWNED_SKELETON_LAYER, DrownedSkeletonModel::createBodyLayer);

		event.registerLayerDefinition(ModModelLayers.PINE_BOAT_LAYER, BoatModel::createBodyModel);
		event.registerLayerDefinition(ModModelLayers.PINE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
	}

	@SubscribeEvent
	public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntities.FOSSIL_POLISHING_BE.get(), FossilPolisherBlockEntityRenderer::new);

		event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
		event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
	}


}
