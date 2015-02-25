import javax.swing.*;
import java.io.*;

/**
 * Created by Leslie on 22/02/2015.
 */
public class ListaDatos {

    NodoDatos cabeza, cola;
    int size;

    public ListaDatos(){
        cabeza = null;
        cola = null;
        size = 0;
    }

    public void addprimero(NodoDatos nod){
        if(cabeza == null){
            cabeza = nod;
        } else {
            NodoDatos temp = cabeza;
            NodoDatos nuevo = nod;
            nuevo.enlacesig(temp);
            cabeza = nuevo;
        }
        size++;
    }

    public void add(NodoDatos nod){
        if(cola == null)
        {
            cola = nod;
            cabeza = cola;
        }
        else
        {
            cola.sig = nod;
            cola = cola.sig;
        }
        size++;
    }


    public NodoDatos obtener(int index){
        int contador = 0;
        NodoDatos temp = cabeza;
        while(contador<index){
            temp = temp.obtenersig();
            contador++;
        }
        return temp;
    }

    public void eliminiar(int index){
        if(index == 0){
            cabeza = cabeza.obtenersig();
        } else {
            int contador = 0;
            NodoDatos temporal = cabeza;
            while (contador < index-1){
                temporal = temporal.obtenersig();
                contador++;
            }
            temporal.enlacesig(temporal.obtenersig().obtenersig());
        }
        size--;
    }

    public void vaciarlista(){
        cabeza = null;
        cola = null;
        size = 0;
    }



    public void Escribir (String NombreArchivo){

        File f;
        f = new File("C:\\Users\\Leslie\\Desktop", NombreArchivo);

        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);


            wr.write("digraph G{ \n" +
                    " rankidir = LR;\n" +
                    " node[shape = Mrecord]; \n" +
                    " rankidir = UD; \n");

            for(int i=0;i< size();i++){
                wr.write(" {  rank = same; ");
                wr.write(" Jugador"+(i+1)+"[label = Nombre_"+obtener(i).obtenernombre()+"]; ");
                wr.write(" nodo"+i+"_1[label = Tipo_"+obtener(i).obtenertipo()+"]; ");
                wr.write(" nodo"+i+"_2[label = Cantidad_"+obtener(i).obtenercantidad()+"]; ");
                ListaDatosEx temp = obtener(i).obtenerextras();
                int cont = 0;
                for(int j=0; j < temp.size();j++){
                    wr.write(" nodo"+i+""+j+"[label = "+temp.obtener(j).obtenercampo()+"_"+temp.obtener(j).obtenervalor()+"]; ");
                    cont++;
                }
                wr.write(" Jugador"+(i+1)+" -> nodo"+i+"_1; \n" +
                        " nodo"+i+"_1 -> nodo"+i+"_2; \n" +
                         " nodo"+i+"_2 -> nodo"+i+"0; ");
                for(int m = 0; m <= cont-2; m++){
                       wr.write(" nodo"+i+""+m+" -> nodo"+i+""+(m+1)+"; ");
                }
                wr.write(" }; ");
           }

            wr.write(" Jugadores -> Jugador1; " +
                    "  Jugador1 -> Jugador2; " +
                    "}");

            wr.close();
            bw.close();


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "La ruta especificada no existe", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();}
    }


    public void grafo(){
        Escribir("grafojugadores.txt");
        try {
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = "C:\\Users\\Leslie\\Desktop\\grafojugadores.txt";
            String fileOutputPath = "C:\\Users\\Leslie\\Desktop\\grafojugadores.jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec( cmd );

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

    }

    public int size(){
        return size;
    }

    public boolean estavacia(){
        if(cola == null){
            return true;
        } else {
            return false;
        }
    }


}
