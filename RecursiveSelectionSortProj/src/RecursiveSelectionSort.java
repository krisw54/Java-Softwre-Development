import java.util.Scanner;
/**
 *
 * @author krisw
 */
public class RecursiveSelectionSort {

    public static void main(String[] args)
    {
        //The sort() method in the ExamResults class 
        int[] arr = new int[20];
        input(arr);
        sort(arr, 0);
        output(arr);
        
        //The sortByMark() method in the ExamResultsExtended class
        Result[] resultsArray = new Result[20];
        input(resultsArray);
        sortByMark(resultsArray, 0);
        output(resultsArray);
        
        //The sortByName() method in the ExamResultsExtended class
        sortByName(resultsArray, 0);
        output(resultsArray);
        
    }

    public static void input(int[] arr)
    {
        Scanner kybd = new Scanner(System.in);
        System.out.println("Enter exam results: ");
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = kybd.nextInt();
        }
    }

    public static void input(Result[] array)
    {
        Scanner kybd = new Scanner(System.in);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Candidate " + (i+1));
            System.out.print("\tName: ");
            String name = kybd.nextLine();
            System.out.print("\tMark: ");
            int mark = kybd.nextInt();
            kybd.nextLine();            //to flush the kybd buffer
            
            array[i] = new Result(name, mark);
        }
    }    

    public static void sort(int[] arr, int startAt)
    {
        if (startAt < arr.length -1)
        {
        for (int pass = 1; pass < arr.length; pass++)
        {
            int firstElement = pass - 1;
            int smallPos = findSmallest(arr, firstElement);
            if (smallPos != firstElement)
            {
                int temp = arr[smallPos];
                arr[smallPos] = arr[firstElement];
                arr[firstElement] = temp;
            }
            //this is for testing purposes only
            //output(arr); 
        }
        sort(arr, (startAt+1));
        }
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

    public static void output(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void sortByMark(Result[] array, int startAt)
    {
        if (startAt < array.length -1)
        {
            for (int pass = 1; pass < array.length; pass++)
            {
            int firstElement = pass - 1;
            int smallPos = findSmallestMark(array, firstElement);
                if (smallPos != firstElement)
                {
                    Result temp = array[smallPos];
                    array[smallPos] = array[firstElement];
                    array[firstElement] = temp;
                }
            }
            sortByMark(array, (startAt+1));
        }
    }

    public static int findSmallestMark(Result[] array, int first)
    {
        int smallestPos = first;
        for (int i = first+1; i < array.length; i++)
        {
            if (array[i].getMark() < array[smallestPos].getMark())
            {
                smallestPos = i;
            }
        }
        return smallestPos;
    }    

    public static void sortByName(Result[] array, int startAt)
    {
        if (startAt < array.length -1)
        {
            for (int pass = 1; pass < array.length; pass++)
            {
                int firstElement = pass - 1;
                int smallPos = findSmallestName(array, firstElement);
                if (smallPos != firstElement)
                {
                    Result temp = array[smallPos];
                    array[smallPos] = array[firstElement];
                    array[firstElement] = temp;
                }
            }
            sortByName(array, (startAt+1));
        }
    }

    public static int findSmallestName(Result[] array, int first)
    {
        int smallestPos = first;
        for (int i = first+1; i < array.length; i++)
        {
            if (array[i].getName().compareToIgnoreCase(array[smallestPos].getName()) < 0)
            {
                smallestPos = i;
            }
        }
        return smallestPos;
    }

    public static void output(Result[] array)
    {
        System.out.println("\nExam results");
        System.out.println("============");
        
        for (int i = 0; i < array.length; i++)
        {
            System.out.printf("\t%-20s\t%d\n", array[i].getName(), array[i].getMark());
        }
    }    
    
}
