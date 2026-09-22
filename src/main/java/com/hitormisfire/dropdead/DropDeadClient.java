package com.hitormisfire.dropdead;

import com.hitormisfire.dropdead.datamap.BarkDroppable;
import com.hitormisfire.dropdead.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = DropDead.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = DropDead.MOD_ID, value = Dist.CLIENT)
public class DropDeadClient {
    public DropDeadClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        DropDead.LOGGER.info("HELLO FROM CLIENT SETUP");
        DropDead.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void onToolModification(BlockEvent.BlockToolModificationEvent event){
        if (event.getItemAbility() != ItemAbilities.AXE_STRIP) return;
        if (event.isSimulated()) return; // don't drop items during simulation/preview

        Level level = (Level) event.getLevel();
        BlockState state = event.getState();

        BarkDroppable bark = state.getBlock().builtInRegistryHolder()
                .getData(DropDeadDataMaps.BARK_DROPPABLES);

        if (bark != null) {
            Direction face = event.getContext() != null
                    ? event.getContext().getClickedFace()
                    : Direction.UP;
            Block.popResourceFromFace(level, event.getPos(), face, new ItemStack(bark.barkItem()));

        }

    }
}
