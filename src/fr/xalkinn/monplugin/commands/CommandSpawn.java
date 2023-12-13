package fr.xalkinn.monplugin.commands;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//Teleportation
		if (sender instanceof Player) {
			
			Random positionRandom = new Random();
			Player player = (Player) sender;
			//Recuperation de coordonne du joueur
			Location playerLocation = player.getLocation();
			
			//Coordonne x y et z et pour finir, la direction (le facing)
			//Location spawn = new Location(player.getWorld(), -75.698, 70, 171.651, 88.3f, 19.6f);
			
			//TP du joueur au coordone random
			Location spawn = new Location(player.getWorld(), playerLocation.getX() + positionRandom.nextInt(10), playerLocation.getY()  + positionRandom.nextInt(10), playerLocation.getZ() + positionRandom.nextInt(10), 88.3f, 19.6f);
			player.sendMessage("La teleportation au spawn est un §csucces !");
			player.teleport(spawn);
		}
		
		return false;
	}

}
