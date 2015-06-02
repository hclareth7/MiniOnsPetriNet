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
public class InhibitorArc extends Arc {

    public InhibitorArc() {
    }

    public InhibitorArc(long id, int multiplicidad, Place place, Transition transition) {
        super(id, multiplicidad, place, transition);
        
    }

    @Override
    public boolean checkArc() {
        int num_token = getPlace().getListTokensSize();
        
        if (num_token == getMultiplicidad()) {
            getTransition().setState(false);
            //System.out.println("Bloqueo Inhibitor: (" + getClass().getName() + " Arc) :" + getId());
            return false;
        } else {
            getTransition().setState(true);
            return true;
        }
    }

    @Override
    public void run() {
        checkArc();
        //showTokensList();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g1 = (Graphics2D) g;
        Stroke L = new BasicStroke(2);
        g2.setStroke(L);
        Line2D.Double linea = new Line2D.Double(getPlace().getX(), getPlace().getY()+5 , getTransition().getX()+getTransition().getWidth()+10, getTransition().getY());
        g2.setColor(new Color(46, 204, 113));
        g2.draw(linea);
        g2.drawImage(new ImageIcon("src/images/inhibitor.png").getImage(),getTransition().getX()+getTransition().getWidth()+10/2, getTransition().getY()-10/2, this);
    }
}
