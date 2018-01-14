import java.util.*;
public class Company
{
   public static void main(String[] args)
   {
      Stack staff = new Stack();

      Scanner kybd = new Scanner(System.in);
      System.out.print("Hire(h), fire(f) or end(e)?");
      String action = kybd.next();
      while (!action.equalsIgnoreCase("e"))
      {
         if (action.equalsIgnoreCase("h"))
         {
            System.out.print("Enter number: ");
            int empNumber = kybd.nextInt();
            staff.push(empNumber);
            System.out.println(empNumber + " is hired");
         }
         else if (action.equalsIgnoreCase("f"))
         {
            if (staff.isEmpty())
            {
               System.out.println("No staff to fire");
            } 
            else
            {
               System.out.println(staff.pop() + 
                                  " is fired");
            }
         } 
         else
         {
            System.out.println("Invalid operation");
         }
         System.out.print("Hire(h), fire(f) or end(e)?");
         action = kybd.next();
      }
   }
}
