import java.awt.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class SpaceshipInAJApplet extends JApplet
{
    private Spaceship ship1;
    
       public void init()
    {
        getContentPane().setBackground(new Color(0xabcdef));
        ship1 = new Spaceship(65,100);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        ship1.paint(g);
    }
    
}
