package net.iwata.balan3g_mod.entity;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_BalanEntity;
import net.iwata.balan3g_mod.entity.custom.Living_Boxed_BalanEntity;
import net.iwata.balan3g_mod.entity.custom.Mauser_AmmoEntity;
import net.iwata.balan3g_mod.entity.custom.Tokkitai_Valine3gEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Balan3g_mod.MOD_ID);

    public static final RegistryObject<EntityType<Living_BalanEntity>> Living_Balan =
            ENTITY_TYPES.register("living_balan",
                    () -> EntityType.Builder.of(Living_BalanEntity::new, MobCategory.MONSTER)
                            .sized(0.7f, 0.9f)
                            .build(ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "living_balan").toString()));

    public static final RegistryObject<EntityType<Living_Boxed_BalanEntity>> Living_Boxed_Balan =
            ENTITY_TYPES.register("living_boxed_balan",
                    () -> EntityType.Builder.of(Living_Boxed_BalanEntity::new, MobCategory.MONSTER)
                            .sized(0.9f, 0.9f)
                            .build(ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "living_boxed_balan").toString()));

    public static final RegistryObject<EntityType<Tokkitai_Valine3gEntity>> Tokkitai_Valine3g =
            ENTITY_TYPES.register("tokkitai_valine3g",
                    () -> EntityType.Builder.of(Tokkitai_Valine3gEntity::new, MobCategory.CREATURE)
                            .sized(0.6f, 1.8f)
                            .build(ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "tokkitai_valine3g").toString()));

    public static final RegistryObject<EntityType<Mauser_AmmoEntity>> Mauser_Ammo =
            ENTITY_TYPES.register("mauser_ammo",
                    () -> EntityType.Builder.<Mauser_AmmoEntity>of(Mauser_AmmoEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .build(ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "mauser_ammo").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
