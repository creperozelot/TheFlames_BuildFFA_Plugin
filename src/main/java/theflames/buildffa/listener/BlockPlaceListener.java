package theflames.buildffa.listener;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;

public class BlockPlaceListener implements Listener  {
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent event) {
        if (!StaticCache.buildmode) {
            Player player = event.getPlayer();
            Block block = event.getBlock();

            (new BukkitRunnable() {
                public void run() {
                    block.setType(Material.STAINED_GLASS);
                }
            }).runTaskLater((Plugin) Buildffa.getInstance(), 140L);
            (new BukkitRunnable() {
                public void run() {
                    block.setType(Material.AIR);
                }
            }).runTaskLater((Plugin)Buildffa.getInstance(), 220L);

        }



    }
}

