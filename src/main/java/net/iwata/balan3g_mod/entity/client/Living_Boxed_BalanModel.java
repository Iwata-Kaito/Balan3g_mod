package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_Boxed_BalanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Living_Boxed_BalanModel extends GeoModel<Living_Boxed_BalanEntity> {
    @Override
    public ResourceLocation getModelResource(Living_Boxed_BalanEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "geo/living_boxed_balan.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Living_Boxed_BalanEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/entity/living_boxed_balan.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Living_Boxed_BalanEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "animations/living_boxed_balan_animation.json");
    }
}
