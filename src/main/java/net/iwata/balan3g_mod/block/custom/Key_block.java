package net.iwata.balan3g_mod.block.custom;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.Balan3g_mod_Config;
import net.iwata.balan3g_mod.entity.ModEntities;
import net.iwata.balan3g_mod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import static net.iwata.balan3g_mod.Balan3g_mod_Config.spawn_count;

public class Key_block extends Block {

    public Key_block(Properties pProperties) {
        super(pProperties);
    }

    //右クリック時召喚
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack mainHand = player.getMainHandItem();
        if (hand != InteractionHand.MAIN_HAND || !mainHand.is(ModItems.Balan_Key.get())) return InteractionResult.PASS;
        if (!(level instanceof ServerLevel serverLevel)) return InteractionResult.SUCCESS; // クライアントでスイングアニメ

        // ブロック変更
        serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
        serverLevel.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
        serverLevel.setBlock(pos.below(), Blocks.WHITE_CONCRETE.defaultBlockState(), Block.UPDATE_ALL);

        // エンティティ召喚
        var entity = ModEntities.Tokkitai_Valine3g.get().create(serverLevel);
        if (entity == null) {
            Balan3g_mod.LOGGER.warn("Failed to create entity at {}", pos);
            return InteractionResult.FAIL;
        }
        entity.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, serverLevel.getRandom().nextFloat() * 360.0F, 0.0F);
        entity.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(pos), MobSpawnType.TRIGGERED, null, null);
        serverLevel.addFreshEntity(entity);

        //音&エフェクト
        serverLevel.playSound(null, pos, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.0F, 1.0F);
        serverLevel.sendParticles(ParticleTypes.PORTAL, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 20, 0.5, 0.5, 0.5, 0.1);

        // アイテム消費 (Creative除く)
        if (!player.isCreative()) mainHand.shrink(1);

        return InteractionResult.CONSUME;
    }

    //プレイヤー破壊時召喚
    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        super.playerWillDestroy(level, pos, state, player);

        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        double spawnX = pos.getX() + 0.5;
        double spawnY = pos.getY();
        double spawnZ = pos.getZ() + 0.5;
        long count = spawn_count;

        for (int i = 0; i < count; i++) {
            var balan = ModEntities.Living_Boxed_Balan.get().create(serverLevel);
            if (balan != null) {
                balan.setPos(spawnX, spawnY, spawnZ);
                double vx = (serverLevel.getRandom().nextDouble() - 0.5);
                double vz = (serverLevel.getRandom().nextDouble() - 0.5);
                balan.setDeltaMovement(vx, 0.0, vz);
                serverLevel.addFreshEntity(balan);
            }
        }
    }
}