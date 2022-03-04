package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.BlueFluid;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Fluids {

    public static DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, BlueSkiesTcon.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BlueSkiesTcon.MOD_ID);

    public static BlueFluid aquite = register("molten_aquite", 800, 12);
    public static BlueFluid charoite = register("molten_charoite", 1000, 12);
    public static BlueFluid diopside = register("molten_diopside", 1000, 12);
    public static BlueFluid horizonite = register("molten_horizonite", 1000, 12);
    public static BlueFluid pyrope = register("molten_pyrope", 800, 12);
    public static BlueFluid moonstone = register("molten_moonstone", 1000, 12);
    public static BlueFluid falsite = register("molten_falsite", 800, 12);
    public static BlueFluid ventium = register("molten_ventium", 800, 12);

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
        BLOCKS.register(bus);
    }

    public static BlueFluid register(String key, int temp, int light) {
        return BlueFluid.register(key, temp, light);
    }
}
