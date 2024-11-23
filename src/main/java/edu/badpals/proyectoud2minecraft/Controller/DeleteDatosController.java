package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import edu.badpals.proyectoud2minecraft.View.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
            Alertas.errorBorrarIdVacio();
        } else {
            int rows = Conexion.borrarDatos(idBorrar.getText());
            if (rows == 1) {
                Alertas.infoBorrado();
            } else {
                Alertas.errorBorrar();
            }
        }
    }
}