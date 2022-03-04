package mrthomas20121.blue_skies_tcon.api;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ItemDeferredRegister extends BlueDeferredRegister<Item> {

    public ItemDeferredRegister() {
        super(Item.class, BlueSkiesTcon.MOD_ID);
    }

    public ItemCast registerCast(String sand) {
        String castBase = String.format("%s_cast", sand);
        RegistryObject<Item> blank = this.register("blank_"+castBase, BlueItems::register);
        RegistryObject<Item> ingot = this.register("ingot_"+castBase, BlueItems::register);
        RegistryObject<Item> nugget = this.register("nugget_"+castBase, BlueItems::register);
        RegistryObject<Item> gem = this.register("gem_"+castBase, BlueItems::register);
        RegistryObject<Item> rod = this.register("rod_"+castBase, BlueItems::register);
        RegistryObject<Item> repair_kit = this.register("repair_kit_"+castBase, BlueItems::register);
        RegistryObject<Item> plate = this.register("plate_"+castBase, BlueItems::register);
        RegistryObject<Item> gear = this.register("gear_"+castBase, BlueItems::register);
        RegistryObject<Item> coin = this.register("coin_"+castBase, BlueItems::register);
        RegistryObject<Item> wire = this.register("wire_"+castBase, BlueItems::register);
        RegistryObject<Item> pickaxe_head = this.register("pickaxe_head_"+castBase, BlueItems::register);
        RegistryObject<Item> small_axe_head = this.register("small_axe_head_"+castBase, BlueItems::register);
        RegistryObject<Item> small_blade = this.register("small_blade_"+castBase, BlueItems::register);
        RegistryObject<Item> hammer_head = this.register("hammer_head_"+castBase, BlueItems::register);
        RegistryObject<Item> broad_blade = this.register("broad_blade_"+castBase, BlueItems::register);
        RegistryObject<Item> broad_axe_head = this.register("broad_axe_head_"+castBase, BlueItems::register);
        RegistryObject<Item> tool_binding = this.register("tool_binding_"+castBase, BlueItems::register);
        RegistryObject<Item> large_plate = this.register("large_plate_"+castBase, BlueItems::register);
        RegistryObject<Item> tool_handle = this.register("tool_handle_"+castBase, BlueItems::register);
        RegistryObject<Item> tough_handle = this.register("tough_handle_"+castBase, BlueItems::register);
        return new ItemCast(blank, ingot, nugget, gem, rod, repair_kit, plate, gear, coin, wire, pickaxe_head, small_axe_head, small_blade, hammer_head, broad_blade, broad_axe_head, tool_binding, large_plate, tool_handle, tough_handle);
    }
}
