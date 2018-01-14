import java.awt.*;
import java.io.*;
import java.util.*;

public class ExampleApplication
{
    public static void main(String args[])
    {
        try
        {
            Scanner inFile = new Scanner(new File("InputFile.txt"));

            if (inFile.hasNext())
            {
                ArrayList<Alien> aliens = createAliens(inFile);
                inFile.close();

                new ExampleJFrame(aliens);
            }
            else
            {
                System.out.println("The input file is empty");
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("The input file was not available");
        }
    }

    public static ArrayList<Alien> createAliens(Scanner inFile)
    {
        ArrayList<Alien> alienList = new ArrayList<Alien>();

        String line = inFile.nextLine();
        line = inFile.nextLine();

        while (inFile.hasNext())
        {
            Alien a = null;
            Color c = Alien.getRandomColour();

            String name = line.substring(line.indexOf(" ") + 1);

            if (line.startsWith("Alien"))
            {
                a = new GhostAlien();
            }
            else if (line.startsWith("TriAlien"))
            {
                TriAlien tri = new TriAlien();
                tri.setLegColour(c);
                a = tri;
            }
            a.setName(name);
            alienList.add(a);
            
            line = inFile.nextLine();
        }
        return alienList;
    }
}