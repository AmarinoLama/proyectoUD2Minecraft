package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.badpals.proyectoud2minecraft.Model.Objetos.*;
import edu.badpals.proyectoud2minecraft.View.Alertas;

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
                Alertas.errorExportarDatos();
        }

    }

    private static void transaccionExportar(List<?> listaObjetos, String tipoObjeto, String rutaArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (Objects.equals(rutaArchivo, "")) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/ExportacionesDefecto/" + tipoObjeto + ".json"), listaObjetos);
                Alertas.infoJSONgeneradoDefault(tipoObjeto);
            } else {
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(rutaArchivo + "/" + tipoObjeto + ".json"), listaObjetos);
                Alertas.infoJSONgeneradoRuta(tipoObjeto, rutaArchivo);
            }
        } catch (Exception e) {
            Alertas.errorExportarDatos();
        }
    }
}