package ru.xapple.zxtraileffects.lib;

import ru.xapple.zxtraileffects.Main;

import java.sql.*;

/**
 * Created by Egorka on 13.02.2016.
 */
public class MySQL {
    private final String HOST, DATABASE, USER, PASSWORD, PORT;
    private Connection con;

    public MySQL() {
        this.HOST = Main.get().getConfig().getString("db.host", "localhost");
        this.DATABASE = Main.get().getConfig().getString("db.name");
        this.USER = Main.get().getConfig().getString("db.user");
        this.PASSWORD = Main.get().getConfig().getString("db.password");
        this.PORT = Main.get().getConfig().getString("db.port", "3306");
        connect();
    }
    // Подключение
    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8", USER, PASSWORD);
            //System.out.println("[Coins MySQL] The connection to MySQL is made!");
        } catch (SQLException e) {
            System.out.println("[MySQL] The connection to MySQL couldn't be made! reason: " + e.getMessage());
        }
    }
    // Отключение
    public void disconnect() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    // Проверка подключения
    public boolean hasConnection() {
        return con != null;
    }

    // Подготовка запроса
    public PreparedStatement prepareStatement(String qry) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
    // Обновление данных
    public void update(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            connect();
            e.printStackTrace();
        }
    }
    // Запрос
    public ResultSet query(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (SQLException e) {
            connect();
            e.printStackTrace();
        }
        return null;
    }


}