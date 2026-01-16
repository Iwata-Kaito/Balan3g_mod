package net.iwata.balan3g_mod.item;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Balan3g_mod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Balan3g_mod_tab = CREATIVE_MODE_TABS.register("balan3g_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Balan.get()))
                    .title(Component.translatable("creativetab.balan3g_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.Balan.get());
                        pOutput.accept(ModItems.Tied_up_Balan.get());
                        pOutput.accept(ModItems.Boxed_balan.get());
                        pOutput.accept(ModItems.Balan_Key.get());
                        pOutput.accept(ModItems.broken_Balan_Key.get());

                        pOutput.accept(ModBlocks.Crate_of_Balan.get());
                        pOutput.accept(ModBlocks.Key_block.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
