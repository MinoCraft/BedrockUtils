package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class LogicBlockAnalogicComparatorButton2Procedure extends BedrockutilsModElements.ModElement {
	public LogicBlockAnalogicComparatorButton2Procedure(BedrockutilsModElements instance) {
		super(instance, 134);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure LogicBlockAnalogicComparatorButton2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure LogicBlockAnalogicComparatorButton2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure LogicBlockAnalogicComparatorButton2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure LogicBlockAnalogicComparatorButton2!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("selectedSignal", ((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "selectedSignal")) + 1));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "selectedSignal")) > 15)) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("selectedSignal", 15);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
