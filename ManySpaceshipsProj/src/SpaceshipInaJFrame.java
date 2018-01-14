import java.awt.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class SpaceshipInaJFrame extends JFrame
{
    private Spaceship[] ships;
    
    public SpaceshipInaJFrame(Spaceship[] ships)
    {
        super("Spaceship Program");
        this.ships = ships;
        
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(new Color(0xabcdef));
        
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        for (Spaceship a : ships)
        {
            a.paint(g);
        }
    }
    
}
