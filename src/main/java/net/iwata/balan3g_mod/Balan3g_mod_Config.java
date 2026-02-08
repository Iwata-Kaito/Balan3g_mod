package net.iwata.balan3g_mod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Balan3g_mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Balan3g_mod_Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.LongValue SPAWN_COUNT = BUILDER
            .comment("Spawn Count")
            .comment("Count spawned from Key Block")
            .defineInRange("spawn_count", 3, 1, Long.MAX_VALUE);

    public static final ForgeConfigSpec.LongValue Protect_Gear_THRESHOLD = BUILDER
            .comment("")
            .comment("Protect Gear Threshold")
            .defineInRange("protect_Gear_threshold", 10, 0, Long.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static long spawn_count;
    public static long protect_Gear_threshold;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        spawn_count = SPAWN_COUNT.get();
        protect_Gear_threshold = Protect_Gear_THRESHOLD.get();
    }
}