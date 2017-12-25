package net.cjpack.init;

import net.cjpack.Reference;
import net.cjpack.block.CCTBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CCTBlocks {
	
	public static Block cjBlock = new CCTBlockBase(Material.IRON, "cj_block", null);
	
	public static void createBlocks() {
		createBlock(cjBlock);
	}
	
	public static void createBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName()));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID), "inventory"));
	}

}
