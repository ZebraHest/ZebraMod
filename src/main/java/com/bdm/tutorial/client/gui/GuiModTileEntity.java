package com.bdm.tutorial.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import com.bdm.tutorial.guicontainer.ContainerModTileEntity;
import com.bdm.tutorial.tileentity.ModTileEntity;

public class GuiModTileEntity extends GuiContainer {

	protected ModTileEntity te;
	protected IInventory playerInv;
	
	public GuiModTileEntity(IInventory playerInv, ModTileEntity te) {
		super(new ContainerModTileEntity(playerInv, te));

		this.playerInv = playerInv;
		this.te = te;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("tutorial:textures/gui/container/mod_tile_entity.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.te.getDisplayName() == null ? "" : this.te.getDisplayName().getUnformattedComponentText();
		this.fontRendererObj.drawString(s, 88-this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInv.getDisplayName() == null ? "" : this.playerInv.getDisplayName().getUnformattedComponentText(), 8, 72, 4210752);
	}

}
