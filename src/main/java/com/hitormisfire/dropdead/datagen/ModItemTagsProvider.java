package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.item.ModItems;
import com.hitormisfire.dropdead.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DropDead.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.OAK_SPLITTABLE)
                .add(ModItems.getRK(Items.OAK_LOG))
                .add(ModItems.getRK(Items.OAK_WOOD));

        tag(ModTags.Items.SPLIT_LOGS)
                .add(ModItems.getRK(ModBlocks.OAK_SPLIT_LOG.asItem()));

        tag(ModTags.Items.BOW_DRILL_REPAIRABLE)
                .add(ModItems.getRK(Items.STICK));
        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(ModItems.BOW_DRILL.get()));
        tag(ModTags.Items.BOW_DRILL_BITS)
                .add(ModItems.getRK(Items.FLINT))
                .addTag(ItemTags.METAL_NUGGETS);

        tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModItems.getRK(ModBlocks.LOOSE_COBBLESTONE.asItem()));

        tag(ModTags.Items.WOOD_BARK)
                .add(ModItems.getRK(ModItems.OAK_BARK.get()))
                .add(ModItems.getRK(ModItems.BIRCH_BARK.get()))
                .add(ModItems.getRK(ModItems.SPRUCE_BARK.get()))
                .add(ModItems.getRK(ModItems.JUNGLE_BARK.get()))
                .add(ModItems.getRK(ModItems.DARK_OAK_BARK.get()))
                .add(ModItems.getRK(ModItems.ACACIA_BARK.get()))
                .add(ModItems.getRK(ModItems.CHERRY_BARK.get()))
                .add(ModItems.getRK(ModItems.MANGROVE_BARK.get()))
                .add(ModItems.getRK(ModItems.PALE_OAK_BARK.get()));
    }
}
