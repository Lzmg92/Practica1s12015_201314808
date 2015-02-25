import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Leslie on 23/02/2015.
 */
public class VentanaTipos extends JFrame{

    final Main m = new Main();

    JFrame ven = new JFrame(m.titulo);

    MyTableModel modelo;
    JTable tablaregistro = new JTable(modelo);
    JScrollPane scroll = new JScrollPane(tablaregistro);

    Object [][] data;
    String [] col = {"Imagen", "Nombre", "Puntos", "Ataque"};

    JFileChooser fc = new JFileChooser();
    ImageIcon planta;
    String ruta;

    JMenuBar barra = new JMenuBar();
    JMenu reporte = new JMenu("Reportes");
    JMenuItem reporteuser = new JMenuItem("Reporte Personajes");

    JButton Nuevo = new JButton("Nuevo");
    JButton Modificar = new JButton("Modificar");
    JButton Eliminar = new JButton("Eliminar");
    JButton Finalizar = new JButton("Finalizar");
    JLabel Nombre = new JLabel(m.nombretipo);

    public VentanaTipos(){

        ven.setSize(600, 400);
        ven.setLocationRelativeTo(this);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ven.setLayout(null);
        ven.setVisible(true);

        ven.getContentPane().setBackground(Color.black);

        ven.add(scroll);
        ven.setJMenuBar(barra);
        barra.add(reporte);
        reporte.add(reporteuser);

        ven.add(Nuevo);
        ven.add(Modificar);
        ven.add(Eliminar);
        ven.add(Finalizar);
        ven.add(Nombre);

        modelo = new MyTableModel(data, col);
        tablaregistro.setModel(modelo);
        tablaregistro.setRowHeight(60);
        tablaregistro.setShowGrid(false);
        tablaregistro.setBackground(Color.GRAY);

        Nombre.setFont(new Font("Arial Rounded", Font.BOLD, 15));
        Nombre.setForeground(Color.white);

        scroll.setBounds(25 ,60, 550, 270);

        Nuevo.setBounds(25, 10, 100, 30);
        Modificar.setBounds(135, 10, 100, 30);
        Eliminar.setBounds(245, 10, 100, 30);
        Finalizar.setBounds(355, 10, 100, 30);
        Nombre.setBounds(465, 10, 200, 30);

        //////////////////////////////////////////////////// BOTONES

        ///////////////// ------------------------------------------------------AGREGAR

        Nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon imatemp = JalarImagen();
                String nombre = JOptionPane.showInputDialog("Ingrese Nuevo Nombre ");
                String pts = JOptionPane.showInputDialog("Ingrese la Cantidad de Puntos ");
                int puntos = Integer.parseInt(pts);
                String ataque;

                int seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione Tipo de Ataque",
                        "Ataque",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[] { "Directo", "Disparo" },
                        "Directo");

                if (seleccion == 0){
                    ataque = "Directo";
                }else
                {
                    ataque = "Disparo";
                }

                Object[] temp = {imatemp, nombre, pts, ataque };
                modelo.addRow(temp);
            }
        });

        ///////////////// ------------------------------------------------------ELIMINAR

        Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int temp = tablaregistro.getSelectedRow();
                modelo.removeRow(temp);
            }
        });

        ///////////////// ------------------------------------------------------MODIFICAR

        Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tempo = tablaregistro.getSelectedRow();
                modelo.removeRow(tempo);
                ImageIcon imatemp = JalarImagen();
                String tiempo = JOptionPane.showInputDialog("Ingrese Nuevo Nombre ");
                Object[] temp = {tiempo, imatemp};
                modelo.addRow(temp);
            }
        });

        ///////////////// ------------------------------------------------------FINALIZAR

        Finalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public ImageIcon JalarImagen(){
        fc.showSaveDialog(fc);
        int rest = fc.APPROVE_OPTION;
        if(rest==JFileChooser.APPROVE_OPTION)
        {String b=fc.getSelectedFile().toString();
            ruta = b;}
        planta = new javax.swing.ImageIcon(ruta);
        Image implanta = planta.getImage();
        ImageIcon plantaesc = new ImageIcon(implanta.getScaledInstance(40,40,Image.SCALE_SMOOTH));
        return plantaesc;
    }

}
