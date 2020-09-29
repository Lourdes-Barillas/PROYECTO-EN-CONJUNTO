package Frames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private  PruebaVentanas programaPrincipal;


    public void setProgramaPrincipal(PruebaVentanas programaPrincipal){
        this.programaPrincipal = programaPrincipal;
    }

    public void initialize(URL url, ResourceBundle rb){
        //TODO
    }

    public void setControllerPrincipal(PruebaVentanas pruebaVentanas) {
        this.programaPrincipal = programaPrincipal;
    }
    @FXML
    private void ventanaOrden(ActionEvent event){
        programaPrincipal = new PruebaVentanas();
        programaPrincipal.mostrarVentanaSecundaria();
    }
}
