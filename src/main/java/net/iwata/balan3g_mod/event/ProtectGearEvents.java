package net.iwata.balan3g_mod.event;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.Balan3g_mod_Config;
import net.iwata.balan3g_mod.item.custom.Protect_GearItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Balan3g_mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ProtectGearEvents {

    private static long THRESHOLD = 5;

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        THRESHOLD = Balan3g_mod_Config.Protect_Gear_THRESHOLD.get();
        LivingEntity living = event.getEntity();
        if (living.level().isClientSide) return;

        if (!isWearingFullProtectGear(living)) return;

        long dmg = (long) event.getAmount();
        if (dmg <= 0.0f) return;

        if (dmg <= THRESHOLD) {
            event.setAmount(0.0f);
            return;
        }

        event.setAmount(Math.max(0.0f, (float) dmg / 2));
    }

    @SubscribeEvent
    public static void onEffectApplicable(MobEffectEvent.Applicable event) {
        LivingEntity living = event.getEntity();
        if (living.level().isClientSide) return;

        if (!isWearingFullProtectGear(living)) return;

        MobEffect effect = event.getEffectInstance().getEffect();

        if (effect.getCategory() == MobEffectCategory.HARMFUL) {
            if (effect == MobEffects.BAD_OMEN || effect == MobEffects.DOLPHINS_GRACE) {
                return;
            }
            event.setResult(MobEffectEvent.Applicable.Result.DENY);
        }
    }

    private static boolean isWearingFullProtectGear(LivingEntity living) {
        return isProtectGear(living.getItemBySlot(EquipmentSlot.HEAD))
                && isProtectGear(living.getItemBySlot(EquipmentSlot.CHEST))
                && isProtectGear(living.getItemBySlot(EquipmentSlot.LEGS))
                && isProtectGear(living.getItemBySlot(EquipmentSlot.FEET));
    }

    private static boolean isProtectGear(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() instanceof Protect_GearItem;
    }

    @SubscribeEvent
    public static void onPlayerTickGiveBuffs(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        var player = event.player;
        if (player.level().isClientSide) return;

        if (!isWearingFullProtectGear(player)) return;

        ensureEffect(player, MobEffects.NIGHT_VISION, 310, 0);
        ensureEffect(player, MobEffects.FIRE_RESISTANCE, 310, 0);
        ensureEffect(player, MobEffects.WATER_BREATHING, 310, 0);
    }

    private static void ensureEffect(net.minecraft.world.entity.LivingEntity entity, net.minecraft.world.effect.MobEffect effect, int durationTicks, int amplifier) {
        var current = entity.getEffect(effect);

        if (current != null && current.getDuration() > 300) return;

        entity.addEffect(new MobEffectInstance(effect, durationTicks, amplifier, true, false, false));
    }
}
