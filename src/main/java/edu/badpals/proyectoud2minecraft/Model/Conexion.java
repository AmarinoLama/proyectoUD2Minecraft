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
                    BkEnchantment = "Mundano";
                }
                ;

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

    public static List<Potion> cargarPots() {

        String sqQuery = "SELECT * FROM Potions";

        try (PreparedStatement pstmt = connectDB().prepareStatement(sqQuery)) {

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
            return listaItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Block> cargarBlocks() {

        String sqQuery = "SELECT * FROM Blocks";

        try (PreparedStatement pstmt = connectDB().prepareStatement(sqQuery)) {

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
            return listaItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Tool> cargarTools() {

        String sqQuery = "SELECT * FROM tools";

        try (PreparedStatement pstmt = connectDB().prepareStatement(sqQuery)) {

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
            return listaItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}

