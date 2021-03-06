package uk.co.wehavecookies56.kk.common.synthesis;

import static uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry.registerFreeDevRecipe;

import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeDefenseBoost;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeDriveRecovery;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeElixir;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeEther;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeHiPotion;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeHighDriveRecovery;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMagicBoost;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMegaEther;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMegaPotion;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMegalixir;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMythrilCrystal;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMythrilGem;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMythrilShard;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipeMythrilStone;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipePanacea;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipePotion;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.RecipePowerBoost;

/**
 * Created by Toby on 16/07/2016.
 */
public class ModSynthesisFreeDevRecipes {

    public static void init() {
        registerFreeDevRecipe(new RecipeDriveRecovery(ModItems.DriveRecovery.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeHighDriveRecovery(ModItems.HighDriveRecovery.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeMythrilShard(Strings.SM_MythrilShard));
        registerFreeDevRecipe(new RecipeMythrilStone(Strings.SM_MythrilStone));
        registerFreeDevRecipe(new RecipeMythrilGem(Strings.SM_MythrilGem));
        registerFreeDevRecipe(new RecipeMythrilCrystal(Strings.SM_MythrilCrystal));
        registerFreeDevRecipe(new RecipePotion(ModItems.Potion.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeHiPotion(ModItems.HiPotion.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeMegaPotion(ModItems.MegaPotion.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeEther(ModItems.Ether.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeMegaEther(ModItems.MegaEther.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeElixir(ModItems.Elixir.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeMegalixir(ModItems.Megalixir.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeDefenseBoost(ModItems.DefenseBoost.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipePowerBoost(ModItems.PowerBoost.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipeMagicBoost(ModItems.MagicBoost.getUnlocalizedName()));
        registerFreeDevRecipe(new RecipePanacea(ModItems.Panacaea.getUnlocalizedName()));
    }

}
