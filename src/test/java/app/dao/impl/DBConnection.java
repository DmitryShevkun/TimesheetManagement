package app.dao.impl;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    @Value("${jdbc.driver}")
    private static String driver;
    @Value("${db.url}")
    private static String url;
    @Value("${db.username}")
    private static String username;
    @Value("${db.password}")
    private static String password;

    public Connection getConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
