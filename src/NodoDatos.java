/**
 * Created by Leslie on 22/02/2015.
 */
public class NodoDatos {

    String nombre;
    String tipo;
    int cantidad;
    ListaDatosEx extras;
    NodoDatos sig;

    public NodoDatos(String nombre, String tipo, int cantidad, ListaDatosEx extras ){
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.extras = extras;
        this.sig = null;
    }

    public void enlacesig(NodoDatos n){
        sig = n;
    }

    public NodoDatos obtenersig(){
        return sig;
    }

    public String obtenernombre(){
        return nombre;
    }

    public String obtenertipo(){
        return tipo;
    }

    public int obtenercantidad(){
        return cantidad;
    }

    public ListaDatosEx obtenerextras() {return extras;}


}
