import java.util.*;

/**
 *
 * @author krisw
 */
public class Hangman {
  
    public static void main(String[] args) {
    String letGuess;
    String display = "";
    int pos;
    boolean wordCom = false;
    
    Scanner myKeyboard = new Scanner(System.in);
    System.out.print("Enter your word for the hangman game!: ");
    
    String theWord = myKeyboard.nextLine();
    int wordLength = theWord.length();
    System.out.println("");
    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //Clear the word from the screen for 2nd player
    
    for (int i=0; i < wordLength; i++)
    {
        System.out.print("-");
        display = display + ("-");
    }
    System.out.println("");
    
    while (wordCom == false)
    {
        letGuess = myKeyboard.nextLine();
        pos = theWord.indexOf(letGuess);
         if (pos == -1)
         {
             System.out.println("Letter Not There!");
             System.out.println(display);
         }
         else
         {
            while (pos != -1)
            {
               display = display.substring(0, pos) + letGuess + display.substring (pos+1); //replace a dash with letGuess
               pos = theWord.indexOf(letGuess, pos+1);
               wordLength--;
            }
             System.out.println(display);
            if (wordLength == 0)
            wordCom = true;
         }
      }
   }
}
