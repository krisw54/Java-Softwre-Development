package draughts;
import java.awt.*;
import javax.swing.*;

/**
* Describes a Square, storing colours, place of square.
* @author GDM
* @see Board
* @since 16-Mar-20017
*/
public class Square extends JPanel
{
    /**
    * Stores LIGHT_SQUARE_COLOUR = 0xdfdfdf
    * @since 16-Mar-20017
    */
    public static final Color LIGHT_SQUARE_COLOUR = new Color(0xdfdfdf);
    /**
    * Stores DARK_SQUARE_COLOUR = 0x333333
    * @since 16-Mar-20017
    */
    public static final Color DARK_SQUARE_COLOUR = new Color(0x333333);
    /**
    * Stores SELECTED_DARK_SQUARE_COLOUR= Yellow
    * @since 16-Mar-20017
    */
    public static final Color SELECTED_DARK_SQUARE_COLOUR = Color.YELLOW;
    
    private Color background;
    private int row, column;
    private Color selectedBackground;
    private DraughtsPiece piece;
    private boolean selected = false;
    
    /**
    * @param c color of the pen
    * @param row row number
    * @param col column number
    */
    public Square(Color c, int row, int col)
    {
        super(new BorderLayout());
        background = c;
        this.row = row;
        this.column = col;
        setBackground(background);
        if (background == DARK_SQUARE_COLOUR)
        {
            selectedBackground = SELECTED_DARK_SQUARE_COLOUR;
        }
        piece = null;
    }
     
    /**
     * Returns row number as an int
     * @return {@code row} 
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * Returns column number as an int
     * @return {@code column} 
     */
    public int getColumn()
    {
        return column;
    }
    
    /**
     * Sets the draughts piece
     * @param piece DraughtsPiece
     * 
     */
    public void setPiece(DraughtsPiece piece)
    {
        if (piece == null && this.piece != null)
        {
            remove(this.piece);
            this.piece.setSquare(null);
            this.piece = null;
        }
        else if (piece != null && this.piece == null)
        {
            this.piece = piece;
            piece.setSquare(this);
            add(piece);
        }
    }
    
    /**
     * Returns draughtsPiece
     * @return {@code piece} 
     */
    public DraughtsPiece getPiece()
    {
        return piece;
    }
    /**
     * Sets background color on enter
     */
    protected void enter()
    {
        setBackground(selectedBackground);
    }
     /**
     * Sets background color on exit
     */
    protected void exit()
    {
        setBackground(background);
    }
    /**
     * Sets selected draughts piece
     */    
    protected void setSelected(boolean b)
    {
        selected = b;
        setBackground(b == false ? background : selectedBackground);
    }
    /**
     * Returns selected draughts piece
     * @return {@code selected} 
     */
    protected boolean  isSelected()
    {
        return selected;
    }
}
