package mrthomas20121.blue_skies_tcon;

import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;


/* Increases player speed, scaling strength with tool usage */
public class EcstaticModifier extends Modifier implements BlockBreakModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.BLOCK_BREAK);
    }

    @Override
    public boolean shouldDisplay(boolean advanced) {
        return true;
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        if (context.canHarvest() && context.isEffective() && !context.isAOE()) {
            applyEffect(context.getLiving(), modifier);
        }
    }

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
}
