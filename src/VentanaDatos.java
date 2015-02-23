import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Leslie on 22/02/2015.
 */
public class VentanaDatos extends JFrame {

    ListaDatos Jugadores = new ListaDatos();
    PilaPlantas plantas = new PilaPlantas();
    ColaZombies zombies = new ColaZombies();

    JFrame ven = new JFrame("Datos");

    JMenuBar barra = new JMenuBar();
    JMenu reporte = new JMenu("Reportes");
    JMenuItem reporteuser = new JMenuItem("Reporte Jugador");

    JLabel titulo = new JLabel();
    JLabel nombre = new JLabel("Nombre");
    JLabel cantidad = new JLabel("Cantidad");

    JTextArea txtnombre = new JTextArea();
    JTextArea txtcantidad = new JTextArea();

    JButton Agregar = new JButton("Agregar Campos");
    JButton Guardar = new JButton("Guardar");

    ListaDatosEx masdatos = new ListaDatosEx();

    public VentanaDatos(){

        ven.setSize(400, 350);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ven.setLayout(null);
        ven.setVisible(true);

        ven.setJMenuBar(barra);
        barra.add(reporte);
        reporte.add(reporteuser);

        ven.getContentPane().setBackground(Color.black);

        titulo.setFont(new Font("Arial Rounded", Font.BOLD, 21));
        titulo.setForeground(Color.white);

        nombre.setFont(new Font("Arial Rounded", Font.BOLD, 18));
        nombre.setForeground(Color.white);

        cantidad.setFont(new Font("Arial Rounded", Font.BOLD, 18));
        cantidad.setForeground(Color.white);

        ven.add(titulo);
        ven.add(nombre);
        ven.add(txtnombre);
        ven.add(cantidad);
        ven.add(txtcantidad);
        ven.add(Agregar);
        ven.add(Guardar);

        titulo.setBounds(150, 30, 100, 40);
        nombre.setBounds(50, 100, 100, 30);
        txtnombre.setBounds(150, 100, 200, 30);
        cantidad.setBounds(50, 180, 100, 30);
        txtcantidad.setBounds(150, 180, 200, 30);
        Agregar.setBounds(50, 250, 150, 30);
        Guardar.setBounds(250, 250, 100, 30);

        Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String campo = JOptionPane.showInputDialog("Ingrese Nuevo Campo ");
                String valor = JOptionPane.showInputDialog("Ingrese Nuevo Valor ");
                NodoDatosEx nue = new NodoDatosEx(campo, valor);
                masdatos.add(nue);
            }
        });

        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(titulo.getText().equals("Plantas")){
                NodoDatos nuevito = new NodoDatos(txtnombre.getText(), titulo.getText(), Integer.parseInt(txtcantidad.getText()), masdatos, plantas);
               // VentanaInicio n = new VentanaInicio();
                Jugadores.add(nuevito);
                }else {
                    NodoDatos nuevito = new NodoDatos(txtnombre.getText(), titulo.getText(), Integer.parseInt(txtcantidad.getText()), masdatos, zombies);
                //    VentanaInicio n = new VentanaInicio();
                    Jugadores.add(nuevito);
                }

/*

                System.out.println("Vacia? " + Jugadores.estavacia());
                System.out.println("Tamaño = " + Jugadores.size());
                System.out.println("Tamaño = " + masdatos.size());

                System.out.println("Nodo 1 Nombre = " + Jugadores.obtener(0).obtenernombre());
                System.out.println("Nodo 1 Cantidad = " + Jugadores.obtener(0).obtenercantidad());
                System.out.println("Nodo 1 Tipo = "+ Jugadores.obtener(0).obtenertipo());
                System.out.println("Nodo 1 Extras1 = "+ Jugadores.obtener(0).obtenerextras().obtener(0).obtenercampo()+"  "+ Jugadores.obtener(0).obtenerextras().obtener(0).obtenervalor());
                System.out.println("Nodo 1 Extras2 = "+ Jugadores.obtener(0).obtenerextras().obtener(1).obtenercampo()+"  "+ Jugadores.obtener(0).obtenerextras().obtener(1).obtenervalor());
                System.out.println("Nodo 1 Extras3 = "+ Jugadores.obtener(0).obtenerextras().obtener(2).obtenercampo()+"  "+ Jugadores.obtener(0).obtenerextras().obtener(2).obtenervalor());


                System.out.println("----------------- eliminado ---------------------");

                masdatos.eliminiar(0);

                System.out.println("Vacia? " + Jugadores.estavacia());
                System.out.println("Tamaño J = " + Jugadores.size());
                System.out.println("Tamaño = " + masdatos.size());

                System.out.println("Nodo 1 Extras1 = "+ Jugadores.obtener(0).obtenerextras().obtener(0).obtenercampo()+"  "+ Jugadores.obtener(0).obtenerextras().obtener(0).obtenervalor());
                System.out.println("Nodo 1 Extras2 = "+ Jugadores.obtener(0).obtenerextras().obtener(1).obtenercampo()+"  "+ Jugadores.obtener(0).obtenerextras().obtener(1).obtenervalor());

            */

               // ven.setVisible(false);
                }
        });

        reporteuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           Jugadores.grafo();
            }
        });


    }


}
