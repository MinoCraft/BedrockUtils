package net.mcreator.bedrockutils.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.block.BlockBedrockFramedPillar2Block;
import net.mcreator.bedrockutils.block.BlockBedrockFramedPillar1Block;
import net.mcreator.bedrockutils.block.BlockBedrockFramedPillar0Block;
import net.mcreator.bedrockutils.block.BlockBedrockFramedBlock;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class BlockBedrockFramedPillarCTUpdateProcedure extends BedrockutilsModElements.ModElement {
	public BlockBedrockFramedPillarCTUpdateProcedure(BedrockutilsModElements instance) {
		super(instance, 144);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure BlockBedrockFramedPillarCTUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure BlockBedrockFramedPillarCTUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure BlockBedrockFramedPillarCTUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure BlockBedrockFramedPillarCTUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
			if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))
					&& (BlockTags.getCollection()
							.getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = BlockBedrockFramedPillar1Block.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else if ((BlockTags.getCollection()
					.getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = BlockBedrockFramedPillar2Block.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else if ((BlockTags.getCollection()
					.getTagByID(new ResourceLocation(("bedrockutils:bedrock_framed").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = BlockBedrockFramedPillar0Block.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = BlockBedrockFramedBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}
