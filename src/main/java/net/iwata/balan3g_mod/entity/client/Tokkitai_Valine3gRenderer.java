package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Tokkitai_Valine3gEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class Tokkitai_Valine3gRenderer extends GeoEntityRenderer<Tokkitai_Valine3gEntity> {
    public Tokkitai_Valine3gRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Tokkitai_Valine3gModel());
        this.shadowRadius = 0.4f;

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Tokkitai_Valine3gEntity animatable){
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "textures/entity/tokkitai_valine3g.png");
    }

    @Override
    public int getPackedOverlay(Tokkitai_Valine3gEntity animatable, float u, float partialTick) {
        return OverlayTexture.NO_OVERLAY;
    }
}
