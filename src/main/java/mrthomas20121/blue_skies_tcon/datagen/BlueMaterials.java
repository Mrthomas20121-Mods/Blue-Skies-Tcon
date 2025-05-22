package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

import javax.annotation.Nonnull;

public class BlueMaterials extends AbstractMaterialDataProvider {

    public static final MaterialId aquite = createMaterial("aquite");
    public static final MaterialId charoite = createMaterial("charoite");
    public static final MaterialId diopside = createMaterial("diopside");
    public static final MaterialId horizonite = createMaterial("horizonite");
    public static final MaterialId pyrope = createMaterial("pyrope");

    private static MaterialId createMaterial(String name) {
        return new MaterialId(new ResourceLocation(BlueSkiesTcon.MOD_ID, name));
    }

    public BlueMaterials(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        addMaterial(aquite, 2, ORDER_HARVEST, true);
        addMaterial(charoite, 2, ORDER_WEAPON, true);
        addMaterial(diopside, 2, ORDER_WEAPON, true);
        addMaterial(horizonite, 2, ORDER_HARVEST, false);
        addMaterial(pyrope, 2, ORDER_HARVEST, true);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Blue Skies Materials";
    }

    public static class BlueSkiesTraits extends AbstractMaterialTraitDataProvider {
        public BlueSkiesTraits(PackOutput packOutput, AbstractMaterialDataProvider materials) {
            super(packOutput, materials);
        }

        @Override
        protected void addMaterialTraits() {
            // TODO: everything needs to be changed
            addDefaultTraits(aquite, TinkerModifiers.overworked);
            addDefaultTraits(charoite, TinkerModifiers.holy);
            addDefaultTraits(diopside, TinkerModifiers.holy);
            addDefaultTraits(horizonite, TinkerModifiers.autosmelt, TinkerModifiers.fiery);
            addDefaultTraits(pyrope, TinkerModifiers.overworked);
        }

        @Nonnull
        @Override
        public String getName() {
            return "Blue Skies Material Traits";
        }
    }

    public static class BlueSkiesMaterialStats extends AbstractMaterialStatsDataProvider {
        public BlueSkiesMaterialStats(PackOutput packOutput, AbstractMaterialDataProvider materials) {
            super(packOutput, materials);
        }

        @Override
        protected void addMaterialStats() {
            // melee, armor
            addMaterialStats(aquite,
                    new HeadMaterialStats(270, 6f, Tiers.IRON, 2.25f),
                    HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(1.1f).attackDamage(0.9f).build(),
                    StatlessMaterialStats.BINDING);

            // melee, armor
            addMaterialStats(charoite,
                    new HeadMaterialStats(1561, 8.0f, Tiers.DIAMOND, 2f),
                    HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(1.1f).attackDamage(1.05f).build(),
                    StatlessMaterialStats.BINDING);

            // melee, armor
            addMaterialStats(diopside,
                    new HeadMaterialStats(1661, 6f, Tiers.DIAMOND, 3.25f),
                    HandleMaterialStats.multipliers().durability(0.95f).miningSpeed(1.1f).attackSpeed(0.75f).attackDamage(1.25f).build(),
                    StatlessMaterialStats.BINDING);

            // melee, armor
            addMaterialStats(horizonite,
                    new HeadMaterialStats(250, 8.0f, Tiers.DIAMOND, 1.75f),
                    HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(1f).attackDamage(1.1f).build(),
                    StatlessMaterialStats.BINDING);

            // TODO: for shields, plating
//            addMaterialStats(moonstone, PlatingMaterialStats.SHIELD.getDefaultStats());

            // melee, armor
            addMaterialStats(pyrope,
                    new HeadMaterialStats(300, 11f, Tiers.STONE, 1.55f),
                    HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(1.25f).build(),
                    StatlessMaterialStats.BINDING);
        }

        @Nonnull
        @Override
        public String getName() {
            return "Blue Skies Material Stats";
        }
    }
}
