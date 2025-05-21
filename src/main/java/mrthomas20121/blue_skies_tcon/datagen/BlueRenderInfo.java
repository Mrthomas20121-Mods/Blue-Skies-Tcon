package mrthomas20121.blue_skies_tcon.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlueRenderInfo extends AbstractMaterialRenderInfoProvider {

    public BlueRenderInfo(PackOutput packOutput, AbstractMaterialSpriteProvider spriteProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, spriteProvider, existingFileHelper);
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
