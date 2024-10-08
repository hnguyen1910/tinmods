package net.hntin.tinmods.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.hntin.tinmods.TinMods;
import net.hntin.tinmods.item.ModItems;
import net.hntin.tinmods.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = TinMods.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void CustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.KING.get()) {

            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            List<VillagerTrades.ItemListing> Lvl1 = trades.get(1);
            List<VillagerTrades.ItemListing> Lvl2 = trades.get(2);
            List<VillagerTrades.ItemListing> Lvl3 = trades.get(3);
            List<VillagerTrades.ItemListing> Lvl4 = trades.get(4);
            List<VillagerTrades.ItemListing> Lvl5 = trades.get(5);

            // Level 1
            Lvl1.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(Items.IRON_INGOT, 2),
                    10, 8, 0.02f
            ));
            Lvl1.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.RAW_IRON, 2),
                    new ItemStack(Items.EMERALD, 1),
                    10, 8, 0.02f
            ));

            // Level 2
            Lvl2.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(Items.GOLD_INGOT, 2),
                    5, 8, 0.03f
            ));
            Lvl2.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.RAW_GOLD, 2),
                    new ItemStack(Items.EMERALD, 2),
                    5, 8, 0.03f
            ));

            // Level 3
            Lvl3.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.COAL_DIAMOND.get(), 1),
                    6, 8, 0.05f
            ));
            Lvl3.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(Items.EMERALD, 2),
                    9, 8, 0.05f
            ));

            // Level 4
            Lvl4.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(Items.TOTEM_OF_UNDYING, 1),
                    3, 8, 0.07f
            ));
            Lvl4.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(Items.NETHERITE_INGOT, 1),
                    7, 8, 0.7f
            ));

            // Level 5
            Lvl5.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.POOP.get(), 1),
                    100, 8, 0.1f
            ));

            Lvl5.add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.ANCIENT_DEBRIS, 2),
                    new ItemStack(Items.EMERALD, 10),
                    10, 100, 0.1f
            ));
        }

    }
}
