
import java.util.Scanner;

/**
 *
 * @author krisw
 */
public class Alphabetical {
    
    public static void main(String[] args) {
        
        Scanner kybd = new Scanner(System.in);
        System.out.println("Please Enter Size of Array: ");
        int arrSize = kybd.nextInt();
        String arr[] = new String[arrSize];
        //Start
        input(arr, kybd);
        sort(arr);
        output(arr); 
    }
    
    public static void input(String[] arr, Scanner kybd)
    {
        kybd.nextLine(); //Flush Buffer
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Enter Next Item: ");
            arr[i] = kybd.nextLine();
        }
    }
    
    public static int findSmallest(String[] arr, int first)
    {
        int smallestPos = first; 
        for (int i = first+1; i < arr.length; i++)
        {
            if (arr[i].compareTo(arr[smallestPos]) < 0)
            {
                smallestPos = i;
            }
        }
        return smallestPos;
    }

    public static void sort(String[] arr)
    {
        for (int pass = 1; pass < arr.length; pass++)
        {
            int firstElement = pass - 1;
            int smallPos = findSmallest(arr, firstElement);
            if (smallPos != firstElement)
            {
                String temp = arr[smallPos];
                arr[smallPos] = arr[firstElement];
                arr[firstElement] = temp;
            }
        }
    }    
    
    public static void output(String[] arr)
    {   
        System.out.println("\n\nSorted Order (A-Z)");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        System.out.println();
    }    
}
