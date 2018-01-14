import java.util.*;

public class Append
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int size1 = kybd.nextInt();
        int[] array1 = new int[size1];
        
        System.out.print("Enter contents of first array: ");
        read(array1);

        System.out.print("Contents of first array: ");
        print(array1);
        
        System.out.print("Enter size of second array: ");
        int size2 = kybd.nextInt();
        int[] array2 = new int[size2];
        
        System.out.print("Enter contents of second array: ");
        read(array2);

        System.out.print("Contents of second array: ");
        print(array2);

        System.out.print("Contents of merged array: ");
        print(append(array1, array2));
    }

    public static void read(int[] array)
    {
        Scanner kybd = new Scanner(System.in);
        for (int i = 0; i < array.length; i++)
        {
            array[i] = kybd.nextInt();
        }
    }

    public static int[] append(int[] array1, int[] array2)
    {
        int[] appended = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++)
        {
            appended[i] = array1[i];
        }
        
        for (int i = 0; i < array2.length; i++)
        {
            appended[array1.length + i] = array2[i];
        }
        return appended;
 
    }
    
    public static void print(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
