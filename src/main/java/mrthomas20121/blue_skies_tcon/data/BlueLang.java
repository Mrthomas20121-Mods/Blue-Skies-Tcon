package mrthomas20121.blue_skies_tcon.data;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.apache.commons.lang3.StringUtils;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class BlueLang extends LanguageProvider {

    public BlueLang(PackOutput gen) {
        super(gen, BlueSkiesTcon.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addFluid(BlueFluids.aquite, "molten_aquite");
        addFluid(BlueFluids.charoite, "molten_charoite");
        addFluid(BlueFluids.diopside, "molten_diopside");
        addFluid(BlueFluids.horizonite, "molten_horizonite");
        addFluid(BlueFluids.pyrope, "molten_pyrope");
        addFluid(BlueFluids.moonstone, "molten_moonstone");
        addFluid(BlueFluids.falsite, "molten_falsite");
        addFluid(BlueFluids.ventium, "molten_ventium");

        addItem(BlueItems.aquite_nugget, "Aquite Nugget");
        addItem(BlueItems.charoite_nugget, "Charoite Nugget");
        addItem(BlueItems.diopside_nugget, "Diopside Nugget");
        addItem(BlueItems.moonstone_nugget, "Moonstone Nugget");
        addItem(BlueItems.pyrope_nugget, "Pyrope Nugget");

        addCast(BlueItems.midnight_sand);
        addCast(BlueItems.crystal_sand);

        addModifier(BlueModifiers.ECSTATIC.getId(), "Ecstatic", "Get a speed boost for using your tools", "Now I'm motivated");
        addModifier(BlueModifiers.SKY_BREAKER, "Sky Breaker", "Break through the limits of the Blue Skies", "We Minecrafters have no limits!");
        addModifier(BlueModifiers.SPEEDSTER, "Speedster", "TODO", "TODO");
    }

    private void addFluid(FluidObject<ForgeFlowingFluid> fluid, String name) {
        String capName = capitalize(name);
        add(String.format("fluid.%s.%s", BlueSkiesTcon.MOD_ID, name), capName);
        add(fluid.asItem(), capitalize(String.format("%s_bucket", name)));
        String materialName = name.replace("molten_", "");
        add(String.format("material.%s.%s", BlueSkiesTcon.MOD_ID, materialName), capitalize(materialName));
    }

    private void addCast(ItemCast cast) {
        cast.getALL().forEach(itemCast -> addItem(itemCast, capitalize(itemCast.getId().getPath())));
    }

    private void addModifier(ModifierId id, String name, String desc, String flavor) {
        add(String.format("modifier.blue_skies_tcon.%s", id.getPath()), name);
        add(String.format("modifier.blue_skies_tcon.%s.description", id.getPath()), desc);
        add(String.format("modifier.blue_skies_tcon.%s.flavor", id.getPath()), flavor);
    }

    public String capitalize(String input) {
        if (input.contains("_")) {
            String[] split = input.split("_");
            StringBuilder output = new StringBuilder();
            for (String s : split) {
                output.append(StringUtils.capitalize(s));
                output.append(" ");
            }
            return output.toString().trim();
        }
        return StringUtils.capitalize(input);
    }
}
