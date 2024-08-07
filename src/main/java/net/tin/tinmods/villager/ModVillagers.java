package net.tin.tinmods.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tin.tinmods.TinMods;
import net.tin.tinmods.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TinMods.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,TinMods.MOD_ID);

    public static final RegistryObject<PoiType> THRONE_POI = POI_TYPES.register("throne_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.THRONE_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,1));

    public static final RegistryObject<VillagerProfession> KING =
            VILLAGER_PROFESSIONS.register("king",() ->
                    new VillagerProfession("king",
                            holder -> holder.get() == THRONE_POI.get(),
                            holder -> holder.get() == THRONE_POI.get(),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.AMETHYST_BLOCK_BREAK));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
