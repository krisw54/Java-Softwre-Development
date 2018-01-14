import sports.*;

/**
 * This is a partial implementation of the test plan in file
 * "{@code 22 TextPlan.docx}" to illustrate how a test application
 * class could be written.
 */
public class TestPlanImplementedByApplication
{
    public static void main(String args[])
    {
        UT1();
        UT2();
        UT3();
    }

    private static void UT1()
    {
        try
        {
            System.out.println("Test: UT1");
            Team t1 = new Team("A-Team", 5);
            System.out.println("\tExpected: team exists"
                               + "\tActual: " + (t1 != null));
            System.out.println("\tExpected: team name = 'A-Team'"
                               + "\tActual: " + (t1.getName().equals("A-Team")));
            System.out.println("\tExpected: required number of players = 5"
                               + "\tActual: " + (t1.getRequiredNumberOfPlayers() == 5));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void UT2()
    {
        try
        {
            System.out.println("\nTest: UT2");
            Player p1 = new Player("Jimmy");
            System.out.println("\tExpected: player exists"
                               + "\tActual: " + (p1 != null));
            System.out.println("\tExpected: player name = 'Jimmy'"
                               + "\tActual: " + (p1.getName().equals("Jimmy")));
            System.out.println("\tExpected: position is blank"
                               + "\tActual: " + (p1.getPosition().equals("")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void UT3()
    {
        try
        {
            System.out.println("\nTest: UT3");
            Team t1 = new Team("", 5);
            System.out.println("\tExpected: error: team not created"
                               + "\tActual: " + (t1 == null));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
