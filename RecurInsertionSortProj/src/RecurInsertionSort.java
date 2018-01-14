import java.util.Scanner;
/**
 *
 * @author krisw
 */
public class RecurInsertionSort {
    
    public static void main(String[] args) {
        
        int arr[] = new int[20];
        read(arr);
        output(arr);
        sort(arr,0);
        output(arr);
    }

    public static void read(int[] arr)
    {
        Scanner kybd = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print("Input Next Number: ");
            arr[i] = kybd.nextInt();
        }
    }
    
    public static void sort (int[] arr, int startAt)
    {
        if (startAt < arr.length)
        {
            for (int i = 1; i < arr.length; i++)
            {
                int value = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] < value)
                {
                    arr[j+1] = arr[j];
                    j = j - 1;
                }
                copy(arr, value, j);
            }
            sort (arr,(startAt+1));
        }
    }
    
    public static void copy (int[] arr, int value, int j)
    {
        arr[j+1] = value;
    }
    
    public static void output(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\n");
    } 
    
}
