package michał.gryboś.michalowicepoziomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class MenuHandler implements Listener {


    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        String playerName = player.getName();
        File playerFile = new File(getPlugin(Michalowicepoziomy.class).getDataFolder() + File.separator + "PlayerDatabase", playerName + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
        try {
            playerData.save(playerFile);
        } catch (IOException e1) {
            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
            e1.printStackTrace();
        }
        //Gornictwo
        Inventory gornictwo = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Gornictwo");

        //Menu Options(Items)
        //1
        ItemStack gmozliwosci = new ItemStack(Material.DIAMOND_PICKAXE); //Kills the player
        //2
        ItemStack gpunkciki = new ItemStack(Material.IRON_PICKAXE); //Fills the hunger bar
        //3
        ItemStack gdrop = new ItemStack(Material.STONE_PICKAXE); //Gives the player a weapon
        //4
        ItemStack gxp = new ItemStack(Material.WOODEN_PICKAXE);
        //gpunkty
        ItemStack gpunkty = new ItemStack(Material.NETHERITE_PICKAXE);
        //Edit the items
        ItemMeta gmozliwosci_meta = gmozliwosci.getItemMeta();
        gmozliwosci_meta.setDisplayName(ChatColor.AQUA + "Gornictwo możliwości");
        ArrayList<String> gmozliwosci_lore = new ArrayList<>();
        gmozliwosci_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        gmozliwosci_meta.setLore(gmozliwosci_lore);
        gmozliwosci.setItemMeta(gmozliwosci_meta);

        ItemMeta gpunkciki_meta = gpunkciki.getItemMeta();
        gpunkciki_meta.setDisplayName(ChatColor.DARK_GREEN + "Gornictwo punkty+");
        ArrayList<String> gpunkciki_lore = new ArrayList<>();
        gpunkciki_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        gpunkciki_meta.setLore(gpunkciki_lore);
        gpunkciki.setItemMeta(gpunkciki_meta);

        ItemMeta gdrop_meta = gdrop.getItemMeta();
        gdrop_meta.setDisplayName(ChatColor.DARK_RED + "Gornictwo drop");
        ArrayList<String> gdrop_lore = new ArrayList<>();
        gdrop_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        gdrop_meta.setLore(gdrop_lore);
        gdrop.setItemMeta(gdrop_meta);

        ItemMeta gxp_meta = gxp.getItemMeta();
        gdrop_meta.setDisplayName(ChatColor.DARK_RED + "Gornictwo exp");
        ArrayList<String> gxp_lore = new ArrayList<>();
        gxp_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        gxp_meta.setLore(gdrop_lore);
        gxp.setItemMeta(gdrop_meta);

        ItemMeta gpunkty_meta = gpunkty.getItemMeta();
        gpunkty_meta.setDisplayName(ChatColor.BLACK + "Gorncitwo punkty");
        ArrayList<String> gpunkty_lore = new ArrayList<>();
        gpunkty_lore.add(ChatColor.GOLD + "Masz:" + playerData.getInt("gornictwo.punkty") + "punktów górnictwa");
        gpunkty_meta.setLore(gpunkty_lore);
        gpunkty.setItemMeta(gpunkty_meta);
        // gmozliwosci
        Inventory gornictwo11 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Gornictwo możliwości");
        //Menu Options(Items)
        //1

        ItemStack g111 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("gornictwo.11")) {
            g111 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack g121 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.11"))
            g121 = new ItemStack(Material.RED_STAINED_GLASS);
        if (playerData.getBoolean("gornictwo.12")) {
            g121 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack g131 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.12"))
            g131 = new ItemStack(Material.RED_CONCRETE);
        if (playerData.getBoolean("gornictwo.13")) {
            g131 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack g14 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.13")){
            g14 = new ItemStack(Material.RED_CONCRETE_POWDER);
    }if (playerData.getBoolean("gornictwo.14")) {
            g14 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta g11_meta1 = g111.getItemMeta();
        g11_meta1.setDisplayName(ChatColor.AQUA + "Górnictwo 1.1 ");
        ArrayList<String> g11_lore1 = new ArrayList<>();
        g11_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 500 punktów");
        g11_meta1.setLore(g11_lore1);
        g111.setItemMeta(g11_meta1);

        ItemMeta g12_meta1 = g121.getItemMeta();
        g12_meta1.setDisplayName(ChatColor.DARK_GREEN + "Gornictwo 1.2");
        ArrayList<String> g12_lore1 = new ArrayList<>();
        g12_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2000 punktów");
        g12_meta1.setLore(g12_lore1);
        g121.setItemMeta(g12_meta1);

        ItemMeta g13_meta1 = g131.getItemMeta();
        g13_meta1.setDisplayName(ChatColor.DARK_RED + "Gornictwo 1.3");
        ArrayList<String> g13_lore1 = new ArrayList<>();
        g13_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        g13_meta1.setLore(g13_lore1);
        g131.setItemMeta(g13_meta1);

        ItemMeta g14_meta1 = g14.getItemMeta();
        g14_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Gorncitwo 1.4");
        ArrayList<String> g14_lore1 = new ArrayList<>();
        g14_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punktów");
        g14_meta1.setLore(g14_lore1);
        g14.setItemMeta(g14_meta1);

        Inventory gornictwo13 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Gornictwo dropy");
        //Menu Options(Items)
        //1
        ItemStack g31 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("gornictwo.31")){
            g31 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack g32 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.31")) {
            g32 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("gornictwo.32")){
            g32 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack g33 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.32")) {
            g33 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("gornictwo.33")){
            g33 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack g34 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.33")) {
            g34 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }
        if (playerData.getBoolean("gornictwo.34")){
            g34 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta g31_meta1 = g31.getItemMeta();
        g31_meta1.setDisplayName(ChatColor.AQUA + "Górnictwo 3.1 ");
        ArrayList<String> g31_lore1 = new ArrayList<>();
        g31_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        g31_meta1.setLore(g31_lore1);
        g31.setItemMeta(g31_meta1);

        ItemMeta g32_meta1 = g32.getItemMeta();
        g32_meta1.setDisplayName(ChatColor.DARK_GREEN + "Gornictwo 3.2");
        ArrayList<String> g32_lore1 = new ArrayList<>();
        g32_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        g32_meta1.setLore(g32_lore1);
        g32.setItemMeta(g32_meta1);

        ItemMeta g33_meta1 = g33.getItemMeta();
        g33_meta1.setDisplayName(ChatColor.DARK_RED + "Gornictwo 3.3");
        ArrayList<String> g33_lore1 = new ArrayList<>();
        g33_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        g33_meta1.setLore(g33_lore1);
        g33.setItemMeta(g33_meta1);

        ItemMeta g34_meta1 = g34.getItemMeta();
        g34_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Gorncitwo 3.4");
        ArrayList<String> g34_lore1 = new ArrayList<>();
        g34_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        g34_meta1.setLore(g34_lore1);
        g34.setItemMeta(g34_meta1);

        Inventory gornictwo12 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Gornictwo punkty+");
        //Menu Options(Items)
        //1
        ItemStack g21 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("gornictwo.21")){
            g21 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack g22 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.21")) {
            g22 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("gornictwo.22")){
            g22 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack g23 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.22")) {
            g23 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("gornictwo.23")){
            g23 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack g24 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.23")) {
            g24 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("gornictwo.24")){
            g24 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta g21_meta1 = g21.getItemMeta();
        g21_meta1.setDisplayName(ChatColor.AQUA + "Gornictwo 2.1 ");
        ArrayList<String> g21_lore1 = new ArrayList<>();
        g21_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1100 punktów");
        g21_meta1.setLore(g21_lore1);
        g21.setItemMeta(g21_meta1);

        ItemMeta g22_meta1 = g22.getItemMeta();
        g22_meta1.setDisplayName(ChatColor.DARK_GREEN + "Gornictwo 2.2");
        ArrayList<String> g22_lore1 = new ArrayList<>();
        g22_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3000 punktów");
        g22_meta1.setLore(g22_lore1);
        g22.setItemMeta(g22_meta1);

        ItemMeta g23_meta1 = g23.getItemMeta();
        g23_meta1.setDisplayName(ChatColor.DARK_RED + "Gornictwo 2.3");
        ArrayList<String> g23_lore1 = new ArrayList<>();
        g23_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punktów");
        g23_meta1.setLore(g23_lore1);
        g23.setItemMeta(g23_meta1);

        ItemMeta g24_meta1 = g24.getItemMeta();
        g24_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Gornictwo 2.4");
        ArrayList<String> g24_lore1 = new ArrayList<>();
        g24_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 5000 punnktów");
        g24_meta1.setLore(g24_lore1);
        g24.setItemMeta(g24_meta1);

        Inventory gornictwo14 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Gornictwo exp");
        //Menu Options(Items)
        //1
        ItemStack g41 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("gornictwo.41")){
            g41 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack g42 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.41")) {
            g42 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("gornictwo.42")){
            g42 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack g43 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.42")) {
            g43 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("gornictwo.43")){
            g43 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack g44 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("gornictwo.43")) {
            g44 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("gornictwo.44")){
            g44 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta g41_meta1 = g41.getItemMeta();
        g41_meta1.setDisplayName(ChatColor.AQUA + "Gornictwo 4.1 ");
        ArrayList<String> g41_lore1 = new ArrayList<>();
        g41_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        g41_meta1.setLore(g41_lore1);
        g41.setItemMeta(g41_meta1);

        ItemMeta g42_meta1 = g42.getItemMeta();
        g42_meta1.setDisplayName(ChatColor.DARK_GREEN + "Gornictwo 4.2");
        ArrayList<String> g42_lore1 = new ArrayList<>();
        g42_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        g42_meta1.setLore(g42_lore1);
        g42.setItemMeta(g42_meta1);

        ItemMeta g43_meta1 = g43.getItemMeta();
        g43_meta1.setDisplayName(ChatColor.DARK_RED + "Gornictwo 4.3");
        ArrayList<String> g43_lore1 = new ArrayList<>();
        g43_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        g43_meta1.setLore(g43_lore1);
        g43.setItemMeta(g43_meta1);

        ItemMeta g44_meta1 = g44.getItemMeta();
        g44_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Gornictwo 4.4");
        ArrayList<String> g44_lore1 = new ArrayList<>();
        g44_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        g44_meta1.setLore(g44_lore1);
        g44.setItemMeta(g44_meta1);

        Inventory rolnictwo = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Rolnictwo");

        //Menu Options(Items)
        //1
        ItemStack rmoz = new ItemStack(Material.DIAMOND_HOE); //Kills the player
        //2
        ItemStack rpunkciki =  new ItemStack(Material.IRON_HOE); //Fills the hunger bar
        //3
        ItemStack rdrop = new ItemStack(Material.STONE_HOE); //Gives the player a weapon
        //4
        ItemStack rexp = new ItemStack(Material.WOODEN_HOE);
        //rpunkty
        ItemStack rpunkty = new ItemStack(Material.NETHERITE_HOE);
        //Edit the items
        ItemMeta rmoz_meta = rmoz.getItemMeta();
        rmoz_meta.setDisplayName(ChatColor.AQUA + "Rolnictwo możliwości");
        ArrayList<String> rmoz_lore = new ArrayList<>();
        rmoz_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        rmoz_meta.setLore(rmoz_lore);
        rmoz.setItemMeta(rmoz_meta);

        ItemMeta rpunkciki_meta = rpunkciki.getItemMeta();
        rpunkciki_meta.setDisplayName(ChatColor.DARK_GREEN + "Rolnictwo punkty+");
        ArrayList<String> rpunkciki_lore = new ArrayList<>();
        rpunkciki_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        rpunkciki_meta.setLore(rpunkciki_lore);
        rpunkciki.setItemMeta(rpunkciki_meta);

        ItemMeta rdrop_meta = rdrop.getItemMeta();
        rdrop_meta.setDisplayName(ChatColor.DARK_RED + "Rolnictwo drop");
        ArrayList<String> rdrop_lore = new ArrayList<>();
        rdrop_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        rdrop_meta.setLore(rdrop_lore);
        rdrop.setItemMeta(rdrop_meta);

        ItemMeta rexp_meta = rexp.getItemMeta();
        rexp_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Rolncitwo exp");
        ArrayList<String> rexp_lore = new ArrayList<>();
        rexp_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        rexp_meta.setLore(rexp_lore);
        rexp.setItemMeta(rexp_meta);

        ItemMeta rpunkty_meta = rpunkty.getItemMeta();
        rpunkty_meta.setDisplayName(ChatColor.BLACK + "Rolncitwo rpunkty");
        ArrayList<String> rpunkty_lore = new ArrayList<>();
        rpunkty_lore.add(ChatColor.GOLD + "Masz:" + playerData.getInt("rolnictwo.punkty") + "punktów rolnictwa");
        rpunkty_meta.setLore(rpunkty_lore);
        rpunkty.setItemMeta(rpunkty_meta);

        Inventory r1 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Rolnictwo mozliwosci");

        ItemStack r11 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("rolnictwo.11")){
            r11 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }
        ItemStack r12 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.11")) {
            r12 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("rolnictwo.12")){
            r12 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack r13 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.12")) {
            r13 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("rolnictwo.13")){
            r13 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack r14 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.13")) {
            r14 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("rolnictwo.14")){
            r14 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta r11_meta1 = r11.getItemMeta();
        r11_meta1.setDisplayName(ChatColor.AQUA + "Rolnictwo 1.1 ");
        ArrayList<String> r11_lore1 = new ArrayList<>();
        r11_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 500 punktów");
        r11_meta1.setLore(r11_lore1);
        r11.setItemMeta(r11_meta1);

        ItemMeta r12_meta1 = r12.getItemMeta();
        r12_meta1.setDisplayName(ChatColor.DARK_GREEN + "Rolnictwo 1.2");
        ArrayList<String> r12_lore1 = new ArrayList<>();
        r12_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2000 punktów");
        r12_meta1.setLore(r12_lore1);
        r12.setItemMeta(r12_meta1);

        ItemMeta r13_meta1 = r13.getItemMeta();
        r13_meta1.setDisplayName(ChatColor.DARK_RED + "Rolnictwo 1.3");
        ArrayList<String> r13_lore1 = new ArrayList<>();
        r13_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        r13_meta1.setLore(r13_lore1);
        r13.setItemMeta(r13_meta1);

        ItemMeta r14_meta1 = r14.getItemMeta();
        r14_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Rolncitwo 1.4");
        ArrayList<String> r14_lore1 = new ArrayList<>();
        r14_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punnktów");
        r14_meta1.setLore(r14_lore1);
        r14.setItemMeta(r14_meta1);

        Inventory r2 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Rolnictwo punkty+");
        ItemStack r21 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("rolnictwo.21")){
            r21 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack r22 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.21")) {
            r22 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("rolnictwo.22")){
            r22 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack r23 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.22")) {
            r23 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("rolnictwo.23")){
            r23 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack r24 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.23")) {
            r24 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("rolnictwo.24")){
            r24 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta r21_meta1 = r21.getItemMeta();
        r21_meta1.setDisplayName(ChatColor.AQUA + "Rolnictwo 2.1 ");
        ArrayList<String> r21_lore1 = new ArrayList<>();
        r21_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1100 punktów");
        r21_meta1.setLore(r21_lore1);
        r21.setItemMeta(r21_meta1);

        ItemMeta r22_meta1 = r22.getItemMeta();
        r22_meta1.setDisplayName(ChatColor.DARK_GREEN + "Rolnictwo 2.2");
        ArrayList<String> r22_lore1 = new ArrayList<>();
        r22_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3000 punktów");
        r22_meta1.setLore(r22_lore1);
        r22.setItemMeta(r22_meta1);

        ItemMeta r23_meta1 = r23.getItemMeta();
        r23_meta1.setDisplayName(ChatColor.DARK_RED + "Rolnictwo 2.3");
        ArrayList<String> r23_lore1 = new ArrayList<>();
        r23_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punktów");
        r23_meta1.setLore(r23_lore1);
        r23.setItemMeta(r23_meta1);

        ItemMeta r24_meta1 = r24.getItemMeta();
        r24_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Rolncitwo 2.4");
        ArrayList<String> r24_lore1 = new ArrayList<>();
        r24_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 5000 punnktów");
        r24_meta1.setLore(r24_lore1);
        r24.setItemMeta(r24_meta1);

        Inventory r3 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Rolnictwo dropy");
        //Menu Options(Items)
        //1
        ItemStack r31 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("rolnictwo.31")){
            r31 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack r32 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.31")) {
            r32 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("rolnictwo.32")){
            r32 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack r33 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.32")) {
            r33 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("rolnictwo.33")){
            r33 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack r34 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.33")) {
            r34 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("rolnictwo.34")){
            r34 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta r31_meta1 = r31.getItemMeta();
        r31_meta1.setDisplayName(ChatColor.AQUA + "Rolnictwo 3.1 ");
        ArrayList<String> r31_lore1 = new ArrayList<>();
        r31_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        r31_meta1.setLore(r31_lore1);
        r31.setItemMeta(r31_meta1);

        ItemMeta r32_meta1 = r32.getItemMeta();
        r32_meta1.setDisplayName(ChatColor.DARK_GREEN + "Rolnictwo 3.2");
        ArrayList<String> r32_lore1 = new ArrayList<>();
        r32_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        r32_meta1.setLore(r32_lore1);
        r32.setItemMeta(r32_meta1);

        ItemMeta r33_meta1 = r33.getItemMeta();
        r33_meta1.setDisplayName(ChatColor.DARK_RED + "Rolnictwo 3.3");
        ArrayList<String> r33_lore1 = new ArrayList<>();
        r33_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        r33_meta1.setLore(r33_lore1);
        r33.setItemMeta(r33_meta1);

        ItemMeta r34_meta1 = r34.getItemMeta();
        r34_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Rolncitwo 3.4");
        ArrayList<String> r34_lore1 = new ArrayList<>();
        r34_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        r34_meta1.setLore(r34_lore1);
        r34.setItemMeta(r34_meta1);

        Inventory r4 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Rolnictwo exp");
        //Menu Options(Items)
        //1
        ItemStack r41 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("rolnictwo.41")){
            r41 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack r42 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.41")) {
            r42 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("rolnictwo.42")){
            r42 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack r43 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.42")) {
            r43 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("rolnictwo.43")){
            r43 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack r44 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("rolnictwo.43")) {
            r44 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("rolnictwo.44")){
            r44 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta r41_meta1 = r41.getItemMeta();
        r41_meta1.setDisplayName(ChatColor.AQUA + "Rolnictwo 4.1 ");
        ArrayList<String> r41_lore1 = new ArrayList<>();
        r41_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        r41_meta1.setLore(r41_lore1);
        r41.setItemMeta(r41_meta1);

        ItemMeta r42_meta1 = r42.getItemMeta();
        r42_meta1.setDisplayName(ChatColor.DARK_GREEN + "Rolnictwo 4.2");
        ArrayList<String> r42_lore1 = new ArrayList<>();
        r42_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        r42_meta1.setLore(r42_lore1);
        r42.setItemMeta(r42_meta1);

        ItemMeta r43_meta1 = r43.getItemMeta();
        r43_meta1.setDisplayName(ChatColor.DARK_RED + "Rolnictwo 4.3");
        ArrayList<String> r43_lore1 = new ArrayList<>();
        r43_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        r43_meta1.setLore(r43_lore1);
        r43.setItemMeta(r43_meta1);

        ItemMeta r44_meta1 = r44.getItemMeta();
        r44_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Rolncitwo 4.4");
        ArrayList<String> r44_lore1 = new ArrayList<>();
        r44_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        r44_meta1.setLore(r44_lore1);
        r44.setItemMeta(r44_meta1);

        Inventory walka = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Walka");

        //Menu Options(Items)
        //1
        ItemStack wmmozliwosci = new ItemStack(Material.DIAMOND_SWORD); //Kills the player
        //2
        ItemStack wpunkty =  new ItemStack(Material.IRON_SWORD); //Fills the hunger bar
        //3
        ItemStack wdrop = new ItemStack(Material.STONE_SWORD); //Gives the player a weapon
        //4
        ItemStack wexp = new ItemStack(Material.WOODEN_SWORD);
        //punkty
        ItemStack wapunkty = new ItemStack(Material.NETHERITE_SWORD);
        //Edit the items
        ItemMeta wmmozliwosci_meta = wmmozliwosci.getItemMeta();
        wmmozliwosci_meta.setDisplayName(ChatColor.AQUA + "Walka możliwości");
        ArrayList<String> wmmozliwosci_lore = new ArrayList<>();
        wmmozliwosci_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        wmmozliwosci_meta.setLore(wmmozliwosci_lore);
        wmmozliwosci.setItemMeta(wmmozliwosci_meta);

        ItemMeta wpunkty_meta = wpunkty.getItemMeta();
        wpunkty_meta.setDisplayName(ChatColor.DARK_GREEN + "Walka punkty+");
        ArrayList<String> wpunkty_lore = new ArrayList<>();
        wpunkty_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        wpunkty_meta.setLore(wpunkty_lore);
        wpunkty.setItemMeta(wpunkty_meta);

        ItemMeta wdrop_meta = wdrop.getItemMeta();
        wdrop_meta.setDisplayName(ChatColor.DARK_RED + "Walka drop");
        ArrayList<String> wdrop_lore = new ArrayList<>();
        wdrop_lore.add(ChatColor.DARK_RED + "COMING SOON");
        wdrop_meta.setLore(wdrop_lore);
        wdrop.setItemMeta(wdrop_meta);

        ItemMeta wexp_meta = wexp.getItemMeta();
        wexp_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Walka exp");
        ArrayList<String> wexp_lore = new ArrayList<>();
        wexp_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        wexp_meta.setLore(wexp_lore);
        wexp.setItemMeta(wexp_meta);

        ItemMeta wapunkty_meta = wapunkty.getItemMeta();
        wapunkty_meta.setDisplayName(ChatColor.BLACK + "Walka punkty");
        ArrayList<String> wapunkty_lore = new ArrayList<>();
        wapunkty_lore.add(ChatColor.GOLD + "Masz:" + playerData.getInt("walka.punkty") + "punktów walki");
        wapunkty_meta.setLore(wapunkty_lore);
        wapunkty.setItemMeta(wapunkty_meta);

        Inventory walka1 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Walka możliwości");
        //Menu Options(Items)
        //1
        ItemStack w11 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("walka.11")){
            w11 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2

        ItemStack w12 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.11"))
            w12 = new ItemStack(Material.RED_STAINED_GLASS);
        if (playerData.getBoolean("walka.12")){
            w12 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack w13 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.12"))
            w13 = new ItemStack(Material.RED_CONCRETE);
        if (playerData.getBoolean("walka.13")){
            w13 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack w14 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.13"))
            w14 = new ItemStack(Material.RED_CONCRETE_POWDER);
        if (playerData.getBoolean("walka.14")){
            w14 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta w11_meta1 = w11.getItemMeta();
        w11_meta1.setDisplayName(ChatColor.AQUA + "Walka 1.1 ");
        ArrayList<String> w11_lore1 = new ArrayList<>();
        w11_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 500 punktów");
        w11_meta1.setLore(w11_lore1);
        w11.setItemMeta(w11_meta1);

        ItemMeta w12_meta1 = w12.getItemMeta();
        w12_meta1.setDisplayName(ChatColor.DARK_GREEN + "Walka 1.2");
        ArrayList<String> w12_lore1 = new ArrayList<>();
        w12_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2000 punktów");
        w12_meta1.setLore(w12_lore1);
        w12.setItemMeta(w12_meta1);

        ItemMeta w13_meta1 = w13.getItemMeta();
        w13_meta1.setDisplayName(ChatColor.DARK_RED + "Walka 1.3");
        ArrayList<String> w13_lore1 = new ArrayList<>();
        w13_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        w13_meta1.setLore(w13_lore1);
        w13.setItemMeta(w13_meta1);

        ItemMeta w14_meta1 = w14.getItemMeta();
        w14_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Walka 1.4");
        ArrayList<String> w14_lore1 = new ArrayList<>();
        w14_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punktów");
        w14_meta1.setLore(w14_lore1);
        w14.setItemMeta(w14_meta1);

        Inventory walka2 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "walka punkty+");
        //Menu Options(Items)
        //1
        ItemStack w21 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("walka.21")){
            w21 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack f22 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.21")) {
            f22 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("walka.22")){
            f22 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack w23 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.22")) {
            w23 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("walka.23")){
            w23 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack w24 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.23")) {
            w24 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("walka.24")){
            w24 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta w21_meta1 = w21.getItemMeta();
        w21_meta1.setDisplayName(ChatColor.AQUA + "walka 2.1 ");
        ArrayList<String> w21_lore1 = new ArrayList<>();
        w21_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1100 punktów");
        w21_meta1.setLore(w21_lore1);
        w21.setItemMeta(w21_meta1);

        ItemMeta f22_meta1 = f22.getItemMeta();
        f22_meta1.setDisplayName(ChatColor.DARK_GREEN + "walka 2.2");
        ArrayList<String> f22_lore1 = new ArrayList<>();
        f22_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3000 punktów");
        f22_meta1.setLore(f22_lore1);
        f22.setItemMeta(f22_meta1);

        ItemMeta w23_meta1 = w23.getItemMeta();
        w23_meta1.setDisplayName(ChatColor.DARK_RED + "walka 2.3");
        ArrayList<String> w23_lore1 = new ArrayList<>();
        w23_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punktów");
        w23_meta1.setLore(w23_lore1);
        w23.setItemMeta(w23_meta1);

        ItemMeta w24_meta1 = w24.getItemMeta();
        w24_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Walka 2.4");
        ArrayList<String> w24_lore1 = new ArrayList<>();
        w24_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 5000 punnktów");
        w24_meta1.setLore(w24_lore1);
        w24.setItemMeta(w24_meta1);

        Inventory walka3 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "walka dropy");
        //Menu Options(Items)
        //1

        ItemStack w31 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("walka.31")){
            w31 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack w32 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.31")) {
            w32 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("walka.32")){
            w32 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
            ItemStack w33 = new ItemStack(Material.BARRIER);
            if (playerData.getBoolean("walka.32")) {
        w33 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("walka.33")){
            w33 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
                ItemStack w34 = new ItemStack(Material.BARRIER);
                if (playerData.getBoolean("walka.33")) {
        w34 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("walka.34")){
            w34 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta w31_meta1 = w31.getItemMeta();
        w31_meta1.setDisplayName(ChatColor.AQUA + "walka 3.1 ");
        ArrayList<String> w31_lore1 = new ArrayList<>();
        w31_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        w31_meta1.setLore(w31_lore1);
        w31.setItemMeta(w31_meta1);

        ItemMeta w32_meta1 = w32.getItemMeta();
        w32_meta1.setDisplayName(ChatColor.DARK_GREEN + "walka 3.2");
        ArrayList<String> w32_lore1 = new ArrayList<>();
        w32_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        w32_meta1.setLore(w32_lore1);
        w31.setItemMeta(w32_meta1);

        ItemMeta w33_meta1 = w33.getItemMeta();
        w33_meta1.setDisplayName(ChatColor.DARK_RED + "walka 3.3");
        ArrayList<String> w33_lore1 = new ArrayList<>();
        w33_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        w33_meta1.setLore(w33_lore1);
        w33.setItemMeta(w33_meta1);

        ItemMeta w34_meta1 = w34.getItemMeta();
        w34_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "walka 3.4");
        ArrayList<String> w34_lore1 = new ArrayList<>();
        w34_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        w34_meta1.setLore(w34_lore1);
        w34.setItemMeta(w34_meta1);

        Inventory walka4 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "walka exp");
        //Menu Options(Items)
        //1
        ItemStack w41 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("walka.41")){
            w41 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack w42 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("walka.41")) {
            w42 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("walka.42")){
            w42 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
            ItemStack w43 = new ItemStack(Material.BARRIER);
            if (playerData.getBoolean("walka.42")) {
                w43 = new ItemStack(Material.RED_CONCRETE);
            }if (playerData.getBoolean("walka.43")){
            w43 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
                ItemStack w44= new ItemStack(Material.BARRIER);
                if (playerData.getBoolean("walka.43")) {
                    w44 = new ItemStack(Material.RED_CONCRETE_POWDER);
                }if (playerData.getBoolean("walka.44")){
            w44 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta w41_meta1 = w41.getItemMeta();
        w41_meta1.setDisplayName(ChatColor.AQUA + "walka 4.1 ");
        ArrayList<String> w41_lore1 = new ArrayList<>();
        w41_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        w41_meta1.setLore(w41_lore1);
        w41.setItemMeta(w41_meta1);

        ItemMeta w42_meta1 = w42.getItemMeta();
        w42_meta1.setDisplayName(ChatColor.DARK_GREEN + "walka 4.2");
        ArrayList<String> w42_lore1 = new ArrayList<>();
        w42_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        w42_meta1.setLore(w42_lore1);
        w42.setItemMeta(w42_meta1);

        ItemMeta w43_meta1 = w43.getItemMeta();
        w43_meta1.setDisplayName(ChatColor.DARK_RED + "walka 4.3");
        ArrayList<String> w43_lore1 = new ArrayList<>();
        w43_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        w43_meta1.setLore(w43_lore1);
        w43.setItemMeta(w43_meta1);

        ItemMeta w44_meta1 = w44.getItemMeta();
        w44_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "walka 4.4");
        ArrayList<String> w44_lore1 = new ArrayList<>();
        w44_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        w44_meta1.setLore(w44_lore1);
        w44.setItemMeta(w44_meta1);

        Inventory zaklinanie = Bukkit.createInventory(player, 9, ChatColor.AQUA + "zaklinanie");

        //Menu Options(Items)
        //1
        ItemStack zmozliwosci = new ItemStack(Material.BOOKSHELF); //Kills the player
        //2
        ItemStack zpunkciki =  new ItemStack(Material.KNOWLEDGE_BOOK); //Fills the hunger bar
        //3
        ItemStack zdrop = new ItemStack(Material.ENCHANTED_BOOK); //Gives the player a weapon
        //4
        ItemStack zexp = new ItemStack(Material.WRITABLE_BOOK);
        //punkty
        ItemStack zpunkty = new ItemStack(Material.ENCHANTING_TABLE);
        //Edit the items
        ItemMeta zmozliwosci_meta = zmozliwosci.getItemMeta();
        zmozliwosci_meta.setDisplayName(ChatColor.AQUA + "zaklinanie możliwości");
        ArrayList<String> zmozliwosci_lore = new ArrayList<>();
        zmozliwosci_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        zmozliwosci_meta.setLore(zmozliwosci_lore);
        zmozliwosci.setItemMeta(zmozliwosci_meta);

        ItemMeta zpunkciki_meta = zpunkciki.getItemMeta();
        zpunkciki_meta.setDisplayName(ChatColor.DARK_GREEN + "zaklinanie punkty+");
        ArrayList<String> zpunkciki_lore = new ArrayList<>();
        zpunkciki_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        zpunkciki_meta.setLore(zpunkciki_lore);
        zpunkciki.setItemMeta(zpunkciki_meta);

        ItemMeta zdrop_meta = zdrop.getItemMeta();
        zdrop_meta.setDisplayName(ChatColor.DARK_RED + "zaklinanie drop");
        ArrayList<String> zdrop_lore = new ArrayList<>();
        zdrop_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        zdrop_meta.setLore(zdrop_lore);
        zdrop.setItemMeta(zdrop_meta);

        ItemMeta zexp_meta = zexp.getItemMeta();
        zexp_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "zaklinanie exp");
        ArrayList<String> zexp_lore = new ArrayList<>();
        zexp_lore.add(ChatColor.GOLD + "KLiknij LPM aby wejść do tej kategorii");
        zexp_meta.setLore(zexp_lore);
        zexp.setItemMeta(zexp_meta);

        ItemMeta zpunkty_meta = zpunkty.getItemMeta();
        zpunkty_meta.setDisplayName(ChatColor.BLACK + "zaklinanie punkty");
        ArrayList<String> zpunkty_lore = new ArrayList<>();
        zpunkty_lore.add(ChatColor.GOLD + "Masz:" + playerData.getInt("zaklinanie.punkty") + "punktów zaklinania");
        zpunkty_meta.setLore(zpunkty_lore);
        zpunkty.setItemMeta(zpunkty_meta);

        Inventory zaklinanie1 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "zaklinanie możliwości");
        //Menu Options(Items)
        //1
        ItemStack z11 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("zaklinanie.11")){
            z11 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack z12 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.11"))
            z12 = new ItemStack(Material.RED_STAINED_GLASS);
        if (playerData.getBoolean("zaklinanie.12")){
            z12 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack z13 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.12"))
            z13 = new ItemStack(Material.RED_CONCRETE);
        if (playerData.getBoolean("zaklinanie.13")){
            z13 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack z14 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.13"))
            z14 = new ItemStack(Material.RED_CONCRETE_POWDER);
        if (playerData.getBoolean("zaklinanie.14")){
            z14 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta z11_meta1 = z11.getItemMeta();
        z11_meta1.setDisplayName(ChatColor.AQUA + "zaklinanie 1.1 ");
        ArrayList<String> z11_lore1 = new ArrayList<>();
        z11_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 500 punktów");
        z11_meta1.setLore(z11_lore1);
        z11.setItemMeta(z11_meta1);

        ItemMeta z12_meta1 = z12.getItemMeta();
        z12_meta1.setDisplayName(ChatColor.DARK_GREEN + "zaklinanie 1.2");
        ArrayList<String> z12_lore1 = new ArrayList<>();
        z12_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2000 punktów");
        z12_meta1.setLore(z12_lore1);
        z12.setItemMeta(z12_meta1);

        ItemMeta z13_meta1 = z13.getItemMeta();
        z13_meta1.setDisplayName(ChatColor.DARK_RED + "zaklinanie 1.3");
        ArrayList<String> z13_lore1 = new ArrayList<>();
        z13_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        z13_meta1.setLore(z13_lore1);
        z13.setItemMeta(z13_meta1);

        ItemMeta z14_meta1 = z14.getItemMeta();
        z14_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "zaklinanie 1.4");
        ArrayList<String> z14_lore1 = new ArrayList<>();
        z14_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punktów");
        z14_meta1.setLore(z14_lore1);
        z14.setItemMeta(z14_meta1);

        Inventory zaklinanie2 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "zaklinanie punkty+");
        //Menu Options(Items)
        //1
        ItemStack z21 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("zaklinanie.21")){
            z21 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack z22 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.21")) {
            z22 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("zaklinanie.22")){
            z22 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
        ItemStack z23 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.22")) {
            z23 = new ItemStack(Material.RED_CONCRETE);
        }if (playerData.getBoolean("zaklinanie.23")){
            z23 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
        ItemStack z24 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.23")) {
            z24 = new ItemStack(Material.RED_CONCRETE_POWDER);
        }if (playerData.getBoolean("zaklinanie.24")){
            z24 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta z21_meta1 = z21.getItemMeta();
        z21_meta1.setDisplayName(ChatColor.AQUA + "zaklinanie 2.1 ");
        ArrayList<String> z21_lore1 = new ArrayList<>();
        z21_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1100 punktów");
        z21_meta1.setLore(z21_lore1);
        z21.setItemMeta(z21_meta1);

        ItemMeta z22_meta1 = z22.getItemMeta();
        z22_meta1.setDisplayName(ChatColor.DARK_GREEN + "zaklinanie 2.2");
        ArrayList<String> z22_lore1 = new ArrayList<>();
        z22_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3000 punktów");
        z22_meta1.setLore(z22_lore1);
        z22.setItemMeta(z22_meta1);

        ItemMeta z23_meta1 = z23.getItemMeta();
        z23_meta1.setDisplayName(ChatColor.DARK_RED + "zaklinanie 2.3");
        ArrayList<String> z23_lore1 = new ArrayList<>();
        z23_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 4000 punktów");
        z23_meta1.setLore(z23_lore1);
        z23.setItemMeta(z23_meta1);

        ItemMeta z24_meta1 = z24.getItemMeta();
        z24_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Rolncitwo 2.4");
        ArrayList<String> z24_lore1 = new ArrayList<>();
        z24_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 5000 punnktów");
        z24_meta1.setLore(z24_lore1);
        z24.setItemMeta(z24_meta1);

        Inventory zaklinanie3 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "zaklinanie dropy");
        //Menu Options(Items)
        //1
        ItemStack z31 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("zaklinanie.31")){
            z31 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack z32 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.31")) {

            z32 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("zaklinanie.32")){
            z32 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
            ItemStack z33 = new ItemStack(Material.BARRIER);
            if (playerData.getBoolean("zaklinanie.32")) {

                z33 = new ItemStack(Material.RED_CONCRETE);
            }if (playerData.getBoolean("zaklinanie.33")){
            z33 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
                ItemStack z34 = new ItemStack(Material.BARRIER);
                if (playerData.getBoolean("zaklinanie.33")) {

                    z34 = new ItemStack(Material.RED_CONCRETE_POWDER);
                }if (playerData.getBoolean("zaklinanie.34")){
            z34 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta z31_meta1 = z31.getItemMeta();
        z31_meta1.setDisplayName(ChatColor.AQUA + "zaklinanie 3.1 ");
        ArrayList<String> z31_lore1 = new ArrayList<>();
        z31_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        z31_meta1.setLore(z31_lore1);
        z31.setItemMeta(z31_meta1);

        ItemMeta z32_meta1 = z32.getItemMeta();
        z32_meta1.setDisplayName(ChatColor.DARK_GREEN + "zaklinanie 3.2");
        ArrayList<String> z32_lore1 = new ArrayList<>();
        z32_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        z32_meta1.setLore(z32_lore1);
        z32.setItemMeta(z32_meta1);

        ItemMeta z33_meta1 = z33.getItemMeta();
        z33_meta1.setDisplayName(ChatColor.DARK_RED + "zaklinanie 3.3");
        ArrayList<String> z33_lore1 = new ArrayList<>();
        z33_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        z33_meta1.setLore(z33_lore1);
        z33.setItemMeta(z33_meta1);

        ItemMeta z34_meta1 = z34.getItemMeta();
        z34_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Rolncitwo 3.4");
        ArrayList<String> z34_lore1 = new ArrayList<>();
        z34_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        z34_meta1.setLore(z34_lore1);
        z34.setItemMeta(z34_meta1);

        Inventory zaklinanie4 = Bukkit.createInventory(player, 9, ChatColor.AQUA + "zaklinanie exp");
        //Menu Options(Items)
        //1
        ItemStack z41 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        if (playerData.getBoolean("zaklinanie.41")){
            z41 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }

        //Kills the player
        //2
        ItemStack z42 = new ItemStack(Material.BARRIER);
        if (playerData.getBoolean("zaklinanie.41")) {

            z42 = new ItemStack(Material.RED_STAINED_GLASS);
        }if (playerData.getBoolean("zaklinanie.42")){
            z42 = new ItemStack(Material.GREEN_STAINED_GLASS);
        } //Fills the hunger bar
        //3
            ItemStack z43 = new ItemStack(Material.BARRIER);
            if (playerData.getBoolean("zaklinanie.42")) {

                z43 = new ItemStack(Material.RED_CONCRETE);
            }if (playerData.getBoolean("zaklinanie.43")){
            z43 = new ItemStack(Material.GREEN_CONCRETE);
        }
        //4
                ItemStack z44 = new ItemStack(Material.BARRIER);
                if (playerData.getBoolean("zaklinanie.43")) {

                    z44 = new ItemStack(Material.RED_CONCRETE_POWDER);
                }if (playerData.getBoolean("zaklinanie.44")){
            z44 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
        }
        //Edit the items
        ItemMeta z41_meta1 = z41.getItemMeta();
        z41_meta1.setDisplayName(ChatColor.AQUA + "zaklinanie 4.1 ");
        ArrayList<String> z41_lore1 = new ArrayList<>();
        z41_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 700 punktów");
        z41_meta1.setLore(z41_lore1);
        z41.setItemMeta(z41_meta1);

        ItemMeta z42_meta1 = z42.getItemMeta();
        z42_meta1.setDisplayName(ChatColor.DARK_GREEN + "zaklinanie 4.2");
        ArrayList<String> z42_lore1 = new ArrayList<>();
        z42_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 1500 punktów");
        z42_meta1.setLore(z42_lore1);
        z42.setItemMeta(z42_meta1);

        ItemMeta z43_meta1 = z43.getItemMeta();
        z43_meta1.setDisplayName(ChatColor.DARK_RED + "zaklinanie 4.3");
        ArrayList<String> z43_lore1 = new ArrayList<>();
        z43_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 2500 punktów");
        z43_meta1.setLore(z43_lore1);
        z43.setItemMeta(z43_meta1);

        ItemMeta z44_meta1 = z44.getItemMeta();
        z44_meta1.setDisplayName(ChatColor.LIGHT_PURPLE + "Zaklinanie 4.4");
        ArrayList<String> z44_lore1 = new ArrayList<>();
        z44_lore1.add(ChatColor.GOLD + "KLiknij LPM aby kupić za 3500 punnktów");
        z44_meta1.setLore(z44_lore1);

if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Klasy")) {
    e.setCancelled(true);
    if (e.getCurrentItem() == null) {
        return;
    } else if (e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
        ItemStack[] menu_items = {gmozliwosci, gpunkciki, gdrop, gxp, gpunkty};
        gornictwo.setContents(menu_items);
        player.openInventory(gornictwo);
    } else if (e.getCurrentItem().getType().equals(Material.DIAMOND_HOE)) {
        ItemStack[] menu_items = {rmoz, rpunkciki, rdrop, rexp, rpunkty};
        rolnictwo.setContents(menu_items);
        player.openInventory(rolnictwo);
    } else if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {

        ItemStack[] menu_items1 = {wmmozliwosci, wpunkty, wdrop, wexp, wapunkty};
        walka.setContents(menu_items1);
        player.openInventory(walka);
    } else if (e.getCurrentItem().getType().equals(Material.ENCHANTING_TABLE)) {
        //rolnictwo

        //Put the items in the inventory
        ItemStack[] menu_items = {zmozliwosci, zpunkciki, zdrop, zexp, zpunkty};
        zaklinanie.setContents(menu_items);
        player.openInventory(zaklinanie);
    }
}
if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Gornictwo")) {
    e.setCancelled(true);
    if (e.getCurrentItem() == null) {
        return;
    } else {
        if (e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
            ItemStack[] menu_items1 = {g111, g121, g131, g14, gpunkty};
            gornictwo11.setContents(menu_items1);
            player.openInventory(gornictwo11);
        }
        if (e.getCurrentItem().getType().equals(Material.IRON_PICKAXE)) {
            ItemStack[] menu_items1 = {g21, g22, g23, g24, gpunkty};
            gornictwo12.setContents(menu_items1);
            player.openInventory(gornictwo12);
        }
        if (e.getCurrentItem().getType().equals(Material.STONE_PICKAXE)) {
            ItemStack[] menu = {g31, g32, g33, g34, gpunkty};
            gornictwo13.setContents(menu);
            player.openInventory(gornictwo13);
        }
        if (e.getCurrentItem().getType().equals(Material.WOODEN_PICKAXE)) {
            ItemStack[] menu = {g41, g42, g43, g44, gpunkty};
            gornictwo14.setContents(menu);
            player.openInventory(gornictwo14);
        }
    }
}
if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Rolnictwo")) {
    e.setCancelled(true);
    if (e.getCurrentItem() == null) {
        return;
    } else {
        if (e.getCurrentItem().getType().equals(Material.DIAMOND_HOE)) {
            ItemStack[] menu_items1 = {r11, r12, r13, r14, rpunkty};
            r1.setContents(menu_items1);
            player.openInventory(r1);
        }
        if (e.getCurrentItem().getType().equals(Material.IRON_HOE)) {
            ItemStack[] menu_items1 = {r21, r22, r23, r24, rpunkty};
            r2.setContents(menu_items1);
            player.openInventory(r2);
        }
        if (e.getCurrentItem().getType().equals(Material.STONE_HOE)) {
            ItemStack[] menu_items1 = {r31, r32, r33, r34, rpunkty};
            r3.setContents(menu_items1);
            player.openInventory(r3);
        }
        if (e.getCurrentItem().getType().equals(Material.WOODEN_HOE)) {
            ItemStack[] menu = {r41, r42, r43, r44, rpunkty};
            r4.setContents(menu);
            player.openInventory(r4);
        }
    }
}
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Walka")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            } else {
                if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
                    ItemStack[] menu_items1 = {w11, w12, w13, w14, wapunkty};
                    walka1.setContents(menu_items1);
                    player.openInventory(walka1);
                }
                if (e.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
                    ItemStack[] menu_items1 = {w21, f22, w23, w24, wapunkty};
                    walka2.setContents(menu_items1);
                    player.openInventory(walka2);
                }
                if (e.getCurrentItem().getType().equals(Material.STONE_SWORD)) {
                    ItemStack[] menu_items1 = {w31, w32, w33, w34, wapunkty};
                    walka3.setContents(menu_items1);
                    player.openInventory(walka3);
                }

            }
        }
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Zaklinanie")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            } else {
                if (e.getCurrentItem().getType().equals(Material.BOOKSHELF)) {
                    ItemStack[] menu_items1 = {z11, z12, z13, z14, zpunkty};
                    zaklinanie1.setContents(menu_items1);
                    player.openInventory(zaklinanie1);
                }
                if (e.getCurrentItem().getType().equals(Material.KNOWLEDGE_BOOK)) {
                    ItemStack[] menu_items1 = {z21, z22, z23, z24, zpunkty};
                    zaklinanie2.setContents(menu_items1);
                    player.openInventory(zaklinanie2);
                }
                if (e.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK)) {
                    ItemStack[] menu_items1 = {z31, z32, z33, z34, zpunkty};
                    zaklinanie3.setContents(menu_items1);
                    player.openInventory(zaklinanie3);
                }
                if (e.getCurrentItem().getType().equals(Material.WRITABLE_BOOK)) {
                    ItemStack[] menu = {z41, z42, z43, z44, zpunkty};
                    zaklinanie4.setContents(menu);
                    player.openInventory(zaklinanie4);
                }
            }
        }
if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Gornictwo możliwości")){
    e.setCancelled(true);
    if (e.getCurrentItem() == null){
        return;
    }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
        if (playerData.getInt("gornictwo.punkty") >=500){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 1.1 za 500 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 500);
            playerData.set("gornictwo.11", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
            }
    }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
        if (playerData.getInt("gornictwo.punkty") >=2000){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 1.2 za 2000 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 2000);
            playerData.set("gornictwo.12", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
        if (playerData.getInt("gornictwo.punkty") >=2500){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 1.3 za 2500 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 2500);
            playerData.set("gornictwo.13", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
        if (playerData.getInt("gornictwo.punkty") >=4000){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 1.4 za 4000 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 4000);
            playerData.set("gornictwo.14", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }
}

if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Gornictwo punkty+")){
    e.setCancelled(true);
    if (e.getCurrentItem() == null){
        return;
    }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
        if (playerData.getInt("gornictwo.punkty") >=1100){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 2.1 za 1100 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 1100);
            playerData.set("gornictwo.21", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
        if (playerData.getInt("gornictwo.punkty") >=2000){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 2.2 za 3000 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 3000);
            playerData.set("gornictwo.22", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
        if (playerData.getInt("gornictwo.punkty") >=4000){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 2.3 za 4000 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 4000);
            playerData.set("gornictwo.23", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
        if (playerData.getInt("gornictwo.punkty") >=5000){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 2.4 za 5000 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 5000);
            playerData.set("gornictwo.24", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }
}
if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Gornictwo dropy")){
    e.setCancelled(true);
    if (e.getCurrentItem() == null){
        return;
    }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
        if (playerData.getInt("gornictwo.punkty") >=700){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 3.1 za 700 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 700);
            playerData.set("gornictwo.31", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
        if (playerData.getInt("gornictwo.punkty") >=1500){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 3.2 za 1500 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 1500);
            playerData.set("gornictwo.32", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
        if (playerData.getInt("gornictwo.punkty") >=2500){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 3.3 za 2500 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") -2500);
            playerData.set("gornictwo.33", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
        if (playerData.getInt("gornictwo.punkty") >=3500){
            player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 3.4 za 3500 punktów");
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 3500);
            playerData.set("gornictwo.34", true);
            player.closeInventory();
        }else {
            player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
            player.closeInventory();
        }
    }
}
    if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Rolnictwo mozliwosci")){
        e.setCancelled(true);
        if (e.getCurrentItem() == null){
            return;
        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
            if (playerData.getInt("rolnictwo.punkty") >=500){
                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś Rolnictwo 1.1 za 500 punktów");
                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 500);
                playerData.set("rolnictwo.11", true);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
            if (playerData.getInt("rolnictwo.punkty") >=2000){
                playerData.set("rolnictwo.12", true);

                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 1.2 za 2000 punktów");
                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 2000);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
            if (playerData.getInt("rolnictwo.punkty") >=2500){
                playerData.set("rolnictwo.13", true);

                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 1.3 za 2500 punktów");
                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 2500);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
            if (playerData.getInt("rolnictwo.punkty") >=4000){
                playerData.set("rolnictwo.14", true);
                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 1.4 za 4000 punktów");
                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 4000);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }
        }
                if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Gornictwo exp")){
        e.setCancelled(true);
        if (e.getCurrentItem() == null){
            return;
        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
            if (playerData.getInt("gornictwo.punkty") >=700){
                playerData.set("gornictwo.41", true);
                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 4.1 za 700 punktów");
                playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 700);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
            if (playerData.getInt("gornictwo.punkty") >=1500){
                playerData.set("gornictwo.42", true);

                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 4.2 za 1500 punktów");
                playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 1500);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
            if (playerData.getInt("gornictwo.punkty") >=2500){
                playerData.set("gornictwo.43", true);

                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 4.3 za 2500 punktów");
                playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") -2500);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
            if (playerData.getInt("gornictwo.punkty") >=3500){
                playerData.set("gornictwo.44", true);

                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś górnictwo 4.4 za 3500 punktów");
                playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") - 3500);
                player.closeInventory();
            }else {
                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                player.closeInventory();
            }
        }
    }


        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Rolnictwo punkty+")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                if (playerData.getInt("rolnictwo.punkty") >=1100){
                    playerData.set("rolnictwo.21", true);

                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 2.1 za 1100 punktów");
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 1100);
                    player.closeInventory();
                }else {
                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                    player.closeInventory();
                }
            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                if (playerData.getInt("rolnictwo.punkty") >=2000){
                    playerData.set("rolnictwo.22", true);

                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 2.2 za 3000 punktów");
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 3000);
                    player.closeInventory();
                }else {
                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                    player.closeInventory();
                }
            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                if (playerData.getInt("rolnictwo.punkty") >=4000){
                    playerData.set("rolnictwo.23", true);

                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 2.3 za 4000 punktów");
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 4000);
                    player.closeInventory();
                }else {
                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                    player.closeInventory();
                }

            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                if (playerData.getInt("rolnictwo.punkty") >=5000){
                    playerData.set("rolnictwo.24", true);

                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 2.4 za 5000 punktów");
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 5000);
                    player.closeInventory();
                }else {
                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                    player.closeInventory();
                }
            }
   }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Rolnictwo dropy")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else
                if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                    if (playerData.getInt("rolnictwo.punkty") >=700){
                        playerData.set("rolnictwo.31", true);

                        player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 3.1 za 700 punktów");
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 700);
                        player.closeInventory();
                    }else {
                        player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                        player.closeInventory();
                    }
                }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                    if (playerData.getInt("rolnictwo.punkty") >=1500){
                        playerData.set("rolnictwo.32", true);

                        player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 3.2 za 1500 punktów");
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 1500);
                        player.closeInventory();
                    }else {
                        player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                        player.closeInventory();
                    }
                }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                    if (playerData.getInt("rolnictwo.punkty") >=2500){
                        playerData.set("rolnictwo.33", true);

                        player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 3.3 za 2500 punktów");
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") -2500);
                        player.closeInventory();
                    }else {
                        player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                        player.closeInventory();
                    }
                }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                    if (playerData.getInt("rolnictwo.punkty") >=3500){
                        playerData.set("rolnictwo.34", true);

                        player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 3.4 za 3500 punktów");
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 3500);
                        player.closeInventory();
                    }else {
                        player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                        player.closeInventory();
                    }
                }
        }
                    if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Rolnictwo exp")){
                        e.setCancelled(true);
                        if (e.getCurrentItem() == null){
                            return;
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                            if (playerData.getInt("rolnictwo.punkty") >=700){
                                playerData.set("rolnictwo.41", true);

                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 4.1 za 700 punktów");
                                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 700);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                            if (playerData.getInt("rolnictwo.punkty") >=1500){
                                playerData.set("rolnictwo.42", true);

                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 4.2 za 1500 punktów");
                                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 1500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                            if (playerData.getInt("rolnictwo.punkty") >=2500){
                                playerData.set("rolnictwo.43", true);

                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 4.3 za 2500 punktów");
                                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") -2500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }

                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                            if (playerData.getInt("rolnictwo.punkty") >=3500){
                                playerData.set("rolnictwo.44", true);

                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś rolnictwo 4.4 za 3500 punktów");
                                playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") - 3500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }
                    }
                        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"Walka możliwości")){
                            e.setCancelled(true);
                            if (e.getCurrentItem() == null){
                                return;
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                                if (playerData.getInt("walka.punkty") >=500){
                                    playerData.set("walka.11", true);

                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś Walka 1.1 za 500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                                if (playerData.getInt("walka.punkty") >=2000){
                                    playerData.set("walka.12", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 1.2 za 2000 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 2000);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                                if (playerData.getInt("walka.punkty") >=2500){
                                    playerData.set("walka.13", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 1.3 za 2500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 2500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }

                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                                if (playerData.getInt("walka.punkty") >=4000){
                                    playerData.set("walka.14", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 1.4 za 4000 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 4000);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }
                        }

                        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"walka punkty+")){
                            e.setCancelled(true);
                            if (e.getCurrentItem() == null){
                                return;
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                                if (playerData.getInt("walka.punkty") >=1100){
                                    playerData.set("walka.21", true);

                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 2.1 za 1100 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 1100);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                                if (playerData.getInt("walka.punkty") >=2000){
                                    playerData.set("walka.22", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 2.2 za 3000 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 3000);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                                if (playerData.getInt("walka.punkty") >=4000){
                                    playerData.set("walka.23", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 2.3 za 4000 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 4000);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }

                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                                if (playerData.getInt("walka.punkty") >=5000){
                                    playerData.set("walka.24", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 2.4 za 5000 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 5000);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }
                        }
                        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"walka dropy")){
                            e.setCancelled(true);
                            if (e.getCurrentItem() == null){
                                return;
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                                if (playerData.getInt("walka.punkty") >=700){
                                    playerData.set("walka.31", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 3.1 za 700 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 700);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                                if (playerData.getInt("walka.punkty") >=1500){
                                    playerData.set("walka.32", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 3.2 za 1500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 1500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                                if (playerData.getInt("walka.punkty") >=2500){
                                    playerData.set("walka.33", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 3.3 za 2500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") -2500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }

                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                                if (playerData.getInt("walka.punkty") >=3500){
                                    playerData.set("walka.34", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 3.4 za 3500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 3500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }
                        }
                        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"walka exp")){
                            e.setCancelled(true);
                            if (e.getCurrentItem() == null){
                                return;
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                                if (playerData.getInt("walka.punkty") >=700){
                                    playerData.set("walka.41", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 4.1 za 700 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 700);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                                if (playerData.getInt("walka.punkty") >=1500){
                                    playerData.set("walka.42", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 4.2 za 1500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 1500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                                if (playerData.getInt("walka.punkty") >=2500){
                                    playerData.set("walka.43", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 4.3 za 2500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") -2500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }

                            }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                                if (playerData.getInt("walka.punkty") >=3500){
                                    playerData.set("walka.44", true);
                                    player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś walka 4.4 za 3500 punktów");
                                    playerData.set("walka.punkty", playerData.getInt("walka.punkty") - 3500);
                                    player.closeInventory();
                                }else {
                                    player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                    player.closeInventory();
                                }
                            }}
                    if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"zaklinanie możliwości")){
                        e.setCancelled(true);
                        if (e.getCurrentItem() == null){
                            return;
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                            if (playerData.getInt("zaklinanie.punkty") >=500){
                                playerData.set("zaklinanie.11", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 1.1 za 500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                            if (playerData.getInt("zaklinanie.punkty") >=2000){
                                playerData.set("zaklinanie.12", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 1.2 za 2000 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 2000);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                            if (playerData.getInt("zaklinanie.punkty") >=2500){
                                playerData.set("zaklinanie.13", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 1.3 za 2500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 2500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }

                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                            if (playerData.getInt("zaklinanie.punkty") >=4000){
                                playerData.set("zaklinanie.14", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 1.4 za 4000 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 4000);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }
                    }
                    if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"zaklinanie punkty+")){
                        e.setCancelled(true);
                        if (e.getCurrentItem() == null){
                            return;
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                            if (playerData.getInt("zaklinanie.punkty") >=1100){
                                playerData.set("zaklinanie.21", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 2.1 za 1100 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 1100);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                            if (playerData.getInt("zaklinanie.punkty") >=2000){
                                playerData.set("zaklinanie.22", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 2.2 za 3000 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 3000);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                            if (playerData.getInt("zaklinanie.punkty") >=4000){
                                playerData.set("zaklinanie.23", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 2.3 za 4000 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 4000);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }

                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                            if (playerData.getInt("zaklinanie.punkty") >=5000){
                                playerData.set("zaklinanie.24", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 2.4 za 5000 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 5000);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }
                    }
                    if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"zaklinanie dropy")){
                        e.setCancelled(true);
                        if (e.getCurrentItem() == null){
                            return;
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                            if (playerData.getInt("zaklinanie.punkty") >=700){
                                playerData.set("zaklinanie.31", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 3.1 za 700 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 700);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                            if (playerData.getInt("zaklinanie.punkty") >=1500){
                                playerData.set("zaklinanie.32", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 3.2 za 1500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 1500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                            if (playerData.getInt("zaklinanie.punkty") >=2500){
                                playerData.set("zaklinanie.33", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 3.3 za 2500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") -2500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }

                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                            if (playerData.getInt("zaklinanie.punkty") >=3500){
                                playerData.set("zaklinanie.34", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 3.4 za 3500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 3500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }
                    }
                    if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA +"zaklinanie exp")){
                        e.setCancelled(true);
                        if (e.getCurrentItem() == null){
                            return;
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                            if (playerData.getInt("zaklinanie.punkty") >=700){
                                playerData.set("zaklinanie.41", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 4.1 za 700 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 700);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)){
                            if (playerData.getInt("zaklinanie.punkty") >=1500){
                                playerData.set("zaklinanie.42", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 4.2 za 1500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 1500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE)){
                            if (playerData.getInt("zaklinanie.punkty") >=2500){
                                playerData.set("zaklinanie.43", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 4.3 za 2500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") -2500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }

                        }else if (e.getCurrentItem().getType().equals(Material.RED_CONCRETE_POWDER)){
                            if (playerData.getInt("zaklinanie.punkty") >=3500){
                                playerData.set("zaklinanie.44", true);
                                player.sendMessage(ChatColor.GREEN + "Gratulacje zakupiłeś zaklinanie 4.4 za 3500 punktów");
                                playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") - 3500);
                                player.closeInventory();
                            }else {
                                player.sendMessage(ChatColor.RED + "Oj mordeczko problem jest. Zarobić musisz");
                                player.closeInventory();
                            }
                        }}
        try {
            playerData.save(playerFile);
        } catch (IOException e1) {
            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
            e1.printStackTrace();
        }
                }

            }

