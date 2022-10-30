package theflames.buildffa.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import theflames.buildffa.StaticCache;

public class CommandHeal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Here we need to give items to our player


            if (args.length == 0) {
                player.setFoodLevel(20);
                player.setHealth(20);
                player.sendMessage(StaticCache.prefix + "§aDu hast dich Gehealt...");
            } else if (args.length == 1) {
                String name = String.valueOf(args[0]);
                Player getplayer = Bukkit.getPlayerExact(name);
                if (getplayer != null) {
                    getplayer.getPlayer().setHealth(20);
                    getplayer.getPlayer().setFoodLevel(20);
                    player.sendMessage(StaticCache.prefix + "§aDu hast den Spieler §6" + name + " §aGeheilt...");
                    getplayer.getPlayer().sendMessage(StaticCache.prefix + "§aDu wurdest Geheilt...");
                } else {
                    player.sendMessage(StaticCache.prefix + "§cDer Spieler ist Offline oder wurde nicht Gefunden.");
                }
            } else {
                player.sendMessage(StaticCache.prefix + "§cDu hast zu viele Argumente angegeben!");
            }

        } else {
            sender.sendMessage("§cDu kannst diesen Befehl nur als Spieler ausführen.");
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

}
