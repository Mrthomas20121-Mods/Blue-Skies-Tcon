package mrthomas20121.blue_skies_tcon.api;

import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.recipe.helper.FluidOutput;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.data.recipe.IByproduct;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.melting.IMeltingContainer;

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
    public FluidOutput getFluid(float v) {
        return this.fluidSupplier.result((int) (nuggets * v));
    }

    @Override
    public IMeltingContainer.OreRateType getOreRate() {
        // TODO: undecided
        return IMeltingContainer.OreRateType.METAL;
    }
}
