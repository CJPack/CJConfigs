package net.cjpack.init;

import net.cjpack.Reference;
import net.cjpack.item.CCTItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CCTItems {
	
	public static Item cjIngot = new CCTItemBase("cj_ingot", null, true);
	
	public static void createItems() {
		createItem(cjIngot);
	}
	
	public static void createItem(Item item) {
		GameRegistry.register(item);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
	}

}
