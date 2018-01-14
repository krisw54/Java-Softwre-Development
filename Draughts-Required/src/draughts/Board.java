package draughts;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Board extends JPanel implements MouseListener
{
    private Square[][] squares;
    private ArrayList<DraughtsPiece> lightPieces;
    private ArrayList<DraughtsPiece> darkPieces;
    

    public Board(int numRows)
    {
        super(new GridLayout(numRows, numRows));
        squares = new Square[numRows][numRows];
        lightPieces = new ArrayList<DraughtsPiece>();
        darkPieces = new ArrayList<DraughtsPiece>();

        setupBoard(numRows);
        setupPieces(numRows);

        allocatePieces();
        
    }

    private void setupBoard(int numRows)
    {
        boolean lightSquare = true;

        for (int row = 0; row < numRows; row++)
        {
            for (int col = 0; col < numRows; col++)
            {
                if (lightSquare)
                {
                    squares[row][col] = new Square(Square.LIGHT_SQUARE_COLOUR, row + 1, col + 1);
                    
                }
                else
                {
                    squares[row][col] = new Square(Square.DARK_SQUARE_COLOUR, row + 1, col + 1);
                    squares[row][col].addMouseListener(this);
                }
                add(squares[row][col]);
                lightSquare = !lightSquare;
            }
            lightSquare = !lightSquare;
        }
    }

    private void setupPieces(int numRows)
    {
        int numPieces = ((numRows * numRows) - (2 * numRows)) / 4;
        for (int i = 0; i < numPieces; i++)
        {
            DraughtsPiece p = new DraughtsPiece(DraughtsPiece.LIGHT_PIECE_COLOUR);
            lightPieces.add(p);

            p = new DraughtsPiece(DraughtsPiece.DARK_PIECE_COLOUR);
            darkPieces.add(p);
        }
    }

    private void allocatePieces()
    {
        int row = squares.length - 1;
        int col = 0;

        for (DraughtsPiece p : lightPieces)
        {
            squares[row][col].setPiece(p);
            col += 2;
            if (col >= squares[0].length)
            {
                col = row % 2;
                row--;
            }
        }

        row = 0;
        col = squares[0].length - 1;
        for (DraughtsPiece p : darkPieces)
        {
            squares[row][col].setPiece(p);
            col -= 2;
            if (col < 0)
            {
                row++;
                col = squares[0].length - 1 - (row % 2);
            }
        }
    }
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered" + e.getSource());
       Square s = (Square)e.getSource();
       s.enter();
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited "+ e.getSource());
       Square s = (Square)e.getSource();
       s.exit();
    }
    public void mousePressed(MouseEvent e) {
      
    }

    public void mouseReleased(MouseEvent e) {
     
    }
    public void mouseClicked(MouseEvent e) {
      
    }
}
