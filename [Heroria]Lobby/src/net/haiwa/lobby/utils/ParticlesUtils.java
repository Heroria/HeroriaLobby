package net.haiwa.lobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class ParticlesUtils {

	public ParticlesUtils() {
		
	}
	
	public void sendKintoParticles(Location loc, EnumParticle particle, float radius) {
	
		for(int i = 0; i < 100; i++) {
			float x = (float) (radius * Math.cos(i + 50));
			float z = (float) (radius * Math.sin(i));
			
			PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, true, (float) loc.getX() + x, (float) loc.getY(), (float) loc.getZ() + z, 0, 1, 0, 1, 0, 1);
			
			for(Player players : Bukkit.getOnlinePlayers()) {
				((CraftPlayer) players).getHandle().playerConnection.sendPacket(packet);
			}
			radius = (float) (radius - 0.02);
		}
		
	}
}
