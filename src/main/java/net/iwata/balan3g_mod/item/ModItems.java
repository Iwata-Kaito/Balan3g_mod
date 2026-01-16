package net.iwata.balan3g_mod.item;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Balan3g_mod.MOD_ID);

    public static final RegistryObject<Item> Balan = ITEMS.register("balan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Tied_up_Balan = ITEMS.register("tied_up_balan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Boxed_balan = ITEMS.register("boxed_balan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> broken_Balan_Key = ITEMS.register("broken_balan_key",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Balan_Key = ITEMS.register("balan_key",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
