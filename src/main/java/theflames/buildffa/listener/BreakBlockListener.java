package theflames.buildffa.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import theflames.buildffa.StaticCache;

public class BreakBlockListener implements Listener {
    @EventHandler
    public void OnBreakBlock(BlockBreakEvent event) {

        if (!StaticCache.buildmode) {
            event.setCancelled(true);
        }




    }
}
