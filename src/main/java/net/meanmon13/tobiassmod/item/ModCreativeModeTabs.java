package net.meanmon13.tobiassmod.item;

import net.meanmon13.tobiassmod.TobiassMod;
import net.meanmon13.tobiassmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TobiassMod.MODID);

    public static final Supplier<CreativeModeTab> TOBIASS_TAB = CREATIVE_MODE_TAB.register(
            "tobiass_tab",
            ()-> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.tobiassmod.tobiass_tab"))
                    .displayItems((itemDisplayParameters, output) ->{
                        //Add items to Tobias's Tab
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);

                        //Add blocks to Tobias's Tab
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);

                        output.accept(ModBlocks.KILL_BUTTON);

                    }).build()
    );


    public static final void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }



}
