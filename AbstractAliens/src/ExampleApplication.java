import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.JOptionPane;

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
                JOptionPane.showMessageDialog(null, 
                                              "The input file is empty", 
                                              "Empty file", 
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(null, 
                                          "The input file was not available", 
                                          "File not found", 
                                          JOptionPane.ERROR_MESSAGE);
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