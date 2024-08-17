package net.hntin.tinmods.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.hntin.tinmods.TinMods;
import net.hntin.tinmods.block.ModBlocks;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinMods.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TIN_MODS_TAB = CREATIVE_MODE_TABS.register("tinmod_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PURIFIED_COAL_NUGGET.get()))
                    .title(Component.translatable("creativetab.tinmod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PURIFIED_COAL_NUGGET.get());
                        output.accept(ModItems.COAL_DIAMOND.get());
                        output.accept(Items.DIAMOND);
                        output.accept(ModBlocks.THRONE_BLOCK.get());
                        output.accept(ModItems.POOP.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
