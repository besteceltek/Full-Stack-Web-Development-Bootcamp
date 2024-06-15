package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    // Singleton Design Pattern
    private static Database instance = null;
    private Connection connection = null;

    private Database() {
        // Database Connection
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("/Users/besteceltek/Desktop/Full-Stack-Web-Development-Bootcamp/WeekSeven/RentACar/database.properties");
            properties.load(input);
            input.close();

            String DB_URL = properties.getProperty("DB_URL");
            String DB_USERNAME = properties.getProperty("DB_USERNAME");
            String DB_PASSWORD = properties.getProperty("DB_PASSWORD");

            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Database();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return instance.getConnection();
    }
}
