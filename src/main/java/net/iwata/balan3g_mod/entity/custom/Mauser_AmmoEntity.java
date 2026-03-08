package net.iwata.balan3g_mod.entity.custom;

import net.iwata.balan3g_mod.Balan3g_mod_Config;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Mauser_AmmoEntity extends ThrowableProjectile implements GeoEntity, GeoAnimatable {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    private static final float DAMAGE = (float) Balan3g_mod_Config.MAUSER_AMMO_DAMAGE;
    private static final double MAX_LIFE_TICKS = Balan3g_mod_Config.MAUSER_AMMO_MAX_LIFE_TICKS;
    private int lifeTicks = 0;
    private LivingEntity shooter = null;

    public Mauser_AmmoEntity(EntityType<? extends ThrowableProjectile> entityType, Level world) {
        super(entityType, world);
        this.setNoGravity(true);
    }

    public Mauser_AmmoEntity(EntityType<? extends ThrowableProjectile> entityType, Level world, LivingEntity shooter) {
        this(entityType, world);
        this.shooter = shooter;
    }

    @Override
    public void tick() {
        this.setNoGravity(true);

        super.tick();

        if (this.lifeTicks++ >= MAX_LIFE_TICKS) {
            this.discard();
        }
    }

    //Entityに当たった際
        @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        if (!this.level().isClientSide && entity != shooter && entity instanceof LivingEntity living) {
            double r = this.level().random.nextDouble(); // [0.0, 1.0)

            if (r < Balan3g_mod_Config.MAUSER_AMMO_HURT) {
                living.hurt(this.damageSources().thrown(this, shooter), (DAMAGE*2)+1);
            } else if (r < Balan3g_mod_Config.MAUSER_AMMO_SETHEALTH) {
                living.setHealth((float) (living.getHealth() - DAMAGE));
            } else {
                living.setHealth(0.0F);
            }

            living.invulnerableTime = 0;
        }
        this.discard();
    }




    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        this.discard();
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "rotation", 0, event -> {
            return event.setAndContinue(RawAnimation.begin().thenPlayAndHold("idle"));
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

}
