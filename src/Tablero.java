import javax.swing.*;
import java.awt.*;

/**
 * Created by Leslie on 25/02/2015.
 */
public class Tablero extends JFrame implements Runnable{

    int i = 0;

    Thread t;

    JFrame ven = new JFrame("Plants vrs Zombies");

    JMenuBar barra = new JMenuBar();
    JMenu reporte = new JMenu("Reportes");
    JMenuItem reporteuser = new JMenuItem("Reporte Jugadores");

    JLabel nombrejug1 = new JLabel("Jugador1");
    JLabel nombrejug2 = new JLabel("Jugador2");

    TableroDinamico este = new TableroDinamico();
    ImageIcon planta;

    MyTableModel modelo;
    JTable tablaregistro = new JTable(modelo);
    JScrollPane scroll = new JScrollPane(tablaregistro);

    Object [][] data;
    String [] col = {"Plantas"};

    MyTableModel modelo2;
    JTable tablaregistro2 = new JTable(modelo2);
    JScrollPane scroll2 = new JScrollPane(tablaregistro2);

    Object [][] data2;
    String [] col2 = {"Zombies"};

    final Main m = new Main();

    public Tablero(){

        ven.setSize(900, 650);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ven.setLayout(null);
        ven.setVisible(true);

        ven.setJMenuBar(barra);

        ven.getContentPane().setBackground(Color.black);

        barra.add(reporte);
        reporte.add(reporteuser);

        ven.add(scroll);
        ven.add(scroll2);
        ven.add(este);
        ven.add(nombrejug1);
        ven.add(nombrejug2);

        modelo = new MyTableModel(data, col);
        tablaregistro.setModel(modelo);
        tablaregistro.setRowHeight(60);
        tablaregistro.setShowGrid(false);
        tablaregistro.setBackground(Color.GRAY);

        modelo2 = new MyTableModel(data2, col2);
        tablaregistro2.setModel(modelo2);
        tablaregistro2.setRowHeight(60);
        tablaregistro2.setShowGrid(false);
        tablaregistro2.setBackground(Color.GRAY);

        este.setBounds(100, 30, 700, 600);
        nombrejug1.setBounds(10, 10, 100, 20);
        nombrejug2.setBounds(810, 10, 100, 20);

        scroll.setBounds(0 ,30, 100, 560);
        scroll2.setBounds(800 ,30, 100, 560);

        t = new Thread(this, "1hilo");
        t.start();
    }

    public ImageIcon JalarImagen(String ruta){
        planta = new javax.swing.ImageIcon(ruta);
        Image implanta = planta.getImage();
        ImageIcon plantaesc = new ImageIcon(implanta.getScaledInstance(40,40,Image.SCALE_SMOOTH));
        return plantaesc;
    }


    public int mayor(){
        if(m.PilaPrun.size() < m.ColaZrun.size()){
            return m.ColaZrun.size();
        }else{
            return m.PilaPrun.size();
        }
    }



    @Override
    public void run() {

        try {
            while (i < mayor()) {
                Object[] temp = {JalarImagen(m.PilaPrun.get().obtenerimagen())};
                Object[] temp2 = {JalarImagen(m.ColaZrun.get().obtenerimagen())};
                modelo.addRow(temp);
                modelo2.addRow(temp2);
                i++;

            }

            Thread.sleep(50000);
        } catch (InterruptedException e){};
    }
}
