package net.mcreator.bedrockutils.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class MetrologyToolRightClickedInAirProcedure extends BedrockutilsModElements.ModElement {
	public MetrologyToolRightClickedInAirProcedure(BedrockutilsModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency entity for procedure MetrologyToolRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency itemstack for procedure MetrologyToolRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity.isSneaking())) {
			(itemstack).getOrCreateTag().putDouble("setToolMode", (((itemstack).getOrCreateTag().getDouble("setToolMode")) + 1));
			if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) > 2)) {
				(itemstack).getOrCreateTag().putDouble("setToolMode", 0);
			}
			if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) == 0)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Mode: Disabled"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) == 1)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Mode: Opposite Wrench"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("setToolMode")) == 2)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Mode: Take Measure"), (true));
				}
			}
		}
	}
}
