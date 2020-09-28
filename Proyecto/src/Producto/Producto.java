package Producto;

public class Producto {
    private int idProducto;//inicializará con el valor de 200
    private String producto;
    private String marca;
    private String precio;

    public Producto(){
      //se inicializa el sigId aquí
    }


    public Producto(int idProducto, String producto, String marca, String precio){
        //todos los parámetros
    }

    public int idProducto(){
        return 0;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public String getMarca() {
        return marca;
    }

    public String getPrecio(){
        return "";
    }

    public String toString(){
        return "";
    }

    public String getClase(){
        return "";
    }
}
