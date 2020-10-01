package Orden;
import Cliente.*;

import java.util.Date;
import Frames.VenOrdenPrincipal.OrdenController;
import Producto.Producto;

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
    
    public Orden(){
    total =0.0;
    fechaOrden=new Date();
    this.id = sigIdOrden();
    }

    /**
     *
     * @param pCliente
     * @param pfecha
     */
    public Orden(int pCliente, Date pfecha, Cliente cliente){
        this.cliente = cliente;
        //verificar el cliente y buscarlo
        OrdenController controller = new OrdenController();
        this.cliente = controller.getCliente();
        DataSistema db = new DataSistema();
        ItemOrden orden;
        for(Cliente c : db.getCliente()){
            if(this.cliente.getIdCliente() == pCliente){
                try{
                    int cantidad = Integer.parseInt(controller.getCantidadProducto());
                    //buscar en DataSistema
                    Double precio = 0.0;//obtener el precio del producto
                    Double totalsd = 0.0, totalcd = 0.0;
                    //getprecio y gettotal
                    for(Producto p : db.getProducto()){
                        int nlinea = sigIdOrden();
                        orden = new ItemOrden(nlinea, cantidad, p.idProducto());
                        precio = p.getPrecio();
                        totalsd = orden.getTotalItem();
                        nlinea++;
                        this.item1 = orden;
                    }//fin for
                    if(this.cliente instanceof Empresa){
                        Double descuento = totalsd * 0.05;
                        totalcd = totalsd - descuento;
                    }
                }catch (NumberFormatException e){
                    System.out.println(e);
                    //cuadro de diálogo
                }//fin catcht
            }//fin if
        }// fin for

        new Orden(pfecha);
    }//fin constructor


    public double getTotal(){
        return 0;
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

    public Orden(Date pfecha){
        new Orden();
        this.fechaOrden = pfecha;
        this.total = this.precioEnvio + this.item1.getTotalItem();
        this.estado = 1;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
