import java.io.*;
import java.util.*;

public class ExampleApplication
{
    public static void main(String args[])
    {
        try
        {
            Scanner inFile = new Scanner(new File("InputFile.txt"));

            ArrayList<Team> teams = inputTeams(inFile);
            ArrayList<Player> players = inputPlayers(inFile, teams);
            inFile.close();

            printAllTeams(teams);
            printAllPlayers(players);
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("The input file was not available");
        }
    }

    public static ArrayList<Team> inputTeams(Scanner inFile)
    {
        ArrayList<Team> teams = new ArrayList<Team>();

        String line = inFile.nextLine();
        line = inFile.nextLine();

        while (!line.equalsIgnoreCase("Players"))
        {
            String[] part = line.split(":");

            String name = part[0];
            int teamSize = Integer.parseInt(part[1]);

            Team t = new Team(name, teamSize);
            teams.add(t);
            line = inFile.nextLine();
        }
        return teams;
    }

    public static ArrayList<Player> inputPlayers(Scanner inFile, ArrayList<Team> teams)
    {
        ArrayList<Player> players = new ArrayList<Player>();

        while (inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] names = line.split(":");

            Player p = new Player(names[0]);
            players.add(p);

            if (names.length == 2)
            {
                Team t = findTeam(names[1], teams);
                if (!t.addPlayer(p))
                {
                    System.out.println("INFO: The player was not added to the team, which already has the max number of players:> " + line);
                }
            }
        }
        return players;
    }

    public static Team findTeam(String teamName, ArrayList<Team> teams)
    {
        Team t = null;
        boolean found = false;
        int i = 0;

        while (!found && i < teams.size())
        {
            if (teams.get(i).getName().equalsIgnoreCase(teamName))
            {
                found = true;
                t = teams.get(i);
            }
            i++;
        }

        return t;
    }

    public static void printAllPlayers(ArrayList<Player> players)
    {
        System.out.println("\nAll players");
        System.out.println("===========");
        for (Player p : players)
        {
            System.out.printf("\t%-10s  ", p.getName());
            System.out.printf("%-10s\n", (p.getTeam() == null ? "---" : p.getTeam().getName()));
        }
    }

    public static void printAllTeams(ArrayList<Team> teams)
    {
        System.out.println("\nAll teams");
        System.out.println("===========");
        for (Team t : teams)
        {
            System.out.println("\t" + t.getName()
                               + "(" + (t.canCompete() ? "Can" : "Cannot") + " compete)");

            for (Player p : t.getPlayers())
            {
                System.out.println("\t\t" + p.getName());
            }
        }
    }
}
