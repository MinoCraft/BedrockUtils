package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class MetrologyToolItemFrameModeProcedure extends BedrockutilsModElements.ModElement {
	public MetrologyToolItemFrameModeProcedure(BedrockutilsModElements instance) {
		super(instance, 102);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency entity for procedure MetrologyToolItemFrameMode!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency itemstack for procedure MetrologyToolItemFrameMode!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure MetrologyToolItemFrameMode!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure MetrologyToolItemFrameMode!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure MetrologyToolItemFrameMode!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure MetrologyToolItemFrameMode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		(itemstack).getOrCreateTag().putDouble("wrenchDir", (((itemstack).getOrCreateTag().getDouble("wrenchDir")) + 1));
		if ((((itemstack).getOrCreateTag().getDouble("wrenchDir")) > 5)) {
			(itemstack).getOrCreateTag().putDouble("wrenchDir", 0);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((new java.text.DecimalFormat("##").format(((itemstack).getOrCreateTag().getDouble("wrenchDir"))))),
					(true));
		}
		if ((((itemstack).getOrCreateTag().getDouble("wrenchDir")) == 0)) {
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.EAST), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.EAST.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("wrenchDir")) == 1)) {
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.SOUTH), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(
							(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.SOUTH.getAxis()), 3);
				}
			} catch (Exception e) {
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("wrenchDir")) == 2)) {
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.WEST), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("wrenchDir")) == 3)) {
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.UP), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.UP.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("wrenchDir")) == 4)) {
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.DOWN), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
							_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.DOWN.getAxis()),
							3);
				}
			} catch (Exception e) {
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("wrenchDir")) == 5)) {
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
				if (_property != null) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(_property, Direction.NORTH), 3);
				} else {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), _bs.with(
							(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.NORTH.getAxis()), 3);
				}
			} catch (Exception e) {
			}
		}
	}
}
