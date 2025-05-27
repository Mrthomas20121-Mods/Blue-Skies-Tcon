package mrthomas20121.blue_skies_tcon.data.modifier;

import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import mrthomas20121.blue_skies_tcon.init.BlueVariables;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.variable.melee.EntityMeleeVariable;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;

public class BlueModifierProvider extends AbstractModifierProvider {
    public BlueModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {
        buildModifier(BlueModifiers.SPEEDSTER)
                .addModule(ConditionalMeleeDamageModule.builder()
                        .customVariable("speed", new EntityMeleeVariable(BlueVariables.ENTITY_SPEED, EntityMeleeVariable.WhichEntity.ATTACKER, 0))
                        .formula()
                        .customVariable("speed")
                        .build()
                );
        buildModifier(BlueModifiers.SKY_BREAKER);
    }

    @Override
    public String getName() {
        return "Blue Skies Modifiers";
    }
}
