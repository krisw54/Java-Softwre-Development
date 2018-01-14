package draughts;
import java.awt.*;
import javax.swing.*;

public class DraughtsJFrame extends JFrame
{
    Board board;
    
    public DraughtsJFrame(int numRows) throws Exception
    {
        super("Chris's draughts board");
        setSize(600, 626);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if (numRows > 0)
        {
            setupGUI(numRows);
        }
        else
        {
            throw new Exception("The number of rows cannot be negative");
        }
        
        setVisible(true);
    }
    
    private void setupGUI(int numRows)
    {
        board = new Board(numRows%2==0? numRows : numRows + 1);
        
        getContentPane().add(board, BorderLayout.CENTER);
    }
}
