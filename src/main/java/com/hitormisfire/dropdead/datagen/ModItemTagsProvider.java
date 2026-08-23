package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.item.ModItems;
import com.hitormisfire.dropdead.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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

    }
}
