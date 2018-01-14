public class TeamAndPlayerApplication
{
    public static void main(String args[])
    {
        try
        {
            new TeamAndPlayerJFrame();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
