import java.awt.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class SimpleJApplet extends JApplet
{
 public void init()
    {
        getContentPane().setBackground(Color.GREEN);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        g.setColor(Color.RED);

        g.fillRect(0, 0, 60, 60);
        g.fillRect(120, 0, 60, 60);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 60, 60);
        g.drawRect(120, 0, 60, 60);
        g.setColor(Color.BLACK);
        g.drawLine(60,30,120,30);
    }    
    
}
