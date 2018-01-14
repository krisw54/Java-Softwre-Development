import java.awt.*;
/**
 *
 * @author krisw
 */
public class Spaceship
{
    private int x;
    private int y;
    private Color bodyColour;
    
    private static Color[] COLOUR_PALETTE = {Color.BLUE, Color.CYAN, 
                                             Color.GREEN, Color.MAGENTA, 
                                             Color.ORANGE, Color.PINK,
                                             Color.RED};
    
    public static Color getRandomColour()
    {
        int index = (int)(Math.random() * COLOUR_PALETTE.length);
        return COLOUR_PALETTE[index];
    }
    
    public Spaceship()
    {
        this(0, 0);
    }

    public Spaceship(int firstX, int firstY)
    {
        x = firstX;
        y = firstY;
        bodyColour = getRandomColour();
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getWidth()
    {
        return 100;
    }
    
    public int getHeight()
    {
        return 90;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setBodyColour(Color c)
    {
        bodyColour = c;
    }
    
    public Color getBodyColour()
    {
        return bodyColour;
    }
    
    public void paint(Graphics g)
    {
        int[] xx = {x+50, x+10, x+90};
        int[] yy = {y, y+30, y+30};

        g.setColor(bodyColour);
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
