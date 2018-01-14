import java.awt.*;

public class Alien
{
    private int x;
    private int y;

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
        int[] xs = {x, x+50, x+50, x+44, x+37, x+25, x+13, x+6, x};
        int[] ys = {y+60, y+60, y+90, y+60, y+90, y+60, y+90, y+60, y+90};
        
        g.setColor(Color.YELLOW);
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
    }
}
