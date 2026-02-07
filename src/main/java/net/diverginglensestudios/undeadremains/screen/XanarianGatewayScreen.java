/***********************************************************/
/*       This file is part of the UndeadRemains Mod        */
/*      which is maintained by DivergingLense Studios      */
/*          and is published under the MIT License         */
/* https://github.com/DivergingLenseStudios/Undead-Remains */
/***********************************************************/

package net.diverginglensestudios.undeadremains.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.diverginglensestudios.undeadremains.UndeadRemains;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class XanarianGatewayScreen extends AbstractContainerScreen<XanarianGatewayMenu> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(UndeadRemains.MOD_ID,
			"textures/gui/xanarian_gateway_screen.png");

	public XanarianGatewayScreen(XanarianGatewayMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
	}

	@Override
	protected void init() {
		super.init();
		this.inventoryLabelY = 10000;
		this.titleLabelY = 10000;
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - imageWidth) / 2;
		int y = (height - imageHeight) / 2;

		guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

		renderProgressArrow(guiGraphics, x, y);
		renderChargeBar(guiGraphics, x, y);
	}

	private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
		if (menu.isCrafting()) {
			guiGraphics.blit(TEXTURE, x + 58, y + 36   // screen position
				,176, 0,				 // texture UV
				8, menu.getScaledProgress());	// width, height
		}
	}
	private void renderChargeBar(GuiGraphics guiGraphics, int x, int y) {
    int filled = menu.getScaledCharge();

    // Draw bottom-up
    guiGraphics.blit(TEXTURE,
            x + 134, y + 12 + (60 - filled),   			// screen position
            187, 0 + (60 - filled),           // texture UV
            25, filled);                       // width, height
}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
		renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, delta);
		renderTooltip(guiGraphics, mouseX, mouseY);
	}
}
