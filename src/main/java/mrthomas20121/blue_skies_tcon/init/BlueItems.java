package mrthomas20121.blue_skies_tcon.init;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.item.ItemCast;
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

    public static final ItemCast CRYSTAL_SAND = new ItemCast("crystal_sand");
    public static final ItemCast MIDNIGHT_SAND = new ItemCast("midnight_sand");

    public static final Item.Properties DEFAULT_PROPERTIES = new Item.Properties();

    public static Item register() {
        return new Item(DEFAULT_PROPERTIES);
    }

    @SubscribeEvent
    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == TinkerSmeltery.tabSmeltery.getKey()) {
            event.acceptAll(CRYSTAL_SAND.getAll().stream().map(r -> new ItemStack(r.get())).toList());
            event.acceptAll(MIDNIGHT_SAND.getAll().stream().map(r -> new ItemStack(r.get())).toList());
        }
    }
}
