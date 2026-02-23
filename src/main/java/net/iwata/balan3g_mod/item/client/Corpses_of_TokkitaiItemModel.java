package net.iwata.balan3g_mod.item.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.item.custom.Corpses_of_TokkitaiItem;
import net.iwata.balan3g_mod.item.custom.Protect_GearItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Corpses_of_TokkitaiItemModel extends GeoModel<Corpses_of_TokkitaiItem> {
    @Override
    public ResourceLocation getModelResource(Corpses_of_TokkitaiItem animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "geo/corpses_of_tokkitai.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Corpses_of_TokkitaiItem animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/block/corpses_of_tokkitai.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Corpses_of_TokkitaiItem animatable) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "animations/corpses_of_tokkitai.animation.json");
    }
}
