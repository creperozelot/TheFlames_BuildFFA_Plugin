package theflames.buildffa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.Buildffa;
import theflames.buildffa.utils.MYSQL;

import java.sql.*;

public class DevCommandMySQLgetKills implements CommandExecutor {
    public static String host = Buildffa.getInstance().getConfig().getString("mysql.host");

    public static String port = Buildffa.getInstance().getConfig().getString("mysql.port");

    public static String database = Buildffa.getInstance().getConfig().getString("mysql.db");

    public static String username = Buildffa.getInstance().getConfig().getString("mysql.username");

    public static String password = Buildffa.getInstance().getConfig().getString("mysql.password");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);

                Statement stmt = conn.createStatement();

                stmt.executeQuery("SELECT * FROM `Stats` WHERE `UUID` = '" + player.getUniqueId() + "'");

                ResultSet resultSet = stmt.getResultSet();

                resultSet.first();

                int deaths = resultSet.getInt("DEATHS");

                player.sendMessage("Deine Kills sind " + deaths);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            sender.sendMessage("§cDu kannst diesen Command nur als Spieler ausführen...");
        }
        return true;
    }
}
