import java.util.Scanner;
/**
 *
 * @author krisw
 */
public class ChartPosition {
    
    public static void main(String[] args) {
        Scanner kybd = new Scanner(System.in);
        String [] charts = {"Clean Bandit", "James Arthur", "Little Mix", "Rae Sremmurd", "Weekend", "Neiked", "Bruno Mars", "Maroon", "Chainsmokers", "Hailee Steinfeld"};
        System.out.print("Enter a chart artist: ");
        String name = kybd.nextLine();
        int position;
        
        while (!name.equalsIgnoreCase("end"))
        {
            position = searchArtists(charts, name);
            if (position == -1)
            {
                System.out.println("Artists Not In List\n");
            }
            else
            {
                System.out.println("Artist: " + charts[position] + " is at chart position: " + (position+1)+"\n");
            }
            System.out.print("Enter name to search for (enter 'end' to finish: ");        
            name = kybd.nextLine();
        }
    } 
    
    public static int searchArtists(String[] arr, String item)
    {
        int index = 0; 
        while (index < arr.length && !arr[index].equalsIgnoreCase(item))
        {
            index++;
        }
        if (index == arr.length)
        {
            //item not found
            index = -1;
        }
        return index;
    }
        
}

