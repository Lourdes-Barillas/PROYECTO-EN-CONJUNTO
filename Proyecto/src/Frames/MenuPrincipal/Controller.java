package Frames.MenuPrincipal;

import Frames.PruebaVentanas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private PruebaVentanas programaPrincipal;

    public void initialize(URL url, ResourceBundle rb){
        //TODO
    }

    public void setControllerPrincipal(PruebaVentanas pruebaVentanas) {
        this.programaPrincipal = pruebaVentanas;
    }
    @FXML
    private void ventanaOrden(ActionEvent event){
        programaPrincipal = new PruebaVentanas();
        programaPrincipal.mostrarVentanaSecundaria();
        programaPrincipal.cerrarVentana(event);
    }
    @FXML
    private void ventanaReporte(ActionEvent event){
        programaPrincipal= new PruebaVentanas();
        programaPrincipal.mostrarMenuReportes();
        programaPrincipal.cerrarVentana(event);
    }

    public void menu_Salir(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }
}
