package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "DropDead Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ModBlocks.PYRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PYRITE.get())
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE))
                .group("pyrite")
                .save(output);
        shapeless(RecipeCategory.MISC, ModItems.PYRITE.get(), 9)
                .requires(ModBlocks.PYRITE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.PYRITE_BLOCK.get()), has(ModBlocks.PYRITE_BLOCK))
                .group("pyrite")
                .save(output);

        List<ItemLike> PYRITE_SMELTABLES = List.of(ModBlocks.PYRITE_ORE, ModBlocks.DEEPSLATE_PYRITE_ORE);

        oreSmelting(PYRITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PYRITE.get(),.25f,200,"pyrite");
        oreBlasting(PYRITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PYRITE.get(),.25f,100,"pyrite");
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, DropDead.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
