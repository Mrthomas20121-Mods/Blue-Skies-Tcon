package mrthomas20121.blue_skies_tcon.api;

import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;

public abstract class AbstractFluid {

    protected RegistryObject<ForgeFlowingFluid.Source> stillFluid;
    protected RegistryObject<ForgeFlowingFluid.Flowing> flowingFluid;

    protected RegistryObject<FlowingFluidBlock> block;
    protected RegistryObject<Item> bucket;

    protected FluidObject<ForgeFlowingFluid> object;

    protected ForgeFlowingFluid.Properties properties;

    protected AbstractFluid(String name, FluidAttributes.Builder attributes) {

        stillFluid = Fluids.FLUIDS.register(name, () -> new ForgeFlowingFluid.Source(properties));
        flowingFluid = Fluids.FLUIDS.register(flowing(name), () -> new ForgeFlowingFluid.Flowing(properties));

        properties = new ForgeFlowingFluid.Properties(stillFluid, flowingFluid, attributes);
    }

    public Fluid getStill() {
        return stillFluid.get().getFluid();
    }

    public Fluid getFlowing() {
        return flowingFluid.get().getFluid();
    }

    public FluidObject<ForgeFlowingFluid> asObject() {
        return object;
    }

    protected String flowing(String fluid) {

        return fluid + "_flowing";
    }

    protected String bucket(String fluid) {

        return fluid + "_bucket";
    }
}
