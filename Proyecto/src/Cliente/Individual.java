package Cliente;

public class Individual extends Cliente {
    private String dpi;

    public Individual(String dpi, int id){
        this.dpi = dpi;
        this.id = id;
    }
    public  Individual(Cliente cliente, String dpi){
        this.dpi = dpi;
        this.id = cliente.getIdCliente();
    }
    public  Individual(Cliente cliente){
        this.id = cliente.getIdCliente();
    }

    public Individual(){

    }
    public String getDpi() {
        return dpi;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "dpi='" + dpi + '\'' +
                ", id=" + id +
                '}';
    }
}
