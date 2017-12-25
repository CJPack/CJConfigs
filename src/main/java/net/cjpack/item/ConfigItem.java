package net.cjpack.item;

import net.cjpack.CCT;
import net.cjpack.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class ConfigItem extends Item {

    public static CreativeTabs tab = new CreativeTabs("cct_items") {
        @Override
        public Item getTabIconItem() {
            return Items.NETHER_STAR;
        }
    };

    public static List<ConfigItem> items = new ArrayList<>();

    public ConfigItem(String name, String registryName) {
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
        this.setCreativeTab(tab);
        items.add(this);
    }

    public static void loadItems(){
        CCT.i.getCategoryNames().forEach(c -> new ConfigItem(CCT.i.getCategory(c).get("unlocalizedName").getString(), CCT.i.getCategory(c).get("registryName").getString()));
    }
}
