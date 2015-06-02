package arcs;


import javax.swing.JComponent;
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
public abstract class Arc extends JComponent {

    private long id;
    private int multiplicidad;
    private Place place;
    private Transition transition;
    

    public Arc() {
        multiplicidad = 1;
        init();
    }

    public Arc(long id, int multiplicidad, Place place, Transition transition) {
        this.id = id;
        this.multiplicidad = multiplicidad;
        this.place = place;
        this.transition = transition;
        init();
    }

    private void init() {
        this.setLocation(0, 0);
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMultiplicidad() {
        return multiplicidad;
    }

    public void setMultiplicidad(int multiplicidad) {
        this.multiplicidad = multiplicidad;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public boolean checkArc() {
        int num_token = getPlace().getListTokensSize();
        if (getMultiplicidad() <= num_token) {
            this.transition.setState(true);
            return true;
        } else {
            //System.out.println("No hay suficientes Tokens en el Place (" + getClass().getName() + " Arc) :" + getId());
            this.transition.setState(false);
            return false;
        }
    }

    public abstract void run();

    public void showTokensList() {
       // System.out.println("Tokens List:");
        for (int i = 0; i < getPlace().getTokens_list().size(); i++) {
            System.out.println("# Tokens: " + i+1);

        }
    }
}
