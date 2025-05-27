package mrthomas20121.blue_skies_tcon.mixin;

import com.legacy.blue_skies.asm_hooks.PlayerHooks;
import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mixin(PlayerHooks.class)
public class PlayerHooksMixin {
    @Inject(method = "isNerfableTool(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/block/state/BlockState;)Z", at = @At("HEAD"), remap = false, cancellable = true)
    private static void isNerfableTool(ItemStack stack, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (ModifierUtil.getModifierLevel(stack, BlueModifiers.SKY_BREAKER) >= 1) {
            cir.setReturnValue(false);
        }
    }
}
