package com.tristankechlo.livingthings.client.model.entity;

import java.util.Random;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.tristankechlo.livingthings.client.model.AdvancedEntityModel;
import com.tristankechlo.livingthings.entities.ElephantEntity;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ElephantModel<T extends ElephantEntity> extends AdvancedEntityModel<T> {

	private float[][] currentTrunkAngle = { { 0F, 0F, 0F }, { 0F, 0F, 0F }, { 0F, 0F, 0F } };
	private float[][] targetTrunkAngle = { { 0.17F, 0.17F, 0.17F }, { 0.17F, 0.17F, 0.17F }, { 0.17F, 0.17F, 0.17F } };
	private boolean[][] countUpwards = { { true, true, true }, { true, true, true }, { true, true, true } };

	private final ModelPart Tusks;
	private final ModelPart Body;
	private final ModelPart Chests;
	private final ModelPart Saddle;
	private final ModelPart Head;
	private final ModelPart TrunkTop;
	private final ModelPart TrunkMiddle;
	private final ModelPart TrunkBottom;
	private final ModelPart RightFrontLeg;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightBackLeg;
	private final ModelPart LeftBackLeg;

	public ElephantModel(ModelPart root) {
		this.Tusks = root.getChild("Tusks");
		this.Body = root.getChild("Body");
		this.Chests = root.getChild("Chests");
		this.Saddle = root.getChild("Saddle");
		this.Head = root.getChild("Head");
		this.TrunkTop = root.getChild("TrunkTop");
		this.TrunkMiddle = root.getChild("TrunkMiddle");
		this.TrunkBottom = root.getChild("TrunkBottom");
		this.RightFrontLeg = root.getChild("RightFrontLeg");
		this.LeftFrontLeg = root.getChild("LeftFrontLeg");
		this.RightBackLeg = root.getChild("RightBackLeg");
		this.LeftBackLeg = root.getChild("LeftBackLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tusks = partdefinition.addOrReplaceChild("Tusks", CubeListBuilder.create(),
				PartPose.offset(0.0F, -12.0F, -19.0F));

		PartDefinition LeftTusk = Tusks.addOrReplaceChild("LeftTusk", CubeListBuilder.create(),
				PartPose.offset(7.0F, 6.0F, -10.0F));

		PartDefinition LeftTuskTop = LeftTusk.addOrReplaceChild("LeftTuskTop", CubeListBuilder.create().texOffs(192, 0)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftTuskMiddle = LeftTuskTop.addOrReplaceChild("LeftTuskMiddle",
				CubeListBuilder.create().texOffs(204, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LeftTuskBottom = LeftTuskMiddle
				.addOrReplaceChild("LeftTuskBottom",
						CubeListBuilder.create().texOffs(215, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightTusk = Tusks.addOrReplaceChild("RightTusk", CubeListBuilder.create(),
				PartPose.offset(-7.0F, 6.0F, -10.0F));

		PartDefinition RightTuskTop = RightTusk.addOrReplaceChild("RightTuskTop", CubeListBuilder.create()
				.texOffs(228, 0).addBox(-15.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(14.0F, 0.0F, 0.0F));

		PartDefinition RightTuskMiddle = RightTuskTop.addOrReplaceChild("RightTuskMiddle",
				CubeListBuilder.create().texOffs(238, 0).addBox(-15.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition RightTuskBottom = RightTuskMiddle.addOrReplaceChild(
				"RightTuskBottom", CubeListBuilder.create().texOffs(248, 0).addBox(-15.0F, 0.0F, -1.0F, 2.0F, 5.0F,
						2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 64)
						.addBox(-11.0F, -42.0F, -20.0F, 22.0F, 24.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(156, 93)
						.addBox(-8.0F, -43.0F, -17.0F, 16.0F, 1.0F, 34.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Legs = Body.addOrReplaceChild("Legs", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Front = Legs.addOrReplaceChild("Front", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightFrontLeg = Front.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(68, 0)
				.addBox(-3.0F, 1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -19.0F, -16.0F));

		PartDefinition LeftFrontLeg = Front.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(95, 0)
				.addBox(-3.0F, 1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -19.0F, -16.0F));

		PartDefinition Back = Legs.addOrReplaceChild("Back", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightBackLeg = Back.addOrReplaceChild("RightBackLeg", CubeListBuilder.create().texOffs(122, 0)
				.addBox(-3.0F, 1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -19.0F, 16.0F));

		PartDefinition LeftBackLeg = Back.addOrReplaceChild("LeftBackLeg", CubeListBuilder.create().texOffs(149, 0)
				.addBox(-3.0F, 1.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -19.0F, 16.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(123, 45).addBox(-9.0F, -9.0F, -12.0F, 18.0F, 16.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -36.0F, -20.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition TrunkTop = Head
				.addOrReplaceChild("TrunkTop",
						CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.1F, -4.0F, 8.0F, 10.0F, 8.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition TrunkMiddle = TrunkTop
				.addOrReplaceChild("TrunkMiddle",
						CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, -0.2F, -3.0F, 6.0F, 8.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition TrunkBottom = TrunkMiddle
				.addOrReplaceChild("TrunkBottom",
						CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, 0.7F, -2.0F, 4.0F, 7.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Ears = Head.addOrReplaceChild("Ears", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftEar = Ears.addOrReplaceChild("LeftEar",
				CubeListBuilder.create().texOffs(200, 37).addBox(0.0F, -8.0F, 0.0F, 1.0F, 12.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, -1.0F, -6.0F, 0.1309F, 0.48F, 0.0F));

		PartDefinition RightEar = Ears.addOrReplaceChild("RightEar",
				CubeListBuilder.create().texOffs(200, 37).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 12.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, -1.0F, -6.0F, 0.1309F, -0.48F, 0.0F));

		PartDefinition Chests = partdefinition.addOrReplaceChild("Chests", CubeListBuilder.create().texOffs(54, 38)
				.addBox(11.0F, -37.0F, 9.5F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(54, 38).mirror()
				.addBox(-13.0F, -37.0F, 9.5F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(136, 85).addBox(10.2F, -42.475F, 11.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(136, 85).addBox(-11.2F, -42.475F, 11.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(125, 92).addBox(-8.5F, -43.475F, 11.5F, 17.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition HolderLeft = Chests.addOrReplaceChild("HolderLeft",
				CubeListBuilder.create().texOffs(134, 89).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.6F, -42.5F, 13.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition HolderRight = Chests.addOrReplaceChild("HolderRight",
				CubeListBuilder.create().texOffs(134, 89).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.6F, -42.5F, 13.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Saddle = partdefinition.addOrReplaceChild("Saddle",
				CubeListBuilder.create().texOffs(114, 84)
						.addBox(-6.5F, -44.0F, -7.0F, 13.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(124, 96)
						.addBox(-6.0F, -45.0F, 3.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(136, 85)
						.addBox(-11.2F, -42.475F, -2.0F, 1.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(136, 85)
						.addBox(10.2F, -42.475F, -2.0F, 1.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(144, 90)
						.addBox(-1.5F, -46.0F, -7.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(245, 43)
						.addBox(10.4F, -32.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(245, 43)
						.addBox(-11.4F, -32.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(245, 43)
						.addBox(10.4F, -32.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(245, 43)
						.addBox(-11.4F, -32.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition SaddleRight = Saddle.addOrReplaceChild("SaddleRight",
				CubeListBuilder.create().texOffs(130, 84).addBox(-2.5492F, -0.0726F, -0.5F, 5.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.625F, -43.175F, -1.5F, 0.0F, 0.0F, -0.3054F));

		PartDefinition SaddleLeft = Saddle.addOrReplaceChild("SaddleLeft",
				CubeListBuilder.create().texOffs(130, 84).addBox(-2.5492F, -0.0726F, -0.5F, 5.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.725F, -43.15F, -1.5F, 0.0F, 0.0F, 0.3054F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {

		if (this.young) {
			matrixStack.scale(0.6F, 0.6F, 0.6F);
			matrixStack.translate(0, 1, 0);
		} else {
			Tusks.render(matrixStack, buffer, packedLight, packedOverlay);
		}
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Chests.render(matrixStack, buffer, packedLight, packedOverlay);
		Saddle.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	@Override
	public void setupAnim(ElephantEntity elephant, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

		this.Head.xRot = headPitch * 0.0174532925F;
		this.Tusks.xRot = headPitch * 0.0174532925F;
		this.Head.yRot = netHeadYaw * 0.0174532925F;
		this.Tusks.yRot = netHeadYaw * 0.0174532925F;

		this.walk(RightFrontLeg, LeftFrontLeg, RightBackLeg, LeftBackLeg, limbSwing, limbSwingAmount);

		this.TrunkTop.xRot = this.currentTrunkAngle[0][0];
		this.TrunkTop.yRot = this.currentTrunkAngle[0][1];
		this.TrunkTop.zRot = this.currentTrunkAngle[0][2];

		this.TrunkMiddle.xRot = this.currentTrunkAngle[1][0];
		this.TrunkMiddle.yRot = this.currentTrunkAngle[1][1];
		this.TrunkMiddle.zRot = this.currentTrunkAngle[1][2];

		this.TrunkBottom.xRot = this.currentTrunkAngle[2][0];
		this.TrunkBottom.yRot = this.currentTrunkAngle[2][1];
		this.TrunkBottom.zRot = this.currentTrunkAngle[2][2];

	}

	@Override
	public void prepareMobModel(ElephantEntity elephant, float limbSwing, float limbSwingAmount, float partialTick) {
		if (partialTick > 0.5F) {
			setTrunkAngle();
		}
		int i = elephant.getAttackTimer();
		if (i > 0) {
			this.Head.xRot = 1.7F * Mth.triangleWave((float) i - partialTick, 10.0F);
			this.Tusks.xRot = 1.7F * Mth.triangleWave((float) i - partialTick, 10.0F);
		}
		this.Chests.visible = elephant.hasChest();
		this.Saddle.visible = elephant.isSaddled();

	}

	private void setTrunkAngle() {
		float[] offset = { 0.0025F, 0.001F, 0.0025F };

		for (int part = 0; part < this.currentTrunkAngle.length; part++) {
			for (int axis = 0; axis < this.currentTrunkAngle[part].length; axis++) {

				if (this.countUpwards[part][axis] == true) {

					this.currentTrunkAngle[part][axis] += offset[axis];

					if (this.currentTrunkAngle[part][axis] > this.targetTrunkAngle[part][axis]) {
						this.targetTrunkAngle[part][axis] = (float) (0 - ((new Random().nextFloat() * 0.1F) + 0.1F));
						this.countUpwards[part][axis] = false;
					}

					continue;
				} else if (this.countUpwards[part][axis] == false) {

					this.currentTrunkAngle[part][axis] -= offset[axis];

					if (this.currentTrunkAngle[part][axis] < this.targetTrunkAngle[part][axis]) {
						this.targetTrunkAngle[part][axis] = (float) ((new Random().nextFloat() * 0.1F) + 0.1F);
						this.countUpwards[part][axis] = true;
					}

					continue;
				}
			}
		}
	}

}
