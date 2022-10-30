package theflames.buildffa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;

public class CommandSetDeathheight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        int playerheight = (int) player.getLocation().getY();
        player.sendMessage(StaticCache.prefix + Buildffa.getInstance().getConfig().getString("message.command.deathheight").replace("{height}", Integer.toString(playerheight)));
        Buildffa.getInstance().getConfig().set("map.deathheight", playerheight);
        return true;
    }
}
