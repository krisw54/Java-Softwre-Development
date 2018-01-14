
import java.util.Scanner;

/**
 *
 * @author krisw
 */
public class WhoseNumber {
    
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        Entry[] dir = new Entry[4];
        int position;
        
        inputDirectory(dir);
        
        System.out.print("Enter number to search for (enter 'end' to finish): ");
        String number = kybd.next();
        while (!number.equalsIgnoreCase("end"))
        {
            position = searchDirectory(dir, number);
            if (position == -1)
            {
                System.out.println("Numbers is not in directory");
            }
            else
            {
                System.out.println("Name for " + number + " is " + dir[position].getName());
            }
            System.out.print("Enter name to search for (enter 'end' to finish: ");        
            number = kybd.next();
        }
    }

    public static void inputDirectory(Entry[] dir)
    {
        Scanner kybd = new Scanner(System.in);
        for (int i = 0; i < dir.length; i++)
        {
            dir[i] = new Entry();
            System.out.print("Name for entry " + (i + 1) + ": ");
            dir[i].setName(kybd.next());
            System.out.print("Number for entry " + (i + 1) + ": ");
            dir[i].setNumber(kybd.next());
        }
    }

    public static void outputDirectory(Entry[] dir)
    {
        for (int i = 0; i < dir.length; i++)
        {
            System.out.print((i + 1) + ":\tName " + dir[i].getName());
            System.out.println("\t" + dir[i].getNumber());
        }
    }

    public static int searchDirectory(Entry[] arr, String item)
    {
        int low = 0;
        int high = arr.length - 1;
        int position = (low + high) / 2;
        while (item.compareTo(arr[position].getNumber()) != 0  && high >= low)
        {
            if (item.compareTo(arr[position].getNumber()) < 0)
            {
                high = position - 1;
            } else if (item.compareTo(arr[position].getNumber()) > 0)
            {
                low = position + 1;
            }
            position = (low + high) / 2;
        }
        if (item.compareTo(arr[position].getNumber()) != 0)
        {
            position = -1;
        }
        return position;
    }
    
}
