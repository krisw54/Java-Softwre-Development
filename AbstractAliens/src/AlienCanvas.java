import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class AlienCanvas extends JComponent
{
    private ArrayList<Alien> aliens;
    
    public AlienCanvas(ArrayList<Alien> aliens)
    {
        super();
        this.aliens = aliens;

        /**************************
         * Added for this example *
         **************************/
        setPreferredSize(determinePreferredSize());
    }
    
    @Override
    public void paint(Graphics g)
    {
        Font f = new Font("Copperplate Gothic Light", Font.PLAIN, 12);
        g.setFont(f);
        for (Alien a : aliens)
        {
            a.paint(g);
        }
    }
    
    public void randomColourChange()
    {
        for (Alien a : aliens)
        {
            a.setBodyColour(Alien.getRandomColour());
        }
        repaint();
    }
    
    public void sameColourChange()
    {
        Color c = Alien.getRandomColour();
        for (Alien a : aliens)
        {
            a.setBodyColour(c);
        }
        repaint();
    }
    
    public void alienColourChange(String name)
    {
        Color c = Alien.getRandomColour();
        for (Alien a : aliens)
        {
            if (a.getName().equalsIgnoreCase(name))
            {
                a.setBodyColour(c);
            }
        }
        repaint();
    }

    /**************************
     * Added for this example *
     **************************/
    private Dimension determinePreferredSize()
    {
        int maxHeight = 0;
        int maxWidth = 0;
        for (Alien a : aliens)
        {
            a.setPosition(maxWidth+5, 5);
            if (a.getHeight() > maxHeight)
            {
                maxHeight = a.getHeight();
            }
            maxWidth += a.getWidth() + 10;
        }
        return new Dimension(maxWidth, maxHeight+10);
    }
}