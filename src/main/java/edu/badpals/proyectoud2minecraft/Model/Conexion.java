package edu.badpals.proyectoud2minecraft.Model;

import java.security.spec.ECField;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Conexion {


    private static Connection connectDB() {

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "root");
            return conexion;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return null;
        }

    }

    public static List<Items> cargarItems() {

        String sqQuery = "SELECT * FROM items";

        try (PreparedStatement pstmt = connectDB().prepareStatement(sqQuery)) {

            pstmt.setString(1, nombreDepartamento);

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("Num_proxecto");
                String nome_proxecto = resultado.getString("Nome_proxecto");
                String lugar = resultado.getString("Lugar");
                Integer num_departamento = resultado.getInt("Num_departamento");

                Proxecto proxectoAMostrar = new Proxecto(id, nome_proxecto, lugar, num_departamento);
                System.out.println(proxectoAMostrar.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }






}
