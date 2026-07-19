package org.example.dao;

import org.example.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private DatabaseConnection databaseConnection;

    public CustomerDAO() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    public void save(Customer customer) throws  SQLException {
        String sql = "INSERT INTO Customers (name, phone, cpf) VALUES (?, ?, ?)";

        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setString(3, customer.getCpf());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getInt(1));

                }
            }

        }
    }

    public List<Customer> findAll() throws SQLException {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customers";

        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String cpf = rs.getString("cpf");

                Customer customer = new Customer(cpf, name, phone);
                customer.setId(id);

                list.add(customer);

            }
        }
        return list;
    }

    public Customer findByCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE cpf = ? ";
        try (Connection conn = DatabaseConnection.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                Customer customer = new Customer(cpf, name, phone);
                customer.setId(rs.getInt("id"));

                return customer;


            } else {
                return null;
            }

        }
    }
}
