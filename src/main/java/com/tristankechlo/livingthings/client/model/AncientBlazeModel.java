package com.tristankechlo.livingthings.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.tristankechlo.livingthings.entities.AncientBlazeEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AncientBlazeModel <T extends AncientBlazeEntity> extends EntityModel<T> {

	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Helmet;
	private final ModelRenderer Crystal;
	private final ModelRenderer Shields;
	private final ModelRenderer ShieldOne;
	private final ModelRenderer ShieldTwo;
	private final ModelRenderer ShieldThree;
	private final ModelRenderer ShieldFour;
	private final ModelRenderer Sticks;
	private final ModelRenderer StickOne;
	private final ModelRenderer StickTwo;
	private final ModelRenderer StickThree;
	private final ModelRenderer StickFour;
	private final ModelRenderer StickFive;
	private final ModelRenderer StickSix;

	public AncientBlazeModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 11.0F, 0.0F);
		Body.setTextureOffset(25, 24).addBox(-2.5F, -22.0F, -2.5F, 5.0F, 35.0F, 5.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.5F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Helmet = new ModelRenderer(this);
		Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Helmet);
		Helmet.setTextureOffset(33, 0).addBox(3.5F, -9.5F, -4.5F, 1.0F, 10.0F, 2.0F, 0.0F, false);
		Helmet.setTextureOffset(9, 17).addBox(-3.5F, -8.5F, -4.5F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(9, 22).addBox(-2.5F, -9.5F, -4.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(16, 22).addBox(0.5F, -9.5F, -4.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(23, 22).addBox(-3.5F, -10.5F, -4.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(9, 25).addBox(1.5F, -10.5F, -4.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(16, 25).addBox(0.5F, -11.5F, -4.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(23, 25).addBox(-2.5F, -11.5F, -4.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(9, 28).addBox(-1.5F, -12.5F, -4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(33, 13).addBox(1.5F, -3.5F, -4.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(40, 13).addBox(-3.5F, -3.5F, -4.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(40, 0).addBox(-4.5F, -9.5F, -4.5F, 1.0F, 10.0F, 2.0F, 0.0F, false);
		Helmet.setTextureOffset(0, 33).addBox(-2.5F, -8.5F, 3.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(0, 36).addBox(-2.5F, -0.5F, 3.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(47, 13).addBox(2.5F, -9.5F, 3.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(47, 25).addBox(-3.5F, -9.5F, 3.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(18, 28).addBox(-2.5F, -4.5F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(33, 19).addBox(-0.5F, -7.5F, 3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(38, 19).addBox(-0.5F, -2.5F, 3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(47, 37).addBox(-1.5F, -6.5F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(47, 44).addBox(0.5F, -6.5F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(41, 24).addBox(1.5F, -4.5F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(52, 29).addBox(3.5F, -1.5F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
		Helmet.setTextureOffset(52, 21).addBox(3.5F, -8.5F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
		Helmet.setTextureOffset(52, 13).addBox(-4.5F, -8.5F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
		Helmet.setTextureOffset(46, 51).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Helmet.setTextureOffset(0, 39).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Helmet.setTextureOffset(47, 0).addBox(3.5F, -9.5F, 2.5F, 1.0F, 10.0F, 2.0F, 0.0F, false);
		Helmet.setTextureOffset(54, 0).addBox(-4.5F, -9.5F, 2.5F, 1.0F, 10.0F, 2.0F, 0.0F, false);
		Helmet.setTextureOffset(7, 40).addBox(-4.5F, -10.5F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(13, 31).addBox(3.5F, -10.5F, 3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(13, 34).addBox(3.5F, -5.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(18, 34).addBox(-4.5F, -5.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(46, 55).addBox(3.5F, -5.5F, -0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Helmet.setTextureOffset(46, 60).addBox(-4.5F, -5.5F, -0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Helmet.setTextureOffset(52, 37).addBox(-4.5F, -1.5F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
		Helmet.setTextureOffset(52, 45).addBox(3.5F, -13.5F, -4.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(57, 45).addBox(-4.5F, -13.5F, -4.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(53, 51).addBox(2.5F, -15.5F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Helmet.setTextureOffset(58, 51).addBox(-3.5F, -15.5F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Crystal = new ModelRenderer(this);
		Crystal.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Crystal);
		Crystal.setTextureOffset(25, 2).addBox(-1.5F, -11.5F, -4.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		Crystal.setTextureOffset(27, 6).addBox(-3.5F, -9.5F, -4.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Crystal.setTextureOffset(27, 6).addBox(2.5F, -9.5F, -4.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		Shields = new ModelRenderer(this);
		Shields.setRotationPoint(0.0F, -22.0F, 0.0F);
		Body.addChild(Shields);
		setRotationAngle(Shields, 0.0F, -0.7854F, 0.0F);
		

		ShieldOne = new ModelRenderer(this);
		ShieldOne.setRotationPoint(0.0F, 0.0F, -7.5F);
		Shields.addChild(ShieldOne);
		setRotationAngle(ShieldOne, -0.3491F, 0.0F, 0.0F);
		ShieldOne.setTextureOffset(0, 43).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 19.0F, 2.0F, 0.0F, false);

		ShieldTwo = new ModelRenderer(this);
		ShieldTwo.setRotationPoint(-7.5F, 0.0F, 0.0F);
		Shields.addChild(ShieldTwo);
		setRotationAngle(ShieldTwo, -0.3491F, 1.5708F, 0.0F);
		ShieldTwo.setTextureOffset(0, 43).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 19.0F, 2.0F, 0.0F, false);

		ShieldThree = new ModelRenderer(this);
		ShieldThree.setRotationPoint(0.0F, 0.0F, 7.5F);
		Shields.addChild(ShieldThree);
		setRotationAngle(ShieldThree, -0.3491F, 3.1416F, 0.0F);
		ShieldThree.setTextureOffset(0, 43).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 19.0F, 2.0F, 0.0F, false);

		ShieldFour = new ModelRenderer(this);
		ShieldFour.setRotationPoint(7.5F, 0.0F, 0.0F);
		Shields.addChild(ShieldFour);
		setRotationAngle(ShieldFour, -0.3491F, -1.5708F, 0.0F);
		ShieldFour.setTextureOffset(0, 43).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 19.0F, 2.0F, 0.0F, false);

		Sticks = new ModelRenderer(this);
		Sticks.setRotationPoint(0.0F, 5.0F, 0.0F);
		Body.addChild(Sticks);
		

		StickOne = new ModelRenderer(this);
		StickOne.setRotationPoint(-8.0F, 0.0F, 0.0F);
		Sticks.addChild(StickOne);
		StickOne.setTextureOffset(0, 18).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		StickTwo = new ModelRenderer(this);
		StickTwo.setRotationPoint(-4.0F, 0.0F, 6.928F);
		Sticks.addChild(StickTwo);
		StickTwo.setTextureOffset(0, 18).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		StickThree = new ModelRenderer(this);
		StickThree.setRotationPoint(4.0F, 0.0F, 6.928F);
		Sticks.addChild(StickThree);
		StickThree.setTextureOffset(0, 18).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		StickFour = new ModelRenderer(this);
		StickFour.setRotationPoint(8.0F, 0.0F, 0.0F);
		Sticks.addChild(StickFour);
		StickFour.setTextureOffset(0, 18).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		StickFive = new ModelRenderer(this);
		StickFive.setRotationPoint(4.0F, 0.0F, -6.928F);
		Sticks.addChild(StickFive);
		StickFive.setTextureOffset(0, 18).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		StickSix = new ModelRenderer(this);
		StickSix.setRotationPoint(-4.0F, 0.0F, -6.928F);
		Sticks.addChild(StickSix);
		StickSix.setTextureOffset(0, 18).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,	float netHeadYaw, float headPitch) {
		this.Head.rotateAngleY = netHeadYaw * 0.017453F;
	    this.Head.rotateAngleX = headPitch * 0.017453F;
	    
	    this.Sticks.rotateAngleY = ageInTicks / 15;
	    this.Shields.rotateAngleY = -ageInTicks / 50;
	    
	    float speed = 0.3F;	    
	    this.StickOne.rotationPointY = MathHelper.cos((3F + ageInTicks) * speed);
	    this.StickTwo.rotationPointY = MathHelper.cos((6F + ageInTicks) * speed);
	    this.StickThree.rotationPointY = MathHelper.cos((9F + ageInTicks) * speed);
	    this.StickFour.rotationPointY = MathHelper.cos((12F + ageInTicks) * speed);
	    this.StickFive.rotationPointY = MathHelper.cos((15F + ageInTicks) * speed);
	    this.StickSix.rotationPointY = MathHelper.cos((18F + ageInTicks) * speed);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}
