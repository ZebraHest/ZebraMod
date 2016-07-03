package com.zebrahest.zebramod;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class GuiFindingRod extends GuiContainer {

	public GuiFindingRod(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void drawCenteredString(FontRenderer fontRendererIn, String text,
			int x, int y, int color) {
		//draw text and stuff here
		//the parameters for drawString are: string, x, y, color
		fontRendererIn.drawString("Tiny", 8, 6, 4210752);
		//draws "Inventory" or your regional equivalent
//		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

}
