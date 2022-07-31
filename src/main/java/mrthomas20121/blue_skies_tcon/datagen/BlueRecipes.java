package mrthomas20121.blue_skies_tcon.datagen;

import com.legacy.blue_skies.registries.SkiesBlocks;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.CustomByProduct;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.crafting.conditions.TrueCondition;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.data.recipe.*;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.molding.MoldingRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.data.Byproduct;

import javax.annotation.Nonnull;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BlueRecipes extends RecipeProvider implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public BlueRecipes(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        String materialFolder = "materials/";
        String meltingFolder = "smeltery/melting/";
        String castingFolder = "smeltery/casting/";
        String bucketCastingFolder = "smeltery/casting/bucket/";

        // sand casts
        ShapelessRecipeBuilder.shapeless(BlueItems.crystal_sand.getBlank().get(), 4)
                .requires(SkiesBlocks.crystal_sand)
                .unlockedBy("has_casting", has(TinkerSmeltery.searedTable))
                .save(consumer, modResource("smeltery/crystal_sand_cast"));
        ShapelessRecipeBuilder.shapeless(BlueItems.midnight_sand.getBlank().get(), 4)
                .requires(SkiesBlocks.midnight_sand)
                .unlockedBy("has_casting", has(TinkerSmeltery.searedTable))
                .save(consumer, modResource("smeltery/midnight_sand_cast"));

        // bucket recipes
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_lava_bucket)
                .setFluidAndTime(new FluidStack(net.minecraft.world.level.material.Fluids.LAVA.getSource(), FluidValues.GLASS_BLOCK))
                .setCast(SkiesItems.ventium_bucket, true)
                .save(consumer, modResource(bucketCastingFolder+"lava"));
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_water_bucket)
                .setFluidAndTime(new FluidStack(net.minecraft.world.level.material.Fluids.WATER.getSource(), FluidValues.GLASS_BLOCK))
                .setCast(SkiesItems.ventium_bucket, true)
                .save(consumer, modResource(bucketCastingFolder+"water"));
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_bucket)
                .setFluidAndTime(Fluids.ventium, true, FluidValues.INGOT*3)
                .save(consumer, modResource(bucketCastingFolder+"ventium_bucket"));

        gemCasting(consumer, Fluids.aquite, SkiesItems.aquite, castingFolder+"aquite_gem");
        gemCasting(consumer, Fluids.charoite, SkiesItems.charoite, castingFolder+"charoite_gem");
        gemCasting(consumer, Fluids.diopside, SkiesItems.diopside_gem, castingFolder+"diopside_gem");
        gemCasting(consumer, Fluids.pyrope, SkiesItems.pyrope_gem, castingFolder+"pyrope_gem");
        gemCasting(consumer, Fluids.moonstone, SkiesBlocks.moonstone.asItem(), castingFolder+"moonstone_gem");
        ingotCasting(consumer, Fluids.horizonite, SkiesItems.horizonite_ingot, castingFolder+"horizonite_block");
        blockBasin(consumer, Fluids.horizonite, SkiesBlocks.horizonite_block, castingFolder+"horizonite_block");
        ingotCasting(consumer, Fluids.falsite, SkiesItems.falsite_ingot, castingFolder+"falsite_block");
        blockBasin(consumer, Fluids.falsite, SkiesBlocks.falsite_block, castingFolder+"falsite_block");
        ingotCasting(consumer, Fluids.ventium, SkiesItems.ventium_ingot, castingFolder+"ventium_block");
        blockBasin(consumer, Fluids.ventium, SkiesBlocks.ventium_block, castingFolder+"ventium_block");

        gemMelting(consumer, Fluids.aquite.get(), "aquite", true, 9, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.charoite.get(), "charoite", true, 9, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.diopside.get(), "diopside", true, 9, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.pyrope.get(), "pyrope", true, 9, meltingFolder, false, CustomByProduct.MOONSTONE);
        metalMelting(consumer, Fluids.horizonite.get(), "horizonite", true, false, meltingFolder, false, Byproduct.IRON);
        metalMelting(consumer, Fluids.falsite.get(), "falsite", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        metalMelting(consumer, Fluids.ventium.get(), "ventium", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.moonstone.get(), "moonstone", true, 9, meltingFolder, false);

        MoldingRecipeBuilder.moldingTable(BlueItems.midnight_sand.getBlank().get())
                .setMaterial(BlueItemTags.midnight_sand_casts)
                .save(consumer, modResource("smeltery/midnight_sand_cast_pickup"));

        MoldingRecipeBuilder.moldingTable(BlueItems.crystal_sand.getBlank().get())
                .setMaterial(BlueItemTags.crystal_sand_casts)
                .save(consumer, modResource("smeltery/crystal_sand_cast_pickup"));



        // material melting
        //materialMeltingCasting(consumer, BlueMaterials.aquite, Fluids.aquite.asObject(), true, materialFolder+"aquite");
        //materialMeltingCasting(consumer, BlueMaterials.charoite, Fluids.charoite.asObject(), true,materialFolder+"charoite");
        //materialMeltingCasting(consumer, BlueMaterials.diopside, Fluids.diopside.asObject(), true,materialFolder+"diopside");
        //materialMeltingCasting(consumer, BlueMaterials.horizonite, Fluids.horizonite.asObject(), true,materialFolder+"horizonite");
        //materialMeltingCasting(consumer, BlueMaterials.pyrope, Fluids.pyrope.asObject(), true,materialFolder+"pyrope");
    }

    protected void blockBasin(Consumer<FinishedRecipe> consumer, FluidObject<ForgeFlowingFluid> object, Block block, String folder) {
        ItemCastingRecipeBuilder.basinRecipe(block)
                .setFluidAndTime(object, true, FluidValues.METAL_BLOCK)
                .setSwitchSlots()
                .save(consumer, modResource(folder+block.getRegistryName().getPath()));
    }

    @Nonnull
    @Override
    public String getModId() {
        return BlueSkiesTcon.MOD_ID;
    }
}
