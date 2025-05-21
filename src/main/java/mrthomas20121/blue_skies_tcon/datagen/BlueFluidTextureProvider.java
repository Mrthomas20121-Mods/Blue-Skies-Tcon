package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;

import javax.annotation.Nonnull;

import static slimeknights.tconstruct.fluids.TinkerFluids.withoutMolten;

public class BlueFluidTextureProvider extends AbstractFluidTextureProvider  {
    public BlueFluidTextureProvider(PackOutput packOutput) {
        super(packOutput, BlueSkiesTcon.MOD_ID);
    }

    @Override
    public void addTextures() {
        ore(BlueFluids.aquite);
        ore(BlueFluids.charoite);
        ore(BlueFluids.diopside);
        ore(BlueFluids.falsite);
        ore(BlueFluids.horizonite);
        ore(BlueFluids.moonstone);
        ore(BlueFluids.pyrope);
        ore(BlueFluids.ventium);
    }

    private FluidTexture.Builder ore(FluidObject<?> fluid) {
        return moltenFolder(fluid, "ore");
    }

    private FluidTexture.Builder moltenFolder(FluidObject<?> fluid, String folder) {
        return named(fluid, "molten/" + folder + "/" + withoutMolten(fluid));
    }

    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return texture(fluid).textures(new ResourceLocation(BlueSkiesTcon.MOD_ID, "fluid/"+name+"/"), false, false);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies Fluid Texture Provider";
    }
}
