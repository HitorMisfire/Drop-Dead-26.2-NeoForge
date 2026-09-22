package com.hitormisfire.dropdead.datamap;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public record BarkDroppable(Item barkItem) {
    public static final Codec<BarkDroppable> BARK_ITEM_CODEC = BuiltInRegistries.ITEM.byNameCodec()
            .xmap(BarkDroppable::new, BarkDroppable::barkItem);

    public static final Codec<BarkDroppable> CODEC = Codec.withAlternative(
            RecordCodecBuilder.create(inst -> inst.group(
                            BuiltInRegistries.ITEM.byNameCodec().fieldOf("bark_item")
                                    .forGetter(BarkDroppable::barkItem))
                    .apply(inst, BarkDroppable::new)),
            BARK_ITEM_CODEC);
}
