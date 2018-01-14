import java.util.Scanner;
/**
 *
 * @author krisw
 */
public class Cinema {
    
    public static void main(String[] args) {
        
        Queue q = new Queue();
        
        Scanner kybd = new Scanner(System.in);
        System.out.print("Join (j), leave (l) or end (e)? ");
        String action = kybd.nextLine();
        while (!action.equalsIgnoreCase("e"))
        {
            if (action.equalsIgnoreCase("j"))
            {
                System.out.print("Enter Name: ");
                String name = kybd.nextLine();
                System.out.print("Enter Age: ");
                int age = kybd.nextInt();
                kybd.nextLine();
                Person p = new Person();
                p.setName(name);
                p.setAge(age);
                q.add(p);
                System.out.println(name + " aged: " + age + " joined queue!");
            } 
            else if (action.equalsIgnoreCase("l"))
            {
                if (!q.isEmpty())
                {
                    Person p = q.remove();
                    if (p.getAge()> 14 )
                    {
                        System.out.println(p.getName() + " has left the queue and has entered the cinema");
                    }
                    else
                    {
                        System.out.println(p.getName() + " has left the queue, but is too young to enter the cinema");
                    }
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
