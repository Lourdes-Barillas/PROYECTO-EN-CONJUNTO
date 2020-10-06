package Frames;

import Cliente.*;
import Orden.*;

import java.io.*;
import java.util.Date;

public class MadeOrden {
    private int id_Orden;
    private String ido;
    private String cliente;
    private String dpi;
    private String contacto;
    private int id_cliente;
    private ItemOrden item;
    private Date fecha;
    private String date;
    private Double total;
    private String ptotal;
    private int tipoDeEnvio;
    private String tde;
    private String te;
    private int diasEnvio;
    private String d;
    private String nomProducto;

    public void addData(Orden orden, String contacto){
        Cliente c = orden.getCliente();
        this.id_Orden = 1;
        this.cliente = orden.getTc().toString();
        System.out.println("Let's get the type");
        if(c.getTipoCliente() ==TipoCliente.Persona){
            this.dpi = ((Individual) c).getDpi();
        }
        this.contacto = contacto;
        System.out.println("The type has geted as " + this.contacto);

        this.item = orden.getItem1();
        this.fecha = orden.getFechaOrden();
        this.total = orden.getTotal(orden.getProducto());
        this.tipoDeEnvio = orden.getTipoEnvio();
        this.diasEnvio = orden.getDiasEnvio();
        this.nomProducto = orden.getProducto().getProducto();
        System.out.println("What has been geted"+orden.toString());
        System.out.println("Everything has been geted");
    }//end addData

    public void addToArchive(Orden orden, String contacto){
        System.out.println("opening file");
        File file = new File("orden.txt");
        addData(orden, contacto);
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            bf.write(this.id_Orden + "");bf.newLine();
            if(orden.getTc()==TipoCliente.Persona){
                bf.write("Individual");
            }else
                bf.write(TipoCliente.Empresarial.toString());bf.newLine();

            System.out.println("Writting the type");
            /*if(orden.getCliente().getTipoCliente()==TipoCliente.Persona){
                bf.write(this.dpi);
            }else
                bf.write(this.contacto);*/

            bf.write(this.contacto);bf.newLine();
            bf.write(this.fecha.toString());bf.newLine();
            bf.write(this.total+"");bf.newLine();
            bf.write(this.tipoDeEnvio+"");bf.newLine();
            bf.write(this.diasEnvio+ "");bf.newLine();
            bf.write(this.nomProducto + "");
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getData(){
        File file = new File("orden.txt");
        String orden[] = new String[8];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int i=0;
            while( (line=br.readLine()) !=null){

                switch (i){
                    case 0:
                        this.ido = (line);
                        orden[0] = line;
                        break;
                    case 1:
                        this.te = (line);
                        orden[1] = line;
                        break;
                    case 2://dpi o contacto
                        this.dpi = line;
                        this.contacto = dpi;
                        orden[2] = line;;
                        break;
                    case 3://fecha
                        this.date = line;
                        orden[3] = line;
                        break;
                    case 4://precio
                        this.ptotal = line;
                        orden[4] = line;
                        break;
                    case 5://tipo de envio
                        this.tde=(line);
                        orden[5] = line;
                        break;
                    case 6://dias de envio
                        this.d = (line);
                        orden[6] = line;
                        break;
                    case 7:
                        this.nomProducto = (line);
                        orden[7] = line;
                        break;
                }
                i++;
                //[id, tipo de envio, dpi, contacto, date, ptotal, tip de envio, dias]
                orden = new String[]{this.ido + "", this.te + "", "" + this.dpi,
                        "" + this.contacto, "" + this.date, "" + this.ptotal, "" + this.tde, "" + this.nomProducto};
              //  i++;
            }
            br.close();
            //}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orden;
    }

}
