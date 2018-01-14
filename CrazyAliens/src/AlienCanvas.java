import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlienCanvas extends JComponent
                         implements MouseMotionListener
{
    private Alien[] alien;
    private int count;

    public AlienCanvas(Alien[] alien)
    {
        super();
        this.alien = alien;
        count = 0;
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g)
    {
        for (Alien a : alien)
        {
            a.paint(g);
        }
    }
    
    public void changeAllColours()
    {
        for (Alien a : alien)
        {
            a.setBodyColour(Alien.getRandomColour());
        }
        repaint();
    }
    
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e)
    {
        count++;
        if (count == 10)
        {
            changeAllColours();
            count = 0;
        }
    }
}