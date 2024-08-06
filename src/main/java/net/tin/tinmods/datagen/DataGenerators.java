package net.tin.tinmods.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tin.tinmods.TinMods;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TinMods.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        dataGenerator.addProvider(event.includeServer(), new RecipeGen(packOutput));
        dataGenerator.addProvider(event.includeServer(), LootTableGen.create(packOutput));

        dataGenerator.addProvider(event.includeClient(), new BlockStateGen(packOutput, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new ItemModelGen(packOutput, existingFileHelper));

        BlockTagGen blockTagGenerator = dataGenerator.addProvider(event.includeServer(),
                new BlockTagGen(packOutput, lookupProvider, existingFileHelper));
        dataGenerator.addProvider(event.includeServer(), new ItemTagGen(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

    }
}
