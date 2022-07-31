package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.apache.commons.lang3.StringUtils;
import slimeknights.mantle.registration.object.FluidObject;

public class BlueLang extends LanguageProvider {

    public BlueLang(DataGenerator gen) {
        super(gen, BlueSkiesTcon.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        addFluid(Fluids.aquite, "molten_aquite");
        addFluid(Fluids.charoite, "molten_charoite");
        addFluid(Fluids.diopside, "molten_diopside");
        addFluid(Fluids.horizonite, "molten_horizonite");
        addFluid(Fluids.pyrope, "molten_pyrope");
        addFluid(Fluids.moonstone, "molten_moonstone");
        addFluid(Fluids.falsite, "molten_falsite");
        addFluid(Fluids.ventium, "molten_ventium");

        addItem(BlueItems.aquite_nugget, "Aquite Nugget");
        addItem(BlueItems.charoite_nugget, "Charoite Nugget");
        addItem(BlueItems.diopside_nugget, "Diopside Nugget");
        addItem(BlueItems.moonstone_nugget, "Moonstone Nugget");
        addItem(BlueItems.pyrope_nugget, "Pyrope Nugget");
        add("modifier.blue_skies_tcon.chemical_bonds", "Chemical Bonds");
        add("modifier.blue_skies_tcon.chemical_bonds.description", "Your tools damage feels off.");
        add("modifier.blue_skies_tcon.chemical_bonds.flavor", "Crystals have chemical bonds");
        addCast(BlueItems.midnight_sand);
        addCast(BlueItems.crystal_sand);
    }

    private void addFluid(FluidObject<ForgeFlowingFluid> fluid, String name) {
        String capName = capitalize(name);
        add(String.format("fluid.%s.%s", BlueSkiesTcon.MOD_ID, name), capName);
        add(fluid.asItem(), capitalize(String.format("%s_bucket", name)));
        String materialName = name.replace("molten_", "");
        add(String.format("material.%s.%s", BlueSkiesTcon.MOD_ID, materialName), capitalize(materialName));
    }

    protected void addCast(ItemCast cast) {
        cast.getALL().forEach(itemCast -> {
            addItem(itemCast, capitalize(itemCast.getId().getPath()));
        });
    }

    public String capitalize(String input) {
        if(input.contains("_")) {
            String[] split = input.split("_");
            StringBuilder output = new StringBuilder();
            for(String s : split) {
                output.append(StringUtils.capitalize(s));
                output.append(" ");
            }
            return output.toString().trim();
        }
        return StringUtils.capitalize(input);
    }
}
