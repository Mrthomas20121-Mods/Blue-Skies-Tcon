package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlueFluidTags extends FluidTagsProvider {

    // forge tags
    public static final ITag.INamedTag<Fluid> AQUITE = FluidTags.bind("forge:molten_aquite");
    public static final ITag.INamedTag<Fluid> CHAROITE = FluidTags.bind("forge:molten_charoite");
    public static final ITag.INamedTag<Fluid> DIOPSIDE = FluidTags.bind("forge:molten_diopside");
    public static final ITag.INamedTag<Fluid> HORIZONITE = FluidTags.bind("forge:molten_horizonite");
    public static final ITag.INamedTag<Fluid> PYROPE = FluidTags.bind("forge:molten_pyrope");
    public static final ITag.INamedTag<Fluid> MOONSTONE = FluidTags.bind("forge:molten_moonstone");
    public static final ITag.INamedTag<Fluid> FALSITE = FluidTags.bind("forge:molten_falsite");
    public static final ITag.INamedTag<Fluid> VENTIUM = FluidTags.bind("forge:molten_ventium");

    // Blue skies tags
    public static final ITag.INamedTag<Fluid> AQUITE_ = FluidTags.bind("blue_skies_tcon:molten_aquite");
    public static final ITag.INamedTag<Fluid> CHAROITE_ = FluidTags.bind("blue_skies_tcon:molten_charoite");
    public static final ITag.INamedTag<Fluid> DIOPSIDE_ = FluidTags.bind("blue_skies_tcon:molten_diopside");
    public static final ITag.INamedTag<Fluid> HORIZONITE_ = FluidTags.bind("blue_skies_tcon:molten_horizonite");
    public static final ITag.INamedTag<Fluid> PYROPE_ = FluidTags.bind("blue_skies_tcon:molten_pyrope");
    public static final ITag.INamedTag<Fluid> MOONSTONE_ = FluidTags.bind("blue_skies_tcon:molten_moonstone");
    public static final ITag.INamedTag<Fluid> FALSITE_ = FluidTags.bind("blue_skies_tcon:molten_falsite");
    public static final ITag.INamedTag<Fluid> VENTIUM_ = FluidTags.bind("blue_skies_tcon:molten_ventium");

    public static final ITag.INamedTag<Fluid> LAVA = FluidTags.bind("minecraft:lava");

    public BlueFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(LAVA)
             .add(
                     Fluids.aquite.getStill(),
                     Fluids.aquite.getFlowing(),
                     Fluids.charoite.getStill(),
                     Fluids.charoite.getFlowing(),
                     Fluids.diopside.getStill(),
                     Fluids.diopside.getFlowing(),
                     Fluids.horizonite.getStill(),
                     Fluids.horizonite.getFlowing(),
                     Fluids.pyrope.getStill(),
                     Fluids.pyrope.getFlowing(),
                     Fluids.moonstone.getStill(),
                     Fluids.moonstone.getFlowing(),
                     Fluids.falsite.getStill(),
                     Fluids.falsite.getFlowing(),
                     Fluids.ventium.getStill(),
                     Fluids.ventium.getFlowing()
             );
        tag(AQUITE).add(Fluids.aquite.getStill(), Fluids.aquite.getFlowing());
        tag(AQUITE_).add(Fluids.aquite.getStill(), Fluids.aquite.getFlowing());
        tag(CHAROITE).add(Fluids.charoite.getStill(), Fluids.charoite.getFlowing());
        tag(CHAROITE_).add(Fluids.charoite.getStill(), Fluids.charoite.getFlowing());
        tag(DIOPSIDE).add(Fluids.diopside.getStill(), Fluids.diopside.getFlowing());
        tag(DIOPSIDE_).add(Fluids.diopside.getStill(), Fluids.diopside.getFlowing());
        tag(HORIZONITE).add(Fluids.horizonite.getStill(), Fluids.horizonite.getFlowing());
        tag(HORIZONITE_).add(Fluids.horizonite.getStill(), Fluids.horizonite.getFlowing());
        tag(PYROPE).add(Fluids.pyrope.getStill(), Fluids.pyrope.getFlowing());
        tag(PYROPE_).add(Fluids.pyrope.getStill(), Fluids.pyrope.getFlowing());
        tag(MOONSTONE).add(Fluids.moonstone.getStill(), Fluids.moonstone.getFlowing());
        tag(MOONSTONE_).add(Fluids.moonstone.getStill(), Fluids.moonstone.getFlowing());
        tag(FALSITE).add(Fluids.falsite.getStill(), Fluids.falsite.getFlowing());
        tag(FALSITE_).add(Fluids.falsite.getStill(), Fluids.falsite.getFlowing());
        tag(VENTIUM).add(Fluids.ventium.getStill(), Fluids.ventium.getFlowing());
        tag(VENTIUM_).add(Fluids.ventium.getStill(), Fluids.ventium.getFlowing());
    }
}
