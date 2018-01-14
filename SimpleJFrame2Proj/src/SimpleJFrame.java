/**
 *
 * @author krisw
 */
import java.awt.*;
import javax.swing.*;

public class SimpleJFrame extends JFrame
{
    public SimpleJFrame()
    {
        super("Chris's Picture drawn in JAVA!");
        setSize(600, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0xabcdef));
        setVisible(true);
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

