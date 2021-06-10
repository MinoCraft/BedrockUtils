package net.mcreator.bedrockutils.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

import net.mcreator.bedrockutils.item.BedrockFragmentItem;
import net.mcreator.bedrockutils.BedrockutilsModVariables;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class BedrockBreakerRedstoneOnProcedure extends BedrockutilsModElements.ModElement {
	public BedrockBreakerRedstoneOnProcedure(BedrockutilsModElements instance) {
		super(instance, 36);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure BedrockBreakerRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure BedrockBreakerRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure BedrockBreakerRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure BedrockBreakerRedstoneOn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double breakXPos = 0;
		double breakYPos = 0;
		double breakZPos = 0;
		breakXPos = (double) (BedrockutilsModVariables.MapVariables.get(world).tempBreakXPos);
		breakYPos = (double) (BedrockutilsModVariables.MapVariables.get(world).tempBreakYPos);
		breakZPos = (double) (BedrockutilsModVariables.MapVariables.get(world).tempBreakZPos);
		if ((!((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (World.THE_END)))) {
			if (((breakYPos) > 1)) {
				if (((world.getBlockState(new BlockPos((int) (breakXPos), (int) (breakYPos), (int) (breakZPos)))).getBlock() == Blocks.BEDROCK
						.getDefaultState().getBlock())) {
					world.destroyBlock(new BlockPos((int) (breakXPos), (int) (breakYPos), (int) (breakZPos)), false);
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.lightning_bolt.impact")),
								SoundCategory.NEUTRAL, (float) 0.6, (float) 5);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.lightning_bolt.impact")),
								SoundCategory.NEUTRAL, (float) 0.6, (float) 5, false);
					}
					if ((Math.random() < 0.4)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, (breakXPos), (breakYPos), (breakZPos),
									new ItemStack(BedrockFragmentItem.block, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							entityToSpawn.setNoDespawn();
							world.addEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
