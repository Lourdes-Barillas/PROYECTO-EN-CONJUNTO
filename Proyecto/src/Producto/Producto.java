package Producto;

public class Producto {
    private int idProducto;//inicializará con el valor de 200
    private String producto;
    private String marca;
    private Double precio;

    public Producto(){
      //se inicializa el sigId aquí
    }


    public Producto(int idProducto, String producto, String marca, Double precio){
        //todos los parámetros
        this.idProducto = idProducto;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
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

    public void setPrecio(Double precio) {
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

    public Double getPrecio(){
        return this.precio;
    }

    public String toString(){
        return "";
    }

    public String getClase(){
        return "";
    }
}
