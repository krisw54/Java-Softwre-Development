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
        for (Alien a : alien)
        {
            a.paint(g);
        }
    }
}