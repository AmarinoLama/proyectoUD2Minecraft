module edu.badpals.proyectoud2minecraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires java.sql;

    opens edu.badpals.proyectoud2minecraft.Model to javafx.base;
    exports edu.badpals.proyectoud2minecraft;
    exports edu.badpals.proyectoud2minecraft.Controller;
    opens edu.badpals.proyectoud2minecraft.Controller to javafx.fxml;
    exports edu.badpals.proyectoud2minecraft.Model;
    exports edu.badpals.proyectoud2minecraft.Model.Objetos;
    opens edu.badpals.proyectoud2minecraft.Model.Objetos to javafx.base;

}