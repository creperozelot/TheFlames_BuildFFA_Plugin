package theflames.buildffa.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import theflames.buildffa.Buildffa;

public class EntityDamageListener implements Listener {

    //disable falldamage
    @EventHandler
    public static void onEntityDamage(EntityDamageEvent event) {
        if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL))
            event.setCancelled(true);
    }

    //teleport to spawn is player under deathheight
    @EventHandler
    public static void onPlayerDamagaOverArenaHeight(EntityDamageEvent event) {
        Player player = (Player) event.getEntity();
        if (player.getHeight() >= Buildffa.getInstance().getConfig().getInt("map.arenaheight")) {
            event.setCancelled(true);
        }
    }
}
