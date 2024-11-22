package edu.badpals.proyectoud2minecraft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class OrdenarController {

    @FXML
    private Button btnFiltrar;

    @FXML
    private Button btnOrdenar;

    @FXML
    private CheckBox cbxLetras;

    @FXML
    private CheckBox cbxPalabra;

    @FXML
    private CheckBox chbx64;

    @FXML
    private RadioButton rbtNombre;

    @FXML
    private RadioButton rbtnDescrip;

    @FXML
    private RadioButton rbtnId;

    @FXML
    private RadioButton rbtnImagen;

    @FXML
    private RadioButton rbtnStack;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        rbtnId.setToggleGroup(toggleGroup);
        rbtnDescrip.setToggleGroup(toggleGroup);
        rbtnImagen.setToggleGroup(toggleGroup);
        rbtnStack.setToggleGroup(toggleGroup);
        rbtNombre.setToggleGroup(toggleGroup);
    }


    @FXML
    void filtrar(ActionEvent event) {

    }

    @FXML
    void ordenar(ActionEvent event) {

    }

}
