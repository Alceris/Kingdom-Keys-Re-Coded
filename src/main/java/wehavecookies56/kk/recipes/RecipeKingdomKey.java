package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeKingdomKey extends Recipe {

	public String name;

	public RecipeKingdomKey(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.KingdomKey;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_BlazingShard);
		reqs.add(Strings.SM_BlazingCrystal);
		reqs.add(Strings.SM_BlazingStone);
		return reqs;
	}

}
