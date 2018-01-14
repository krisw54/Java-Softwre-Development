
import java.util.Scanner;

public class LectureDemo
{

    public static void main(String[] args)
    {
        int[] examResults = new int[10];

        input(examResults);
        int swaps = sort(examResults);
        output(examResults);
        System.out.println("\n" + swaps);
    }

    public static void input(int[] a)
    {
        Scanner k = new Scanner(System.in);
        for (int i = 0; i < a.length; i++)
        {
            System.out.print("Please enter an exam result");
            a[i] = k.nextInt();
        }
    }

    public static void output(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static int sort(int[] arr)
    {
        int countSwaps = 0;
        for (int pass = 1; pass < arr.length; pass++)
        {
            int firstElement = pass - 1;
            int smallPos = findSmallest(arr, firstElement);
            if (smallPos != firstElement)
            {
                countSwaps++;
                swap(arr, smallPos, firstElement);
            }
            output(arr); //this is for testing purposes only
        }
        return countSwaps;
    }

    public static int findSmallest(int[] array, int first)
    {
        int smallestPos = first;
        for (int i = first+1; i < array.length; i++)
        {
            if (array[i] < array[smallestPos])
            {
                smallestPos = i;
            }
        }
        return smallestPos;
    }

    public static void swap(int[] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
