import java.awt.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class SpaceshipInAJApplet extends JApplet
{
    private int x = 65;
    private int y = 100;
    
       public void init()
    {
        getContentPane().setBackground(new Color(0xabcdef));
    }
    
    public void paint(Graphics g)
    {
    int[] xx = {x+50, x+10, x+90};
    int[] yy = {y, y+30, y+30};

        super.paint(g);
        g.setColor(new Color(75, 83, 32));
        g.fillOval(x, y+10, 100, 40);
        g.fillPolygon(xx, yy, 3);
        g.fillRect(x+20, y+40, 5, 15);
        g.fillRect(x+75, y+40, 5, 15);
        g.setColor(Color.YELLOW);
        g.fillOval(x+20, y+25, 10, 10);
        g.fillOval(x+70, y+25, 10, 10);
        g.fillOval(x+40, y+20, 20, 20);
    }
    
}
