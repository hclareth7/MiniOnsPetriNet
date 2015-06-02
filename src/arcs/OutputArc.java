package arcs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import javax.swing.ImageIcon;
import places.Place;
import places.Token;
import transitions.Transition;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class OutputArc extends Arc {

    public OutputArc(long id, int multiplicidad, Place place, Transition transition) {
        super(id, multiplicidad, place, transition);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Stroke L = new BasicStroke(2);
        g2.setStroke(L);
        Line2D.Double linea = new Line2D.Double(getTransition().getX() + getTransition().getWidth(), getTransition().getY() + getTransition().getHeight() / 2, getPlace().getX() - 10, getPlace().getY() + getPlace().getHeight() / 2);
        g2.setColor(new Color(46, 204, 113));
        g2.draw(linea);
        g2.drawImage(new ImageIcon("src/images/flecha.png").getImage(), getPlace().getX() - 10, getPlace().getY() - 5 + getPlace().getHeight() / 2, this);
    }

    @Override
    public void run() {
        System.out.println("1Output");

        for (int i = 0; i < getMultiplicidad(); i++) {
            System.out.println("2Output");
            Token token = new Token(1, 0);
            getPlace().addToken(token);
            getPlace().setVisible(false);
            getPlace().setVisible(true);

        }
        //showTokensList();

    }
}
