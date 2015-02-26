/**
 * Created by Leslie on 14/02/2015.
 */
public class Main {

    public static int coorfilas = 0;
    public static int coorcolum = 0;
    public static String titulo = "Datos Plantas";
    public static String nombretipo = "";
    public static ListaDatos Jugadores = new ListaDatos();
    public static ListaPersonajes ListaPjugP =  new ListaPersonajes();
    public static ListaPersonajes ListaPjugZ = new ListaPersonajes();
    public static Boolean esPrimera = true;

    public static PilaPlantas PilaPrun = new PilaPlantas();
    public static ColaZombies ColaZrun = new ColaZombies();

    public static void main(String[] args) {


        System.out.println(System.getProperty("user.home")+ System.getProperty("file.separator")+"Desktop");
        System.out.println(System.getProperty("file.separator") + "grafojugadores.jpg");

        VentanaInicio s = new VentanaInicio();



    }
}
