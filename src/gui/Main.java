package gui;


import places.Token;
import places.Place;
import transitions.TimedTransition;
import transitions.Transition;
import arcs.InhibitorArc;
import arcs.InputArc;
import arcs.Arc;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class Main {

    public static void main(String args[]) {

        Token t1 = new Token(1, 0);

        Token t2 = new Token(2, 0);
        Token t3 = new Token(3, 0);



        Place p1 = new Place(1, "Place 1");
        p1.addToken(t1);

        Place p2 = new Place(2, "Place 2");
        p2.addToken(t2);
        p2.addToken(t3);

        Transition timedTransition = new TimedTransition();
        Arc inhibitor_arc = new InhibitorArc(1, 1, p1, timedTransition);
        Arc input_arc2 = new InputArc(2, 2, p2, timedTransition);

        if (timedTransition.getState()) {
            inhibitor_arc.checkArc();
            input_arc2.checkArc();
            inhibitor_arc.run();
            input_arc2.run();

        }


    }
}
