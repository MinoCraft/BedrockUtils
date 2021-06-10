package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.mcreator.bedrockutils.block.BlockBedrockFramedPillar2Block;
import net.mcreator.bedrockutils.block.BlockBedrockFramedPillar1Block;
import net.mcreator.bedrockutils.block.BlockBedrockFramedPillar0Block;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class BlockBedrockFramedPillarCTProcedure extends BedrockutilsModElements.ModElement {
	public BlockBedrockFramedPillarCTProcedure(BedrockutilsModElements instance) {
		super(instance, 141);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure BlockBedrockFramedPillarCT!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure BlockBedrockFramedPillarCT!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure BlockBedrockFramedPillarCT!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure BlockBedrockFramedPillarCT!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockBedrockFramedPillar1Block.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockBedrockFramedPillar2Block.block.getDefaultState(), 3);
			}
		} else if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))) {
			if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockBedrockFramedPillar1Block.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockBedrockFramedPillar0Block.block.getDefaultState(), 3);
			}
		}
	}
}
