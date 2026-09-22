package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDeadDataMaps;
import com.hitormisfire.dropdead.datamap.BarkDroppable;
import com.hitormisfire.dropdead.item.ModItems;
import com.hitormisfire.dropdead.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
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
                .add(Blocks.OAK_LOG.builtInRegistryHolder(), new BarkDroppable(ModItems.FOSSIL.get()),false);

    }
}
