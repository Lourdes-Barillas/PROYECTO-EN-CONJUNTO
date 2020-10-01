package Cliente;

public class Individual extends Cliente {
    private String dpi;

    public Individual(String dpi, int id){
        this.dpi = dpi;
        this.id = id;
    }
    public  Individual(){

    }

    public String getDpi() {
        return dpi;
    }
}
