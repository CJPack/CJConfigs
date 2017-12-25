package net.cjpack;

import net.cjpack.init.CCTBlocks;
import net.cjpack.init.CCTItems;
import net.cjpack.item.ConfigItem;
import net.cjpack.proxy.ICCTProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class CCT {

    @Mod.Instance(Reference.MODID)
    public static CCT instance;

    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static ICCTProxy proxy;
    public static Configuration i;

    public static void loadConfigDefaults() {
        if (i.getCategoryNames().size() == 0) {
            ConfigCategory c = i.getCategory("default");
            c.put("unlocalizedName", new Property("unlocalizedName", "default_item", Property.Type.STRING));
            c.put("registryName", new Property("registryName", "default_item", Property.Type.STRING));
            c.put("tab", new Property("tab", "cct_items", Property.Type.STRING));
            c.put("mods", new Property("mods", new String[]{"effect", "beacon"}, Property.Type.STRING));
            c.put("size", new Property("size", "1", Property.Type.INTEGER));
        }
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File dir = new File(Loader.instance().getConfigDir() + File.separator + "CJCustomThings");
        dir.mkdir();
        File f = new File(dir, "items.cfg");
        i = new Configuration(f);
        i.load();
        loadConfigDefaults();
        i.save();
        proxy.preInit(event);

        ConfigItem.loadItems();
        CCTItems.createItems();
        CCTBlocks.createBlocks();

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);

    }


}
