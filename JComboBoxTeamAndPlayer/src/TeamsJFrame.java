import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class TeamsJFrame extends JFrame implements ActionListener, ListSelectionListener
{
    ArrayList<Team> teams;
    JComboBox teamList;
    ArrayList<Player> players;
    JList playerList;
    JButton reset;
    boolean changePlayerList = true;

    public TeamsJFrame(ArrayList<Team> teams, ArrayList<Player> players)
    {
        super("GDM's JComboBox example");
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
        teamList = new JComboBox(teams.toArray());
        teamList.setEditable(false);
        teamList.setSelectedIndex(-1);
        teamList.addActionListener(this);

        JPanel northP = new JPanel(new BorderLayout());
        northP.setOpaque(false);

        northP.add(new JLabel("Teams"), BorderLayout.NORTH);
        northP.add(teamList, BorderLayout.SOUTH);

        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(northP, BorderLayout.NORTH);

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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reset)
        {
            playerList.setListData(players.toArray());
            teamList.setSelectedIndex(-1);
        }
        else if (e.getSource() == teamList)
        {
            if (changePlayerList)
            {
                Team t = (Team) teamList.getSelectedItem();
                if (t != null)
                {
                    displayPlayers(t);
                }
            }
            else
            {
                changePlayerList = true;
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

        changePlayerList = false;
        if (t != null)
        {
            teamList.setSelectedItem(t);
        }
        else
        {
            teamList.setSelectedIndex(-1);
        }
    }
}
