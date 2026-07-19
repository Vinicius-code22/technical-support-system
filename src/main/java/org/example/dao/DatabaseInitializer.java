package org.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public void initializeDatabase() throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS Customers (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, cpf TEXT UNIQUE )");
        stmt.execute("CREATE TABLE IF NOT EXISTS ServiceOrders(id INTEGER PRIMARY KEY AUTOINCREMENT, customerId INTEGER, date TEXT, model TEXT, password TEXT, repair TEXT, description TEXT, price REAL, status TEXT)");
        stmt.execute(("CREATE  TABLE IF NOT EXISTS Accessories (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, supplier TEXT, quantity INTEGER, unitPrice REAL)"));
    }

}
