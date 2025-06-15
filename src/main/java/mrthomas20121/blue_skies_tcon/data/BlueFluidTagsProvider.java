package mrthomas20121.blue_skies_tcon.data;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlueFluidTagsProvider extends FluidTagsProvider {

    // forge tags
    public static final TagKey<Fluid> AQUITE = forgeTag("molten_aquite");
    public static final TagKey<Fluid> CHAROITE = forgeTag("molten_charoite");
    public static final TagKey<Fluid> DIOPSIDE = forgeTag("molten_diopside");
    public static final TagKey<Fluid> HORIZONITE = forgeTag("molten_horizonite");
    public static final TagKey<Fluid> PYROPE = forgeTag("molten_pyrope");
    public static final TagKey<Fluid> MOONSTONE = forgeTag("molten_moonstone");
    public static final TagKey<Fluid> FALSITE = forgeTag("molten_falsite");
    public static final TagKey<Fluid> VENTIUM = forgeTag("molten_ventium");

    public static TagKey<Fluid> forgeTag(String name) {
        return FluidTags.create(ResourceLocation.fromNamespaceAndPath("forge", name));
    }

    public BlueFluidTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Blue Skies TCon Fluid Tags Provider";
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(AQUITE).add(BlueFluids.aquite.get());
        tag(CHAROITE).add(BlueFluids.charoite.get());
        tag(DIOPSIDE).add(BlueFluids.diopside.get());
        tag(HORIZONITE).add(BlueFluids.horizonite.get());
        tag(PYROPE).add(BlueFluids.pyrope.get());
        tag(MOONSTONE).add(BlueFluids.moonstone.get());
        tag(FALSITE).add(BlueFluids.falsite.get());
        tag(VENTIUM).add(BlueFluids.ventium.get());
    }
}
