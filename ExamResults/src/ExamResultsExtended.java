
import java.util.*;

public class ExamResultsExtended
{

    public static void main(String[] args)
    {
        Result[] resultsArray = new Result[20];
        
        input(resultsArray);
        
        sortByMark(resultsArray);
        output(resultsArray);
        
        sortByName(resultsArray);
        output(resultsArray);
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

    public static void sortByMark(Result[] array)
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
            //this is for testing purposes only
            //output(arr); 
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

    public static void sortByName(Result[] array)
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
            //this is for testing purposes only
            //output(arr); 
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
