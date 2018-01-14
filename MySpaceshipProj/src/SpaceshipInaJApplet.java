import java.awt.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class SpaceshipInaJApplet extends JApplet
{
    public void init()
    {
        getContentPane().setBackground(new Color(0xabcdef));
    }
    
    public void paint(Graphics g)
    {
    int[] x = {50, 10, 90};
    int[] y = {0, 30, 30};

        super.paint(g);
        g.setColor(new Color(74, 86, 34));
        g.fillOval(0, 10, 100, 40);
        g.fillPolygon(x, y, 3);
        g.fillRect(20, 40, 5, 15);
        g.fillRect(75, 40, 5, 15);
        g.setColor(Color.YELLOW);
        g.fillOval(20, 25, 10, 10);
        g.fillOval(70, 25, 10, 10);
        g.fillOval(40, 20, 20, 20);
    }
    
    
}
