package net.mcreator.bedrockutils.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;
import java.util.HashMap;

@BedrockutilsModElements.ModElement.Tag
public class MetrologyToolItemInHandTickProcedure extends BedrockutilsModElements.ModElement {
	public MetrologyToolItemInHandTickProcedure(BedrockutilsModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency entity for procedure MetrologyToolItemInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency itemstack for procedure MetrologyToolItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) == 0)) {
			(itemstack).getOrCreateTag().putBoolean("setOppositeMode", (false));
			(itemstack).getOrCreateTag().putBoolean("setMesureMode", (false));
			(itemstack).getOrCreateTag().putBoolean("setDisabledMode", (true));
		} else if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) == 1)) {
			(itemstack).getOrCreateTag().putBoolean("setMesureMode", (false));
			(itemstack).getOrCreateTag().putBoolean("setOppositeMode", (true));
			(itemstack).getOrCreateTag().putBoolean("setDisabledMode", (false));
		} else if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) == 2)) {
			(itemstack).getOrCreateTag().putBoolean("setDisabledMode", (false));
			(itemstack).getOrCreateTag().putBoolean("setOppositeMode", (false));
			(itemstack).getOrCreateTag().putBoolean("setMesureMode", (true));
		} else if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) == 3)) {
			(itemstack).getOrCreateTag().putBoolean("setDisabledMode", (false));
			(itemstack).getOrCreateTag().putBoolean("setOppositeMode", (false));
			(itemstack).getOrCreateTag().putBoolean("setMesureMode", (false));
		}
		if (((itemstack).getOrCreateTag().getBoolean("plotOnePlaced"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				MetrologyToolDistanceCalculProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
