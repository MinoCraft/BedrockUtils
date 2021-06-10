package net.mcreator.bedrockutils.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.block.LogicBlockAnalogicComparatorOnBlock;
import net.mcreator.bedrockutils.block.LogicBlockAnalogicComparatorHalfBlock;
import net.mcreator.bedrockutils.block.LogicBlockAnalogicComparatorBlock;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class LogicBlockAnalogicComparatorOnUpdateTickProcedure extends BedrockutilsModElements.ModElement {
	public LogicBlockAnalogicComparatorOnUpdateTickProcedure(BedrockutilsModElements instance) {
		super(instance, 135);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure LogicBlockAnalogicComparatorOnUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure LogicBlockAnalogicComparatorOnUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure LogicBlockAnalogicComparatorOnUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure LogicBlockAnalogicComparatorOnUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double readPower = 0;
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
			readPower = (double) ((world instanceof World) ? ((World) world).getRedstonePower(new BlockPos((int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputXPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputYPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputZPos"))), Direction.SOUTH) : 0);
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
			readPower = (double) ((world instanceof World) ? ((World) world).getRedstonePower(new BlockPos((int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputXPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputYPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputZPos"))), Direction.NORTH) : 0);
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
			readPower = (double) ((world instanceof World) ? ((World) world).getRedstonePower(new BlockPos((int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputXPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputYPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputZPos"))), Direction.WEST) : 0);
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
			readPower = (double) ((world instanceof World) ? ((World) world).getRedstonePower(new BlockPos((int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputXPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputYPos")), (int) (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockOutputZPos"))), Direction.EAST) : 0);
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putString("signalInput", (new java.text.DecimalFormat("##").format((readPower))));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (((readPower) == (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "selectedSignal")))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					final ItemStack _setstack = new ItemStack(Items.WOODEN_SWORD, (int) (1));
					_setstack.setCount((int) 1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = LogicBlockAnalogicComparatorOnBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				TileEntity _te = world.getTileEntity(_bp);
				CompoundNBT _bnbt = null;
				if (_te != null) {
					_bnbt = _te.write(new CompoundNBT());
					_te.remove();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.read(_bso, _bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		} else if ((((readPower) > (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "selectedSignal"))) || (((readPower) < (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "selectedSignal"))) && ((readPower) > 0)))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
						}
					});
				}
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = LogicBlockAnalogicComparatorHalfBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				TileEntity _te = world.getTileEntity(_bp);
				CompoundNBT _bnbt = null;
				if (_te != null) {
					_bnbt = _te.write(new CompoundNBT());
					_te.remove();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.read(_bso, _bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		} else if (((readPower) == 0)) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
						}
					});
				}
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = LogicBlockAnalogicComparatorBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				TileEntity _te = world.getTileEntity(_bp);
				CompoundNBT _bnbt = null;
				if (_te != null) {
					_bnbt = _te.write(new CompoundNBT());
					_te.remove();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.read(_bso, _bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		}
	}
}
