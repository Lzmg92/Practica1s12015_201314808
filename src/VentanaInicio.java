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

    JFileChooser fc = new JFileChooser();
    JFileChooser fc2 = new JFileChooser();
    String ruta, ruta2;

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

        inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(es.Jugadores.obtener(0).obtenertipo().equals("Plantas")){
                    es.titulo = "Datos Plantas";
                    es.nombretipo =  es.Jugadores.obtener(0).obtenertipo() + " " + es.Jugadores.obtener(0).obtenernombre();
                    es.esPrimera = true;
                    VentanaTipos n = new VentanaTipos();

                    } else {
                    es.titulo = "Datos Zombies";
                    es.nombretipo =  es.Jugadores.obtener(0).obtenertipo() + " " + es.Jugadores.obtener(0).obtenernombre();
                    es.esPrimera = true;
                    VentanaTipos n = new VentanaTipos();
                }
                ven.setVisible(false);
            }
        });


        reporteuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                fc.showSaveDialog(fc);
                int rest = fc.APPROVE_OPTION;
                if(rest==JFileChooser.APPROVE_OPTION)
                {String b=fc.getSelectedFile().toString();
                    ruta = b;}

                es.Jugadores.grafo(ruta, System.getProperty("user.home"));
                System.out.println(ruta);
                System.out.println(System.getProperty("user.home")+ System.getProperty("file.separator")+"Desktop");
            }
        });
    }


}
