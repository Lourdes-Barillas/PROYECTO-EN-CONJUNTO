package Frames.VenOrdenEmpresa;

import Cliente.*;
import Frames.VenOrdenPrincipal.OrdenController;
import Orden.DataSistema;
import Orden.Orden;
import Producto.Producto;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Date;

public class OrdenClienteEmp {
    public TextField id;
    public TextField contacto;
    private Cliente cliente;
    private Producto producto;
    private String np;//n productos
    OrdenController stageOrden;

    public void iniciar(ActionEvent event) {
        Empresa cliente = new Empresa();
        DataSistema db = new DataSistema();
        db.listaClientes();//refresh lista de clientes
        for(Cliente c : db.getCliente()){
            System.out.println("x");
            if(c instanceof Empresa){
                System.out.println("y");
                try{
                    System.out.println("If console don´t write z, then the register doesn't exist or it isn't Empresa");
                    System.out.println("you've writted" + this.id.getText() + " and db have " + c.getIdCliente());
                    if(c.getIdCliente()==Integer.parseInt(this.id.getText())){
                        System.out.println("z");
                        if(((Empresa) c).getContacto().equalsIgnoreCase(this.contacto.getText())){
                            System.out.println("A");
                            //Hasta aquí tenemos un cliente individual
                            Date fecha = new Date();
                            System.out.println(this.contacto.getCharacters());
                            setCliente(this.contacto.getCharacters().toString(), this.id.getCharacters().toString());
                            System.out.println(this.cliente.toString());

                            setOrden();
                            Node souce = (Node) event.getSource();
                            Stage g = (Stage) souce.getScene().getWindow();
                            g.close();
                        }
                    }
                }catch (Exception e){
                    //mostrar cuadro de diálogo
                    System.out.println(e);
                }
            }
        }//fin for
    }

    public void parametrosEmpresa (OrdenController vorden, Producto producto, String np){
        this.producto = producto; System.out.println("Recibiendo " + producto.getProducto());
        this.np = np;
        System.out.println("Recibiendo " + np);
        this.stageOrden=vorden;
    }

    public void setCliente(String contacto, String id) {
        try{
            this.cliente = new Empresa(contacto, Integer.parseInt(id));
        }catch (NumberFormatException e){
            System.out.println(e);
        }
    }

    public void setOrden(){
        System.out.println("Entrando a orden");
        System.out.println(this.producto.getProducto() + " " + this.np);
        try{
            int pcliente = Integer.parseInt(this.id.getCharacters().toString());
            setCliente(this.contacto.getCharacters().toString(), this.id.getCharacters().toString());
            System.out.println("Tipo de producto: " + this.producto.getProducto());
            Orden orden = new Orden(pcliente, this.cliente, this.np, this.producto);
            System.out.println(orden.toString());
            DataSistema db = new DataSistema();
            db.orden.add(orden);
            System.out.println(db.getOrden().toString());
        }catch (NumberFormatException e){
            System.out.println(e);
        }
    }

}
