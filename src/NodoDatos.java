/**
 * Created by Leslie on 22/02/2015.
 */
public class NodoDatos {

    String nombre;
    int cantidad;
    NodoDatosEx extras;
    NodoDatos sig;

    public NodoDatos(String nombre, int cantidad ){
        this.nombre = nombre;
        this.cantidad = cantidad;
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

    public int obtenercantidad(){
        return cantidad;
    }

}
