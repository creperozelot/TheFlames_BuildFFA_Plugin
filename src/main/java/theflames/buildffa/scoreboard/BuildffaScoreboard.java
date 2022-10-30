package theflames.buildffa.scoreboard;

import de.primeapi.primeplugins.spigotapi.api.plugins.coins.CoinsAPI;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import theflames.buildffa.Buildffa;

public class BuildffaScoreboard extends ScoreboardBuilder{
    public BuildffaScoreboard(Player player) {
        super(player,   "  §8[§eBuildFFA§8]  ");
    }



    @Override
    public void createScoreboard() {
        run();
        setScore("§e§lSpieler §6↴", 13);
        setScore(player.getName(), 12);
        setScore("", 11);
        setScore("§e§lRang §6↴", 10);
        setScore("%uperms_prefix%", 9);
        setScore("", 8);
        setScore("§e§lCoins §6↴", 7);
        setScore(CoinsAPI.getInstance().getCoins(player.getUniqueId()).toString(), 6);
        setScore("", 5);
        setScore("§e§lKills §6↴", 4);
        setScore("{P_kills_r}", 3);
        setScore("", 2);
        setScore("§e§lTode §6↴", 1);
        setScore("{P_deaths}", 0);
    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                setScore(CoinsAPI.getInstance().getCoins(player.getUniqueId()).toString(), 6);
            }
        }.runTaskTimer(Buildffa.getInstance(), 20L, 20L);
    }
}
