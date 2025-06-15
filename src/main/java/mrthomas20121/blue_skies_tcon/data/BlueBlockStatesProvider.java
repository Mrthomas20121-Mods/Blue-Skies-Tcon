package mrthomas20121.blue_skies_tcon.data;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FlowingFluidObject;

public class BlueBlockStatesProvider extends BlockStateProvider {

    public BlueBlockStatesProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, BlueSkiesTcon.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        fluid(BlueFluids.aquite);
        fluid(BlueFluids.charoite);
        fluid(BlueFluids.diopside);
        fluid(BlueFluids.horizonite);
        fluid(BlueFluids.pyrope);
        fluid(BlueFluids.ventium);
        fluid(BlueFluids.falsite);
        fluid(BlueFluids.moonstone);
    }

    public void fluid(FlowingFluidObject<ForgeFlowingFluid> fluid) {
        ResourceLocation name = fluid.getId();
        simpleBlock(fluid.getBlock(), models().cubeAll(name.getPath(), ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath() + "_still")));
    }
}
