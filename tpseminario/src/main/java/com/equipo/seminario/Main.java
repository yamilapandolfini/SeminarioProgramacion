package com.equipo.seminario;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Appointment Manager");
        
        stage.setScene(scene);
        stage.show();
    }

  public static void main(String[] args) {
      launch();
  }

}
