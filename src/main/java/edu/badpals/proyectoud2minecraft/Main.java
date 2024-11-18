package edu.badpals.proyectoud2minecraft;

import edu.badpals.proyectoud2minecraft.Controller.MainController;
import edu.badpals.proyectoud2minecraft.Model.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainview.fxml"));
        loader.setRoot(new AnchorPane());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Proyecto UD2 Minecraft");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}