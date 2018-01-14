import java.awt.*;
import javax.swing.*;

public class AlienCanvas extends JComponent
{
    private Alien[] alien;
    private JTextArea log;

    public AlienCanvas(Alien[] alien, JTextArea log)
    {
        super();
        this.alien = alien;
        this.log = log;
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
        log.append("\n  All random");
        repaint();
    }
    
    public void sameColourChange()
    {
        Color c = Alien.getRandomColour();
        for (Alien a : alien)
        {
            a.setBodyColour(c);
        }
        log.append("\n  All the same");
        repaint();
    }
    
    public void alienColourChange(String name)
    {
        Color c = Alien.getRandomColour();
        for (Alien a : alien)
        {
            if (a.getName().equalsIgnoreCase(name))
            {
                a.setBodyColour(c);
                log.append("\n  Change only " + a.getName());
            }
        }
        repaint();
    }
}