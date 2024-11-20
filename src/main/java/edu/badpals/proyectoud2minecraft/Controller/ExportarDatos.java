package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.*;
import javafx.scene.control.Alert;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
public class ExportarDatos {

    public static void exportarAJSON(String tipoObjeto, String rutaArchivo) {

        ObjectMapper mapper = new ObjectMapper();

        switch (tipoObjeto) {
            case "Item":

                List<Item> listaItems  = new ArrayList<>();
                listaItems = Conexion.cargarItems();

                transaccionExportar(listaItems,tipoObjeto, rutaArchivo);

                break;
            case "Tool":

                List<Tool> listaTools  = new ArrayList<>();
                listaTools = Conexion.cargarTools();

                transaccionExportar(listaTools, tipoObjeto, rutaArchivo);

                break;
            case "Book":

                List<Book> listaBooks  = new ArrayList<>();
                listaBooks = Conexion.cargarBooks();

                transaccionExportar(listaBooks,tipoObjeto, rutaArchivo);

                break;
            case "Potion":
                List<Potion> listaPotions  = new ArrayList<>();
                listaPotions = Conexion.cargarPots();

                transaccionExportar(listaPotions,tipoObjeto, rutaArchivo);

                break;
            case "Block":

                List<Block> listaBlocks = new ArrayList<>();
                listaBlocks = Conexion.cargarBlocks();

                transaccionExportar(listaBlocks,tipoObjeto, rutaArchivo);

            default:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exportar a JSON");
                alert.setHeaderText("Error en la exportación");
                alert.setContentText("No se ha podido llevar a cabo la exportación");
                alert.showAndWait();
                return;
        }

    }

    private static void transaccionExportar(List<?> listaObjetos, String tipoObjeto, String rutaArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (rutaArchivo == null) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/ExportacionesDefecto/" + tipoObjeto + ".json"), listaObjetos);
            } else {
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(rutaArchivo + tipoObjeto + ".json"), listaObjetos);
                System.out.println("Archivo JSON generado correctamente: " + rutaArchivo + tipoObjeto + ".json");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
