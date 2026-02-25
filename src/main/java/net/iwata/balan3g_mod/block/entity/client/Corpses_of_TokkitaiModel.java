package net.iwata.balan3g_mod.block.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.block.entity.AnimatedBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Corpses_of_TokkitaiModel  extends GeoModel<AnimatedBlockEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "geo/corpses_of_tokkitai.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "textures/block/corpses_of_tokkitai.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Balan3g_mod.MOD_ID, "animations/corpses_of_tokkitai.animation.json");
    }
}
