/**
 *
 * @author chriswood
 */
import java.awt.*;

public class SpaceRocket extends Spaceship {
    
private Color rocketColour;
    
    public SpaceRocket()
    {
        this(0, 0, Color.YELLOW);
    }
    
    public SpaceRocket(int firstX, int firstY, Color rocketColour)
    {
        super(firstX, firstY);
        this.rocketColour = rocketColour;
    }
    
    public void setRocketColour(Color c)
    {
        rocketColour = c;
    }
    
    @Override
    public int getWidth()
    {
        return 90;
    }
    
    @Override
    public int getHeight()
    {
        return 30;
    }

    @Override
    public void paint(Graphics g)
    {
        int x = getX();
        int y = getY();
        
        int[] xs = {x+60, x+90, x+60};
        int[] ys = {y, y+15, y+30};
        
        //Draw Rocket Body
        g.setColor(rocketColour);
        g.fillRect(x, y, 60, 30);
        g.fillPolygon(xs, ys, 3);
        //Draw Windows
        g.setColor(Color.BLACK);
        g.fillOval(x+30, y+5, 20, 20);
        g.setColor(Color.BLUE);

        String name = getName();
        if (name != null && name.length() > 0)
        {
            int nameWidth = g.getFontMetrics().stringWidth(name);
            
            g.drawString(name, 
                         x+(getWidth()-nameWidth)/2, 
                         y+getHeight()/2+g.getFontMetrics().getMaxAscent());
        }

    }    
}
