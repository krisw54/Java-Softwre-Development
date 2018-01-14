
/**
 *
 * @author krisw
 */
public class CardGameEncoding {
    public static void main(String[] args) {
        
    int player1Card = (int) (Math.random() * 13) + 1;
    int player2Card = (int) (Math.random() * 13) + 1;
    int player1Points = 0;
    int player2Points = 0;
    
    if (player1Card > player2Card)
    {
        System.out.println("Player 1 Wins This Round " + player1Card);
        player1Points = player1Points + 1;
    }
    else if (player1Card == player2Card)
    {
        System.out.println("Draw – No one gets a point " + player1Card);
    }
    else
    {
        System.out.println("Player 2 Wins This Round " + player2Card);
        player2Points = player2Points + 1;
    }
    
    for (int i=2; i <= 7; i++)
    {
        player1Card = (int) (Math.random() * 13) + 1;
        player2Card = (int) (Math.random() * 13) + 1;  
        
        if (player1Card > player2Card)
        {
            System.out.println("Player 1 Wins This Round " + player1Card);
            player1Points = player1Points + 1;
        }
        else if (player1Card == player2Card)
        {
            System.out.println("Draw – No one gets a point " + player1Card);
        }
        else
        {
            System.out.println("Player 2 Wins This Round " + player2Card);
            player2Points = player2Points + 1;
        }
    }
    System.out.println("Player 1 Points :" + player1Points);
    System.out.println("Player 2 Points :" + player2Points);
        
    if (player1Points > player2Points)
    {
        System.out.println("Player 1 Wins This Game!");
    }
    else if (player1Points == player2Points)
    {
       System.out.println("Draw – No one wins the game!");
    }
    else
    {
       System.out.println("Player 2 Wins This Game!");
    }
    }
}
