package mrthomas20121.blue_skies_tcon;

import mrthomas20121.blue_skies_tcon.init.BlueItems;
import mrthomas20121.blue_skies_tcon.init.Fluids;
import mrthomas20121.blue_skies_tcon.datagen.*;
import mrthomas20121.blue_skies_tcon.init.Modifiers;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

@Mod(BlueSkiesTcon.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlueSkiesTcon {

public static final String MOD_ID = "blue_skies_tcon";
	public static final Logger LOGGER = LogManager.getLogger();

	public BlueSkiesTcon() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Modifiers.MODIFIERS.register(bus);
		Fluids.register(bus);
		BlueItems.ITEMS.register(bus);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeServer()) {
			BlockTagsProvider blockTagsProvider = new BlueBlockTags(gen, fileHelper);
			gen.addProvider(blockTagsProvider);
			gen.addProvider(new BlueItemTags(gen, blockTagsProvider, fileHelper));
			//BlueMaterials materials = new BlueMaterials(gen);
			//gen.addProvider(materials);
			//gen.addProvider(new BlueMaterials.BlueSkiesMaterialStats(gen, materials));
			//gen.addProvider(new BlueMaterials.BlueSkiesTraits(gen, materials));
			gen.addProvider(new BlueFluidTags(gen, fileHelper));
			gen.addProvider(new BlueRecipes(gen));
		}
		if(event.includeClient()) {
			gen.addProvider(new BlueLang(gen));
			gen.addProvider(new BlueBlockStates(gen, fileHelper));
			gen.addProvider(new BlueItemModels(gen, fileHelper));
			//AbstractMaterialSpriteProvider provider = new BlueMaterialSpriteProvider();
			//gen.addProvider(new BlueRenderInfo(gen, provider));
			//gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new TinkerPartSpriteProvider(), provider));
		}
	}
}
