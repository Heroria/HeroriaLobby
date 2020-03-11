package net.haiwa.lobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

	public InventoryUtils() {
		
	}
	
	public Inventory navigation(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 9 * 6, "§9Navigation > " + p.getName());
		inv.setItem(10, ItemUtils.smashmStick());
		
		return inv;
	}

	public Inventory settings(Player p) {

		Inventory inv = Bukkit.createInventory(null, 9 * 6, "§9Options > " + p.getName());
		inv.setItem(10, ItemUtils.smashmStick());
		
		return inv;
	}

	public Inventory profil(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 9 * 6, "§9Profile > " + p.getName());
		inv.setItem(53, ItemUtils.profileHead(p));
		
		return null;
	}

	public Inventory particules(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 9 * 3, "§9Paritcules > " + p.getName());
		inv.setItem(0, ItemUtils.particulesFeather());
		
		return null;
	}
	
}
