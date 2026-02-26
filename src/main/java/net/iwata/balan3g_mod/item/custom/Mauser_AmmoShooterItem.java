package net.iwata.balan3g_mod.item.custom;

import net.iwata.balan3g_mod.entity.ModEntities;
import net.iwata.balan3g_mod.entity.custom.Mauser_AmmoEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Mauser_AmmoShooterItem extends Item {
    private final double speed;
    private final int cooldownTicks;

    public Mauser_AmmoShooterItem(Properties properties, double speed, int cooldownTicks) {
        super(properties);
        this.speed = speed;
        this.cooldownTicks = cooldownTicks;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            Mauser_AmmoEntity ammo = new Mauser_AmmoEntity(ModEntities.Mauser_Ammo.get(), level, player);

            Vec3 look = player.getLookAngle();
            ammo.setOwner(player);

            ammo.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());

            ammo.setDeltaMovement(look.scale(this.speed));

            level.addFreshEntity(ammo);
        }

        player.getCooldowns().addCooldown(this, this.cooldownTicks);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }


}
