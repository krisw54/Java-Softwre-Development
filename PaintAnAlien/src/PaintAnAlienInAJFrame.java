import java.awt.*;
import javax.swing.*;

public class PaintAnAlienInAJFrame extends JFrame
{
    public PaintAnAlienInAJFrame()
    {
        super("Alien in a JFrame");
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0xabcdef));
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        int[] xs = {0, 50, 50, 44, 37, 25, 13, 06, 00};
        int[] ys = {60, 60, 90, 60, 90, 60, 90, 60, 90};
        
        g.setColor(Color.YELLOW);
        //draw the top of head
        g.fillOval(0, 0, 50, 60);
        //draw the middle of head
        g.fillRect(0, 30, 50, 30);
        //draw the bottom of head
        g.fillPolygon(xs, ys, 9);
        
        g.setColor(Color.BLACK);
        //draw the eyes
        g.fillOval(12, 15, 10, 10);
        g.fillOval(28, 15, 10, 10);
        //draw the mouth
        g.fillOval(15, 30, 20, 10);
    }
}
