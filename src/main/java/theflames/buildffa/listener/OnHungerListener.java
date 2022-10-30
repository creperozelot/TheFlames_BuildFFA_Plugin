package theflames.buildffa.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OnHungerListener implements Listener {
    @EventHandler
    public void OnPlayerHunger(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        player.setFoodLevel(20);
    }
}
