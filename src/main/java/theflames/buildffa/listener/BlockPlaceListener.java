package theflames.buildffa.listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.ChunkPosition;
import net.minecraft.server.v1_8_R3.Position;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class BlockPlaceListener implements Listener  {
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent event) throws InvocationTargetException {
        if (!StaticCache.buildmode) {
            Player player = event.getPlayer();
            Block block = event.getBlock();

            ProtocolManager manager = ProtocolLibrary.getProtocolManager();
            PacketContainer packet = manager.createPacket(PacketType.Play.Server.BLOCK_BREAK_ANIMATION);

            packet.getPositionModifier().write(0 ,new ChunkPosition(event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ()));
            packet.getBytes().write(0, (byte) 5);
            packet.getIntegers().write(0, event.getPlayer().getEntityId() + 1);
            manager.sendServerPacket(player, packet);


        }



    }
}

