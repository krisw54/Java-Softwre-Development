import java.awt.*;

public class GhostAlien extends Alien
{
    public GhostAlien()
    {
        this(0, 0);
    }
    
    public GhostAlien(int firstX, int firstY)
    {
        super(firstX, firstY);
    }

    public void paint(Graphics g)
    {
        int x = getX();
        int y = getY();
        
        int[] xs = {x, x+50, x+50, x+44, x+37, x+25, x+13, x+6, x};
        int[] ys = {y+60, y+60, y+90, y+60, y+90, y+60, y+90, y+60, y+90};
        
        g.setColor(getBodyColour());
        //draw the top of head
        g.fillOval(x, y, 50, 60);
        //draw the middle of head
        g.fillRect(x, y+30, 50, 30);
        //draw the bottom of head
        g.fillPolygon(xs, ys, 9);
        
        g.setColor(Color.BLACK);
        //draw the eyes
        g.fillOval(x+12, y+15, 10, 10);
        g.fillOval(x+28, y+15, 10, 10);
        //draw the mouth
        g.fillOval(x+15, y+30, 20, 10);
        
        String name = getName();
        int nameLength = g.getFontMetrics().stringWidth(name);
        if (name != null && name.length() > 0)
        {
            g.drawString(name, x+25-nameLength/2, y+43+g.getFontMetrics().getMaxAscent());
        }
    }

    public int getWidth()
    {
        return 50;
    }
    
    public int getHeight()
    {
        return 90;
    }
}
