package net.haiwa.lobby.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.haiwa.lobby.Main;
import net.haiwa.lobby.utils.InventoryUtils;
import net.haiwa.lobby.utils.ParticlesUtils;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class CmdPa implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("pa")) {
		
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				if(args.length == 0) {
				
					p.openInventory(new InventoryUtils().particules(p));
					
					return true;
				}else if(args.length == 1) {
					
					if(args[0].equalsIgnoreCase("kinto")) {
						
						ParticlesUtils pu = new ParticlesUtils();
						
						Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.INSTANCE, new Runnable() {
							
							@Override
							public void run() {
								pu.sendKintoParticles(p.getLocation(), EnumParticle.REDSTONE, (float) 1.5);
							}
						}, 3, 3);
						
					}
				}else {
					return true;
				}
			}else {
				return true;
			}
		}
		return false;
	}

}
