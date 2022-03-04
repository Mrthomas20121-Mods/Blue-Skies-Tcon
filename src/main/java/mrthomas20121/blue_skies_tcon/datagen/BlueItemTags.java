package mrthomas20121.blue_skies_tcon.datagen;

import com.legacy.blue_skies.registries.SkiesBlocks;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlueItemTags extends ItemTagsProvider {

    ITag.INamedTag<Item> nuggets = ItemTags.bind("forge:nuggets");
    public static ITag.INamedTag<Item> crystal_sand_casts = ItemTags.bind("tconstruct:casts/crystal_sand");
    public static ITag.INamedTag<Item> midnight_sand_casts = ItemTags.bind("tconstruct:casts/midnight_sand");
    ITag.INamedTag<Item> single_use = ItemTags.bind("tconstruct:casts/single_use");

    public BlueItemTags(DataGenerator gen, BlockTagsProvider tag, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, tag, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        addGemTags("aquite", SkiesBlocks.everbright_aquite_ore, SkiesBlocks.everdawn_aquite_ore, SkiesBlocks.aquite_block, SkiesItems.aquite_gem,  BlueItems.aquite_nugget.get());
        addGemTags("charoite", SkiesBlocks.everbright_charoite_ore, SkiesBlocks.everdawn_charoite_ore, SkiesBlocks.charoite_block, SkiesItems.charoite, BlueItems.charoite_nugget.get());
        addGemTags("diopside", SkiesBlocks.everdawn_diopside_ore, SkiesBlocks.everbright_diopside_ore, SkiesBlocks.diopside_block, SkiesItems.diopside_gem, BlueItems.diopside_nugget.get());
        addTags("horizonite", SkiesBlocks.horizonite_ore, SkiesBlocks.horizonite_block, SkiesItems.horizonite_ingot, BlueItems.horizonite_nugget.get());
        addTags("falsite", SkiesBlocks.falsite_ore, SkiesBlocks.falsite_block, SkiesItems.falsite_ingot, BlueItems.falsite_nugget.get());
        addTags("ventium", SkiesBlocks.ventium_ore, SkiesBlocks.ventium_block, SkiesItems.ventium_ingot, BlueItems.ventium_nugget.get());
        addGemTags("moonstone", SkiesBlocks.everbright_moonstone_ore, SkiesBlocks.everdawn_moonstone_ore, SkiesBlocks.moonstone_block, SkiesBlocks.moonstone.asItem(), BlueItems.moonstone_nugget.get());
        addGemTags("pyrope", SkiesBlocks.everdawn_pyrope_ore, SkiesBlocks.everbright_pyrope_ore, SkiesBlocks.pyrope_block, SkiesItems.pyrope_gem, BlueItems.pyrope_nugget.get());
        addCastTag(BlueItems.midnight_sand);
        addCastTag(BlueItems.crystal_sand);
    }

    protected void addCastTag(ItemCast cast) {
        TagsProvider.Builder<Item> crystalSandProvider = tag(crystal_sand_casts);
        TagsProvider.Builder<Item> midnightSandProvider = tag(midnight_sand_casts);
        TagsProvider.Builder<Item> singleUseProvider = tag(single_use);
        cast.getALL().forEach(itemCast -> {
            ResourceLocation registryName = itemCast.getId();
            Item item = itemCast.get();
            ITag.INamedTag<Item> castTag = ItemTags.bind("tconstruct:casts/single_use/"+registryName.getPath().replace("_crystal_sand_cast", "").replace("_midnight_sand_cast", ""));
            tag(castTag).add(item);
            if(registryName.getPath().contains("midnight")) {
                midnightSandProvider.add(item);
            }
            else {
                crystalSandProvider.add(item);
            }
            singleUseProvider.add(item);
        });
    }

    protected void addGemTags(String name, Block ore, Block ore2, Block block, Item ingot, Item nugget) {
        ITag.INamedTag<Item> gemTag = ItemTags.bind(String.format("forge:gems/%s", name));
        ITag.INamedTag<Item> nuggetTag = ItemTags.bind(String.format("forge:nuggets/%s", name));
        ITag.INamedTag<Item> oreTag = ItemTags.bind(String.format("forge:ores/%s", name));
        ITag.INamedTag<Item> blockTag = ItemTags.bind(String.format("forge:storage_blocks/%s", name));

        tag(gemTag).add(ingot);
        tag(nuggetTag).add(nugget);
        tag(oreTag).add(ore.asItem(), ore2.asItem());
        tag(blockTag).add(block.asItem());
        tag(nuggets).add(nugget);
    }

    protected void addTags(String name, Block ore, Block block, Item ingot, Item nugget) {
        ITag.INamedTag<Item> ingotTag = ItemTags.bind(String.format("forge:ingots/%s", name));
        ITag.INamedTag<Item> nuggetTag = ItemTags.bind(String.format("forge:nuggets/%s", name));
        ITag.INamedTag<Item> oreTag = ItemTags.bind(String.format("forge:ores/%s", name));
        ITag.INamedTag<Item> blockTag = ItemTags.bind(String.format("forge:storage_blocks/%s", name));

        tag(ingotTag).add(ingot);
        tag(nuggetTag).add(nugget);
        tag(oreTag).add(ore.asItem());
        tag(blockTag).add(block.asItem());
        tag(nuggets).add(nugget);
    }
}
