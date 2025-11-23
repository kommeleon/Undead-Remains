/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.item.armor.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class LightningRodModifiedFossilHelmetModel extends ArmorModel {

	public LightningRodModifiedFossilHelmetModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition armorHead = partdefinition.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.6F))
		.texOffs(32, 0).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-2.0F, -16.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.8F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armorBody = partdefinition.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition armorLeftArm = partdefinition.addOrReplaceChild("armorLeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition armorRightArm = partdefinition.addOrReplaceChild("armorRightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition armorLeftLeg = partdefinition.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition armorRightLeg = partdefinition.addOrReplaceChild("armorRightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition armorLeftBoot = partdefinition.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition armorRightBoot = partdefinition.addOrReplaceChild("armorRightBoot", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}