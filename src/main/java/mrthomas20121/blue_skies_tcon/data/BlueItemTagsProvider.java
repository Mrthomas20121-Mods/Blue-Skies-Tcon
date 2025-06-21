package mrthomas20121.blue_skies_tcon.data;

import com.legacy.blue_skies.registries.SkiesBlocks;
import com.legacy.blue_skies.registries.SkiesItems;
import mrthomas20121.blue_skies_tcon.BlueSkiesTcon;
import mrthomas20121.blue_skies_tcon.item.ItemCast;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlueItemTagsProvider extends ItemTagsProvider {

    public static final TagKey<Item> CRYSTAL_SAND_CASTS = ItemTags.create(BlueSkiesTcon.resource("casts/crystal_sand"));
    public static final TagKey<Item> MIDNIGHT_SAND_CASTS = ItemTags.create(BlueSkiesTcon.resource("casts/midnight_sand"));
    TagKey<Item> nuggets = create("forge:nuggets");
    TagKey<Item> single_use = create("tconstruct:casts/single_use");

    public static TagKey<Item> create(String name) {
        return ItemTags.create(ResourceLocation.parse(name));
    }

    public BlueItemTagsProvider(PackOutput gen, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, lookupProvider, blockTagProvider, BlueSkiesTcon.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Blue Skies TCon Item Tags Provider";
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addGemTags("aquite", SkiesBlocks.everbright_aquite_ore, SkiesBlocks.everdawn_aquite_ore, SkiesBlocks.aquite_block, SkiesItems.aquite);
        addGemTags("charoite", SkiesBlocks.everbright_charoite_ore, SkiesBlocks.everdawn_charoite_ore, SkiesBlocks.charoite_block, SkiesItems.charoite);
        addGemTags("diopside", SkiesBlocks.everdawn_diopside_ore, SkiesBlocks.everbright_diopside_ore, SkiesBlocks.diopside_block, SkiesItems.diopside_gem);
        addTags("horizonite", SkiesBlocks.horizonite_ore, SkiesBlocks.horizonite_block, SkiesItems.horizonite_ingot, SkiesItems.horizonite_nugget);
        addTags("falsite", SkiesBlocks.falsite_ore, SkiesBlocks.falsite_block, SkiesItems.falsite_ingot, SkiesItems.falsite_nugget);
        addTags("ventium", SkiesBlocks.ventium_ore, SkiesBlocks.ventium_block, SkiesItems.ventium_ingot, SkiesItems.ventium_nugget);
        addGemTags("moonstone", SkiesBlocks.everbright_moonstone_ore, SkiesBlocks.everdawn_moonstone_ore, SkiesBlocks.moonstone_block, SkiesBlocks.moonstone.asItem());
        addGemTags("pyrope", SkiesBlocks.everdawn_pyrope_ore, SkiesBlocks.everbright_pyrope_ore, SkiesBlocks.pyrope_block, SkiesItems.pyrope_gem);
        addCastTag(BlueItems.MIDNIGHT_SAND);
        addCastTag(BlueItems.CRYSTAL_SAND);
    }

    protected void addCastTag(ItemCast cast) {
        TagsProvider.TagAppender<Item> crystalSandAppender = tag(CRYSTAL_SAND_CASTS);
        TagsProvider.TagAppender<Item> midnightSandAppender = tag(MIDNIGHT_SAND_CASTS);
        TagsProvider.TagAppender<Item> singleUseAppender = tag(single_use);
        TagsProvider.TagAppender<Item> castsProvider = tag(TinkerTags.Items.CASTS);
        TagsProvider.TagAppender<Item> patternsProvider = tag(TinkerTags.Items.PATTERNS);
        for (RegistryObject<Item> itemCast : cast.getAll()) {
            ResourceLocation registryName = itemCast.getId();
            Item item = itemCast.get();
            TagKey<Item> castTag = create("tconstruct:casts/single_use/" + registryName.getPath().replace("_crystal_sand_cast", "").replace("_midnight_sand_cast", ""));
            tag(castTag).add(item);
            if (registryName.getPath().contains("midnight")) {
                midnightSandAppender.add(itemCast.getKey());
            } else {
                crystalSandAppender.add(itemCast.getKey());
            }
            singleUseAppender.add(itemCast.getKey());
            castsProvider.add(itemCast.getKey());
            patternsProvider.add(itemCast.getKey());
        }
    }

    protected void addGemTags(String name, Block ore, Block ore2, Block block, Item gem) {
        TagKey<Item> gemTag = create(String.format("forge:gems/%s", name));
        TagKey<Item> oreTag = create(String.format("forge:ores/%s", name));
        TagKey<Item> blockTag = create(String.format("forge:storage_blocks/%s", name));

        tag(gemTag).add(gem);
        tag(oreTag).add(ore.asItem(), ore2.asItem());
        tag(blockTag).add(block.asItem());
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
