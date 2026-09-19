package com.hitormisfire.dropdead.block;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.custom.ModFallingBlock;
import com.hitormisfire.dropdead.block.custom.SplitLogBlock;
import com.hitormisfire.dropdead.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(DropDead.MOD_ID);

    public static ResourceKey<Block> getRK(Block block) {
       return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    public static final DeferredBlock<Block> PYRITE_BLOCK = registerBlock("pyrite_block",
            properties -> new Block(properties.destroyTime(4f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> PYRITE_ORE = registerBlock("pyrite_ore",
            properties -> new Block(properties.destroyTime(3f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_PYRITE_ORE = registerBlock("deepslate_pyrite_ore",
            properties -> new Block(properties.destroyTime(5f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> FOSSIL_BLOCK = registerBlock("fossil_block",
            properties -> new RotatedPillarBlock(properties.destroyTime(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final DeferredBlock<Block> OAK_SPLIT_LOG = registerBlock("oak_split_log",
            properties -> new SplitLogBlock(properties.destroyTime(2f)
                    .ignitedByLava().sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LOOSE_COBBLESTONE = registerBlock("loose_cobblestone",
            properties -> new ModFallingBlock(properties.destroyTime(1.5f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
