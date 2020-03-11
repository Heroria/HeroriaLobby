package net.haiwa.lobby.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemUtils {
	
	public ItemUtils() {
		
	}

	public ItemStack navigationCompass(Player p) {
		
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta compassM = compass.getItemMeta();
		
		compassM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		compassM.setDisplayName("§bNavigation > " + p.getName());
		compass.setItemMeta(compassM);
		
		return compass;
	}

	public ItemStack hiddenPowderDesactivate(Player p) {
		
		ItemStack powder = new ItemStack(Material.SULPHUR);
		ItemMeta powderM = powder.getItemMeta();
		
		powderM.setDisplayName("§cPoudre d'invisibilité > " + p.getName());
		powder.setItemMeta(powderM);
		
		return powder;
	}
	
	public ItemStack hiddenPowderActivate(Player p) {
		
		ItemStack powder = new ItemStack(Material.SULPHUR);
		ItemMeta powderM = powder.getItemMeta();
		
		powderM.addEnchant(Enchantment.DURABILITY, 1, true);
		powderM.setDisplayName("§aPoudre d'invisibilité > " + p.getName());
		powder.setItemMeta(powderM);
		
		return powder;
	}

	public ItemStack settingsLever(Player p) {
		
		ItemStack lever = new ItemStack(Material.LEVER);
		ItemMeta leverM = lever.getItemMeta();
		
		leverM.setDisplayName("§bOptions > " + p.getName());
		lever.setItemMeta(leverM);
		
		return lever;
	}

	public ItemStack lapisLazuliProfil(Player p) {
		
		ItemStack lapislazuli = new ItemStack(Material.INK_SACK, 1, (short) 4);
		ItemMeta lapislazuliM = lapislazuli.getItemMeta();
		
		lapislazuliM.setDisplayName("§7Profil > " + p.getName());
		lapislazuli.setItemMeta(lapislazuliM);
		
		return lapislazuli;
	}
	
	public ItemStack shopEnderChest(Player p) {
		
		ItemStack enderchest = new ItemStack(Material.ENDER_CHEST);
		ItemMeta enderchestM = enderchest.getItemMeta();
		
		enderchestM.setDisplayName("§dBoutique >" + p.getName());
		enderchest.setItemMeta(enderchestM);
		
		return enderchest;
	}

	public static ItemStack smashmStick() {
		
		ItemStack stick = new ItemStack(Material.STICK);
		ItemMeta stickM = stick.getItemMeta();
		
		stickM.addEnchant(Enchantment.KNOCKBACK, 1, true);
		stickM.setDisplayName("§bSmash");
		stick.setItemMeta(stickM);
		
		return stick;
	}

	public static ItemStack profileHead(Player p) {
		
		ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta headM = (SkullMeta) head.getItemMeta();
		
		headM.setOwner(p.getName());
		headM.setDisplayName("§9Profile: " + p.getName());
		head.setItemMeta(headM);
		
		return head;
	}
	
	public static ItemStack particulesFeather() {
		
		ItemStack feather = new ItemStack(Material.FEATHER);
		ItemMeta featherM = feather.getItemMeta();
		
		featherM.setDisplayName("§5Kinto");
		feather.setItemMeta(featherM);
		
		return feather;
	}
	
}
