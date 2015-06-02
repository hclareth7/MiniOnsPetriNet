package arcs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import javax.swing.ImageIcon;
import places.Place;
import transitions.Transition;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class InputArc extends Arc {

    public InputArc() {
        //setPlace(new Place(1, ""));
    }

    public InputArc(long id, int multiplicidad, Place place, Transition transition) {
        super(id, multiplicidad, place, transition);
    }

    @Override
    public void run() {
        int num_token = getPlace().getListTokensSize();
        if (checkArc()) {
//            if (num_token != 0) {

            for (int i = 0; i < getMultiplicidad(); i++) {
                getPlace().getTokens_list().remove(num_token - 1).setVisible(false);
                getPlace().setVisible(false);
                getPlace().setVisible(true);
                //num_token = getPlace().getListTokensSize();
                //System.out.println("Name Tran: " + getTransition().getName());

            }
            //showTokensList();
//            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g1 = (Graphics2D) g;
        Stroke L = new BasicStroke(2);
        g2.setStroke(L);
        Line2D.Double linea = new Line2D.Double(getPlace().getX() + getPlace().getWidth(), getPlace().getY() + getPlace().getHeight() / 2, getTransition().getX() - 10, getTransition().getY() + getTransition().getHeight() / 2);
        g2.setColor(new Color(46, 204, 113));
        g2.draw(linea);
        g2.drawString("a", (int) (linea.x1 - linea.x2) / 2, (int) (linea.y1 - linea.y2));
        g2.drawImage(new ImageIcon("src/images/flecha.png").getImage(), getTransition().getX() - 10, getTransition().getY() - 5 + getTransition().getHeight() / 2, this);
    }
}
