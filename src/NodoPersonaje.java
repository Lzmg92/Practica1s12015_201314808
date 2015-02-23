/**
 * Created by Leslie on 23/02/2015.
 */
public class NodoPersonaje {

    String imagen;
    String nombre;
    int puntos;
    String ataque;
    NodoPersonaje sig;

    public NodoPersonaje(String imagen, String nombre, int puntos, String ataque){
        this.imagen = imagen;
        this.nombre = nombre;
        this.puntos = puntos;
        this.ataque = ataque;
        this.sig = null;
    }

    public void enlacesig(NodoPersonaje n){
        sig = n;
    }

    public NodoPersonaje obtenersig(){
        return sig;
    }

    public String obtenerimagen(){
        return imagen;
    }

    public String obtenernombre(){
        return nombre;
    }

    public int obtenerpuntos(){ return puntos;}

    public String obtenerataque(){
        return ataque;
    }


    public void setimagen(String imagen){
        this.imagen = imagen;
    }

    public void setnombre(String nombre){
        this.nombre = nombre;
    }

    public void setpuntos(int puntos){
        this.puntos = puntos;
    }

    public void setataque(String ataque){
        this.ataque = ataque;
    }

}



