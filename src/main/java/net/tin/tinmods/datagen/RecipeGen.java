package net.tin.tinmods.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tin.tinmods.TinMods;
import net.tin.tinmods.block.ModBlocks;
import net.tin.tinmods.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class RecipeGen extends RecipeProvider implements IConditionBuilder {

    public RecipeGen(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, List.of(ModItems.PURIFIED_COAL_NUGGET.get()), RecipeCategory.MISC, Items.DIAMOND, 1f, 200, "easy_diamond");
        oreBlasting(pWriter, List.of(ModItems.PURIFIED_COAL_NUGGET.get()), RecipeCategory.MISC, Items.DIAMOND, 1f, 100, "easy_diamond");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COAL_DIAMOND.get(), 1)
                .pattern("QLQ")
                .pattern("RCG")
                .pattern("QIQ")
                .define('C', Items.COAL)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GOLD_INGOT)
                .define('Q', Items.QUARTZ)
                .define('L', Items.LAPIS_LAZULI)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,Items.DIAMOND_HORSE_ARMOR,1)
                .pattern("SSD")
                .pattern("DLD")
                .pattern("DDD")
                .define('D',Items.DIAMOND)
                .define('L',Items.LEATHER)
                .define('S',Items.STRING)
                .unlockedBy(getHasName(Items.LEATHER),has(Items.LEATHER))
                .save(pWriter);

        stonecutterResultFromBase(pWriter,RecipeCategory.MISC,ModItems.PURIFIED_COAL_NUGGET.get(),ModItems.COAL_DIAMOND.get(),1);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.THRONE_BLOCK.get(),1)
                .pattern("G G")
                .pattern("DSD")
                .pattern("E E")
                .define('G',Items.GOLD_INGOT)
                .define('D',Items.DIAMOND)
                .define('E',Items.EMERALD)
                .define('S', ItemTags.STAIRS)
                .unlockedBy(getHasName(ModBlocks.THRONE_BLOCK.get()),has(ModBlocks.THRONE_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TinMods.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
