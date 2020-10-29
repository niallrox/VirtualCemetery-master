package ServerWork;

import Foundation.Command;
import Foundation.DatabaseInfo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Base64;

public class Database {
    private Connection connection;
    private MessageDigest hash;
    private static Database database = new Database();

    public static Database getDatabase() {
        return database;
    }

    /**
     * Метод подключает сервер к БД все данные БД константы класса DatabaseInfo для удобства в будующем (если надо будет имзенить)
     */
    public void connectToBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DatabaseInfo.URL_BD, DatabaseInfo.USER, DatabaseInfo.PASSWORD);
            System.out.println("Сервер подключился к БД");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Метод регестрирует пользователя и добавляет его в БД
     *
     * @param command
     * @return
     */
    public Command registration(Command command) {
        try {
            hash = MessageDigest.getInstance("SHA-224");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO " + DatabaseInfo.NAME_LP_BD + " (" + DatabaseInfo.LOGIN_LP_BD + ", " + DatabaseInfo.PASSWORD_LP_BD + ") VALUES (?, ?);");
            ps.setString(1, command.getLogin());
            ps.setString(2, Base64.getEncoder().encodeToString(hash.digest(command.getPassword().getBytes("UTF-8"))));
            ps.execute();
            return new Command("Регистарция прошла успешно");
        } catch (NoSuchAlgorithmException | SQLException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return new Command("Ошибка при регистрации.");
        }
    }

    /**
     * Метод авторизует пользователя
     *
     * @param command
     * @return
     */
    public Command authorization(Command command) {
        try {
            hash = MessageDigest.getInstance("SHA-224");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + DatabaseInfo.NAME_LP_BD + " WHERE (" + DatabaseInfo.LOGIN_LP_BD + " = ?);");
            ps.setString(1, command.getLogin());
            ResultSet res = ps.executeQuery();
            res.next();
            if (Base64.getEncoder().encodeToString(hash.digest(command.getPassword().getBytes("UTF-8")))
                    .equals(res.getString(DatabaseInfo.PASSWORD_LP_BD))) {
                return new Command("Авторизация прошла успешно");
            } else {
                return new Command("Пароль введен не верно");
            }
        } catch (NoSuchAlgorithmException | SQLException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return new Command("Ошибка при авторизации");
        }
    }
}