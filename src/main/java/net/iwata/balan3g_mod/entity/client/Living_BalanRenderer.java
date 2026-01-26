package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_BalanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class Living_BalanRenderer extends GeoEntityRenderer<Living_BalanEntity> {
    public Living_BalanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Living_BalanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(Living_BalanEntity animatable){
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/entity/living_balan.png");
    }
}
