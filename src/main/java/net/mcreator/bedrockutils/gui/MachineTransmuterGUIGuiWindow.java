
package net.mcreator.bedrockutils.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.bedrockutils.procedures.TransmutProgressBar6Procedure;
import net.mcreator.bedrockutils.procedures.TransmutProgressBar5Procedure;
import net.mcreator.bedrockutils.procedures.TransmutProgressBar4Procedure;
import net.mcreator.bedrockutils.procedures.TransmutProgressBar3Procedure;
import net.mcreator.bedrockutils.procedures.TransmutProgressBar2Procedure;
import net.mcreator.bedrockutils.procedures.TransmutProgressBar1Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar9Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar8Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar7Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar6Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar5Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar4Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar3Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar2Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar1Procedure;
import net.mcreator.bedrockutils.procedures.EnergyProgressBar10Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class MachineTransmuterGUIGuiWindow extends ContainerScreen<MachineTransmuterGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public MachineTransmuterGUIGuiWindow(MachineTransmuterGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 180;
		this.ySize = 205;
	}
	private static final ResourceLocation texture = new ResourceLocation("bedrockutils:textures/machine_transmuter_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/transmutprogressbar_0.png"));
		this.blit(ms, this.guiLeft + 44, this.guiTop + 37, 0, 0, 90, 6, 90, 6);
		if (TransmutProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/transmutprogressbar_1.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 37, 0, 0, 90, 6, 90, 6);
		}
		if (TransmutProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/transmutprogressbar_2.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 37, 0, 0, 90, 6, 90, 6);
		}
		if (TransmutProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/transmutprogressbar_3.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 37, 0, 0, 90, 6, 90, 6);
		}
		if (TransmutProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/transmutprogressbar_4.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 37, 0, 0, 90, 6, 90, 6);
		}
		if (TransmutProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/transmutprogressbar_5.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 37, 0, 0, 90, 6, 90, 6);
		}
		if (TransmutProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/transmutprogressbar_6.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 37, 0, 0, 90, 6, 90, 6);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar0.png"));
		this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		if (EnergyProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar1.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar2.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar3.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar4.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar5.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar6.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar7.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar8.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar9.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar10.png"));
			this.blit(ms, this.guiLeft + 44, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "\u00A75Transmutation Table", 3, 4, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
