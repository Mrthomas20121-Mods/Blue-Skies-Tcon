package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlueItemModels extends ItemModelProvider {

    public BlueItemModels(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        fluidWithModel(Fluids.aquite.getId(), "item/generated");
        fluidWithModel(Fluids.charoite.getId(), "item/generated");
        fluidWithModel(Fluids.diopside.getId(), "item/generated");
        fluidWithModel(Fluids.horizonite.getId(), "item/generated");
        fluidWithModel(Fluids.pyrope.getId(), "item/generated");
        fluidWithModel(Fluids.moonstone.getId(), "item/generated");
        fluidWithModel(Fluids.falsite.getId(), "item/generated");
        fluidWithModel(Fluids.ventium.getId(), "item/generated");

        fluidWithModel(BlueItems.aquite_nugget, "item/generated");
        fluidWithModel(BlueItems.charoite_nugget, "item/generated");
        fluidWithModel(BlueItems.diopside_nugget, "item/generated");
        fluidWithModel(BlueItems.moonstone_nugget, "item/generated");
        fluidWithModel(BlueItems.pyrope_nugget, "item/generated");

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

    public void fluidWithModel(ResourceLocation id, String model) {
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath() + "_bucket");
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void itemCastModel(RegistryObject<? extends Item> registryObject, String model, String cast) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/"+cast+"/" + id.getPath().replace("_crystal_sand_cast", "").replace("_midnight_sand_cast", ""));
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void fluidWithModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }
}
