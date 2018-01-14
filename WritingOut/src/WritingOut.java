import java.io.*;
import java.util.*;

public class WritingOut
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
            PrintWriter outFile = new PrintWriter("out.txt");

            outFile.print("\nIntegers input:\n\t");
            while (inFile.hasNext())
            {
                try
                {
                    int value = inFile.nextInt();
                    sum += value;
                    count++;
                    outFile.print("  " + value);
                }
                catch (InputMismatchException ime)
                {
                    String valueStr = inFile.next();
                    errs += "\n\t" + valueStr;
                }
            }

            ave = (double)sum / count;
            outFile.println("\n\nAverage: \n\t" + ave);
            outFile.println("\nInvalid input:" + errs);

            inFile.close();
            outFile.close();
        }
        catch (IOException ioe)
        {
           System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}
