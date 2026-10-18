package org.example.estudio6;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    ObservableList<Dispositivo> listaDispositivos = FXCollections.observableArrayList();

    @FXML
    private Label lblContador;
    @FXML
    private Slider sldBrillo;
    @FXML
    private TextField tfNombre;
    @FXML
    private Button btnEliminar;
    @FXML
    private Label lblTitulo;
    @FXML
    private TextField tfCodigo;
    @FXML
    private Button brnAnadir;
    @FXML
    private ComboBox cbTipo;
    @FXML
    private TableColumn<Dispositivo, String> tcNombre;
    @FXML
    private TableColumn<Dispositivo, Double> tcBrillo;
    @FXML
    private TableColumn<Dispositivo, String> tcTipo;
    @FXML
    private TableView<Dispositivo> tbDispositivos;
    @FXML
    private TableColumn<Dispositivo, Double> tcCode;

    int contador = 0;

    @FXML
    public void initialize() {

        cbTipo.setItems(FXCollections.observableArrayList("Bombilla", "Bomba", "Bombazo"));
        cbTipo.setValue("Bombilla");

        tbDispositivos.setItems(listaDispositivos);

        tcCode.setCellValueFactory(cellData -> cellData.getValue().codigoProperty().asObject());
        tcNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        tcTipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        tcBrillo.setCellValueFactory(cellData -> cellData.getValue().brilloProperty().asObject());

        btnEliminar.disableProperty().bind(tbDispositivos.getSelectionModel().selectedItemProperty().isNull());

        BooleanBinding estaBien = Bindings.createBooleanBinding(() -> {

            Boolean textoMal = (tfNombre.getText().trim().isEmpty() || cbTipo.getValue().toString().trim().isEmpty());

            Boolean numerosBien = true;

            try {

                Double.parseDouble(tfCodigo.getText());

            } catch (NumberFormatException nfe) {
                numerosBien = false;
            }

            return !textoMal && numerosBien;

        }, tfNombre.textProperty(), tfCodigo.textProperty(), cbTipo.valueProperty()

        );

        brnAnadir.disableProperty().bind(estaBien.not());

    }

    @FXML
    public void onEliminar(ActionEvent actionEvent) {

        listaDispositivos.remove(tbDispositivos.getSelectionModel().getSelectedItem());

        contador--;

        lblContador.setText(String.valueOf("Total de dispositivos: "+contador));

    }

    @FXML
    public void onAnadir(ActionEvent actionEvent) {

        double codigo = Double.parseDouble(tfCodigo.getText());
        String tipo = cbTipo.getValue().toString();
        double valor = sldBrillo.getValue();

        listaDispositivos.add(new Dispositivo(codigo, tfNombre.getText(), tipo, valor));

        contador++;

        lblContador.setText(String.valueOf("Total de dispositivos: "+contador));

    }
}
