package mrthomas20121.blue_skies_tcon.datagen;

import com.legacy.blue_skies.registries.SkiesBlocks;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlueBlockTags extends BlockTagsProvider {

    public static final TagKey<Block> AQUITE_BLOCK = create("forge:storage_blocks/aquite");
    public static final TagKey<Block> CHAROITE_BLOCK = create("forge:storage_blocks/charoite");
    public static final TagKey<Block> DIOPSIDE_BLOCK = create("forge:storage_blocks/diopside");
    public static final TagKey<Block> HORIZONITE_BLOCK = create("forge:storage_blocks/horizonite");
    public static final TagKey<Block> FALSITE_BLOCK = create("forge:storage_blocks/falsite");
    public static final TagKey<Block> VENTIUM_BLOCK = create("forge:storage_blocks/ventium");
    public static final TagKey<Block> MOONSTONE_BLOCK = create("forge:storage_blocks/moonstone");
    public static final TagKey<Block> PYROPE_BLOCK = create("forge:storage_blocks/pyrope");

    public static final TagKey<Block> AQUITE_ORE = create("forge:ores/aquite");
    public static final TagKey<Block> CHAROITE_ORE = create("forge:ores/charoite");
    public static final TagKey<Block> DIOPSIDE_ORE = create("forge:ores/diopside");
    public static final TagKey<Block> HORIZONITE_ORE = create("forge:ores/horizonite");
    public static final TagKey<Block> FALSITE_ORE = create("forge:ores/falsite");
    public static final TagKey<Block> VENTIUM_ORE = create("forge:ores/ventium");
    public static final TagKey<Block> MOONSTONE_ORE = create("forge:ores/moonstone");
    public static final TagKey<Block> PYROPE_ORE = create("forge:ores/pyrope");

    public static TagKey<Block> create(String name) {
        return BlockTags.create(new ResourceLocation(name));
    }

    public BlueBlockTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(AQUITE_ORE).add(SkiesBlocks.everbright_aquite_ore, SkiesBlocks.everdawn_aquite_ore);
        tag(CHAROITE_ORE).add(SkiesBlocks.everbright_charoite_ore, SkiesBlocks.everdawn_charoite_ore);
        tag(DIOPSIDE_ORE).add(SkiesBlocks.everbright_diopside_ore, SkiesBlocks.everdawn_diopside_ore);
        tag(HORIZONITE_ORE).add(SkiesBlocks.horizonite_ore);
        tag(FALSITE_ORE).add(SkiesBlocks.falsite_ore);
        tag(VENTIUM_ORE).add(SkiesBlocks.ventium_ore);
        tag(MOONSTONE_ORE).add(SkiesBlocks.everbright_moonstone_ore, SkiesBlocks.everdawn_moonstone_ore);
        tag(PYROPE_ORE).add(SkiesBlocks.everbright_pyrope_ore, SkiesBlocks.everdawn_pyrope_ore);

        tag(AQUITE_BLOCK).add(SkiesBlocks.aquite_block);
        tag(CHAROITE_BLOCK).add(SkiesBlocks.charoite_block);
        tag(DIOPSIDE_BLOCK).add(SkiesBlocks.diopside_block);
        tag(HORIZONITE_BLOCK).add(SkiesBlocks.horizonite_block);
        tag(FALSITE_BLOCK).add(SkiesBlocks.falsite_ore);
        tag(VENTIUM_BLOCK).add(SkiesBlocks.ventium_block);
        tag(MOONSTONE_BLOCK).add(SkiesBlocks.moonstone);
        tag(PYROPE_BLOCK).add(SkiesBlocks.pyrope_block);
    }
}
