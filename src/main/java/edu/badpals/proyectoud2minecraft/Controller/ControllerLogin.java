package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import edu.badpals.proyectoud2minecraft.View.Alertas;
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
    private PasswordField lblContrasena;

    @FXML
    private TextField lblUsuario;

    @FXML
    private Label txtContrasena;

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

        String usuario = lblUsuario.getText();
        String contrasena = lblContrasena.getText();


        if (validatePass(usuario, contrasena)) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainview.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Proyecto UD2 Minecraft");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Stage currentStage = (Stage) btnLogin.getScene().getWindow();
            currentStage.close();
            stage.show();

        } else {
            txtError.setText("Usuario y/o contraseña incorrectos");
        }
    }

    public Label getTxtContrasena() {
        return txtContrasena;
    }

    public Label getTxtCredenciales() {
        return txtCredenciales;
    }

    private static Connection connectDB() {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd_credentials", "root", "root");
            return conexion;
        } catch (SQLException e) {
            Alertas.noConexionBBDDUsers();
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
            Alertas.errorHasher();
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
            Alertas.errorGetUsers();
            return null;
        }
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



            if (encontrarUsuarioPorNombre(listaUsuariosRegistrados,user) == null) {
                return false;
            } else {

                User usuarioComprobado = encontrarUsuarioPorNombre(listaUsuariosRegistrados, user);


                String hasedPass = hasher(password);

                return usuarioComprobado.getPassword().equals(hasedPass);

            }

        } catch (Exception e) {
            Alertas.errorValidacion();
            return false;
        }

    }
}