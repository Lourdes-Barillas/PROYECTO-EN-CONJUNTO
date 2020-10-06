package Cliente;

public class Cliente {
    //static int sigIdCliente;
    private TipoCliente tipoCliente;
    public int id;
   // public String dato;

    public int getIdCliente(){
        return id;
    }
    //public String getDato(){ return dato;}

    public Cliente(TipoCliente cliente){
        this.tipoCliente = cliente;
    }
    public Cliente(){
        //Todos los parámetros
    }

    public String toString(){
        return tipoCliente.toString();
    }

    public String getNombreClase(){
        String clase = this.tipoCliente.toString();
        return clase;
    }
    public TipoCliente getTipoCliente(){
        return this.tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
