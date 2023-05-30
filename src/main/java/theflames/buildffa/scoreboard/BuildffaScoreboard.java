package theflames.buildffa.scoreboard;

import de.primeapi.primeplugins.spigotapi.api.plugins.coins.CoinsAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import theflames.buildffa.Buildffa;
import theflames.buildffa.utils.MYSQL;

import java.sql.*;

public class BuildffaScoreboard extends ScoreboardBuilder{
    public static String host = Buildffa.getInstance().getConfig().getString("mysql.host");

    public static String port = Buildffa.getInstance().getConfig().getString("mysql.port");

    public static String database = Buildffa.getInstance().getConfig().getString("mysql.db");

    public static String username = Buildffa.getInstance().getConfig().getString("mysql.username");

    public static String password = Buildffa.getInstance().getConfig().getString("mysql.password");
    int change = 0;
    public BuildffaScoreboard(Player player) {
        super(player,   "  §8[§eBuildFFA§8]  ");
    }



    @Override
    public void createScoreboard() {
        run1();
        run2();
        setScore("§e§lSpieler §6↴", 14);
        setScore(player.getName(), 13);
        setScore("", 12);
        setScore("§e§lRang §6↴", 11);
        setScore("%uperms_prefix%", 10);
        setScore("", 9);
        setScore("§e§lCoins §6↴", 8);
        setScore("Loading...", 7);
        setScore("", 6);
        setScore("§e§lKills §6↴", 5);
        setScore("Loading...", 4);
        setScore("", 3);
        setScore("§e§lTode §6↴", 2);
        setScore("Loading...", 1);
        setScore("§cthe-flames.de", 0);
    }

    @Override
    public void update() {

    }

    private void run1() {
        new BukkitRunnable() {
            @Override
            public void run() {

                //get player deaths
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);

                    Statement stmt = conn.createStatement();

                    stmt.executeQuery("SELECT * FROM `Stats` WHERE `UUID` = '" + player.getUniqueId() + "'");

                    ResultSet resultSet = stmt.getResultSet();

                    resultSet.first();

                    int playerdeaths = resultSet.getInt("TEMPDEATHS");

                    setScore(String.valueOf(playerdeaths), 1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                //get  player kills
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);

                    Statement stmt = conn.createStatement();

                    stmt.executeQuery("SELECT * FROM `Stats` WHERE `UUID` = '" + player.getUniqueId() + "'");

                    ResultSet resultSet = stmt.getResultSet();

                    resultSet.first();

                    int playerkills = resultSet.getInt("TEMPKILLS");

                    setScore(String.valueOf(playerkills), 4);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                setScore(CoinsAPI.getInstance().getCoins(player.getUniqueId()).toString(), 7);

            }
        }.runTaskTimer(Buildffa.getInstance(), 20L * Buildffa.getInstance().getConfig().getInt("scoreboard.delay"), 20L);
    }

    private void run2() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (change == 0) {
                    setScore( "§cthe-flames.de", 0);
                } else if (change == 1) {
                    setScore("§9/discord", 0);
                } else if (change == 2) {
                    setScore("§b@theflamesmc", 0);
                } else if (change == 3) {
                    setScore("§a/shop", 0);
                    change = -1;
                }
                change++;
            }
        }.runTaskTimer(Buildffa.getInstance(), 20L * Buildffa.getInstance().getConfig().getInt("scoreboard.delay"), 20L);
    }
}
