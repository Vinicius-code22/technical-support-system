package org.example;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ui.CustomerFormView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CustomerFormView customerFormView = new CustomerFormView();
        Scene scene = new Scene(customerFormView.createScreen());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
