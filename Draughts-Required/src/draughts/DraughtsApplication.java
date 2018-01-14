package draughts;

public class DraughtsApplication
{
    public static void main(String args[])
    {
        try
        {
            new DraughtsJFrame(8);
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
