/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orden;
import Cliente.Cliente;
import Producto.Producto;

import java.util.ArrayList;

/**
 *
 * @author deleo
 */
public class DataSistema {
    //public static ArrayList<Cliente> cliente=new ArrayList (8);
    public static ArrayList<Cliente> cliente;
    public static ArrayList<Orden> orden;
    public static ArrayList<Producto> producto;
    
    public DataSistema(){
        cliente=new ArrayList(8);
        orden = new ArrayList(8);
        producto=new ArrayList(8);       
        
    }
    
    
   // public DataSistema(){}
}
