import java.util.*;
/**
 *
 * @author krisw
 */
public class Initials {
    
    public static void main(String[] args) {
        
    Scanner myKeyboard = new Scanner(System.in);
    System.out.print("Enter your full name: ");
    
    String name = myKeyboard.nextLine();
    String one, two, three;
    
    one = String.valueOf(name.charAt(0));
    two =  String.valueOf(name.charAt(name.indexOf(' ')+1));
    three = String.valueOf(name.charAt(name.lastIndexOf(' ')+1));
    
    System.out.println("Your Initals are: " + one + "." + two + "." + three);
        
    }
    
}
