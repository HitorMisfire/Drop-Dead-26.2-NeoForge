package com.hitormisfire.dropdead.item.custom;

import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class BowDrillItem extends Item {
    public BowDrillItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = level.getBlockState(clickedPos);
        BlockState lightable = state.getToolModifiedState(context, ItemAbilities.FIRESTARTER_LIGHT, false);

        if (!level.isClientSide()) {
            float lightChance = level.getRandom().nextFloat();
            ItemStack itemStack = context.getItemInHand();
            BlockPos relativePos = clickedPos.relative(context.getClickedFace());
            if (lightChance < .85) {
                level.playSound(null, relativePos, SoundEvents.ARMOR_STAND_HIT, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
                itemStack.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
                return InteractionResult.FAIL;
            } else {
                if (lightable == null) {
                    if (BaseFireBlock.canBePlacedAt(level, relativePos, context.getHorizontalDirection())) {
                        level.playSound(null, relativePos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 0.9F, level.getRandom().nextFloat() * 0.4F + 0.8F);
                        BlockState fireState = BaseFireBlock.getState(level, relativePos);
                        level.setBlock(relativePos, fireState, 11);
                        level.gameEvent(player, GameEvent.BLOCK_PLACE, clickedPos);
                        if (player instanceof ServerPlayer) {
                            ServerPlayer serverPlayer = (ServerPlayer)player;
                            CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, relativePos, itemStack);
                            itemStack.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
                            itemStack.finishUsingItem(level,player);
                        }

                        return InteractionResult.SUCCESS;
                    } else {
                        return InteractionResult.FAIL;
                    }
                } else {
                    level.playSound(null, clickedPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 0.9F, level.getRandom().nextFloat() * 0.4F + 0.8F);
                    level.setBlock(clickedPos, lightable, 11);
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, clickedPos);
                    itemStack.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
                    itemStack.finishUsingItem(level,player);
                }
            }

        }

        return InteractionResult.SUCCESS;
    }

    public boolean canPerformAction(ItemInstance stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_FLINT_ACTIONS.contains(itemAbility);
    }

}
