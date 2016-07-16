package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryPotionsMenu;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.GiveItemInSlot;
import uk.co.wehavecookies56.kk.common.network.packet.server.PotionConsume;
import uk.co.wehavecookies56.kk.common.network.packet.server.RemoveItemInSlot;

public abstract class ItemKKPotion extends ItemFood {

	String potionType, unlocalizedName;

	public ItemKKPotion (int food, boolean wolf, String type, String unlocalizedName) {
		super(food, wolf);
		setUnlocalizedName(unlocalizedName);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public EnumAction getItemUseAction (ItemStack item) {
		return EnumAction.DRINK;
	}

	public String getItemName () {
		return unlocalizedName;
	}

	public void setItemName (String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

	public static void getItem (EntityPlayer player, World world, String item, int slot) {
		while (player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().getStackInSlot(slot) == null) {
			slot++;
		}
		switch (item) {
			case Strings.Potion:
				((ItemKKPotion) ModItems.Potion).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.Potion));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.HiPotion:
				((ItemKKPotion) ModItems.HiPotion).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.HiPotion));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.MegaPotion:
				((ItemKKPotion) ModItems.MegaPotion).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.MegaPotion));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.Ether:
				((ItemKKPotion) ModItems.Ether).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.Ether));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.MegaEther:
				((ItemKKPotion) ModItems.MegaEther).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.MegaEther));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.Elixir:
				((ItemKKPotion) ModItems.Elixir).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.Elixir));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.Megalixir:
				((ItemKKPotion) ModItems.Megalixir).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.Megalixir));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.DriveRecovery:
				((ItemKKPotion) ModItems.DriveRecovery).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.DriveRecovery));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.HighDriveRecovery:
				((ItemKKPotion) ModItems.HighDriveRecovery).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.HighDriveRecovery));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			case Strings.Panacea:
				((ItemKKPotion) ModItems.Panacaea).getPotionEffect(player);
				player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
				player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new PotionConsume(Strings.Panacea));
				PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.Potion, slot, true));
				break;
			default:
				break;
		}
	}

	@Override
	public void onFoodEaten (ItemStack item, World world, EntityPlayer player) {
		potionEffect(player);

		/*
		 * if (potionType == "hp") player.heal(player.getMaxHealth() / 3); else
		 * if (potionType == "mp")
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) / 3); else if (potionType == "elixir") {
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) / 3); player.heal(player.getMaxHealth() / 3); }
		 * 
		 * if (potionType == "hp2") player.heal(player.getMaxHealth() * 2 / 3);
		 * else if (potionType == "mp2")
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) * 2 / 3); else if (potionType == "elixir2") {
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) * 2 / 3); player.heal(player.getMaxHealth() * 2 / 3); } else if
		 * (potionType == "hp3") player.heal(player.getMaxHealth()); else if
		 * (potionType == "mp3")
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * )); else if (potionType == "elixir3") {
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * )); player.heal(player.getMaxHealth()); }
		 */
		if (!player.capabilities.isCreativeMode) PacketDispatcher.sendToServer(new GiveItemInSlot(new ItemStack(ModItems.EmptyBottle), player.inventory.getFirstEmptyStack(),false));
	}

	/**
	 * Set what the potion does when used e.g. Healing, MP restore, etc.
	 *
	 * @return
	 */
	public abstract void potionEffect (EntityPlayer player);

	public void getPotionEffect (EntityPlayer player) {
		potionEffect(player);
	}

	public void usePotion (EntityPlayer player, InventoryPotionsMenu inventory, int slot) {
		if (inventory.getStackInSlot(slot) != null) if (inventory.getStackInSlot(slot).getItem() instanceof ItemKKPotion) {
			inventory.setInventorySlotContents(slot, null);
			player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 1.0f, 1.0f);
			PacketDispatcher.sendToServer(new RemoveItemInSlot("potion", slot, true));
		}
	}
}