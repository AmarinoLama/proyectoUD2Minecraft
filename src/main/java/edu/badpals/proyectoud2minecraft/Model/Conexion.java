package edu.badpals.proyectoud2minecraft.Model;

import java.security.spec.ECField;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conexion {


    private static Connection connectDB() {

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbddr_minecraft", "root", "root");
            return conexion;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return null;
        }

    }

    public static List<Item> cargarItems() {

        String sqQuery = "SELECT * FROM items";

        try (PreparedStatement pstmt = connectDB().prepareStatement(sqQuery)) {

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
            return listaItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Book> cargarBooks() {

        String sqQuery = "SELECT * FROM Books";

        try (PreparedStatement pstmt = connectDB().prepareStatement(sqQuery)) {

            List<Book> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int BkId = resultado.getInt("BkId");
                String BkName = resultado.getString("BkName");
                String BkType = resultado.getString("BkType");
                String BkEnchantment = resultado.getString("BkEnchantment");

                if (BkEnchantment == null) {
                    BkEnchantment = "-";
                };

                Integer BkLevel = resultado.getInt("BkLevel");

                Book itemActual = new Book(BkId, BkName, BkType, BkEnchantment, BkLevel);
                listaItems.add(itemActual);

            }
            return listaItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }






}
