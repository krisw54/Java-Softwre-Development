import java.awt.*;
import java.util.ArrayList;
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
            a.setBodyColour(Alien.getColour());
        }
        repaint();
    }

    public void sameColourChange()
    {
        Color c = Alien.getColour();
        for (Alien a : alien)
        {
            a.setBodyColour(c);
        }
        repaint();
    }

    public void alienColourChange(String name) throws Exception
    {
        alienColourChange(name, null);
    }

    public void alienColourChange(String name, Color bodyColour) throws Exception
    {
        ArrayList<Alien> aliensToChange = findAlien(name);

        if (aliensToChange.isEmpty())
        {
            //throw new Exception("There are no aliens with this name");
            String msg = "Please enter a valid alien name";
            String title = "Error - Missing Name";
            JOptionPane.showMessageDialog(this,
                                           msg,
                                           title,
                                           JOptionPane.ERROR_MESSAGE); 
        }

        Color c = bodyColour == null ? Alien.getColour() : bodyColour;
        for (Alien a : aliensToChange)
        {
            a.setBodyColour(c);
        }
        repaint();
    }

    private ArrayList<Alien> findAlien(String name)
    {
        ArrayList<Alien> list = new ArrayList<Alien>();
        for (Alien a : alien)
        {
            if (a.getName().equalsIgnoreCase(name))
            {
                list.add(a);
            }
        }
        return list;
    }
}