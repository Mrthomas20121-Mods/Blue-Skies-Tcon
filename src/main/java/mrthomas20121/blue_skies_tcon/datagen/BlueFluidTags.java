package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

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

    public BlueFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(AQUITE).add(Fluids.aquite.get());
        tag(AQUITE_).add(Fluids.aquite.get());
        tag(CHAROITE).add(Fluids.charoite.get());
        tag(CHAROITE_).add(Fluids.charoite.get());
        tag(DIOPSIDE).add(Fluids.diopside.get());
        tag(DIOPSIDE_).add(Fluids.diopside.get());
        tag(HORIZONITE).add(Fluids.horizonite.get());
        tag(HORIZONITE_).add(Fluids.horizonite.get());
        tag(PYROPE).add(Fluids.pyrope.get());
        tag(PYROPE_).add(Fluids.pyrope.get());
        tag(MOONSTONE).add(Fluids.moonstone.get());
        tag(MOONSTONE_).add(Fluids.moonstone.get());
        tag(FALSITE).add(Fluids.falsite.get());
        tag(FALSITE_).add(Fluids.falsite.get());
        tag(VENTIUM).add(Fluids.ventium.get());
        tag(VENTIUM_).add(Fluids.ventium.get());
    }
}
