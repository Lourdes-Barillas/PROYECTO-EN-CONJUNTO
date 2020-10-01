package Frames.Reportes.Productos;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ReporteProductos {
    private Stage reportes;
    public void setControllerReportesP(Stage productos) {
        this.reportes = productos;
    }

    public void retornar(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }
}
