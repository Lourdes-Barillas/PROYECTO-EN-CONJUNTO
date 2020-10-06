
package Orden;

import Cliente.*;
import Producto.Producto;
import java.util.ArrayList;

public class DataSistema {
    //public static ArrayList<Cliente> cliente=new ArrayList (8);
    public ArrayList<Cliente> cliente = new ArrayList(8);
    public ArrayList<Orden> orden = new ArrayList(8);
    public ArrayList<Producto> producto = new ArrayList(8);
    public ArrayList<ItemOrden> items = new ArrayList(8);



    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setItems(ItemOrden item) {
        this.items.add(item);
    }

    public ArrayList<ItemOrden> getItems() {
        return items;
    }

    /**
     * DB de clientes
     */
    public void listaClientes(){
        this.cliente.add(new Individual("2584569874596", 1));
        this.cliente.add(new Individual("3045269871452", 2));
        this.cliente.add(new Individual("3541257896541", 3));
        this.cliente.add(new Individual("2136987541236", 4));

        this.cliente.add(new Empresa("bbzumeta@gmail.com", 5));
        this.cliente.add(new Empresa("zcuffaine@hotmail.com", 6));
        this.cliente.add(new Empresa("marcela53@yahoo.com", 7));
        this.cliente.add(new Empresa("mzoruna@gmail.com", 8));
    }


    /**
     * DB de productos
     */
    public void listaProductos(){
        //el precio de cada producto es por cada unidad
        this.producto.add(new Producto(201, "Llanta", "Firestone", 20.90));//1
        this.producto.add(new Producto(202, "Aro", "Luigi", 30.90));//2
        this.producto.add(new Producto(203, "Batería", "Dolar Industria", 500.90));//3
        this.producto.add(new Producto(204, "Espejo", "Boutique del Automovil", 50.90));//4
        this.producto.add(new Producto(205, "Vela", "Dicas", 50.90));//5
        this.producto.add(new Producto(206, "Radiador", "Vento", 120.90));//6
        this.producto.add(new Producto(207, "Linterna delantera", "KIA", 75.90));//7
        this.producto.add(new Producto(208, "Linterna trasera", "KIA", 80.90));//8
    }
    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setOrden(Orden orden) { this.orden.add(orden); }

    public ArrayList<Orden> getOrden() {
        return orden;
    }

    public Producto devolverProducto(int a){return this.producto.get(a);}
    public Cliente devolverCliente(int b){return this.cliente.get(b);}
    public Orden devolverOrden(int c){return this.orden.get(c);}


    public void listaOden(){
        DataSistema db = new DataSistema();
        db.listaProductos();
        db.listaClientes();
        System.out.println(db.getCliente().toString() + "\n" + db.getProducto().toString());
        System.out.println(db.getCliente().get(2));
        this.orden.add(new Orden(1, db.getCliente().get(0), db.getProducto().get(1).getIdProducto() +"", db.getProducto().get(0)));

        System.out.println("\n\n\n\n\nfin data");
       /* this.orden.add(new Orden(2, db.getCliente().get(1), db.getProducto().get(2).getIdProducto() +"", db.getProducto().get(1)));

        System.out.println("fin data");
        this.orden.add(new Orden(3, db.getCliente().get(2), db.getProducto().get(3).getIdProducto() +"", db.getProducto().get(2)));

        System.out.println("fin data");
        this.orden.add(new Orden(2, db.getCliente().get(1), db.getProducto().get(4).getIdProducto() +"", db.getProducto().get(3)));

        System.out.println("fin data");
        this.orden.add(new Orden(1, db.getCliente().get(0), db.getProducto().get(1).getIdProducto() +"", db.getProducto().get(0)));

        System.out.println("fin data");
        this.orden.add(new Orden(2, db.getCliente().get(1), db.getProducto().get(2).getIdProducto() +"", db.getProducto().get(1)));

        System.out.println("fin data");
        this.orden.add(new Orden(3, db.getCliente().get(2), db.getProducto().get(3).getIdProducto() +"", db.getProducto().get(2)));
         */
        System.out.println("fin data");
    }

}
