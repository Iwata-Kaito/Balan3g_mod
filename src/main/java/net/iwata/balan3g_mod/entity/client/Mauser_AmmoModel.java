package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Mauser_AmmoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Mauser_AmmoModel extends GeoModel<Mauser_AmmoEntity> {
    @Override
    public ResourceLocation getModelResource(Mauser_AmmoEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "geo/mauser_ammo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Mauser_AmmoEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "textures/entity/mauser_ammo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Mauser_AmmoEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "animations/mauser_ammo.animation.json");
    }
}
