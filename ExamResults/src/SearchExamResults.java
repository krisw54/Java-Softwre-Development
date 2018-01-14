import java.util.*;

public class SearchExamResults
{
    private static Scanner kybd = new Scanner(System.in);
    private static final int FIND_LOWEST_MARK = 1;
    private static final int FIND_HIGHEST_MARK = 2;
    private static final int FIND_BY_NAME = 3;
    private static final int FIND_BY_RANGE = 4;
    private static final int EXIT = 5;

    public static void main(String[] args)
    {
        Result[] resultsArray = new Result[20];

        input(resultsArray);
        sortByName(resultsArray);
        output(resultsArray);

        int choice = displayMenu();

        while (choice != EXIT)
        {
            switch (choice)
            {
                case FIND_LOWEST_MARK:
                    Result lowest = getResultHavingLowestMark(resultsArray);
                    System.out.printf("\n%-20s\t%d\n", lowest.getName(), lowest.getMark());
                    break;
                case FIND_HIGHEST_MARK:
                    Result highest = getResultHavingHighestMark(resultsArray);
                    System.out.printf("\n%-20s\t%d\n", highest.getName(), highest.getMark());
                    break;
                case FIND_BY_NAME:
                    System.out.print("Enter name to search for: ");
                    String name = kybd.nextLine();
                    int index = findByName(resultsArray, name);
                    if (index == -1)
                    {
                        System.out.println("Name not found");
                    }
                    else
                    {
                        Result r = resultsArray[index];
                        System.out.printf("\n%-20s\t%d\n", r.getName(), r.getMark());
                    }
                    break;
                case FIND_BY_RANGE:
                    System.out.print("Enter minimum mark in range to search for: ");
                    int minMark = kybd.nextInt();
                    
                    System.out.print("Enter minimum mark in range to search for: ");
                    int maxMark = kybd.nextInt();
                    kybd.nextLine();
                    
                    Result[] results = getResultsInMarkRange(resultsArray, minMark, maxMark);
                    
                    for (Result r : results)
                    {
                        System.out.printf("\n%-20s\t%d\n", r.getName(), r.getMark());
                    }
                    
                    //output(results.size());
                    break;
                default:
                    System.out.println("Invalid option, please choose again");
            }

            choice = displayMenu();
        }
    }

    public static int displayMenu()
    {
        System.out.println("\nMenu");
        System.out.println("\t" + FIND_LOWEST_MARK + ". Find lowest mark");
        System.out.println("\t" + FIND_HIGHEST_MARK + ". Find highest mark");
        System.out.println("\t" + FIND_BY_NAME + ". Find by name");
        System.out.println("\t" + FIND_BY_RANGE + ". Find by mark range");
        System.out.println("\t" + EXIT + ". Exit");

        System.out.print("Enter option number: ");
        int option = kybd.nextInt();
        kybd.nextLine();

        return option;
    }

    public static Result getResultHavingLowestMark(Result[] array)
    {
        sortByMark(array);
        return array[0];
    }

    public static Result getResultHavingHighestMark(Result[] array)
    {
        sortByMark(array);
        return array[array.length - 1];
    }

    public static int findByName(Result[] array, String name)
    {
        sortByName(array);

        int low = 0;
        int high = array.length - 1;
        int index = (low + high) / 2;
        while (name.compareTo(array[index].getName()) != 0 && high >= low)
        {
            if (name.compareTo(array[index].getName()) < 0)
            {
                high = index - 1;
            }
            else if (name.compareTo(array[index].getName()) > 0)
            {
                low = index + 1;
            }
            index = (low + high) / 2;
        }
        if (name.compareTo(array[index].getName()) != 0)
        {
            index = -1;
        }
        return index;
    }

    public static Result[] getResultsInMarkRange(Result[] array, int min, int max)
    {
        sortByMark(array);

        int startIndex = 0;
        Result[] list = null;
        
        while (startIndex < array.length
                && array[startIndex].getMark() < min)
        {
            startIndex++;
        }
        
        if (startIndex < array.length)
        {
            int endIndex = startIndex + 1;
            while (endIndex < array.length
                    && array[endIndex].getMark() <= max)
            {
                endIndex++;
            }
            
            list = new Result[endIndex - startIndex];
            
            for (int i = 0; i < list.length; i++)
            {
                list[i] = array[startIndex + i];
            }
        }
        
        return list;
    }

    public static void input(Result[] array)
    {
        Scanner kybd = new Scanner(System.in);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Candidate " + (i + 1));
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
            int firstElement = pass -1;
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
