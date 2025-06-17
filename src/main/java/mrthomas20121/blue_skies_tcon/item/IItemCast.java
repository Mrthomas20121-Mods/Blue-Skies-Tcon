package mrthomas20121.blue_skies_tcon.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public interface IItemCast {
    RegistryObject<Item> itemOf(ItemCast itemCast);
}
