import java.util.*;
/**
 *
 * @author krisw
 */
public class Pontoon {
    
    public static void main(String[] args) {
        //deal initial hands
        int playerScore = 0;
        int computerScore = 0;
        
        System.out.print ("Player Card: ");
        playerScore = dealCard();
        System.out.print ("Computer Card: ");
        computerScore = dealCard();
        System.out.println("");
        System.out.print ("Player Card: ");
        playerScore = playerScore + dealCard();
        System.out.print ("Computer Card: ");
        computerScore = computerScore + dealCard();
        System.out.println("");
        
        //deal additional cards to player
        
        Scanner kybd = new Scanner(System.in);
        System.out.println("Do You Want More Cards? ");
        String more = kybd.nextLine();
        
        while (more.equalsIgnoreCase("yes"))
        {
            System.out.print ("Player Card: ");
            playerScore = playerScore + dealCard();
            System.out.println("Do You Want More Cards? ");
            more = kybd.nextLine();
        }
        
        //deal additional cards to computer
        while (computerScore < 15)
        {
            System.out.print ("Computer Card: ");
            computerScore = computerScore + dealCard();
            
        }
        
        //check for winner
        System.out.println("");
        checkWin(playerScore, computerScore);
    }
    
    public static int dealCard()
    {
        int value = (int) (Math.random() * 13) + 1;
        int score = 0;
        
        if (value  == 1)
        {
            System.out.println("ACE");
            score = 11;
        }
        else if (value == 11)
        {
            System.out.println("JACK");
            score = 10;
        }
        else if (value == 12)
        {
            System.out.println("QUEEN");
            score = 10;
        }
        else if (value == 13)
        {
            System.out.println("KING");
            score = 10;
        }
        else
        {
            System.out.println("Value: " + value);
            score = value;
        }
        return score;
    }
    
    public static void checkWin(int player, int computer)
    {
        if (player > 21)
        {
            System.out.println("Player Bust!");
        }
        else if (computer > 21) {
            System.out.println("Computer Bust!");
        }
        else if (player > computer)
        {
            System.out.println("Player Wins!");
        }
        else
        {
            System.out.println("Computer Wins!");
        }
    }
}
