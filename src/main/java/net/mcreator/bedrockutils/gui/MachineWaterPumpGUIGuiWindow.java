
package net.mcreator.bedrockutils.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.bedrockutils.procedures.WaterProgressBar9Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar8Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar7Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar6Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar5Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar4Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar3Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar2Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar1Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar11Procedure;
import net.mcreator.bedrockutils.procedures.WaterProgressBar10Procedure;
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
public class MachineWaterPumpGUIGuiWindow extends ContainerScreen<MachineWaterPumpGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public MachineWaterPumpGUIGuiWindow(MachineWaterPumpGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("bedrockutils:textures/machine_water_pump_gui.png");
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
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_gui_energycomponent.png"));
		this.blit(ms, this.guiLeft + -109, this.guiTop + 20, 0, 0, 110, 70, 110, 70);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_gui_fluidcomponent.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 21, 0, 0, 110, 48, 110, 48);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidprogressbar0.png"));
		this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		if (WaterProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar1.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar2.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar3.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar4.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar5.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar6.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar7.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar8.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar9.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar10.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (WaterProgressBar11Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/waterprogressbar11.png"));
			this.blit(ms, this.guiLeft + 139, this.guiTop + 7, 0, 0, 20, 70, 20, 70);
		}
		if (EnergyProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar1.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar2.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar3.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar4.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar5.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar6.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar7.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar8.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar9.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar10.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 67, 0, 0, 90, 15, 90, 15);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/arrowdown.png"));
		this.blit(ms, this.guiLeft + 119, this.guiTop + 34, 0, 0, 12, 16, 12, 16);
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
		this.font.drawString(ms, "Water Pump", 5, 6, -12829636);
		this.font.drawString(ms, "Energy", -102, 27, -12829636);
		this.font.drawString(ms, "" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getEnergy")) + "/" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getCapacity")) + "", -101, 56, -12829636);
		this.font.drawString(ms, "Internal Cell:", -102, 47, -12829636);
		this.font.drawString(ms, "Cost: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "energyCost")) + "", -102, 38, -12829636);
		this.font.drawString(ms, "Amount: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "fluidAmount")) + "", 30, 31, -12829636);
		this.font.drawString(ms, "" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getFluidLevel")) + "/" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getFluidCapacity")) + "", 10, 48, -12829636);
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
