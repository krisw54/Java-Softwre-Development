import java.awt.GraphicsEnvironment;

public class PrintAvailableFonts
{
    public static void main(String args[])
    {
        for (String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
        {
            System.out.println(s);
        }
    }
}
