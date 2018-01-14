import java.util.*;
/**
 *
 * @author chriswood
 */
public class InfiniteInitials {
    
    public static void main(String[] args) {
        
    Scanner myKeyboard = new Scanner(System.in);
    System.out.print("Enter your full name: ");
    
    String name = myKeyboard.nextLine();
    name = name.toUpperCase();
    name = name.trim();
    
    String ini = "";
    int nameL = name.length();
    
    ini = String.valueOf(name.charAt(0));
    
    for (int i=0; i < nameL; i++)
    {     
        if(name.charAt(i)==' ')
        {
            if (name.charAt(i+1)== ' ')
            {
                //DO Nothing
            }
            else
            {
                ini = ini + "." + name.charAt(i+1);
            }
        }
        if(name.charAt(i)=='-')
        {
            ini = ini + name.charAt(i);
            ini = ini + name.charAt(i+1);
        }        
    }

    System.out.println(ini + ".");

    }
    
}
