package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_Boxed_BalanEntity;
import net.iwata.balan3g_mod.entity.custom.Tokkitai_Valine3gEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Tokkitai_Valine3gModel extends GeoModel<Tokkitai_Valine3gEntity> {
    @Override
    public ResourceLocation getModelResource(Tokkitai_Valine3gEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "geo/tokkitai_valine3g.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Tokkitai_Valine3gEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/entity/tokkitai_valine3g.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Tokkitai_Valine3gEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "animations/tokkitai_valine3g.animation.json");
    }
}
