package theflames.buildffa.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import theflames.buildffa.Buildffa;
import theflames.buildffa.utils.MYSQL;
import theflames.buildffa.utils.playerutils;

import java.io.IOException;
import java.sql.SQLException;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void OnPlayerMove(PlayerMoveEvent event) throws IOException, SQLException {
        Player player = event.getPlayer();
        Location playerlocation = player.getLocation();
        World spawn = Bukkit.getWorld(Buildffa.getInstance().getConfig().getString("world"));
        int spawn_x = Buildffa.getInstance().getConfig().getInt("spawn_x");
        int spawn_y = Buildffa.getInstance().getConfig().getInt("spawn_y");
        int spawn_z = Buildffa.getInstance().getConfig().getInt("spawn_z");

        Location spawnpoint = new Location(spawn, spawn_x, spawn_y, spawn_z);

        //teleport to spawn is player under deathheight

        if (playerlocation.getY() <= Buildffa.getInstance().getConfig().getInt("map.deathheight") + 5) {
            playerutils.saveInventory(player);
        }

        if (playerlocation.getY() <= Buildffa.getInstance().getConfig().getInt("map.deathheight")) {
            player.getInventory().clear();
            player.teleport(spawnpoint);

            MYSQL.addDeath(player.getUniqueId().toString());
            MYSQL.addTempDeath(player.getUniqueId().toString());

            if (playerutils.hasInventoryData(player)) {
                playerutils.restoreInventory(player);
            } else {
                ItemStack stone_sword = new ItemStack(Material.STONE_SWORD);
                ItemStack iron_chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                ItemStack iron_helmet = new ItemStack(Material.IRON_HELMET);
                ItemStack iron_leggins = new ItemStack(Material.IRON_LEGGINGS);
                ItemStack iron_boots = new ItemStack(Material.IRON_BOOTS);
                ItemStack cobweb = new ItemStack(Material.WEB);
                ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
                ItemStack rod = new ItemStack(Material.FISHING_ROD);
                ItemStack sandstone1 = new ItemStack(Material.RED_SANDSTONE);
                ItemStack sandstone2 = new ItemStack(Material.RED_SANDSTONE);
                sandstone1.setAmount(64);
                sandstone2.setAmount(64);
                enderpearl.setAmount(2);
                cobweb.setAmount(4);

                player.getInventory().setItem(0, stone_sword);
                player.getInventory().setItem(38, iron_chestplate);
                player.getInventory().setItem(39, iron_helmet);
                player.getInventory().setItem(37, iron_leggins);
                player.getInventory().setItem(36, iron_boots);
                player.getInventory().setItem(1, rod);
                player.getInventory().setItem(2, sandstone1);
                player.getInventory().setItem(3, sandstone2);
                player.getInventory().setItem(4, enderpearl);
                player.getInventory().setItem(5, cobweb);
            }

        }
    }


}
