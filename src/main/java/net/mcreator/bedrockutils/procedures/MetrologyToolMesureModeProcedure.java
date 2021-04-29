package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.bedrockutils.block.MetrologyPlotBlock;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;
import java.util.HashMap;

@BedrockutilsModElements.ModElement.Tag
public class MetrologyToolMesureModeProcedure extends BedrockutilsModElements.ModElement {
	public MetrologyToolMesureModeProcedure(BedrockutilsModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency entity for procedure MetrologyToolMesureMode!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency itemstack for procedure MetrologyToolMesureMode!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure MetrologyToolMesureMode!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure MetrologyToolMesureMode!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure MetrologyToolMesureMode!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure MetrologyToolMesureMode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((itemstack).getOrCreateTag().getBoolean("setMesureMode"))) {
			if ((!((itemstack).getOrCreateTag().getBoolean("plotOnePlaced")))) {
				if ((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), MetrologyPlotBlock.block.getDefaultState(), 3);
				}
				(itemstack).getOrCreateTag().putDouble("PlotOnePosX", x);
				(itemstack).getOrCreateTag().putDouble("PlotOnePosY", y);
				(itemstack).getOrCreateTag().putDouble("PlotOnePosZ", z);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent(
											(("Coord Plot 1: ") + "" + ("X: ") + "" + (((itemstack).getOrCreateTag().getDouble("PlotOnePosX"))) + ""
													+ (" ; ") + "" + ("Y: ") + "" + (((itemstack).getOrCreateTag().getDouble("PlotOnePosY"))) + ""
													+ (" ; ") + "" + ("Z: ") + "" + (((itemstack).getOrCreateTag().getDouble("PlotOnePosZ"))))),
									(false));
				}
				(itemstack).getOrCreateTag().putBoolean("plotOnePlaced", (true));
			} else if ((((itemstack).getOrCreateTag().getBoolean("plotOnePlaced"))
					&& (!((itemstack).getOrCreateTag().getBoolean("plotTwoPlaced"))))) {
				if ((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), MetrologyPlotBlock.block.getDefaultState(), 3);
				}
				(itemstack).getOrCreateTag().putDouble("PlotTwoPosX", x);
				(itemstack).getOrCreateTag().putDouble("PlotTwoPosY", y);
				(itemstack).getOrCreateTag().putDouble("PlotTwoPosZ", z);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent(
											(("Coord Plot 2: ") + "" + ("X: ") + "" + (((itemstack).getOrCreateTag().getDouble("PlotTwoPosX"))) + ""
													+ (" ; ") + "" + ("Y: ") + "" + (((itemstack).getOrCreateTag().getDouble("PlotTwoPosY"))) + ""
													+ (" ; ") + "" + ("Z: ") + "" + (((itemstack).getOrCreateTag().getDouble("PlotTwoPosZ"))))),
									(false));
				}
				(itemstack).getOrCreateTag().putBoolean("plotTwoPlaced", (true));
			} else if ((((itemstack).getOrCreateTag().getBoolean("plotOnePlaced")) && ((itemstack).getOrCreateTag().getBoolean("plotTwoPlaced")))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					MetrologyToolDistanceCalculProcedure.executeProcedure($_dependencies);
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent((("Distance: ") + "" + ("X: ") + "" + (((itemstack).getOrCreateTag().getDouble("deltaX"))) + ""
									+ (" ; ") + "" + ("Y: ") + "" + (((itemstack).getOrCreateTag().getDouble("deltaY"))) + "" + (" ; ") + "" + ("Z: ")
									+ "" + (((itemstack).getOrCreateTag().getDouble("deltaZ"))))),
							(false));
				}
				if (((world.getBlockState(new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("PlotOnePosX")),
						(int) (((itemstack).getOrCreateTag().getDouble("PlotOnePosY")) + 1),
						(int) ((itemstack).getOrCreateTag().getDouble("PlotOnePosZ")))))
								.getBlock() == MetrologyPlotBlock.block.getDefaultState().getBlock())) {
					world.setBlockState(new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("PlotOnePosX")),
							(int) (((itemstack).getOrCreateTag().getDouble("PlotOnePosY")) + 1),
							(int) ((itemstack).getOrCreateTag().getDouble("PlotOnePosZ"))), Blocks.AIR.getDefaultState(), 3);
					(itemstack).getOrCreateTag().putBoolean("plotOnePlaced", (false));
				}
				if (((world.getBlockState(new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("PlotTwoPosX")),
						(int) (((itemstack).getOrCreateTag().getDouble("PlotTwoPosY")) + 1),
						(int) ((itemstack).getOrCreateTag().getDouble("PlotTwoPosZ")))))
								.getBlock() == MetrologyPlotBlock.block.getDefaultState().getBlock())) {
					world.setBlockState(new BlockPos((int) ((itemstack).getOrCreateTag().getDouble("PlotTwoPosX")),
							(int) (((itemstack).getOrCreateTag().getDouble("PlotTwoPosY")) + 1),
							(int) ((itemstack).getOrCreateTag().getDouble("PlotTwoPosZ"))), Blocks.AIR.getDefaultState(), 3);
					(itemstack).getOrCreateTag().putBoolean("plotTwoPlaced", (false));
				}
			}
		}
	}
}
