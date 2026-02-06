package net.iwata.balan3g_mod.item.client;

import net.iwata.balan3g_mod.item.custom.Protect_GearItem;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class Protect_GearRenderer extends GeoArmorRenderer<Protect_GearItem> {
    public Protect_GearRenderer() {
        super(new Protect_GearModel());
    }

    @Override
    protected void applyBoneVisibilityBySlot(EquipmentSlot slot) {
        super.applyBoneVisibilityBySlot(slot);
        // superを呼ぶことで、ヘルメット時は armorHead 以外を隠すといったバニラ相当の制御が行われます。
    }
}
