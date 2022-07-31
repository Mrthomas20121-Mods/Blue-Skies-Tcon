package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlueItemModels extends ItemModelProvider {

    public BlueItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        itemWithModel(Fluids.aquite.asItem(), "item/generated");
        itemWithModel(Fluids.charoite.asItem(), "item/generated");
        itemWithModel(Fluids.diopside.asItem(), "item/generated");
        itemWithModel(Fluids.horizonite.asItem(), "item/generated");
        itemWithModel(Fluids.pyrope.asItem(), "item/generated");
        itemWithModel(Fluids.moonstone.asItem(), "item/generated");
        itemWithModel(Fluids.falsite.asItem(), "item/generated");
        itemWithModel(Fluids.ventium.asItem(), "item/generated");

        itemWithModel(BlueItems.aquite_nugget, "item/generated");
        itemWithModel(BlueItems.charoite_nugget, "item/generated");
        itemWithModel(BlueItems.diopside_nugget, "item/generated");
        itemWithModel(BlueItems.moonstone_nugget, "item/generated");
        itemWithModel(BlueItems.pyrope_nugget, "item/generated");

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

    public void itemWithModel(Item registryObject, String model) {
        ResourceLocation id = registryObject.getRegistryName();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
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
