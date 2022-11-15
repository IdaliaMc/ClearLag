package fr.ayato.clearlag.tasks;

import fr.ayato.clearlag.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ClearLagTask extends TimerTask {
    private static int timer;

    public ClearLagTask() {
        timer = Config.getTime();
    }

    public void run() {
        switch (timer) {
            case 60:
                Bukkit.broadcastMessage(Config.getRepeteMessage().replace("%time%", "1 minute"));
                break;
            case 30:
                Bukkit.broadcastMessage(Config.getRepeteMessage().replace("%time%", "30 seconds"));
                break;
            case 10:
                Bukkit.broadcastMessage(Config.getRepeteMessage().replace("%time%", "10 seconds"));
                break;
            case 3:
                Bukkit.broadcastMessage(Config.getRepeteMessage().replace("%time%", "3 seconds"));
                break;
            case 2:
                Bukkit.broadcastMessage(Config.getRepeteMessage().replace("%time%", "2 seconds"));
                break;
            case 1:
                Bukkit.broadcastMessage(Config.getRepeteMessage().replace("%time%", "1 second"));
                break;
            case 0:
                clearLag();
                break;
        }
        timer--;
    }

    public static void clearLag() {
        List<String> worldsList = Config.getWorlds();
        List<String> blackList = Config.getBlackList();
        for (String world : worldsList) {
            for (Entity entity : Bukkit.getWorld(world).getEntities()) {
                if (!blackList.contains(entity.getType().toString())) {
                    entity.remove();
                }
            }
        }
        Bukkit.broadcastMessage(Config.getSuccessMessage());
        ClearLagTask.timer = Config.getTime();
    }
}
