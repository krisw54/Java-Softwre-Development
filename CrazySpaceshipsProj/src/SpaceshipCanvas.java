/**
 *
 * @author chriswood
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpaceshipCanvas extends JComponent implements MouseMotionListener {
    
    private Spaceship[] spaceships;

    public SpaceshipCanvas(Spaceship[] spaceships)
    {
        super();
        this.spaceships = spaceships;
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g)
    {
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
    
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e)
    {
            moveAllSpaceships();
    }
}
