package mrthomas20121.blue_skies_tcon.api;

import com.google.common.collect.Lists;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;

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
    private final RegistryObject<Item> tool_binding;
    private final RegistryObject<Item> large_plate;
    private final RegistryObject<Item> tool_handle;
    private final RegistryObject<Item> tough_handle;

    public ItemCast(RegistryObject<Item> blank, RegistryObject<Item> ingot, RegistryObject<Item> nugget, RegistryObject<Item> gem, RegistryObject<Item> rod, RegistryObject<Item> repair_kit, RegistryObject<Item> plate, RegistryObject<Item> gear, RegistryObject<Item> coin, RegistryObject<Item> wire, RegistryObject<Item> pickaxe_head, RegistryObject<Item> small_axe_head, RegistryObject<Item> small_blade, RegistryObject<Item> hammer_head, RegistryObject<Item> broad_blade, RegistryObject<Item> broad_axe_head, RegistryObject<Item> tool_binding, RegistryObject<Item> large_plate, RegistryObject<Item> tool_handle, RegistryObject<Item> tough_handle) {
        this.blank = blank;
        this.ingot = ingot;
        this.nugget = nugget;
        this.gem = gem;
        this.rod = rod;
        this.repair_kit = repair_kit;
        this.plate = plate;
        this.gear = gear;
        this.coin = coin;
        this.wire = wire;
        this.pickaxe_head = pickaxe_head;
        this.small_axe_head = small_axe_head;
        this.small_blade = small_blade;
        this.hammer_head = hammer_head;
        this.broad_blade = broad_blade;
        this.broad_axe_head = broad_axe_head;
        this.tool_binding = tool_binding;
        this.large_plate = large_plate;
        this.tool_handle = tool_handle;
        this.tough_handle = tough_handle;
    }

    public RegistryObject<Item> getBlank() {
        return blank;
    }

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

    public RegistryObject<Item> getPickaxeHead() {
        return pickaxe_head;
    }

    public RegistryObject<Item> getSmallAxeHead() {
        return small_axe_head;
    }

    public RegistryObject<Item> getSmallBlade() {
        return small_blade;
    }

    public RegistryObject<Item> getHammerHead() {
        return hammer_head;
    }

    public RegistryObject<Item> getBroadBlade() {
        return broad_blade;
    }

    public RegistryObject<Item> getBroadAxeHead() {
        return broad_axe_head;
    }

    public RegistryObject<Item> getToolBinding() {
        return tool_binding;
    }

    public RegistryObject<Item> getLargePlate() {
        return large_plate;
    }

    public RegistryObject<Item> getToolHandle() {
        return tool_handle;
    }

    public RegistryObject<Item> getToughHandle() {
        return tough_handle;
    }

    public ArrayList<RegistryObject<Item>> getALL() {
        return Lists.newArrayList(blank, ingot, nugget, gem, rod, repair_kit, plate, gear, coin, wire, pickaxe_head, small_axe_head, small_blade, hammer_head, broad_blade, broad_axe_head, tool_binding, large_plate, tool_handle, tough_handle);
    }
}
