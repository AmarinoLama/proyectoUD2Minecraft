package edu.badpals.proyectoud2minecraft.Model;

import edu.badpals.proyectoud2minecraft.Model.Objetos.*;
import edu.badpals.proyectoud2minecraft.View.Alertas;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

    private static Connection conexion;

    private static Connection abrirConexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbddr_minecraft", "root", "root");
            return conexion;
        } catch (SQLException e) {
            Alertas.errorConexionBBDDMc();
            return null;
        }
    }

    private static void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            Alertas.errorCerrarConexion();
        }
    }

    public static List<Item> cargarItems() {

        String sqQuery = "SELECT * FROM items";
        abrirConexion();
        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {

            List<Item> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int ItmId = resultado.getInt("ItmId");
                String ItmName = resultado.getString("ItmName");
                String ItmDesc = resultado.getString("ItmDesc");
                Integer ItmStackSize = resultado.getInt("ItmStackSize");
                String ItmImage = resultado.getString("ItmImage");

                Item itemActual = new Item(ItmId, ItmName, ItmDesc, ItmStackSize, ItmImage);
                listaItems.add(itemActual);

            }
            resultado.close();
            cerrarConexion();
            return listaItems;
        } catch (SQLException e) {
            Alertas.errorCargarTabla();
            cerrarConexion();
            return null;
        }

    }

    public static List<Item> cargarItemsFiltrados(String query) {

        abrirConexion();
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {

            List<Item> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int ItmId = resultado.getInt("ItmId");
                String ItmName = resultado.getString("ItmName");
                String ItmDesc = resultado.getString("ItmDesc");
                Integer ItmStackSize = resultado.getInt("ItmStackSize");
                String ItmImage = resultado.getString("ItmImage");

                Item itemActual = new Item(ItmId, ItmName, ItmDesc, ItmStackSize, ItmImage);
                listaItems.add(itemActual);

            }
            resultado.close();
            cerrarConexion();
            return listaItems;
        } catch (SQLException e) {
            Alertas.errorCargarTabla();
            cerrarConexion();
            return null;
        }

    }

    public static List<Book> cargarBooks() {

        String sqQuery = "SELECT * FROM Books";
        abrirConexion();
        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {

            List<Book> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int BkId = resultado.getInt("BkId");
                String BkName = resultado.getString("BkName");
                TipoLibro BkType = TipoLibro.valueOf(resultado.getString("BkType").toUpperCase());
                String BkEnchantment = resultado.getString("BkEnchantment");

                if (BkEnchantment == null) {
                    BkEnchantment = "Mundano";
                }

                Integer BkLevel = resultado.getInt("BkLevel");

                Book itemActual = new Book(BkId, BkName, BkType, BkEnchantment, BkLevel);
                listaItems.add(itemActual);

            }
            resultado.close();
            cerrarConexion();
            return listaItems;
        } catch (SQLException e) {
            Alertas.errorCargarTabla();
            cerrarConexion();
            return null;
        }
    }

    public static List<Potion> cargarPots() {

        String sqQuery = "SELECT * FROM Potions";
        abrirConexion();

        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {

            List<Potion> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int PotId = resultado.getInt("PotId");
                String PotName = resultado.getString("PotName");
                String PotEffect = resultado.getString("PotEffect");
                Integer PotDuration = resultado.getInt("PotDuration");
                Integer PotLevel = resultado.getInt("PotLevel");

                Potion itemActual = new Potion(PotId, PotName, PotEffect, PotDuration, PotLevel);
                listaItems.add(itemActual);

            }
            resultado.close();
            cerrarConexion();
            return listaItems;
        } catch (SQLException e) {
            Alertas.errorCargarTabla();
            cerrarConexion();
            return null;
        }

    }

    public static List<Block> cargarBlocks() {

        String sqQuery = "SELECT * FROM Blocks";
        abrirConexion();

        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {

            List<Block> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int BlkId = resultado.getInt("BlkId");
                String BlkIdName = resultado.getString("BlkIdName");
                Integer BlkLuminosity = resultado.getInt("BlkLuminosity");
                Integer BlkBlastResistance = resultado.getInt("BlkBlastResistance");
                Integer BlkFlammable = resultado.getInt("BlkFlammable");

                Block itemActual = new Block(BlkId, BlkIdName, BlkLuminosity, BlkBlastResistance, BlkFlammable);
                listaItems.add(itemActual);

            }
            resultado.close();
            cerrarConexion();
            return listaItems;
        } catch (SQLException e) {
            Alertas.errorCargarTabla();
            cerrarConexion();
            return null;
        }

    }

    public static List<Tool> cargarTools() {

        String sqQuery = "SELECT * FROM tools";
        abrirConexion();

        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {

            List<Tool> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int ToolId = resultado.getInt("ToolId");
                String ToolName = resultado.getString("ToolName");
                Integer ToolDurability = resultado.getInt("ToolDurability");
                Integer ToolFlammable = resultado.getInt("ToolFlammable");
                Integer ToolDamage = resultado.getInt("ToolDamage");

                Tool itemActual = new Tool(ToolId, ToolName, ToolDurability, ToolFlammable, ToolDamage);
                listaItems.add(itemActual);

            }
            resultado.close();
            cerrarConexion();
            return listaItems;
        } catch (SQLException e) {
            Alertas.errorCargarTabla();
            cerrarConexion();
            return null;
        }

    }

    public static int insertarDatos(String tabla, String dato1, String dato2, String dato3, String dato4) {

        String sqQuery = "INSERT INTO " + tabla + " VALUES (null, ?, ?, ?, ?)";
        abrirConexion();

        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {

            pstmt.setString(1, dato1);
            pstmt.setString(2, dato2);
            pstmt.setString(3, dato3);
            pstmt.setString(4, dato4);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            cerrarConexion();
            return rowsAffected;

        } catch (SQLException e) {
            cerrarConexion();
            return 0;
        }
    }

    public static int borrarDatos(String text) {

        String sqQuery = "DELETE FROM Items WHERE ItmId = ?";
        abrirConexion();

        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {

            pstmt.setString(1, text);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            cerrarConexion();
            return rowsAffected;

        } catch (SQLException e) {
            Alertas.errorBorrarIdVacio();
            cerrarConexion();
            return 0;
        }
    }

    public static List<String> obtenerColumnasTabla(String tabla) {
        List<String> columnas = new ArrayList<>();
        abrirConexion();
        try {
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet rs = metaData.getColumns("bbddr_minecraft", null, tabla, null);
            while (rs.next()) {
                String columna = rs.getString("COLUMN_NAME");
                columnas.add(columna);
            }
            rs.close();
            cerrarConexion();
        } catch (SQLException e) {
            Alertas.errorObtenerColumnas();
        }
        return columnas;
    }

    public static void asignarItem(String idItem, String tabla, String text1, String text2, String text3, String text4) {

        String query = "INSERT INTO " + tabla + " VALUES ('" + idItem + "', '" + text1 + "', '" + text2 + "', '" + text3 + "', '" + text4 + "')";
        abrirConexion();
        try {
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(query);
            Alertas.infoAsignacionCorrecta();
            stmt.close();
            cerrarConexion();
        } catch (SQLException e) {
            Alertas.errorAsignacion();
            cerrarConexion();
        }
    }

    public static List<String> cargarDatosObjeto(String tabla, String id) {
        List<String> datosTabla = obtenerColumnasTabla(tabla);
        String sqQuery = "SELECT * FROM " + tabla + " WHERE " + datosTabla.get(0) + " = " + id;
        List<String> datos = new ArrayList<>();
        abrirConexion();
        try (Statement stmt = conexion.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sqQuery);
            ResultSetMetaData rsmd = resultado.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultado.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    datos.add(resultado.getString(i));
                }
            }
            resultado.close();
            cerrarConexion();
        } catch (SQLException e) {
            cerrarConexion();
            return null;
        }
        return datos;
    }

    public static int modificarObjeto(String tabla, String id, String dato1, String dato2, String dato3, String dato4) {
        List<String> datosTabla = obtenerColumnasTabla(tabla);
        String sqQuery = "UPDATE " + tabla + " SET " + datosTabla.get(1) + " = ?, " + datosTabla.get(2) + " = ?, " + datosTabla.get(3) + " = ?, " + datosTabla.get(4) + " = ? WHERE " + datosTabla.get(0) + " = ?";
        abrirConexion();
        try (PreparedStatement pstmt = conexion.prepareStatement(sqQuery)) {
            pstmt.setString(1, dato1);
            pstmt.setString(2, dato2);
            pstmt.setString(3, dato3);
            pstmt.setString(4, dato4);
            pstmt.setString(5, id);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            cerrarConexion();
            return rowsAffected;
        } catch (SQLException e) {
            cerrarConexion();
            return 0;
        }
    }
}