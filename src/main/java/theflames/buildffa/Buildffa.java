package theflames.buildffa;

import theflames.buildffa.commands.*;

import org.bukkit.plugin.java.JavaPlugin;
import theflames.buildffa.listener.*;
import theflames.buildffa.utils.MYSQL;

import java.sql.*;

public final class Buildffa extends JavaPlugin {
    private static Buildffa instance;

    static Connection connection;

    public static Buildffa getInstance() {
        return instance;
    }



    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getLogger().info("===================");
        this.getLogger().info("");
        this.getLogger().info("§a§eBuildFFA Geladen...");
        this.getLogger().info("");
        this.getLogger().info("===================");
        MYSQL.connect();
        if (MYSQL.isConnected()) {
            MYSQL.update("CREATE TABLE IF NOT EXISTS Stats(UUID varchar(64), KILLS int, DEATHS int, TEMPKILLS int, TEMPDEATHS int);");
        }

        registerCommand();
        registerListener();
    }

    @Override
    public void onDisable() {
        this.getLogger().info("===================");
        this.getLogger().info("");
        this.getLogger().info("§a§eBuildFFA Deaktiviert...");
        this.getLogger().info("");
        this.getLogger().info("===================");
        MYSQL.disconnect();
    }

    private void registerCommand() {
        this.getCommand("heal").setExecutor(new CommandHeal());
        this.getCommand("setspawn").setExecutor(new CommandSetSpawn());
        this.getCommand("build").setExecutor(new CommandBuild());
        this.getCommand("db-test").setExecutor(new CommandDBconnection());
        this.getCommand("setdeathheight").setExecutor(new CommandSetDeathheight());
        this.getCommand("getkills").setExecutor(new DevCommandMySQLgetKills());
        this.getCommand("setarenaheight").setExecutor(new CommandSetArenaheight());
        this.getCommand("reloadbuildffaconfig").setExecutor(new CommandReload());
    }

    private void registerListener() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new BreakBlockListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItemEvent(), this);
        getServer().getPluginManager().registerEvents(new OnHungerListener(), this);
    }

}
