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
        Font f = new Font("Comic Sans MS", Font.PLAIN, 12);
        g.setFont(f);
        for (Spaceship a : spaceships)
        {
            a.paint(g);
        }
    }
    
    public void moveAllSpaceships()
    {
        double maxXX, maxYY;
        int maxX, maxY;
        for (Spaceship s : spaceships)
        {
            maxXX = (int)(Math.random()*getWidth());
            maxYY = (int)(Math.random()*getHeight());
            maxX = (int)maxXX - s.getWidth();
            maxY = (int)maxYY - s.getHeight();
            if (maxX < 0)
            {
                maxX =0;
            }
            if (maxY < 0)
            {
                maxY=0;
            }
            s.setPosition(maxX,maxY);
        }
        repaint();
    }
}
