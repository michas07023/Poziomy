package michał.gryboś.michalowicepoziomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class komendy implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Klasy");

            //Menu Options(Items)
            //gornictwo
            ItemStack suicide = new ItemStack(Material.DIAMOND_PICKAXE); //Kills the player
            //rolnictwo
            ItemStack feed =  new ItemStack(Material.DIAMOND_HOE); //Fills the hunger bar
            //walka
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD); //Gives the player a weapon
            //zaklinanie
            ItemStack zaklecia = new ItemStack(Material.ENCHANTING_TABLE);

            //Edit the items
            ItemMeta suicide_meta = suicide.getItemMeta();
            suicide_meta.setDisplayName(ChatColor.AQUA + "Gornictwo");
            List suicide_lore = new ArrayList<>();
            suicide_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
            suicide_meta.setLore(suicide_lore);
            suicide.setItemMeta(suicide_meta);

            ItemMeta feed_meta = feed.getItemMeta();
            feed_meta.setDisplayName(ChatColor.DARK_GREEN + "Rolnictwo");
            List feed_lore = new ArrayList<>();
            feed_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
            feed_meta.setLore(feed_lore);
            feed.setItemMeta(feed_meta);

            ItemMeta sword_meta = sword.getItemMeta();
            sword_meta.setDisplayName(ChatColor.DARK_RED + "Walka");
            List sword_lore = new ArrayList<>();
            sword_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
            sword_meta.setLore(sword_lore);
            sword.setItemMeta(sword_meta);

            ItemMeta zaklecia_meta = zaklecia.getItemMeta();
            zaklecia_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Zaklinanie");
            List zaklecia_lore = new ArrayList<>();
            zaklecia_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
            zaklecia_meta.setLore(zaklecia_lore);
            zaklecia.setItemMeta(zaklecia_meta);
            //Put the items in the inventory
            ItemStack[] menu_items = {suicide, feed, sword, zaklecia};
            gui.setContents(menu_items);
            player.openInventory(gui);


        }

        return true;

        }
    }

