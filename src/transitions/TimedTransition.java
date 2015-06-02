package transitions;

import arcs.Arc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class TimedTransition extends Transition {

    private double time;
    private double global_time = 0;
    private int type_probability_functions;

    public TimedTransition() {
        setIcon(new ImageIcon("src/images/timed.png"));
    }

    public TimedTransition(long id, String name) {
        super(id, name);
        setIcon(new ImageIcon("src/images/timed.png"));

    }

    public double getGlobal_time() {
        return global_time;
    }

    public void setGlobal_time(double global_time) {
        this.global_time = global_time;
    }

    @Override
    public void activate() {
        getTimer().start();
        time = 1 + (int) (Math.random() * ((4 - 1) + 1));
        System.out.println("Activate");
        //time = 3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.global_time++;
        this.time--;
//        System.out.println("N" + time);
        System.out.println("Time: " + time + ", Global: " + global_time);
        if (getTime() == 0.0) {

            System.out.println("List: " + getList_arc().size());

            for (int i = 0; i < getList_arc().size(); i++) {

                Arc arc = getList_arc().get(i);
                //arc.getPlace().setText("" + time);
                // if (arc.checkArc()) {
//                System.out.println("SS" + time);
                arc.run();
                arc.showTokensList();
                getParent().repaint();
                //
                // }
                //System.out.println("Aqui" + arc.getClass().getName());

            }

            activate();
        }

    }

    public int getType_probability_functions() {
        return type_probability_functions;
    }

    public void setType_probability_functions(int type_probability_functions) {
        this.type_probability_functions = type_probability_functions;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
