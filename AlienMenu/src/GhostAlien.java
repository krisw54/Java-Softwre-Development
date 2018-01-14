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
        if (name != null && name.length() > 0)
        {
            int nameWidth = g.getFontMetrics().stringWidth(name);
            
            g.drawString(name, 
                         x+(getWidth()-nameWidth)/2, 
                         y+getHeight()/2+g.getFontMetrics().getMaxAscent());
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
    
    @Override
    public GhostAlien clone()
    {
        GhostAlien a = new GhostAlien(this.getX(), this.getY());
        
        a.setBodyColour(this.getBodyColour());
        a.setName(this.getName());
        
        return a;
    }
}
