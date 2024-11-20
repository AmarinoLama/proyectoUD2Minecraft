package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.*;
import javafx.scene.control.Alert;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.File;
import java.util.*;

public class ExportarDatos {

    public static void exportarAJSON(String tipoObjeto, String rutaArchivo) {

        switch (tipoObjeto) {
            case "Items":

                List<Item> listaItems  = Conexion.cargarItems();

                transaccionExportar(listaItems,tipoObjeto, rutaArchivo);

                break;
            case "Tools":

                List<Tool> listaTools  = Conexion.cargarTools();

                transaccionExportar(listaTools, tipoObjeto, rutaArchivo);

                break;
            case "Books":

                List<Book> listaBooks  = Conexion.cargarBooks();

                transaccionExportar(listaBooks,tipoObjeto, rutaArchivo);

                break;
            case "Potions":
                List<Potion> listaPotions  = Conexion.cargarPots();

                transaccionExportar(listaPotions,tipoObjeto, rutaArchivo);

                break;
            case "Blocks":

                List<Block> listaBlocks = Conexion.cargarBlocks();

                transaccionExportar(listaBlocks,tipoObjeto, rutaArchivo);
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exportar a JSON");
                alert.setHeaderText("Error en la exportación");
                alert.setContentText("No se ha podido llevar a cabo la exportación");
                alert.showAndWait();
        }

    }

    private static void transaccionExportar(List<?> listaObjetos, String tipoObjeto, String rutaArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Archivo generado");
            if (Objects.equals(rutaArchivo, "")) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/ExportacionesDefecto/" + tipoObjeto + ".json"), listaObjetos);
                alert.setContentText("Archivo JSON generado correctamente: " + ".../src/main/resources/ExportacionesDefecto/" + tipoObjeto + ".json");
            } else {
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(rutaArchivo + "/" + tipoObjeto + ".json"), listaObjetos);
                alert.setContentText("Archivo JSON generado correctamente: " + rutaArchivo + "/" + tipoObjeto + ".json");
            }
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}