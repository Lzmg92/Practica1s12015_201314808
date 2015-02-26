import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Leslie on 25/02/2015.
 */
public class TableroDinamico extends JPanel implements Runnable, ActionListener {

    private Timer timer;
    Main m = new Main();

    public TableroDinamico(){

        setSize(550, 600);
        setFocusable(true);
        timer = new Timer(120, this);
        timer.start();

    }


    public void paint(Graphics g){
        update(g); }
    public void update(Graphics g){

        Color color = new Color(56,82,14);
// centro
        g.setColor(color);
        g.fillRect(0, 0, 700, 560);

        g.setColor(Color.BLACK);
        int limx = m.coorfilas;
        int limy = m.coorcolum;
        int i = 0;
        int j = 0;
        while (i<550){
            g.drawLine(0, i, 700, i);
            i = i+limx;
        }
        while (j<700){
            g.drawLine(j, 0, j, 560);
            j = j+limy;
        }
        repaint();
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
