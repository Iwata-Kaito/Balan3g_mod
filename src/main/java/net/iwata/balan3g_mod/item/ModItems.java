package net.iwata.balan3g_mod.item;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.ModEntities;
import net.iwata.balan3g_mod.item.custom.Mauser_Ammo_Test;
import net.iwata.balan3g_mod.item.custom.Protect_GearItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
    public static final RegistryObject<Item> BOXED_BALAN = ITEMS.register("boxed_balan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> broken_Balan_Key = ITEMS.register("broken_balan_key",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Balan_Key = ITEMS.register("balan_key",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Living_Balan_SPANW_EGG = ITEMS.register("living_balan_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.Living_Balan, 0x0a8208, 0x0a6408, new Item.Properties()));
    public static final RegistryObject<Item> Living_Boxed_Balan_SPANW_EGG = ITEMS.register("living_boxed_balan_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.Living_Boxed_Balan, 0xffffff, 0x0a6408, new Item.Properties()));
    public static final RegistryObject<Item> Fried_Balan = ITEMS.register("fried_balan",
            () -> new Item(new Item.Properties().food(ModFoods.FRIED_BALAN)));

    public static final RegistryObject<Item> Protectgear_Helmet = ITEMS.register("protect_gear_helmet",
            () -> new Protect_GearItem(ModArmorMaterials.Protect_Gear, Protect_GearItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> Protectgear_Chestplate = ITEMS.register("protect_gear_chestplate",
            () -> new Protect_GearItem(ModArmorMaterials.Protect_Gear, Protect_GearItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> Protectgear_Leggings = ITEMS.register("protect_gear_leggings",
            () -> new Protect_GearItem(ModArmorMaterials.Protect_Gear, Protect_GearItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> Protectgear_Boots = ITEMS.register("protect_gear_boots",
            () -> new Protect_GearItem(ModArmorMaterials.Protect_Gear, Protect_GearItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> MAUSER_AMMO_TEST = ITEMS.register("mauser_ammo_test",
            () -> new Mauser_Ammo_Test(new Item.Properties().stacksTo(1), 1.8, 0));


    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
