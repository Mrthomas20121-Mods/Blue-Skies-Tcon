package mrthomas20121.blue_skies_tcon;

import mrthomas20121.blue_skies_tcon.data.*;
import mrthomas20121.blue_skies_tcon.init.BlueFluids;
import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.BlueModifiers;
import mrthomas20121.blue_skies_tcon.init.BlueVariables;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.json.variable.entity.EntityVariable;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.util.concurrent.CompletableFuture;

@Mod(BlueSkiesTcon.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlueSkiesTcon {

    public static final String MOD_ID = "blue_skies_tcon";
    public static final Logger LOGGER = LogManager.getLogger();

    public BlueSkiesTcon() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlueFluids.FLUIDS.register(bus);
        BlueItems.ITEMS.register(bus);
        BlueModifiers.MODIFIERS.register(bus);
        BlueModifiers.MOB_EFFECTS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        boolean server = event.includeServer();
        BlockTagsProvider blockTagsProvider = new BlueBlockTags(packOutput, lookupProvider, fileHelper);
        gen.addProvider(server, blockTagsProvider);
        gen.addProvider(server, new BlueItemTags(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));

        BlueMaterials materials = new BlueMaterials(packOutput);
        gen.addProvider(server, materials);
        gen.addProvider(server, new BlueMaterials.BlueSkiesMaterialStats(packOutput, materials));
        gen.addProvider(server, new BlueMaterials.BlueSkiesTraits(packOutput, materials));

        gen.addProvider(server, new BlueFluidTags(packOutput, lookupProvider, fileHelper));
        gen.addProvider(server, new BlueRecipeProvider(packOutput));

        gen.addProvider(server, new BlueModifierProvider(packOutput));

        boolean client = event.includeClient();
        gen.addProvider(client, new BlueLanguageProvider(packOutput));
        // TODO: why is this even needed
//		gen.addProvider(client, new BlueBlockStates(packOutput, fileHelper));
        gen.addProvider(client, new BlueItemModels(packOutput, fileHelper));
        gen.addProvider(client, new BlueFluidTextureProvider(packOutput));
        AbstractMaterialSpriteProvider provider = new BlueMaterialSpriteProvider();
        gen.addProvider(client, new BlueRenderInfo(packOutput, provider, fileHelper));
        gen.addProvider(client, new MaterialPartTextureGenerator(packOutput, fileHelper, new TinkerPartSpriteProvider(), provider));
    }

//    @SubscribeEvent
//    public static void register(RegisterEvent event) {
//        if (event.getRegistryKey() != Registries.RECIPE_SERIALIZER) return;
//        EntityVariable.LOADER.register(resource("speedster"), BlueVariables.ENTITY_SPEED.getLoader());
//    }

    public static ResourceLocation resource(String s) {
        return ResourceLocation.fromNamespaceAndPath(BlueSkiesTcon.MOD_ID, s);
    }
}
