import java.io.*;
import java.util.*;

public class ReadingIn
{
    public static void main(String[] args)
    {
        int count = 0;
        int sum = 0;
        double ave = 0;
        String errs = "";

        try
        {
            Scanner inFile = new Scanner(new File("in.txt"));

            System.out.print("\nIntegers input:\n\t");
            while (inFile.hasNext())
            {
                try
                {
                    int value = inFile.nextInt();
                    sum += value;
                    count++;
                    System.out.print(value + "  ");
                }
                catch (InputMismatchException ime)
                {
                    String valueStr = inFile.next();
                    errs += "\n\t" + valueStr;
                }
            }

            ave = (double)sum / count;
            System.out.println("\n\nAverage: \n\t" + ave);
            System.out.println("\nInvalid input:" + errs);

            inFile.close();
        }
        catch (IOException ioe)
        {
           System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}