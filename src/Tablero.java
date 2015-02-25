import javax.swing.*;
import java.awt.*;

/**
 * Created by Leslie on 25/02/2015.
 */
public class Tablero extends JFrame {


    JFrame ven = new JFrame("Plants vrs Zombies");

    JMenuBar barra = new JMenuBar();
    JMenu reporte = new JMenu("Reportes");
    JMenuItem reporteuser = new JMenuItem("Reporte Jugadores");

    JLabel nombrejug1 = new JLabel();
    JLabel nombrejug2 = new JLabel();

    final Main es = new Main();



    public Tablero(){

        ven.setSize(900, 700);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ven.setLayout(null);
        ven.setVisible(true);

        ven.setJMenuBar(barra);
        barra.add(reporte);
        reporte.add(reporteuser);

        ven.getContentPane().setBackground(Color.black);



    }

}
