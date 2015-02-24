import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by Leslie on 14/02/2015.
 */
public class VentanaInicio extends JFrame {

    JFrame ven = new JFrame("Plants vrs Zombies");

    JLabel titulo = new JLabel("Plants vrs Zombies");

    JMenuBar barra = new JMenuBar();
    JMenu reporte = new JMenu("Reportes");
    JMenuItem reporteuser = new JMenuItem("Reporte Jugadores");

    JButton JugP = new JButton("Jugador Plantas");
    JButton JugZ = new JButton("Jugador Zombies");
    JButton inicio = new JButton("Comenzar Juego");
    JButton Edatos = new JButton("Eliminar Datos");

    ImageIcon planta = new javax.swing.ImageIcon(getClass().getResource("img/Tira guisantes.png"));
    Image implanta = planta.getImage();
    ImageIcon plantaesc = new ImageIcon(implanta.getScaledInstance(100,100,Image.SCALE_SMOOTH));

    ImageIcon zombie = new javax.swing.ImageIcon(getClass().getResource("img/zombie.png"));
    Image imzobie = zombie.getImage();
    ImageIcon zombieesc = new ImageIcon(imzobie.getScaledInstance(100,110,Image.SCALE_SMOOTH));

    JLabel imaplanta = new JLabel(plantaesc);
    JLabel imazombie = new JLabel(zombieesc);

    final Main es = new Main();

    public VentanaInicio(){

        ven.setSize(600, 400);
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
        Edatos.setBounds(100, 300, 150, 30);
        inicio.setBounds(300, 300, 250, 30);


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

        Edatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              es.Jugadores.vaciarlista();

            }
        });


        reporteuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                es.Jugadores.grafo();
            }
        });
    }


}
