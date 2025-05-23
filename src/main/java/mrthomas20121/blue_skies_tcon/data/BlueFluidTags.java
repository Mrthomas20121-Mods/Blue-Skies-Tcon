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

public class BlueFluidTags extends FluidTagsProvider {

    // forge tags
    public static final TagKey<Fluid> AQUITE = forgeTag("molten_aquite");
    public static final TagKey<Fluid> CHAROITE = forgeTag("molten_charoite");
    public static final TagKey<Fluid> DIOPSIDE = forgeTag("molten_diopside");
    public static final TagKey<Fluid> HORIZONITE = forgeTag("molten_horizonite");
    public static final TagKey<Fluid> PYROPE = forgeTag("molten_pyrope");
    public static final TagKey<Fluid> MOONSTONE = forgeTag("molten_moonstone");
    public static final TagKey<Fluid> FALSITE = forgeTag("molten_falsite");
    public static final TagKey<Fluid> VENTIUM = forgeTag("molten_ventium");

    // Blue skies tags
    // TODO: seems dumb to have both
    public static final TagKey<Fluid> AQUITE_ = modTag("molten_aquite");
    public static final TagKey<Fluid> CHAROITE_ = modTag("molten_charoite");
    public static final TagKey<Fluid> DIOPSIDE_ = modTag("molten_diopside");
    public static final TagKey<Fluid> HORIZONITE_ = modTag("molten_horizonite");
    public static final TagKey<Fluid> PYROPE_ = modTag("molten_pyrope");
    public static final TagKey<Fluid> MOONSTONE_ = modTag("molten_moonstone");
    public static final TagKey<Fluid> FALSITE_ = modTag("molten_falsite");
    public static final TagKey<Fluid> VENTIUM_ = modTag("molten_ventium");

    public static TagKey<Fluid> forgeTag(String name) {
        return create(new ResourceLocation("forge", name));
    }
    public static TagKey<Fluid> modTag(String name) {
        return create(new ResourceLocation(BlueSkiesTcon.MOD_ID, name));
    }

    public static TagKey<Fluid> create(ResourceLocation name) {
        return FluidTags.create(name);
    }

    public BlueFluidTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, BlueSkiesTcon.MOD_ID, existingFileHelper);
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
//        tag(AQUITE_).add(BlueFluids.aquite.get());
//        tag(CHAROITE_).add(BlueFluids.charoite.get());
//        tag(DIOPSIDE_).add(BlueFluids.diopside.get());
//        tag(HORIZONITE_).add(BlueFluids.horizonite.get());
//        tag(PYROPE_).add(BlueFluids.pyrope.get());
//        tag(MOONSTONE_).add(BlueFluids.moonstone.get());
//        tag(FALSITE_).add(BlueFluids.falsite.get());
//        tag(VENTIUM_).add(BlueFluids.ventium.get());
    }
}
