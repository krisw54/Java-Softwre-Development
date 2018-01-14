
import java.util.*;

public class HighlightText
{

    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = kybd.nextLine();
        
        System.out.println("Enter search string: ");
        String search = kybd.nextLine();

        text = text.toLowerCase();
        search = search.toLowerCase();

        int pos = text.indexOf(search);

        if (pos == -1)
        {
            System.out.println("Search string '" + search + "' not found");
        } 
        else
        {
            System.out.println("Search string found at " + (pos + 1));
            String before = text.substring(0, pos);
            String uppercaseString = search.toUpperCase();
            String after = text.substring(pos + search.length());
            System.out.println(before + uppercaseString + after);
        }
    }
}
