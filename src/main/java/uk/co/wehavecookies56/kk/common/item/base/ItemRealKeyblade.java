package uk.co.wehavecookies56.kk.common.item.base;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRealKeyblade extends ItemKeyblade {

	public ItemRealKeyblade (ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
	}
}
