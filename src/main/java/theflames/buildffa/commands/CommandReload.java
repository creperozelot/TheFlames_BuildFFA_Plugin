package theflames.buildffa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.Buildffa;

public class CommandReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(Buildffa.getInstance().getConfig().getString("message.command.configreload"));
            Buildffa.getInstance().reloadConfig();
            player.sendMessage(Buildffa.getInstance().getConfig().getString("message.command.configreloadsuccess"));
        } else {
            sender.sendMessage("§cDu Kannst diesen Befehl nur als Spieler ausführen!");
        }
        return true;
    }
}
