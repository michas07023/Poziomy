package michał.gryboś.michalowicepoziomy;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class Michalowicepoziomy extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        Plugin plugin = Michalowicepoziomy.getPlugin(Michalowicepoziomy.class);
        Objects.requireNonNull(this.getCommand("profil")).setExecutor(new komendy());
        plugin.getConfig();
        getServer().getPluginManager().registerEvents(this,  this);
        this.getServer().getPluginManager().registerEvents(new MenuHandler(), this);
        if(!this.getDataFolder().exists()) {
            try {
                this.getDataFolder().mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File fileinfo = new File(getDataFolder(),"something.yml");

        if(!getDataFolder().exists()) getDataFolder().mkdir();
        if(!fileinfo.exists()) {
            try {
                fileinfo.createNewFile();
                getConfig().options().copyDefaults(true);
                getConfig().save(fileinfo);
                getConfig().options().copyDefaults(false);
            } catch (IOException e) {

                System.out.println("Uh-Oh, Something happened!");
            }
        }
    }
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
        File fileinfo = new File(getDataFolder(),"panpolicjant.yml");
        if(!getDataFolder().exists()) getDataFolder().mkdir();
        if(!fileinfo.exists()) {
            try {
                fileinfo.createNewFile();
                getConfig().options().copyDefaults(true);
                getConfig().save(fileinfo);
                getConfig().options().copyDefaults(false);
            } catch (IOException e) {

                System.out.println("Uh-Oh, Something happened!");
            }
        }
        Player p = event.getPlayer();
        String playerName = p.getName();
        p.sendMessage("Siema typie" + playerName);
        File userdata = new File(getDataFolder(), File.separator + "PlayerDatabase");
        File f = new File(getPlugin(Michalowicepoziomy.class).getDataFolder() + File.separator + "PlayerDatabase", playerName + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

        //When the player file is created for the first time...
        if (!f.exists()) {
            try {

                playerData.createSection("gornictwo");
                playerData.set("gornictwo.punkty", 0);
                playerData.set("gornictwo.11", false);
                playerData.set("gornictwo.12", false);
                playerData.set("gornictwo.13", false);
                playerData.set("gornictwo.14", false);
                playerData.set("gornictwo.21", false);
                playerData.set("gornictwo.22", false);
                playerData.set("gornictwo.23", false);
                playerData.set("gornictwo.24", false);
                playerData.set("gornictwo.31", false);
                playerData.set("gornictwo.32", false);
                playerData.set("gornictwo.33", false);
                playerData.set("gornictwo.34", false);
                playerData.set("gornictwo.41", false);
                playerData.set("gornictwo.42", false);
                playerData.set("gornictwo.43", false);
                playerData.set("gornictwo.44", false);


                playerData.createSection("zaklinanie");
                playerData.set("zaklinanie.punkty", 0);
                playerData.set("zaklinanie.11", false);
                playerData.set("zaklinanie.12", false);
                playerData.set("zaklinanie.13", false);
                playerData.set("zaklinanie.14", false);
                playerData.set("zaklinanie.21", false);
                playerData.set("zaklinanie.22", false);
                playerData.set("zaklinanie.23", false);
                playerData.set("zaklinanie.24", false);
                playerData.set("zaklinanie.31", false);
                playerData.set("zaklinanie.32", false);
                playerData.set("zaklinanie.33", false);
                playerData.set("zaklinanie.34", false);
                playerData.set("zaklinanie.41", false);
                playerData.set("zaklinanie.42", false);
                playerData.set("zaklinanie.43", false);
                playerData.set("zaklinanie.44", false);


                playerData.createSection("walka");
                playerData.set("walka.punkty", 0);
                playerData.set("walka.11", false);
                playerData.set("walka.12", false);
                playerData.set("walka.13", false);
                playerData.set("walka.14", false);
                playerData.set("walka.21", false);
                playerData.set("walka.22", false);
                playerData.set("walka.23", false);
                playerData.set("walka.24", false);
                playerData.set("walka.31", false);
                playerData.set("walka.32", false);
                playerData.set("walka.33", false);
                playerData.set("walka.34", false);
                playerData.set("walka.41", false);
                playerData.set("walka.42", false);
                playerData.set("walka.43", false);
                playerData.set("walka.44", false);


                playerData.createSection("rolnictwo");
                playerData.set("rolnictwo.punkty", 0);
                playerData.set("rolnictwo.11", false);
                playerData.set("rolnictwo.12", false);
                playerData.set("rolnictwo.13", false);
                playerData.set("rolnictwo.14", false);
                playerData.set("rolnictwo.21", false);
                playerData.set("rolnictwo.22", false);
                playerData.set("rolnictwo.23", false);
                playerData.set("rolnictwo.24", false);
                playerData.set("rolnictwo.31", false);
                playerData.set("rolnictwo.32", false);
                playerData.set("rolnictwo.33", false);
                playerData.set("rolnictwo.34", false);
                playerData.set("rolnictwo.41", false);
                playerData.set("rolnictwo.42", false);
                playerData.set("rolnictwo.43", false);
                playerData.set("rolnictwo.44", false);
                playerData.save(f);
            } catch (IOException exception) {

                exception.printStackTrace();
            }

            //1 - możliwość wydobycia
            //2 - zwiększenie punktów
            //3 - zwiększenie dropów
            //4 - zwiększenie doświadczenia
        }

    }
    public File getPlayerFile(String playerName) {

        File playerFile =  new File (getPlugin(Michalowicepoziomy.class).getDataFolder() + File.separator + "PlayerDatabase", playerName + ".yml");
        return playerFile;
    }
@EventHandler
    public void onBattle(EntityDamageByEntityEvent e){
    if (e.getDamager() instanceof Player){
        Entity player = e.getDamager();
        Entity mob = e.getEntity();
        Player gracz = (Player) player;
    File playerFile = getPlayerFile(player.getName());
    FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
    try {
        playerData.save(playerFile);
    } catch (IOException e1) {
        Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
        e1.printStackTrace();
    }
    boolean gornik = playerData.getBoolean("walka.14");
    boolean gornik2 = playerData.getBoolean("walka.13");
    boolean gornik3 = playerData.getBoolean("walka.12");
    boolean gornik4 = playerData.getBoolean("walka.11");
        if (mob instanceof EnderDragon| mob instanceof  Wither){
            if (!gornik){
                e.setCancelled(true);
                player.sendMessage("§4 Mordeczko masz za niski level walki! UCIEKAJ BO NIC NIE BIJESZ! Wbij level 1.4 :)");
            }
        }
        if (mob instanceof Enderman|mob instanceof Endermite|mob instanceof Shulker){
            if (!gornik2){
             e.setCancelled(true);
             player.sendMessage("§4 Mordeczko masz za niski level walki! UCIEKAJ BO NIC NIE BIJESZ! Wbij level 1.3 :)");
            }
        }
       if (mob instanceof PigZombie| mob instanceof Blaze| mob instanceof Piglin|mob instanceof PiglinBrute|mob instanceof WitherSkeleton|mob instanceof MagmaCube|mob instanceof Ghast ){
        if (!gornik3){
            e.setCancelled(true);
            player.sendMessage("§4 Mordeczko masz za niski level walki! UCIEKAJ BO NIC NIE BIJESZ! Wbij level 1.2 :)");
        }}
        if (mob instanceof Zombie| mob instanceof Skeleton| mob instanceof Spider|mob instanceof CaveSpider|mob instanceof ZombieVillager|mob instanceof Silverfish|mob instanceof Slime|mob instanceof Slime|mob instanceof Creeper|mob instanceof Witch|mob instanceof Drowned ){
            if (!gornik4){
                gracz.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 3));
                player.sendMessage("§4 Mordeczko masz za niski level walki! Wbij level 1.1 :)");
            }
    }}}

@EventHandler
public void onKill(EntityDeathEvent e){
    if(e.getEntity().getKiller() != null) {
        Player player = e.getEntity().getKiller();
        Entity mob = e.getEntity();
        File playerFile = getPlayerFile(player.getName());
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
        try {
            playerData.save(playerFile);
        } catch (IOException e1) {
            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
            e1.printStackTrace();
        }
        int exp = player.getTotalExperience();
        Location lokalizacja = e.getEntity().getLocation();
        World world = e.getEntity().getWorld();
        boolean doswiadczenie1 = playerData.getBoolean("walka.21");
        boolean doswiadczenie2 = playerData.getBoolean("walka.22");
        boolean doswiadczenie3 = playerData.getBoolean("walka.23");
        boolean doswiadczenie4 = playerData.getBoolean("walka.24");
        boolean poziom1 = playerData.getBoolean("walka.31");
        boolean poziom2 = playerData.getBoolean("walka.32");
        boolean poziom3 = playerData.getBoolean("walka.33");
        boolean poziom4 = playerData.getBoolean("walka.34");
        boolean level4 = playerData.getBoolean("walka.44");
        boolean level3 = playerData.getBoolean("walka.43");
        boolean level2 = playerData.getBoolean("walka.42");
        boolean level1 = playerData.getBoolean("walka.41");


        if (mob instanceof EnderDragon | mob instanceof Wither) {
            if (doswiadczenie4) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 2137);
                player.sendMessage("§a Gratulacje! Zdobyłeś 2137 punktów walki");
            } else if (doswiadczenie3) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 1500);
                player.sendMessage("§a Gratulacje! Zdobyłeś 1500 punktów walki");
            } else if (doswiadczenie2) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 1000);
                player.sendMessage("§a Gratulacje! Zdobyłeś 1000 punktów walki");
            } else if (doswiadczenie1) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 600);
                player.sendMessage("§a Gratulacje! Zdobyłeś 600 punktów walki");
            } else {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 420);
                player.sendMessage("§a Gratulacje! Zdobyłeś 420 punktów walki");
            }
            if (poziom4 && mob instanceof Wither) {
                ItemStack drop = new ItemStack(Material.NETHER_STAR, 4);
                world.dropItem(lokalizacja, drop);
            } else if (poziom3 && mob instanceof Wither) {
                ItemStack drop = new ItemStack(Material.NETHER_STAR, 3);
                world.dropItem(lokalizacja, drop);
            } else if (poziom2 && mob instanceof Wither) {
                ItemStack drop = new ItemStack(Material.NETHER_STAR, 2);
                world.dropItem(lokalizacja, drop);
            } else if (poziom1 && mob instanceof Wither) {
                ItemStack drop = new ItemStack(Material.NETHER_STAR, 1);
                world.dropItem(lokalizacja, drop);
            }
            if (level4) {
                player.setTotalExperience(exp + 2137);
            } else if (level3) {
                player.setTotalExperience(exp + 1500);
            } else if (level2) {
                player.setTotalExperience(exp + 1000);
            } else if (level1) {
                player.setTotalExperience(exp + 420);
            }
        }
        if (mob instanceof Enderman | mob instanceof Endermite | mob instanceof Shulker) {
            if (doswiadczenie4) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 80);
                player.sendMessage("§a Gratulacje! Zdobyłeś 80 punktów walki");
            } else if (doswiadczenie3) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 60);
                player.sendMessage("§a Gratulacje! Zdobyłeś 60 punktów walki");
            } else if (doswiadczenie2) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 40);
                player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów walki");
            } else if (doswiadczenie1) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 20);
                player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów walki");
            } else {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 10);
                player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów walki");
            }
            if (level4) {
                player.setTotalExperience(exp + 70);
            } else if (level3) {
                player.setTotalExperience(exp + 40);
            } else if (level2) {
                player.setTotalExperience(exp + 20);
            } else if (level1) {
                player.setTotalExperience(exp + 10);
            }
        }
        if (mob instanceof Blaze | mob instanceof Piglin | mob instanceof PiglinBrute | mob instanceof WitherSkeleton | mob instanceof Ghast) {
            if (doswiadczenie4) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 60);
                player.sendMessage("§a Gratulacje! Zdobyłeś 60 punktów walki");
            } else if (doswiadczenie3) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 50);
                player.sendMessage("§a Gratulacje! Zdobyłeś 50 punktów walki");
            } else if (doswiadczenie2) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 40);
                player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów walki");
            } else if (doswiadczenie1) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 30);
                player.sendMessage("§a Gratulacje! Zdobyłeś 30 punktów walki");
            } else {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 10);
                player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów walki");
            }

            if (level4) {
                player.setTotalExperience(exp + 60);
            } else if (level3) {
                player.setTotalExperience(exp + 30);
            } else if (level2) {
                player.setTotalExperience(exp + 15);
            } else if (level1) {
                player.setTotalExperience(exp + 10);
            }
        }
        if (mob instanceof Zombie | mob instanceof Skeleton | mob instanceof Spider | mob instanceof CaveSpider | mob instanceof ZombieVillager | mob instanceof Silverfish | mob instanceof Slime | mob instanceof Creeper | mob instanceof Witch | mob instanceof Drowned) {
            if (doswiadczenie4) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 50);
                player.sendMessage("§a Gratulacje! Zdobyłeś 50 punktów walki");
            } else if (doswiadczenie3) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 40);
                player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów walki");
            } else if (doswiadczenie2) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 30);
                player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów walki");
            } else if (doswiadczenie1) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 20);
                player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów walki");
            } else {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 10);
                player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów walki");
            }

            if (level4) {
                player.setTotalExperience(exp + 40);
            } else if (level3) {
                player.setTotalExperience(exp + 25);
            } else if (level2) {
                player.setTotalExperience(exp + 13);
            } else if (level1) {
                player.setTotalExperience(exp + 10);
            }
        }
        if (mob instanceof Animals) {
            if (doswiadczenie4) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 5);
                player.sendMessage("§a Gratulacje! Zdobyłeś 5 punktów walki");
            } else if (doswiadczenie3) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 4);
                player.sendMessage("§a Gratulacje! Zdobyłeś 4 punkty walki");
            } else if (doswiadczenie2) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 3);
                player.sendMessage("§a Gratulacje! Zdobyłeś 3 punkty walki");
            } else if (doswiadczenie1) {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 2);
                player.sendMessage("§a Gratulacje! Zdobyłeś 2 punkty walki");
            } else {
                playerData.set("walka.punkty", playerData.getInt("walka.punkty") + 1);
                player.sendMessage("§a Gratulacje! Zdobyłeś 1 punkt walki");
            }

            if (level4) {
                player.setTotalExperience(exp + 10);
            } else if (level3) {
                player.setTotalExperience(exp + 8);
            } else if (level2) {
                player.setTotalExperience(exp + 6);
            } else if (level1) {
                player.setTotalExperience(exp + 4);
            }
        }
        try {
            playerData.save(playerFile);
        } catch (Exception e1) {

            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
            e1.printStackTrace();
        }
    }
    }

@EventHandler
    public void onBlockDestroy(BlockBreakEvent e) {

    Player player = e.getPlayer();
    Block block = e.getBlock();
    Material blockus = block.getType();
    Location lokalizacja = e.getBlock().getLocation();
    File playerFile = getPlayerFile(player.getName());
    FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
    try {
        playerData.save(playerFile);
    } catch (IOException e1) {
        Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
        e1.printStackTrace();
    }
    boolean gornik = playerData.getBoolean("gornictwo.14");
    boolean gornik2 = playerData.getBoolean("gornictwo.13");
    boolean gornik3 = playerData.getBoolean("gornictwo.12");
    boolean gornik4 = playerData.getBoolean("gornictwo.11");
    boolean doswiadczenie1 = playerData.getBoolean("gornictwo.21");
    boolean doswiadczenie2 = playerData.getBoolean("gornictwo.22");
    boolean doswiadczenie3 = playerData.getBoolean("gornictwo.23");
    boolean doswiadczenie4 = playerData.getBoolean("gornictwo.24");
    boolean poziom1 = playerData.getBoolean("gornictwo.31");
    boolean poziom2 = playerData.getBoolean("gornictwo.32");
    boolean poziom3 = playerData.getBoolean("gornictwo.33");
    boolean poziom4 = playerData.getBoolean("gornictwo.34");
    boolean level4 = playerData.getBoolean("gornictwo.44");
    boolean level3 = playerData.getBoolean("gornictwo.43");
    boolean level2 = playerData.getBoolean("gornictwo.42");
    boolean level1 = playerData.getBoolean("gornictwo.41");
    int exp = player.getTotalExperience();
    World world = player.getWorld();
    boolean poziom11 = playerData.getBoolean("rolnictwo.31");
    boolean poziom21 =playerData.getBoolean("rolnictwo.32");
    boolean poziom31 =playerData.getBoolean("rolnictwo.33");
    boolean poziom41 =playerData.getBoolean("rolnictwo.34");
    boolean level11 = playerData.getBoolean("rolnictwo.41");
    boolean level21 =playerData.getBoolean("rolnictwo.42");
    boolean level31 =playerData.getBoolean("rolnictwo.43");
    boolean level41 =playerData.getBoolean("rolnictwo.44");
    boolean doswiadczenie11 = playerData.getBoolean("rolnictwo.21");
    boolean doswiadczenie21 =playerData.getBoolean("rolnictwo.22");
    boolean doswiadczenie31 =playerData.getBoolean("rolnictwo.23");
    boolean doswiadczenie41 =playerData.getBoolean("rolnictwo.24");
    boolean rolnictwo12 = playerData.getBoolean("rolnictwo.12");
    boolean rolnictwo11 = playerData.getBoolean("rolnictwo.11");
    boolean rolnictwo13 = playerData.getBoolean("rolnictwo13");
    boolean rolnictwo14 = playerData.getBoolean("rolnictwo.14");
        if(e.getBlock().getState().getBlockData() instanceof Crops && ((Crops) e.getBlock().getState().getData()).getState() == CropState.RIPE) {

            if (blockus == Material.BEETROOTS) {
                if (!rolnictwo11){
                    e.setCancelled(true);
                    player.sendMessage("§4Mordeczko masz zbyt niski level rolnictwa! Wbij level 1.1");
                }
                else {
                if (doswiadczenie41) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 60);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 60 punktów rolnictwa");
                } else if (doswiadczenie31) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 50);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 50 punktów rolnictwa");
                } else if (doswiadczenie21) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 40);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów rolnictwa");
                } else if (doswiadczenie11) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 30);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 30 punktów rolnictwa");
                } else {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 20);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów rolnictwa");
                }
                if (level41) {
                    player.setTotalExperience(exp + 20);
                } else if (level31) {
                    player.setTotalExperience(exp + 10);
                } else if (level21) {
                    player.setTotalExperience(exp + 7);
                } else if (level11) {
                    player.setTotalExperience(exp + 5);
                }
                if (poziom41) {
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(4);
                    drop.setType(Material.BEETROOTS);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom31) {
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(3);
                    drop.setType(Material.BEETROOTS);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom21) {
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(2);
                    drop.setType(Material.BEETROOTS);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom11) {
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(1);
                    drop.setType(Material.BEETROOTS);
                    world.dropItem(lokalizacja, drop);
                }
            }}
            if (blockus == Material.POTATOES) {
                if (!rolnictwo13){
                    e.setCancelled(true);
                    player.sendMessage("§4Mordeczko masz zbyt niski level rolnictwa! Wbij level 1.3");
                }
                else {
                    if (doswiadczenie41) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 65);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 65 punktów rolnictwa");
                    } else if (doswiadczenie31) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 40);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów rolnictwa");
                    } else if (doswiadczenie21) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 30);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 30 punktów rolnictwa");
                    } else if (doswiadczenie11) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 20);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów rolnictwa");
                    } else {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 10);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów rolnictwa");
                    }
                    if (level41) {
                        player.setTotalExperience(exp + 20);
                    } else if (level31) {
                        player.setTotalExperience(exp + 10);
                    } else if (level21) {
                        player.setTotalExperience(exp + 7);
                    } else if (level11) {
                        player.setTotalExperience(exp + 5);
                    }
                    if (poziom41) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(4);
                        drop.setType(Material.POTATOES);
                        world.dropItem(lokalizacja, drop);
                    } else if (poziom31) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(3);
                        drop.setType(Material.POTATOES);
                        world.dropItem(lokalizacja, drop);
                    } else if (poziom21) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(2);
                        drop.setType(Material.POTATOES);
                        world.dropItem(lokalizacja, drop);
                    } else if (poziom11) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(1);
                        drop.setType(Material.POTATOES);
                        world.dropItem(lokalizacja, drop);
                    }
                }}
            if (blockus == Material.CARROTS) {
                if (!rolnictwo12) {
                    e.setCancelled(true);
                    player.sendMessage("§4Mordeczko masz zbyt niski level rolnictwa! Wbij level 1.2");
                } else {
                    if (doswiadczenie41) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 21);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 21 punktów rolnictwa");
                    } else if (doswiadczenie31) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 17);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 17 punktów rolnictwa");
                    } else if (doswiadczenie21) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 13);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 13 punktów rolnictwa");
                    } else if (doswiadczenie11) {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 9);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 9 punktów rolnictwa");
                    } else {
                        playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 8);
                        player.sendMessage("§a Gratulacje! Zdobyłeś 8 punktów rolnictwa");
                    }
                    if (level41) {
                        player.setTotalExperience(exp + 30);
                    } else if (level31) {
                        player.setTotalExperience(exp + 20);
                    } else if (level21) {
                        player.setTotalExperience(exp + 10);
                    } else if (level11) {
                        player.setTotalExperience(exp + 5);
                    }
                    if (poziom41) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(8);
                        drop.setType(Material.CARROT);
                        world.dropItem(lokalizacja, drop);
                    } else if (poziom31) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(6);
                        drop.setType(Material.CARROT);
                        world.dropItem(lokalizacja, drop);
                    } else if (poziom21) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(4);
                        drop.setType(Material.CARROT);
                        world.dropItem(lokalizacja, drop);
                    } else if (poziom11) {
                        ItemStack drop = new ItemStack(block.getType());
                        drop.setAmount(2);
                        drop.setType(Material.CARROT);
                        world.dropItem(lokalizacja, drop);
                    }
                }
            }

            if (blockus == Material.WHEAT | blockus == Material.COCOA) {
                if (doswiadczenie41) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 5);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 5 punktów rolnictwa");
                } else if (doswiadczenie31) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 4);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 4 punktów rolnictwa");
                } else if (doswiadczenie21) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 3);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 3 punktów rolnictwa");
                } else if (doswiadczenie11) {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 2);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 2 punktów rolnictwa");
                } else {
                    playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 1);
                    player.sendMessage("§a Gratulacje! Zdobyłeś 1 punktów rolnictwa");
                }
                if (poziom41) {
                    ItemStack is = new ItemStack(block.getType());
                    block.getDrops(is).clear();
                    is.setAmount(4);
                    world.dropItem(lokalizacja, is);
                } else if (poziom31) {
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(3);
                    drop.setType(blockus);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom21) {
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(2);
                    drop.setType(blockus);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom11) {
                    ItemStack drop = new ItemStack(block.getType());
                    drop.setAmount(1);
                    drop.setType(blockus);
                    world.dropItem(lokalizacja, drop);
                }
            }
        }
    if (blockus == Material.MELON) {
        if (!rolnictwo14){
            e.setCancelled(true);
            player.sendMessage("§4Mordeczko masz zbyt niski level rolnictwa! Wbij level 1.4");
        }
        else{
        if (doswiadczenie41) {
            playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 80);
            player.sendMessage("§a Gratulacje! Zdobyłeś 80 punktów rolnictwa");
        } else if (doswiadczenie31) {
            playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 60);
            player.sendMessage("§a Gratulacje! Zdobyłeś 60 punktów rolnictwa");
        } else if (doswiadczenie21) {
            playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 40);
            player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów rolnictwa");
        } else if (doswiadczenie11) {
            playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 20);
            player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów rolnictwa");
        } else {
            playerData.set("rolnictwo.punkty", playerData.getInt("rolnictwo.punkty") + 10);
            player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów rolnictwa");
        }
        if (level41) {
            player.setTotalExperience(exp + 40);
        } else if (level31) {
            player.setTotalExperience(exp + 30);
        } else if (level21) {
            player.setTotalExperience(exp + 20);
        } else if (level11) {
            player.setTotalExperience(exp + 10);
        }
        if (poziom41) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(8);
            drop.setType(Material.MELON_SLICE);
            world.dropItem(lokalizacja, drop);
        } else if (poziom31) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(6);
            drop.setType(Material.MELON_SLICE);
            world.dropItem(lokalizacja, drop);
        } else if (poziom21) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(4);
            drop.setType(Material.MELON_SLICE);
            world.dropItem(lokalizacja, drop);
        } else if (poziom11) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(2);
            drop.setType(Material.MELON_SLICE);
            world.dropItem(lokalizacja, drop);
        }
    }
    }
    if (block.getType() == Material.DIAMOND_ORE | block.getType() == Material.DEEPSLATE_DIAMOND_ORE) {
        if (!gornik) {
            e.setCancelled(true);
            player.sendMessage("§4Mordeczko masz zbyt niski level górnictwa! Wbij level 1.4");
        } else {
            if (doswiadczenie4) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 80);
            player.sendMessage("§a Gratulacje! Zdobyłeś 80 punktów górnictwa");
        } else if (doswiadczenie3) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 60);
            player.sendMessage("§a Gratulacje! Zdobyłeś 60 punktów górnictwa");
        } else if (doswiadczenie2) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 40);
            player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów górnictwa");
        } else if (doswiadczenie1) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 20);
            player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów górnictwa");
        } else {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 10);
            player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów górnictwa");
        }
        if (poziom4) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(4);
            drop.setType(Material.DIAMOND);
            world.dropItem(lokalizacja, drop);
        } else if (poziom3) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(3);
            drop.setType(Material.DIAMOND);
            world.dropItem(lokalizacja, drop);
        } else if (poziom2) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(2);
            drop.setType(Material.DIAMOND);
            world.dropItem(lokalizacja, drop);
        } else if (poziom1) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(1);
            drop.setType(Material.DIAMOND);
            world.dropItem(lokalizacja, drop);

        }
        if (level4) {
            player.setTotalExperience(exp + 56);
        } else if (level3) {
            player.setTotalExperience(exp + 42);
        } else if (level2) {
            player.setTotalExperience(exp + 28);
        } else if (level1) {
            player.setTotalExperience(exp + 14);
        }

    }}
    if (block.getType() == Material.GOLD_ORE | block.getType() == Material.DEEPSLATE_GOLD_ORE) {
        if (!gornik2) {
            e.setCancelled(true);
            player.sendMessage("§4Mordeczko masz zbyt niski level górnictwa! Wbij level 1.3");
        } else{
            if (doswiadczenie4) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 40);
            player.sendMessage("§a Gratulacje! Zdobyłeś 40 punktów górnictwa");
        } else if (doswiadczenie3) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 30);
            player.sendMessage("§a Gratulacje! Zdobyłeś 30 punktów górnictwa");
        } else if (doswiadczenie2) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 20);
            player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów górnictwa");
        } else if (doswiadczenie1) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 10);
            player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów górnictwa");
        } else {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 5);
            player.sendMessage("§a Gratulacje! Zdobyłeś 5 punktów górnictwa");
        }
        if (poziom4) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(4);
            drop.setType(Material.RAW_GOLD);
            world.dropItem(lokalizacja, drop);
        } else if (poziom3) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(3);
            drop.setType(Material.RAW_GOLD);
            world.dropItem(lokalizacja, drop);
        } else if (poziom2) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(2);
            drop.setType(Material.RAW_GOLD);
            world.dropItem(lokalizacja, drop);
        } else if (poziom1) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(1);
            drop.setType(Material.RAW_GOLD);
            world.dropItem(lokalizacja, drop);

        }
        if (level4) {
            player.setTotalExperience(exp + 10);
        } else if (level3) {
            player.setTotalExperience(exp + 6);
        } else if (level2) {
            player.setTotalExperience(exp + 2);
        } else if (level1) {
            player.setTotalExperience(exp + 1);
        }

    }}
    if (block.getType() == Material.IRON_ORE | block.getType() == Material.DEEPSLATE_IRON_ORE) {
        if (!gornik3) {
            e.setCancelled(true);
            player.sendMessage("§4Mordeczko masz zbyt niski level górnictwa! Wbij level 1.2");
        } else {
            if (doswiadczenie4) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 30);
            player.sendMessage("§a Gratulacje! Zdobyłeś 30 punktów górnictwa");
        } else if (doswiadczenie3) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 25);
            player.sendMessage("§a Gratulacje! Zdobyłeś 25 punktów górnictwa");
        } else if (doswiadczenie2) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 20);
            player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów górnictwa");
        } else if (doswiadczenie1) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 15);
            player.sendMessage("§a Gratulacje! Zdobyłeś 15 punktów górnictwa");
        } else {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 10);
            player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów górnictwa");
        }
        if (poziom4) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(4);
            drop.setType(Material.RAW_IRON);
            world.dropItem(lokalizacja, drop);
        } else if (poziom3) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(3);
            drop.setType(Material.RAW_IRON);
            world.dropItem(lokalizacja, drop);
        } else if (poziom2) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(2);
            drop.setType(Material.RAW_IRON);
            world.dropItem(lokalizacja, drop);
        } else if (poziom1) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(1);
            drop.setType(Material.RAW_IRON);
            world.dropItem(lokalizacja, drop);

        }
        if (level4) {
            player.setTotalExperience(exp + 5);
        } else if (level3) {
            player.setTotalExperience(exp + 3);
        } else if (level2) {
            player.setTotalExperience(exp + 2);
        } else if (level1) {
            player.setTotalExperience(exp + 1);
        }

    }}
    if (block.getType() == Material.COAL_ORE | block.getType() == Material.DEEPSLATE_COAL_ORE) {
        if (!gornik4) {
            e.setCancelled(true);
            player.sendMessage("§4Mordeczko masz zbyt niski level górnictwa! Wbij level 1.1");
        } else {
            if (doswiadczenie4) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 20);
            player.sendMessage("§a Gratulacje! Zdobyłeś 20 punktów górnictwa");
        } else if (doswiadczenie3) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 15);
            player.sendMessage("§a Gratulacje! Zdobyłeś 15 punktów górnictwa");
        } else if (doswiadczenie2) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 10);
            player.sendMessage("§a Gratulacje! Zdobyłeś 10 punktów górnictwa");
        } else if (doswiadczenie1) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 8);
            player.sendMessage("§a Gratulacje! Zdobyłeś 8 punktów górnictwa");
        } else {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 5);
            player.sendMessage("§a Gratulacje! Zdobyłeś 5 punktów górnictwa");
        }
        if (poziom4) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(4);
            drop.setType(Material.COAL);
            world.dropItem(lokalizacja, drop);
        } else if (poziom3) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(3);
            drop.setType(Material.COAL);
            world.dropItem(lokalizacja, drop);
        } else if (poziom2) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(2);
            drop.setType(Material.COAL);
            world.dropItem(lokalizacja, drop);
        } else if (poziom1) {
            ItemStack drop = new ItemStack(block.getType());
            drop.setAmount(1);
            drop.setType(Material.COAL);
            world.dropItem(lokalizacja, drop);

        }
        if (level4) {
            player.setTotalExperience(exp + 15);
        } else if (level3) {
            player.setTotalExperience(exp + 10);
        } else if (level2) {
            player.setTotalExperience(exp + 5);
        } else if (level1) {
            player.setTotalExperience(exp + 3);
        }

    }}



    if (blockus == Material.STONE|blockus == Material.DEEPSLATE|blockus == Material.REDSTONE_ORE| blockus == Material.DEEPSLATE_REDSTONE_ORE | blockus == Material.COPPER_ORE| blockus == Material.DEEPSLATE_COPPER_ORE | blockus == Material.GRANITE| blockus == Material.DIORITE| blockus == Material.ANDESITE|blockus == Material.TUFF) {
        if (doswiadczenie4) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 5);
            player.sendMessage("§a Gratulacje! Zdobyłeś 5 punktów górnictwa");
        } else if (doswiadczenie3) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 4);
            player.sendMessage("§a Gratulacje! Zdobyłeś 4 punktów górnictwa");
        } else if (doswiadczenie2) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 3);
            player.sendMessage("§a Gratulacje! Zdobyłeś 3 punktów górnictwa");
        } else if (doswiadczenie1) {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 2);
            player.sendMessage("§a Gratulacje! Zdobyłeś 2 punktów górnictwa");
        } else {
            playerData.set("gornictwo.punkty", playerData.getInt("gornictwo.punkty") + 1);
            player.sendMessage("§a Gratulacje! Zdobyłeś 1 punktów górnictwa");
        }
        if (blockus == Material.STONE) {
            if (poziom4) {
                ItemStack drop = new ItemStack(Material.COBBLESTONE);
                drop.setAmount(4);
                drop.setType(Material.COBBLESTONE);
                world.dropItem(lokalizacja, drop);
            } else if (poziom3) {
                ItemStack drop = new ItemStack(Material.COBBLESTONE);
                drop.setAmount(3);
                drop.setType(Material.COBBLESTONE);
                world.dropItem(lokalizacja, drop);
            } else if (poziom2) {
                ItemStack drop = new ItemStack(Material.COBBLESTONE);
                drop.setAmount(2);
                drop.setType(Material.COBBLESTONE);
                world.dropItem(lokalizacja, drop);
            } else if (poziom1) {
                ItemStack drop = new ItemStack(Material.COBBLESTONE);
                drop.setAmount(1);
                drop.setType(Material.COBBLESTONE);
                world.dropItem(lokalizacja, drop);
            }
        } else if (blockus == Material.REDSTONE_ORE | blockus == Material.DEEPSLATE_REDSTONE_ORE){
            if (poziom4) {
                ItemStack drop = new ItemStack(Material.REDSTONE);
                drop.setAmount(4);
                drop.setType(Material.REDSTONE);
                world.dropItem(lokalizacja, drop);
            } else if (poziom3) {
                ItemStack drop = new ItemStack(Material.REDSTONE);
                drop.setAmount(3);
                drop.setType(Material.REDSTONE);
                world.dropItem(lokalizacja, drop);
            } else if (poziom2) {
                ItemStack drop = new ItemStack(Material.REDSTONE);
                drop.setAmount(2);
                drop.setType(Material.REDSTONE);
                world.dropItem(lokalizacja, drop);
            } else if (poziom1) {
                ItemStack drop = new ItemStack(Material.REDSTONE);
                drop.setAmount(1);
                drop.setType(Material.REDSTONE);
                world.dropItem(lokalizacja, drop);
            }
        } else if (blockus == Material.COPPER_ORE | blockus == Material.DEEPSLATE_COPPER_ORE) {
            if (poziom4) {
                ItemStack drop = new ItemStack(Material.RAW_COPPER);
                drop.setAmount(4);
                drop.setType(Material.RAW_COPPER);
                world.dropItem(lokalizacja, drop);
            } else if (poziom3) {
                ItemStack drop = new ItemStack(Material.RAW_COPPER);
                drop.setAmount(3);
                drop.setType(Material.RAW_COPPER);
                world.dropItem(lokalizacja, drop);
            } else if (poziom2) {
                ItemStack drop = new ItemStack(Material.RAW_COPPER);
                drop.setAmount(2);
                drop.setType(Material.RAW_COPPER);
                world.dropItem(lokalizacja, drop);
            } else if (poziom1) {
                ItemStack drop = new ItemStack(Material.RAW_COPPER);
                drop.setAmount(1);
                drop.setType(Material.RAW_COPPER);
                world.dropItem(lokalizacja, drop);
            }
        }else if (blockus == Material.DEEPSLATE) {
                if (poziom4) {
                    ItemStack drop = new ItemStack(Material.COBBLED_DEEPSLATE);
                    drop.setAmount(4);
                    drop.setType(Material.COBBLED_DEEPSLATE);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom3) {
                    ItemStack drop = new ItemStack(Material.COBBLED_DEEPSLATE);
                    drop.setAmount(3);
                    drop.setType(Material.COBBLED_DEEPSLATE);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom2) {
                    ItemStack drop = new ItemStack(Material.COBBLED_DEEPSLATE);
                    drop.setAmount(2);
                    drop.setType(Material.COBBLED_DEEPSLATE);
                    world.dropItem(lokalizacja, drop);
                } else if (poziom1) {
                    ItemStack drop = new ItemStack(Material.COBBLED_DEEPSLATE);
                    drop.setAmount(1);
                    drop.setType(Material.COBBLED_DEEPSLATE);
                    world.dropItem(lokalizacja, drop);
                }
        } else {
            if (poziom4) {
                ItemStack drop = new ItemStack(block.getType());
                drop.setAmount(4);
                drop.setType(blockus);
                world.dropItem(lokalizacja, drop);
            } else if (poziom3) {
                ItemStack drop = new ItemStack(block.getType());
                drop.setAmount(3);
                drop.setType(blockus);
                world.dropItem(lokalizacja, drop);
            } else if (poziom2) {
                ItemStack drop = new ItemStack(block.getType());
                drop.setAmount(2);
                drop.setType(blockus);
                world.dropItem(lokalizacja, drop);
            } else if (poziom1) {
                ItemStack drop = new ItemStack(block.getType());
                drop.setAmount(1);
                drop.setType(blockus);
                world.dropItem(lokalizacja, drop);
            }
        }
    }

    try {
        playerData.save(playerFile);
    } catch (Exception e1) {

        Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
        e1.printStackTrace();
    }
}

@EventHandler
public void onEnchant(EnchantItemEvent e) {

    Player player = e.getEnchanter();
    File playerFile = getPlayerFile(player.getName());
    FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);

    try {
        playerData.save(playerFile);
    } catch (IOException e1) {
        Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
        e1.printStackTrace();
    }
    int exp = e.getExpLevelCost();
    boolean zaklinacz1 = playerData.getBoolean("zaklinanie.11");
    boolean zaklinacz2 = playerData.getBoolean("zaklinanie.12");
    boolean zaklinacz3 = playerData.getBoolean("zaklinanie.13");
    boolean zaklinacz4 = playerData.getBoolean("zaklinanie.14");
    boolean punkty1 = playerData.getBoolean("zaklinanie.21");
    boolean punkty2 = playerData.getBoolean("zaklinanie.22");
    boolean punkty3 = playerData.getBoolean("zaklinanie.23");
    boolean punkty4 = playerData.getBoolean("zaklinanie.24");
    boolean exp1 = playerData.getBoolean("zaklinanie.31");
    boolean exp2 = playerData.getBoolean("zaklinanie.32");
    boolean exp3 = playerData.getBoolean("zaklinanie.33");
    boolean exp4 = playerData.getBoolean("zaklinanie.34");
    boolean drop1 = playerData.getBoolean("zaklinanie.41");
    boolean drop2 = playerData.getBoolean("zaklinanie.42");
    boolean drop3 = playerData.getBoolean("zaklinanie.43");
    boolean drop4 = playerData.getBoolean("zaklinanie.44");
    int poziom = player.getTotalExperience();
    if (exp >= 27) {
        if (!zaklinacz4) {
            e.setCancelled(true);
            player.sendMessage("§4 Mordeczko masz zbyt niski level zaklinania! Wbij level 1.4");
        } else if (punkty4) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 800);
            player.sendMessage("§a Gratulacje! Zdobyłeś 800 punktów zaklinania");
        } else if (punkty3) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 600);
            player.sendMessage("§a Gratulacje! Zdobyłeś 600 punktów zaklinania");
        } else if (punkty2) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 400);
            player.sendMessage("§a Gratulacje! Zdobyłeś 400 punktów zaklinania");
        } else if (punkty1) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 200);
            player.sendMessage("§a Gratulacje! Zdobyłeś 200 punktów zaklinania");
        } else {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 100);
            player.sendMessage("§a Gratulacje! Zdobyłeś 100 punktów zaklinania");
        }
        if (drop4) {
            e.setExpLevelCost(15);
        } else if (drop3) {
            e.setExpLevelCost(18);
        } else if (drop2) {
            e.setExpLevelCost(24);
        } else if (drop1) {
            e.setExpLevelCost(26);

        }
        if (exp4) {
            player.setTotalExperience(poziom + 56);
        } else if (exp3) {
            player.setTotalExperience(poziom + 42);
        } else if (exp2) {
            player.setTotalExperience(poziom + 28);
        } else if (exp1) {
            player.setTotalExperience(poziom + 14);
        }
    }
    if (exp >= 23 & exp < 27) {
        if (!zaklinacz3) {
            e.setCancelled(true);
            player.sendMessage("§4 Mordeczko masz zbyt niski level zaklinania! Wbij level 1.4");
        } else if (punkty4) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 700);
            player.sendMessage("§a Gratulacje! Zdobyłeś 700 punktów zaklinania");
        } else if (punkty3) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 500);
            player.sendMessage("§a Gratulacje! Zdobyłeś 500 punktów zaklinania");
        } else if (punkty2) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 300);
            player.sendMessage("§a Gratulacje! Zdobyłeś 300 punktów zaklinania");
        } else if (punkty1) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 100);
            player.sendMessage("§a Gratulacje! Zdobyłeś 100 punktów zaklinania");
        } else {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 50);
            player.sendMessage("§a Gratulacje! Zdobyłeś 50 punktów zaklinania");
        }
        if (drop4) {
            e.setExpLevelCost(10);
        } else if (drop3) {
            e.setExpLevelCost(14);
        } else if (drop2) {
            e.setExpLevelCost(18);
        } else if (drop1) {
            e.setExpLevelCost(20);

        }
        if (exp4) {
            player.setTotalExperience(poziom + 40);
        } else if (exp3) {
            player.setTotalExperience(poziom + 30);
        } else if (exp2) {
            player.setTotalExperience(poziom + 20);
        } else if (exp1) {
            player.setTotalExperience(poziom + 10);
        }
    }
    if (exp >= 15 & exp <23) {
        if (!zaklinacz2) {
            e.setCancelled(true);
            player.sendMessage("§4 Mordeczko masz zbyt niski level zaklinania! Wbij level 1.2");
        } else if (punkty4) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 500);
            player.sendMessage("§a Gratulacje! Zdobyłeś 500 punktów zaklinania");
        } else if (punkty3) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 400);
            player.sendMessage("§a Gratulacje! Zdobyłeś 400 punktów zaklinania");
        } else if (punkty2) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 200);
            player.sendMessage("§a Gratulacje! Zdobyłeś 200 punktów zaklinania");
        } else if (punkty1) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 90);
            player.sendMessage("§a Gratulacje! Zdobyłeś 90 punktów zaklinania");
        } else {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 30);
            player.sendMessage("§a Gratulacje! Zdobyłeś 30 punktów zaklinania");
        }
        if (drop4) {
            e.setExpLevelCost(5);
        } else if (drop3) {
            e.setExpLevelCost(9);
        } else if (drop2) {
            e.setExpLevelCost(12);
        } else if (drop1) {
            e.setExpLevelCost(14);

        }
        if (exp4) {
            player.setTotalExperience(poziom + 30);
        } else if (exp3) {
            player.setTotalExperience(poziom + 25);
        } else if (exp2) {
            player.setTotalExperience(poziom + 20);
        } else if (exp1) {
            player.setTotalExperience(poziom + 10);
        }
    }
    if (exp >= 10 & exp < 15) {
        if (!zaklinacz1) {
            e.setCancelled(true);
            player.sendMessage("§4 Mordeczko masz zbyt niski level zaklinania! Wbij level 1.1");
        } else if (punkty4) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 400);
            player.sendMessage("§a Gratulacje! Zdobyłeś 400 punktów zaklinania");
        } else if (punkty3) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 300);
            player.sendMessage("§a Gratulacje! Zdobyłeś 300 punktów zaklinania");
        } else if (punkty2) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 200);
            player.sendMessage("§a Gratulacje! Zdobyłeś 200 punktów zaklinania");
        } else if (punkty1) {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 100);
            player.sendMessage("§a Gratulacje! Zdobyłeś 100 punktów zaklinania");
        } else {
            playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + 50);
            player.sendMessage("§a Gratulacje! Zdobyłeś 50 punktów zaklinania");
        }
        if (drop4) {
            e.setExpLevelCost(2);
        } else if (drop3) {
            e.setExpLevelCost(5);
        } else if (drop2) {
            e.setExpLevelCost(7);
        } else if (drop1) {
            e.setExpLevelCost(8);

        }
        if (exp4) {
            player.setTotalExperience(poziom + 10);
        } else if (exp3) {
            player.setTotalExperience(poziom + 8);
        } else if (exp2) {
            player.setTotalExperience(poziom + 6);
        } else if (exp1) {
            player.setTotalExperience(poziom + 4);
        }
    }
    if (exp < 10){
    if (punkty4) {
        playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + exp * 4);
        player.sendMessage("§a Gratulacje! Zdobyłeś" + exp * 4 + "punktów zaklinania");
    } else if (punkty3) {
        playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + exp * 3);
        player.sendMessage("§a Gratulacje! Zdobyłeś" + exp * 3 + "punktów zaklinania");
    } else if (punkty2) {
        playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + exp * 2);
        player.sendMessage("§a Gratulacje! Zdobyłeś" + exp * 2 + "punktów zaklinania");
    } else if (punkty1) {
        playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + exp);
        player.sendMessage("§a Gratulacje! Zdobyłeś" + exp + "punktów zaklinania");
    } else {
        playerData.set("zaklinanie.punkty", playerData.getInt("zaklinanie.punkty") + exp * 0.5);
        player.sendMessage("§a Gratulacje! Zdobyłeś" + exp * 0.5 + "punktów zaklinania");
    }
    if (drop4) {
        e.setExpLevelCost(exp - 8);
    } else if (drop3) {
        e.setExpLevelCost(exp - 6);
    } else if (drop2) {
        e.setExpLevelCost(exp - 4);
    } else if (drop1) {
        e.setExpLevelCost(exp - 2);
    }
    try {
        playerData.save(playerFile);
    } catch (Exception e1) {

        Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
        e1.printStackTrace();
    }
}}
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Plugin plugin = Michalowicepoziomy.getPlugin(Michalowicepoziomy.class);
        plugin.saveConfig();

    }}

