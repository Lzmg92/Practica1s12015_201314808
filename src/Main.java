/**
 * Created by Leslie on 14/02/2015.
 */
public class Main {
    public static void main(String[] args) {

        VentanaInicio s = new VentanaInicio();

        ListaDatosEx nue = new ListaDatosEx();

        System.out.println("Vacia? " + nue.estavacia());

        NodoDatosEx nuev = new NodoDatosEx("edad", "11");
        NodoDatosEx nuevo = new NodoDatosEx("sangre", "0+");

        nue.add(nuev);
        nue.addprimero(nuevo);

        System.out.println("Vacia? " + nue.estavacia());
        System.out.println("Tamaño = "+ nue.size());

        System.out.println("Nodo 1 campo = "+ nue.obtener(1).obtenercampo());
        System.out.println("Nodo 1 valor = " + nue.obtener(1).obtenervalor());

        System.out.println("Nodo 2 campo = " + nue.obtener(0).obtenercampo());
        System.out.println("Nodo 2 valor = "+ nue.obtener(0).obtenervalor());

    }
}
