package mrthomas20121.blue_skies_tcon.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mixin(value = Inventory.class, priority = 99999)
public class InventoryMixin {
    @ModifyArg(
            method = "hurtArmor",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V")
    )
    public int hurt(int pAmount, @Local(argsOnly = true) DamageSource source) {
        if (source.getDirectEntity() instanceof LivingEntity living) {
            int level = ModifierUtil.getModifierLevel(living.getMainHandItem(), BlueModifiers.SHATTERING);
            return pAmount * (level + 1);
        }
        return pAmount;
    }
}
