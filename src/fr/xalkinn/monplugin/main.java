package fr.xalkinn.monplugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.xalkinn.monplugin.commands.CommandSpawn;
import fr.xalkinn.monplugin.commands.CommandTest;

public class main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Le plugin vient de s'allumer");
		getCommand("test").setExecutor(new CommandTest());
		getCommand("alert").setExecutor(new CommandTest());
		getCommand("broadcast").setExecutor(new CommandTest());
		getCommand("spawn").setExecutor(new CommandSpawn());
		
		getServer().getPluginManager().registerEvents(new MonPluginListeners(), this);
		//Test pour serveur local
		//getServer().getPluginManager().registerEvents(new connexion(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin vient de s'eteindre");
	}
}
