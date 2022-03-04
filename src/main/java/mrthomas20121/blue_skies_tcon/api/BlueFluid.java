package mrthomas20121.blue_skies_tcon.api;

import com.legacy.blue_skies.items.SkiesItemGroups;
import com.legacy.blue_skies.items.buckets.VentiumBucketItem;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;

public class BlueFluid extends AbstractFluid {

    protected RegistryObject<Item> ventium_bucket;

    protected BlueFluid(String name, String stillTexture, String flowTexture, int temp, int light) {
        super(name, FluidAttributes.builder(new ResourceLocation(stillTexture), new ResourceLocation(flowTexture))
                .density(4000)
                .viscosity(2500)
                .temperature(temp)
                .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY));

        block = Fluids.BLOCKS.register(name, () -> new FlowingFluidBlock(stillFluid, AbstractBlock.Properties.of(Material.LAVA).noCollission().strength(100.0F).lightLevel((state) ->  light).noDrops()));
        bucket = BlueItems.ITEMS.register(bucket(name), () -> new BucketItem(stillFluid, new Item.Properties().craftRemainder(net.minecraft.item.Items.BUCKET).stacksTo(1).tab(SkiesItemGroups.MISC)));
        ventium_bucket = BlueItems.ITEMS.register(ventium_bucket(name), () -> new VentiumBucketItem(stillFluid, new Item.Properties().craftRemainder(SkiesItems.ventium_bucket).stacksTo(1).tab(SkiesItemGroups.MISC)));

        properties.bucket(bucket).block(block).explosionResistance(1000f).tickRate(9);

        object = new FluidObject<>(new ResourceLocation(BlueSkiesTcon.MOD_ID, name), name, stillFluid, flowingFluid, block);
    }

    public RegistryObject<Item> getBucket() {
        return this.bucket;
    }

    public RegistryObject<Item> getVentiumBucket() {
        return ventium_bucket;
    }

    public RegistryObject<FlowingFluidBlock> getBlock() {
        return this.block;
    }

    public RegistryObject<ForgeFlowingFluid.Source> getStillFluid() {
        return this.stillFluid;
    }

    public RegistryObject<ForgeFlowingFluid.Flowing> getFlowingFluid() {
        return this.flowingFluid;
    }

    public static BlueFluid register(String key, int temp, int light) {
        String still = String.format("%s:block/fluid/%s_still", BlueSkiesTcon.MOD_ID, key);
        String flow = String.format("%s:block/fluid/%s_flowing", BlueSkiesTcon.MOD_ID, key);
        return new BlueFluid(key, still, flow, temp, light);
    }

    public String ventium_bucket(String name) {
        return name+"_ventium_bucket";
    }
}
