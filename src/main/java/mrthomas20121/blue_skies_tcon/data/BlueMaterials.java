package mrthomas20121.blue_skies_tcon.data;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Tiers;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;
import slimeknights.tconstruct.tools.stats.PlatingMaterialStats;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

import javax.annotation.Nonnull;

public class BlueMaterials extends AbstractMaterialDataProvider {

    public static final MaterialId aquite = createMaterial("aquite");
    public static final MaterialId charoite = createMaterial("charoite");
    public static final MaterialId diopside = createMaterial("diopside");
    public static final MaterialId horizonite = createMaterial("horizonite");
    public static final MaterialId pyrope = createMaterial("pyrope");

    public BlueMaterials(PackOutput packOutput) {
        super(packOutput);
    }

    private static MaterialId createMaterial(String name) {
        return new MaterialId(BlueSkiesTcon.resource(name));
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
            addDefaultTraits(aquite, BlueModifiers.SKY_BREAKER); // just give it the breaker trait only
            addDefaultTraits(charoite, BlueModifiers.SPEEDSTER, BlueModifiers.SKY_BREAKER);
            addDefaultTraits(diopside, BlueModifiers.SKY_BREAKER);
            addDefaultTraits(horizonite, TinkerModifiers.autosmelt.getId(), TinkerModifiers.fiery.getId(), BlueModifiers.SKY_BREAKER);
            addDefaultTraits(pyrope, BlueModifiers.ECSTATIC.getId(), BlueModifiers.SKY_BREAKER);
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
            // iron equivalent
            addMaterialStats(aquite,
                    new HeadMaterialStats(270, 6f, Tiers.IRON, 2.25f),
                    HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(1.1f).attackDamage(0.9f).build(),
                    StatlessMaterialStats.BINDING);
            addArmorShieldStats(aquite,
                    PlatingMaterialStats.builder().durabilityFactor(15).armor(2, 5, 6, 2),
                    StatlessMaterialStats.MAILLE);

            // melee, armor
            // diamond equivalent, faster weaker
            addMaterialStats(charoite,
                    new HeadMaterialStats(1561, 8.0f, Tiers.DIAMOND, 2.5f),
                    HandleMaterialStats.multipliers().durability(0.95f).miningSpeed(1.1f).attackSpeed(1.1f).attackDamage(1.0f).build(),
                    StatlessMaterialStats.BINDING);
            addArmorShieldStats(charoite,
                    PlatingMaterialStats.builder().durabilityFactor(33).armor(2, 5, 7, 2).toughness(1f),
                    StatlessMaterialStats.MAILLE);

            // melee, armor
            // diamond equivalent, slower stronger
            addMaterialStats(diopside,
                    new HeadMaterialStats(1661, 6f, Tiers.DIAMOND, 3.25f),
                    HandleMaterialStats.multipliers().durability(0.95f).miningSpeed(0.85f).attackSpeed(0.75f).attackDamage(1.25f).build(),
                    StatlessMaterialStats.BINDING);
            addArmorShieldStats(diopside,
                    PlatingMaterialStats.builder().durabilityFactor(36).armor(2, 4, 6, 2).toughness(4.5f),
                    StatlessMaterialStats.MAILLE);

            // melee, armor
            addMaterialStats(horizonite,
                    new HeadMaterialStats(250, 8.0f, Tiers.DIAMOND, 1.75f),
                    HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(1f).attackDamage(1.1f).build(),
                    StatlessMaterialStats.BINDING);
            addArmorShieldStats(horizonite,
                    PlatingMaterialStats.builder().durabilityFactor(15).armor(1, 4, 5, 2),
                    StatlessMaterialStats.MAILLE);

            // TODO: for shields, plating
//            addMaterialStats(moonstone, PlatingMaterialStats.SHIELD.getDefaultStats());
//            addArmorShieldStats();

            // melee, armor
            // gold? equivalent
            addMaterialStats(pyrope,
                    new HeadMaterialStats(300, 11f, Tiers.STONE, 1.55f),
                    HandleMaterialStats.multipliers().durability(1.05f).miningSpeed(1.1f).attackSpeed(1.15f).build(),
                    StatlessMaterialStats.BINDING);
            addArmorShieldStats(pyrope,
                    PlatingMaterialStats.builder().durabilityFactor(15).armor(1, 4, 5, 2),
                    StatlessMaterialStats.MAILLE);
        }

        @Nonnull
        @Override
        public String getName() {
            return "Blue Skies Material Stats";
        }
    }
}
