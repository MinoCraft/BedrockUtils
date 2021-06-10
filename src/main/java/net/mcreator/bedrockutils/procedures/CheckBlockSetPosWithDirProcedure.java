package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.BedrockutilsModVariables;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class CheckBlockSetPosWithDirProcedure extends BedrockutilsModElements.ModElement {
	public CheckBlockSetPosWithDirProcedure(BedrockutilsModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure CheckBlockSetPosWithDir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure CheckBlockSetPosWithDir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure CheckBlockSetPosWithDir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure CheckBlockSetPosWithDir!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.DOWN)) {
			BedrockutilsModVariables.MapVariables.get(world).tempBreakXPos = (double) x;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakYPos = (double) (y - 1);
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakZPos = (double) z;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.UP)) {
			BedrockutilsModVariables.MapVariables.get(world).tempBreakXPos = (double) x;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakYPos = (double) (y + 1);
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakZPos = (double) z;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
			BedrockutilsModVariables.MapVariables.get(world).tempBreakXPos = (double) x;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakYPos = (double) y;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakZPos = (double) (z - 1);
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH)) {
			BedrockutilsModVariables.MapVariables.get(world).tempBreakXPos = (double) x;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakYPos = (double) y;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakZPos = (double) (z + 1);
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST)) {
			BedrockutilsModVariables.MapVariables.get(world).tempBreakXPos = (double) (x - 1);
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakYPos = (double) y;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakZPos = (double) z;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST)) {
			BedrockutilsModVariables.MapVariables.get(world).tempBreakXPos = (double) (x + 1);
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakYPos = (double) y;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
			BedrockutilsModVariables.MapVariables.get(world).tempBreakZPos = (double) z;
			BedrockutilsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
