package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.fluids.block.BurningLiquidBlock;

public class Fluids {

    public static FluidDeferredRegister FLUIDS = new FluidDeferredRegister(BlueSkiesTcon.MOD_ID);

    public static FlowingFluidObject<ForgeFlowingFluid> aquite = register("molten_aquite", 800);
    public static FlowingFluidObject<ForgeFlowingFluid> charoite = register("molten_charoite", 1000);
    public static FlowingFluidObject<ForgeFlowingFluid> diopside = register("molten_diopside", 1000);
    public static FlowingFluidObject<ForgeFlowingFluid> horizonite = register("molten_horizonite", 1000);
    public static FlowingFluidObject<ForgeFlowingFluid> pyrope = register("molten_pyrope", 800);
    public static FlowingFluidObject<ForgeFlowingFluid> moonstone = register("molten_moonstone", 1000);
    public static FlowingFluidObject<ForgeFlowingFluid> falsite = register("molten_falsite", 800);
    public static FlowingFluidObject<ForgeFlowingFluid> ventium = register("molten_ventium", 800);

    private static FlowingFluidObject<ForgeFlowingFluid> register(String name, int temp) {
        String still = String.format("%s:block/fluid/%s_still", BlueSkiesTcon.MOD_ID, name);
        String flow = String.format("%s:block/fluid/%s_flowing", BlueSkiesTcon.MOD_ID, name);
        return FLUIDS.register(name).type(
                FluidType.Properties.create()
                        .density(2000)
                        .viscosity(10000)
                        .temperature(temp)
                        .descriptionId(still)
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                        .motionScale(0.0023333333333333335D)
                        .canSwim(false)
                        .canDrown(false)
                        .pathType(BlockPathTypes.LAVA)
                        .adjacentPathType(null)
                        .lightLevel(15)
        )
        // TODO: might want a per fluid color
        .block(BurningLiquidBlock.createBurning(MapColor.COLOR_CYAN, 15, 10, 5f))
        .bucket()
        .commonTag()
        .flowing();
    }
}
