package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.DropDeadDataMaps;
import com.hitormisfire.dropdead.datamap.BarkDroppable;
import com.hitormisfire.dropdead.item.ModItems;
import com.hitormisfire.dropdead.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModTags.Items.SPLIT_LOGS, new FurnaceFuel(300), false)
                .add(ModItems.WOOL_BALL, new FurnaceFuel(100), false);

        builder(DropDeadDataMaps.BARK_DROPPABLES)
                .add(Blocks.OAK_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.OAK_BARK.get()),false)
                .add(Blocks.BIRCH_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.BIRCH_BARK.get()),false)
                .add(Blocks.SPRUCE_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.SPRUCE_BARK.get()),false)
                .add(Blocks.JUNGLE_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.JUNGLE_BARK.get()),false)
                .add(Blocks.DARK_OAK_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.DARK_OAK_BARK.get()),false)
                .add(Blocks.ACACIA_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.ACACIA_BARK.get()),false)
                .add(Blocks.CHERRY_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.CHERRY_BARK.get()),false)
                .add(Blocks.MANGROVE_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.MANGROVE_BARK.get()),false)
                .add(Blocks.PALE_OAK_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.PALE_OAK_BARK.get()),false)
                .add(Blocks.OAK_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.OAK_BARK.get()),false)
                .add(Blocks.BIRCH_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.BIRCH_BARK.get()),false)
                .add(Blocks.SPRUCE_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.SPRUCE_BARK.get()),false)
                .add(Blocks.JUNGLE_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.JUNGLE_BARK.get()),false)
                .add(Blocks.DARK_OAK_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.DARK_OAK_BARK.get()),false)
                .add(Blocks.ACACIA_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.ACACIA_BARK.get()),false)
                .add(Blocks.CHERRY_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.CHERRY_BARK.get()),false)
                .add(Blocks.MANGROVE_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.MANGROVE_BARK.get()),false)
                .add(Blocks.PALE_OAK_WOOD.builtInRegistryHolder(), new BarkDroppable(ModItems.PALE_OAK_BARK.get()),false);

    }
}
