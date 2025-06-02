package mrthomas20121.blue_skies_tcon.data;

import com.legacy.blue_skies.registries.SkiesBlocks;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.CustomByProduct;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.SmelteryRecipeBuilder;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.molding.MoldingRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class BlueRecipeProvider extends RecipeProvider implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public BlueRecipeProvider(PackOutput gen) {
        super(gen);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        String toolFolder = "tools/materials/";
        String materialFolder = "materials/";
        String castingFolder = "smeltery/casting/";
        String meltingFolder = "smeltery/melting/";
        String bucketCastingFolder = "smeltery/casting/bucket/";

        // sand casts
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlueItems.crystal_sand.getBlank().get(), 4)
                .requires(SkiesBlocks.crystal_sand)
                .unlockedBy("has_casting", has(TinkerSmeltery.searedTable))
                .save(consumer, BlueSkiesTcon.resource("smeltery/crystal_sand_cast"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlueItems.midnight_sand.getBlank().get(), 4)
                .requires(SkiesBlocks.midnight_sand)
                .unlockedBy("has_casting", has(TinkerSmeltery.searedTable))
                .save(consumer, BlueSkiesTcon.resource("smeltery/midnight_sand_cast"));

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
        materialRecipe(consumer, BlueMaterials.aquite, Ingredient.of(SkiesItems.aquite), 1, 1, toolFolder + "aquite");
        materialRecipe(consumer, BlueMaterials.charoite, Ingredient.of(SkiesItems.charoite), 1, 1, toolFolder + "charoite");
        materialRecipe(consumer, BlueMaterials.diopside, Ingredient.of(SkiesItems.diopside_gem), 1, 1, toolFolder + "diopside");
        materialRecipe(consumer, BlueMaterials.pyrope, Ingredient.of(SkiesItems.pyrope_gem), 1, 1, toolFolder + "pyrope");
        metalMaterialRecipe(consumer, BlueMaterials.horizonite, toolFolder, "horizonite", false);

//        gemCasting(consumer, BlueFluids.aquite, SkiesItems.aquite, castingFolder + "aquite_gem");
//        gemCasting(consumer, BlueFluids.charoite, SkiesItems.charoite, castingFolder + "charoite_gem");
//        gemCasting(consumer, BlueFluids.diopside, SkiesItems.diopside_gem, castingFolder + "diopside_gem");
//        gemCasting(consumer, BlueFluids.pyrope, SkiesItems.pyrope_gem, castingFolder + "pyrope_gem");
//        gemCasting(consumer, BlueFluids.moonstone, SkiesBlocks.moonstone.asItem(), castingFolder + "moonstone_gem");
//        ingotCasting(consumer, BlueFluids.horizonite, SkiesItems.horizonite_ingot, castingFolder + "horizonite_block");
//        blockBasin(consumer, BlueFluids.horizonite, SkiesBlocks.horizonite_block, castingFolder + "horizonite_block");
//        ingotCasting(consumer, BlueFluids.falsite, SkiesItems.falsite_ingot, castingFolder + "falsite_block");
//        blockBasin(consumer, BlueFluids.falsite, SkiesBlocks.falsite_block, castingFolder + "falsite_block");
//        ingotCasting(consumer, BlueFluids.ventium, SkiesItems.ventium_ingot, castingFolder + "ventium_block");
//        blockBasin(consumer, BlueFluids.ventium, SkiesBlocks.ventium_block, castingFolder + "ventium_block");

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

        MoldingRecipeBuilder.moldingTable(BlueItems.midnight_sand.getBlank().get())
                .setMaterial(BlueItemTags.midnight_sand_casts)
                .save(consumer, BlueSkiesTcon.resource("smeltery/midnight_sand_cast_pickup"));
        MoldingRecipeBuilder.moldingTable(BlueItems.crystal_sand.getBlank().get())
                .setMaterial(BlueItemTags.crystal_sand_casts)
                .save(consumer, BlueSkiesTcon.resource("smeltery/crystal_sand_cast_pickup"));

        // material melting
        materialMeltingCasting(consumer, BlueMaterials.aquite, BlueFluids.aquite, materialFolder + "aquite");
        materialMeltingCasting(consumer, BlueMaterials.charoite, BlueFluids.charoite, materialFolder + "charoite");
        materialMeltingCasting(consumer, BlueMaterials.diopside, BlueFluids.diopside, materialFolder + "diopside");
        materialMeltingCasting(consumer, BlueMaterials.horizonite, BlueFluids.horizonite, materialFolder + "horizonite");
        materialMeltingCasting(consumer, BlueMaterials.pyrope, BlueFluids.pyrope, materialFolder + "pyrope");
    }

    protected void blockBasin(Consumer<FinishedRecipe> consumer, FluidObject<ForgeFlowingFluid> object, Block block, String folder) {
        ItemCastingRecipeBuilder.basinRecipe(block)
                .setFluidAndTime(object, FluidValues.METAL_BLOCK)
                .setSwitchSlots()
                .save(consumer, BlueSkiesTcon.resource(folder + block.getDescriptionId()));
    }

    @Nonnull
    @Override
    public String getModId() {
        return BlueSkiesTcon.MOD_ID;
    }
}
