/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.DrownedSkeleton;

import com.mojang.blaze3d.vertex.PoseStack;
import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.diverginglensestudios.undeadremains.entity.client.ModModelLayers;
import net.diverginglensestudios.undeadremains.entity.custom.Skeletons.DrownedSkeletonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DrownedSkeletonRenderer extends MobRenderer<DrownedSkeletonEntity, DrownedSkeletonModel<DrownedSkeletonEntity>> {
	public DrownedSkeletonRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new DrownedSkeletonModel<>(pContext.bakeLayer(ModModelLayers.DROWNED_SKELETON_LAYER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DrownedSkeletonEntity pEntity) {
		return new ResourceLocation(UndeadRemains.MOD_ID, "textures/entity/drowned_skeleton.png");
	}

	@Override
	public void render(DrownedSkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
					   MultiBufferSource pBuffer, int pPackedLight) {


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}