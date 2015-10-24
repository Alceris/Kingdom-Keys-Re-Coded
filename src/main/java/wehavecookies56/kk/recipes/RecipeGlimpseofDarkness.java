package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeGlimpseofDarkness extends Recipe {

	public String name;

	public RecipeGlimpseofDarkness(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_GlimpseofDarkness;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_DarkGem + ".x.3");
		reqs.add(Strings.SM_DenseCrystal + ".x.3");
		reqs.add(Strings.SM_PowerCrystal + ".x.2");
		reqs.add(Strings.SM_DarkStone + ".x.3");
		return reqs;
	}

}
