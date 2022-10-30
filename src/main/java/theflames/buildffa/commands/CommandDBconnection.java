package theflames.buildffa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.Buildffa;
import theflames.buildffa.StaticCache;
import theflames.buildffa.utils.MYSQL;

import java.sql.DriverManager;
import java.sql.SQLData;
import java.sql.SQLException;

public class CommandDBconnection implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (MYSQL.isConnected()) {
            player.sendMessage(StaticCache.prefix + Buildffa.getInstance().getConfig().getString("message.command.mysql.connected"));
        } else {
            player.sendMessage(StaticCache.prefix + Buildffa.getInstance().getConfig().getString("message.command.mysql.not-connected"));
        }
        return true;
    }
}
