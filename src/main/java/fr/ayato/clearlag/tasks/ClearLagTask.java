package fr.ayato.clearlag.tasks;

import fr.ayato.clearlag.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;

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
                Bukkit.broadcastMessage("§eSupression des entitées dans §c1 minute§e!");
                break;
            case 30:
                Bukkit.broadcastMessage("§eSupression des entitées dans §c30 secondes§e!");
                break;
            case 10:
                Bukkit.broadcastMessage("§eSuppression des entitées dans §c10 secondes§e!");
                break;
            case 4:
                Bukkit.broadcastMessage("§eSuppression des entitées dans §c3 secondes§e.");
                break;
            case 3:
                Bukkit.broadcastMessage("§eSuppression des entitées dans §c2 secondes§e.");
                break;
            case 2:
                Bukkit.broadcastMessage("§eSuppression des entitées dans §c1 seconde§e.");
                break;
            case 1:
                clearLag();
                break;
        }
        timer--;
    }

    public static void clearLag() {
        List<String> worldsList = Config.getWorlds();
        for (String world : worldsList) {
            for (Entity entity : Bukkit.getWorld(world).getEntities()) {
                if (!(entity instanceof Player) && !(entity instanceof Villager)) {
                    entity.remove();
                }
            }
        }
        Bukkit.broadcastMessage("§eSuppression des entitées effectuée avec succès!");
        ClearLagTask.timer = Config.getTime();
    }
}
