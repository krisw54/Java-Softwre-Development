import java.awt.*;

public abstract class Alien
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
    
    public abstract void paint(Graphics g);

    public abstract int getWidth();
    
    public abstract int getHeight();
}
