import java.awt.*;

public class Alien
{
    /*********************************************************
     * 
     * Class-level variables and methods
     * 
     *********************************************************/
    private static Color[] COLOUR_PALETTE = {Color.BLUE, Color.CYAN, 
                                             Color.GREEN, Color.MAGENTA, 
                                             Color.ORANGE, Color.PINK,
                                             Color.RED, Color.YELLOW};
    
    public static Color getRandomColour()
    {
        int index = (int)(Math.random() * COLOUR_PALETTE.length);
        return COLOUR_PALETTE[index];
    }
    
    /*********************************************************
     * 
     * Object-level variables and methods
     * 
     *********************************************************/
    private int x;
    private int y;
    private Color bodyColour;
    private String name;
    
    public Alien()
    {
        this(0, 0);
    }
    
    public Alien(int firstX, int firstY)
    {
        x = firstX;
        y = firstY;
        bodyColour = getRandomColour();
        name = "?";
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void setBodyColour(Color c)
    {
        bodyColour = c;
    }
    
    public Color getBodyColour()
    {
        return bodyColour;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getWidth()
    {
        return 50;
    }

    public int getHeight()
    {
        return 90;
    }
   
    public void paint(Graphics g)
    {
        int[] xs = {x, x+50, x+50, x+44, x+37, x+25, x+13, x+6, x};
        int[] ys = {y+60, y+60, y+90, y+60, y+90, y+60, y+90, y+60, y+90};
        
        g.setColor(bodyColour);
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
        
        if (name != null && name.length() > 0)
        {
            int nameWidth = g.getFontMetrics().stringWidth(name);
            
            g.drawString(name, 
                         x+(getWidth()-nameWidth)/2, 
                         y+getHeight()/2+g.getFontMetrics().getMaxAscent());
        }
    }
}
