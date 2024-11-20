package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AsignarItemController {

    @FXML
    private Button btnAceptar;

    @FXML
    private ComboBox<String> cmbTipoItem;

    @FXML
    private TextField idItem;

    @FXML
    private TextField txtDato1;

    @FXML
    private TextField txtDato2;

    @FXML
    private TextField txtDato3;

    @FXML
    private TextField txtDato4;

    @FXML
    void asignarItem(ActionEvent event) {
        Conexion.asignarItem(idItem.getText(), cmbTipoItem.getValue(), txtDato1.getText(), txtDato2.getText(), txtDato3.getText(), txtDato4.getText());
    }

    @FXML
    void asignarTipo(ActionEvent event) {
        String seleccion = cmbTipoItem.getValue();
        txtDato1.setPromptText("Nombre");
        switch (seleccion) {
            case "Books":
                setDatosBooks();
                break;
            case "Potions":
                setDatosPotions();
                break;
            case "Blocks":
                setDatosBlocks();
                break;
            case "Tools":
                setDatosTools();
                break;
        }
    }

    private void setDatosTools() {
        txtDato2.setPromptText("Durabilidad (num)");
        txtDato3.setPromptText("Flameable (num)");
        txtDato4.setPromptText("Daño (num)");

        borrarCasillas();
    }

    private void setDatosBlocks() {
        txtDato2.setPromptText("Luminosidad (num)");
        txtDato3.setPromptText("Resistencia (num)");
        txtDato4.setPromptText("Flameable (num)");

        borrarCasillas();
    }

    private void setDatosPotions() {
        txtDato2.setPromptText("Efecto");
        txtDato3.setPromptText("Duración (num)");
        txtDato4.setPromptText("Nivel (num)");

        borrarCasillas();
    }

    private void setDatosBooks() {
        txtDato2.setPromptText("Normal / Encantado / Escrito");
        txtDato3.setPromptText("Encantamiento");
        txtDato4.setPromptText("Nivel (num)");

        borrarCasillas();
    }

    public void borrarCasillas() {
        txtDato1.setText("");
        txtDato2.setText("");
        txtDato3.setText("");
        txtDato4.setText("");
    }
}
