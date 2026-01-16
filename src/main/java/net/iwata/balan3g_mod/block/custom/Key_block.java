package net.iwata.balan3g_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Key_block extends Block {
    public Key_block(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);

        double spawnX = pPos.getX() + 0.5;
        double spawnY = pPos.getY() ;
        double spawnZ = pPos.getZ() + 0.5;
        int count = 3;

        for (int i = 0; i < count; i++) {
            Creeper creeper = new Creeper(EntityType.CREEPER, pLevel);
            creeper.setPos(spawnX, spawnY, spawnZ);

            double vx = (Math.random() - 0.5);
            double vz = (Math.random() - 0.5);
            creeper.setDeltaMovement(vx, 0.0, vz);

            pLevel.addFreshEntity(creeper);
        }
    }
}
