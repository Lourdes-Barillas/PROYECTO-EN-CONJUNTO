package Frames.VenOrdenPrincipal;

import Cliente.*;
import Frames.MenuPrincipal.Controller;
import Frames.PruebaVentanas;
import Frames.vistaind.IndividualController;
import Orden.DataSistema;
import Producto.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

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
        DataSistema productos = new DataSistema();
        ObservableList<String> items = FXCollections.observableArrayList();
        productos.listaProductos();
        for(Producto p : productos.getProducto()){
            items.add(p.getProducto());
        }
        cb_productotype.setItems(items);
    }


    public void irMenu_Orden(ActionEvent event) throws Exception {//aquí irémos al menú principal
        nuevaVentana = new PruebaVentanas();
        nuevaVentana.start(ordenController);
    }

    public void Ordenar(ActionEvent event) {
        nuevaVentana = new PruebaVentanas();
        System.out.println(cantidadProducto.getCharacters());
        //mostrar ventana de cliente individual o de empresa
        if(this.cb_clientetype.getValue().toString().equals(TipoCliente.Persona.toString())){
            System.out.println("si");
            iraventana("../vistaind/Individual.fxml", "Persona individual");
        }
        //settear los valores de orden
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

    public void startNotOriginal(Stage primaryStage) throws Exception{
        this.ordenController = primaryStage;
    }

    public void iraventana(String url, String tittle){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();
            IndividualController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle(tittle);
            stage.showAndWait();
        }catch (IOException e){

        }
    }
}
