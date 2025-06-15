package mrthomas20121.blue_skies_tcon.data;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import net.minecraft.data.PackOutput;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.fluids.TinkerFluids;

import javax.annotation.Nonnull;


public class BlueFluidTextureProvider extends AbstractFluidTextureProvider {
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
        return named(fluid, "molten/" + folder + "/" + TinkerFluids.withoutMolten(fluid));
    }

    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return texture(fluid).textures(BlueSkiesTcon.resource("fluid/" + name + "/"), false, false);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies TCon Fluid Texture Provider";
    }
}
