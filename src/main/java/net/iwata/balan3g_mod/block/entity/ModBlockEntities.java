package net.iwata.balan3g_mod.block.entity;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Balan3g_mod.MOD_ID);

    public static final RegistryObject<BlockEntityType<AnimatedBlockEntity>> Corpses_of_Tokkitai =
            BLOCK_ENTITIES.register("corpses_of_tokkitai_entity", () ->
                    BlockEntityType.Builder.of(AnimatedBlockEntity::new,
                            ModBlocks.Corpses_of_Tokkitai.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
