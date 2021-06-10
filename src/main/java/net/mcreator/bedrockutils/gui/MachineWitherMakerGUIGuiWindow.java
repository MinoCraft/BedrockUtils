
package net.mcreator.bedrockutils.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.bedrockutils.procedures.OrganicProgressBar9Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar8Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar7Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar6Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar5Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar4Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar3Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar2Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar1Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar11Procedure;
import net.mcreator.bedrockutils.procedures.OrganicProgressBar10Procedure;
import net.mcreator.bedrockutils.procedures.MachineWitherMakerButton0Deco1Procedure;
import net.mcreator.bedrockutils.procedures.MachineWiherMakerButton0Deco0Procedure;
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
import net.mcreator.bedrockutils.BedrockutilsMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class MachineWitherMakerGUIGuiWindow extends ContainerScreen<MachineWitherMakerGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public MachineWitherMakerGUIGuiWindow(MachineWitherMakerGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 209;
	}
	private static final ResourceLocation texture = new ResourceLocation("bedrockutils:textures/machine_wither_maker_gui.png");
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
		this.blit(ms, this.guiLeft + -109, this.guiTop + 17, 0, 0, 110, 70, 110, 70);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_gui_fluidcomponent.png"));
		this.blit(ms, this.guiLeft + -109, this.guiTop + 86, 0, 0, 110, 48, 110, 48);
		if (MachineWiherMakerButton0Deco0Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/machinewithermakerbuttondeco0.png"));
			this.blit(ms, this.guiLeft + 70, this.guiTop + 101, 0, 0, 8, 8, 8, 8);
		}
		if (EnergyProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar1.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar2.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar3.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar4.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar5.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar6.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar7.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar8.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar9.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar10.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 64, 0, 0, 90, 15, 90, 15);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidprogressbar0.png"));
		this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		if (OrganicProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar1.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar2.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar3.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar4.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar5.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar6.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar7.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar8.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar9.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar10.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar11Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar11.png"));
			this.blit(ms, this.guiLeft + 12, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/arrowdown.png"));
		this.blit(ms, this.guiLeft + 38, this.guiTop + 57, 0, 0, 12, 16, 12, 16);
		if (MachineWitherMakerButton0Deco1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/machinewithermakerbuttondeco1.png"));
			this.blit(ms, this.guiLeft + 70, this.guiTop + 101, 0, 0, 8, 8, 8, 8);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/withershadow_0.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 49, 0, 0, 34, 34, 34, 34);
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
		this.font.drawString(ms, "\u00A70\u00A7lWither Maker", 4, 5, -12829636);
		this.font.drawString(ms, "\u00A70\u00A7l\u00A7nEnergy:", -102, 24, -12829636);
		this.font.drawString(ms, "\u00A70\u00A7l\u00A7nFluid:", -102, 93, -12829636);
		this.font.drawString(ms, "\u00A76" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getEnergy")) + "\u00A70/\u00A76" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getCapacity")) + "", -102, 53, -12829636);
		this.font.drawString(ms, "\u00A70Cost: \u00A76" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "energyCost")) + "\u00A70 RF/t", -102, 35, -12829636);
		this.font.drawString(ms, "\u00A70Internal Cell:", -102, 44, -12829636);
		this.font.drawString(ms, "\u00A79" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getFluidLevel")) + "\u00A70/\u00A79" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getFluidCapacity")) + "", -102, 115, -12829636);
		this.font.drawString(ms, "\u00A70Cost: \u00A79fluidCost \u00A70mB/t", -102, 105, -12829636);
		this.font.drawString(ms, "\u00A7l\u00A70" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "setSpawnHeight")) + "", 134, 61, -12829636);
		this.font.drawString(ms, "" + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "setSpawnMode")) + "", 114, 107, -3407821);
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
		this.addButton(new Button(this.guiLeft + 134, this.guiTop + 31, 30, 20, new StringTextComponent("+"), e -> {
			if (true) {
				BedrockutilsMod.PACKET_HANDLER.sendToServer(new MachineWitherMakerGUIGui.ButtonPressedMessage(0, x, y, z));
				MachineWitherMakerGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 134, this.guiTop + 82, 30, 20, new StringTextComponent("-"), e -> {
			if (true) {
				BedrockutilsMod.PACKET_HANDLER.sendToServer(new MachineWitherMakerGUIGui.ButtonPressedMessage(1, x, y, z));
				MachineWitherMakerGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 82, this.guiTop + 94, 30, 20, new StringTextComponent("."), e -> {
			if (true) {
				BedrockutilsMod.PACKET_HANDLER.sendToServer(new MachineWitherMakerGUIGui.ButtonPressedMessage(2, x, y, z));
				MachineWitherMakerGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 134, this.guiTop + 7, 30, 20, new StringTextComponent("Area"), e -> {
			if (true) {
				BedrockutilsMod.PACKET_HANDLER.sendToServer(new MachineWitherMakerGUIGui.ButtonPressedMessage(3, x, y, z));
				MachineWitherMakerGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
