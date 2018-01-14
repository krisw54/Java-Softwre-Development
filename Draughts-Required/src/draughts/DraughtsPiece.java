package draughts;
import java.awt.*;
import javax.swing.*;

public class DraughtsPiece extends JComponent
{
    public static final Color LIGHT_PIECE_COLOUR = new Color(0xccccff);
    public static final Color DARK_PIECE_COLOUR = new Color(0x3333ff);

    private Color colour;
    private Square square;
    
    public DraughtsPiece(Color c)
    {
        super();
        colour = c;
    }
    
    public void setSquare(Square s)
    {
        square = s;
    }
    
    public Square getSquare()
    {
        return square;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(colour);
        g.fillOval(5, 5, getWidth()-10, getHeight()-10);
    }
}
