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
    public int getWidth()
    {
        return 55;
    }

    @Override
    public int getHeight()
    {
        return 95;
    }
   
    @Override
    public void paint(Graphics g)
    {
        int x = getX();
        int y = getY();
        
        int[] xs = {x, x+28, x+56};
        int[] ys = {y+60, y, y+60};
        
        g.setColor(getBodyColour());
        //draw the body
        g.fillPolygon(xs, ys, 3);
        
        g.setColor(Color.BLACK);
        //draw the eyes
        g.fillOval(x+14, y+12, 12, 12);
        g.fillOval(x+31, y+12, 12, 12);
        //draw the nose
        g.fillOval(x+26, y+18, 5, 15);
        //draw the mouth
        g.fillOval(x+18, y+35, 20, 5);
        //draw the legs
        g.setColor(legColour);
        g.fillRect(x+16, y+60, 5, 17);
        g.fillRect(x+38, y+60, 5, 17);
        //draw the feet
        g.setColor(Color.BLACK);
        g.fillArc(x+8, y+75, 20, 20, 0, 180);
        g.fillArc(x+30, y+75, 20, 20, 0, 180);

        String name = getName();
        int nameLength = g.getFontMetrics().stringWidth(name);
        if (name != null && name.length() > 0)
        {
            int nameWidth = g.getFontMetrics().stringWidth(name);
            
            g.drawString(name, 
                         x+(getWidth()-nameWidth)/2, 
                         y+getHeight()/2+g.getFontMetrics().getMaxAscent());
        }
    }
    
    @Override
    public TriAlien clone()
    {
        TriAlien a = new TriAlien(this.getX(), this.getY(), this.legColour);
        
        a.setBodyColour(this.getBodyColour());
        a.setName(this.getName());
        
        return a;
    }
}
