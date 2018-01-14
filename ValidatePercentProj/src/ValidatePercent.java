import java.util.*;

public class ValidatePercent {
    
    public static void main(String[] args) {
        
        Scanner myKeyboard = new Scanner(System.in);
        System.out.print("Enter percentage to validate: ");
        int percentage=0;
       
        do
        {
            if (percentage < 0 || percentage > 100)
            {
             System.out.println("Sorry! You entered an incorrect number it should be between 0-100");
            }
            System.out.print("Enter percentage to validate: ");
            percentage = myKeyboard.nextInt();
        } while (percentage < 0 || percentage > 100);
        
        System.out.println("The validated percentage is: " + percentage + "%");
       
        
    }
}
