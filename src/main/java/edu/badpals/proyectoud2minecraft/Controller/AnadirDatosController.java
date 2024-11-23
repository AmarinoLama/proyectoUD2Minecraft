package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import edu.badpals.proyectoud2minecraft.View.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class AnadirDatosController {

    @FXML
    private TextField txtDat1;

    @FXML
    private TextField txtDat2;

    @FXML
    private TextField txtDat3;

    @FXML
    private TextField txtDat4;

    @FXML
    public void initialize() {

        txtDat1.setPromptText("Nombre");
        txtDat2.setPromptText("Descripción");
        txtDat3.setPromptText("Num máx stack");
        txtDat4.setPromptText("URl de la imagen");

    }

    @FXML
    public void insertarItem(ActionEvent event) {

        if (txtDat1.getText().isEmpty() || txtDat2.getText().isEmpty() || txtDat3.getText().isEmpty() || txtDat4.getText().isEmpty()) {
            Alertas.camposVaciosInsertar();
        } else {
            int rowAffected = Conexion.insertarDatos("Items", txtDat1.getText(), txtDat2.getText(), txtDat3.getText(), txtDat4.getText());
            if (rowAffected == 1) {
                Alertas.infoInsertarDatos();
                txtDat1.clear();
                txtDat2.clear();
                txtDat3.clear();
                txtDat4.clear();
            } else {
                Alertas.errorInsertarDatos();
            }
        }
    }
}
