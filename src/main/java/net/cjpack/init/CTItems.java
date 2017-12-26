package net.cjpack.init;

import net.cjpack.Reference;
import net.cjpack.item.CTItemBase;
import net.cjpack.item.ConfigItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CTItems {
	
	public static Item cjIngot = new CTItemBase("cj_ingot", null, true);
	
	public static void createItems() {
		ConfigItem.items.forEach(i -> createItem(i));
		createItem(cjIngot);
	}
	
	public static void createItem(Item item) {
		GameRegistry.register(item);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
	}



}
