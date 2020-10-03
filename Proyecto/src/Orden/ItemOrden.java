package Orden;
import Producto.Producto;
public class ItemOrden {
    int noLinea;
    int cantidad;
    Producto producto;
    public ItemOrden(int pNoLinea,int pCantidad,int pIdProducto){     
        noLinea=pNoLinea;
        cantidad=pCantidad;
    }
  
    public double getTotalItem(Producto producto){
        double total = 0.0;
        try {
            total = ((double) cantidad) * producto.getPrecio();
        }catch (NumberFormatException e){
            System.out.println(e);
        }
        return total;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString(){
        return "";
    }
    
   
    
}//class ItemOrden
