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

    ListaPersonajes ListaLocalP = new ListaPersonajes();
    ListaPersonajes ListaLocalZ = new ListaPersonajes();

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

                NodoPersonaje tempo = new NodoPersonaje(ruta, nombre, puntos,ataque);

                if(m.titulo.equals("Datos Plantas")){
                    ListaLocalP.push(tempo);
                } else {
                    ListaLocalZ.push(tempo);
                }


            }
        });

        ///////////////// ------------------------------------------------------ELIMINAR

        Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int temp = tablaregistro.getSelectedRow();
                modelo.removeRow(temp);
                if(m.titulo.equals("Datos Plantas")){
                    ListaLocalP.eliminiar(temp);
                } else {
                    ListaLocalZ.eliminiar(temp);
                }
            }
        });

        ///////////////// ------------------------------------------------------MODIFICAR

        Modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tempo = tablaregistro.getSelectedRow();
                modelo.removeRow(tempo);

                ImageIcon imatemp = JalarImagen();
                String nombre = JOptionPane.showInputDialog("Ingrese Nuevo Nombre ");
                System.out.println(ruta);
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

                NodoPersonaje modificado = new NodoPersonaje(ruta, nombre, puntos, ataque);

                if(m.titulo.equals("Datos Plantas")){
                    ListaLocalP.eliminiar(tempo);
                    ListaLocalZ.push(modificado);
                } else {
                    ListaLocalP.eliminiar(tempo);
                    ListaLocalZ.push(modificado);
                }
            }
        });

        ///////////////// ------------------------------------------------------FINALIZAR

        Finalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SigVentana(m.titulo);
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

    public void LlenarPila(int cantidad, ListaPersonajes personajes){
            for (int i = 0; i < cantidad; i++){
                m.PilaPrun.push(personajes.obtener(random(0,personajes.size()-1)));
            }
    }

    public void LlenarCola(int cantidad, ListaPersonajes personajes){
        for (int i = 0; i < cantidad; i++){
            m.ColaZrun.push(personajes.obtener(random(0,personajes.size()-1)));
        }
    }

    int random(int min, int max)
    {
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }


    public void SigVentana(String tipo){
        if(tipo.equals("Datos Plantas") && m.esPrimera == true){
            m.Jugadores.obtener(0).setPersonajes(ListaLocalP);
            LlenarPila(m.Jugadores.obtener(0).cantidad, ListaLocalP);
            m.titulo = "Datos Zombies";
            m.esPrimera = false;
            m.nombretipo = m.Jugadores.obtener(1).obtenernombre()+" "+m.Jugadores.obtener(1).obtenertipo();
            VentanaTipos nueva = new VentanaTipos();

        } else if (tipo.equals("Datos Zombies") && m.esPrimera == true) {
            m.Jugadores.obtener(0).setPersonajes(ListaLocalZ);
            LlenarCola(m.Jugadores.obtener(0).cantidad, ListaLocalZ);
            m.titulo = "Datos Plantas";
            m.esPrimera = false;
            m.nombretipo = m.Jugadores.obtener(1).obtenernombre()+" "+m.Jugadores.obtener(1).obtenertipo();
            VentanaTipos nueva = new VentanaTipos();

        } else if (tipo.equals("Datos Plantas") && m.esPrimera == false) {
            m.Jugadores.obtener(1).setPersonajes(ListaLocalP);
            LlenarPila(m.Jugadores.obtener(1).cantidad, ListaLocalP);

            String menx = JOptionPane.showInputDialog("Ingrese la cantidad de nodos en X");
            String meny = JOptionPane.showInputDialog("Ingrese la cantidad de nodos en Y");

            int eny = Integer.parseInt(meny);
            int enx = Integer.parseInt(menx);

            m.coorfilas = Math.round(550/eny);
            m.coorcolum = Math.round(700/enx);

            Tablero nue = new Tablero();

        } else if (tipo.equals("Datos Zombies") && m.esPrimera == false){
            m.Jugadores.obtener(1).setPersonajes(ListaLocalZ);
            LlenarCola(m.Jugadores.obtener(1).cantidad, ListaLocalZ);

            String menx = JOptionPane.showInputDialog("Ingrese la cantidad de nodos en X");
            String meny = JOptionPane.showInputDialog("Ingrese la cantidad de nodos en Y");

            int eny = Integer.parseInt(meny);
            int enx = Integer.parseInt(menx);

            m.coorfilas = Math.round(550/eny);
            m.coorcolum = Math.round(700/enx);

            Tablero nue = new Tablero();
        }
    }

}
