package Frames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("Menu.FXML"));
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
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("Orden.fxml"));
            AnchorPane ventanaOrden = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Orden");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaOrden);
            ventana.setScene(scene);
            OrdenController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
