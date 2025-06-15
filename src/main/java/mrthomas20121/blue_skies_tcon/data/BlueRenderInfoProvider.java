package mrthomas20121.blue_skies_tcon.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlueRenderInfoProvider extends AbstractMaterialRenderInfoProvider {

    public BlueRenderInfoProvider(PackOutput packOutput, AbstractMaterialSpriteProvider spriteProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, spriteProvider, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(BlueMaterialsProvider.aquite).color(0x93DCF9);
        buildRenderInfo(BlueMaterialsProvider.charoite).color(0xB587D6);
        buildRenderInfo(BlueMaterialsProvider.diopside).color(0x00DC19);
        buildRenderInfo(BlueMaterialsProvider.horizonite).color(0xFF8F84);
        buildRenderInfo(BlueMaterialsProvider.pyrope).color(0xFCAB39);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies TCon Render Info Provider";
    }
}
