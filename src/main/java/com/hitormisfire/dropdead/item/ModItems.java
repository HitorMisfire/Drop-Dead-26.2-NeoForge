package com.hitormisfire.dropdead.item;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.item.custom.AdzeItem;
import com.hitormisfire.dropdead.item.custom.BowDrillItem;
import io.netty.resolver.DefaultHostsFileEntriesResolver;
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
    public static final DeferredItem<Item> BOWL_OF_WATER = ITEMS.registerSimpleItem("bowl_of_water");
    public static final DeferredItem<Item> BOWL_OF_TANNIN = ITEMS.registerSimpleItem("bowl_of_tannin");
    public static final DeferredItem<Item> RAWHIDE = ITEMS.registerSimpleItem("rawhide");

    public static final DeferredItem<Item> OAK_BARK = ITEMS.registerSimpleItem("oak_bark");
    public static final DeferredItem<Item> BIRCH_BARK = ITEMS.registerSimpleItem("birch_bark");
    public static final DeferredItem<Item> SPRUCE_BARK = ITEMS.registerSimpleItem("spruce_bark");
    public static final DeferredItem<Item> JUNGLE_BARK = ITEMS.registerSimpleItem("jungle_bark");
    public static final DeferredItem<Item> DARK_OAK_BARK = ITEMS.registerSimpleItem("dark_oak_bark");
    public static final DeferredItem<Item> ACACIA_BARK = ITEMS.registerSimpleItem("acacia_bark");
    public static final DeferredItem<Item> CHERRY_BARK = ITEMS.registerSimpleItem("cherry_bark");
    public static final DeferredItem<Item> MANGROVE_BARK = ITEMS.registerSimpleItem("mangrove_bark");
    public static final DeferredItem<Item> PALE_OAK_BARK = ITEMS.registerSimpleItem("pale_oak_bark");



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