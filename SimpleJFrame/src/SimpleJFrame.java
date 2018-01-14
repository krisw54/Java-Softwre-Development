import java.awt.*;
import javax.swing.*;

public class SimpleJFrame extends JFrame
{
    public SimpleJFrame()
    {
        super("Simple JFrame example");
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.RED);
        
        setVisible(true);
    }
}
