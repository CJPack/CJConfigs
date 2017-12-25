package net.cjpack.items;

import net.cjpack.ModelProvider;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CCTItems {

    /***
     * Example:
     * public static ItemBase pad;
     */


    public static void init() {
        /**
         * Example:
         * pad = register(new ItemBase("pad"));
         */


    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ModelProvider) {
            ((ModelProvider) item).registerModels(item);
        }

        return item;
    }
}
