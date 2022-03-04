package mrthomas20121.blue_skies_tcon.datagen;

import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.BlueFluid;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class BlueBlockStates extends BlockStateProvider {

    public BlueBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, BlueSkiesTcon.MOD_ID, exFileHelper);
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

    public void blockWithItem(RegistryObject<Block> registryObject) {
        //block model
        simpleBlock(registryObject.get());
        //itemblock model
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "block/" + id.getPath());
        itemModels().cubeAll(id.getPath(), textureLocation);
    }

    public void fluid(BlueFluid fluid) {
        ResourceLocation name = fluid.getBlock().get().getRegistryName();
        simpleBlock(fluid.getBlock().get(), models().cubeAll(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath()+"_still")));
    }
}
