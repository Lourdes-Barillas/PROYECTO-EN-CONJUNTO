package Frames.VenOrdenPrincipal;

import Cliente.*;
import Frames.MenuPrincipal.Controller;
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
    public TextField cantidadProducto;
    public AnchorPane clienteAnchor;
    public ComboBox cb_productotype;
    @FXML
    private ComboBox<TipoCliente> cb_clientetype;
    private PruebaVentanas nuevaVentana;
    private Controller ventana;
    private Stage ordenController;
    private Cliente cliente;


    public void setStagePrincipal(Stage ventana) {
        this.ordenController = ventana;
    }

    public void setCb_clientetype(){
        ObservableList<TipoCliente> items = FXCollections.observableArrayList();
        items.addAll(TipoCliente.Persona, TipoCliente.Empresarial);
        cb_clientetype.setItems(items);
    }

    public void setCb_productotype(){
        ObservableList<TipoCliente> items = FXCollections.observableArrayList();
        items.addAll(TipoCliente.Persona, TipoCliente.Empresarial);
        cb_productotype.setItems(items);
    }


    public void irMenu_Orden(ActionEvent event) throws Exception {//aquí irémos al menú principal
        nuevaVentana = new PruebaVentanas();
        nuevaVentana.start(ordenController);
    }

    public void Ordenar(ActionEvent event) {
        System.out.println(cantidadProducto.getCharacters());
    }

    public void setCliente(){
        Cliente cliente = new Cliente(cb_clientetype.getValue());
        if(cliente.getNombreClase()==TipoCliente.Persona.toString()){
            Individual cIndividual = new Individual();
            cliente = cIndividual;
        } else if(cliente.getNombreClase()==TipoCliente.Empresarial.toString()){
            Empresa cEmpresarial = new Empresa();
            cliente = cEmpresarial;
        }
        this.cliente = cliente;
    }


    /**
     * Por si me sirve
     * @return cliente
     */
    public Cliente getCliente(){
        return cliente;
    }

    public String getCantidadProducto() {
        return cantidadProducto.getText();
    }
}
