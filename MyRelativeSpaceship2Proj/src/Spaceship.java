import java.awt.*;
/**
 *
 * @author krisw
 */
public class Spaceship
{
    private int x;
    private int y;
    
    public Spaceship()
    {
        this(0, 0);
    }

    public Spaceship(int firstX, int firstY)
    {
        x = firstX;
        y = firstY;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void paint(Graphics g)
    {
        int[] xx = {x+50, x+10, x+90};
        int[] yy = {y, y+30, y+30};

        g.setColor(new Color(75, 83, 32));
        g.fillOval(x, y+10, 100, 40);
        g.fillPolygon(xx, yy, 3);
        g.fillRect(x+20, y+40, 5, 15);
        g.fillRect(x+75, y+40, 5, 15);
        g.setColor(Color.YELLOW);
        g.fillOval(x+20, y+25, 10, 10);
        g.fillOval(x+70, y+25, 10, 10);
        g.fillOval(x+40, y+20, 20, 20);
    }
}
