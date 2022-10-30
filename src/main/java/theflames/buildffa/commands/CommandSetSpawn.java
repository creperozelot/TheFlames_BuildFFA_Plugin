package theflames.buildffa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;

public class CommandSetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Buildffa.getInstance().getConfig().set("spawn_x", player.getLocation().getX());
            Buildffa.getInstance().getConfig().set("spawn_y", player.getLocation().getY());
            Buildffa.getInstance().getConfig().set("spawn_z", player.getLocation().getZ());
            Buildffa.getInstance().saveConfig();
            player.sendMessage(StaticCache.prefix + "Du hast den Spawn auf §a" + player.getLocation() + "§6 gesetzt.");
        }
        return true;
    }
}
