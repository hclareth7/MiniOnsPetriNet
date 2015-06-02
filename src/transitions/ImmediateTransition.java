package transitions;

import arcs.Arc;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class ImmediateTransition extends Transition {

    private double probability;
    double ran_pribability;

    public ImmediateTransition(double probability) {
        setIcon(new ImageIcon("src/images/immediate.png"));
        this.probability = probability;
    }

    public ImmediateTransition(double probability, long id, String name) {
        super(id, name);
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public void activate() {
        getTimer().start();
        ran_pribability = Math.random();
//        time = 0 + (int) (Math.random() * ((10 - 0) + 1));
        //System.out.println("time probability: " + ran_pribability);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (ran_pribability <= this.probability) {
            for (int i = 0; i < getList_arc().size(); i++) {
                Arc arc = getList_arc().get(i);
               
                    //System.out.println("Si" + arc.getTransition().getName());
                    arc.run();
             
                //activate();
            }
        } else {
            activate();

        }
    }
}
