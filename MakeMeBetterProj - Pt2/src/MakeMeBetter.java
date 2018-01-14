import java.util.Scanner;

public class MakeMeBetter
{
    public static void main(String[] args)
    {
        int arr[] = new int[11];
        Scanner kybd = new Scanner(System.in);
        
        System.out.println("Please input " + arr.length + " numbers in the range 1-19 :> ");
        
        inputArrayValues(arr,kybd);
        
        outputArrayValues(arr);
        
        sortArrayValues(arr);
        
        outputArrayValues(arr);
        
        outputAveragesOfArrayValues(arr);
    }
    
    public static void inputArrayValues (int[] arr, Scanner kybd)
    {
        int num;
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Input numnber " + (i+1) + ": " );
            num = kybd.nextInt();
            while (num < 1 || num > 19)
            {
                System.out.println("Not in the range 1-19, please try again :> ");
                num = kybd.nextInt();
            }
         arr[i] = num;
        }
    }
    
    public static void sortArrayValues (int [] arr)
    {
        boolean noSwap = false;
        int startAt = 0;
        int stopAt = (arr.length -1);
        while (startAt < stopAt && noSwap == false)
        {
            noSwap = true;
            for (int i=startAt; i<stopAt; i++)
            {
                if (arr[i] > arr[i+1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    noSwap = false;
                }
            }
            stopAt = stopAt - 1;
        }
    }
    
    public static void outputArrayValues (int[] arr)
    {
        System.out.println("\nArray contents");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print((arr[i] < 10 ? " " : "") + arr[i] + "  ");
        }
            System.out.println();
    }
    
    public static void outputAveragesOfArrayValues (int[] arr)
    {
        double av =0;
        int arrSize = arr.length-1;
        int med = (arr.length-1) / 2;
        for (int i = 0; i < arr.length; i++)
        {
            av = (av + arr[i]);
        }
        av = av / 10;

        System.out.println("The minimum number is: " + arr[0]);
        System.out.println("The maximum number is: " + arr[arrSize]);
        System.out.println("The average value is: " + av);
        System.out.println("The median is: " + arr[med]);
    }
    
}