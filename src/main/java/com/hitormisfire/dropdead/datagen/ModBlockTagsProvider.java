package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DropDead.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.PYRITE_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.PYRITE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.FOSSIL_BLOCK.get()));

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.OAK_SPLIT_LOG.get()));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.PYRITE_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.PYRITE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE.get()));

    }
}
