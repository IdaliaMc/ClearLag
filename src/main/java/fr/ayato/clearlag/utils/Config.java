package fr.ayato.clearlag.utils;

import fr.ayato.clearlag.Main;

import java.util.List;

public class Config {
    public static int getTime() {
        return Main.getInstance().getConfig().getInt("time");
    }

    public static List<String> getWorlds() {
        return Main.getInstance().getConfig().getStringList("worlds");
    }

    public static List<String> getBlackList() { return Main.getInstance().getConfig().getStringList("blacklist"); }

    public static String getSuccessMessage() { return Main.getInstance().getConfig().getString("success_message"); }

    public static String getRepeteMessage() { return Main.getInstance().getConfig().getString("repete_message"); }
}
