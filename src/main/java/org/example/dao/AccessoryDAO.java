package org.example.dao;

import org.example.entity.Accessory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccessoryDAO {
    private DatabaseConnection databaseConnection;

    public AccessoryDAO () {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    public void save(Accessory accessory) throws SQLException {
        String sql = "INSERT INTO Accessories (name, supplier, quantity, unitPrice) VALUES (?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, accessory.getName());
            stmt.setString(2, accessory.getSupplier());
            stmt.setInt(3, accessory.getQuantity());
            stmt.setDouble(4, accessory.getUnitPrice());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    accessory.setId(generatedKeys.getInt(1));
                }
            }

        }
    }

    public List<Accessory> findAll() throws SQLException{
        List<Accessory> list = new ArrayList<>();
        String sql = "SELECT * FROM Accessories";
        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String supplier = rs.getString("supplier");
                int quantity = rs.getInt("quantity");
                double unitPrice = rs.getDouble("unitPrice");

                Accessory accessory = new Accessory(name, quantity, supplier, unitPrice);
                accessory.setId(id);
                list.add(accessory);
            }

        }
        return list;
    }

    public void update(Accessory accessory) throws SQLException {
        String sql = "UPDATE Accessories SET name = ?, supplier = ?, quantity = ?, unitPrice = ? WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, accessory.getName());
            stmt.setString(2,accessory.getSupplier());
            stmt.setInt(3, accessory.getQuantity());
            stmt.setDouble(4, accessory.getUnitPrice());
            stmt.setInt(5, accessory.getId());
            stmt.executeUpdate();
        }

    }

    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM Accessories WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
