module edu.badpals.proyectoud2minecraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires java.sql;

    opens edu.badpals.proyectoud2minecraft to javafx.fxml;
    exports edu.badpals.proyectoud2minecraft;
    opens edu.badpals.proyectoud2minecraft.Controller to javafx.fxml; // Ensure this line is present
}