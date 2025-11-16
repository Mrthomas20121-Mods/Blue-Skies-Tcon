package mrthomas20121.blue_skies_tcon.data;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

import javax.annotation.Nonnull;

public class BlueMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies TCon Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {
        // ! aquite maille is green due to tinkers bug
        buildMaterial(BlueMaterialsProvider.aquite)
                .meleeHarvest()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63,  a(0x112266))
                        .addARGB(102, a(0x2A5096))
                        .addARGB(140, a(0x4C94D1))
                        .addARGB(178, a(0x5CBAE0))
                        .addARGB(216, a(0x7CD2F4))
                        .addARGB(255, a(0xD4F4F4)).build());
        buildMaterial(BlueMaterialsProvider.charoite)
                .meleeHarvest()
                .armor()
                .fallbacks("metal")                                                                                                                                                                                                                  // skips 0xB789D9
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, a(0x311D4B))
                        .addARGB(102, a(0x483463))
                        .addARGB(140, a(0x634781))
                        .addARGB(178, a(0x8A5EA8))
                        .addARGB(216, a(0xA075C8))
                        // B789D9
                        .addARGB(255, a(0xDCAEF4)).build());
        buildMaterial(BlueMaterialsProvider.diopside)
                .meleeHarvest()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, a(0x054407))
                        .addARGB(102, a(0x0F6411))
                        .addARGB(140, a(0x008C0B))
                        .addARGB(178, a(0x00C213))
                        .addARGB(216, a(0x4CE849))
                        // 8CF252
                        .addARGB(255, a(0xADF484)).build());
        /**
         * falsite
         * 1d0a44
         * 2f1070
         * 331179
         * 581491
         * 5e17a6
         * 761ed8
         * 7662e5
         * 8479ef
         * 9a94f0
         */
        buildMaterial(BlueMaterialsProvider.horizonite)
                .meleeHarvest()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, a(0x521D24))
                        .addARGB(102, a(0x882F00))
                        .addARGB(140, a(0xC94627))
                        .addARGB(178, a(0xFF6E29))
                        .addARGB(216, a(0xFF8F3A))
                        // FFAD3A
                        .addARGB(255, a(0xFFC06D)).build());
        /**
         * moonstone
         * 576c7c
         * 6692a8
         * 71afce
         * 95c9e2
         * b6ddee
         * c6e6f4
         * d1effc
         * e6f3f9
         */
        buildMaterial(BlueMaterialsProvider.pyrope)
                .meleeHarvest()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, a(0x65101F))
                        .addARGB(102, a(0x9C0A12))
                        // 0x98213D
                        .addARGB(140, a(0xD42032))
                        .addARGB(178, a(0xF24068))
                        .addARGB(216, a(0xFF768D))
                        .addARGB(255, a(0xFFBCC9)).build());
        /**
         * ventium
         * 3a0a0a
         * 601111
         * 661212
         * 7c1f16
         * 8e2519
         * b72020
         * d12533
         * dc3838
         * e4636c
         */
    }

    // hex values are expressed like this so my hex color highlighter works
    private int a(int rgb) {
        if (rgb > 0xFFFFFF) throw new IllegalArgumentException("Invalid rgb value, must not contain an alpha value");
        return (0xFF << 24) | rgb;
    }
}
