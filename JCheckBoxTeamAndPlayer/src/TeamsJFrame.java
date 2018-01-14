import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class TeamsJFrame extends JFrame implements ActionListener, ListSelectionListener
{
    ArrayList<Team> teams;
    JCheckBox[] teamList;
    ArrayList<Player> players;
    JList playerList;
    JButton reset;
    boolean changePlayerList = true;

    public TeamsJFrame(ArrayList<Team> teams, ArrayList<Player> players)
    {
        super("GDM's JCheckBox example");
        setSize(400, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.teams = teams;
        this.players = players;

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        JPanel centreP = setupListPane();
        JPanel southP = setupButtonPane();

        getContentPane().setBackground(new Color(0xfedcba));
        getContentPane().add(centreP, BorderLayout.CENTER);
        getContentPane().add(southP, BorderLayout.SOUTH);
    }

    private JPanel setupButtonPane()
    {
        reset = new JButton("Reset");
        reset.addActionListener(this);

        JPanel p = new JPanel();
        p.setOpaque(false);
        p.add(reset);
        return p;
    }

    private JPanel setupListPane()
    {
        JPanel westP = setupTeamPane();
        JPanel eastP = setupPlayerPane();

        JPanel p = new JPanel(new GridLayout(1, 2, 20, 0));
        p.setOpaque(false);
        p.add(westP);
        p.add(eastP);
        return p;
    }

    private JPanel setupTeamPane()
    {
        teamList = new JCheckBox[teams.size()];

        for (int i = 0; i < teamList.length; i++)
        {
            teamList[i] = new JCheckBox(teams.get(i).getName());
            teamList[i].setOpaque(false);
            teamList[i].addActionListener(this);
        }


        JPanel checkBoxP = setupCheckBoxPane(teamList);

        JPanel northP = new JPanel(new BorderLayout());
        northP.setOpaque(false);

        northP.add(new JLabel("Teams"), BorderLayout.NORTH);
        northP.add(checkBoxP);

        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(northP, BorderLayout.NORTH);

        return p;
    }

    private JPanel setupCheckBoxPane(JCheckBox[] teamList)
    {
        JPanel p = new JPanel(new GridLayout(teamList.length, 1, 5, 5));
        p.setOpaque(false);
        for (JCheckBox b : teamList)
        {
            p.add(b);
        }
        return p;
    }

    private JPanel setupPlayerPane()
    {
        playerList = new JList(players.toArray());
        playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playerList.addListSelectionListener(this);
        JScrollPane jsp = new JScrollPane(playerList);

        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Players"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);

        return p;
    }

    private void clearTeamSelection()
    {
        for (JCheckBox b : teamList)
        {
            b.setSelected(false);
        }
    }

    private Team findTeam(String name)
    {
        Team t = null;
        boolean found = false;

        for (int i = 0; !found && i < teams.size(); i++)
        {
            Team team = teams.get(i);
            if (team.getName().equals(name))
            {
                found = true;
                t = team;
            }
        }
        return t;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reset)
        {
            playerList.setListData(players.toArray());
            clearTeamSelection();
        }
        else if (e.getSource() instanceof JCheckBox)
        {
            boolean somethingSelected = false;
            for (JCheckBox b : teamList)
            {
                if (b.isSelected())
                {
                    somethingSelected = true;
                    Team t = findTeam(b.getText());
                    displayPlayers(t);
                }
            }
            if (!somethingSelected)
            {
                playerList.setListData(players.toArray());
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            if (!playerList.isSelectionEmpty())
            {
                Player p = (Player) playerList.getSelectedValue();
                displayTeam(p);
            }
        }
    }

    private void displayPlayers(Team t)
    {
        playerList.setListData(t.getPlayers().toArray());
    }

    private void displayTeam(Player p)
    {
        Team t = p.getTeam();

        if (t != null)
        {
            for (JCheckBox b : teamList)
            {
                b.setSelected(b.getText().equals(t.getName()));
            }
        }
        else
        {
            clearTeamSelection();
        }
    }
}
