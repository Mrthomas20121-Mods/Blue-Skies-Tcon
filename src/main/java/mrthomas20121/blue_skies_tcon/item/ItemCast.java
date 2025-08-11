package mrthomas20121.blue_skies_tcon.item;

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
    private final RegistryObject<Item> pick_head;
    private final RegistryObject<Item> small_axe_head;
    private final RegistryObject<Item> small_blade;
    private final RegistryObject<Item> adze_head;
    private final RegistryObject<Item> hammer_head;
    private final RegistryObject<Item> broad_axe_head;
    private final RegistryObject<Item> broad_blade;
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

    public RegistryObject<Item> getIngot() {
        return ingot;
    }

    public RegistryObject<Item> getNugget() {
        return nugget;
    }

    public RegistryObject<Item> getGem() {
        return gem;
    }

    public RegistryObject<Item> getRod() {
        return rod;
    }

    public RegistryObject<Item> getRepairKit() {
        return repair_kit;
    }

    public RegistryObject<Item> getPlate() {
        return plate;
    }

    public RegistryObject<Item> getGear() {
        return gear;
    }

    public RegistryObject<Item> getCoin() {
        return coin;
    }

    public RegistryObject<Item> getWire() {
        return wire;
    }

    public RegistryObject<Item> getPickHead() {
        return pick_head;
    }

    public RegistryObject<Item> getSmallAxeHead() {
        return small_axe_head;
    }

    public RegistryObject<Item> getSmallBlade() {
        return small_blade;
    }

    public RegistryObject<Item> getAdzeHead() {
        return adze_head;
    }

    public RegistryObject<Item> getHammerHead() {
        return hammer_head;
    }

    public RegistryObject<Item> getBroadAxeHead() {
        return broad_axe_head;
    }

    public RegistryObject<Item> getBroadBlade() {
        return broad_blade;
    }

    public RegistryObject<Item> getLargePlate() {
        return large_plate;
    }

    public RegistryObject<Item> getToolHandle() {
        return tool_handle;
    }

    public RegistryObject<Item> getToolBinding() {
        return tool_binding;
    }

    public RegistryObject<Item> getToughHandle() {
        return tough_handle;
    }

    public RegistryObject<Item> getToughCollar() {
        return tough_collar;
    }

    public RegistryObject<Item> getBowLimb() {
        return bow_limb;
    }

    public RegistryObject<Item> getBowGrip() {
        return bow_grip;
    }

    public RegistryObject<Item> getHelmetPlating() {
        return helmet_plating;
    }

    public RegistryObject<Item> getChestPlating() {
        return chest_plating;
    }

    public RegistryObject<Item> getLegPlating() {
        return leg_plating;
    }

    public RegistryObject<Item> getBootPlating() {
        return boot_plating;
    }

    public RegistryObject<Item> getMaille() {
        return maille;
    }

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
        this.pick_head = BlueItems.ITEMS.register("pick_head_" + castBase, BlueItems::register);
        this.small_axe_head = BlueItems.ITEMS.register("small_axe_head_" + castBase, BlueItems::register);
        this.small_blade = BlueItems.ITEMS.register("small_blade_" + castBase, BlueItems::register);
        this.adze_head = BlueItems.ITEMS.register("adze_head_" + castBase, BlueItems::register);
        this.hammer_head = BlueItems.ITEMS.register("hammer_head_" + castBase, BlueItems::register);
        this.broad_axe_head = BlueItems.ITEMS.register("broad_axe_head_" + castBase, BlueItems::register);
        this.broad_blade = BlueItems.ITEMS.register("broad_blade_" + castBase, BlueItems::register);
        this.tool_binding = BlueItems.ITEMS.register("tool_binding_" + castBase, BlueItems::register);
        this.large_plate = BlueItems.ITEMS.register("large_plate_" + castBase, BlueItems::register);
        this.tool_handle = BlueItems.ITEMS.register("tool_handle_" + castBase, BlueItems::register);
        this.tough_handle = BlueItems.ITEMS.register("tough_handle_" + castBase, BlueItems::register);
        this.tough_collar = BlueItems.ITEMS.register("tough_binding_" + castBase, BlueItems::register);
        this.bow_limb = BlueItems.ITEMS.register("bow_limb_" + castBase, BlueItems::register);
        this.bow_grip = BlueItems.ITEMS.register("bow_grip_" + castBase, BlueItems::register);
        this.helmet_plating = BlueItems.ITEMS.register("helmet_plating_" + castBase, BlueItems::register);
        this.chest_plating = BlueItems.ITEMS.register("chestplate_plating_" + castBase, BlueItems::register);
        this.leg_plating = BlueItems.ITEMS.register("leggings_plating_" + castBase, BlueItems::register);
        this.boot_plating = BlueItems.ITEMS.register("boots_plating_" + castBase, BlueItems::register);
        this.maille = BlueItems.ITEMS.register("maille_" + castBase, BlueItems::register);
    }

    public RegistryObject<Item> getBlank() {
        return blank;
    }

    public ArrayList<RegistryObject<Item>> getAll() {
        return Lists.newArrayList(blank, ingot, nugget, gem, rod, repair_kit, plate, gear, coin, wire, pick_head, small_axe_head, small_blade, adze_head, hammer_head, broad_axe_head, broad_blade, large_plate, tool_handle, tool_binding, tough_handle, tough_collar, bow_limb, bow_grip, helmet_plating, chest_plating, leg_plating, boot_plating, maille);
    }
}
