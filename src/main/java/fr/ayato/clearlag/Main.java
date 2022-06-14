package fr.ayato.clearlag;

import fr.ayato.clearlag.commands.ClearLagCommand;
import fr.ayato.clearlag.tasks.ClearLagTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main getInstance() {
        return JavaPlugin.getPlugin(Main.class);
    }

    @Override
    public void onEnable() {
        System.out.println(ChatColor.WHITE + "--------------------");
        System.out.println(ChatColor.AQUA + "[" + ChatColor.YELLOW + "Idalia" + ChatColor.AQUA + "]" + ChatColor.GREEN + " ClearLag is now enabled !");
        System.out.println(ChatColor.WHITE + "--------------------");
        saveConfig();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new ClearLagTask(), 0L, 20L);
        getCommand("clearlag").setExecutor(new ClearLagCommand());
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.WHITE + "--------------------");
        System.out.println(ChatColor.AQUA + "[" + ChatColor.YELLOW + "Idalia" + ChatColor.AQUA + "]" + ChatColor.RED + " ClearLag is now disabled !");
        System.out.println(ChatColor.WHITE + "--------------------");
    }
}

