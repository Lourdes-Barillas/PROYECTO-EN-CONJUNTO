package Frames.VenOrdenPrincipal;

import Cliente.TipoCliente;
import Frames.PruebaVentanas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OrdenController {
    public AnchorPane clienteAnchor;
    public TextField cantidadProducto;
    @FXML
    private ComboBox<TipoCliente> cb_clientetype;
    private PruebaVentanas programaPrincipal;
    private Stage ordenController;


    public void setStagePrincipal(Stage ventana) {
        this.ordenController = ventana;
    }

    public void setCb_clientetype(){
        ObservableList<TipoCliente> items = FXCollections.observableArrayList();
        items.addAll(TipoCliente.INDIVIDUAL, TipoCliente.EMPRESA);
        cb_clientetype.setItems(items);
    }


    public void irMenu_Orden(ActionEvent event) {
    }

    public void Ordenar(ActionEvent event) {
        System.out.println(cantidadProducto.getCharacters());
    }

}
