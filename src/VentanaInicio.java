import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Leslie on 14/02/2015.
 */
public class VentanaInicio extends JFrame {

    Main n = new Main();

    JFrame ven = new JFrame("Plants vrs Zombies");

    JLabel titulo = new JLabel("Plants vrs Zombies");

    JButton JugP = new JButton("Jugador Plantas");
    JButton JugZ = new JButton("Jugador Zombies");
    JButton inicio = new JButton("Comenzar Juego");
    JButton Edatos = new JButton("Eliminar Datos");

    ImageIcon planta = new javax.swing.ImageIcon(getClass().getResource("Tira guisantes.png"));
    Image implanta = planta.getImage();
    ImageIcon plantaesc = new ImageIcon(implanta.getScaledInstance(100,100,Image.SCALE_SMOOTH));

    ImageIcon zombie = new javax.swing.ImageIcon(getClass().getResource("zombie.png"));
    Image imzobie = zombie.getImage();
    ImageIcon zombieesc = new ImageIcon(imzobie.getScaledInstance(100,110,Image.SCALE_SMOOTH));

    JLabel imaplanta = new JLabel(plantaesc);
    JLabel imazombie = new JLabel(zombieesc);



    public VentanaInicio(){

        ven.setSize(600, 400);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ven.setLayout(null);
        ven.setVisible(true);

        ven.getContentPane().setBackground(Color.black);

        titulo.setFont(new Font("Arial Rounded", Font.BOLD, 21));
        titulo.setForeground(Color.white);

        ven.add(titulo);
        ven.add(JugP);
        ven.add(JugZ);
        ven.add(inicio);
        ven.add(Edatos);
        ven.add(imaplanta);
        ven.add(imazombie);

        titulo.setBounds(200, 20, 300, 50);
        JugP.setBounds(100, 90, 150, 30);
        imaplanta.setBounds(110, 150, 110, 110);
        JugZ.setBounds(350, 90, 150, 30);
        imazombie.setBounds(360, 150, 110, 110);
        Edatos.setBounds(50, 320, 150, 30);
        inicio.setBounds(300, 320, 250, 30);


        JugP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaDatos n = new VentanaDatos();
                n.titulo.setText("Plantas");
                ven.setVisible(false);

            }
        });

        JugZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaDatos n = new VentanaDatos();
                n.titulo.setText("Zombies");
                ven.setVisible(false);

            }
        });





        System.out.println("Vacia? " + n.Jugadores.estavacia());
        System.out.println("Tamaño = " + n.Jugadores.size());

        System.out.println("Nodo 1 Nombre = " + n.Jugadores.obtener(0).obtenernombre());
        System.out.println("Nodo 1 Cantidad = " + n.Jugadores.obtener(0).obtenercantidad());
        System.out.println("Nodo 1 Tipo = "+ n.Jugadores.obtener(0).obtenertipo());
        System.out.println("Nodo 1 Extras1 = "+ n.Jugadores.obtener(0).obtenerextras().obtener(0).obtenercampo()+"  "+ n.Jugadores.obtener(0).obtenerextras().obtener(0).obtenervalor());









    }


}
