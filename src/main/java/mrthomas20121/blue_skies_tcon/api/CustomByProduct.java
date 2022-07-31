package mrthomas20121.blue_skies_tcon.api;

import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.data.recipe.IByproduct;
import slimeknights.tconstruct.library.recipe.FluidValues;

import javax.annotation.Nonnull;
import java.util.Locale;

public enum CustomByProduct implements IByproduct {
    MOONSTONE(false, Fluids.moonstone);

    private final boolean alwaysPresent;
    private final FluidObject<ForgeFlowingFluid> fluidSupplier;
    private final int nuggets;

    CustomByProduct(boolean alwaysPresent, FluidObject<ForgeFlowingFluid> fluidSupplier) {
        this.alwaysPresent = alwaysPresent;
        this.fluidSupplier = fluidSupplier;
        this.nuggets = FluidValues.NUGGET * 3;
    }

    @Nonnull
    @Override
    public String getName() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    @Override
    public boolean isAlwaysPresent() {
        return this.alwaysPresent;
    }

    @Nonnull
    @Override
    public Fluid getFluid() {
        return this.fluidSupplier.get();
    }

    @Override
    public int getAmount() {
        return nuggets;
    }
}
