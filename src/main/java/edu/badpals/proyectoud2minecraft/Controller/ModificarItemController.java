package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class ModificarItemController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCargar;

    @FXML
    private ComboBox<String> cmbTipoItem;

    @FXML
    private TextField idItem;

    @FXML
    private AnchorPane tablaActual;

    @FXML
    private TextField txtDato1;

    @FXML
    private TextField txtDato2;

    @FXML
    private TextField txtDato3;

    @FXML
    private TextField txtDato4;

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
            case "Items":
                setDatosItems();
                break;
        }
    }

    @FXML
    void cargarDatos(ActionEvent event) {
        String tabla = cmbTipoItem.getValue();
        String id = idItem.getText();
        try {
            List<String> datos = Conexion.cargarDatosObjeto(tabla, id);
            txtDato1.setText(datos.get(1));
            txtDato2.setText(datos.get(2));
            txtDato3.setText(datos.get(3));
            txtDato4.setText(datos.get(4));
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar los datos");
            alert.setContentText("No se pudo cargar los datos del objeto, comprueba la ID y la tabla seleccionada");
            alert.showAndWait();
        }
    }

    @FXML
    void modificarItem(ActionEvent event) {
        String tabla = cmbTipoItem.getValue();
        String id = idItem.getText();
        String dato1 = txtDato1.getText();
        String dato2 = txtDato2.getText();
        String dato3 = txtDato3.getText();
        String dato4 = txtDato4.getText();
        try {
            Conexion.modificarObjeto(tabla, id, dato1, dato2, dato3, dato4);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Objeto modificado");
            alert.setContentText("El objeto ha sido modificado correctamente");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al modificar el objeto");
            alert.setContentText("No se pudo modificar el objeto, comprueba los datos introducidos");
            alert.showAndWait();
        }
    }

    private void setDatosItems() {
        txtDato2.setPromptText("Descripción");
        txtDato3.setPromptText("Stack (num)");
        txtDato4.setPromptText("Imagen URL");

        borrarCasillas();
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

    private void borrarCasillas() {
        txtDato1.setText("");
        txtDato2.setText("");
        txtDato3.setText("");
        txtDato4.setText("");
    }

}