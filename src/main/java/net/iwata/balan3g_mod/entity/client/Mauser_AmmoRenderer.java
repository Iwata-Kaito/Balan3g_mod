package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Mauser_AmmoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class Mauser_AmmoRenderer extends GeoEntityRenderer<Mauser_AmmoEntity> {
    public Mauser_AmmoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Mauser_AmmoModel());
        this.shadowRadius = 0.1f;
    }

    @Override
    public ResourceLocation getTextureLocation(Mauser_AmmoEntity animatable){
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "textures/entity/mauser_ammo.png");
    }
}
