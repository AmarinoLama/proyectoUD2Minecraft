package edu.badpals.proyectoud2minecraft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
        MainController.queryItemsFiltrados = query;
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    private String buildOrderQuery() {
        StringBuilder query = new StringBuilder("SELECT * FROM items");
        boolean hasCondition = false;
        if (cbxLetras.isSelected() | cbxPalabra.isSelected() | chbx64.isSelected()) {
            query.append(" WHERE ");
            if (chbx64.isSelected()) {
                query.append("ItmStackSize >= 64");
                hasCondition = true;
            }
            if (cbxPalabra.isSelected()) {
                if (hasCondition) query.append(" AND ");
                query.append("LENGTH(ItmName) - LENGTH(REPLACE(ItmName, ' ', '')) + 1 = 1");
                hasCondition = true;
            }
            if (cbxLetras.isSelected()) {
                if (hasCondition) query.append(" AND ");
                query.append("LENGTH(ItmDesc) > 30");
            }
        }
        query.append(" ORDER BY ");
        if (rbtNombre.isSelected()) {
            query.append("ItmName");
        } else if (rbtnDescrip.isSelected()) {
            query.append("ItmDesc");
        } else if (rbtnId.isSelected()) {
            query.append("ItmId");
        } else if (rbtnImagen.isSelected()) {
            query.append("ItmImage");
        } else if (rbtnStack.isSelected()) {
            query.append("ItmStackSize");
        }

        return query.toString();
    }
}