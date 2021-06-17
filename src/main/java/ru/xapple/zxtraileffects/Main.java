package ru.xapple.zxtraileffects;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.xapple.zxtraileffects.commands.MainCommand;
import ru.xapple.zxtraileffects.lib.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    private static Main instance;

    public static List<PlayerData> players = new ArrayList<>();

    public MySQL mysql;

    public int cloudMin, cloudMax;
    public int smokeMin, smokeMax;
    public int smoke2Min, smoke2Max;
    public int fireMin, fireMax, fire2Min, fire2Max;
    public int enderMin, enderMax;
    public int heartMin, heartMax;
    public int discoMin, discoMax;
    public int bloodMin, bloodMax;
    public int critMin, critMax;
    public int magmaMin, magmaMax;
    public int letterMin, letterMax;
    public int happyMin, happyMax, angerMin, angerMax;
    public int musicMin, musicMax;
    public int magicMin, magicMax;
    public int sweatMin, sweatMax;
    public int sparkMin, sparkMax;
    public int crumbMin, crumbMax;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        PluginConfig.updateConfig();
        reloadConfig();

        Functions.loadTrailsValues();

        new Messaging(this);
        Objects.requireNonNull(getCommand("trail")).setExecutor(new MainCommand());

        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);

        ConnectMySQL();

        this.getLogger().info("zxTrailEffects enabled.");
    }

    @Override
    public void onDisable() {
        mysql.disconnect();

        // Plugin shutdown logic
        this.getLogger().info("zxTrailEffects disabled.");
    }

    public MySQL getMySQL(){
        return mysql;
    }

    public void ConnectMySQL() {
        mysql = new MySQL();

        // Таблица пользователей
        PreparedStatement statement = mysql.prepareStatement(
                "CREATE TABLE IF NOT EXISTS `zxtraileffects` (\n" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `user_name` varchar(100) NOT NULL,\n" +
                        "  `effect` varchar(100) NOT NULL,\n" +
                        "  PRIMARY KEY (`id`)\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1");
        mysql.update(statement);
    }

    public static Main get() {
        return instance;
    }
}
