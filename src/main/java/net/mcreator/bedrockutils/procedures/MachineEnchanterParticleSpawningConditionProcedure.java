package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class MachineEnchanterParticleSpawningConditionProcedure extends BedrockutilsModElements.ModElement {
	public MachineEnchanterParticleSpawningConditionProcedure(BedrockutilsModElements instance) {
		super(instance, 139);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure MachineEnchanterParticleSpawningCondition!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure MachineEnchanterParticleSpawningCondition!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure MachineEnchanterParticleSpawningCondition!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure MachineEnchanterParticleSpawningCondition!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "enchanterlvl1"))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.ENCHANT, x, y, z, (int) 5, 3, 3, 3, 1);
			}
		}
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "enchanterlvl3"))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.BUBBLE_COLUMN_UP, (x + 1), y, (z + 1), (int) 5, 1, 1, 1, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.BUBBLE_COLUMN_UP, (x + 1), y, (z - 1), (int) 5, 1, 1, 1, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.BUBBLE_COLUMN_UP, (x - 1), y, (z + 1), (int) 5, 1, 1, 1, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.BUBBLE_COLUMN_UP, (x - 1), y, (z - 1), (int) 5, 1, 1, 1, 1);
			}
		}
	}
}
