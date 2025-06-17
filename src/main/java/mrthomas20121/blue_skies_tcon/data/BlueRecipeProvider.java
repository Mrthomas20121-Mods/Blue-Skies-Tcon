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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
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

        // TODO: missing moulding for ingot, nugget, gem, rod, plate, gear, coin, wire
        castMoulding(consumer, TinkerToolParts.repairKit, TinkerSmeltery.repairKitCast, ItemCast::getRepairKit);
        castMoulding(consumer, TinkerToolParts.pickHead, TinkerSmeltery.pickHeadCast, ItemCast::getPickHead);
        castMoulding(consumer, TinkerToolParts.hammerHead, TinkerSmeltery.hammerHeadCast, ItemCast::getHammerHead);
        castMoulding(consumer, TinkerToolParts.smallAxeHead, TinkerSmeltery.smallAxeHeadCast, ItemCast::getSmallAxeHead);
        castMoulding(consumer, TinkerToolParts.broadAxeHead, TinkerSmeltery.broadAxeHeadCast, ItemCast::getBroadAxeHead);
        castMoulding(consumer, TinkerToolParts.smallBlade, TinkerSmeltery.smallBladeCast, ItemCast::getSmallBlade);
        castMoulding(consumer, TinkerToolParts.broadBlade, TinkerSmeltery.broadBladeCast, ItemCast::getBroadBlade);
        castMoulding(consumer, TinkerToolParts.adzeHead, TinkerSmeltery.adzeHeadCast, ItemCast::getAdzeHead);
        castMoulding(consumer, TinkerToolParts.largePlate, TinkerSmeltery.largePlateCast, ItemCast::getLargePlate);
        castMoulding(consumer, TinkerToolParts.bowLimb, TinkerSmeltery.bowLimbCast, ItemCast::getBowLimb);
        castMoulding(consumer, TinkerToolParts.bowGrip, TinkerSmeltery.bowGripCast, ItemCast::getBowGrip);
        castMoulding(consumer, TinkerToolParts.toolBinding, TinkerSmeltery.toolBindingCast, ItemCast::getToolBinding);
        castMoulding(consumer, TinkerToolParts.toughBinding, TinkerSmeltery.toughBindingCast, ItemCast::getToughCollar);
        castMoulding(consumer, TinkerToolParts.toolHandle, TinkerSmeltery.toolHandleCast, ItemCast::getToolHandle);
        castMoulding(consumer, TinkerToolParts.toughHandle, TinkerSmeltery.toughHandleCast, ItemCast::getToughHandle);
        castMoulding(consumer, TinkerToolParts.maille, TinkerSmeltery.mailleCast, ItemCast::getMaille);
        castMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.HELMET), TinkerSmeltery.helmetPlatingCast, ItemCast::getHelmetPlating);
        castMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.CHESTPLATE), TinkerSmeltery.chestplatePlatingCast, ItemCast::getChestPlating);
        castMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.LEGGINGS), TinkerSmeltery.leggingsPlatingCast, ItemCast::getLegPlating);
        castMoulding(consumer, TinkerToolParts.plating.get(ArmorItem.Type.LEGGINGS), TinkerSmeltery.bootsPlatingCast, ItemCast::getBootPlating);

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
        materialRecipe(consumer, BlueMaterialsProvider.aquite, Ingredient.of(SkiesItems.aquite), 1, 1, toolFolder + "aquite");
        materialRecipe(consumer, BlueMaterialsProvider.charoite, Ingredient.of(SkiesItems.charoite), 1, 1, toolFolder + "charoite");
        materialRecipe(consumer, BlueMaterialsProvider.diopside, Ingredient.of(SkiesItems.diopside_gem), 1, 1, toolFolder + "diopside");
        materialRecipe(consumer, BlueMaterialsProvider.pyrope, Ingredient.of(SkiesItems.pyrope_gem), 1, 1, toolFolder + "pyrope");
        metalMaterialRecipe(consumer, BlueMaterialsProvider.horizonite, toolFolder, "horizonite", false);

        // material casting
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("aquite"), BlueFluids.aquite.get())
                .gem(9);
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("charoite"), BlueFluids.charoite.get())
                .gem(9);
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("diopside"), BlueFluids.diopside.get())
                .gem(9);
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("pyrope"), BlueFluids.pyrope.get())
                .gem(9);
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("horizonite"), BlueFluids.horizonite.get())
                .metal();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("falsite"), BlueFluids.falsite.get())
                .metal();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("ventium"), BlueFluids.ventium.get())
                .metal();
        SmelteryRecipeBuilder.fluid(consumer, BlueSkiesTcon.resource("moonstone"), BlueFluids.moonstone.get())
                .gem(9);

        // material melting
        materialMeltingCasting(consumer, BlueMaterialsProvider.aquite, BlueFluids.aquite, materialFolder + "aquite");
        materialMeltingCasting(consumer, BlueMaterialsProvider.charoite, BlueFluids.charoite, materialFolder + "charoite");
        materialMeltingCasting(consumer, BlueMaterialsProvider.diopside, BlueFluids.diopside, materialFolder + "diopside");
        materialMeltingCasting(consumer, BlueMaterialsProvider.horizonite, BlueFluids.horizonite, materialFolder + "horizonite");
        materialMeltingCasting(consumer, BlueMaterialsProvider.pyrope, BlueFluids.pyrope, materialFolder + "pyrope");
    }

    protected void castMoulding(Consumer<FinishedRecipe> consumer, ItemLike pattern, CastItemObject cast, IItemCast itemCast) {
        final String folder = "smeltery/casts/";

        Item crystal_cast = itemCast.itemOf(BlueItems.CRYSTAL_SAND).get();
        Item midnight_cast = itemCast.itemOf(BlueItems.MIDNIGHT_SAND).get();
        String name = cast.getId().getPath();

        // make sand casts via molding in the casting table
        MoldingRecipeBuilder.moldingTable(crystal_cast)
                .setMaterial(BlueItemTagsProvider.CRYSTAL_SAND_CASTS)
                .setPattern(MaterialIngredient.of(pattern), false)
                .save(consumer, BlueSkiesTcon.resource(folder + "crystal_sand/molding/" + name));
        MoldingRecipeBuilder.moldingTable(midnight_cast)
                .setMaterial(BlueItemTagsProvider.MIDNIGHT_SAND_CASTS)
                .setPattern(pattern, false)
                .save(consumer, BlueSkiesTcon.resource(folder + "midnight_sand/molding/" + name));

        ResourceLocation castName = cast.getName();
        // make sand casts in the pattern builder
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(crystal_cast))
                .setPatternItem(Ingredient.of(BlueItemTagsProvider.CRYSTAL_SAND_CASTS))
                .save(consumer, BlueSkiesTcon.resource(folder + "crystal_sand/builder_cast/" + name));
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(midnight_cast))
                .setPatternItem(Ingredient.of(BlueItemTagsProvider.MIDNIGHT_SAND_CASTS))
                .save(consumer, BlueSkiesTcon.resource(folder + "midnight_sand/builder_cast/" + name));

        // blank sand casts
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(crystal_cast, 4))
                .setPatternItem(Ingredient.of(SkiesBlocks.crystal_sand))
                .save(consumer, BlueSkiesTcon.resource(folder + "crystal_sand/builder_block/" + name));
        ItemPartRecipeBuilder.item(castName, ItemOutput.fromItem(midnight_cast, 4))
                .setPatternItem(Ingredient.of(SkiesBlocks.midnight_sand))
                .save(consumer, BlueSkiesTcon.resource(folder + "midnight_sand/builder_block/" + name));
    }

    @Nonnull
    @Override
    public String getModId() {
        return BlueSkiesTcon.MOD_ID;
    }
}
