package Frames.Reportes.Orden;

import Cliente.Cliente;
import Frames.MadeOrden;
import Frames.PruebaVentanas;
import Frames.Reportes.Reportes;
import Orden.Orden;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Orden.DataSistema;
import Producto.Producto;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class ReporteOrden implements Initializable {
    Producto p;
    Cliente c;
    Orden o;
    Orden oEscrita;
    public Label id1;public Label cl1;public Label d1;public Label po1;public Label en1;public Label to1;
    public Label id2;public Label cl2;public Label d2;public Label po2;public Label en2;public Label to2;
    public Label id3;public Label cl3;public Label d3;public Label po3;public Label en3;public Label to3;
    public Label id4;public Label cl4;public Label d4;public Label po4;public Label en4;public Label to4;
    public Label id5;public Label cl5;public Label d5;public Label po5;public Label en5;public Label to5;
    public Label id6;public Label cl6;public Label d6;public Label po6;public Label en6;public Label to6;
    public Label id7;public Label cl7;public Label d7;public Label po7;public Label en7;public Label to7;


    private Stage reportes;

    public void setControllerReportes(Stage orden) {
        this.reportes = orden;
    }
    public void retornar(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }

    public void verDatos() {
        Cliente cl= new Cliente();
        Producto p = new Producto();
        DataSistema prod =new DataSistema();
        prod.listaProductos();
        p=prod.devolverProducto(0);
        id1.setText(String.valueOf(p.getIdProducto()));
        cl1.setText(""+"Individual");//tipo de cliente
        d1.setText(""+"13841354615");//dpi o contacto
        po1.setText(p.getProducto());//producto
        en1.setText(""+2);//dias de entrega
        to1.setText(String.valueOf(p.getPrecio()*2));//total

        p=prod.devolverProducto(1);
        id2.setText(String.valueOf(p.getIdProducto()));
        cl2.setText(""+"Empresa");//tipo de cliente
        d2.setText(""+"mzoruna@gmail.com");//dpi o contacto
        po2.setText(p.getProducto());//producto
        en2.setText(""+8);//dias de entrega
        to2.setText(String.valueOf(p.getPrecio()*5));//total

        p=prod.devolverProducto(3);
        id3.setText(String.valueOf(p.getIdProducto()));
        cl3.setText(""+"Empresa");//tipo de cliente
        d3.setText(""+"mzoruna@gmail.com");//dpi o contacto
        po3.setText(p.getProducto());//producto
        en3.setText(""+1);//dias de entrega
        to3.setText(String.valueOf(p.getPrecio()*10));//total

        p=prod.devolverProducto(4);

        id4.setText(String.valueOf(p.getIdProducto()));
        cl4.setText(""+"Empresa");//tipo de cliente
        d4.setText(""+"zcuffaine@hotmail.com");//dpi o contacto
        po4.setText(p.getProducto());//producto
        en4.setText(""+1);//dias de entrega
        to4.setText(String.valueOf(p.getPrecio()));//total

        p=prod.devolverProducto(5);
        id5.setText(String.valueOf(p.getIdProducto()));
        cl5.setText(""+"Individual");//tipo de cliente
        d5.setText("3045269871452");//dpi o contacto
        po5.setText(p.getProducto());//producto
        en5.setText(""+12);//dias de entrega
        to5.setText(String.valueOf(p.getPrecio()*2));//total

        p=prod.devolverProducto(5);
        id5.setText(String.valueOf(p.getIdProducto()));
        cl5.setText(""+"Individual");//tipo de cliente
        d5.setText("3045269871452");//dpi o contacto
        po5.setText(p.getProducto());//producto
        en5.setText(""+12);//dias de entrega
        to5.setText(String.valueOf(p.getPrecio()*2));//total

        p=prod.devolverProducto(3);
        id5.setText(String.valueOf(p.getIdProducto()));
        cl5.setText(""+"Individual");//tipo de cliente
        d5.setText("3045269871452");//dpi o contacto
        po5.setText(p.getProducto());//producto
        en5.setText(""+12);//dias de entrega
        to5.setText(String.valueOf(p.getPrecio()*2));//total
    }//verdatos


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MadeOrden mo = new MadeOrden();
        mo.getData();
        verDatos();
    }



}//class
