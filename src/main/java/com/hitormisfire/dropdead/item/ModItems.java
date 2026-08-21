package com.hitormisfire.dropdead.item;

import com.hitormisfire.dropdead.DropDead;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DropDead.MOD_ID);
    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }


    public static final DeferredItem<Item> FOSSIL = ITEMS.registerSimpleItem("fossil");
    public static final DeferredItem<Item> PYRITE = ITEMS.registerSimpleItem("pyrite");





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
