import java.util.*;

public class SportsDay
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        
        System.out.print("Enter number of pupils: ");
        int pupils = kybd.nextInt();
        String dummy = kybd.nextLine();
                
        String[] names = new String[pupils];
              
        System.out.println("Enter names of pupils: ");
        for (int i = 0; i < names.length; i++)
        {
            names[i] = kybd.nextLine();
        }
        
        System.out.println("\nPupils in sack race: ");
        for (int i = 0; i < names.length; i++)
        {
            if (names[i].charAt(0) == 'a')
            {
                System.out.println(names[i]);
            }    
        }
        
        System.out.println("\nPupils in egg and spoon: ");
        for (int i = 0; i < names.length; i = i + 2)
        {
                System.out.println(names[i]);            
        }
        
        System.out.println("\nPupils in three legged race: ");
        for (int i = 0; i < names.length / 2; i++)
        {
                System.out.println(names[i]);            
        }             

        System.out.println("\nPupils in obstacle race: ");
        for (int i = names.length / 2; i < names.length; i++)
        {
                System.out.println(names[i]);            
        } 
    }
}
