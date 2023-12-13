package fr.xalkinn.monplugin;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MonPluginListeners implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.getInventory().clear();
		
		//Donner des items a un joueur
		//player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 2));
		
		//Ajout d'une epee special
		ItemStack customSword = new ItemStack(Material.IRON_SWORD, 1);
		ItemStack customAxe = new ItemStack(Material.DIAMOND_AXE, 1);
		ItemStack item = new ItemStack(Material.COMPASS);
		ItemStack boots = new ItemStack(Material.ARROW);
		
		ItemMeta customM = customSword.getItemMeta();
		ItemMeta customA = customAxe.getItemMeta();
		ItemMeta customB = item.getItemMeta();
		
		customM.setDisplayName("§cMa super epee");
		customM.setLore(Arrays.asList("premiere ligne","deuxieme ligne","tr..."));
		
		customB.setDisplayName("§cMa boussole spécial");
		
		//Ajout d'un enchantement
		customM.addEnchant(Enchantment.DAMAGE_ALL, 20000, true);
		//Enchantement de minage rapide (a connaitre)
		//customA.addEnchant(Enchantment., 0, false)	
		//Cacher les enchentement de l'obj
		customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		customSword.setItemMeta(customM);
		item.setItemMeta(customB);
				
		player.getInventory().addItem(item);
		player.getInventory().setItemInMainHand(customSword);
		player.getInventory().addItem(customAxe);
		
		//Ajout d'item sur l'emplacement casque
		ItemStack customItem = new ItemStack(Material.WOOL, 8, (byte)14);
		player.getInventory().setHelmet(customItem);
		//Ajout d'un compas
		player.getInventory().addItem(item);
		player.getInventory().setBoots(boots);
		player.updateInventory();
	}
	
	//Gestion des interactions
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		//Verification si le joueur à un item ou non
		if (it == null) return;
		
		//Creation d'interraction
		if (it.getType() == Material.DIAMOND_AXE) {
			if (action == Action.RIGHT_CLICK_AIR) {
				player.sendMessage("Vous venez de faire un clique dans le vide");
			}
		}
		
		//Verification de la boussole
		if (it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cMa boussole spécial")) {
			//Ajout d'un effet sur la boussole
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
		}
	}
	
}
