package net.iwata.balan3g_mod;

import com.mojang.logging.LogUtils;
import net.iwata.balan3g_mod.block.ModBlocks;
import net.iwata.balan3g_mod.entity.ModEntities;
import net.iwata.balan3g_mod.entity.client.Living_BalanRenderer;
import net.iwata.balan3g_mod.entity.client.Living_Boxed_BalanRenderer;
import net.iwata.balan3g_mod.entity.client.Tokkitai_Valine3gRenderer;
import net.iwata.balan3g_mod.item.ModCreativeModTabs;
import net.iwata.balan3g_mod.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Balan3g_mod.MOD_ID)
@SuppressWarnings("removal")
public class Balan3g_mod {
    public static final String MOD_ID = "balan3g_mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Balan3g_mod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        FMLJavaModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Balan3g_mod_Config.SPEC, "Balan3g_mod_Config.toml");

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        GeckoLib.initialize();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.Balan);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.Living_Balan.get(), Living_BalanRenderer::new);
            EntityRenderers.register(ModEntities.Living_Boxed_Balan.get(), Living_Boxed_BalanRenderer::new);
            EntityRenderers.register(ModEntities.Tokkitai_Valine3g.get(), Tokkitai_Valine3gRenderer::new);
        }
    }
}