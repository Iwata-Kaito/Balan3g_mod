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

    public static final ForgeConfigSpec.ConfigValue<List<? extends Double>> For_Administrator = BUILDER
            .comment("")
            .comment("For Administrator(Double)")
            .defineListAllowEmpty(
                    "for_administrator",
                    List.of(800.0D, 2.8D, 300.0D, 1.0D,40.0D, 0.90D, 0.999D),
                    v -> v instanceof Double
            );

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static long spawn_count;
    public static long Protect_Gear_threshold;

    public static double FIRE_RPM;
    public static double BULLET_SPEED;
    public static double MAX_HEALTH;
    public static double MAUSER_AMMO_DAMAGE;
    public static double MAUSER_AMMO_MAX_LIFE_TICKS;
    public static double MAUSER_AMMO_HURT;
    public static double MAUSER_AMMO_SETHEALTH;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        spawn_count = SPAWN_COUNT.get();
        Protect_Gear_threshold = Protect_Gear_THRESHOLD.get();

        List<? extends Double> for_administrator = For_Administrator.get();
        FIRE_RPM = for_administrator.get(0);
        BULLET_SPEED = for_administrator.get(1);
        MAX_HEALTH = for_administrator.get(2);
        MAUSER_AMMO_DAMAGE = for_administrator.get(3);
        MAUSER_AMMO_MAX_LIFE_TICKS = for_administrator.get(4);
        MAUSER_AMMO_HURT = for_administrator.get(5);
        MAUSER_AMMO_SETHEALTH = for_administrator.get(6);
    }
}