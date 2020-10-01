
package Orden;

import Cliente.*;
import Producto.Producto;
import java.util.ArrayList;

public class DataSistema {
    //public static ArrayList<Cliente> cliente=new ArrayList (8);
    public ArrayList<Cliente> cliente = new ArrayList(8);
    public ArrayList<Orden> orden = new ArrayList(8);
    public ArrayList<Producto> producto = new ArrayList(8);

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    /**
     * DB de clientes
     */
    public void listaClientes(){
        this.cliente.add(new Individual("3045269871452", 1));
    }


    /**
     * DB de productos
     */
    public void listaProductos(){
        //el precio de cada producto es por cada unidad
        this.producto.add(new Producto(1, "Llanta", "Firestone", 20.90));//1
        this.producto.add(new Producto(2, "Aro", "Luigi", 30.90));//2
        this.producto.add(new Producto(3, "Batería", "Dolar Industria", 500.90));//3
        this.producto.add(new Producto(4, "Espejo", "Boutique del Automovil", 50.90));//4
        this.producto.add(new Producto(5, "Vela", "Dicas", 50.90));//5
        this.producto.add(new Producto(6, "Radiador", "Vento", 120.90));//6
        this.producto.add(new Producto(7, "Linterna delantera", "KIA", 75.90));//7
        this.producto.add(new Producto(8, "Linterna trasera", "KIA", 80.90));//8
    }
    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setOrden(Orden orden) {
        this.orden.add(orden);
    }

    public ArrayList<Orden> getOrden() {
        return orden;
    }
}
