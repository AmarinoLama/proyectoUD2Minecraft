package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerLogin {

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView imgLogin;

    @FXML
    private PasswordField lblContraseña;

    @FXML
    private TextField lblUsuario;

    @FXML
    private Label txtContraseña;

    @FXML
    private Label txtCredenciales;

    @FXML
    private Label txtError;

    @FXML
    private Label txtUsuario;

    /*

    btnLoginClicked(ActionEvent event) llama a validatePass() y comprueba si el usuario y la contraseña están en el archivo de configuracion config.properties.
    Si la validación es correcta, da paso a la siguiente ventana. Y si no, informa de que la contraseña y/o el usuario son incorrectos.

     */


    @FXML
    void btnLoginClicked(ActionEvent event) throws IOException {
        System.out.println("Login button clicked");
    }

    public Label getTxtContraseña() {
        return txtContraseña;
    }

    public Label getTxtCredenciales() {
        return txtCredenciales;
    }

    private static Connection connectDB() {

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd_credentials", "root", "root");
            return conexion;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return null;
        }

    }


    public static String hasher(String password) {

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    public static List<User> getUsersAndPasswords() {

        String sqQuery = "SELECT * FROM credentials";

        try (PreparedStatement pstmt = connectDB().prepareStatement(sqQuery)) {

            List<User> listaItems = new ArrayList<>();

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {

                String name = resultado.getString("UsrName");
                String pass = resultado.getString("PwdUser");

                User itemActual = new User(name, pass);
                listaItems.add(itemActual);

            }
            return listaItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean comprobarMatchUsuario(List<User> usuarios, String usuarioProvisto) {

        for (User usuario: usuarios){
            if (usuario.getName() != usuarioProvisto) {

            } else {
                return true;
            }
        }
        return false;
    }

    private static User encontrarUsuarioPorNombre(List<User> usuarios, String usuarioProvisto) {

        for (User usuario : usuarios) {
            if (usuario != null && usuario.getName().equals(usuarioProvisto)) {
                return usuario;
            }
        }
        return null;
    }



    public static boolean validatePass(String user, String password) {

        try{

            List<User> listaUsuariosRegistrados = getUsersAndPasswords();

            if (!comprobarMatchUsuario(listaUsuariosRegistrados,user) || encontrarUsuarioPorNombre(listaUsuariosRegistrados,user) == null) {
                return false;
            } else {

                User usuarioComprobado = encontrarUsuarioPorNombre(listaUsuariosRegistrados, user);


                String hasedPass = hasher(password);

                return usuarioComprobado.getPassword().equals(hasedPass);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}