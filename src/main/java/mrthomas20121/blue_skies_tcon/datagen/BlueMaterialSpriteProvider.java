package mrthomas20121.blue_skies_tcon.datagen;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

import javax.annotation.Nonnull;

public class BlueMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {
        buildMaterial(BlueMaterials.aquite)
                 .meleeHarvest()
                 .fallbacks("metal")
                 .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF192242).addARGB(102, 0xFF264786).addARGB(140, 0xFF336597).addARGB(178, 0xFF4781B1).addARGB(216, 0xFF4B92CF).addARGB(255, 0xFF93DCF9).build());
        buildMaterial(BlueMaterials.charoite)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF301D4A).addARGB(102, 0xFF473362).addARGB(140, 0xFF62467F).addARGB(178, 0xFF885DA6).addARGB(216, 0xFFB587D6).addARGB(255, 0xFFF2C7F9).build());
        buildMaterial(BlueMaterials.diopside)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF054307).addARGB(102, 0xFF008A0B).addARGB(140, 0xFF00A30B).addARGB(178, 0xFF4BE548).addARGB(216, 0xFF4BE548).addARGB(255, 0xFFBEFC99).build());
        buildMaterial(BlueMaterials.horizonite)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF511D24).addARGB(102, 0xFFAE2D15).addARGB(140, 0xFFC74527).addARGB(178, 0xFFFC8D39).addARGB(216, 0xFFFCAB39).addARGB(255, 0xFFFCBE6C).build());
        buildMaterial(BlueMaterials.pyrope)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF64101F).addARGB(102, 0xFF9A0A12).addARGB(140, 0xFFD12031).addARGB(178, 0xFFEF3F67).addARGB(216, 0xFFFC758B).addARGB(255, 0xFFFCBAC7).build());

    }
}
