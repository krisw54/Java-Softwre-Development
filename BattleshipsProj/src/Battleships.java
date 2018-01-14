import java.util.Scanner;
/**
 *
 * @author krisw
 */
public class Battleships {
    
    public static void main(String[] args) {
        
        int[] [] board = new int[12] [12];
        int[] [] guessBoard = new int[12] [12];
        boolean gameDone = false;
        int guess=0;
        Scanner myKeyboard = new Scanner(System.in);
        
        //Setup board
        for (int i = 0; i < board.length; i++)
        {
          for (int j = 0; j < board.length; j++)
          {
           board [i][j]=0;
          }
        }

        for (int i = 0; i < guessBoard.length; i++)
        {
          for (int j = 0; j < guessBoard.length; j++)
          {
           guessBoard [i][j]=4;
          }
        }
        
        //put ships in
        board[1][1] = 1;
        board [1][6] = 1;
        board [2][6] = 1;
        board [10][9] = 1;
        board [11][3] = 1;
        
        //Output board
        for (int i = 0; i < board.length; i++)
        {
            System.out.println((i+1) +"\t|\t|\t|\t|\t|\t|\t|\t|\t|\t|\t|\t|\t|");
        }
        System.out.println("\t    1       2       3       4       5       6       7       8       9       10      11      12");

     
        while (gameDone == false)
        {
            System.out.print("Enter Guess for X (1-12): ");
            int guessX = myKeyboard.nextInt();
            System.out.print("Enter Guess for Y (1-12: ");
            int guessY = myKeyboard.nextInt();
            
            if (board [guessY-1] [guessX-1] == 1)
            {
                System.out.println("HIT\n");
                guessBoard[guessY-1][guessX-1] = 3;
                printBoard(guessBoard);
                guess++;
                if (guess==5)
                {
                    gameDone = true;
                    System.out.println("GAME OVER - You Won!!");
                }                
            }
            else
            {
                System.out.println("MISS\n");
                guessBoard[guessY-1][guessX-1] = 0;
                printBoard(guessBoard);
            }
        }
    }
    
    public static void printBoard(int[][] array)
    {
     String output = "|";
        for (int i = 0; i < array.length; i++)
        {
            System.out.print((i+1) + "\t");
          for (int j = 0; j < array.length; j++)
          {
            if (array[i][j]==3)
            {
                output+= "   H" + "\t|"; 
            }
            else if (array[i][j]==0)
            {
                output+= "   M" + "\t|"; 
            }
            else
            {
                output+= " " + "\t|"; 
            }
          }
        System.out.println(output);
        output="|";
        }
        System.out.println("\t    1       2       3       4       5       6       7       8       9       10      11      12");
    }
    
}
