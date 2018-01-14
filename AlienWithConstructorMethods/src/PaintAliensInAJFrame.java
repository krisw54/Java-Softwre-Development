import java.awt.*;
import javax.swing.*;

public class PaintAliensInAJFrame extends JFrame
{
    private Alien alien1, alien2, alien3, alien4, alien5;
    
    public PaintAliensInAJFrame()
    {
        super("Alien in a JFrame");
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0xabcdef));
        alien1 = new Alien();
        alien2 = new Alien(100, 100);
        alien3 = new Alien(160, 160);
        alien4 = new Alien(10, 10);
        alien5 = new Alien();
        alien1.setPosition(40, 40);
        alien4.setPosition(220, 100);
        alien5.setPosition(280, 40);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        alien1.paint(g);
        alien2.paint(g);
        alien3.paint(g);
        alien4.paint(g);
        alien5.paint(g);
    }
}
