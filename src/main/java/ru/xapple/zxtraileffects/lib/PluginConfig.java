package ru.xapple.zxtraileffects.lib;

import ru.xapple.zxtraileffects.Main;

import java.io.File;
import java.io.IOException;

public class PluginConfig {
    public static void updateConfig() {
        saveConfig();
    }

    private static boolean saveConfig() {
        File file = new File(Main.get().getDataFolder(), "config.yml");
        try {
            Main.get().getConfig().save(file);
            return true;
        } catch (IOException ignored) {
            return false;
        }
    }
}
