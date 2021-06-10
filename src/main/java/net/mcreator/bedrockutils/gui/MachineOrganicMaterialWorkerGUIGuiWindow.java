
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
import net.mcreator.bedrockutils.procedures.OmwViewItemValue2Procedure;
import net.mcreator.bedrockutils.procedures.OmwViewItemValue1Procedure;
import net.mcreator.bedrockutils.procedures.OmwResistorProgress0Procedure;
import net.mcreator.bedrockutils.procedures.OmwRecycleProgress6Procedure;
import net.mcreator.bedrockutils.procedures.OmwRecycleProgress5Procedure;
import net.mcreator.bedrockutils.procedures.OmwRecycleProgress4Procedure;
import net.mcreator.bedrockutils.procedures.OmwRecycleProgress3Procedure;
import net.mcreator.bedrockutils.procedures.OmwRecycleProgress2Procedure;
import net.mcreator.bedrockutils.procedures.OmwRecycleProgress1Procedure;
import net.mcreator.bedrockutils.procedures.OmwRecycleProgress0Procedure;
import net.mcreator.bedrockutils.procedures.OmwCraftProgress3Procedure;
import net.mcreator.bedrockutils.procedures.OmwCraftProgress2Procedure;
import net.mcreator.bedrockutils.procedures.OmwCraftProgress1Procedure;
import net.mcreator.bedrockutils.procedures.OmwCraftProgress0Procedure;
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
public class MachineOrganicMaterialWorkerGUIGuiWindow extends ContainerScreen<MachineOrganicMaterialWorkerGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public MachineOrganicMaterialWorkerGUIGuiWindow(MachineOrganicMaterialWorkerGUIGui.GuiContainerMod container, PlayerInventory inventory,
			ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 200;
	}
	private static final ResourceLocation texture = new ResourceLocation("bedrockutils:textures/machine_organic_material_worker_gui.png");
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
		this.blit(ms, this.guiLeft + -109, this.guiTop + 8, 0, 0, 110, 70, 110, 70);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_gui_upgradecomponent.png"));
		this.blit(ms, this.guiLeft + -109, this.guiTop + 124, 0, 0, 110, 48, 110, 48);
		if (EnergyProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar1.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar2.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar3.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar4.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar5.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar6.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar7.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar8.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar9.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		if (EnergyProgressBar10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/energyprogressbar10.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 55, 0, 0, 90, 15, 90, 15);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidprogressbar0.png"));
		this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		if (OrganicProgressBar1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar1.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar2.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar3.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar4.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar5.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar6.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar7Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar7.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar8Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar8.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar9Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar9.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar10Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar10.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		if (OrganicProgressBar11Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/fluidorganicprogressbar11.png"));
			this.blit(ms, this.guiLeft + 143, this.guiTop + 31, 0, 0, 20, 70, 20, 70);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_gui_fluidcomponent.png"));
		this.blit(ms, this.guiLeft + -109, this.guiTop + 77, 0, 0, 110, 48, 110, 48);
		if (OmwCraftProgress0Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/omw_testgui.png"));
			this.blit(ms, this.guiLeft + 14, this.guiTop + 36, 0, 0, 129, 65, 129, 65);
		}
		if (OmwCraftProgress1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/omw_testgui_1.png"));
			this.blit(ms, this.guiLeft + 14, this.guiTop + 36, 0, 0, 129, 65, 129, 65);
		}
		if (OmwCraftProgress2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/omw_testgui_2.png"));
			this.blit(ms, this.guiLeft + 14, this.guiTop + 36, 0, 0, 129, 65, 129, 65);
		}
		if (OmwCraftProgress3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/omw_testgui_3.png"));
			this.blit(ms, this.guiLeft + 14, this.guiTop + 36, 0, 0, 129, 65, 129, 65);
		}
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/resistorgui_0.png"));
		this.blit(ms, this.guiLeft + 78, this.guiTop + 92, 0, 0, 34, 13, 34, 13);
		if (OmwResistorProgress0Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/resistorgui_1.png"));
			this.blit(ms, this.guiLeft + 78, this.guiTop + 92, 0, 0, 34, 13, 34, 13);
		}
		if (OmwRecycleProgress0Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/omw_recycleprogressbar0.png"));
			this.blit(ms, this.guiLeft + 14, this.guiTop + 36, 0, 0, 117, 33, 117, 33);
		}
		if (OmwRecycleProgress1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_progressbarsgen_1.png"));
			this.blit(ms, this.guiLeft + 30, this.guiTop + 63, 0, 0, 17, 4, 17, 4);
		}
		if (OmwRecycleProgress2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_progressbarsgen_2.png"));
			this.blit(ms, this.guiLeft + 30, this.guiTop + 63, 0, 0, 35, 4, 35, 4);
		}
		if (OmwRecycleProgress3Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_progressbarsgen_3.png"));
			this.blit(ms, this.guiLeft + 30, this.guiTop + 63, 0, 0, 53, 4, 53, 4);
		}
		if (OmwRecycleProgress4Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_progressbarsgen_4.png"));
			this.blit(ms, this.guiLeft + 30, this.guiTop + 63, 0, 0, 72, 4, 72, 4);
		}
		if (OmwRecycleProgress5Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_progressbarsgen_5.png"));
			this.blit(ms, this.guiLeft + 30, this.guiTop + 63, 0, 0, 85, 4, 85, 4);
		}
		if (OmwRecycleProgress6Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bedrockutils:textures/bu_progressbarsgen_6.png"));
			this.blit(ms, this.guiLeft + 30, this.guiTop + 63, 0, 0, 88, 4, 88, 4);
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
		this.font.drawString(ms, "\u00A70\u00A7lOrganic Material Worker", 4, 5, -12829636);
		this.font.drawString(ms, "\u00A70\u00A7n\u00A7lEnergy:", -101, 16, -12829636);
		this.font.drawString(ms, "\u00A70Cost: \u00A76" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "energyCost")) + " \u00A70RF/i", -101, 26, -12829636);
		this.font.drawString(ms, "\u00A70Internal Cell:", -101, 36, -12829636);
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
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getCapacity")) + "", -101, 45, -12829636);
		this.font.drawString(ms, "\u00A70Tank: \u00A76" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getFluidAmount")) + " \u00A70mB", -101, 106, -12829636);
		this.font.drawString(ms, "\u00A70\u00A7n\u00A7lUpgrade:", -101, 131, -12829636);
		this.font.drawString(ms, "\u00A70Amount: \u00A76" + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "outputFluidAmount")) + " \u00A70mB", -101, 95, -12829636);
		if (OmwViewItemValue1Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "" + (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return 0;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "itemValue1")) + "", 36, 42, -12829636);
		if (OmwViewItemValue2Procedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
			this.font.drawString(ms, "" + (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return 0;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "itemValue2")) + "", 36, 85, -12829636);
		this.font.drawString(ms, "\u00A70\u00A7n\u00A7lFluid:", -101, 84, -12829636);
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
