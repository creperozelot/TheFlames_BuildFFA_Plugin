package theflames.buildffa.listener;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;
import theflames.buildffa.Buildffa;
import theflames.buildffa.commands.CommandBuild;
import theflames.buildffa.placeholderapi.PAPIAnimations;
import theflames.buildffa.utils.utils;


public class BlockPlaceListener implements Listener  {
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent event) {
        if (!CommandBuild.buildmodelist.contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();
            Block block = event.getBlock();

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 0, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 2);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 1, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 3);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 2, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 4);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 3, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 5);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 4, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 6);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 5, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 7);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 6, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 8);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 7, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 9);

            new BukkitRunnable() {
                @Override
                public void run() {
                    PAPIAnimations.blockBreakEffect(player, block.getLocation().toVector(), 8, utils.randomInt(0, 255));
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 10);


            new BukkitRunnable() {
                @Override
                public void run() {
                    block.setType(Material.AIR);
                }
            }.runTaskLater(Buildffa.getInstance(), 10 * 11);


        }



    }
}

