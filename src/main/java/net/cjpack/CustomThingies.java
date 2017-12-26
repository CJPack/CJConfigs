package net.cjpack;

import java.awt.List;
import java.io.File;

import net.cjpack.init.CTBlocks;
import net.cjpack.init.CTItems;
import net.cjpack.item.ConfigItem;
import net.cjpack.proxy.ICCTProxy;
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

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class CustomThingies {

    @Mod.Instance(Reference.MODID)
    public static CustomThingies instance;

    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static ICCTProxy proxy;
    public static Configuration i;

    public static void loadConfigDefaults() {
        if (i.getCategoryNames().size() == 0) {
            ConfigCategory c = i.getCategory("example");
            c.put("unlocalizedName", new Property("unlocalizedName", "example_item", Property.Type.STRING));
            c.put("registryName", new Property("registryName", "example_item", Property.Type.STRING));
            c.put("tab", new Property("tab", "ct_items", Property.Type.STRING));
            c.put("mods", new Property("mods", new String[]{"effect", "beacon"}, Property.Type.STRING));
            c.put("size", new Property("size", "1", Property.Type.INTEGER));
            i.addCustomCategoryComment("example", "unlocalizedName = String unlocalizedName, registryName = String registryName, tab = CreativeTabs, mods: effect = boolean hasEffect  beacon = boolean isBeaconPayment, size = Int maxStackSize");
        }
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File dir = new File(Loader.instance().getConfigDir() + File.separator + "CustomThingies");
        dir.mkdir();
        File f = new File(dir, "items.cfg");
        i = new Configuration(f);
        i.load();
        loadConfigDefaults();
        i.save();
        proxy.preInit(event);

        ConfigItem.loadItems();
        CTItems.createItems();
        CTBlocks.createBlocks();

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
