import java.awt.*;
import javax.swing.*;
/**
 *
 * @author chriswood
 */
public class CompassJFrame extends JFrame {
    private JButton[] myButton;

    public CompassJFrame()
    {
        super("Compass Program");
        
        setSize(400, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.BLUE);
        
        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.BLUE);
        getContentPane().add(new JButton("Move North"), BorderLayout.NORTH);
        getContentPane().add(new JButton("Move South"), BorderLayout.SOUTH);
        getContentPane().add(new JButton("Move East"), BorderLayout.EAST);
        getContentPane().add(new JButton("Move West"), BorderLayout.WEST);
        getContentPane().add(new JButton("Move Centre"), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
}
