package theflames.buildffa.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerDropItemEvent implements Listener {
    @EventHandler
    public void PlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("tf.buildffa.build")) {
            event.setCancelled(true);
        }
    }
}
