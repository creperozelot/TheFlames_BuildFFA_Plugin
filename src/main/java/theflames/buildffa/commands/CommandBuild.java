package theflames.buildffa.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.StaticCache;

public class CommandBuild implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!StaticCache.buildmode) {
                player.sendMessage(StaticCache.prefix + "§lBitte führe diesen Befehl nur auf einem Server aus der sich im Wartungsmodus befindet!");
                Bukkit.broadcastMessage(StaticCache.prefix + "§aBau-Modus Aktiviert!");
                StaticCache.buildmode = true;
            } else {
                Bukkit.broadcastMessage(StaticCache.prefix + "§aBau-Modus §cDeaktiviert§a!");
                StaticCache.buildmode = false;
            }

        } else {
            sender.sendMessage("§cDu Kannst diesen Befehl nur als Spieler ausführen!");
        }
        return true;
    }
}
