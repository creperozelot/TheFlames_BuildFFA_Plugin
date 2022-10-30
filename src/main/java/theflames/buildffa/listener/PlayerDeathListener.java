package theflames.buildffa.listener;

import de.primeapi.primeplugins.spigotapi.api.plugins.coins.CoinsAPI;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent event) {
        Player player = (Player) event.getEntity();
        Player killer = player.getKiller();
        CoinsAPI coinsAPI = CoinsAPI.getInstance();
        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 1);
        int spawn_x = Buildffa.getInstance().getConfig().getInt("spawn_x");
        int spawn_y = Buildffa.getInstance().getConfig().getInt("spawn_y");
        int spawn_z = Buildffa.getInstance().getConfig().getInt("spawn_z");
        World spawn = Bukkit.getWorld(Buildffa.getInstance().getConfig().getString("world"));

        Location spawnpoint = new Location(spawn,spawn_x, spawn_y, spawn_z );
        //Set Coins
        int coins = CoinsAPI.getInstance().getCoins(player.getUniqueId()).complete();
        if (coins > Buildffa.getInstance().getConfig().getInt("coins.remove")) {
            int SetCoins = coins - Buildffa.getInstance().getConfig().getInt("coins.remove");
            coinsAPI.setCoins(player.getUniqueId(), SetCoins);
        }
        player.teleport(spawnpoint);

        //set killer coins
        int killercoins = CoinsAPI.getInstance().getCoins(killer.getUniqueId()).complete();
            coinsAPI.setCoins(killer.getUniqueId(), killercoins + Buildffa.getInstance().getConfig().getInt("coins.add"));
            killer.getInventory().addItem(enderpearl);

        //Send Messages
        event.setDeathMessage(StaticCache.prefix + "Der Spieler §f" + killer.getName() + "§66ist §cGestorben!");
        player.sendMessage(StaticCache.prefix + "Du hast §f20§6 Coins §cVerloren.");
        killer.sendMessage(StaticCache.prefix + "Du hast §f10§6 Coins §aBekommen.");

    }
}
