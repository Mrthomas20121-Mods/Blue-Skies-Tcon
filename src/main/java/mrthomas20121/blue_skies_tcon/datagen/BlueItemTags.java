package mrthomas20121.blue_skies_tcon.datagen;

import com.legacy.blue_skies.registries.SkiesBlocks;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.api.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlueItemTags extends ItemTagsProvider {

    TagKey<Item> nuggets = create("forge:nuggets");
    public static TagKey<Item> crystal_sand_casts = create("tconstruct:casts/crystal_sand");
    public static TagKey<Item> midnight_sand_casts = create("tconstruct:casts/midnight_sand");
    TagKey<Item> single_use = create("tconstruct:casts/single_use");

    public static TagKey<Item> create(String name) {
        return ItemTags.create(new ResourceLocation(name));
    }

    public BlueItemTags(DataGenerator gen, BlockTagsProvider tag, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, tag, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        addGemTags("aquite", SkiesBlocks.everbright_aquite_ore, SkiesBlocks.everdawn_aquite_ore, SkiesBlocks.aquite_block, SkiesItems.aquite,  BlueItems.aquite_nugget.get());
        addGemTags("charoite", SkiesBlocks.everbright_charoite_ore, SkiesBlocks.everdawn_charoite_ore, SkiesBlocks.charoite_block, SkiesItems.charoite, BlueItems.charoite_nugget.get());
        addGemTags("diopside", SkiesBlocks.everdawn_diopside_ore, SkiesBlocks.everbright_diopside_ore, SkiesBlocks.diopside_block, SkiesItems.diopside_gem, BlueItems.diopside_nugget.get());
        addTags("horizonite", SkiesBlocks.horizonite_ore, SkiesBlocks.horizonite_block, SkiesItems.horizonite_ingot, SkiesItems.horizonite_nugget);
        addTags("falsite", SkiesBlocks.falsite_ore, SkiesBlocks.falsite_block, SkiesItems.falsite_ingot, SkiesItems.falsite_nugget);
        addTags("ventium", SkiesBlocks.ventium_ore, SkiesBlocks.ventium_block, SkiesItems.ventium_ingot, SkiesItems.ventium_nugget);
        addGemTags("moonstone", SkiesBlocks.everbright_moonstone_ore, SkiesBlocks.everdawn_moonstone_ore, SkiesBlocks.moonstone_block, SkiesBlocks.moonstone.asItem(), BlueItems.moonstone_nugget.get());
        addGemTags("pyrope", SkiesBlocks.everdawn_pyrope_ore, SkiesBlocks.everbright_pyrope_ore, SkiesBlocks.pyrope_block, SkiesItems.pyrope_gem, BlueItems.pyrope_nugget.get());
        addCastTag(BlueItems.midnight_sand);
        addCastTag(BlueItems.crystal_sand);
    }

    protected void addCastTag(ItemCast cast) {
        TagsProvider.TagAppender<Item> crystalSandProvider = tag(crystal_sand_casts);
        TagsProvider.TagAppender<Item> midnightSandProvider = tag(midnight_sand_casts);
        TagsProvider.TagAppender<Item> singleUseProvider = tag(single_use);
        cast.getALL().forEach(itemCast -> {
            ResourceLocation registryName = itemCast.getId();
            Item item = itemCast.get();
            TagKey<Item> castTag = create("tconstruct:casts/single_use/"+registryName.getPath().replace("_crystal_sand_cast", "").replace("_midnight_sand_cast", ""));
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
        TagKey<Item> gemTag = create(String.format("forge:gems/%s", name));
        TagKey<Item> nuggetTag = create(String.format("forge:nuggets/%s", name));
        TagKey<Item> oreTag = create(String.format("forge:ores/%s", name));
        TagKey<Item> blockTag = create(String.format("forge:storage_blocks/%s", name));

        tag(gemTag).add(ingot);
        tag(nuggetTag).add(nugget);
        tag(oreTag).add(ore.asItem(), ore2.asItem());
        tag(blockTag).add(block.asItem());
        tag(nuggets).add(nugget);
    }

    protected void addTags(String name, Block ore, Block block, Item ingot, Item nugget) {
        TagKey<Item> ingotTag = create(String.format("forge:ingots/%s", name));
        TagKey<Item> nuggetTag = create(String.format("forge:nuggets/%s", name));
        TagKey<Item> oreTag = create(String.format("forge:ores/%s", name));
        TagKey<Item> blockTag = create(String.format("forge:storage_blocks/%s", name));

        tag(ingotTag).add(ingot);
        tag(nuggetTag).add(nugget);
        tag(oreTag).add(ore.asItem());
        tag(blockTag).add(block.asItem());
        tag(nuggets).add(nugget);
    }
}
