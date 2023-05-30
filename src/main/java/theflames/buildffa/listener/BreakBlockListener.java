package theflames.buildffa.listener;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import theflames.buildffa.commands.CommandBuild;

public class BreakBlockListener implements Listener {
    @EventHandler
    public void OnBreakBlock(BlockBreakEvent event) {

        Player player = event.getPlayer();


        if (!CommandBuild.buildmodelist.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }




    }
}
