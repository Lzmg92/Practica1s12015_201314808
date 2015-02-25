import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Leslie on 22/02/2015.
 */
public class VentanaDatos extends JFrame {

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

        final Main es = new Main();

        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(titulo.getText().equals("Plantas")){
                NodoDatos nuevito = new NodoDatos(txtnombre.getText(), titulo.getText(), Integer.parseInt(txtcantidad.getText()), masdatos, es.Pplantas);
                VentanaInicio n = new VentanaInicio();
                es.Jugadores.add(nuevito);
                }else {
                    NodoDatos nuevito = new NodoDatos(txtnombre.getText(), titulo.getText(), Integer.parseInt(txtcantidad.getText()), masdatos, es.Czombies);
                   VentanaInicio n = new VentanaInicio();
                    es.Jugadores.add(nuevito);
                }

                ven.setVisible(false);
                }
        });

        reporteuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           es.Jugadores.grafo();
            }
        });


    }


}
