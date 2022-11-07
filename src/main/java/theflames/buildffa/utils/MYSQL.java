package theflames.buildffa.utils;

import theflames.buildffa.Buildffa;

import java.sql.*;

public class MYSQL {

    public static String host = Buildffa.getInstance().getConfig().getString("mysql.host");

    public static String port = Buildffa.getInstance().getConfig().getString("mysql.port");

    public static String database = Buildffa.getInstance().getConfig().getString("mysql.db");

    public static String username = Buildffa.getInstance().getConfig().getString("mysql.username");

    public static String password = Buildffa.getInstance().getConfig().getString("mysql.password");

    public static Connection con;

    public static void connect() {
        if (!isConnected())
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                System.out.println("| [BuildFFA] MYSQL Verbindung hergestellt                     |");
            } catch (SQLException e) {
                System.out.println("| [BuildFFA] MYSQL Verbindung konnte nicht hergestellt werden.|");
            }
    }

    public static void disconnect() {
        if (isConnected())
            try {
                con.close();
                System.out.println("| [BuildFFA] MYSQL Verbindung wurde getrennt.                 |");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static boolean isConnected() {
        if (con == null)
            return false;
        return true;
    }

    public static void update(String qry) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResult(String qry) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

