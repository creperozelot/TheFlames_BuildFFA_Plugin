package theflames.buildffa.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import theflames.buildffa.Buildffa;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class playerutils {
    public static void saveInventory(Player p) throws IOException {
        File f = new File(Buildffa.getInstance().getDataFolder().getAbsolutePath() + "/Data/inv", p.getUniqueId() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("inventory.armor", p.getInventory().getArmorContents());
        c.set("inventory.content", p.getInventory().getContents());
        c.save(f);
    }

    @SuppressWarnings("unchecked")
    public static void restoreInventory(Player p) throws IOException {
        File f = new File(Buildffa.getInstance().getDataFolder().getAbsolutePath() + "/Data/inv", p.getUniqueId() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        p.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
        p.getInventory().setContents(content);
    }

    public static boolean hasInventoryData(Player p) {
        boolean bol = false;
        File f = new File(Buildffa.getInstance().getDataFolder().getAbsolutePath() + "/Data/inv", p.getUniqueId() + ".yml");
        if (f.exists()) {
            bol = true;
        }

        return bol;
    }
}
