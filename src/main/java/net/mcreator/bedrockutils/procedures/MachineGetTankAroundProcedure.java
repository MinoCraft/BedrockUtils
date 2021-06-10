package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.block.FluidTankBlock;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class MachineGetTankAroundProcedure extends BedrockutilsModElements.ModElement {
	public MachineGetTankAroundProcedure(BedrockutilsModElements instance) {
		super(instance, 273);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure MachineGetTankAround!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure MachineGetTankAround!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure MachineGetTankAround!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure MachineGetTankAround!");
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", (z + 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", (x - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", (x + 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", (z - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", (x - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", (x + 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST)) {
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", (x - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", (z + 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", (z - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST)) {
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", (x + 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", (z + 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == FluidTankBlock.block.getDefaultState()
					.getBlock())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosX", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("tankPosZ", (z - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
