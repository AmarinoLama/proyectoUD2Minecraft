package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainController {

    @FXML
    private Button btnConsulta;

    @FXML
    private Button btnExportar;

    @FXML
    private Button btnSalir;

    @FXML
    private ComboBox<String> cmbTabla;

    @FXML
    private TableColumn<?, ?> clmDato1;

    @FXML
    private TableColumn<?, ?> clmDato2;

    @FXML
    private TableColumn<?, ?> clmDato3;

    @FXML
    private TableColumn<?, ?> clmDato4;

    @FXML
    private TableColumn<?, ?> clmID;

    @FXML
    private TableView<Object> tablaMain;

    @FXML
    void exportarJSON(ActionEvent event) {

    }

    @FXML
    public void initialize() {

        clmID.setPrefWidth(100);
        clmDato1.setPrefWidth(150);
        clmDato2.setPrefWidth(300);
        clmDato3.setPrefWidth(140);
        clmDato4.setPrefWidth(100);


        setAndBindCellTitlesItem();
        realizarConsulta(null);



    }

    @FXML
    void actualizarTabla(ActionEvent event) {

        String seleccion = cmbTabla.getValue();
        tablaMain.getItems().clear();
        switch (seleccion) {
            case "Item":
                setAndBindCellTitlesItem();
                break;
            case "Book":
                setAndBindCellTitlesBook();
                break;
            case "Potion":
                setAndBindCellTitlesPotion();
                break;
            case "Block":
                setAndBindCellTitlesBlock();
                break;
            case "Tool":
                setAndBindCellTitlesTool();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + seleccion);
        }



    }

    @FXML
    public void realizarConsulta(ActionEvent event) {


    }

    @FXML
    void salirPrograma(ActionEvent event) {

    }

    private void setAndBindCellTitlesItem() {

        List<Item> itemsActuales = Conexion.cargarItems();
        tablaMain.getItems().addAll(itemsActuales);

        clmID.setText("ID");
        clmDato1.setText("Nombre");
        clmDato2.setText("Descripción");
        clmDato3.setText("Tamaño Stack");
        clmDato4.setText("Imagen");

        clmID.setCellValueFactory(new PropertyValueFactory<>("ItmId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("ItmName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("ItmDesc"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("ItmStackSize"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("ItmImage"));


    }

    private void setAndBindCellTitlesPotion() {


        List<Potion> itemsActuales = Conexion.cargarPots();
        tablaMain.getItems().addAll(itemsActuales);

        clmID.setText("ID");
        clmDato1.setText("Nombre");
        clmDato2.setText("Efecto");
        clmDato3.setText("Duración");
        clmDato4.setText("Nivel");

        clmID.setCellValueFactory(new PropertyValueFactory<>("PotId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("PotName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("PotEffect"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("PotDuration"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("PotLevel"));
    }

    private void setAndBindCellTitlesBook() {

        List<Book> itemsActuales = Conexion.cargarBooks();
        tablaMain.getItems().addAll(itemsActuales);

        clmID.setText("ID");
        clmDato1.setText("Nombre");
        clmDato2.setText("Tipo");
        clmDato3.setText("Encantamiento");
        clmDato4.setText("Nivel");

        clmID.setCellValueFactory(new PropertyValueFactory<>("BkId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("BkName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("BkType"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("BkEnchantment"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("BkLevel"));
    }

    private void setAndBindCellTitlesBlock() {

        List<Block> itemsActuales = Conexion.cargarBlocks();
        tablaMain.getItems().addAll(itemsActuales);

        clmID.setText("ID");
        clmDato1.setText("Nombre");
        clmDato2.setText("Luminosidad");
        clmDato3.setText("Resistencia Explosivos");
        clmDato4.setText("Inflamabilidad");


        clmID.setCellValueFactory(new PropertyValueFactory<>("BlkId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("BlkIdName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("BlkLuminosity"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("BlkBlastResistance"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("BlkFlammable"));
    }

    private void setAndBindCellTitlesTool() {


        List<Tool> itemsActuales = Conexion.cargarTools();
        tablaMain.getItems().addAll(itemsActuales);

        clmID.setText("ID");
        clmDato1.setText("Nombre");
        clmDato2.setText("Durabilidad");
        clmDato3.setText("Inflamabilidad");
        clmDato4.setText("Daño");


        clmID.setCellValueFactory(new PropertyValueFactory<>("ToolId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("ToolName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("ToolDurability"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("ToolFlammable"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("ToolDamage"));
    }

}
