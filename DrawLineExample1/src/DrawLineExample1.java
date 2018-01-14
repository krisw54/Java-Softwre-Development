
public class DrawLineExample1
{
    public static void main (String[] args)
    {
        drawLine();
        //additional code
        drawLine();
    }

    public static void drawLine()
    {
         for (int i = 0; i < 20; i++)
         {
            System.out.print("_");
        }
        System.out.println();
    }
}

