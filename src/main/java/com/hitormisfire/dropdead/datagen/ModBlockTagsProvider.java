package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DropDead.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //TOOL TAGS
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.PYRITE_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.PYRITE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.FOSSIL_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.LOOSE_COBBLESTONE.get()));

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.OAK_SPLIT_LOG.get()));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.PYRITE_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.PYRITE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.DEEPSLATE_PYRITE_ORE.get()));

        tag(ModTags.Blocks.INCORRECT_FOR_BOW_DRILL)
                .addTag(BlockTags.INCORRECT_FOR_WOODEN_TOOL);

        tag(BlockTags.INCORRECT_FOR_COPPER_TOOL)
                .remove(BlockTags.GOLD_ORES);

        //WOOD LOG TAGS
        tag(ModTags.Blocks.OAK_SPLITTABLE)
                .add(ModBlocks.getRK(Blocks.OAK_LOG))
                .add(ModBlocks.getRK(Blocks.OAK_WOOD));
    }
}
