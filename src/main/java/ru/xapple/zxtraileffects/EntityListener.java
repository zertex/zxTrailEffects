package ru.xapple.zxtraileffects;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.xapple.zxtraileffects.lib.Functions;
import ru.xapple.zxtraileffects.lib.PlayerData;

import java.util.*;

/**
 * Created by Egorka on 10.10.2015.
 */
public class EntityListener implements Listener {

    public ArrayList<Entity> allitems = new ArrayList<Entity>();
    public ArrayList<ItemStack> allitemstacks = new ArrayList<ItemStack>();
    public HashMap<Player, ArrayList<Entity>> diamonds = new HashMap<Player, ArrayList<Entity>>();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        PlayerData pd = Functions.getPlayerDataByName(player.getName());
        if (pd != null) {

            if (pd.effect.equals("cloud")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().cloudMax, Main.get().cloudMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.CLOUD, player.getLocation(), random.nextInt(Main.get().cloudMax - Main.get().cloudMin + Main.get().cloudMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("smoke")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().smokeMax, Main.get().smokeMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.SMOKE_LARGE, player.getLocation(), random.nextInt(Main.get().smokeMax - Main.get().smokeMin + Main.get().smokeMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("smoke2")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().smoke2Max, Main.get().smoke2Min)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, player.getLocation(), random.nextInt(Main.get().smoke2Max - Main.get().smoke2Min + Main.get().smoke2Min) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("fire")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().fireMax, Main.get().fireMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), random.nextInt(Main.get().fireMax - Main.get().fireMin + Main.get().fireMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("fire2")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().fire2Max, Main.get().fire2Min)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, player.getLocation(), random.nextInt(Main.get().fire2Max - Main.get().fire2Min + Main.get().fire2Min) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("ender")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().enderMax, Main.get().enderMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), random.nextInt(Main.get().enderMax - Main.get().enderMin + Main.get().enderMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("heart")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().heartMax, Main.get().heartMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.HEART, player.getLocation(), random.nextInt(Main.get().heartMax - Main.get().heartMin + Main.get().heartMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("disco")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().discoMax, Main.get().discoMin)) {
                        Random random = new Random();
                        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.ORANGE, 1);
                        player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), random.nextInt(Main.get().discoMax - Main.get().discoMin + Main.get().discoMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F, dustOptions);
                        player.getWorld().spawnParticle(Particle.SPELL_MOB, player.getLocation(), random.nextInt(Main.get().discoMax - Main.get().discoMin + Main.get().discoMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("blood")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().heartMax, Main.get().heartMin)) {
                        Random random = new Random();
                        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 1);
                        player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), random.nextInt(Main.get().discoMax - Main.get().discoMin + Main.get().discoMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F, dustOptions);
                    }
                }
            }

            if (pd.effect.equals("crit")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().critMax, Main.get().critMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.CRIT, player.getLocation(), random.nextInt(Main.get().critMax - Main.get().critMin + Main.get().critMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("magma")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().magmaMax, Main.get().magmaMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.LAVA, player.getLocation(), random.nextInt(Main.get().magmaMax - Main.get().magmaMin + Main.get().magmaMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("letter")) {
                //if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().letterMax, Main.get().letterMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, player.getLocation(), random.nextInt(Main.get().letterMax - Main.get().letterMin + Main.get().letterMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                //}
            }

            if (pd.effect.equals("happy")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().happyMax, Main.get().happyMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation(), random.nextInt(Main.get().happyMax - Main.get().happyMin + Main.get().happyMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("anger")) {
                if (Math.random() < 0.25) {
                    if (!trailNegative(Main.get().angerMax, Main.get().angerMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, player.getLocation(), random.nextInt(Main.get().angerMax - Main.get().angerMin + Main.get().angerMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("music")) {
                if (Math.random() < 0.33) {
                    if (!trailNegative(Main.get().musicMax, Main.get().musicMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.NOTE, player.getLocation(), random.nextInt(Main.get().musicMax - Main.get().musicMin + Main.get().musicMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("magic")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().magicMax, Main.get().magicMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), random.nextInt(Main.get().magicMax - Main.get().magicMin + Main.get().magicMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                        player.getWorld().spawnParticle(Particle.SPELL_WITCH, player.getLocation(), random.nextInt(Main.get().magicMax - Main.get().magicMin + Main.get().magicMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("sweat")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().sweatMax, Main.get().sweatMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.WATER_SPLASH, player.getLocation(), random.nextInt(Main.get().sweatMax - Main.get().sweatMin + Main.get().sweatMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("spark")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().sparkMax, Main.get().sparkMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation(), random.nextInt(Main.get().sparkMax - Main.get().sparkMin + Main.get().sparkMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            if (pd.effect.equals("crumb")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().crumbMax, Main.get().crumbMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.DRIP_LAVA, player.getLocation(), random.nextInt(Main.get().crumbMax - Main.get().crumbMin + Main.get().crumbMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }

            /*if (pd.effect.equals("heart")) {
                if (Math.random() < 0.5) {
                    if (!trailNegative(Main.get().heartMax, Main.get().heartMin)) {
                        Random random = new Random();
                        player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, player.getLocation(), random.nextInt(Main.get().heartMax - Main.get().heartMin + Main.get().heartMin) + 1, random.nextFloat(), random.nextFloat(), random.nextFloat(), 0.01F);
                    }
                }
            }*/

            if (pd.effect.equals("star")) {
                if (Math.random() < 0.5) {
                    ItemStack star1 = new ItemStack(Material.NETHER_STAR);
                    ItemMeta starMeta = star1.getItemMeta();
                    starMeta.setDisplayName("Trail Loot");
                    star1.setItemMeta(starMeta);
                    Item item = player.getWorld().dropItem(event.getFrom(), star1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            item.remove();
                        }
                    }.runTaskLater(Main.get(), 100L);
                }
            }

            if (pd.effect.equals("flower")) {
                ItemStack f1 = new ItemStack(Material.LILAC);
                ItemMeta f1Meta = f1.getItemMeta();
                f1Meta.setDisplayName("Trail Loot");
                f1.setItemMeta(f1Meta);

                ItemStack f2 = new ItemStack(Material.RED_TULIP);
                ItemMeta f2Meta = f2.getItemMeta();
                f2Meta.setDisplayName("Trail Loot");
                f2.setItemMeta(f2Meta);

                ItemStack f3 = new ItemStack(Material.BLUE_ORCHID);
                ItemMeta f3Meta = f3.getItemMeta();
                f3Meta.setDisplayName("Trail Loot");
                f3.setItemMeta(f3Meta);

                ItemStack f4 = new ItemStack(Material.AZURE_BLUET);
                ItemMeta f4Meta = f4.getItemMeta();
                f4Meta.setDisplayName("Trail Loot");
                f4.setItemMeta(f4Meta);

                ItemStack f5 = new ItemStack(Material.WHITE_TULIP);
                ItemMeta f5Meta = f5.getItemMeta();
                f5Meta.setDisplayName("Trail Loot");
                f5.setItemMeta(f5Meta);

                ItemStack f6 = new ItemStack(Material.ORANGE_TULIP);
                ItemMeta f6Meta = f6.getItemMeta();
                f6Meta.setDisplayName("Trail Loot");
                f6.setItemMeta(f6Meta);

                ItemStack f7 = new ItemStack(Material.SUNFLOWER);
                ItemMeta f7Meta = f7.getItemMeta();
                f7Meta.setDisplayName("Trail Loot");
                f7.setItemMeta(f7Meta);

                ItemStack f8 = new ItemStack(Material.OXEYE_DAISY);
                ItemMeta f8Meta = f8.getItemMeta();
                f8Meta.setDisplayName("Trail Loot");
                f8.setItemMeta(f8Meta);

                ItemStack f9 = new ItemStack(Material.PEONY);
                ItemMeta f9Meta = f9.getItemMeta();
                f9Meta.setDisplayName("Trail Loot");
                f9.setItemMeta(f9Meta);

                ItemStack f10 = new ItemStack(Material.DANDELION);
                ItemMeta f10Meta = f10.getItemMeta();
                f10Meta.setDisplayName("Trail Loot");
                f10.setItemMeta(f10Meta);

                Random dropchance = new Random();
                int dropped = dropchance.nextInt(11);

                Item item;
                if (dropped == 1) {
                    item = player.getWorld().dropItem(event.getFrom(), f1);
                } else if (dropped == 2) {
                    item = player.getWorld().dropItem(event.getFrom(), f2);
                } else if (dropped == 3) {
                    item = player.getWorld().dropItem(event.getFrom(), f3);
                } else if (dropped == 4) {
                    item = player.getWorld().dropItem(event.getFrom(), f4);
                } else if (dropped == 5) {
                    item = player.getWorld().dropItem(event.getFrom(), f5);
                } else if (dropped == 6) {
                    item = player.getWorld().dropItem(event.getFrom(), f6);
                } else if (dropped == 7) {
                    item = player.getWorld().dropItem(event.getFrom(), f7);
                } else if (dropped == 8) {
                    item = player.getWorld().dropItem(event.getFrom(), f8);
                } else if (dropped == 9) {
                    item = player.getWorld().dropItem(event.getFrom(), f9);
                } else {
                    item = player.getWorld().dropItem(event.getFrom(), f10);
                }
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        item.remove();
                    }
                }.runTaskLater(Main.get(), 60L);
            }

            if (pd.effect.equals("diamond")) {
                ItemStack diamond1 = new ItemStack(Material.DIAMOND);
                ItemMeta diamondMeta = diamond1.getItemMeta();
                diamondMeta.setDisplayName("Trail Loot");
                diamond1.setItemMeta(diamondMeta);

                ItemStack gold1 = new ItemStack(Material.GOLD_INGOT);
                ItemMeta goldMeta = gold1.getItemMeta();
                goldMeta.setDisplayName("Trail Loot");
                gold1.setItemMeta(goldMeta);

                ItemStack emerald1 = new ItemStack(Material.EMERALD);
                ItemMeta emeraldMeta = emerald1.getItemMeta();
                emeraldMeta.setDisplayName("Trail Loot");
                emerald1.setItemMeta(emeraldMeta);

                ItemStack iron1 = new ItemStack(Material.IRON_INGOT);
                ItemMeta ironMeta = iron1.getItemMeta();
                ironMeta.setDisplayName("Trail Loot");
                iron1.setItemMeta(ironMeta);

                Random dropchance = new Random();
                int dropped = dropchance.nextInt(5);

                Item item;
                if (dropped == 1) {
                    item = player.getWorld().dropItem(event.getFrom(), diamond1);
                } else if (dropped == 2) {
                    item = player.getWorld().dropItem(event.getFrom(), gold1);
                } else if (dropped == 3) {
                    item = player.getWorld().dropItem(event.getFrom(), iron1);
                } else {
                    item = player.getWorld().dropItem(event.getFrom(), emerald1);
                }
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        item.remove();
                    }
                }.runTaskLater(Main.get(), 60L);
            }

        }
    }

    public Boolean trailNegative(int max, int min) {
        return (max - min <= 0);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Functions.JoinPlayer(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (this.diamonds.containsKey(player)) {
            Iterator<Entity> it = ((ArrayList)this.diamonds.get(player)).iterator();
            while (it.hasNext()) {
                Entity removed = it.next();
                removed.remove();
            }
        }

        Functions.LeavePlayer(player);
    }

    @EventHandler
    public void onPlayerPickupItem(EntityPickupItemEvent event) {
        Item item = event.getItem();
        ItemMeta meta = item.getItemStack().getItemMeta();
        if (meta.getDisplayName().equals("Trail Loot")) {
            event.setCancelled(true);
        }
    }

    public void EntityDeathEvent(EntityDeathEvent event) {
        List<ItemStack> drops = event.getDrops();
        for (ItemStack drop : drops) {
            ItemMeta meta = drop.getItemMeta();
            if (meta.getDisplayName().equals("Trail Loot")) {
                drop.setAmount(0);
            }
        }
    }

    @EventHandler
    public void HopperPickup(InventoryPickupItemEvent event) {
        Item item = event.getItem();
        ItemMeta meta = item.getItemStack().getItemMeta();
        if (meta.getDisplayName().equals("Trail Loot")) {
            event.setCancelled(true);
        }
    }
}
