
package net.mcreator.bedrockutils.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.itemgroup.BedrockUtilsItemGroup;
import net.mcreator.bedrockutils.BedrockutilsModElements;

import java.util.List;

@BedrockutilsModElements.ModElement.Tag
public class BedrockiumCoalItem extends BedrockutilsModElements.ModElement {
	@ObjectHolder("bedrockutils:bedrockium_coal")
	public static final Item block = null;
	public BedrockiumCoalItem(BedrockutilsModElements instance) {
		super(instance, 151);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BedrockUtilsItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("bedrockium_coal");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A7510 X longer than regular coal"));
			list.add(new StringTextComponent("\u00A76Use Transmutation Table to obtain"));
		}
	}
}
