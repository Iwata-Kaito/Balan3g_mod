package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Tokkitai_Valine3gEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class Tokkitai_Valine3gRenderer extends GeoEntityRenderer<Tokkitai_Valine3gEntity> {
    public Tokkitai_Valine3gRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Tokkitai_Valine3gModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public ResourceLocation getTextureLocation(Tokkitai_Valine3gEntity animatable){
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/entity/tokkitai_valine3g.png");
    }
}
