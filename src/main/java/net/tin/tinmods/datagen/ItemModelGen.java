package net.tin.tinmods.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tin.tinmods.TinMods;
import net.tin.tinmods.item.ModItems;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TinMods.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COAL_DIAMOND);
        simpleItem(ModItems.PURIFIED_COAL_NUGGET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> itemRegistryObject){
        return withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TinMods.MOD_ID,"item/" + itemRegistryObject.getId().getPath()));
    }
}