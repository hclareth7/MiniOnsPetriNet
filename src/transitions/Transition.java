package transitions;

import arcs.Arc;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public abstract class Transition extends JButton implements ActionListener {

    private long id;
    private String name;
    private boolean state;
    //
    private Timer timer = new Timer(1000,this);
    //
    private ArrayList<Arc> list_arc = new ArrayList<>();

    public Transition() {
        state = true;
        init();
    }

    public Transition(long id, String name, boolean state) {
        this.id = id;
        this.name = name;
        this.state = state;
        init();
    }

    public Transition(long id, String name) {
        this.id = id;
        this.name = name;
        init();
    }

    private void init() {
        setSize(14, 57);
        setLocation(100, 10);
        this.setBorder(null);
        this.setContentAreaFilled(false);
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

    public void addArc(Arc a) {
        list_arc.add(a);
    }

    public ArrayList<Arc> getList_arc() {
        return list_arc;
    }

    public void setList_arc(ArrayList<Arc> list_arc) {
        this.list_arc = list_arc;
    }

    public abstract void activate();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transition(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = true;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
