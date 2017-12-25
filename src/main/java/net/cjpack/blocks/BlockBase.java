package net.cjpack.blocks;

import net.cjpack.ModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import static net.cjpack.CCT.proxy;

public class BlockBase extends Block implements ModelProvider {

    protected String name;

    public BlockBase(Material material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }


    @Override
    public void registerModels(Item item) {
        proxy.registerRenderer(item, 0, name);
    }
}
