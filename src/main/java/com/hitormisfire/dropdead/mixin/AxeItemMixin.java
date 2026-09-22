package com.hitormisfire.dropdead.mixin;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.DropDeadDataMaps;
import com.hitormisfire.dropdead.datamap.BarkDroppable;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {


    @Inject(method = "getAxeStrippingState",
            at = @At("HEAD"), cancellable = true)
    private static void getBarkState(BlockState originalState, CallbackInfoReturnable<Item> cir) {
        BarkDroppable barkDroppable = (BarkDroppable) originalState.getData(DropDeadDataMaps.BARK_DROPPABLES);
        if (barkDroppable != null) {
            cir.setReturnValue(barkDroppable.barkItem());
        }
        DropDead.LOGGER.info(String.valueOf(cir.getReturnValue()));
    }
}
