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
                System.out.println("| [BuildFFA] MYSQL Verbindung hergestellt");
            } catch (SQLException e) {
                System.out.println("| [BuildFFA] MYSQL Verbindung konnte nicht hergestellt werden.");
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

    public static boolean PlayerExist(String uuid) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        Statement stmt = con.createStatement();
        return stmt.executeQuery("SELECT * FROM `Stats` WHERE `UUID`='" + uuid + "';").next();
    }

    public static ResultSet getDeath(String uuid) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT `DEATHS` FROM `Stats` WHERE `UUID`='" + uuid + "';");
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getDeathsinInt(String uuid) {
        try {
            Statement stmt = con.createStatement();

            stmt.executeQuery("SELECT * FROM `Stats` WHERE `UUID` = '" + uuid + "'");

            ResultSet resultSet = stmt.getResultSet();

            resultSet.first();

            return resultSet.getInt("TEMPDEATHS");
        } catch (SQLException e) {
            return -1;
        }
    }

    public static int getKillsinInt(String uuid) {
        try {
            Statement stmt = con.createStatement();

            stmt.executeQuery("SELECT * FROM `Stats` WHERE `UUID` = '" + uuid + "'");

            ResultSet resultSet = stmt.getResultSet();

            resultSet.first();

            return resultSet.getInt("TEMPKILLS");
        } catch (SQLException e) {
            return -1;
        }
    }

    public static void addDeath(String uuid) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        Statement stmt = con.createStatement();
        int deaths = getDeath(uuid).getInt("DEATHS") + 1;
        stmt.execute("UPDATE `Stats` SET `DEATHS`='" + deaths + "';");
    }

    public static ResultSet getTempDeath(String uuid) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT `TEMPDEATHS` FROM `Stats` WHERE `UUID`='" + uuid + "';");
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addTempDeath(String uuid) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        Statement stmt = con.createStatement();
        int deaths = getTempDeath(uuid).getInt("TEMPDEATHS") + 1;
        stmt.execute("UPDATE `Stats` SET `TEMPDEATHS`='" + deaths + "';");
    }

    public static ResultSet getKill(String uuid) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT `KILLS` FROM `Stats` WHERE `UUID`='" + uuid + "';");
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addKill(String uuid) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        Statement stmt = con.createStatement();
        int kills = getKill(uuid).getInt("KILLS") + 1;
        stmt.execute("UPDATE `Stats` SET `KILLS`='" + kills + "';");
    }

    public static ResultSet getTempKill(String uuid) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT `TEMPKILLS` FROM `Stats` WHERE `UUID`='" + uuid + "';");
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addTempKill(String uuid) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        Statement stmt = con.createStatement();
        int kills = getTempKill(uuid).getInt("TEMPKILLS") + 1;
        stmt.execute("UPDATE `Stats` SET `TEMPKILLS`='" + kills + "';");
    }
}

