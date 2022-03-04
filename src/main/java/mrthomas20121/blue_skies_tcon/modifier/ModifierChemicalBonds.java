package mrthomas20121.blue_skies_tcon.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

public class ModifierChemicalBonds extends Modifier {

    public ModifierChemicalBonds() {
        super(0x93DCF9);
    }

    @Override
    public float getEntityDamage(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        float d = (damage*2);
        return d*RANDOM.nextFloat();
    }

    @Override
    public void addToolStats(@Nonnull ToolRebuildContext context, int level, @Nonnull ModifierStatsBuilder builder) {
        ToolStats.DURABILITY.multiply(builder, 0.9f);
    }
}
