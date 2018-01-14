import java.awt.*;
import javax.swing.*;

public class PaintAliensInAJFrame extends JFrame
{
    private Alien[] alien;
    
    public PaintAliensInAJFrame(Alien[] alien)
    {
        super("Polymorphic Aliens in a JFrame");
        this.alien = alien;
        
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(new Color(0xabcdef));
        
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        for (Alien a : alien)
        {
            a.paint(g);
        }
    }
}
