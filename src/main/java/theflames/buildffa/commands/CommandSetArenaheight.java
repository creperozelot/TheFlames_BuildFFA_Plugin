package theflames.buildffa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;

public class CommandSetArenaheight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof  Player) {
            Player player = (Player) sender;
            int playerheight = (int) player.getLocation().getY();
            Buildffa.getInstance().getConfig().set("map.arenaheight", playerheight);
            Buildffa.getInstance().saveConfig();
            player.sendMessage(StaticCache.prefix + Buildffa.getInstance().getConfig().getString("message.command.deathheight").replace("{height}", Integer.toString(playerheight)));
        } else {
            sender.sendMessage("§cDu Kannst diesen Befehl nur als Spieler ausführen!");
        }
        return true;
    }
}
