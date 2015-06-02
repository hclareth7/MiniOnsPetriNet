package places;


import java.awt.Graphics;
import javax.swing.ImageIcon;
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
public class Token extends JLabel {

    private long id;
    private int state;

    public Token(long id, int state) {
        this.id = id;
        this.state = state;
        init();
    }

    public Token() {
        init();
    }

    private void init() {
        
        setIcon(new ImageIcon("src/images/inhibitor.png"));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
