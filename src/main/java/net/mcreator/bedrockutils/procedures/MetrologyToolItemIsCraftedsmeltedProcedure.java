package net.mcreator.bedrockutils.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class MetrologyToolItemIsCraftedsmeltedProcedure extends BedrockutilsModElements.ModElement {
	public MetrologyToolItemIsCraftedsmeltedProcedure(BedrockutilsModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency itemstack for procedure MetrologyToolItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).getOrCreateTag().putDouble("setToolMode", 0);
	}
}
