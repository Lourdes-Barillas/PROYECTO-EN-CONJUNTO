package Frames.VenOrdenPrincipal;

import Cliente.*;
import Frames.MenuPrincipal.Controller;
import Frames.PruebaVentanas;
import Frames.vistaind.IndividualController;
import Orden.*;
import Producto.Producto;
import com.sun.jndi.toolkit.url.UrlUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
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
import java.net.URL;
import java.util.ResourceBundle;

public class OrdenController {
    private OrdenController controladorOrden;
    public Producto producto;
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

    public String getCb_productotype() {
        return cb_productotype.getValue().toString();
    }

    public void irMenu_Orden(ActionEvent event) throws Exception {//aquí irémos al menú principal
        nuevaVentana = new PruebaVentanas();
        nuevaVentana.start(ordenController);
    }

    public void Ordenar(ActionEvent event) throws IOException{
        Orden orden;
        nuevaVentana = new PruebaVentanas();
        System.out.println("cantidad" + cantidadProducto.getCharacters());
        //mostrar ventana de cliente individual o de empresa
        if(this.cb_clientetype.getValue().toString().equals(TipoCliente.Persona.toString())){
            System.out.println("si");
            setCliente();
            IndividualController ic = new IndividualController();
            System.out.println("setCliente" + cliente.toString());
            iraventana("../vistaind/Individual.fxml", "Persona individual");
            ItemOrden item = new ItemOrden(1, Integer.parseInt(this.getCantidadProducto()),
                    getIdProducto(this.cb_productotype.getValue().toString()));
            System.out.println(ic);
        }
        //settear los valores de orden
        this.cantidadProducto.setText("");
        this.cb_clientetype.setValue(null);
        this.cb_productotype.setValue(null);
    }

    public int getIdProducto(String producto){
        int idProducto = 0;
        DataSistema db = new DataSistema();
        db.listaProductos();
        for(Producto p : db.getProducto()){
            if(p.getProducto().equalsIgnoreCase(producto)){
                idProducto = p.getIdProducto();
                System.out.println(idProducto);
            }
        }
        return idProducto;
    }
    public void setCliente(){
        Cliente cliente = new Cliente(cb_clientetype.getValue());
        if(cliente.getNombreClase()==TipoCliente.Persona.toString()){
            this.cliente = cliente;
            System.out.println(cliente.toString());
            Individual clientei = new Individual(cliente);
            System.out.println(cliente.toString());
        } else if(cliente.getNombreClase()==TipoCliente.Empresarial.toString()){
            this.cliente = cliente;
            System.out.println(cliente.toString());
            //Empresa clientee = new Empresa(cliente);
            System.out.println(cliente.toString());
        }
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
            setProducto(this.cb_productotype.getValue().toString());
            controller.
                    parametros(this.controladorOrden, this.producto,
                            this.cantidadProducto.getCharacters().toString());

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle(tittle);
            stage.showAndWait();
        }catch (IOException e){

        }
    }
    public void initialize(URL url, ResourceBundle rb){
        this.controladorOrden = this;
    }

    public void setProducto(String prodtype) {
        DataSistema productos = new DataSistema();
        productos.listaProductos();
        for(Producto p : productos.getProducto()){
            System.out.println(p.toString());
            if(p.getProducto().equalsIgnoreCase(prodtype)){//si encuentra este producto
                this.producto = p;
            }
        }
    }



}
