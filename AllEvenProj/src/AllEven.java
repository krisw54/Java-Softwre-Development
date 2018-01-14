import java.util.Scanner;
/**
 *
 * @author krisw
 */
public class AllEven {
    
    public static void main(String[] args) {
        
        Scanner myKeyboard = new Scanner(System.in);  
        int arraySize=0;
        
        while (arraySize <= 0)
        {
           System.out.print("Enter Array Size: ");
           arraySize = myKeyboard.nextInt();
        }
        
        int[] numStore = new int[arraySize];
        
        //Read in Data
        read(numStore, myKeyboard);
        
        //Sort out even numbers
        getEven (numStore);
        
        //Print Out Data
        print(getEven(numStore));
    }
    
    public static void read(int[] array, Scanner kybd)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print("Input Next Number: ");
            array[i] = kybd.nextInt();
        }
    }
    
    public static int[] getEven(int[] array)
    {
         int j=0, count=0;
         
         for (int i = 0; i < array.length; i++)
         {
            if (array[i]% 2 == 0)
            {
                count++;
            }
         }
         
        int [] numStoreN = new int[count];
         
        if (count == 0)
        {

        }
        else
        {
            for (int i = 0; i < array.length; i++)
            {
                if (array[i]% 2 == 0)
                {
                    numStoreN[j] = array[i];
                    j++;
                }  
            }
        }
        return numStoreN;
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
