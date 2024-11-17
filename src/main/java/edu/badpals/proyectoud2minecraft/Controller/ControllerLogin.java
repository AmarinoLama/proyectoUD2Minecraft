package edu.badpals.proyectoud2minecraft.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

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
}