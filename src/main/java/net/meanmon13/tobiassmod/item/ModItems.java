package net.meanmon13.tobiassmod.item;

import net.meanmon13.tobiassmod.TobiassMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TobiassMod.MODID);

    public static  final DeferredItem<Item> BISMUTH = ITEMS.register(
            "bismuth",
            ()-> new Item(new Item.Properties())
    );
    public static  final DeferredItem<Item> RAW_BISMUTH = ITEMS.register(
            "raw_bismuth",
            ()-> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
    // ------------------------------------------------------------------------

}
