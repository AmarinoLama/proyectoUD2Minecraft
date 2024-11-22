package edu.badpals.proyectoud2minecraft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class OrdenarController {

    @FXML
    private Button btnActualizar;

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
    void ordenar(ActionEvent event) {
        String query = buildOrderQuery();
        System.out.println(query);
    }

    private String buildOrderQuery() {
        StringBuilder query = new StringBuilder("SELECT * FROM items");
        query.append(" ORDER BY ");
        if (rbtNombre.isSelected()) {
            query.append("nombre");
        } else if (rbtnDescrip.isSelected()) {
            query.append("descripcion");
        } else if (rbtnId.isSelected()) {
            query.append("id");
        } else if (rbtnImagen.isSelected()) {
            query.append("imagen");
        } else if (rbtnStack.isSelected()) {
            query.append("stack");
        }
        if (cbxLetras.isSelected() | cbxPalabra.isSelected() | chbx64.isSelected()) {
            if (chbx64.isSelected()) {
                query.append(" WHERE stack >= 64");
            }
            if (cbxPalabra.isSelected()) {
                //calentada
                query.append(" WHERE stack >= 32 AND stack < 64");
            }
            if (cbxLetras.isSelected()) {
                query.append(" WHERE LENGTH(descripcion) > 20");
            }
        }

        return query.toString();
    }

}
