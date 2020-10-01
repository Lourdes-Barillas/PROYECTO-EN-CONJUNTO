package Frames.vistaind;

import Cliente.*;
import Orden.DataSistema;
import Orden.Orden;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.Date;

public class IndividualController {

    public TextField dpi;
    public TextField id;

    public void iniciar(ActionEvent event) {
        Individual cliente = new Individual();
        DataSistema db = new DataSistema();
        db.listaClientes();//refresh lista de clientes
        for(Cliente c : db.getCliente()){
            if(c instanceof Individual){
                cliente = new Individual(dpi.getText(), Integer.parseInt(id.getText()));
                try{
                    if(c.getIdCliente()==Integer.parseInt(this.id.getText())){
                        if(((Individual) c).getDpi().equalsIgnoreCase(dpi.getText())){
                            //Hasta aquí tenemos un cliente individual
                            Date fecha = new Date();
                            //pedir los días de envío y el tipo
                            Orden nuevaOrden = new Orden(1, fecha, c);
                            nuevaOrden.setFormaDeEnvio(3, 1);
                            db.setOrden(nuevaOrden);
                            System.out.println(db.getOrden().toString());
                        }
                    }
                }catch (Exception e){
                    //mostrar cuadro de diálogo
                }
            }
        }//fin for

    }
}
