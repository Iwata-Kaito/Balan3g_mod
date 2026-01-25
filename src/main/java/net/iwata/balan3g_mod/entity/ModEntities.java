package net.iwata.balan3g_mod.entity;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_BalanEntity;
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
                            .sized(0.6f, 0.9f)
                            .build(new ResourceLocation(Balan3g_mod.MOD_ID, "living_balan").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
