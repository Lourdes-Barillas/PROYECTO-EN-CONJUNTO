package Frames.Reportes.Orden;

import Frames.PruebaVentanas;
import Frames.Reportes.Reportes;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Orden.DataSistema;

import javax.swing.*;

public class ReporteOrden {
    public TextField id_B;
    private Stage reportes;

    public void setControllerReportes(Stage orden) {
        this.reportes = orden;
    }
    public void retornar(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }

    public void Buscar(ActionEvent event) {
        String idc=id_B.getText();
        DataSistema data= new DataSistema();
        if(data.getOrden().size()==0){
            JOptionPane.showMessageDialog(null, "na hay registros en existencia");
        }
        //------------------------------------------------------------------------
        //de aqui en adelante el resto en caso que si encuentre registros
        //con que ma ayudes a arreglar el inconveniente que no encuentra registro de orden basta
        //tengo aqui codificacion ,que si Diosito quiere va a funcionar
        //------------------------------------------------------------------------

    }//buscar
}//class
