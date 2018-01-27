package cjpack.cjpe.config;

import cjpack.cjpe.CJPE;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ConfigBlock extends Block {

    public static CreativeTabs tab = new CreativeTabs("cct_blocks") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(Blocks.BEACON).getItem();
        }
    };

    public static List<ConfigBlock> items = new ArrayList<>();

    public List<String> mods;
    public ConfigCategory c;

    public ConfigBlock(ConfigCategory c) {
        super(Material.IRON);
        this.c = c;
        this.setUnlocalizedName(c.get("unlocalizedName").getString());
        this.setRegistryName(new ResourceLocation(CJPE.MODID, c.get("registryName").getString()));
        this.setCreativeTab(c.get("tab") != null ? getTabByName(c.get("tab").getString()) : tab);
        this.setHardness(c.get("hardness") != null ? Float.parseFloat(c.get("hardneess").getString()) : 1.0f);
        this.setHarvestLevel(c.get("tool") != null ? c.get("tool").getString() : "hand", c.get("harvest") != null ? c.get("harvest").getInt() : 0);
        this.setLightLevel(c.get("light") != null ? Float.parseFloat(c.get("light").getString()) : 0.0f);
        this.setLightOpacity(c.get("opacity") != null ? c.get("opacity").getInt() : 0);
        this.mods = c.get("mods") != null ? Arrays.asList(c.get("mods").getStringList()) : new ArrayList<>();
        if(mods.contains("unbreakable")) this.setBlockUnbreakable();
        items.add(this);
    }

    public static CreativeTabs getTabByName(String name) {
        for (CreativeTabs ct : CreativeTabs.CREATIVE_TAB_ARRAY) {
            if (ct.getTabLabel().equalsIgnoreCase(name)) return ct;
        }
        return tab;
    }

    public static void loadBlocks() {
        CJPE.b.getCategoryNames().forEach(c -> new ConfigBlock(CJPE.b.getCategory(c)));
        items.forEach(block -> {
            GameRegistry.register(block);
            GameRegistry.register(new ItemBlock(block).setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName()));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(CJPE.MODID), "inventory"));
        });
    }
}
