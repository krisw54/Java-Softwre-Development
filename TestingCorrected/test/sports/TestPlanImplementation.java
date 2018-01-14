package sports;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This is an implementation of the test plan in file
 * "{@code 22 TextPlan.docx}" to illustrate how a JUnit test 
 * class could be written.
 */
public class TestPlanImplementation
{
    @Test
    public void test_UT1() throws SportsException
    {
        Team t1 = new Team("A-Team", 5);

        assertNotNull("Team should exist, but t1 is null", t1);
        
        assertEquals("Team name should be 'A-Team' - ", 
                     "A-Team", 
                     t1.getName());
        
        assertEquals("Required number of players should be 5 - ", 
                     5, 
                     t1.getRequiredNumberOfPlayers());
    }
    
    @Test
    public void test_UT2() throws SportsException
    {
        Player p1 = new Player("Jimmy");

        assertNotNull("Player should exist, but p1 is null", p1);
        
        assertEquals("Player name should be 'Jimmy' - ", 
                     "Jimmy", 
                     p1.getName());
        
        assertEquals("Position should be the empty string - ", 
                     "", 
                     p1.getPosition());
    }
    
    @Test (expected=SportsException.class)
    public void test_UT3() throws SportsException
    {
        Team t1 = new Team("", 5);
    }
    
    @Test (expected=SportsException.class)
    public void test_UT4() throws SportsException
    {
        Team t1 = new Team("Z-Team", -4);
    }
    
    @Test (expected=SportsException.class)
    public void test_UT5() throws SportsException
    {
        Player p1 = new Player("");
    }
    
    @Test (expected=SportsException.class)
    public void test_UT6() throws SportsException
    {
        Team t1 = new Team("Y-Team", 0);
    }
    
    @Test
    public void test_UT7() throws SportsException
    {
        Team t1 = new Team("B-Team", 1);

        assertNotNull("Team should exist, but t1 is null", t1);
        
        assertEquals("Team name should be 'B-Team' - ", 
                     "B-Team", 
                     t1.getName());
        
        assertEquals("Required number of players should be 1 - ", 
                     1, 
                     t1.getRequiredNumberOfPlayers());
        
        assertFalse("The team should not be able to compete, but t1 can compete", 
                    t1.canCompete());
    }
    
    @Test
    public void test_UT8() throws SportsException
    {
        Player p1 = new Player("Jimmy");
        Team t1 = new Team("B-Team", 1);
        
        t1.addPlayer(p1, "Defence");
        
        assertEquals("Team t1 should only have one player - ", 
                     1, 
                     t1.getPlayers().size());
        
        Player p = t1.getPlayers().get(0);
        
        assertEquals("The player's name should be 'Jimmy' - ", 
                     "Jimmy", 
                     p.getName());
        
        assertTrue("The team should be able to compete, but t1 cannot compete", 
                   t1.canCompete());
        
        assertEquals("The player's team's name should be 'B-Team' - ", 
                     "B-Team", 
                     p.getTeam().getName());
        
        assertEquals("The player's position should be 'Defence' - ", 
                     "Defence", 
                     p.getPosition());
    }
    
    @Test
    public void test_UT9() throws SportsException
    {
        Player p1 = new Player("Jimmy");
        Team t1 = new Team("B-Team", 1);
        
        t1.addPlayer(p1, "Defence");
        
        Player p2 = new Player("John");
        boolean playerAdded = t1.addPlayer(p2, "Attack");
        
        assertFalse("Player p2 should not have been added to team t1", 
                    playerAdded);
        
        assertNull("Player p2 should not have a team, but does", p2.getTeam());
        
        assertEquals("Player p2's position should be blank - ", 
                     "", 
                     p2.getPosition());
        
        assertEquals("Team t1 should only have one player - ", 
                     1, 
                     t1.getPlayers().size());
    }
    
    @Test
    public void test_UT10() throws SportsException
    {
        Player p1 = new Player("Jimmy");
        Team t1 = new Team("B-Team", 1);
        t1.addPlayer(p1, "Defence");
        t1.removePlayer(p1);
        
        assertEquals("Team t1 should not have any players - ", 
                     0, 
                     t1.getPlayers().size());
        
        assertFalse("The team should not be able to compete, but t1 can compete", 
                    t1.canCompete());
        
        assertNull("Player p1 should not have a team, but does", p1.getTeam());
        
        assertEquals("Player p1's position should be blank - ", 
                     "", 
                     p1.getPosition());
    }
    
    @Test
    public void test_UT11() throws SportsException
    {
        Player p1 = new Player("Jimmy");
        Team t1 = new Team("B-Team", 1);
        t1.addPlayer(p1, "Defence");
        t1.removePlayer(p1);
        t1.removePlayer(p1);
        
        assertEquals("Team t1 should not have any players - ", 
                     0, 
                     t1.getPlayers().size());
    }
    
    @Test
    public void test_UT12() throws SportsException
    {
        Team t1 = new Team("A-Team", 5);
        Team t2 = new Team("B-Team", 1);
        Player p1 = new Player("Jimmy");
        
        t1.addPlayer(p1, "Attack");
        t2.addPlayer(p1, "Defence");
        
        assertEquals("Team t1 should only have one player - ", 
                     1, 
                     t1.getPlayers().size());
        
        Player p = t1.getPlayers().get(0);
        
        assertEquals("The player's name should be 'Jimmy' - ", 
                     "Jimmy", 
                     p.getName());
        
        assertFalse("Team t1 should not be able to compete, but it can", 
                    t1.canCompete());
        
        assertEquals("The player's team's name should be 'A-Team' - ", 
                     "A-Team", 
                     p.getTeam().getName());
        
        assertEquals("The player's position should be 'Attack' - ", 
                     "Attack", 
                     p.getPosition());
        
        assertEquals("Team t2 should not have any players - ", 
                     0, 
                     t2.getPlayers().size());
        
        assertFalse("Team t2 should not be able to compete, but it can", 
                    t2.canCompete());
    }
    
    @Test
    public void test_UT13() throws SportsException
    {
        Team t1 = new Team("A-Team", 5);
        Player p1 = new Player("Jimmy");
        
        t1.addPlayer(p1, "Attack");
        boolean playerAdded = t1.addPlayer(p1, "Defence");
        
        assertFalse("Player p1 should not have been added a second time to team t1", 
                    playerAdded);
        
        assertEquals("Team t1 should only have one player - ", 
                     1, 
                     t1.getPlayers().size());
        
        Player p = t1.getPlayers().get(0);
        
        assertEquals("The player's name should be 'Jimmy' - ", 
                     "Jimmy", 
                     p.getName());
        
        assertFalse("Team t1 should not be able to compete, but it can", 
                    t1.canCompete());
        
        assertEquals("The player's team's name should be 'A-Team' - ", 
                     "A-Team", 
                     p.getTeam().getName());
        
        assertEquals("The player's position should be 'Attack' - ", 
                     "Attack", 
                     p.getPosition());
    }
    
    @Test
    public void test_UT14() throws SportsException
    {
        Team t1 = new Team("A-Team", 5);
        Player p1 = new Player("John");
        
        boolean playerAdded = t1.addPlayer(p1, "Wing");
        
        assertFalse("Player p1 should not have been added to team t1", 
                    playerAdded);
        
        assertNull("The player's team should be null, but was not", 
                     p1.getTeam());
        
        assertEquals("The player's position should be blank - ", 
                     "", 
                     p1.getPosition());
        
        assertEquals("Team t1 should not have any players - ", 
                     0, 
                     t1.getPlayers().size());
    }
}
