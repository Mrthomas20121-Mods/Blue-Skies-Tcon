package mrthomas20121.blue_skies_tcon.datagen;

import com.legacy.blue_skies.registries.SkiesBlocks;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.CustomByProduct;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.crafting.conditions.TrueCondition;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.data.AdvancementsProvider;
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
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {
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
                .setFluidAndTime(new FluidStack(net.minecraft.fluid.Fluids.LAVA.getFluid(), FluidValues.GLASS_BLOCK))
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"lava"));
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_water_bucket)
                .setFluidAndTime(new FluidStack(net.minecraft.fluid.Fluids.WATER.getFluid(), FluidValues.GLASS_BLOCK))
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"water"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.aquite.getVentiumBucket().get())
                .setFluidAndTime(Fluids.aquite.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"aquite"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.charoite.getVentiumBucket().get())
                .setFluidAndTime(Fluids.charoite.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"charoite"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.diopside.getVentiumBucket().get())
                .setFluidAndTime(Fluids.diopside.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"diopside"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.horizonite.getVentiumBucket().get())
                .setFluidAndTime(Fluids.horizonite.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"horizonite"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.pyrope.getVentiumBucket().get())
                .setFluidAndTime(Fluids.pyrope.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"pyrope"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.moonstone.getVentiumBucket().get())
                .setFluidAndTime(Fluids.moonstone.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"moonstone"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.falsite.getVentiumBucket().get())
                .setFluidAndTime(Fluids.falsite.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"falsite"));
        ItemCastingRecipeBuilder
                .tableRecipe(Fluids.ventium.getVentiumBucket().get())
                .setFluidAndTime(Fluids.ventium.asObject(), true, FluidValues.GLASS_BLOCK)
                .setCast(SkiesItems.ventium_bucket, true)
                .build(consumer, modResource(bucketCastingFolder+"ventium"));
        ItemCastingRecipeBuilder
                .tableRecipe(SkiesItems.ventium_bucket)
                .setFluidAndTime(Fluids.ventium.asObject(), true, FluidValues.INGOT*3)
                .build(consumer, modResource(bucketCastingFolder+"ventium_bucket"));

        gemCasting(consumer, Fluids.aquite.asObject(), SkiesItems.aquite_gem, castingFolder+"aquite_gem");
        gemCasting(consumer, Fluids.charoite.asObject(), SkiesItems.charoite, castingFolder+"charoite_gem");
        gemCasting(consumer, Fluids.diopside.asObject(), SkiesItems.diopside_gem, castingFolder+"diopside_gem");
        gemCasting(consumer, Fluids.pyrope.asObject(), SkiesItems.pyrope_gem, castingFolder+"pyrope_gem");
        gemCasting(consumer, Fluids.moonstone.asObject(), SkiesBlocks.moonstone.asItem(), castingFolder+"moonstone_gem");
        ingotCasting(consumer, Fluids.horizonite.asObject(), SkiesItems.horizonite_ingot, castingFolder+"horizonite_block");
        blockBasin(consumer, Fluids.horizonite.asObject(), SkiesBlocks.horizonite_block, castingFolder+"horizonite_block");
        ingotCasting(consumer, Fluids.falsite.asObject(), SkiesItems.falsite_ingot, castingFolder+"falsite_block");
        blockBasin(consumer, Fluids.falsite.asObject(), SkiesBlocks.falsite_block, castingFolder+"falsite_block");
        ingotCasting(consumer, Fluids.ventium.asObject(), SkiesItems.ventium_ingot, castingFolder+"ventium_block");
        blockBasin(consumer, Fluids.ventium.asObject(), SkiesBlocks.ventium_block, castingFolder+"ventium_block");

        gemMelting(consumer, Fluids.aquite.getStill(), "aquite", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.charoite.getStill(), "charoite", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.diopside.getStill(), "diopside", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.pyrope.getStill(), "pyrope", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        metalMelting(consumer, Fluids.horizonite.getStill(), "horizonite", true, false, meltingFolder, false, Byproduct.IRON);
        metalMelting(consumer, Fluids.falsite.getStill(), "falsite", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        metalMelting(consumer, Fluids.ventium.getStill(), "ventium", true, false, meltingFolder, false, CustomByProduct.MOONSTONE);
        gemMelting(consumer, Fluids.moonstone.getStill(), "moonstone", true, false, meltingFolder, false);

        MoldingRecipeBuilder.moldingTable(BlueItems.midnight_sand.getBlank().get())
                .setMaterial(BlueItemTags.midnight_sand_casts)
                .build(consumer, modResource("smeltery/midnight_sand_cast_pickup"));

        MoldingRecipeBuilder.moldingTable(BlueItems.crystal_sand.getBlank().get())
                .setMaterial(BlueItemTags.crystal_sand_casts)
                .build(consumer, modResource("smeltery/crystal_sand_cast_pickup"));



        // material melting
        //materialMeltingCasting(consumer, BlueMaterials.aquite, Fluids.aquite.asObject(), true, materialFolder+"aquite");
        //materialMeltingCasting(consumer, BlueMaterials.charoite, Fluids.charoite.asObject(), true,materialFolder+"charoite");
        //materialMeltingCasting(consumer, BlueMaterials.diopside, Fluids.diopside.asObject(), true,materialFolder+"diopside");
        //materialMeltingCasting(consumer, BlueMaterials.horizonite, Fluids.horizonite.asObject(), true,materialFolder+"horizonite");
        //materialMeltingCasting(consumer, BlueMaterials.pyrope, Fluids.pyrope.asObject(), true,materialFolder+"pyrope");
    }

    protected void blockBasin(Consumer<IFinishedRecipe> consumer, FluidObject<ForgeFlowingFluid> object, Block block, String folder) {
        ItemCastingRecipeBuilder.basinRecipe(block)
                .setFluidAndTime(object, true, FluidValues.METAL_BLOCK)
                .setSwitchSlots()
                .build(consumer, modResource(folder+block.getRegistryName().getPath()));
    }

    void customOreMelting(Consumer<IFinishedRecipe> consumer, Fluid fluid, int amount, String tagName, float factor, String recipePath, boolean isOptional, IByproduct... byproducts) {
        Consumer<IFinishedRecipe> wrapped = isOptional ? withCondition(consumer, tagCondition(tagName)) : consumer;
        Supplier<MeltingRecipeBuilder> supplier = () -> MeltingRecipeBuilder.melting(Ingredient.of(getTag("forge", tagName)), fluid, amount, factor).setOre();
        ResourceLocation location = modResource(recipePath);

        // if no byproducts, just build directly
        if (byproducts.length == 0) {
            supplier.get().build(wrapped, location);
            // if first option is always present, only need that one
        } else if (byproducts[0].isAlwaysPresent()) {
            supplier.get()
                    .addByproduct(new FluidStack(byproducts[0].getFluid(), byproducts[0].getNuggets()))
                    .build(wrapped, location);
        } else {
            // multiple options, will need a conditonal recipe
            ConditionalRecipe.Builder builder = ConditionalRecipe.builder();
            boolean alwaysPresent = false;
            for (IByproduct byproduct : byproducts) {
                builder.addCondition(tagCondition("gems/" + byproduct.getName()));
                builder.addRecipe(supplier.get().addByproduct(new FluidStack(byproduct.getFluid(), byproduct.getNuggets()))::build);
                // found an always present byproduct? we are done
                alwaysPresent = byproduct.isAlwaysPresent();
                if (alwaysPresent) {
                    break;
                }
            }
            // not always present? add a recipe with no byproducts as a final fallback
            if (!alwaysPresent) {
                builder.addCondition(TrueCondition.INSTANCE);
                builder.addRecipe(supplier.get()::build);
            }
            builder.build(wrapped, location);
        }
    }

    private void gemMelting(Consumer<IFinishedRecipe> consumer, Fluid fluid, String name, boolean hasOre, boolean hasDust, String folder, boolean isOptional, IByproduct... byproducts) {
        String prefix = folder + "/" + name + "/";
        metalMeltingBase(consumer, fluid, FluidValues.METAL_BLOCK, "storage_blocks/" + name, 3.0f, prefix + "block", isOptional);
        metalMeltingBase(consumer, fluid, FluidValues.INGOT, "gems/" + name, 1.0f, prefix + "gem", isOptional);
        metalMeltingBase(consumer, fluid, FluidValues.NUGGET, "nuggets/" + name, 1 / 3f, prefix + "nugget", isOptional);
        if (hasOre) {
            customOreMelting(consumer, fluid, FluidValues.INGOT, "ores/" + name, 1.5f, prefix + "ore", isOptional, byproducts);
        }
        // remaining forms are always optional as we don't ship them
        // allow disabling dust as some mods treat dust as distinct from ingots
        if (hasDust) {
            metalMeltingBase(consumer, fluid, FluidValues.INGOT, "dusts/" + name, 0.75f, prefix + "dust", true);
        }
        metalMeltingBase(consumer, fluid, FluidValues.INGOT, "plates/" + name, 1.0f, prefix + "plates", true);
        metalMeltingBase(consumer, fluid, FluidValues.INGOT * 4, "gears/" + name, 2.0f, prefix + "gear", true);
        metalMeltingBase(consumer, fluid, FluidValues.NUGGET * 3, "coins/" + name, 2 / 3f, prefix + "coin", true);
        metalMeltingBase(consumer, fluid, FluidValues.INGOT / 2, "rods/" + name, 1 / 5f, prefix + "rod", true);
        metalMeltingBase(consumer, fluid, FluidValues.INGOT / 2, "wires/" + name, 1 / 5f, prefix + "wire", true);
        metalMeltingBase(consumer, fluid, FluidValues.INGOT, "sheetmetals/" + name, 1.0f, prefix + "sheetmetal", true);
    }

    @Nonnull
    @Override
    public String getModId() {
        return BlueSkiesTcon.MOD_ID;
    }
}
