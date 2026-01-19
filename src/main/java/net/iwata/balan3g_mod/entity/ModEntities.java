package net.iwata.balan3g_mod.entity;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_BalanEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Balan3g_mod.MOD_ID);

    public static final RegistryObject<EntityType<Living_BalanEntities>> Living_Balan =
            ENTITY_TYPES.register("living_balan", () -> EntityType.Builder.of(Living_BalanEntities::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.8f).build("living_balan"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
