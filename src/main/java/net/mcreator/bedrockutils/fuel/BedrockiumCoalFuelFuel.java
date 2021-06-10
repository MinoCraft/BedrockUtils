
package net.mcreator.bedrockutils.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.bedrockutils.item.BedrockiumCoalItem;
import net.mcreator.bedrockutils.BedrockutilsModElements;

@BedrockutilsModElements.ModElement.Tag
public class BedrockiumCoalFuelFuel extends BedrockutilsModElements.ModElement {
	public BedrockiumCoalFuelFuel(BedrockutilsModElements instance) {
		super(instance, 152);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(BedrockiumCoalItem.block, (int) (1)).getItem())
			event.setBurnTime(16000);
	}
}
