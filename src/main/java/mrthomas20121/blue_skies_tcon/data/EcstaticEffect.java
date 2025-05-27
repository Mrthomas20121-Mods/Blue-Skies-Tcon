package mrthomas20121.blue_skies_tcon.data;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

/* Basically a second speed (so they stack), that's half as strong */
public class EcstaticEffect extends MobEffect {
    public EcstaticEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x670000);
        addAttributeModifier(Attributes.MOVEMENT_SPEED, "10463189-d8bf-4987-a001-721a22591e06", 0.1D, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
