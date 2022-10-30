//class name for other codes
package theflames.buildffa.listener;

//Import something to use in codes
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;

//Initial. Code for Class (Create Class for use
public class PlayerQuitListener implements Listener {

    //set listener (event action)
    @EventHandler
    public void OnPLayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        //set quit message
        event.setQuitMessage(StaticCache.prefix + Buildffa.getInstance().getConfig().getString("quit-message").replace("{player}", player.getDisplayName()));
    }
}
