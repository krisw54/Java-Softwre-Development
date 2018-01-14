import java.io.*;
import java.util.*;

public class InputOutputManager
{
    private ArrayList<Team> teams;
    private ArrayList<Player> players;

    public InputOutputManager()
    {
        teams = new ArrayList<Team>();
        players = new ArrayList<Player>();
    }

    public ArrayList<Team> getTeams()
    {
        return teams;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public void readDataFromFile() throws Exception
    {
        try
        {
            Scanner inFile = new Scanner(new File("DataFile.txt"));
            inputTeams(inFile);
            inputPlayers(inFile, getTeams());
            inFile.close();
        }
        catch (FileNotFoundException fnfe)
        {
            throw new Exception("The data file was not available for input");
        }
    }

    private void inputTeams(Scanner inFile)
    {
        teams = new ArrayList<Team>();

        String line = inFile.nextLine();
        line = inFile.nextLine();

        while (!line.equalsIgnoreCase("Players"))
        {
            String[] part = line.split(":");

            String name = part[0];
            int teamSize = Integer.parseInt(part[1]);

            Team t = new Team(name, teamSize);
            getTeams().add(t);
            line = inFile.nextLine();
        }
    }

    private void inputPlayers(Scanner inFile, ArrayList<Team> teams)
    {
        players = new ArrayList<Player>();

        while (inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] names = line.split(":");

            Player p = new Player(names[0]);
            getPlayers().add(p);

            if (names.length == 2)
            {
                Team t = findTeam(names[1], teams);
                t.addPlayer(p);
            }
        }
    }

    private Team findTeam(String teamName, ArrayList<Team> teams)
    {
        Team t = null;
        boolean found = false;

        for (int i = 0; !found && i < teams.size(); i++)
        {
            if (teams.get(i).getName().equalsIgnoreCase(teamName))
            {
                found = true;
                t = teams.get(i);
            }
        }

        return t;
    }

    public void writeDataToFile() throws Exception
    {
        PrintWriter outFile = new PrintWriter("DataFile.txt");
        outputTeams(outFile);
        outputPlayers(outFile);
        outFile.close();
    }

    private void outputPlayers(PrintWriter outFile)
    {
        outFile.println("Players");
        for (Player p : getPlayers())
        {
            outFile.println(p.getName() + ":" + (p.getTeam() == null ? "" : p.getTeam().getName()));
        }
    }

    private void outputTeams(PrintWriter outFile)
    {
        outFile.println("Teams");
        for (Team t : getTeams())
        {
            outFile.println(t.getName() + ":" + t.getRequiredNumberOfPlayers());
        }
    }
}
