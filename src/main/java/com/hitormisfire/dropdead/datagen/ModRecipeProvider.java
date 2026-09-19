package com.hitormisfire.dropdead.datagen;

import com.hitormisfire.dropdead.DropDead;
import com.hitormisfire.dropdead.block.ModBlocks;
import com.hitormisfire.dropdead.item.ModItems;
import com.hitormisfire.dropdead.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

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
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYRITE_BLOCK.get())
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


        shapeless(RecipeCategory.MISC, ModItems.WOOL_BALL.get())
                .requires(Items.STRING,2)
                .unlockedBy(getHasName(ModItems.WOOL_BALL.get()), has(ModItems.WOOL_BALL))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .group("wool_ball")
                .save(output);
        shapeless(RecipeCategory.MISC, Items.STRING,2)
                .requires(ModItems.WOOL_BALL.get())
                .unlockedBy(getHasName(ModItems.WOOL_BALL.get()), has(ModItems.WOOL_BALL))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .group("wool_ball")
                .save(output,"dropdead:string_from_wool_ball");
        shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.WOOL.white())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.WOOL_BALL.get())
                .unlockedBy(getHasName(ModItems.WOOL_BALL.get()), has(ModItems.WOOL_BALL))
                .group("wool_ball")
                .save(output,"minecraft:white_wool_from_string");



        shaped(RecipeCategory.TOOLS, ModItems.BOW_DRILL.get())
                .pattern("A#")
                .pattern("# ")
                .define('A', Items.STRING)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("bow_drill")
                .save(output);
        shaped(RecipeCategory.TOOLS, ModItems.SHARP_BOW_DRILL.get())
                .pattern("A#")
                .pattern("#B")
                .define('A', Items.STRING)
                .define('#', Items.STICK)
                .define('B', ModTags.Items.BOW_DRILL_BITS)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy("has_drill_bit", has(ModTags.Items.BOW_DRILL_BITS))
                .group("bow_drill")
                .save(output);


        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_SPLIT_LOG.get(), 4)
                .requires(ModTags.Items.OAK_SPLITTABLE)
                .unlockedBy(getHasName(Blocks.OAK_LOG), has(Blocks.OAK_LOG))
                .group("split_logs")
                .save(output);
        shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_LOG)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.OAK_SPLIT_LOG.get())
                .unlockedBy(getHasName(ModBlocks.OAK_SPLIT_LOG.get()), has(ModBlocks.OAK_SPLIT_LOG))
                .group("split_logs_to_block")
                .save(output, "dropdead:oak_log_from_split_log");
        shapeless(RecipeCategory.MISC, Items.STICK, 2)
                .requires(ModTags.Items.SPLIT_LOGS)
                .unlockedBy("has_split_logs", has(ModTags.Items.SPLIT_LOGS))
                .group("sticks")
                .save(output);
        shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE,2)
                .pattern("A#")
                .pattern("#A")
                .define('A', ModBlocks.LOOSE_COBBLESTONE.get())
                .define('#', Items.CLAY_BALL)
                .unlockedBy(getHasName(ModBlocks.LOOSE_COBBLESTONE.get()), has(ModBlocks.LOOSE_COBBLESTONE.get()))
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .group("clay_cobblestone")
                .save(output, "dropdead:cobblestone");



        shaped(RecipeCategory.MISC, ModItems.UNFIRED_BOWL.get())
                .pattern("AA")
                .define('A', Items.CLAY_BALL)
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .group("unfired_pottery")
                .save(output);







        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.OAK_PLANKS)
                .requires(Blocks.BEDROCK)
                .unlockedBy(getHasName(Blocks.BEDROCK), has(Blocks.BEDROCK))
                .group("temp")
                .save(output);

        List<ItemLike> PYRITE_SMELTABLES = List.of(ModBlocks.PYRITE_ORE, ModBlocks.DEEPSLATE_PYRITE_ORE);
        List<ItemLike> CLAY_SMELTABLES = List.of(ModItems.UNFIRED_BOWL);

        oreSmelting(PYRITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PYRITE.get(),.25f,200,"pyrite");
        oreBlasting(PYRITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PYRITE.get(),.25f,100,"pyrite");

        campfireSmelting(CLAY_SMELTABLES,RecipeCategory.MISC,CookingBookCategory.MISC,Items.BOWL,.03f,200,"clay");
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

    protected void campfireSmelting(List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group) {
        this.oreCooking(CampfireCookingRecipe::new, smeltables, craftingCategory, cookingCategory, result, experience, cookingTime, group, "_from_campfire_cooking");
    }

}
