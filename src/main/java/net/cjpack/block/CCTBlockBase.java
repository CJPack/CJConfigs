package net.cjpack.block;

import net.cjpack.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class CCTBlockBase extends Block {
	
	public CCTBlockBase(Material material, String name, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(Reference.MODID, name));
		setCreativeTab(tab);
	}
}
