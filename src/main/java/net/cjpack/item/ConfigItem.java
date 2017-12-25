package net.cjpack.item;

import net.cjpack.CCT;
import net.cjpack.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.actors.threadpool.Arrays;

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

    public List<String> mods;
    public ConfigCategory c;

    public ConfigItem(ConfigCategory c) {
        this.c = c;
        this.setUnlocalizedName(c.get("unlocalizedName").getString());
        this.setRegistryName(new ResourceLocation(Reference.MODID, c.get("registryName").getString()));
        this.setCreativeTab(c.get("tab").getString() != null ? getTabByName(c.get("tab").getString()) : tab);
        this.setMaxDamage(c.get("durability").getString() != null ? c.get("durability").getInt() : 1);
        this.setMaxStackSize(c.get("size").getString() != null ? c.get("size").getInt() : 64);
        this.mods = c.get("mods").getStringList() != null ? Arrays.asList(c.get("mods").getStringList()) : new ArrayList<>();
        items.add(this);
    }

    public static CreativeTabs getTabByName(String name){
        for (CreativeTabs ct : CreativeTabs.CREATIVE_TAB_ARRAY) {
            if(ct.getTabLabel().equalsIgnoreCase(name)) return ct;
        }
        return tab;
    }

    public boolean hasEffect(ItemStack stack) {
        return mods.contains("effect");
    }

    public boolean isBeaconPayment(ItemStack stack) {
        return mods.contains("beacon");
    }

    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return mods.contains("enchant");
    }

    public boolean isDamageable() {
        return mods.contains("damageable");
    }

    public boolean isRepairable() {
        return super.isRepairable();
    }

    public static void loadItems(){
        CCT.i.getCategoryNames().forEach(c -> new ConfigItem(CCT.i.getCategory(c)));
    }
}
