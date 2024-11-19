package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class AnadirDatosController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBorrar;

    @FXML
    private TextField idBorrar;

    @FXML
    private TextField idPrincipal;

    @FXML
    private Toggle rbtnGroup;

    @FXML
    private RadioButton rbtAnadir;

    @FXML
    private RadioButton rbtnModif;

    @FXML
    private TextField txtDat1;

    @FXML
    private TextField txtDat2;

    @FXML
    private TextField txtDat3;

    @FXML
    private TextField txtDat4;

    @FXML
    private Text txtTabla;

    @FXML
    public void initialize() {
        idPrincipal.setDisable(true);
        idPrincipal.setPromptText("No disponible");
    }

    @FXML
    public void insertarItem(ActionEvent event) {
        int rowAffected = Conexion.insertarDatos("Items", txtDat1.getText(), txtDat2.getText(), txtDat3.getText(), txtDat4.getText());
        if (rowAffected == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Inserción exitosa");
            alert.setContentText("El dato ha sido insertado correctamente");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al insertar");
            alert.setContentText("El dato no ha podido ser insertado");
            alert.showAndWait();
        }
    }
}
