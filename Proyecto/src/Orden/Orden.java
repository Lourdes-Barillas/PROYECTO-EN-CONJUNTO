/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orden;
import Cliente.Cliente;

import java.util.Date;
/**
 *
 * @author deleo
 */
public class Orden {
    int id;
    Cliente cliente;
    ItemOrden item1;
    ItemOrden item2;
    Date fechaOrden;
    double precioEnvio;
    double total;
    String tipoEnvio;
    String Estado;
    static int sigIdOrden;
    int diasEnvio;
    
    public Orden(){
    total =0.0;
    fechaOrden=new Date();
    //inicializar id
    }
    
    public Orden(int pCliente, Date pfecha){
        
    }
    public double getTotal(){
        return 0;
        //return precioEnvio*descuento;
    }
    
}
