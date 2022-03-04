package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.init.Modifiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import javax.annotation.Nonnull;

import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

public class BlueMaterials extends AbstractMaterialDataProvider {

    public static final MaterialId aquite = createMaterial("aquite");
    public static final MaterialId diopside = createMaterial("diopside");
    public static final MaterialId charoite = createMaterial("charoite");
    public static final MaterialId horizonite = createMaterial("horizonite");
    public static final MaterialId pyrope = createMaterial("pyrope");

    private static MaterialId createMaterial(String name) {
        return new MaterialId(new ResourceLocation("blue_skies_tcon", name));
    }

    public BlueMaterials(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void addMaterials() {
        addMaterial(aquite, 3, ORDER_HARVEST, false, 0x93DCF9);
        addMaterial(charoite, 3, ORDER_WEAPON, false, 0xB587D6);
        addMaterial(diopside, 3, ORDER_WEAPON, false, 0x00DC19);
        addMaterial(horizonite, 3, ORDER_WEAPON, false, 0xFF8F84);
        addMaterial(pyrope, 3, ORDER_GENERAL, false, 0xFCAB39);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies Materials";
    }

    public static class BlueSkiesTraits extends AbstractMaterialTraitDataProvider {

        public BlueSkiesTraits(DataGenerator gen, AbstractMaterialDataProvider materials) {
            super(gen, materials);
        }

        @Override
        protected void addMaterialTraits() {
            addDefaultTraits(aquite, Modifiers.chemical_bonds.get());
            addDefaultTraits(charoite, TinkerModifiers.fractured.get());
            addDefaultTraits(diopside, TinkerModifiers.gilded.get());
            addDefaultTraits(horizonite, TinkerModifiers.autosmelt.get(), TinkerModifiers.fiery.get());
            addDefaultTraits(pyrope, Modifiers.chemical_bonds.get());
        }

        @Nonnull
        @Override
        public String getName() {
            return "Blue Skies Material Traits";
        }
    }

    public static class BlueSkiesMaterialStats extends AbstractMaterialStatsDataProvider {

        public BlueSkiesMaterialStats(DataGenerator gen, AbstractMaterialDataProvider materials) {
            super(gen, materials);
        }

        @Nonnull
        @Override
        public String getName() {
            return "Blue Skies Material Stats";
        }

        @Override
        protected void addMaterialStats() {

            addMaterialStats(aquite,
                    new HeadMaterialStats(300, 6f, DIAMOND, 2f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.1f).withAttackSpeed(1.2f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(charoite,
                    new HeadMaterialStats(1500, 6.5f, DIAMOND, 2f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.1f).withAttackSpeed(1.1f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(diopside,
                    new HeadMaterialStats(1600, 6f, DIAMOND, 6f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.1f).withAttackSpeed(0.7f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(horizonite,
                    new HeadMaterialStats(300, 6.5f, DIAMOND, 3f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.1f).withAttackSpeed(1f),
                    ExtraMaterialStats.DEFAULT);

            addMaterialStats(pyrope,
                    new HeadMaterialStats(300, 5f, DIAMOND, 1f),
                    HandleMaterialStats.DEFAULT.withDurability(1.05f).withMiningSpeed(1.1f).withAttackSpeed(1.1f),
                    ExtraMaterialStats.DEFAULT);
        }
    }
}
