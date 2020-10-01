package Cliente;

public class Cliente {
    //static int sigIdCliente;
    private TipoCliente tipoCliente;
    private int id;


    public int getIdCliente(){
        return id;
    }


    public Cliente(TipoCliente cliente){
        this.tipoCliente = cliente;
    }
    public Cliente(){
        //Todos los parámetros
    }

    public String toString(){
        return "";
    }

    public String getNombreClase(){
        String clase = this.tipoCliente.toString();
        return clase;
    }



}
