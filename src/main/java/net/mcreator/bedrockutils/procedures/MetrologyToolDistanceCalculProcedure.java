package net.mcreator.bedrockutils.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class MetrologyToolDistanceCalculProcedure extends BedrockutilsModElements.ModElement {
	public MetrologyToolDistanceCalculProcedure(BedrockutilsModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency entity for procedure MetrologyToolDistanceCalcul!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency itemstack for procedure MetrologyToolDistanceCalcul!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		boolean bothPlaced = false;
		double onePosZ = 0;
		double onePosX = 0;
		double twoPosY = 0;
		double deltaZ = 0;
		double onePosY = 0;
		double twoPosX = 0;
		double deltaX = 0;
		double twoPosZ = 0;
		double deltaY = 0;
		if ((((itemstack).getOrCreateTag().getBoolean("plotOnePlaced")) && ((itemstack).getOrCreateTag().getBoolean("plotTwoPlaced")))) {
			onePosX = (double) ((itemstack).getOrCreateTag().getDouble("PlotOnePosX"));
			onePosY = (double) ((itemstack).getOrCreateTag().getDouble("PlotOnePosY"));
			onePosZ = (double) ((itemstack).getOrCreateTag().getDouble("PlotOnePosZ"));
			twoPosX = (double) ((itemstack).getOrCreateTag().getDouble("PlotTwoPosX"));
			twoPosY = (double) ((itemstack).getOrCreateTag().getDouble("PlotTwoPosY"));
			twoPosZ = (double) ((itemstack).getOrCreateTag().getDouble("PlotTwoPosZ"));
			bothPlaced = (boolean) (true);
		} else if ((((itemstack).getOrCreateTag().getBoolean("plotOnePlaced")) && (!((itemstack).getOrCreateTag().getBoolean("plotTwoPlaced"))))) {
			onePosX = (double) ((itemstack).getOrCreateTag().getDouble("PlotOnePosX"));
			onePosY = (double) ((itemstack).getOrCreateTag().getDouble("PlotOnePosY"));
			onePosZ = (double) ((itemstack).getOrCreateTag().getDouble("PlotOnePosZ"));
			twoPosX = (double) (entity.getPosX());
			twoPosY = (double) (entity.getPosY());
			twoPosZ = (double) (entity.getPosZ());
			bothPlaced = (boolean) (false);
		}
		deltaX = (double) Math.round(((onePosX) - (twoPosX)));
		if (((deltaX) < 0)) {
			deltaX = (double) ((deltaX) * (-1));
		}
		if (((deltaX) != 0)) {
			deltaX = (double) ((deltaX) + 1);
		}
		deltaY = (double) Math.round(((onePosY) - (twoPosY)));
		if (((deltaY) < 0)) {
			deltaY = (double) ((deltaY) * (-1));
		}
		if (((deltaY) != 0)) {
			deltaY = (double) ((deltaY) + 1);
		}
		deltaZ = (double) Math.round(((onePosZ) - (twoPosZ)));
		if (((deltaZ) < 0)) {
			deltaZ = (double) ((deltaZ) * (-1));
		}
		if (((deltaZ) != 0)) {
			deltaZ = (double) ((deltaZ) + 1);
		}
		if ((bothPlaced)) {
			(itemstack).getOrCreateTag().putDouble("deltaX", (deltaX));
			(itemstack).getOrCreateTag().putDouble("deltaY", (deltaY));
			(itemstack).getOrCreateTag().putDouble("deltaZ", (deltaZ));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						(("X: ") + "" + ((deltaX)) + "" + (" ; ") + "" + ("Y: ") + "" + ((deltaY)) + "" + (" ; ") + "" + ("Z: ") + "" + ((deltaZ)))),
						(true));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						(("X: ") + "" + ((deltaX)) + "" + (" ; ") + "" + ("Y: ") + "" + ((deltaY)) + "" + (" ; ") + "" + ("Z: ") + "" + ((deltaZ)))),
						(true));
			}
		}
	}
}
