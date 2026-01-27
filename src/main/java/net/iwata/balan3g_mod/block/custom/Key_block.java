package net.iwata.balan3g_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.iwata.balan3g_mod.entity.ModEntities;

public class Key_block extends Block {

    public Key_block(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);

            double spawnX = pPos.getX() + 0.5;
            double spawnY = pPos.getY();
            double spawnZ = pPos.getZ() + 0.5;
            int count = 3;

            for (int i = 0; i < count; i++) {
                var balan = ModEntities.Living_Boxed_Balan.get().create(pLevel);
                if (balan != null) {
                    balan.setPos(spawnX, spawnY, spawnZ);
                    double vx = (Math.random() - 0.5);
                    double vz = (Math.random() - 0.5);
                    balan.setDeltaMovement(vx, 0.0, vz);

                    pLevel.addFreshEntity(balan);
                }
            }
        }
    }
}