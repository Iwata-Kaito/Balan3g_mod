package net.iwata.balan3g_mod.entity.custom;

import net.iwata.balan3g_mod.Balan3g_mod_Config;
import net.iwata.balan3g_mod.entity.ModEntities;
import net.iwata.balan3g_mod.item.ModItems;
import net.iwata.balan3g_mod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;

public class Tokkitai_Valine3gEntity extends Animal implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private boolean corpsePlaced = false;

    //銃撃設定
    private double fireAccumulator = 0.0;

    //設定
    public Tokkitai_Valine3gEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setMaxUpStep(2.0f);
        this.setPersistenceRequired();
    }

    //基本ステータス
    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.JUMP_STRENGTH, 0.6f)
                .add(Attributes.MAX_HEALTH, 300.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0f)
                .add(Attributes.FOLLOW_RANGE, 200.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();
    }

    //BossBar
    private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED, ServerBossEvent.BossBarOverlay.PROGRESS);

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    //Goal設定
    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));

        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(1, new FeuerGoal());
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 64.0F));
    }

    //色々設定
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ModEntities.Tokkitai_Valine3g.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    //armor,effect付与
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);

        AttributeInstance maxHealthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttribute != null) {
            maxHealthAttribute.setBaseValue(Balan3g_mod_Config.MAX_HEALTH);
            this.setHealth(this.getMaxHealth());
        }

        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ModItems.Protectgear_Helmet.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ModItems.Protectgear_Chestplate.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ModItems.Protectgear_Leggings.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ModItems.Protectgear_Boots.get()));

        this.setDropChance(EquipmentSlot.HEAD, 0.0F);
        this.setDropChance(EquipmentSlot.CHEST, 0.0F);
        this.setDropChance(EquipmentSlot.LEGS, 0.0F);
        this.setDropChance(EquipmentSlot.FEET, 0.0F);

        this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, -1, 0, false, false));
        this.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, -1, 0, false, false));

        return pSpawnData;
    }

    //死亡時にブロック生成
    @Override
    public void die(DamageSource damageSource) {
        super.die(damageSource);

        if (corpsePlaced) return;
        corpsePlaced = true;

        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        BlockPos placePos = this.blockPosition();
        serverLevel.setBlock(placePos, ModBlocks.Corpses_of_Tokkitai.get().defaultBlockState(), 3);
    }

    //銃撃
    public class FeuerGoal extends Goal {
        @Override
        public boolean canUse() {
            LivingEntity target = Tokkitai_Valine3gEntity.this.getTarget();
            return Tokkitai_Valine3gEntity.this.isAlive()
                    && target != null
                    && target.isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return canUse();
        }

        @Override
        public void tick() {
            if (Tokkitai_Valine3gEntity.this.level().isClientSide) return;

            LivingEntity target = Tokkitai_Valine3gEntity.this.getTarget();
            if (target == null || !target.isAlive()) return;


            Tokkitai_Valine3gEntity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);

            double shotsPerTick = Balan3g_mod_Config.FIRE_RPM / 1200.0D;
            fireAccumulator += shotsPerTick;

            while (fireAccumulator >= 1.0) {
                fireAccumulator -= 1.0;
                shootOnce(target);
            }
        }

        private void shootOnce(LivingEntity target) {
            Vec3 from = Tokkitai_Valine3gEntity.this.position().add(0.0, Tokkitai_Valine3gEntity.this.getEyeHeight(), 0.0);
            Vec3 to = target.position().add(0.0, target.getBbHeight() * 0.5, 0.0);

            Vec3 dir = to.subtract(from);
            if (dir.lengthSqr() < 1.0E-6) return;
            dir = dir.normalize();

            Mauser_AmmoEntity ammo = new Mauser_AmmoEntity(ModEntities.Mauser_Ammo.get(), Tokkitai_Valine3gEntity.this.level(), Tokkitai_Valine3gEntity.this);
            ammo.setOwner(Tokkitai_Valine3gEntity.this);
            ammo.setPos(from.x, from.y, from.z);
            ammo.setDeltaMovement(dir.scale(Balan3g_mod_Config.BULLET_SPEED));

            Tokkitai_Valine3gEntity.this.level().addFreshEntity(ammo);
        }
    }
}
