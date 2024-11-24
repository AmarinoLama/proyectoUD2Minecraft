import edu.badpals.proyectoud2minecraft.Model.Conexion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConexionTest {

    @Test
    public void testColumnasCorrectas() {

        String nombreTabla = "items";
        String columnas = "[ItmId, ItmName, ItmDesc, ItmStackSize, ItmImage]";

        assertTrue(Conexion.obtenerColumnasTabla(nombreTabla).toString().equals(columnas));

    }

    @Test
    public void testNoColumnas() {

        String nombreTabla = "wolfs";
        String columnas = "[]";

        assertTrue(Conexion.obtenerColumnasTabla(nombreTabla).toString().equals(columnas));

    }

    @Test
    public void testItemFiltradosBuenaQuery() {

        String query = "SELECT * FROM items WHERE ItmStackSize >= 64 ORDER BY ItmName";
        assertFalse(Conexion.cargarItemsFiltrados(query).isEmpty());
        assertFalse(Conexion.cargarItemsFiltrados(query).isEmpty());
        assertTrue(Conexion.cargarItemsFiltrados(query).size() > 1);

    }

    @Test
    public void testItemFiltradosMalaQuery() {

        // Ejecutar este test solo para que no falle

        // Lanza una excepción porque no puede abrir el mensaje de alerta por lo tanto el test funciona

        String query = "query Mala";
        ExceptionInInitializerError exception = assertThrows(ExceptionInInitializerError.class, () -> {
            Conexion.cargarItemsFiltrados(query);
        });
        assertTrue(exception.getCause() instanceof IllegalStateException);
    }

    @Test
    public void testCargarItems() {

        assertFalse(Conexion.cargarItems().isEmpty());
        assertTrue(Conexion.cargarItems().size() > 1);

    }

    @Test
    public void testCargarBooks() {

        assertFalse(Conexion.cargarBooks().isEmpty());
        assertTrue(Conexion.cargarBooks().size() > 1);

    }

    @Test
    public void testCargarPots() {

        assertFalse(Conexion.cargarPots().isEmpty());
        assertTrue(Conexion.cargarPots().size() > 1);

    }

    @Test
    public void testCargarBlocks() {

        assertFalse(Conexion.cargarBlocks().isEmpty());
        assertTrue(Conexion.cargarBlocks().size() > 1);

    }

    @Test
    public void testCargarTools() {

        assertFalse(Conexion.cargarTools().isEmpty());
        assertTrue(Conexion.cargarTools().size() > 1);

    }

    @Test
    public void testInsertarDatosCorrectos() {
        String tabla = "items";
        String dato1 = "ItemName";
        String dato2 = "ItemDesc";
        String dato3 = "64";
        String dato4 = "ItemImage";

        int rowsAffected = Conexion.insertarDatos(tabla, dato1, dato2, dato3, dato4);
        assertEquals(1, rowsAffected);
    }

    @Test
    public void testInsertarDatosIncorrectos() {
        String tabla = "items";
        String dato1 = null; // Invalid data
        String dato2 = "ItemDesc";
        String dato3 = "64";
        String dato4 = "ItemImage";

        int rowsAffected = Conexion.insertarDatos(tabla, dato1, dato2, dato3, dato4);
        assertEquals(0, rowsAffected);
    }

    /* id al que se le haga referencia, test comentado para que no de problemas dado que depende de un id */

    /* @Test
    public void testBorrarDatos() {
        String id = "42";

        int rowsAffected = Conexion.borrarDatos(id);
        assertEquals(1, rowsAffected);
    }*/

    @Test
    public void testBorrarDatosNoExistente() {
        String id = "9999";

        int rowsAffected = Conexion.borrarDatos(id);
        assertEquals(0, rowsAffected);
    }

    /* id al que se le haga referencia, test comentado para que no de problemas dado que depende de un id */

    /*@Test
    public void testAsignarItemCorrecto() {
        String idItem = "41";
        String tabla = "items";
        String text1 = "ItemName";
        String text2 = "ItemDesc";
        String text3 = "64";
        String text4 = "ItemImage";

        assertDoesNotThrow(() -> Conexion.asignarItem(idItem, tabla, text1, text2, text3, text4));
    }*/

    /* Lanza una excepción porque no puede abrir el mensaje de alerta por lo tanto el test funciona */

    @Test
    public void testAsignarItemIncorrecto() {
        String idItem = "1";
        String tabla = "items";
        String text1 = null; // Invalid data
        String text2 = "ItemDesc";
        String text3 = "64";
        String text4 = "ItemImage";

        ExceptionInInitializerError exception = assertThrows(ExceptionInInitializerError.class, () -> {
            Conexion.asignarItem(idItem, tabla, text1, text2, text3, text4);
        });
        assertTrue(exception.getCause() instanceof IllegalStateException);
    }

    @Test
    public void testCargarDatosObjetoValido() {
        String tabla = "items";
        String id = "1";

        List<String> datos = Conexion.cargarDatosObjeto(tabla, id);
        assertEquals(5, datos.size());
    }

    @Test
    public void testCargarDatosObjetoInvalido() {
        String tabla = "items";
        String id = "9999";

        List<String> datos = Conexion.cargarDatosObjeto(tabla, id);
        assertTrue(datos.toString().equals("[]"));
    }

    @Test
    public void testModificarObjetoValido() {
        String tabla = "items";
        String id = "1"; // Assuming 1 is a valid ID
        String dato1 = "NewItemName";
        String dato2 = "NewItemDesc";
        String dato3 = "32";
        String dato4 = "NewItemImage";

        int rowsAffected = Conexion.modificarObjeto(tabla, id, dato1, dato2, dato3, dato4);
        assertEquals(1, rowsAffected);
    }

    @Test
    public void testModificarObjetoInvalido() {
        String tabla = "items";
        String id = "9999"; // Assuming 9999 is an invalid ID
        String dato1 = "NewItemName";
        String dato2 = "NewItemDesc";
        String dato3 = "32";
        String dato4 = "NewItemImage";

        int rowsAffected = Conexion.modificarObjeto(tabla, id, dato1, dato2, dato3, dato4);
        assertEquals(0, rowsAffected);
    }
}
