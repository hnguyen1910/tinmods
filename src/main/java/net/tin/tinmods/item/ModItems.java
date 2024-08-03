package net.tin.tinmods.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tin.tinmods.TinMods;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, TinMods.MOD_ID);

    public static final RegistryObject<Item> PURIFIED_COAL_NUGGET = ITEMS.register("purified_coal_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_DIAMOND = ITEMS.register("coal_diamond",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
