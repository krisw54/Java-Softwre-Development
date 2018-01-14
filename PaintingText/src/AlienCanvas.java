import java.awt.*;
import javax.swing.*;

public class AlienCanvas extends JComponent
{
    private Alien[] alien;

    public AlienCanvas(Alien[] alien)
    {
        super();
        this.alien = alien;
    }
    
    @Override
    public void paint(Graphics g)
    {
        Font f = new Font("Copperplate Gothic Light", Font.PLAIN, 12);
        g.setFont(f);
        for (Alien a : alien)
        {
            a.paint(g);
        }
    }
    
    public void randomColourChange()
    {
        for (Alien a : alien)
        {
            a.setBodyColour(Alien.getRandomColour());
        }
        repaint();
    }
    
    public void sameColourChange()
    {
        Color c = Alien.getRandomColour();
        for (Alien a : alien)
        {
            a.setBodyColour(c);
        }
        repaint();
    }
}