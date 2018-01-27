package cjpack.cjpe;

import cjpack.cjpe.config.ConfigBlock;
import cjpack.cjpe.config.ConfigItem;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import static cjpack.cjpe.CJPE.*;

@Mod(modid = MODID, name = NAME, version = VERSION, acceptedMinecraftVersions = MCVERSION)
public class CJPE {

    public static final String MODID = "cjpe";
    public static final String NAME = "CJPack Extras";
    public static final String VERSION = "1.0";
    public static final String MCVERSION = "[1.10.2]";

    @Mod.Instance(MODID)
    public static CJPE instance;

    public static Configuration i;
    public static Configuration b;

    public static void loadConfigDefaults() {
        if (i.getCategoryNames().size() == 0) {
            ConfigCategory c = i.getCategory("default");
            c.put("unlocalizedName", new Property("unlocalizedName", "default_item", Property.Type.STRING));
            c.put("registryName", new Property("registryName", "default_item", Property.Type.STRING));
            c.put("tab", new Property("tab", "cct_items", Property.Type.STRING));
            c.put("mods", new Property("mods", new String[]{"effect", "beacon"}, Property.Type.STRING));
            c.put("size", new Property("size", "1", Property.Type.INTEGER));
        }
        if (b.getCategoryNames().size() == 0) {
            ConfigCategory c = b.getCategory("default");
            c.put("unlocalizedName", new Property("unlocalizedName", "default_block", Property.Type.STRING));
            c.put("registryName", new Property("registryName", "default_block", Property.Type.STRING));
            c.put("mods", new Property("mods", new String[]{"unbreakable"}, Property.Type.STRING));
        }
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File dir = new File(Loader.instance().getConfigDir() + File.separator + "cjpe");
        dir.mkdir();
        File f = new File(dir, "items.cfg");
        i = new Configuration(f);
        i.load();
        File ff = new File(dir, "blocks.cfg");
        b = new Configuration(ff);
        b.load();

        loadConfigDefaults();
        i.save();
        b.save();

        ConfigItem.loadItems();
        ConfigBlock.loadBlocks();

    }


}
