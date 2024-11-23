package edu.badpals.proyectoud2minecraft.View;

import javafx.scene.control.Alert;

public class Alertas {

    public static void errorCargarDatos() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al cargar los datos");
        alert.setContentText("No se pudo cargar los datos del objeto, comprueba la ID y la tabla seleccionada");
        alert.showAndWait();
    }

    public static void infoObjetoModif() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Objeto modificado");
        alert.setContentText("El objeto ha sido modificado correctamente");
        alert.showAndWait();
    }

    public static void errorModifObjeto() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al modificar el objeto");
        alert.setContentText("No se pudo modificar el objeto, comprueba los datos introducidos");
        alert.showAndWait();
    }

    public static void errorAbrirVentana() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al abrir la ventana filtrar");
        alert.setContentText("La ventana filtrar solo se puede abrir en la table de items");
        alert.showAndWait();
    }
}
