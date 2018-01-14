/**
 *
 * @author chriswood
 */
import java.awt.*;
import javax.swing.*;

public class SpaceshipCanvas extends JComponent {
    
    private Spaceship[] spaceships;

    public SpaceshipCanvas(Spaceship[] spaceships)
    {
        super();
        this.spaceships = spaceships;
    }
    
    @Override
    public void paint(Graphics g)
    {
        for (Spaceship a : spaceships)
        {
            a.paint(g);
        }
    }
    
}
