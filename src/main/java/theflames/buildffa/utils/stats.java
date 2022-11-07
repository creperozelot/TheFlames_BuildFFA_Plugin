package theflames.buildffa.utils;

import theflames.buildffa.Buildffa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class stats {
    public static boolean playerExists(String uuid) {
        try {
            ResultSet rs = MYSQL.getResult("SELECT * FROM Stats WHERE UUID='" + uuid + "'");
            if (rs.next())
                return (rs.getString("UUID") != null);
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void createPlayer(String uuid) {
            if (!playerExists(uuid))
                MYSQL.update("INSERT INTO Stats(UUID, KILLS, DEATHS, TEMPKILLS, TEMPDEATHS) VALUES ('" + uuid + "', '0', '0', '0', '0');");
        }
    }