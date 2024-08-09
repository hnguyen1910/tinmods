package net.tin.tinmods.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.client.event.RegisterNamedRenderTypesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tin.tinmods.TinMods;
import net.tin.tinmods.item.ModItems;
import net.tin.tinmods.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = TinMods.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void CustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.KING.get()) {

            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            List<VillagerTrades.ItemListing> Lvl1 = trades.get(1);
            List<VillagerTrades.ItemListing> Lvl2 = trades.get(2);
            List<VillagerTrades.ItemListing> Lvl3 = trades.get(3);
            List<VillagerTrades.ItemListing> Lvl4 = trades.get(4);
            List<VillagerTrades.ItemListing> Lvl5 = trades.get(5);

            // Level 1
            Lvl1.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,1),
                    new ItemStack(Items.IRON_INGOT,2),
                    10,8,0.02f
            ));
            Lvl1.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.RAW_IRON,2),
                    new ItemStack(Items.EMERALD,1),
                    10,8,0.02f
            ));

            // Level 2
            Lvl2.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(Items.GOLD_INGOT,2),
                    5,8,0.05f
            ));
            Lvl2.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.RAW_GOLD,2),
                    new ItemStack(Items.EMERALD,2),
                    5,8,0.05f
            ));

            // Level 3
            Lvl3.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.COAL_DIAMOND.get(),1),
                    6,8,0.1f
            ));
            Lvl3.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND,1),
                    new ItemStack(Items.EMERALD,2),
                    9,8,0.1f
            ));

            // Level 4
            Lvl4.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,10),
                    new ItemStack(Items.TOTEM_OF_UNDYING,1),
                    3,8,0.3f
            ));
            Lvl4.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,15),
                    new ItemStack(Items.NETHERITE_INGOT,1),
                    7,8,0.3f
            ));

            // Level 5
            Lvl5.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,10),
                    new ItemStack(ModItems.POOP.get(),1),
                    100,8,0.01f
            ));
        }

    }
}
