
import java.util.*;

public class AltonTowers
{

    public static void main(String[] args)
    {
        QueueWithArray q = new QueueWithArray();
        //QueueWithArrayList q = new QueueWithArrayList();

        Scanner kybd = new Scanner(System.in);
        System.out.print("Join (j), leave (l) or end (e)? ");
        String action = kybd.nextLine();
        while (!action.equalsIgnoreCase("e"))
        {
            if (action.equalsIgnoreCase("j"))
            {
                System.out.print("Enter name: ");
                String name = kybd.nextLine();
                q.add(name);
                System.out.println(name + " joined queue");
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
                System.out.println("Invalid operation");
            }
            System.out.print("Join (j), leave (l) or end (e)? ");
            action = kybd.nextLine();
        }
    }
}
