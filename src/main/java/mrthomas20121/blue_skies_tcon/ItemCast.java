package mrthomas20121.blue_skies_tcon;

import com.google.common.collect.Lists;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class ItemCast {

    private final RegistryObject<Item> blank;
    private final RegistryObject<Item> ingot;
    private final RegistryObject<Item> nugget;
    private final RegistryObject<Item> gem;
    private final RegistryObject<Item> rod;
    private final RegistryObject<Item> repair_kit;
    private final RegistryObject<Item> plate;
    private final RegistryObject<Item> gear;
    private final RegistryObject<Item> coin;
    private final RegistryObject<Item> wire;
    private final RegistryObject<Item> pickaxe_head;
    private final RegistryObject<Item> small_axe_head;
    private final RegistryObject<Item> small_blade;
    private final RegistryObject<Item> hammer_head;
    private final RegistryObject<Item> broad_blade;
    private final RegistryObject<Item> broad_axe_head;
    private final RegistryObject<Item> large_plate;
    private final RegistryObject<Item> tool_handle;
    private final RegistryObject<Item> tool_binding;
    private final RegistryObject<Item> tough_handle;
    private final RegistryObject<Item> tough_collar;
    private final RegistryObject<Item> bow_limb;
    private final RegistryObject<Item> bow_grip;
    private final RegistryObject<Item> helmet_plating;
    private final RegistryObject<Item> chest_plating;
    private final RegistryObject<Item> leg_plating;
    private final RegistryObject<Item> boot_plating;
    private final RegistryObject<Item> maille;

    // TODO: missing casting recipes and textures

    public ItemCast(String sand) {
        String castBase = String.format("%s_cast", sand);
        this.blank = BlueItems.ITEMS.register("blank_" + castBase, BlueItems::register);
        this.ingot = BlueItems.ITEMS.register("ingot_" + castBase, BlueItems::register);
        this.nugget = BlueItems.ITEMS.register("nugget_" + castBase, BlueItems::register);
        this.gem = BlueItems.ITEMS.register("gem_" + castBase, BlueItems::register);
        this.rod = BlueItems.ITEMS.register("rod_" + castBase, BlueItems::register);
        this.repair_kit = BlueItems.ITEMS.register("repair_kit_" + castBase, BlueItems::register);
        this.plate = BlueItems.ITEMS.register("plate_" + castBase, BlueItems::register);
        this.gear = BlueItems.ITEMS.register("gear_" + castBase, BlueItems::register);
        this.coin = BlueItems.ITEMS.register("coin_" + castBase, BlueItems::register);
        this.wire = BlueItems.ITEMS.register("wire_" + castBase, BlueItems::register);
        this.pickaxe_head = BlueItems.ITEMS.register("pickaxe_head_" + castBase, BlueItems::register);
        this.small_axe_head = BlueItems.ITEMS.register("small_axe_head_" + castBase, BlueItems::register);
        this.small_blade = BlueItems.ITEMS.register("small_blade_" + castBase, BlueItems::register);
        this.hammer_head = BlueItems.ITEMS.register("hammer_head_" + castBase, BlueItems::register);
        this.broad_blade = BlueItems.ITEMS.register("broad_blade_" + castBase, BlueItems::register);
        this.broad_axe_head = BlueItems.ITEMS.register("broad_axe_head_" + castBase, BlueItems::register);
        this.tool_binding = BlueItems.ITEMS.register("tool_binding_" + castBase, BlueItems::register);
        this.large_plate = BlueItems.ITEMS.register("large_plate_" + castBase, BlueItems::register);
        this.tool_handle = BlueItems.ITEMS.register("tool_handle_" + castBase, BlueItems::register);
        this.tough_handle = BlueItems.ITEMS.register("tough_handle_" + castBase, BlueItems::register);
        this.tough_collar = BlueItems.ITEMS.register("tough_collar_" + castBase, BlueItems::register);
        this.bow_limb = BlueItems.ITEMS.register("bow_limb_" + castBase, BlueItems::register);
        this.bow_grip = BlueItems.ITEMS.register("bow_grip_" + castBase, BlueItems::register);
        this.helmet_plating = BlueItems.ITEMS.register("helmet_plating_" + castBase, BlueItems::register);
        this.chest_plating = BlueItems.ITEMS.register("chest_plating_" + castBase, BlueItems::register);
        this.leg_plating = BlueItems.ITEMS.register("leg_plating_" + castBase, BlueItems::register);
        this.boot_plating = BlueItems.ITEMS.register("boot_plating_" + castBase, BlueItems::register);
        this.maille = BlueItems.ITEMS.register("maille_" + castBase, BlueItems::register);
    }

    public RegistryObject<Item> getBlank() {
        return blank;
    }

    public ArrayList<RegistryObject<Item>> getAll() {
        return Lists.newArrayList(blank, ingot, nugget, gem, rod, repair_kit, plate, gear, coin, wire, pickaxe_head, small_axe_head, small_blade, hammer_head, broad_blade, broad_axe_head, large_plate, tool_handle, tool_binding, tough_handle);
    }
}
