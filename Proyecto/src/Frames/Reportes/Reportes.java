package Frames.Reportes;

import Frames.PruebaVentanas;
import Frames.Reportes.Clientes.ReporteClientes;
import Frames.Reportes.Clientes.ReporteClientes;
import Frames.Reportes.Orden.ReporteOrden;
import Frames.Reportes.Productos.ReporteProductos;
import Frames.VenOrdenPrincipal.OrdenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Reportes {
    private PruebaVentanas main;
    private Reportes re;
    private Stage ordenController;
    public void setStagePrincipal(Stage ventana) {
        this.ordenController = ventana;
    }

    public void retorno_Menu(ActionEvent event)throws Exception {
        main = new PruebaVentanas();
        main.start(ordenController);
    }

    public void b_Reporte_Orden(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("Reportes/Orden/ROrdenFx.fxml"));
            AnchorPane ReporteOrden = (AnchorPane) loader.load();
            Stage orden = new Stage();
            orden.setTitle("Reporte de Orden");
            orden.initOwner(ordenController);
            Scene scene = new Scene(ReporteOrden);
            orden.setScene(scene);
            ReporteOrden controller = loader.getController();
            controller.setControllerReportes(orden);
            orden.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }//botton reporte de orden

    public void b_Reporte_Productos(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("Reportes/Productos/RProductosFx.fxml"));
            AnchorPane ReporteProducto = (AnchorPane) loader.load();
            Stage producto = new Stage();
            producto.setTitle("Reporte de Productos");
            producto.initOwner(ordenController);
            Scene scene = new Scene(ReporteProducto);
            producto.setScene(scene);
            ReporteProductos control = loader.getController();
            control.setControllerReportesP(producto);
            producto.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void b_Reporte_Clientes(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("Reportes/Clientes/RClientesFx.fxml"));
            AnchorPane ReporteClientes = (AnchorPane) loader.load();
            Stage clientes = new Stage();
            clientes.setTitle("Reporte de Clientes");
            clientes.initOwner(ordenController);
            Scene scene = new Scene(ReporteClientes);
            clientes.setScene(scene);
            ReporteClientes control = loader.getController();
            control.setControllerReportesC(clientes);
            clientes.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
