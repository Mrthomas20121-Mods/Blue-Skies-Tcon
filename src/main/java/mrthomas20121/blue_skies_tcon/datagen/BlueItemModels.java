package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class BlueItemModels extends ItemModelProvider {

    public BlueItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        itemWithModel(Fluids.aquite.getBucket(), "item/generated");
        itemWithModel(Fluids.charoite.getBucket(), "item/generated");
        itemWithModel(Fluids.diopside.getBucket(), "item/generated");
        itemWithModel(Fluids.horizonite.getBucket(), "item/generated");
        itemWithModel(Fluids.pyrope.getBucket(), "item/generated");
        itemWithModel(Fluids.moonstone.getBucket(), "item/generated");
        itemWithModel(Fluids.falsite.getBucket(), "item/generated");
        itemWithModel(Fluids.ventium.getBucket(), "item/generated");

        itemWithModel(Fluids.aquite.getVentiumBucket(), "item/generated");
        itemWithModel(Fluids.charoite.getVentiumBucket(), "item/generated");
        itemWithModel(Fluids.diopside.getVentiumBucket(), "item/generated");
        itemWithModel(Fluids.horizonite.getVentiumBucket(), "item/generated");
        itemWithModel(Fluids.pyrope.getVentiumBucket(), "item/generated");
        itemWithModel(Fluids.moonstone.getVentiumBucket(), "item/generated");
        itemWithModel(Fluids.falsite.getVentiumBucket(), "item/generated");
        itemWithModel(Fluids.ventium.getVentiumBucket(), "item/generated");

        itemWithModel(BlueItems.aquite_nugget, "item/generated");
        itemWithModel(BlueItems.charoite_nugget, "item/generated");
        itemWithModel(BlueItems.diopside_nugget, "item/generated");
        itemWithModel(BlueItems.falsite_nugget, "item/generated");
        itemWithModel(BlueItems.horizonite_nugget, "item/generated");
        itemWithModel(BlueItems.moonstone_nugget, "item/generated");
        itemWithModel(BlueItems.pyrope_nugget, "item/generated");
        itemWithModel(BlueItems.ventium_nugget, "item/generated");

        castModel(BlueItems.midnight_sand);
        castModel(BlueItems.crystal_sand);
    }

    public void castModel(ItemCast cast) {
        cast.getALL().forEach(itemCast-> {
            ResourceLocation reg = itemCast.getId();
            if(reg.getPath().contains("midnight")) {
                itemCastModel(itemCast, "item/generated", "midnight_sand_cast");
            }
            else {
                itemCastModel(itemCast, "item/generated", "crystal_sand_cast");
            }
        });
    }

    public void itemCastModel(RegistryObject<? extends Item> registryObject, String model, String cast) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/"+cast+"/" + id.getPath().replace("_crystal_sand_cast", "").replace("_midnight_sand_cast", ""));
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }
}
