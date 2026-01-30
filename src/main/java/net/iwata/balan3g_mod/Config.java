package net.iwata.balan3g_mod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Balan3g_mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.LongValue SPAWN_COUNT = BUILDER
            .comment("Spawn Count")
            .comment("Count spawned from Key Block")
            .defineInRange("spawn_count", 3, 1, Long.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static long spawn_count;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        spawn_count = SPAWN_COUNT.get();
    }
}
