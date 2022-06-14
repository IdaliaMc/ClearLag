package fr.ayato.clearlag.commands;

import fr.ayato.clearlag.tasks.ClearLagTask;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClearLagCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("clearlag")) {
            if (commandSender.hasPermission("clearlag.use")) {
                ClearLagTask.clearLag();
            } else {
                commandSender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
            }
        }
        return false;
    }
}
