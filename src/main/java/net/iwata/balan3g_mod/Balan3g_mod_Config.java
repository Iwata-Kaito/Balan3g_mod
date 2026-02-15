package net.iwata.balan3g_mod;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;

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
            .defineInRange("Protect_Gear_threshold", 10, 0, Long.MAX_VALUE);

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ALLOWED_EFFECTS = BUILDER
            .comment("")
            .comment("Effects not blocked by Protect Gear")
            .defineListAllowEmpty(
                    "protect_gear_allowed_effects",
                    List.of("minecraft:bad_omen",
                            "minecraft:dolphins_grace",
                            "minecraft:night_vision",
                            "minecraft:water_breathing",
                            "minecraft:fire_resistance",
                            "minecraft:resistance"),
                    v -> v instanceof String s && ResourceLocation.isValidResourceLocation(s)
            );

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static long spawn_count;
    public static long Protect_Gear_threshold;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        spawn_count = SPAWN_COUNT.get();
        Protect_Gear_threshold = Protect_Gear_THRESHOLD.get();
    }
}