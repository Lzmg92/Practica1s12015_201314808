/**
 * Created by Leslie on 22/02/2015.
 */
public class ListaDatosEx {

    NodoDatosEx cabeza, cola;
    int size;

    public ListaDatosEx(){
        cabeza = null;
        cola = null;
        size = 0;
    }

    public void addprimero(NodoDatosEx nod){
        if(cabeza == null){
            cabeza = nod;
        } else {
            NodoDatosEx temp = cabeza;
            NodoDatosEx nuevo = nod;
            nuevo.enlacesig(temp);
            cabeza = nuevo;
        }
        size++;
    }

    public void add(NodoDatosEx nod){
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


    public NodoDatosEx obtener(int index){
        int contador = 0;
        NodoDatosEx temp = cabeza;
        while(contador<index){
            temp = temp.obtenersig();
            contador++;
        }
        return temp;
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
