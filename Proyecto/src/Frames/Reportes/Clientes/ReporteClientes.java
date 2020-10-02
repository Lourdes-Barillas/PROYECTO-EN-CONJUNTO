package Frames.Reportes.Clientes;

import Frames.Reportes.Reportes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
public class ReporteClientes {

    private Stage cliente;
    public void setControllerReportesC(Stage clientes) {
        this.cliente = clientes;
    }


    public void retornar(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }
}//class
