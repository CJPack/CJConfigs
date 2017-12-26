package net.cjpack.item;

import net.cjpack.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CTItemBase extends Item {
	
	public static boolean effect;
	
	public CTItemBase(String name, CreativeTabs tab, boolean effect) {
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(Reference.MODID, name));
		setCreativeTab(tab);
		this.effect = effect;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return effect;
	}

}
