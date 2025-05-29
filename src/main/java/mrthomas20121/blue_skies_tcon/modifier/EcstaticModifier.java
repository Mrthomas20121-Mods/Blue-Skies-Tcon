package mrthomas20121.blue_skies_tcon.modifier;

import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.OnAttackedModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;


/* Increases player speed, scaling strength with tool usage */
public class EcstaticModifier extends Modifier implements BlockBreakModifierHook, MeleeHitModifierHook, OnAttackedModifierHook {
    private static void applyEffect(LivingEntity living, ModifierEntry modifier) {
        int amp = modifier.getLevel() - 1;
        if (amp < 0) return;
        MobEffectInstance instance = living.getEffect(BlueModifiers.ECSTATIC_EFFECT.get());
        if (instance != null) {
            instance.applyEffect(living);
        } else {
            instance = new MobEffectInstance(BlueModifiers.ECSTATIC_EFFECT.get(), 60, amp);
            living.addEffect(instance);
        }
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.BLOCK_BREAK, ModifierHooks.MELEE_HIT, ModifierHooks.ON_ATTACKED);
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        if (context.canHarvest() && context.isEffective() && !context.isAOE()) {
            applyEffect(context.getLiving(), modifier);
        }
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        applyEffect(context.getAttacker(), modifier);
    }

    @Override
    public void onAttacked(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slot, DamageSource source, float amount, boolean isDirectDamage) {
        int amp = modifier.getLevel() - 1;
        if (amp < 0) return;
        final int duration_cap = 80;

        LivingEntity living = context.getEntity();
        MobEffectInstance instance = living.getEffect(BlueModifiers.ECSTATIC_EFFECT.get());

        // reset duration
        if (slot.equals(EquipmentSlot.FEET)) {
            living.removeEffect(BlueModifiers.ECSTATIC_EFFECT.get());
        }

        instance = new MobEffectInstance(BlueModifiers.ECSTATIC_EFFECT.get(), Math.min((instance != null ? instance.getDuration() : 0) + 20, duration_cap), amp);
        living.addEffect(instance);
    }
}
