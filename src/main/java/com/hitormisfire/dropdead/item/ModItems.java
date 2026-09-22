package com.hitormisfire.dropdead.item;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.item.custom.AdzeItem;
import com.hitormisfire.dropdead.item.custom.BowDrillItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
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
    public static final DeferredItem<Item> WOOL_BALL = ITEMS.registerSimpleItem("wool_ball");
    public static final DeferredItem<Item> UNFIRED_BOWL = ITEMS.registerSimpleItem("unfired_bowl");


    public static final DeferredItem<Item> BOW_DRILL = ITEMS.registerItem("bow_drill",
        properties -> new BowDrillItem(properties.useCooldown(2).durability(24)));
    public static final DeferredItem<Item> SHARP_BOW_DRILL = ITEMS.registerItem("sharp_bow_drill",
        properties -> new BowDrillItem(properties.pickaxe(ModToolMaterials.BOW_DRILL,0,0)
                .useCooldown(2)));
    public static final DeferredItem<Item> STONE_ADZE = ITEMS.registerItem("stone_adze",
        properties -> new AdzeItem(ToolMaterial.STONE,0,0,properties));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}