package net.iwata.balan3g_mod.item.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.item.custom.Protect_GearItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Protect_GearModel extends GeoModel<Protect_GearItem> {
    @Override
    public ResourceLocation getModelResource(Protect_GearItem animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "geo/protect_gear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Protect_GearItem animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/armor/test.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Protect_GearItem animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "animations/protect_gear.animation.json");
    }
}
