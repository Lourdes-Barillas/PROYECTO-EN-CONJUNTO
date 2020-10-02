package Frames;

import Frames.MenuPrincipal.Controller;
import Frames.Reportes.Reportes;
import Frames.VenOrdenPrincipal.OrdenController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PruebaVentanas extends Application {

    private Stage stagePrincipal;
    private AnchorPane rootPane;


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stagePrincipal = primaryStage;
        mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal(){
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("MenuPrincipal/Menu.fxml"));
            rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Menu");
            stagePrincipal.setScene(scene);
            Controller controller = loader.getController();
            controller.setControllerPrincipal(this);
            stagePrincipal.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void mostrarVentanaSecundaria(){
        try{
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("VenOrdenPrincipal/Orden.fxml"));
            AnchorPane ventanaOrden = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Orden");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaOrden);
            ventana.setScene(scene);
            OrdenController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            controller.setCb_clientetype();
            controller.setCb_productotype();
            ventana.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarVentana(ActionEvent event){
        Node souce = (Node) event.getSource();
        stagePrincipal = (Stage) souce.getScene().getWindow();
        stagePrincipal.close();

    }
    public void mostrarMenuReportes(){
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("Reportes/ReportesFx.fxml"));
            AnchorPane MenusReportes = (AnchorPane) loader.load();
            Stage reportes = new Stage();
            reportes.setTitle("Reportes");
            reportes.initOwner(stagePrincipal);
            Scene scene = new Scene(MenusReportes);
            reportes.setScene(scene);
            Reportes controller = loader.getController();
            controller.setStagePrincipal(reportes);
            reportes.show();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
