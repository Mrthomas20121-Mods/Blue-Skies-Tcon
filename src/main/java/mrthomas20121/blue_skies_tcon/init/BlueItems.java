package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.ItemCast;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlueItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BlueSkiesTcon.MOD_ID);

    public static final RegistryObject<Item> aquite_nugget = ITEMS.register("aquite_nugget", BlueItems::register);
    public static final RegistryObject<Item> charoite_nugget = ITEMS.register("charoite_nugget", BlueItems::register);
    public static final RegistryObject<Item> diopside_nugget = ITEMS.register("diopside_nugget", BlueItems::register);
    public static final RegistryObject<Item> pyrope_nugget = ITEMS.register("pyrope_nugget", BlueItems::register);
    public static final RegistryObject<Item> moonstone_nugget = ITEMS.register("moonstone_nugget", BlueItems::register);

    public static final ItemCast midnight_sand = new ItemCast("midnight_sand");
    public static final ItemCast crystal_sand = new ItemCast("crystal_sand");

    public static final Item.Properties DEFAULT_PROPERTIES = new Item.Properties();

    public static Item register() {
        return new Item(DEFAULT_PROPERTIES);
    }

    @SubscribeEvent
    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == TinkerSmeltery.tabSmeltery.getKey()) {
            event.acceptAll(midnight_sand.getAll().stream().map(r -> new ItemStack(r.get())).toList());
            event.acceptAll(crystal_sand.getAll().stream().map(r -> new ItemStack(r.get())).toList());
        }
    }
}
