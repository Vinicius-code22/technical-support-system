package org.example.dao;

import org.example.entity.Customer;
import org.example.entity.ServiceOrder;
import org.example.entity.Status;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServiceOrderDAO {
    private DatabaseConnection databaseConnection;

    public ServiceOrderDAO( ) {
        this.databaseConnection = DatabaseConnection.getInstance();
    }


    public void save(ServiceOrder serviceOrder) throws  SQLException {
        String sql = "INSERT INTO ServiceOrders (customerId, date, model, password, repair, description, price, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, serviceOrder.getCustomerId());
            stmt.setString(2, String.valueOf(serviceOrder.getDate()));
            stmt.setString(3, serviceOrder.getModel());
            stmt.setString(4, serviceOrder.getPassword());
            stmt.setString(5, serviceOrder.getRepair());
            stmt.setString(6,serviceOrder.getDescription());
            stmt.setDouble(7, serviceOrder.getPrice());
            stmt.setString(8, String.valueOf(serviceOrder.getStatus()));
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    serviceOrder.setId(generatedKeys.getInt(1));
                }
            }


        }

    }

    public List<ServiceOrder> findAll() throws SQLException{
        List<ServiceOrder> list = new ArrayList<>();
        String sql = "SELECT * FROM ServiceOrders";

        try (Connection conn = DatabaseConnection.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int customerID = rs.getInt("customerId");
                LocalDate date = LocalDate.parse(rs.getString("date"));
                String model = rs.getString("model");
                String password = rs.getString("password");
                String repair = rs.getString("repair");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                Status status = Status.valueOf(rs.getString("status"));
                int id = rs.getInt("id");


                ServiceOrder serviceOrder = new ServiceOrder(customerID, date, description, model, password, price, repair, status);
                serviceOrder.setId(id);
                list.add(serviceOrder);
            }
        }
        return list;
    }


    public void update(ServiceOrder serviceOrder) throws SQLException{
            String sql = "UPDATE ServiceOrders SET customerId = ?, date = ?, model = ?, password = ?, repair = ?, description = ?, price = ?, status = ? WHERE id = ?";

            try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, serviceOrder.getCustomerId());
                stmt.setString(2, String.valueOf(serviceOrder.getDate()));
                stmt.setString(3, serviceOrder.getModel());
                stmt.setString(4, serviceOrder.getPassword());
                stmt.setString(5, serviceOrder.getRepair());
                stmt.setString(6, serviceOrder.getDescription());
                stmt.setDouble(7, serviceOrder.getPrice());
                stmt.setString(8, String.valueOf(serviceOrder.getStatus()));
                stmt.setInt(9, serviceOrder.getId());
                stmt.executeUpdate();
            }
    }

    public void delete(Integer id)  throws SQLException {
        String sql = "DELETE FROM ServiceOrders WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
