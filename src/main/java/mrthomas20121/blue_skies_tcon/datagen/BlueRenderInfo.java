package mrthomas20121.blue_skies_tcon.datagen;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

import javax.annotation.Nonnull;

public class BlueRenderInfo extends AbstractMaterialRenderInfoProvider {

    public BlueRenderInfo(DataGenerator gen, AbstractMaterialSpriteProvider spriteProvider) {
        super(gen, spriteProvider);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(BlueMaterials.aquite).color(0x93DCF9);
        buildRenderInfo(BlueMaterials.charoite).color(0xB587D6);
        buildRenderInfo(BlueMaterials.diopside).color(0x00DC19);
        buildRenderInfo(BlueMaterials.horizonite).color(0xFF8F84);
        buildRenderInfo(BlueMaterials.pyrope).color(0xFCAB39);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies Render info provider!";
    }
}
