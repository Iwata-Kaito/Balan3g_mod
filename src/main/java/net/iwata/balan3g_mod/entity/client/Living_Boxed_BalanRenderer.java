package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_Boxed_BalanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class Living_Boxed_BalanRenderer extends GeoEntityRenderer<Living_Boxed_BalanEntity> {
    public Living_Boxed_BalanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Living_Boxed_BalanModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(Living_Boxed_BalanEntity animatable){
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/entity/living_boxed_balan.png");
    }
}
