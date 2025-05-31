package mrthomas20121.blue_skies_tcon.modifier;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.OnAttackedModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class UltravioletModifier extends Modifier implements MeleeHitModifierHook, OnAttackedModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT, ModifierHooks.ON_ATTACKED);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        int amp = modifier.getLevel() - 1;
        if (amp < 0) return;

        LivingEntity living = context.getLivingTarget();
        if (living == null) return;

        MobEffectInstance instance = living.getEffect(MobEffects.GLOWING);
        if (instance != null) {
            instance.applyEffect(living);
        } else {
            living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20 * modifier.getLevel(), amp));
        }
    }

    @Override
    public void onAttacked(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slot, DamageSource source, float amount, boolean isDirectDamage) {
        int amp = modifier.getLevel() - 1;
        if (amp < 0) return;

        if (source.getEntity() instanceof LivingEntity living) {
            int level = 0;
            for (ItemStack item : context.getEntity().getArmorSlots()) {
                level += ModifierUtil.getModifierLevel(item, this.getId());
            }

            MobEffectInstance instance = living.getEffect(MobEffects.GLOWING);
            if (instance != null) {
                instance.applyEffect(living);
            } else {
                living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10 * level, amp));
            }
        }
    }

}
