package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FlowingFluidObject;

public class BlueBlockStates extends BlockStateProvider {

    public BlueBlockStates(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, BlueSkiesTcon.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        fluid(Fluids.aquite);
        fluid(Fluids.charoite);
        fluid(Fluids.diopside);
        fluid(Fluids.horizonite);
        fluid(Fluids.pyrope);
        fluid(Fluids.ventium);
        fluid(Fluids.falsite);
        fluid(Fluids.moonstone);
    }

    public void fluid(FlowingFluidObject<ForgeFlowingFluid> fluid) {
        ResourceLocation name = fluid.getId();
        simpleBlock(fluid.getBlock(), models().cubeAll(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath()+"_still")));
    }
}
