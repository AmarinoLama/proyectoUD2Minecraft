package edu.badpals.proyectoud2minecraft.Controller;

import edu.badpals.proyectoud2minecraft.Model.Conexion;
import edu.badpals.proyectoud2minecraft.Model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

        setCellTitlesItem();
        realizarConsulta(null);




    }

    @FXML
    public void realizarConsulta(ActionEvent event) {

        clmID.setText("ID");
        clmDato1.setText("Nombre");
        clmDato2.setText("Descripción");
        clmDato3.setText("Tamaño Stack");
        clmDato4.setText("Imagen");

        List<Item> itemsActuales = Conexion.cargarItems();
        tablaMain.getItems().addAll(itemsActuales);
    }

    @FXML
    void salirPrograma(ActionEvent event) {

    }

    private void setCellTitlesItem() {
        clmID.setCellValueFactory(new PropertyValueFactory<>("ItmId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("ItmName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("ItmDesc"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("ItmStackSize"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("ItmImage"));
    }

    private void setCellTitlesPotion() {
        clmID.setCellValueFactory(new PropertyValueFactory<>("PotId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("PotName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("PotEffect"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("PotDuration"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("PotLevel"));
    }

    private void setCellTitlesBook() {
        clmID.setCellValueFactory(new PropertyValueFactory<>(""));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("BkName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("BkType"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("BkEnchantment"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("BkLevel"));
    }

    private void setCellTitlesBlock() {
        clmID.setCellValueFactory(new PropertyValueFactory<>("BlkId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("BlkIdName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("BlkLuminosity"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("BlkBlastResistance"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("BlkFlammable"));
    }

    private void setCellTitlesTool() {
        clmID.setCellValueFactory(new PropertyValueFactory<>("ToolId"));
        clmDato1.setCellValueFactory(new PropertyValueFactory<>("ToolName"));
        clmDato2.setCellValueFactory(new PropertyValueFactory<>("ToolDurability"));
        clmDato3.setCellValueFactory(new PropertyValueFactory<>("ToolFlammable"));
        clmDato4.setCellValueFactory(new PropertyValueFactory<>("ToolDamage"));
    }

}
