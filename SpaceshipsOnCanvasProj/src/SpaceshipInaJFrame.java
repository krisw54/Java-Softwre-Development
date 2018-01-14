import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class SpaceshipInaJFrame extends JFrame
{
    private JButton moveShips;
    private SpaceshipCanvas canvas;
    
    public SpaceshipInaJFrame(Spaceship[] ships)
    {
        super("Spaceship Program");
        
        setSize(600, 600);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new SpaceshipCanvas(ships);
        getContentPane().setBackground(new Color(0xabcdef));

        getContentPane().add(canvas, BorderLayout.CENTER);
        
        createButton();
        
        setVisible(true);
    }
    
    private void createButton()
    {
        moveShips = new JButton("Move Ships");
        getContentPane().add(moveShips, BorderLayout.SOUTH);
    }
 
    
}
