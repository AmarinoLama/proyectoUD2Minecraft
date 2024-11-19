package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteDatosController {

    @FXML
    private Button btnBorrar;

    @FXML
    private TextField idBorrar;

      /*
            todo poner los mensajes de alerta en view
     */


    @FXML
    void borrarPorId(ActionEvent event) {
        if (idBorrar.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al borrar");
            alert.setContentText("El campo de ID no puede estar vacío");
            alert.showAndWait();
        } else {
            int rows = Conexion.borrarDatos(idBorrar.getText());
            if (rows == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Borrado exitoso");
                alert.setContentText("El dato ha sido borrado correctamente");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error al borrar");
                alert.setContentText("No se ha podido borrar el dato");
                alert.showAndWait();
            }
        }
    }
}