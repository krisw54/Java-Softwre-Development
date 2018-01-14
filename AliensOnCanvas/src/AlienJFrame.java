import java.awt.*;
import javax.swing.*;

public class AlienJFrame extends JFrame
{
    private AlienCanvas canvas;

    public AlienJFrame(Alien[] alien)
    {
        super("Polymorphic Aliens in a JFrame");
        
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        canvas = new AlienCanvas(alien);
        
        getContentPane().setBackground(new Color(0xabcdef));
        getContentPane().add(canvas);
        
        setVisible(true);
    }
}
