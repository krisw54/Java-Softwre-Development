import java.util.Scanner;
/**
 *
 * @author krisw
 */
public class TaxiRank {
    
    public static void main(String[] args) {
        
        Rank q = new Rank();
        
        Scanner kybd = new Scanner(System.in);
        System.out.print("Join (j), leave (l) or end (e)? ");
        String action = kybd.nextLine();
        while (!action.equalsIgnoreCase("e"))
        {
            if (action.equalsIgnoreCase("j"))
            {
                System.out.print("Enter taxi’s registration number: ");
                String taxiReg = kybd.nextLine();
                q.add(taxiReg);
                System.out.println(taxiReg + " joined queue");
            } 
            else if (action.equalsIgnoreCase("l"))
            {
                if (!q.isEmpty())
                {
                    System.out.println(q.remove() + " left queue");
                } 
                else
                {
                    System.out.println("Queue empty");
                }
            } 
            else
            {
                System.out.println("Invalid");
            }
            System.out.print("Join (j), leave (l) or end (e)? ");
            action = kybd.nextLine();
        }
    }
    
}
