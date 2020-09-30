package Frames;

import Frames.MenuPrincipal.Controller;
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

        /*
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
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
}
