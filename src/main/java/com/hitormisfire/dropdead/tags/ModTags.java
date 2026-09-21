package com.hitormisfire.dropdead.tags;

import com.hitormisfire.dropdead.DropDead;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> OAK_SPLITTABLE = createTag("oak_splittable");

        public static final TagKey<Block> INCORRECT_FOR_BOW_DRILL = createTag("incorrect_for_bow_drill");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(DropDead.MOD_ID, name));
        }
    }
    public static class Items{

        public static final TagKey<Item> OAK_SPLITTABLE = createTag("oak_splittable");
        public static final TagKey<Item> SPLIT_LOGS = createTag("split_logs");

        public static final TagKey<Item> BOW_DRILL_REPAIRABLE = createTag("bow_drill_repairable");
        public static final TagKey<Item> BOW_DRILL_BITS = createTag("bow_drill_bits");

        public static final TagKey<Item> WOOD_BARK = createTag("wood_bark");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(DropDead.MOD_ID, name));
        }
    }
}
