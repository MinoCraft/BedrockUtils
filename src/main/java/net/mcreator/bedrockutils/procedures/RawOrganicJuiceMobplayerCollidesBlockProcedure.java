package net.mcreator.bedrockutils.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class RawOrganicJuiceMobplayerCollidesBlockProcedure extends BedrockutilsModElements.ModElement {
	public RawOrganicJuiceMobplayerCollidesBlockProcedure(BedrockutilsModElements instance) {
		super(instance, 222);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency entity for procedure RawOrganicJuiceMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 60, (int) 2));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 60, (int) 2));
	}
}
