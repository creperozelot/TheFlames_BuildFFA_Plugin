package theflames.buildffa.placeholderapi;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.lang.reflect.InvocationTargetException;

import static com.comphenix.protocol.PacketType.Play.Server.BLOCK_BREAK_ANIMATION;

public class PAPIAnimations {

    public static void blockBreakEffect(Player player, Vector vector, int step, int randId) {
        PacketContainer container = new PacketContainer(BLOCK_BREAK_ANIMATION);
        container.getBlockPositionModifier().write(0, new BlockPosition(vector));
        container.getIntegers()
                .write(0, randId)
                .write(1, step);
        execute(player, container);
    }
    static void execute(Player receiver, PacketContainer container) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(receiver, container);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
