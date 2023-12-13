package fr.xalkinn.monplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		//Ceci est un test pour afficher un message via la commande test
		//sender.sendMessage("Bravo, le test est reussi");
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (cmd.getName().equalsIgnoreCase("test")) {
				player.sendMessage("§eBravo, tu as §9reussi");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("alert")) {
				/*//Commande pour diffusion d'un message serveur avec l'info de QUI le diffuse
				Bukkit.broadcastMessage("[" + player.getName() + "] " + "§eCeci est un message §9broadcast");
				return true;*/
				
				if (args.length == 0) {
					player.sendMessage("La commande est : /alert <ton message>");
					return true;
				}
				
				if (args.length >= 1) {
					StringBuilder bc = new StringBuilder();
					for (String part : args) {
						bc.append(part + " ");
					}
					Bukkit.broadcastMessage("[" + player.getName() + "] " + bc.toString());
				}
			}
			if (cmd.getName().equalsIgnoreCase("broadcast")) {
				
				Bukkit.broadcastMessage("[" + player.getName() + "] " + "§eCeci est un message §9broadcast");
				return true;

			}
		}
		
		return false;
	}

}
