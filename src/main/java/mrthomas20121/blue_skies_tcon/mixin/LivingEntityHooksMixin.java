package mrthomas20121.blue_skies_tcon.mixin;

import com.legacy.blue_skies.asm_hooks.LivingEntityHooks;
import com.legacy.blue_skies.capability.SkiesPlayer;
import com.legacy.blue_skies.items.SkyArmorItem;
import com.legacy.blue_skies.registries.SkiesDimensions;
import com.legacy.blue_skies.util.EntityUtil;
import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mixin(LivingEntityHooks.class)
public class LivingEntityHooksMixin {
//    @Inject(method = "getArmorValue", at = @At("HEAD"), remap = false)
    /**
     * @author paypur
     * @reason why u use instanceof :/
     */
    @Overwrite(remap = false)
    public static int getArmorValue(int defense, LivingEntity entity) {
        // TODO: https://github.com/LlamaLad7/MixinExtras/wiki/ModifyExpressionValue
        if (!(entity instanceof Player player && SkiesDimensions.inSkyDimension(entity))) return defense;
        return SkiesPlayer.getIfPresent(player, (skyPlayer) -> {
            if (EntityUtil.hasPlayerCompletedProgression(skyPlayer)) return defense;
            int i = 0;
            for (ItemStack stack : player.getArmorSlots()) {
                if (!(stack.getItem() instanceof SkyArmorItem || ModifierUtil.getModifierLevel(stack, BlueModifiers.SKY_BREAKER) >= 1) &&
                        stack.getItem() instanceof ArmorItem armor) {
                    ArmorMaterial material = armor.getMaterial();
                    if (material != ArmorMaterials.LEATHER && material != ArmorMaterials.GOLD && material != ArmorMaterials.TURTLE) {
                        i += Math.max(2, Math.min(4, armor.getDefense() / 2));
                    }
                }
            }
            if (defense > 1 && i < defense) return defense - i;
            return defense;
        }, () -> defense);
    }
}
