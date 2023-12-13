package fr.xalkinn.monplugin.connexion;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class connexion implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.getInventory().clear();
		
		//Donner des items a un joueur
		player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 2));
		
		//Ajout d'une epee special
		ItemStack customSword = new ItemStack(Material.IRON_SWORD, 2);
		ItemMeta customM = customSword.getItemMeta();
		customM.setDisplayName("§cMa super epee");
		customM.setLore(Arrays.asList("premiere ligne","deuxieme ligne","tr..."));
		
		//Ajout d'un enchantement
		customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
		customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		
		customSword.setItemMeta(customM);
				
		player.getInventory().setItemInOffHand(customSword);
		
		player.updateInventory();
	
	}
}
