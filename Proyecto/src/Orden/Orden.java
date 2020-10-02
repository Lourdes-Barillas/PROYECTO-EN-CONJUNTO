package Orden;
import Cliente.*;

import java.util.Date;
import Frames.VenOrdenPrincipal.OrdenController;
import Frames.vistaind.IndividualController;
import Producto.Producto;

import javax.swing.*;
import javax.xml.crypto.Data;

public class Orden {
    private int id;
    private Cliente cliente;
    private ItemOrden item1;
    private ItemOrden item2;
    private Date fechaOrden;
    private double precioEnvio;
    private double total;
    private int tipoEnvio;
    private int estado;
    private int diasEnvio;
    
    public void orden(){
    total =0.0;
    fechaOrden=new Date();
    this.id = sigIdOrden();
    }

    /**
     *
     * @param pCliente
     */
    public Orden(int pCliente, Cliente cliente, String np, Producto producto){
        System.out.println("llegando a orden");
        DataSistema db = new DataSistema();
        ItemOrden orden;
        this.cliente = cliente;
        System.out.println("cliente puesto" + cliente.getIdCliente());
        //verificar el cliente y buscarlo

        System.out.println(cliente.toString());
        db.listaClientes();
        System.out.println("buscando cliente");
        for(Cliente c : db.getCliente()){//recorriendo la lista de clientes en DataSistema
            System.out.println("cliente" + c.toString());
            if(this.cliente.getIdCliente() == pCliente){
                System.out.println("cliente obtenido");
                try{
                    int cantidad = Integer.parseInt(np);//getcantidad del fxml
                    System.out.println(cantidad);
                    Double precio = 0.0;//obtener el precio del producto
                    Double totalsd = 0.0, totalcd = 0.0;
                    //getprecio y gettotal
                    System.out.println("obteniendo producto");
                    db.listaProductos();
                        for(Producto p : db.getProducto()){//busco el producto en DataSistema
                            System.out.println("Buscando producto de tipo " + producto.getProducto());
                            if(p.getProducto().equalsIgnoreCase(producto.getProducto())) {//vemos el tipo de producto
                                System.out.println("producto encontrado");
                                int nlinea = sigIdOrden();
                                orden = new ItemOrden(nlinea, cantidad, p.idProducto());
                                precio = p.getPrecio();
                                System.out.println("precio Q." + precio);
                                totalsd = orden.getTotalItem(p);
                                System.out.println(totalsd);
                                System.out.println(orden.toString() + " orden");
                                nlinea++;
                                this.item1 = orden;
                                System.out.println(item1);
                            }
                        }//fin for

                    if(this.cliente instanceof Empresa){
                        Double descuento = totalsd * 0.05;
                        totalcd = totalsd - descuento;
                    }
                }catch (NumberFormatException e){
                    System.out.println(e);
                    //cuadro de diálogo
                }//fin catcht
            }
        }// fin for
        Date fecha = new Date();
        orden(fecha, producto);
    }//fin constructor

    public double getTotal(Producto producto){
        return this.item1.getTotalItem(producto);
        //return precioEnvio*descuento;
    }


    public int sigIdOrden(){
        DataSistema registro = new DataSistema();
        for(Orden ordenes : registro.orden){
            //entrará como 1 para buscar la cantidad de ordenes
            //si no hay ordenes entonces id=1
            int id = 1;
            if(ordenes!=null){
                //si hay una orden anterior id!=2
                //si hay dos ordenes id=3
                id ++;
            }
        }//fin for
        return id;
    }//fin sigIdOrden

    public void setFormaDeEnvio(int diasEnvio, int tipoEnvio) {
        this.diasEnvio = diasEnvio;
        this.tipoEnvio = tipoEnvio;
        if(tipoEnvio == 1){
            //supongamos que si es de tipo 1 el envío es a domicilio
            this.precioEnvio = diasEnvio *  3.90;
        } else if(tipoEnvio == 2){
            //supongamos que si es de tipo 1 el envío es a un almacen
            this.precioEnvio = diasEnvio *  1.20;
        } else if(diasEnvio!=1 && diasEnvio!=2){
            //imprimir un mensaje
            diasEnvio = 2;
        }
    }

    public void orden(Date pfecha, Producto p){
        orden();
        this.fechaOrden = pfecha;
        this.total = this.precioEnvio + this.item1.getTotalItem(p);
        this.estado = 1;
    }


    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", item1=" + item1 +
                ", item2=" + item2 +
                ", fechaOrden=" + fechaOrden +
                ", precioEnvio=" + precioEnvio +
                ", total=" + total +
                ", tipoEnvio=" + tipoEnvio +
                ", estado=" + estado +
                ", diasEnvio=" + diasEnvio +
                '}';
    }
}
