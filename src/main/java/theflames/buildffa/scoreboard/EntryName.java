package theflames.buildffa.scoreboard;

import org.bukkit.ChatColor;

public enum EntryName {

    ENTRY_0(0, ChatColor.YELLOW.toString()),
    ENTRY_1(1, ChatColor.BLACK.toString()),
    ENTRY_2(2, ChatColor.AQUA.toString()),
    ENTRY_3(3, ChatColor.DARK_AQUA.toString()),
    ENTRY_4(4, ChatColor.DARK_BLUE.toString()),
    ENTRY_5(5, ChatColor.DARK_GRAY.toString()),
    ENTRY_6(6, ChatColor.DARK_GREEN.toString()),
    ENTRY_7(7, ChatColor.DARK_RED.toString()),
    ENTRY_8(8, ChatColor.GOLD.toString()),
    ENTRY_9(9, ChatColor.GREEN.toString()),
    ENTRY_10(10, ChatColor.BOLD.toString()),
    ENTRY_11(11, ChatColor.ITALIC.toString()),
    ENTRY_12(12, ChatColor.MAGIC.toString()),
    ENTRY_13(13, ChatColor.RED.toString()),
    ENTRY_14(14, ChatColor.LIGHT_PURPLE.toString()),


    ;

    private final int entry;
    private final String entryName;

    EntryName(int entry, String entryName) {
        this.entry = entry;
        this.entryName = entryName;
    }

    public int getEntry() {
        return entry;
    }

    public String getEntryName() {
        return entryName;
    }
}
