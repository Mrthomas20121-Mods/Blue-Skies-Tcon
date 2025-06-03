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
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class BlueLanguageProvider extends LanguageProvider {

    public BlueLanguageProvider(PackOutput gen) {
        super(gen, BlueSkiesTcon.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addMaterial(BlueMaterials.aquite,"Iron at home:");
        addMaterial(BlueMaterials.charoite, "Slightly radioactive");
        addMaterial(BlueMaterials.diopside, "The cooler Emerald");
        addMaterial(BlueMaterials.horizonite, "SUPERHOT");
        addMaterial(BlueMaterials.pyrope, "Simply lovely");

        addFluid(BlueFluids.aquite);
        addFluid(BlueFluids.charoite);
        addFluid(BlueFluids.diopside);
        addFluid(BlueFluids.horizonite);
        addFluid(BlueFluids.pyrope);
        addFluid(BlueFluids.moonstone);
        addFluid(BlueFluids.falsite);
        addFluid(BlueFluids.ventium);

        addItem(BlueItems.aquite_nugget, "Aquite Nugget");
        addItem(BlueItems.charoite_nugget, "Charoite Nugget");
        addItem(BlueItems.diopside_nugget, "Diopside Nugget");
        addItem(BlueItems.moonstone_nugget, "Moonstone Nugget");
        addItem(BlueItems.pyrope_nugget, "Pyrope Nugget");

        addCast(BlueItems.midnight_sand);
        addCast(BlueItems.crystal_sand);

        add(String.format("effect.%s.ecstatic", BlueSkiesTcon.MOD_ID), "Ecstatic");

        addModifier(BlueModifiers.ECSTATIC.getId(), "Ecstatic", "Get a speed boost for using your tools", "Now I'm motivated");
        addModifier(BlueModifiers.ULTRAVIOLET.getId(), "Ultraviolet", "Make your targets glow briefly", "Known to the State of California to cause cancer");

        addModifier(BlueModifiers.SKY_BREAKER, "Sky Breaker", "Break through the limits of the Blue Skies", "We Minecrafters have no limits!");

//        addModifier(BlueModifiers.SPEEDSTER, "Speedster", "TODO", "TODO");
    }

    private void addMaterial(MaterialId material, String flavor) {
        add(String.format("material.%s.%s", BlueSkiesTcon.MOD_ID, material.getPath()), capitalize(material.getPath()));
        add(String.format("material.%s.%s.flavor", BlueSkiesTcon.MOD_ID, material.getPath()), flavor);
    }

    private void addFluid(FluidObject<ForgeFlowingFluid> fluid) {
        String capName = capitalize(fluid.getId().getPath());
        add(String.format("fluid.%s.%s", BlueSkiesTcon.MOD_ID, fluid.getId().getPath()), capName);
        add(fluid.asItem(), capitalize(String.format("%s_bucket", fluid.getId().getPath())));
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
