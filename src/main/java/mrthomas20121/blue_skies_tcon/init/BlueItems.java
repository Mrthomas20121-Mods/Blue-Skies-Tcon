package mrthomas20121.blue_skies_tcon.init;

import com.legacy.blue_skies.items.SkiesItemGroups;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.api.ItemDeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class BlueItems {

    public static ItemDeferredRegister ITEMS = new ItemDeferredRegister();

    public static RegistryObject<Item> aquite_nugget = ITEMS.register("aquite_nugget", BlueItems::register);
    public static RegistryObject<Item> charoite_nugget = ITEMS.register("charoite_nugget", BlueItems::register);
    public static RegistryObject<Item> diopside_nugget = ITEMS.register("diopside_nugget", BlueItems::register);
    public static RegistryObject<Item> horizonite_nugget = ITEMS.register("horizonite_nugget", BlueItems::register);
    public static RegistryObject<Item> pyrope_nugget = ITEMS.register("pyrope_nugget", BlueItems::register);
    public static RegistryObject<Item> falsite_nugget = ITEMS.register("falsite_nugget", BlueItems::register);
    public static RegistryObject<Item> moonstone_nugget = ITEMS.register("moonstone_nugget", BlueItems::register);
    public static RegistryObject<Item> ventium_nugget = ITEMS.register("ventium_nugget", BlueItems::register);
    public static ItemCast midnight_sand = ITEMS.registerCast("midnight_sand");
    public static ItemCast crystal_sand = ITEMS.registerCast("crystal_sand");

    public static Item register() {
        return new Item(new Item.Properties().tab(SkiesItemGroups.MISC));
    }
}
