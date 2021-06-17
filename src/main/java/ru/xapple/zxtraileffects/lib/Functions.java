package ru.xapple.zxtraileffects.lib;

import org.bukkit.entity.Player;
import ru.xapple.zxtraileffects.EntityListener;
import ru.xapple.zxtraileffects.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Functions {
    public static void JoinPlayer(Player player) {
        for (int i = 0; i < Main.players.size(); i++) {
            if (player.getName().equalsIgnoreCase(Main.players.get(i).name)) {
                return;
            }
        }

        // find player effect on mysql
        String effect = "";
        String SELECT = "SELECT effect FROM zxtraileffects WHERE user_name=? LIMIT 1";
        try {
            PreparedStatement statement = Main.get().mysql.prepareStatement(SELECT);
            statement.setString(1, player.getName());
            ResultSet result = Main.get().mysql.query(statement);
            if (result != null) {
                while (result.next()) {
                    //if (result.next()) {
                    effect = result.getString("effect");
                }
                result.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        PlayerData pd = new PlayerData();
        pd.name = player.getName();
        pd.effect = effect;
        Main.players.add(pd);
    }

    public static void LeavePlayer(Player player) {
        if (Main.players != null) {
            Main.players.removeIf(pd -> pd.name.equalsIgnoreCase(player.getName()));
        }
    }

    public static PlayerData getPlayerDataByName(String name) {
        for (int i = 0; i < Main.players.size(); i++) {
            if (name.equalsIgnoreCase(Main.players.get(i).name)) {
                return Main.players.get(i);
            }
        }
        return null;
    }

    public static void addPlayerEffect(Player player, String effect) {
        String INSERT = "INSERT INTO zxtraileffects (user_name, effect) VALUES(?,?)";
        try {
            PreparedStatement statement = Main.get().mysql.prepareStatement(INSERT);
            statement.setString(1, player.getName());
            statement.setString(2, effect);
            Main.get().mysql.update(statement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        PlayerData pd = new PlayerData();
        pd.name = player.getName();
        pd.effect = effect;
        Main.players.add(pd);
    }

    public static void removePlayerEffect(Player player) {
        // remove from db
        String DELETE = "DELETE FROM zxtraileffects WHERE user_name = ?";
        try {
            PreparedStatement statement = Main.get().mysql.prepareStatement(DELETE);
            statement.setString(1, player.getName());
            Main.get().mysql.update(statement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // stop show effect
        Functions.LeavePlayer(player);
    }

    public static void loadTrailsValues()
    {
        Main.get().cloudMax = Main.get().getConfig().getInt("trails.clouds.max", 10);
        Main.get().cloudMin = Main.get().getConfig().getInt("trails.clouds.min", 5);
        Main.get().smokeMax = Main.get().getConfig().getInt("trails.smoke.max", 14);
        Main.get().smokeMin = Main.get().getConfig().getInt("trails.smoke.min", 8);
        Main.get().smoke2Max = Main.get().getConfig().getInt("trails.smoke2.max", 14);
        Main.get().smoke2Min = Main.get().getConfig().getInt("trails.smoke2.min", 8);
        Main.get().fireMax = Main.get().getConfig().getInt("trails.fire.max", 6);
        Main.get().fireMin = Main.get().getConfig().getInt("trails.fire.min", 2);
        Main.get().enderMax = Main.get().getConfig().getInt("trails.ender.max", 160);
        Main.get().enderMin = Main.get().getConfig().getInt("trails.ender.min", 90);
        Main.get().heartMax = Main.get().getConfig().getInt("trails.heart.max", 8);
        Main.get().heartMin = Main.get().getConfig().getInt("trails.heart.min", 2);
        Main.get().discoMax = Main.get().getConfig().getInt("trails.disco.max", 8);
        Main.get().discoMin = Main.get().getConfig().getInt("trails.disco.min", 2);
        Main.get().bloodMax = Main.get().getConfig().getInt("trails.blood.max", 8);
        Main.get().bloodMin = Main.get().getConfig().getInt("trails.blood.min", 2);
        Main.get().critMax = Main.get().getConfig().getInt("trails.crit.max", 7);
        Main.get().critMin = Main.get().getConfig().getInt("trails.crit.min", 4);
        Main.get().magmaMax = Main.get().getConfig().getInt("trails.magma.max", 6);
        Main.get().magmaMin = Main.get().getConfig().getInt("trails.magma.min", 2);
        Main.get().letterMax = Main.get().getConfig().getInt("trails.letter.max", 16);
        Main.get().letterMin = Main.get().getConfig().getInt("trails.letter.min", 9);
        Main.get().happyMax = Main.get().getConfig().getInt("trails.happy.max", 12);
        Main.get().happyMin = Main.get().getConfig().getInt("trails.happy.min", 4);
        Main.get().angerMax = Main.get().getConfig().getInt("trails.anger.max", 5);
        Main.get().angerMin = Main.get().getConfig().getInt("trails.anger.min", 2);
        Main.get().musicMax = Main.get().getConfig().getInt("trails.music.max", 6);
        Main.get().musicMin = Main.get().getConfig().getInt("trails.music.min", 3);
        Main.get().magicMax = Main.get().getConfig().getInt("trails.magic.max", 7);
        Main.get().magicMin = Main.get().getConfig().getInt("trails.magic.min", 4);
        Main.get().sweatMax = Main.get().getConfig().getInt("trails.sweat.max", 8);
        Main.get().sweatMin = Main.get().getConfig().getInt("trails.sweat.min", 4);
        Main.get().sparkMax = Main.get().getConfig().getInt("trails.spark.max", 7);
        Main.get().sparkMin = Main.get().getConfig().getInt("trails.spark.min", 4);
        Main.get().crumbMax = Main.get().getConfig().getInt("trails.crumb.max", 8);
        Main.get().crumbMin = Main.get().getConfig().getInt("trails.crumb.min", 4);
        Main.get().fire2Max = Main.get().getConfig().getInt("trails.fire2.max", 6);
        Main.get().fire2Min = Main.get().getConfig().getInt("trails.fire2.min", 2);
    }
}
