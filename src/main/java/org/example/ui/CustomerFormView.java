package org.example.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.dao.CustomerDAO;
import org.example.entity.Customer;

import java.sql.SQLException;

public class CustomerFormView {

    public GridPane createScreen() {
        GridPane gridPane = new GridPane();
        Label labelName = new Label("Nome:");
        TextField textFieldName = new TextField();
        gridPane.add(labelName, 0, 0);
        gridPane.add(textFieldName,1, 0);

        Label labelTelefone = new Label("Telefone:");
        TextField textFieldTelefone = new TextField();
        gridPane.add(labelTelefone, 0, 1);
        gridPane.add(textFieldTelefone,1, 1);

        Label labelCPF = new Label("CPF:");
        TextField textFieldCPF = new TextField();
        gridPane.add(labelCPF, 0, 2);
        gridPane.add(textFieldCPF,1, 2);

        Button buttonSave = new Button("Salvar");
        gridPane.add(buttonSave, 0, 3);

        buttonSave.setOnAction(event -> {
            String name = textFieldName.getText();
            String telefone = textFieldTelefone.getText();
            String cpf = textFieldCPF.getText();

            Customer customer = new Customer(name, telefone, cpf);
            CustomerDAO customerDAO = new CustomerDAO();
            try {
                customerDAO.save(customer);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        return gridPane;
    }
}
