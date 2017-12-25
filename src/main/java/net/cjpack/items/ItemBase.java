package net.cjpack.items;

import net.cjpack.ModelProvider;
import net.minecraft.item.Item;

import static net.cjpack.CCT.proxy;

public class ItemBase extends Item implements ModelProvider {


    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    public void registerModels(Item item) {
        proxy.registerRenderer(item, 0, name);
    }
}
