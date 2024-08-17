package net.hntin.tinmods.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.hntin.tinmods.TinMods;
import net.hntin.tinmods.item.ModItems;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TinMods.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COAL_DIAMOND);
        simpleItem(ModItems.PURIFIED_COAL_NUGGET);
        simpleItem(ModItems.POOP);
    }

    private void simpleItem(RegistryObject<Item> itemRegistryObject){
        withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TinMods.MOD_ID, "item/" + itemRegistryObject.getId().getPath()));
    }
}
