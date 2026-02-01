package net.iwata.balan3g_mod.item.client;

import net.iwata.balan3g_mod.item.custom.Protect_GearItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class Protect_GearRenderer extends GeoArmorRenderer<Protect_GearItem> {
    public Protect_GearRenderer() {
        super(new Protect_GearModel());
    }
}
