package edu.badpals.proyectoud2minecraft.View;

import javafx.scene.control.Alert;

public class Alertas {

    private static Alert info = new Alert(Alert.AlertType.INFORMATION);
    private static Alert error = new Alert(Alert.AlertType.ERROR);

    public static void errorCargarDatos() {
        error.setTitle("Error");
        error.setHeaderText("Error al cargar los datos");
        error.setContentText("No se pudo cargar los datos del objeto, comprueba la ID y la tabla seleccionada");
        error.showAndWait();
    }

    public static void infoObjetoModif() {
        info.setTitle("Información");
        info.setHeaderText("Objeto modificado");
        info.setContentText("El objeto ha sido modificado correctamente");
        info.showAndWait();
    }

    public static void errorModifObjeto() {
        error.setTitle("Error");
        error.setHeaderText("Error al modificar el objeto");
        error.setContentText("No se pudo modificar el objeto, comprueba los datos introducidos");
        error.showAndWait();
    }

    public static void errorAbrirVentana() {
        error.setTitle("Error");
        error.setHeaderText("Error al abrir la ventana filtrar");
        error.setContentText("La ventana filtrar solo se puede abrir en la tabla de items");
        error.showAndWait();
    }

    public static void errorCargarTabla() {
        error.setTitle("Error");
        error.setHeaderText("Error al cargar tabla");
        error.setContentText("La tabla con los datos no se ha podido cargar");
        error.showAndWait();
    }

    public static void errorAnadirDatos() {
        error.setTitle("Error");
        error.setHeaderText("Error al añadir datos");
        error.setContentText("El dato no se ha podido añadir, comprueba los datos introducidos");
        error.showAndWait();
    }

    public static void errorBorrarDatos() {
        error.setTitle("Error");
        error.setHeaderText("Error al borrar datos");
        error.setContentText("El dato no se ha podido borrar, comprueba los datos introducidos");
        error.showAndWait();
    }

    public static void errorAsignarDatosItem() {
        error.setTitle("Error");
        error.setHeaderText("Error al asignar datos");
        error.setContentText("No se han podido asignar los datos al item, comprueba los datos introducidos");
        error.showAndWait();
    }

    public static void errorAbrirVentanaCatch() {
        error.setTitle("Error");
        error.setHeaderText("Error al abrir la ventana");
        error.setContentText("No se ha podido abrir la ventana, comprueba los datos introducidos");
        error.showAndWait();
    }

    public static void errorExportarDatos() {
        error.setTitle("Exportar a JSON");
        error.setHeaderText("Error en la exportación");
        error.setContentText("No se ha podido llevar a cabo la exportación");
        error.showAndWait();
    }

    public static void infoJSONgeneradoDefault(String tipoObjeto) {
        info.setTitle("Información");
        info.setHeaderText("Archivo generado");
        info.setContentText("Archivo JSON generado correctamente: " + ".../src/main/resources/ExportacionesDefecto/" + tipoObjeto + ".json");
        info.showAndWait();
    }

    public static void infoJSONgeneradoRuta(String tipoObjeto, String rutaArchivo) {
        info.setTitle("Información");
        info.setHeaderText("Archivo generado");
        info.setContentText("Archivo JSON generado correctamente: " + rutaArchivo + "/" + tipoObjeto + ".json");
        info.showAndWait();
    }

    public static void errorBorrarIdVacio() {
        error.setTitle("Error");
        error.setHeaderText("Error al borrar");
        error.setContentText("El campo de ID no puede estar vacío");
        error.showAndWait();
    }

    public static void infoBorrado() {
        info.setTitle("Información");
        info.setHeaderText("Borrado exitoso");
        info.setContentText("El dato ha sido borrado correctamente");
        info.showAndWait();
    }

    public static void errorBorrar() {
        error.setTitle("Error");
        error.setHeaderText("Error al borrar");
        error.setContentText("No se ha podido borrar el dato");
        error.showAndWait();
    }

    public static void noConexionBBDDUsers() {
        error.setTitle("Error");
        error.setHeaderText("Error de conexión");
        error.setContentText("No se ha podido conectar a la base de datos de usuarios");
        error.showAndWait();
    }

    public static void errorHasher() {
        error.setTitle("Error");
        error.setHeaderText("Error al encriptar la contraseña");
        error.setContentText("No se ha podido encriptar la contraseña");
        error.showAndWait();
    }

    public static void errorGetUsers() {
        error.setTitle("Error");
        error.setHeaderText("Error al obtener los datos");
        error.setContentText("No se han podido obtener los usuarios y contraseña de la base de datos");
        error.showAndWait();
    }

    public static void errorValidacion() {
        error.setTitle("Error");
        error.setHeaderText("Error al validar");
        error.setContentText("No se ha podido validar el usuario y la contraseña");
        error.showAndWait();
    }

    public static void camposVaciosInsertar() {
        error.setTitle("Error");
        error.setHeaderText("Error al insertar");
        error.setContentText("Todos los campos deben estar rellenados");
        error.showAndWait();
    }

    public static void infoInsertarDatos() {
        info.setTitle("Información");
        info.setHeaderText("Inserción exitosa");
        info.setContentText("El dato ha sido insertado correctamente");
        info.showAndWait();
    }

    public static void errorInsertarDatos() {
        error.setTitle("Error");
        error.setHeaderText("Error al insertar");
        error.setContentText("El dato no ha podido ser insertado");
        error.showAndWait();
    }

    public static void errorConexionBBDDMc() {
        error.setTitle("Error");
        error.setHeaderText("Error de conexión");
        error.setContentText("No se ha podido conectar a la base de datos de Minecraft");
        error.showAndWait();
    }

    public static void errorObtenerColumnas() {
        error.setTitle("Error");
        error.setHeaderText("Error al obtener las columnas");
        error.setContentText("No se han podido obtener las columnas de la tabla seleccionada");
        error.showAndWait();
    }

    public static void infoAsignacionCorrecta() {
        info.setTitle("Información");
        info.setHeaderText("Asignación exitosa");
        info.setContentText("El dato ha sido asignado correctamente");
        info.showAndWait();
    }

    public static void errorAsignacion() {
        error.setTitle("Error");
        error.setHeaderText("Error al asignar");
        error.setContentText("El dato no ha podido ser asignado");
        error.showAndWait();
    }

    public static void errorCerrarConexion() {
        error.setTitle("Error");
        error.setHeaderText("Error al cerrar la conexión");
        error.setContentText("No se ha podido cerrar la conexión a la base de datos");
        error.showAndWait();
    }
}