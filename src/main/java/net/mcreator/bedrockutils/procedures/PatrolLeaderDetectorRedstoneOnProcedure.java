package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.bedrockutils.block.SneakyBlockBlock;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class PatrolLeaderDetectorRedstoneOnProcedure extends BedrockutilsModElements.ModElement {
	public PatrolLeaderDetectorRedstoneOnProcedure(BedrockutilsModElements instance) {
		super(instance, 86);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure PatrolLeaderDetectorRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure PatrolLeaderDetectorRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure PatrolLeaderDetectorRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure PatrolLeaderDetectorRedstoneOn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), SneakyBlockBlock.block.getDefaultState(), 3);
		}
	}
}
