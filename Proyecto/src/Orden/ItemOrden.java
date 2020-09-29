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
  
    public static double getTotalItem(){      
      //  return cantidad*precio;
      return 0;
    }
    
    @Override
    public String toString(){

        return "";
    }
    
   
    
}//class ItemOrden
