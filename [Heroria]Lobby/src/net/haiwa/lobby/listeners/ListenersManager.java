package net.haiwa.lobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import net.haiwa.lobby.utils.InventoryUtils;
import net.haiwa.lobby.utils.ItemUtils;

public class ListenersManager implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		p.getInventory().clear();
		p.setFoodLevel(20);
		p.setHealth(20);
		e.setJoinMessage(null);
		
		p.getInventory().setItem(0, new ItemUtils().navigationCompass(p));
		p.getInventory().setItem(1, new ItemUtils().hiddenPowderDesactivate(p));
		p.getInventory().setItem(4, new ItemUtils().settingsLever(p));
		p.getInventory().setItem(7, new ItemUtils().lapisLazuliProfil(p));
		p.getInventory().setItem(8, new ItemUtils().shopEnderChest(p));
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		Action a = e.getAction();
		ItemStack it = e.getItem();
		
		if(it == null) return; 
		
		if(it.getType().equals(Material.COMPASS)) {
			if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigation > " + p.getName())) {
				if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
					p.openInventory(new InventoryUtils().navigation(p));
					return;
				}
			}
		}else if(it.getType().equals(Material.SULPHUR)) {
			if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cPoudre d'invisibilité > " + p.getName())) {
				if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
					for(Player players : Bukkit.getOnlinePlayers()) {
						p.hidePlayer(players);
					}
					p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
					p.sendMessage("§aTous les joueurs sont invisibles");
					p.getInventory().setItem(1, new ItemUtils().hiddenPowderActivate(p));
					return;
				}
			}else if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§aPoudre d'invisibilité > " + p.getName())) {
				if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
					for(Player players : Bukkit.getOnlinePlayers()) {
						p.showPlayer(players);
					}
					p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 1f, 1f);
					p.sendMessage("§cTous les joueurs sont visibles");
					p.getInventory().setItem(1, new ItemUtils().hiddenPowderDesactivate(p));
					return;
				}
			}
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		e.setBuild(false);
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onDamageByBlock(EntityDamageByBlockEvent e) {
		e.setCancelled(true);
	}
}
