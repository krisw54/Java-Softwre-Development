import java.awt.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class PaintShapesTask1 extends JApplet
{
 public void init()
    {
        getContentPane().setBackground(new Color(0xabcdef));
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        g.setColor(Color.YELLOW);

        g.fillOval(0, 0, 60, 60);
        g.fillOval(120, 0, 60, 60);
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, 60, 60);
        g.drawOval(120, 0, 60, 60);
        g.drawLine(60,30,120,30);
    }    
    
}
