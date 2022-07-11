package com.thomasglasser.minejago.generated;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import com.thomasglasser.minejago.MinejagoMod;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MinejagoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        boolean onServer = event.includeServer();
        boolean onClient = event.includeClient();

        ModBlockTags blockTags = new ModBlockTags(generator, existingFileHelper);

        if (onServer)
        {
            generator.addProvider(new ModItemTags(generator, blockTags, existingFileHelper));
            generator.addProvider(blockTags);
        }

        if (onClient)
        {
            generator.addProvider(new ModItemModels(generator, existingFileHelper));
            generator.addProvider(new ModEnUsLanguageProvider(generator));
        }
    }
}
