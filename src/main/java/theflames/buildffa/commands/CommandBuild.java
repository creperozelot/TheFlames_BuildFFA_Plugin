package theflames.buildffa.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.StaticCache;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommandBuild implements CommandExecutor {

    public static List<UUID> buildmodelist = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (buildmodelist.contains(player.getUniqueId())) {
                player.sendMessage(StaticCache.prefix + "§aBau-Modus §cDeaktiviert!");
                buildmodelist.remove(player.getUniqueId());
            } else {
                player.sendMessage(StaticCache.prefix + "§aBau-Modus Aktiviert!");
                buildmodelist.add(player.getUniqueId());
            }

        } else {
            sender.sendMessage("§cDu Kannst diesen Befehl nur als Spieler ausführen!");
        }
        return true;
    }
}
