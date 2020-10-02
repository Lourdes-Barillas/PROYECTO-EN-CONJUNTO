package Cliente;

public class Empresa extends Cliente{
    private String contacto;

    public Empresa(String contacto, int id){
        this.contacto = contacto;
        this.id = id;
    }

    @Override
    public int getIdCliente() {
        return super.getIdCliente();
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "contacto='" + contacto + '\'' +
                ", id=" + id +
                '}';
    }

    public Empresa(Cliente cliente, String contacto){
        this.contacto = contacto;
        this.id = cliente.getIdCliente();
    }

    public Empresa(){

    }

    public  Empresa(Cliente cliente){
        this.id = cliente.getIdCliente();
    }
}
