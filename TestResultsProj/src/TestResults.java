/**
 *
 * @author chriswood
 */
import java.io.*;
import java.util.*;

public class TestResults {
    
    public static void main(String[] args) 
    {
    
        ArrayList<String> namesArray = new ArrayList<String>();
        readIn(namesArray);
        addGrade(namesArray);
        
    }
    
    public static void readIn(ArrayList namesArray)
    {
        String errs = "";
        try
        {
            Scanner inFile = new Scanner(new File("Names.txt"));

            System.out.print("\nStudent Names:\n");
            while (inFile.hasNext())
            {
                try
                {
                    namesArray.add(inFile.nextLine());
                }
                catch (InputMismatchException ime)
                {
                    String valueStr = inFile.next();
                    errs += "\n\t" + valueStr;
                }
            }
            inFile.close();
        }
        catch (IOException ioe)
        {
           System.out.println("ERROR: " + ioe.getMessage());
        }
    }
    
    public static void addGrade(ArrayList namesArray)
    {
        Scanner kybd = new Scanner(System.in);
        int grade = 0;
        
        try
        {
            PrintWriter passFile = new PrintWriter("Pass.txt");
            PrintWriter failFile = new PrintWriter("Fail.txt");
            
            passFile.print("\nPass Stuents:\n");
            failFile.print("\nFail Stuents:\n");
            
            for (int i = 0; i < namesArray.size(); i++)
            {
                System.out.println("\tPlease Input Grade for: " + namesArray.get(i));
                grade = kybd.nextInt();
                
                if (grade >39)
                {
                    passFile.print("\t" + namesArray.get(i) + " - " + grade + "%\n");
                }
                else
                {
                    failFile.print("\t" + namesArray.get(i) + " - " + grade + "%\n");
                }
            }
            passFile.close();
            failFile.close();
        }
        catch (IOException ioe)
        {
           System.out.println("ERROR: " + ioe.getMessage());
        }
    }
}
