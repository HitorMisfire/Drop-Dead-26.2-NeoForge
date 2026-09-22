package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, DropDead.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.FOSSIL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PYRITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.WOOL_BALL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.UNFIRED_BOWL.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.BOW_DRILL.get(),ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.SHARP_BOW_DRILL.get(),ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STONE_ADZE.get(),ModelTemplates.FLAT_HANDHELD_ITEM);

        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.PYRITE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.PYRITE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_PYRITE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.LOOSE_COBBLESTONE.get());

        blockModels.createRotatedPillarWithHorizontalVariant(ModBlocks.FOSSIL_BLOCK.get(), TexturedModel.COLUMN_ALT,TexturedModel.COLUMN_HORIZONTAL_ALT);

        blockModels.createNonTemplateModelBlock(ModBlocks.OAK_SPLIT_LOG.get());
    }
}
