import java.awt.*;

public class TriAlien extends Alien
{
    private Color legColour;
    
    public TriAlien()
    {
        this(0, 0, Color.BLACK);
    }
    
    public TriAlien(int firstX, int firstY, Color legColour)
    {
        super(firstX, firstY);
        this.legColour = legColour;
    }
    
    public void setLegColour(Color c)
    {
        legColour = c;
    }

    @Override
    public void paint(Graphics g)
    {
        int x = getX();
        int y = getY();
        
        int[] xs = {x, x+25, x+50};
        int[] ys = {y+60, y, y+60};
        
        g.setColor(getBodyColour());
        //draw the body
        g.fillPolygon(xs, ys, 3);
        
        g.setColor(Color.BLACK);
        //draw the eyes
        g.fillOval(x+12, y+15, 10, 10);
        g.fillOval(x+28, y+15, 10, 10);
        //draw the nose
        g.fillOval(x+22, y+18, 5, 15);
        //draw the mouth
        g.fillOval(x+15, y+35, 20, 5);
        //draw the legs
        g.setColor(legColour);
        g.fillRect(x+13, y+60, 5, 12);
        g.fillRect(x+33, y+60, 5, 12);
        //draw the feet
        g.setColor(Color.BLACK);
        g.fillArc(x+5, y+70, 20, 20, 0, 180);
        g.fillArc(x+25, y+70, 20, 20, 0, 180);

        String name = getName();
        int nameLength = g.getFontMetrics().stringWidth(name);
        if (name != null && name.length() > 0)
        {
            g.drawString(name, x+25-nameLength/2, y+42+g.getFontMetrics().getMaxAscent());
        }
    }

    @Override
    public int getWidth()
    {
        return 50;
    }
    
    @Override
    public int getHeight()
    {
        return 90;
    }
}
