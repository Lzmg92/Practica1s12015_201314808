import java.util.Objects;

/**
 * Created by Leslie on 22/02/2015.
 */
public class NodoDatos {

    String nombre;
    String tipo;
    int cantidad;
    Object pilacola;
    ListaDatosEx extras;
    NodoDatos sig;


    public NodoDatos(String nombre, String tipo, int cantidad, ListaDatosEx extras, Object pilacola ){
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.extras = extras;
        this.pilacola = pilacola;
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

    public Object obtenerpilacola(){
        return pilacola;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPilacola(Object pilacola) {
        this.pilacola = pilacola;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setExtras(ListaDatosEx extras) {
        this.extras = extras;
    }

}
