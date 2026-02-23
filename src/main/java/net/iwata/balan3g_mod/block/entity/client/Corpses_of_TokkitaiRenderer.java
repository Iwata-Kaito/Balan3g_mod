package net.iwata.balan3g_mod.block.entity.client;

import net.iwata.balan3g_mod.block.entity.AnimatedBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class Corpses_of_TokkitaiRenderer extends GeoBlockRenderer<AnimatedBlockEntity> {
    public Corpses_of_TokkitaiRenderer(BlockEntityRendererProvider.Context context) {
        super(new Corpses_of_TokkitaiModel());
    }
}
