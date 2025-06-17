package mrthomas20121.blue_skies_tcon.data;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.item.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class BlueItemModelsProvider extends ItemModelProvider {

    public BlueItemModelsProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return "Blue Skies TCon Item Model Provider";
    }

    @Override
    protected void registerModels() {
        fluidWithModel(BlueFluids.aquite.getId(), "item/generated");
        fluidWithModel(BlueFluids.charoite.getId(), "item/generated");
        fluidWithModel(BlueFluids.diopside.getId(), "item/generated");
        fluidWithModel(BlueFluids.horizonite.getId(), "item/generated");
        fluidWithModel(BlueFluids.pyrope.getId(), "item/generated");
        fluidWithModel(BlueFluids.moonstone.getId(), "item/generated");
        fluidWithModel(BlueFluids.falsite.getId(), "item/generated");
        fluidWithModel(BlueFluids.ventium.getId(), "item/generated");

        itemWithModel(BlueItems.aquite_nugget, "item/generated");
        itemWithModel(BlueItems.charoite_nugget, "item/generated");
        itemWithModel(BlueItems.diopside_nugget, "item/generated");
        itemWithModel(BlueItems.moonstone_nugget, "item/generated");
        itemWithModel(BlueItems.pyrope_nugget, "item/generated");

        castModel(BlueItems.MIDNIGHT_SAND);
        castModel(BlueItems.CRYSTAL_SAND);
    }

    public void castModel(ItemCast cast) {
        cast.getAll().forEach(itemCast -> {
            ResourceLocation reg = itemCast.getId();
            if (reg.getPath().contains("midnight")) {
                itemCastModel(itemCast, "item/generated", "midnight_sand_casts");
            } else {
                itemCastModel(itemCast, "item/generated", "crystal_sand_casts");
            }
        });
    }

    // for buckets
    public void fluidWithModel(ResourceLocation id, String model) {
        ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + id.getPath() + "_bucket");
        singleTexture(id.getPath() + "_bucket", ResourceLocation.parse(model), "layer0", textureLocation);
    }

    public void itemCastModel(RegistryObject<? extends Item> registryObject, String model, String cast) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + cast + "/" + id.getPath().replace("_crystal_sand_cast", "").replace("_midnight_sand_cast", ""));
        singleTexture(id.getPath(), ResourceLocation.parse(model), "layer0", textureLocation);
    }

    public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), ResourceLocation.parse(model), "layer0", textureLocation);
    }
}
