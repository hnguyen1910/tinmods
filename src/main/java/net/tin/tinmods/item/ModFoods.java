package net.tin.tinmods.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties POOP = new FoodProperties.Builder().nutrition(10).saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.HUNGER),1f).build();
}
