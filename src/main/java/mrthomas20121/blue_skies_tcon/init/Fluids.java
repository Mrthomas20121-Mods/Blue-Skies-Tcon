package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

public class Fluids {

    public static FluidDeferredRegister FLUIDS = new FluidDeferredRegister(BlueSkiesTcon.MOD_ID);

    public static FluidObject<ForgeFlowingFluid> aquite = register("molten_aquite", 800);
    public static FluidObject<ForgeFlowingFluid> charoite = register("molten_charoite", 1000);
    public static FluidObject<ForgeFlowingFluid> diopside = register("molten_diopside", 1000);
    public static FluidObject<ForgeFlowingFluid> horizonite = register("molten_horizonite", 1000);
    public static FluidObject<ForgeFlowingFluid> pyrope = register("molten_pyrope", 800);
    public static FluidObject<ForgeFlowingFluid> moonstone = register("molten_moonstone", 1000);
    public static FluidObject<ForgeFlowingFluid> falsite = register("molten_falsite", 800);
    public static FluidObject<ForgeFlowingFluid> ventium = register("molten_ventium", 800);

    private static FluidObject<ForgeFlowingFluid> register(String name, int temp) {
        String still = String.format("%s:block/fluid/%s_still", BlueSkiesTcon.MOD_ID, name);
        String flow = String.format("%s:block/fluid/%s_flowing", BlueSkiesTcon.MOD_ID, name);
        return FLUIDS.register(name, FluidAttributes.builder(new ResourceLocation(still), new ResourceLocation(flow)).density(2000).viscosity(10000).temperature(temp).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA), Material.LAVA, 15);
    }
}
