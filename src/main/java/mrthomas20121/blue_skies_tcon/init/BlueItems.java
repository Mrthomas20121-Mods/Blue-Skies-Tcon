package mrthomas20121.blue_skies_tcon.init;

import com.legacy.blue_skies.items.SkiesItemGroups;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlueItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BlueSkiesTcon.MOD_ID);

    public static RegistryObject<Item> aquite_nugget = ITEMS.register("aquite_nugget", BlueItems::register);
    public static RegistryObject<Item> charoite_nugget = ITEMS.register("charoite_nugget", BlueItems::register);
    public static RegistryObject<Item> diopside_nugget = ITEMS.register("diopside_nugget", BlueItems::register);
    public static RegistryObject<Item> pyrope_nugget = ITEMS.register("pyrope_nugget", BlueItems::register);
    public static RegistryObject<Item> moonstone_nugget = ITEMS.register("moonstone_nugget", BlueItems::register);
    public static ItemCast midnight_sand = registerCast("midnight_sand");
    public static ItemCast crystal_sand = registerCast("crystal_sand");

    public static Item register() {
        return new Item(new Item.Properties().tab(SkiesItemGroups.MISC));
    }

    public static ItemCast registerCast(String sand) {
        String castBase = String.format("%s_cast", sand);
        RegistryObject<Item> blank = ITEMS.register("blank_"+castBase, BlueItems::register);
        RegistryObject<Item> ingot = ITEMS.register("ingot_"+castBase, BlueItems::register);
        RegistryObject<Item> nugget = ITEMS.register("nugget_"+castBase, BlueItems::register);
        RegistryObject<Item> gem = ITEMS.register("gem_"+castBase, BlueItems::register);
        RegistryObject<Item> rod = ITEMS.register("rod_"+castBase, BlueItems::register);
        RegistryObject<Item> repair_kit = ITEMS.register("repair_kit_"+castBase, BlueItems::register);
        RegistryObject<Item> plate = ITEMS.register("plate_"+castBase, BlueItems::register);
        RegistryObject<Item> gear = ITEMS.register("gear_"+castBase, BlueItems::register);
        RegistryObject<Item> coin = ITEMS.register("coin_"+castBase, BlueItems::register);
        RegistryObject<Item> wire = ITEMS.register("wire_"+castBase, BlueItems::register);
        RegistryObject<Item> pickaxe_head = ITEMS.register("pickaxe_head_"+castBase, BlueItems::register);
        RegistryObject<Item> small_axe_head = ITEMS.register("small_axe_head_"+castBase, BlueItems::register);
        RegistryObject<Item> small_blade = ITEMS.register("small_blade_"+castBase, BlueItems::register);
        RegistryObject<Item> hammer_head = ITEMS.register("hammer_head_"+castBase, BlueItems::register);
        RegistryObject<Item> broad_blade = ITEMS.register("broad_blade_"+castBase, BlueItems::register);
        RegistryObject<Item> broad_axe_head = ITEMS.register("broad_axe_head_"+castBase, BlueItems::register);
        RegistryObject<Item> tool_binding = ITEMS.register("tool_binding_"+castBase, BlueItems::register);
        RegistryObject<Item> large_plate = ITEMS.register("large_plate_"+castBase, BlueItems::register);
        RegistryObject<Item> tool_handle = ITEMS.register("tool_handle_"+castBase, BlueItems::register);
        RegistryObject<Item> tough_handle = ITEMS.register("tough_handle_"+castBase, BlueItems::register);
        return new ItemCast(blank, ingot, nugget, gem, rod, repair_kit, plate, gear, coin, wire, pickaxe_head, small_axe_head, small_blade, hammer_head, broad_blade, broad_axe_head, tool_binding, large_plate, tool_handle, tough_handle);
    }
}
