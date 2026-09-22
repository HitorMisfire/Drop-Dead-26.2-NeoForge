package com.hitormisfire.dropdead.datamap;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public record BarkDroppable(Item barkItem) {
    public static final Codec<BarkDroppable> CODEC = BuiltInRegistries.ITEM.byNameCodec()
            .xmap(BarkDroppable::new, BarkDroppable::barkItem)
            .fieldOf("bark_item").codec();
}
