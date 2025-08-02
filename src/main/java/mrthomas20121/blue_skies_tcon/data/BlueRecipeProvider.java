package mrthomas20121.blue_skies_tcon.data;

import com.legacy.blue_skies.registries.SkiesBlocks;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.item.IItemCast;
import mrthomas20121.blue_skies_tcon.item.ItemCast;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.recipe.helper.ItemOutput;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.library.data.recipe.*;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.ingredient.MaterialIngredient;
import slimeknights.tconstruct.library.recipe.molding.MoldingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.partbuilder.ItemPartRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerToolParts;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class BlueRecipeProvider extends RecipeProvider implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {
    static final String SMELTERY_FOLDER = "smeltery/casts/";

    public BlueRecipeProvider(PackOutput gen) {
        super(gen);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        final String toolFolder = "tools/materials/";
        final String materialFolder = "materials/";
        final String bucketCastingFolder = "smeltery/casting/bucket/";

        // sand casts
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlueItems.CRYSTAL_SAND.getBlank().get(), 4)
                .requires(SkiesBlocks.crystal_sand)
                .unlockedBy("has_casting", has(TinkerSmeltery.searedTable))
                .save(consumer, BlueSkiesTcon.resource("smeltery/crystal_sand_cast"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlueItems.MIDNIGHT_SAND.getBlank().get(), 4)
                .requires(SkiesBlocks.midnight_sand)
                .unlockedBy("has_casting", has(TinkerSmeltery.searedTable))
                .save(consumer, BlueSkiesTcon.resource("smeltery/midnight_sand_cast"));

        castBuildingMoulding(consumer, TinkerToolParts.repairKit, TinkerSmeltery.repairKitCast, ItemCast::getRepairKit);
        castBuildingMoulding(consumer, TinkerToolParts.pickHead, TinkerSmeltery.pickHeadCast, ItemCast::getPickHead);
        castBuildingMoulding(consumer, TinkerToolParts.hammerHead, TinkerSmeltery.hammerHeadCast, ItemCast::getHammerHead);
        castBuildingMoulding(consumer, TinkerToolParts.smallAxeHead, TinkerSmeltery.smallAxeHeadCast, ItemCast::getSmallAxeHead);
        castBuildingMoulding(consumer, TinkerToolParts.broadAxeHead, TinkerSmeltery.broadAxeHeadCast, ItemCast::getBroadAxeHead);
        castBuildingMoulding(consumer, TinkerToolParts.smallBlade, TinkerSmeltery.smallBladeCast, ItemCast::getSmallBlade);
        castBuildingMoulding(consumer, TinkerToolParts.broadBlade, TinkerSmeltery.broadBladeCast, ItemCast::getBroadBlade);
        castBuildingMoulding(consumer, TinkerToolParts.adzeHead, TinkerSmeltery.adzeHeadCast, ItemCast::getAdzeHead);
        castBuildingMoulding(consumer, TinkerToolParts.largePlate, TinkerSmeltery.largePlateCast, ItemCast::getLargePlate);
        castBuildingMoulding(consumer, TinkerToolParts.bowLimb, TinkerSmeltery.bowLimbCast, ItemCast::getBowLimb);
        castBuildingMoulding(consumer, TinkerToolParts.bowGrip, TinkerSmeltery.bowGripCast, ItemCast::getBowGrip);
        castBuildingMoulding(consumer, TinkerToolParts.toolBinding, TinkerSmeltery.toolBindingCast, ItemCast::getToolBinding);
        castBuildingMoulding(consumer, TinkerToolParts.toughBinding, TinkerSmeltery.toughBindingCast, ItemCast::getToughCollar);
        castBuildingMoulding(consumer, TinkerToolParts.toolHandle, TinkerSmeltery.toolHandleCast, ItemCast::getToolHandle);
        castBuildingMoulding(consumer, TinkerToolParts.toughHandle, TinkerSmeltery.toughHandleCast, ItemCast::getToughHandle);
        castBuildingMoulding(consumer, TinkerToolParts.maille, TinkerSmeltery.mailleCast, ItemCast::getMaille);
        castBuildingMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.HELMET), TinkerSmeltery.helmetPlatingCast, ItemCast::getHelmetPlating);
        castBuildingMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.CHESTPLATE), TinkerSmeltery.chestplatePlatingCast, ItemCast::getChestPlating);
        castBuildingMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.LEGGINGS), TinkerSmeltery.leggingsPlatingCast, ItemCast::getLegPlating);
        castBuildingMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.LEGGINGS), TinkerSmeltery.bootsPlatingCast, ItemCast::getBootPlating);

        castBuildingMoulding(consumer, Tags.Items.INGOTS, TinkerSmeltery.ingotCast, ItemCast::getIngot);
        castBuildingMoulding(consumer, Tags.Items.NUGGETS, TinkerSmeltery.nuggetCast, ItemCast::getNugget);
        castBuildingMoulding(consumer, Tags.Items.GEMS, TinkerSmeltery.gemCast, ItemCast::getGem);
        castBuildingMoulding(consumer, Tags.Items.RODS, TinkerSmeltery.rodCast, ItemCast::getRod);

        castBuildingMoulding(consumer, ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "plate")), TinkerSmeltery.plateCast, ItemCast::getPlate);
        castBuildingMoulding(consumer, ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "gear")), TinkerSmeltery.gearCast, ItemCast::getGear);
        castBuildingMoulding(consumer, ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "coin")), TinkerSmeltery.coinCast, ItemCast::getCoin);
        castBuildingMoulding(consumer, ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "wire")), TinkerSmeltery.wireCast, ItemCast::getWire);

        // bucket recipes
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_lava_bucket)
                .setFluidAndTime(new FluidStack(net.minecraft.world.level.material.Fluids.LAVA.getSource(), FluidValues.GLASS_BLOCK))
                .setCast(SkiesItems.ventium_bucket, true)
                .save(consumer, BlueSkiesTcon.resource(bucketCastingFolder + "lava"));
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_water_bucket)
                .setFluidAndTime(new FluidStack(net.minecraft.world.level.material.Fluids.WATER.getSource(), FluidValues.GLASS_BLOCK))
                .setCast(SkiesItems.ventium_bucket, true)
                .save(consumer, BlueSkiesTcon.resource(bucketCastingFolder + "water"));
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_bucket)
                .setFluidAndTime(BlueFluids.ventium, FluidValues.INGOT * 3)
                .save(consumer, BlueSkiesTcon.resource(bucketCastingFolder + "ventium_bucket"));

        // repair materials
        materialRecipe(consumer, BlueMaterialsProvider.aquite, Ingredient.of(SkiesItems.aquite), 1, 1, toolFolder + "aquite/gem");
        materialRecipe(consumer, BlueMaterialsProvider.aquite, Ingredient.of(SkiesBlocks.aquite_block.asItem()), 9, 1, toolFolder + "aquite/block");
        materialRecipe(consumer, BlueMaterialsProvider.charoite, Ingredient.of(SkiesItems.charoite), 1, 1, toolFolder + "charoite/gem");
        materialRecipe(consumer, BlueMaterialsProvider.charoite, Ingredient.of(SkiesBlocks.charoite_block.asItem()), 9, 1, toolFolder + "charoite/block");
        materialRecipe(consumer, BlueMaterialsProvider.diopside, Ingredient.of(SkiesItems.diopside_gem), 1, 1, toolFolder + "diopside/gem");
        materialRecipe(consumer, BlueMaterialsProvider.diopside, Ingredient.of(SkiesBlocks.diopside_block.asItem()), 9, 1, toolFolder + "diopside/block");
        materialRecipe(consumer, BlueMaterialsProvider.pyrope, Ingredient.of(SkiesItems.pyrope_gem), 1, 1, toolFolder + "pyrope/gem");
        materialRecipe(consumer, BlueMaterialsProvider.pyrope, Ingredient.of(SkiesBlocks.pyrope_block.asItem()), 9, 1, toolFolder + "pyrope/block");
        metalMaterialRecipe(consumer, BlueMaterialsProvider.horizonite, toolFolder, "horizonite", false);

        // material casting
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("aquite"), BlueFluids.aquite.get())
                .ore()
                .largeGem()
                .rawOre(); // TODO: raw ores double when they should only 1.33x
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("charoite"), BlueFluids.charoite.get())
                .ore()
                .largeGem()
                .rawOre(); // same problem
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("diopside"), BlueFluids.diopside.get())
                .ore()
                .largeGem();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("pyrope"), BlueFluids.pyrope.get())
                .ore()
                .largeGem();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("falsite"), BlueFluids.falsite.get())
                .ore()
                .metal();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("horizonite"), BlueFluids.horizonite.get())
                .ore()
                .metal();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("ventium"), BlueFluids.ventium.get())
                .ore()
                .metal();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("moonstone"), BlueFluids.moonstone.get())
                .ore()
                .largeGem();

        // material part melting and casting
        materialMeltingCasting(consumer, BlueMaterialsProvider.aquite, BlueFluids.aquite, 100,materialFolder + "aquite/");
        materialMeltingCasting(consumer, BlueMaterialsProvider.charoite, BlueFluids.charoite, 100, materialFolder + "charoite/");
        materialMeltingCasting(consumer, BlueMaterialsProvider.diopside, BlueFluids.diopside, 100, materialFolder + "diopside/");
        materialMeltingCasting(consumer, BlueMaterialsProvider.horizonite, BlueFluids.horizonite, 90, materialFolder + "horizonite/");
        materialMeltingCasting(consumer, BlueMaterialsProvider.pyrope, BlueFluids.pyrope, 100, materialFolder + "pyrope/");
    }

    protected void castMoulding(Consumer<FinishedRecipe> consumer, Ingredient ingredient, CastItemObject cast, IItemCast itemCast) {
        Item crystal_cast = itemCast.itemOf(BlueItems.CRYSTAL_SAND).get();
        Item midnight_cast = itemCast.itemOf(BlueItems.MIDNIGHT_SAND).get();
        String name = cast.getId().getPath();

        // make sand casts via molding in the casting table
        MoldingRecipeBuilder.moldingTable(crystal_cast)
                .setMaterial(BlueItemTagsProvider.CRYSTAL_SAND_CASTS)
                .setPattern(ingredient, false)
                .save(consumer, BlueSkiesTcon.resource(SMELTERY_FOLDER + "crystal_sand/molding/" + name));
        MoldingRecipeBuilder.moldingTable(midnight_cast)
                .setMaterial(BlueItemTagsProvider.MIDNIGHT_SAND_CASTS)
                .setPattern(ingredient, false)
                .save(consumer, BlueSkiesTcon.resource(SMELTERY_FOLDER + "midnight_sand/molding/" + name));
    }

    protected void castBuilding(Consumer<FinishedRecipe> consumer, CastItemObject cast, IItemCast itemCast) {
        Item crystal_cast = itemCast.itemOf(BlueItems.CRYSTAL_SAND).get();
        Item midnight_cast = itemCast.itemOf(BlueItems.MIDNIGHT_SAND).get();
        String name = cast.getId().getPath();

        ResourceLocation castName = cast.getName();
        // make sand casts in the pattern builder
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(crystal_cast))
                .setPatternItem(Ingredient.of(BlueItemTagsProvider.CRYSTAL_SAND_CASTS))
                .save(consumer, BlueSkiesTcon.resource(SMELTERY_FOLDER + "crystal_sand/builder_cast/" + name));
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(midnight_cast))
                .setPatternItem(Ingredient.of(BlueItemTagsProvider.MIDNIGHT_SAND_CASTS))
                .save(consumer, BlueSkiesTcon.resource(SMELTERY_FOLDER + "midnight_sand/builder_cast/" + name));

        // blank sand casts
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(crystal_cast, 4))
                .setPatternItem(Ingredient.of(SkiesBlocks.crystal_sand))
                .save(consumer, BlueSkiesTcon.resource(SMELTERY_FOLDER + "crystal_sand/builder_block/" + name));
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(midnight_cast, 4))
                .setPatternItem(Ingredient.of(SkiesBlocks.midnight_sand))
                .save(consumer, BlueSkiesTcon.resource(SMELTERY_FOLDER + "midnight_sand/builder_block/" + name));
    }

    protected void castBuildingMoulding(Consumer<FinishedRecipe> consumer, ItemLike pattern, CastItemObject cast, IItemCast itemCast) {
        castMoulding(consumer, MaterialIngredient.of(pattern), cast, itemCast);
        castBuilding(consumer, cast, itemCast);
    }

    protected void castBuildingMoulding(Consumer<FinishedRecipe> consumer, TagKey<Item> tag, CastItemObject cast, IItemCast itemCast) {
        castMoulding(consumer, Ingredient.of(tag), cast, itemCast);
        castBuilding(consumer, cast, itemCast);
    }

    @Nonnull
    @Override
    public String getModId() {
        return BlueSkiesTcon.MOD_ID;
    }
}
