package places;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class Place extends JButton {

    private long id;
    private ArrayList<Token> tokens_list = new ArrayList<>();
    private String name;

    public Place(long id, String name) {
        this.id = id;
        this.name = name;
        init();
    }

    private void init() {

        setSize(69, 69);
        setLocation(10, 10);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        setIcon(new ImageIcon("src/images/place.png"));
        setToolTipText(name);
        setLayout(new GridLayout(4, 4));

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - getWidth() / 2, getY() + e.getY() - getHeight() / 2);

                getParent().repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                getParent().repaint();
            }
        });

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Token> getTokens_list() {
        return tokens_list;
    }

    public void setTokens_list(ArrayList<Token> tokens_list) {
        this.tokens_list = tokens_list;
    }

    public int getListTokensSize() {
        return this.tokens_list.size();
    }

    public boolean addToken(Token t) {
        this.add(t);
        this.setVisible(false);
        this.setVisible(true);
        return this.tokens_list.add(t);

    }

    private void mostrar() {
        for (int i = 0; i < tokens_list.size(); i++) {
            Token t = tokens_list.get(i);
            t.setVisible(true);
            this.add(t);
        }
    }
}
