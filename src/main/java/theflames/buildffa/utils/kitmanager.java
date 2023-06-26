package theflames.buildffa.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import theflames.buildffa.Buildffa;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class kitmanager {

    private static final File file = new File(Buildffa.getInstance().getDataFolder().getAbsolutePath(), "/data/kits.yml");
    private static FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public static void init() throws IOException {

        if (!file.exists()) {
            file.createNewFile();
        }

        configuration.set("kits", "");
        configuration.save(file);

    }

    public static boolean exsist(String kitname) {
        return configuration.get("kits." + kitname) != null;
    }

    public static boolean savekit(Player player, String kitname) throws IOException {
        if (exsist(kitname)) return false;

        ItemStack[] inv = player.getInventory().getContents();
        ItemStack[] armor = player.getInventory().getArmorContents();
        configuration.set("kits." + kitname + ".inv", inv);
        configuration.set("kits." + kitname + ".armor", armor);
        configuration.save(file);

        return exsist(kitname);
    }

    public static void removekit(String kitname) throws IOException {
        configuration.set("kits." + kitname, null);
        configuration.save(file);
    }

    public static boolean loadkit(Player player, String kitname) {
        if (!exsist(kitname)) return false;

        ItemStack[] inv = ((List<ItemStack>) configuration.get("kits." + kitname + ".inv")).toArray(new ItemStack[0]);
        ItemStack[] armor = ((List<ItemStack>) configuration.get("kits." + kitname + ".armor")).toArray(new ItemStack[0]);
        player.getInventory().setContents(inv);
        player.getInventory().setArmorContents(armor);

        return true;
    }



}
