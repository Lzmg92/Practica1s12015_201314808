/**
 * Created by Leslie on 22/02/2015.
 */
public class NodoDatosEx {

    String campo;
    String valor;
    NodoDatosEx sig;

    public NodoDatosEx(String campo, String valor){
        this.campo = campo;
        this.valor = valor;
        this.sig = null;
    }

    public void enlacesig(NodoDatosEx n){
        sig = n;
    }

    public NodoDatosEx obtenersig(){
        return sig;
    }

    public String obtenercampo(){
        return campo;
    }

    public String obtenervalor(){
        return valor;
    }

}
