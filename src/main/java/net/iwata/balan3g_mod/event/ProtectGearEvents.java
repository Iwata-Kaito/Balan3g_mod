package net.iwata.balan3g_mod.event;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.Balan3g_mod_Config;
import net.iwata.balan3g_mod.item.ModItems;
import net.iwata.balan3g_mod.item.custom.Protect_GearItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static net.iwata.balan3g_mod.Balan3g_mod_Config.Protect_Gear_threshold;

@Mod.EventBusSubscriber(modid = Balan3g_mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ProtectGearEvents {


    //ダメージ無効化、軽減
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        float THRESHOLD = Protect_Gear_threshold;
        LivingEntity living = event.getEntity();
        if (living.level().isClientSide) return;

        if (!isWearingFullProtectGear(living)) return;

        if (event.getSource() != null && event.getSource().is(DamageTypeTags.BYPASSES_EFFECTS)) {
            event.setAmount(0.0f);
            return;
        }
        if (event.getSource() != null && event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            event.setAmount(0.0f);
            return;
        }


        float dmg = event.getAmount();
        if (dmg <= 0.0f) return;

        if (dmg <= THRESHOLD) {
            event.setAmount(0.0f);
            return;
        }

        event.setAmount(Math.max(0.0f, (float) Math.floor(dmg / 2.0)));
    }

    //Effectを防ぐ
    @SubscribeEvent
    public static void onEffectApplicable(MobEffectEvent.Applicable event) {
        LivingEntity living = event.getEntity();
        if (living.level().isClientSide) return;
        if (!isWearingFullProtectGear(living)) return;

        MobEffectInstance instance = event.getEffectInstance();
        MobEffect effect = instance.getEffect();

        if (effect.isInstantenous()) {
            event.setResult(MobEffectEvent.Applicable.Result.DENY);
            return;
        }

        ResourceLocation effectId = ForgeRegistries.MOB_EFFECTS.getKey(effect);

        if (effectId == null || !Balan3g_mod_Config.ALLOWED_EFFECTS.get().contains(effectId.toString())) {
            event.setResult(MobEffectEvent.Applicable.Result.DENY);
        }
    }

    //フル装備か確認
    private static boolean isWearingFullProtectGear(LivingEntity living) {
        return isProtectGear(living.getItemBySlot(EquipmentSlot.HEAD))
                && isProtectGear(living.getItemBySlot(EquipmentSlot.CHEST))
                && isProtectGear(living.getItemBySlot(EquipmentSlot.LEGS))
                && isProtectGear(living.getItemBySlot(EquipmentSlot.FEET));
    }

    private static boolean isProtectGear(ItemStack stack) {
        return !stack.isEmpty() && stack.is(ModItems.Protectgear_Helmet.get()) || stack.is(ModItems.Protectgear_Chestplate.get()) || stack.is(ModItems.Protectgear_Leggings.get()) || stack.is(ModItems.Protectgear_Boots.get());
    }

    //暗視、耐火、水中呼吸を付与
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
