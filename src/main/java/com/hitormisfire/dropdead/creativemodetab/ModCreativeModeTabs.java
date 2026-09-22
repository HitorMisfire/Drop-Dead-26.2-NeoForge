package com.hitormisfire.dropdead.creativemodetab;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DropDead.MOD_ID);

    public static final Supplier<CreativeModeTab> DROPDEAD_ITEMS_TAB = CREATIVE_MODE_TABS.register("dropdead_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FOSSIL.get()))
                    .title(Component.translatable("creativetab.dropdead.dropdead_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .withTabsAfter(Identifier.fromNamespaceAndPath(DropDead.MOD_ID, "dropdead_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FOSSIL);
                        output.accept(ModItems.PYRITE);
                        output.accept(ModItems.WOOL_BALL);
                        output.accept(ModItems.UNFIRED_BOWL);

                        output.accept(ModItems.BOW_DRILL);
                        output.accept(ModItems.SHARP_BOW_DRILL);
                        output.accept(ModItems.STONE_ADZE);

                    }).build());

    public static final Supplier<CreativeModeTab> DROPDEAD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("dropdead_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PYRITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.dropdead.dropdead_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PYRITE_BLOCK);
                        output.accept(ModBlocks.PYRITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_PYRITE_ORE);
                        output.accept(ModBlocks.FOSSIL_BLOCK);
                        output.accept(ModBlocks.OAK_SPLIT_LOG);
                        output.accept(ModBlocks.LOOSE_COBBLESTONE);


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
