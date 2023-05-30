package theflames.buildffa.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import theflames.buildffa.Buildffa;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class tempfile {

    private static final File file = new File(Buildffa.getInstance().getDataFolder().getAbsolutePath(), "/data/tempstorage.yml");
    private static final FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public static boolean initTempFile() {
        if (file.exists()) {
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            Buildffa.getInstance().getLogger().log(Level.SEVERE, e.getMessage());
            return false;
        }

        return true;

    }

    public static boolean playerexist(String playername) {
        return  configuration.contains(playername);
    }

    public static void initplayer(String playername) throws IOException {
        if (!playerexist(playername)) {
            configuration.set(playername + ".tempkills", 0);
            configuration.set(playername + ".tempdeaths", 0);
            configuration.save(file);
        }
    }

    public static int getkills(String playername) {
        return configuration.getInt(playername + ".tempkills");
    }

    public static void addkill(String playername) throws IOException {
        configuration.set(playername + ".tempkills", getkills(playername) + 1);
        configuration.save(file);
    }

    public static int getdeaths(String playername) {
        return configuration.getInt(playername + ".tempdeaths");
    }

    public static void adddeath(String playername) throws IOException {
        configuration.set(playername + ".tempdeaths", getdeaths(playername) + 1);
        configuration.save(file);
    }

    public static void removeplayer(String playername) throws IOException {
        configuration.set(playername, null);
        configuration.save(file);
    }

    public static void deleteTempfile() {
        file.delete();
    }

}
