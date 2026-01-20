package net.iwata.balan3g_mod.entity.client;

import net.iwata.balan3g_mod.Balan3g_mod;
import net.iwata.balan3g_mod.entity.custom.Living_BalanEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Living_BalanRenderer extends MobRenderer<Living_BalanEntities, Living_Balan_Model<Living_BalanEntities>> {
    public Living_BalanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Living_Balan_Model<>(pContext.bakeLayer(ModModelLayers.LIVING_BALAN_LAYER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Living_BalanEntities pEntity) {
        return new ResourceLocation(Balan3g_mod.MOD_ID, "textures/entity/living_balan.png");
    }
}
