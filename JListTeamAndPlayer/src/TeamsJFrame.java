import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class TeamsJFrame extends JFrame implements ActionListener, ListSelectionListener
{
    ArrayList<Team> teams;
    JList teamList;
    
    ArrayList<Player> players;
    JList playerList;
    
    JButton reset;
    
    //int ctr=0;
    
    public TeamsJFrame(ArrayList<Team> teams, ArrayList<Player> players)
    {
        super("GDM's JList example");
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
        JPanel listPanel = setupListPanel();
        JPanel buttonPanel = setupButtonPanel();
        
        getContentPane().setBackground(new Color(0xfedcba));
        getContentPane().add(listPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private JPanel setupButtonPanel()
    {
        reset = new JButton("Reset");
        reset.addActionListener(this);
        
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.add(reset);
        return p;
    }
    
    private JPanel setupListPanel()
    {
        JPanel teamPanel = setupTeamPanel();
        JPanel playerPanel = setupPlayerPanel();
        
        JPanel p = new JPanel(new GridLayout(1, 2, 20, 0));
        p.setOpaque(false);
        p.add(teamPanel);
        p.add(playerPanel);
        return p;
    }
    
    private JPanel setupTeamPanel()
    {
        teamList = new JList(teams.toArray());
        teamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        teamList.addListSelectionListener(this);
        JScrollPane jsp = new JScrollPane(teamList);
        
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Teams"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel setupPlayerPanel()
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
        teamList.setListData(teams.toArray());
        playerList.setListData(players.toArray());
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        //System.out.println("valueChanged(): " + ++ctr + ": " + e.getValueIsAdjusting());
        if (!e.getValueIsAdjusting())
        {
            if (e.getSource() == teamList)
            {
                if (!teamList.isSelectionEmpty())
                {
                    displayPlayers((Team)teamList.getSelectedValue());
                }
            }
            else
            {
                if (!playerList.isSelectionEmpty())
                {
                    displayTeam((Player)playerList.getSelectedValue());
                }
            }
        }
    }
    
    private void displayPlayers(Team t)
    {
        playerList.setListData(t.getPlayers().toArray());
    }
    
    private void displayTeam(Player p)
    {
        Team[] t = {p.getTeam()};
        teamList.setListData(t);
    }
}
