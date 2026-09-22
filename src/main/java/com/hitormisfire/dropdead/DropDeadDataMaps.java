package com.hitormisfire.dropdead;

import com.hitormisfire.dropdead.datamap.BarkDroppable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

public class DropDeadDataMaps {

    public static final DataMapType<Block, BarkDroppable> BARK_DROPPABLES = DataMapType.builder(
            id("bark_droppables"), Registries.BLOCK, BarkDroppable.CODEC).synced(BarkDroppable.BARK_ITEM_CODEC, false).build();

    private static Identifier id(final String name) {
        return Identifier.fromNamespaceAndPath(DropDead.MOD_ID, name);
    }

    @SubscribeEvent
    private static void register(final RegisterDataMapTypesEvent event) {
        event.register(BARK_DROPPABLES);
    }
}
