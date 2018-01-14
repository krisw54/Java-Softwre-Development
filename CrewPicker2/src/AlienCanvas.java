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
    
    public void setAlienList(ArrayList<Alien> aliens)
    {
        this.aliens = aliens;
        setPreferredSize(determinePreferredSize());
    }
    
    public Alien getAlien(String name)
    {
        Alien a = null;
        int i=0;
        
        while (a == null && i<aliens.size())
        {
            if (aliens.get(i).getName().equalsIgnoreCase(name))
            {
                a = aliens.get(i);
            }
            i++;
        }
        return a;
    }
    
    public boolean addAlien(Alien a)
    {
        boolean alienAdded = false;
        
        if (!aliens.contains(a) && getAlien(a.getName())==null)
        {
            alienAdded = aliens.add(a);
        }
        setPreferredSize(determinePreferredSize());
        
        return alienAdded;
    }
}