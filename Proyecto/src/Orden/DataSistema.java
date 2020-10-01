
package Orden;

import Cliente.Cliente;
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

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    /**
     * DB de clientes
     */
    public void listaClientes(){
        this.cliente.add(new Cliente());
    }


    /**
     * DB de productos
     */
    public void listaProductos(){
        this.producto.add(new Producto());
    }
}
