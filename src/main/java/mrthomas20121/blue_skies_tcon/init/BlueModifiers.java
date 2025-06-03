package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.EcstaticEffect;
import mrthomas20121.blue_skies_tcon.modifier.EcstaticModifier;
import mrthomas20121.blue_skies_tcon.modifier.UltravioletModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class BlueModifiers {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(BlueSkiesTcon.MOD_ID);
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, BlueSkiesTcon.MOD_ID);

    public static final ModifierId SKY_BREAKER = new ModifierId(BlueSkiesTcon.MOD_ID, "sky_breaker");
//    public static final ModifierId SPEEDSTER = new ModifierId(BlueSkiesTcon.MOD_ID, "speedster");

    public static final StaticModifier<EcstaticModifier> ECSTATIC = MODIFIERS.register("ecstatic", EcstaticModifier::new);
    public static final StaticModifier<UltravioletModifier> ULTRAVIOLET = MODIFIERS.register("ultraviolet", UltravioletModifier::new);

    public static final RegistryObject<EcstaticEffect> ECSTATIC_EFFECT = MOB_EFFECTS.register("ecstatic", EcstaticEffect::new);
}
