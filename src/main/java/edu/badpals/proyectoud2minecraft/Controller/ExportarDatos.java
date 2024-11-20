package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import javafx.scene.control.Alert;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ExportarDatos {

    public static void exportarAJSON(String tipoObjeto, String nombreArchivo) {


        List<Object> listaItems = new ArrayList<>();

        switch (tipoObjeto) {
            case "Item":
                listaItems = Collections.singletonList(Conexion.cargarItems());
                break;
            case "Tool":
                listaItems = Collections.singletonList(Conexion.cargarTools());
                break;
            case "Book":
                listaItems = Collections.singletonList(Conexion.cargarBooks());
                break;
            case "Potion":
                listaItems = Collections.singletonList(Conexion.cargarPots());
                break;
            case "Block":
                listaItems = Collections.singletonList(Conexion.cargarBlocks());
                break;

            default:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exportar a JSON");
                alert.setHeaderText("Error en la exportación");
                alert.setContentText("No se has podido llevar a cabo la exportacion");
                alert.showAndWait();
                break;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(nombreArchivo), lista);
            System.out.println("Archivo JSON generado correctamente: " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
