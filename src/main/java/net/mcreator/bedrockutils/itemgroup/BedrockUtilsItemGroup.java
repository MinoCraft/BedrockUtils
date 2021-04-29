
package net.mcreator.bedrockutils.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.bedrockutils.block.BlockBedrockWitherBlock;
import net.mcreator.bedrockutils.BedrockutilsModElements;

@BedrockutilsModElements.ModElement.Tag
public class BedrockUtilsItemGroup extends BedrockutilsModElements.ModElement {
	public BedrockUtilsItemGroup(BedrockutilsModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbedrock_utils") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlockBedrockWitherBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
