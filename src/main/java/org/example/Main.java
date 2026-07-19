package org.example;


import org.example.dao.AccessoryDAO;
import org.example.dao.CustomerDAO;
import org.example.dao.DatabaseInitializer;
import org.example.dao.ServiceOrderDAO;
import org.example.entity.Accessory;
import org.example.entity.Customer;
import org.example.entity.ServiceOrder;
import org.example.entity.Status;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main{
    public static void main(String[] args) throws SQLException {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        databaseInitializer.initializeDatabase();
        Accessory accessory = new Accessory("Carregador", 10, "Fornecedor ", 60.00);

        AccessoryDAO accessoryDAO = new AccessoryDAO();

        accessoryDAO.save(accessory);

        for (Accessory a: accessoryDAO.findAll()) {
            System.out.println(a);
        }

        accessory.setUnitPrice(65.00);
        accessory.setSupplier("Fornecedor Upgrade");

        accessoryDAO.update(accessory);

        accessoryDAO.delete(accessory.getId());

        for (Accessory a: accessoryDAO.findAll()) {
            System.out.println(a);
        }
    }
}
