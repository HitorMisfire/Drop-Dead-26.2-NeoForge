package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.block.custom.SegmentableLog;
import com.hitormisfire.dropdead.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SegmentableBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;
import java.util.stream.IntStream;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PYRITE_BLOCK.get());
        dropSelf(ModBlocks.FOSSIL_BLOCK.get());

        add(ModBlocks.OAK_SPLIT_LOG.get(), this::createSegmentedLogDrops);

        add(ModBlocks.PYRITE_ORE.get(),
                createOreDrop(ModBlocks.PYRITE_ORE.get(), ModItems.PYRITE.get()));
        add(ModBlocks.DEEPSLATE_PYRITE_ORE.get(),
                createOreDrop(ModBlocks.DEEPSLATE_PYRITE_ORE.get(), ModItems.PYRITE.get()));
    }





    public LootTable.Builder createSegmentedLogDrops(Block block) {
        LootTable.Builder var10000;
        if (block instanceof SegmentableLog segmentableLog) {
            var10000 = LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add((LootPoolEntryContainer.Builder)this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(IntStream.rangeClosed(1, 4).boxed().toList(), (count) -> SetItemCountFunction.setCount(ConstantValue.exactly((float)count)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.predicates.StatePropertiesPredicate.Builder.properties().hasProperty(segmentableLog.getSegmentAmountProperty(), count)))))));
        } else {
            var10000 = noDrop();
        }

        return var10000;
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
