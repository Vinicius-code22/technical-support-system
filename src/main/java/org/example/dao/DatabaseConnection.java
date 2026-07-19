package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:sqlite:technical_support.db";
    private static DatabaseConnection databaseConnection;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

}
