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

    public void grafo(){

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
