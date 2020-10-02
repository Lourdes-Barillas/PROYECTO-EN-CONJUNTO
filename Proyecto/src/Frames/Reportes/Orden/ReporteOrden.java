package Frames.Reportes.Orden;

import Frames.PruebaVentanas;
import Frames.Reportes.Reportes;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ReporteOrden {
    private Stage reportes;
    public void setControllerReportes(Stage orden) {
        this.reportes = orden;
    }
    public void retornar(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }
}
