//passing parameters to methods
public class DrawLineExample2
{
    public static void main (String [] args)
    {
        drawLine('*', 10);
        drawLine('@', 15);
    }

    public static void drawLine (char ch, int reps)
    {
        for (int i = 0; i < reps; i++)
        {
            System.out.print(ch);
        }
        System.out.println();
    }
}
