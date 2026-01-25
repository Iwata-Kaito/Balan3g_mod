package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_BalanEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class Living_BalanModel extends GeoModel<Living_BalanEntity> {
    @Override
    public ResourceLocation getModelResource(Living_BalanEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "geo/living_balan.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Living_BalanEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/entity/living_balan.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Living_BalanEntity animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "animations/living_balan_animation.json");
    }
}
