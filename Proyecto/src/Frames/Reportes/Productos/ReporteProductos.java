package Frames.Reportes.Productos;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Orden.DataSistema;
import Producto.Producto;

public class ReporteProductos implements Initializable {
    Producto producto;

    public Label id1;public Label producto1;public Label marca1;public Label precio1;
    public Label id2;public Label producto2;public Label marca2;public Label precio2;
    public Label id3;public Label producto3;public Label marca3;public Label precio3;
    public Label id4;public Label producto4;public Label marca4;public Label precio4;
    public Label id5;public Label producto5;public Label marca5;public Label precio5;
    public Label id6;public Label producto6;public Label marca6;public Label precio6;
    public Label id7;public Label producto7;public Label marca7;public Label precio7;
    public Label id8;public Label producto8;public Label marca8;public Label precio8;


    private Stage reportesp;
    public void setControllerReportesP(Stage productos) {
        this.reportesp = productos;
    }

    public void retornar(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }

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
        listarProductos();
    }

    public void listarProductos(){
        DataSistema prod =new DataSistema();
        prod.listaProductos();
        producto=prod.devolverProducto(0);
        id1.setText(String.valueOf(producto.getIdProducto()));
        producto1.setText(producto.getProducto());
        marca1.setText(producto.getMarca());
        precio1.setText(producto.getPrecio().toString());

        producto=prod.devolverProducto(1);
        id2.setText(String.valueOf(producto.getIdProducto()));
        producto2.setText(producto.getProducto());
        marca2.setText(producto.getMarca());
        precio2.setText(producto.getPrecio().toString());

        producto=prod.devolverProducto(2);
        id3.setText(String.valueOf(producto.getIdProducto()));
        producto3.setText(producto.getProducto());
        marca3.setText(producto.getMarca());
        precio3.setText(producto.getPrecio().toString());

        producto=prod.devolverProducto(3);
        id4.setText(String.valueOf(producto.getIdProducto()));
        producto4.setText(producto.getProducto());
        marca4.setText(producto.getMarca());
        precio4.setText(producto.getPrecio().toString());

        producto=prod.devolverProducto(4);
        id5.setText(String.valueOf(producto.getIdProducto()));
        producto5.setText(producto.getProducto());
        marca5.setText(producto.getMarca());
        precio5.setText(producto.getPrecio().toString());

        producto=prod.devolverProducto(5);
        id6.setText(String.valueOf(producto.getIdProducto()));
        producto6.setText(producto.getProducto());
        marca6.setText(producto.getMarca());
        precio6.setText(producto.getPrecio().toString());

        producto=prod.devolverProducto(6);
        id7.setText(String.valueOf(producto.getIdProducto()));
        producto7.setText(producto.getProducto());
        marca7.setText(producto.getMarca());
        precio7.setText(producto.getPrecio().toString());

        producto=prod.devolverProducto(7);
        id8.setText(String.valueOf(producto.getIdProducto()));
        producto8.setText(producto.getProducto());
        marca8.setText(producto.getMarca());
        precio8.setText(producto.getPrecio().toString());

    }
}
