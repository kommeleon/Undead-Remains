/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.entity.client.DrownedSkeleton;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.diverginglensestudios.undeadremains.entity.animations.ModSkeletonAnimations;
import net.diverginglensestudios.undeadremains.entity.custom.Skeletons.DrownedSkeletonEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class DrownedSkeletonModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "drowned_skeleton"), "main");
	private final ModelPart DrownedSkeleton;
	private final ModelPart head;


	public DrownedSkeletonModel(ModelPart root) {
		this.DrownedSkeleton = root.getChild("drowned_skeleton");
		this.head = this.DrownedSkeleton.getChild("body").getChild("torso").getChild("head");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition drowned_skeleton = partdefinition.addOrReplaceChild("drowned_skeleton", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = drowned_skeleton.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(32, 12).addBox(-4.0F, -12.0F, -5.0F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.01F))
				.texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 32).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(-0.01F))
				.texOffs(32, 22).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(-5.0F, -10.0F, 0.0F));

		PartDefinition left_arm = torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(24, 32).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false)
				.texOffs(32, 22).mirror().addBox(-1.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(5.0F, -10.0F, 0.0F));

		PartDefinition conduit = torso.addOrReplaceChild("conduit", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, -8.0F, -1.0F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(32, 31).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.1F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 31).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.1F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModSkeletonAnimations.DROWNED_SKELETON_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		DrownedSkeleton.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return DrownedSkeleton;
	}
}