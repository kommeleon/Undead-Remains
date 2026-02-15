/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.Xanaranha;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.diverginglensestudios.undeadremains.entity.animations.ModAnimationDefinitions;
import net.diverginglensestudios.undeadremains.entity.animations.ModFishAnimations;
import net.diverginglensestudios.undeadremains.entity.custom.Fish.XanaranhaEntity;
import net.diverginglensestudios.undeadremains.entity.custom.Xanarians.XanarianEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class XanaranhaModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "xanaranha"), "main");
	private final ModelPart Xanaranha;
	private final ModelPart head;
	private final ModelPart tail;


	public XanaranhaModel(ModelPart root) {
		this.Xanaranha = root.getChild("Xanaranha");
		this.head = this.Xanaranha.getChild("torso").getChild("head");
		this.tail = this.Xanaranha.getChild("tail");

	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Xanaranha = partdefinition.addOrReplaceChild("Xanaranha", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 9.5F));

		PartDefinition torso = Xanaranha.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -17.0F, 8.0F, 18.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 1.5F));

		PartDefinition fin_left = torso.addOrReplaceChild("fin_left", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, -4.0F, -1.0F, 1.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, -13.0F));

		PartDefinition fin_right = torso.addOrReplaceChild("fin_right", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-1.0F, -4.0F, -1.0F, 1.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, -13.0F));

		PartDefinition back_fin = torso.addOrReplaceChild("back_fin", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -9.0F));

		PartDefinition cube_r1 = back_fin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 55).addBox(-0.5F, -4.0F, -6.0F, 1.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, -17.0F));

		PartDefinition head_left = head.addOrReplaceChild("head_left", CubeListBuilder.create().texOffs(30, 35).addBox(0.0F, -6.0F, -10.0F, 3.0F, 10.0F, 10.0F, new CubeDeformation(0.01F))
				.texOffs(68, 52).addBox(0.0F, -8.0F, -10.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.01F))
				.texOffs(50, 20).addBox(0.0F, 4.0F, -11.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.01F))
				.texOffs(46, 55).addBox(-2.0F, -5.0F, -9.0F, 2.0F, 9.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head_right = head.addOrReplaceChild("head_right", CubeListBuilder.create().texOffs(30, 35).mirror().addBox(-3.0F, -6.0F, -10.0F, 3.0F, 10.0F, 10.0F, new CubeDeformation(0.01F)).mirror(false)
				.texOffs(68, 52).mirror().addBox(-3.0F, -8.0F, -10.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.01F)).mirror(false)
				.texOffs(50, 20).mirror().addBox(-4.0F, 4.0F, -11.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.01F)).mirror(false)
				.texOffs(56, 34).addBox(0.0F, -5.0F, -9.0F, 2.0F, 9.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = Xanaranha.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 9.0F, 11.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, -16.0F, 1.5F));

		PartDefinition tail_fin = tail.addOrReplaceChild("tail_fin", CubeListBuilder.create().texOffs(26, 55).addBox(-0.5F, -8.5F, -2.0F, 1.0F, 17.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 9.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		float f = 1.0F;
		float f1 = 1.0F;
		if (!pEntity.isInWater()) {
			f = 1.3F;
			f1 = 1.7F;
		}
		this.tail.yRot = -f * 0.25F * Mth.sin(f1 * 0.6F * pAgeInTicks);
		//this.animate(((XanaranhaEntity) pEntity).attackAnimationState, ModFishAnimations.XANARANHA_ATTACK, pAgeInTicks, 1f);

	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Xanaranha.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Xanaranha;
	}
}