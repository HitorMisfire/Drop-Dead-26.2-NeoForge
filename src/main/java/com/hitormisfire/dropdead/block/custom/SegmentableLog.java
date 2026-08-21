package com.hitormisfire.dropdead.block.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.function.Function;

public interface SegmentableLog {
    int MIN_SEGMENT = 1;
    int MAX_SEGMENT = 4;
    IntegerProperty AMOUNT = BlockStateProperties.SEGMENT_AMOUNT;

    default Function<BlockState, VoxelShape> getShapeCalculator(EnumProperty<Direction> facing, IntegerProperty amount) {
        Map<Direction, VoxelShape> shapes = Shapes.rotateHorizontal(Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)8.0F, this.getShapeHeight(), (double)8.0F));
        Map<Direction, VoxelShape> shape3 = Shapes.rotateHorizontal(Shapes.or(Block.box((double)8.0F, (double)0.0F, (double)0.0F, (double)16.0F, this.getShapeHeight(), (double)8.0F), Block.box((double)0.0F, (double)0.0F, (double)8.0F, (double)16.0F, this.getShapeHeight(), (double)16.0F)));
        return (state) -> {
            VoxelShape shape = Shapes.empty();
            Direction direction = (Direction)state.getValue(facing);
            int count = (Integer)state.getValue(amount);

            for(int i = 0; i < count; ++i) {
                shape = Shapes.or(shape, (VoxelShape)shapes.get(direction));
                direction = direction.getClockWise();
            } if (count == 3) {
                shape = (VoxelShape)shape3.get(direction);
            }

            return shape;
        };
    }

    default IntegerProperty getSegmentAmountProperty() {
        return AMOUNT;
    }

    default double getShapeHeight() {
        return (double)16.0F;
    }

    default boolean canBeReplaced(BlockState state, BlockPlaceContext context, IntegerProperty segment) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(state.getBlock().asItem()) && (Integer)state.getValue(segment) < 4;
    }

    default BlockState getStateForPlacement(BlockPlaceContext context, Block block, IntegerProperty segment, EnumProperty<Direction> facing) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        return state.is(block) ? (BlockState)state.setValue(segment, Math.min(4, (Integer)state.getValue(segment) + 1)) : (BlockState)block.defaultBlockState().setValue(facing, context.getHorizontalDirection());
    }
}
