package net.haiwa.lobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

	public InventoryUtils() {
		
	}
	
	public Inventory navigation(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 9 * 6, "§7Navigation > " + p.getName());
		inv.setItem(10, ItemUtils.smashmStick());
		
		return inv;
	}
	
}
