import java.util.Scanner;

/**
 *
 * @author krisw
 */
public class Votes {
    
    public static void main(String[] args) {
        
        Scanner kybd = new Scanner(System.in);
        System.out.println("Please Enter Number of candidates: ");
        int arrSize = kybd.nextInt();
        kybd.nextLine(); //Flush Buffer
        Candidate[] arr = new Candidate[arrSize];
        createCandidates(arr, kybd);
        input(arr, kybd);
        sort(arr);
        printDetails(arr);
        
        
    }
    
    public static Candidate[] createCandidates(Candidate[] arr, Scanner kybd)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Candidate: " + (i + 1));
            arr[i] = createCandidate(kybd);
        }
        return arr;
    }
    
    public static Candidate createCandidate(Scanner kybd)
    {
        Candidate c = new Candidate();
        
        System.out.print("Enter Candidate Name: ");
        String name = kybd.nextLine();
        c.setName(name);

        return c;
    }
    
    public static void input(Candidate[] arr, Scanner kybd)
    {
        String theName = "";
        while (!theName.equalsIgnoreCase("end"))
        {
            System.out.println("Enter name for votes: ");
            theName = kybd.nextLine();
            for (int i = 0; i < arr.length; i++)
            {
                if (theName.equalsIgnoreCase(arr[i].getName()))
                {
                    int votes =  arr[i].getVotes()+1;
                    arr[i].setVotes(votes);
                }
            }
        }
    }
    
    public static void sort(Candidate[] arr)
    {
        for (int pass = 1; pass < arr.length; pass++)
        {
            int firstElement = pass - 1;
            int smallPos = findSmallest(arr, firstElement);
            if (smallPos != firstElement)
            {
                Candidate temp = arr[smallPos];
                arr[smallPos] = arr[firstElement];
                arr[firstElement] = temp;
            }
        }
    } 

    public static int findSmallest(Candidate[] arr, int first)
    {
        int smallestPos = first; 
        for (int i = first+1; i < arr.length; i++)
        {
            if  (arr[i].getVotes() > arr[smallestPos].getVotes())
            {
                smallestPos = i;
            }
        }
        return smallestPos;
    }
    
    public static void printDetails(Candidate[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Name: " + arr[i].getName() + " Votes: " + arr[i].getVotes());
        }
    }    
    
}
