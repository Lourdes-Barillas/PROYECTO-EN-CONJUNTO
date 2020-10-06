package Frames.Reportes.Clientes;

import Cliente.Cliente;
import Frames.Reportes.Reportes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import Orden.DataSistema;
import Cliente.Individual;
import Cliente.Empresa;
public class ReporteClientes {

    public RowConstraints row;
    public Label dato1;public Label id1;
    public Label dato2;public Label id2;
    public Label dato3;public Label id3;
    public Label dato4;public Label id4;
    public Label dato5;public Label id5;
    public Label dato6;public Label id6;
    public Label dato7;public Label id7;
    public Label dato8;public Label id8;
    private Stage cliente;
    private Cliente cln;

    public void setControllerReportesC(Stage clientes) {
        this.cliente = clientes;
    }


    public void retornar(ActionEvent event) {
        Node souce = (Node) event.getSource();
        Stage stage = (Stage) souce.getScene().getWindow();
        stage.close();
    }

    public void b_Individual(ActionEvent event) {devolverClientesInd(); }
    public void b_Empresas(ActionEvent event) { devolverClienesEmp(); }
    public void b_Ambos(ActionEvent event) { devolverClientesAll(); }

    public void devolverClientesAll() {
        try2("ambos");
    }//devolverclienteAll

    public void devolverClienesEmp(){
       try2("uno");
    }
    public void devolverClientesInd(){
        try2("dos");
    }

    public void try2(String am){
        resetT();
        int a = 0, b = -1;
        String ids;
        Individual ind= new Individual();
        Empresa emp=new Empresa();
        String dat="";
        int id=0;
        int d1=0,d2=0,d3=0;
        DataSistema cl = new DataSistema();
        cl.listaClientes();
        while (cl.cliente.size()>a){
            if(am.equalsIgnoreCase("ambos")) {
                if(cl.getCliente().get(a) instanceof Empresa) {
                    id=((Empresa) cl.getCliente().get(a)).getIdCliente();
                    dat = ((Empresa) cl.getCliente().get(a)).getContacto();
                    b++;
                }
                if(cl.devolverCliente(a) instanceof Individual){
                    id=((Individual) cl.getCliente().get(a)).getIdCliente();
                    dat =((Individual) cl.getCliente().get(a)).getDpi();
                    b++;
                }
            }
            if(am.equalsIgnoreCase("uno")){
                if(cl.getCliente().get(a) instanceof Empresa) {
                    id=((Empresa) cl.getCliente().get(a)).getIdCliente();
                    dat = ((Empresa) cl.getCliente().get(a)).getContacto();
                    b++;
                }
            }
            if(am.equalsIgnoreCase("dos")){
                if(cl.devolverCliente(a) instanceof Individual){
                    id=((Individual) cl.getCliente().get(a)).getIdCliente();
                    dat =((Individual) cl.getCliente().get(a)).getDpi();
                    b++;
                }
            }
            ids=String.valueOf(id);//convertir el id a String

                    switch (b) {
                        case 0:
                            dato1.setText("  "+dat);
                            id1.setText("  "+ids);
                            break;
                        case 1:
                            dato2.setText("  "+dat);
                            id2.setText("  "+ids);
                            break;
                        case 2:
                            dato3.setText("  "+dat);
                            id3.setText("  "+ids);
                            break;
                        case 3:
                            dato4.setText("  "+dat);
                            id4.setText("  "+ids);
                            break;
                        case 4:
                            dato5.setText("  "+dat);
                            id5.setText("  "+ids);
                            break;
                        case 5:
                            dato6.setText("  "+dat);
                            id6.setText("  "+ids);
                            break;
                        case 6:
                            dato7.setText("  "+dat);
                            id7.setText("  "+ids);
                            break;
                        case 7:
                            dato8.setText("  "+dat);
                            id8.setText("  "+ids);
                            break;
                        default:
                            dat="";
                            ids="";
                            break;
                    }//switch individual
            a++;

        }
    }
    public void resetT(){
        dato1.setText("  "); id1.setText("  ");
        dato2.setText("  "); id2.setText("  ");
        dato3.setText("  "); id3.setText("  ");
        dato4.setText("  "); id4.setText("  ");
        dato5.setText("  "); id5.setText("  ");
        dato6.setText("  "); id6.setText("  ");
        dato7.setText("  "); id7.setText("  ");
        dato8.setText("  "); id8.setText("  ");
    }

}//class
