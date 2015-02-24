import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Leslie on 23/02/2015.
 */
public class VentanaTipos extends JFrame{

    String titulo = "Datos Plantas";

    JFrame ven = new JFrame(titulo);

    DefaultTableModel registros;
    JTable tablaregistro = new JTable(registros);
    JScrollPane scroll = new JScrollPane(tablaregistro);

    Object [][] data;
    String [] col = {"Imagen", "Nombre", "Puntos", "Ataque"};

    JMenuBar barra = new JMenuBar();
    JMenu reporte = new JMenu("Reportes");
    JMenuItem reporteuser = new JMenuItem("Reporte Personajes");

    JButton Modificar = new JButton("Modificar");
    JButton Eliminar = new JButton("Eliminar");
    JButton Finalizar = new JButton("Finalizar");


    public VentanaTipos(){

        ven.setSize(600, 400);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ven.setLayout(null);
        ven.setVisible(true);


        tablaregistro.setPreferredScrollableViewportSize(new Dimension(400, 50));

        ven.getContentPane().add(scroll, BorderLayout.CENTER);

        ven.add(scroll);
        ven.setJMenuBar(barra);
        barra.add(reporte);
        reporte.add(reporteuser);

        ven.add(Modificar);
        ven.add(Eliminar);
        ven.add(Finalizar);

        registros = new DefaultTableModel(data, col);
        tablaregistro.setModel(registros);

        tablaregistro.setLocation(15,10);
        tablaregistro.setSize(400, 200);

        scroll.setBounds(25 ,60, 550, 270);

        Modificar.setBounds(25, 10, 100, 30);
        Eliminar.setBounds(135, 10, 100, 30);
        Finalizar.setBounds(245, 10, 100, 30);
    }

}
