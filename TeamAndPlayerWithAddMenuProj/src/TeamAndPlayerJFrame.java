import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class TeamAndPlayerJFrame extends JFrame implements ActionListener, ListSelectionListener, WindowListener
{
    InputOutputManager ioMgr;
    ArrayList<Team> teams;
    JList teamList;
    ArrayList<Player> players;
    JList playerList;
    JButton reset;
    JMenuItem load, save, exit, team;
    JMenu file, add;
    
    public TeamAndPlayerJFrame() throws Exception
    {
        super("Chris's Team and Player");
        setSize(400, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(this);

        ioMgr = new InputOutputManager();
        inputData();

        setupGUI();

        setVisible(true);
    }

    private void inputData() throws Exception
    {
        ioMgr.readDataFromFile();
        teams = ioMgr.getTeams();
        players = ioMgr.getPlayers();
    }

    private void outputData()
    {
            try
            {
                ioMgr.writeDataToFile();
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Save error", JOptionPane.ERROR_MESSAGE);
            }
    }

    private void setupGUI()
    {
        JPanel listPanel = setupListPanel();
        JPanel buttonPanel = setupButtonPanel();

        getContentPane().setBackground(new Color(0xfedcba));
        getContentPane().add(listPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        bar.add(setupApplicationMenu());
        bar.add(setupAddMenu());
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
    
    private JMenu setupAddMenu()
    {
        JMenu menuAdd = new JMenu("Add");
        
        team = new JMenuItem("Team");
        
        menuAdd.add(team);
        
        team.setMnemonic(KeyEvent.VK_T);
        
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_T,
        InputEvent.ALT_MASK); team.setAccelerator(key);
        
        team.addActionListener(this);
        
        return menuAdd;
    }
    
    private JMenu setupApplicationMenu()
    {
        JMenu menu = new JMenu("File");
        
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
        
        menu.add(load);
        menu.add(save);
        menu.addSeparator();
        menu.add(exit);
        
        exit.setMnemonic(KeyEvent.VK_X);
        load.setMnemonic(KeyEvent.VK_L);
        save.setMnemonic(KeyEvent.VK_S);
        
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_X,
        InputEvent.ALT_MASK); exit.setAccelerator(key);
  
        KeyStroke key1 = KeyStroke.getKeyStroke(KeyEvent.VK_L,
        InputEvent.ALT_MASK); load.setAccelerator(key1);
        
        KeyStroke key2 = KeyStroke.getKeyStroke(KeyEvent.VK_S,
        InputEvent.CTRL_MASK); save.setAccelerator(key2);
        
        exit.addActionListener(this);
        load.addActionListener(this);
        save.addActionListener(this);
        
        return menu;
    }
    
    private String inputTeamName(ArrayList t)
    {
        String nameTitle = "Add Team";
        AddTeamDialog dialog = new AddTeamDialog(null, nameTitle, t);
        return dialog.getName();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        teamList.setListData(teams.toArray());
        playerList.setListData(players.toArray());
        
        if (e.getSource() == load)
        {
            System.out.println("load");
            try
            {
               ioMgr.readDataFromFile(); 
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }
        else if (e.getSource() == save)
        {
            System.out.println("Save");
            try
            {
               ioMgr.writeDataToFile(); 
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == exit)
        {
            System.out.println("exit");
            dispatchEvent( new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        else if (e.getSource() == team)
        {
           String name = inputTeamName(ioMgr.getTeams());
           teamList.setListData(teams.toArray());
           playerList.setListData(players.toArray());
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            if (e.getSource() == teamList)
            {
                if (!teamList.isSelectionEmpty())
                {
                    displayPlayers((Team) teamList.getSelectedValue());
                }
            }
            else
            {
                if (!playerList.isSelectionEmpty())
                {
                    displayTeam((Player) playerList.getSelectedValue());
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
        Team[] t =
        {
            p.getTeam()
        };
        teamList.setListData(t);
    }

    @Override
    public void windowOpened(WindowEvent e){}
    @Override
    public void windowClosed(WindowEvent e){}
    @Override
    public void windowActivated(WindowEvent e){}
    @Override
    public void windowDeactivated(WindowEvent e){}
    @Override
    public void windowIconified(WindowEvent e){}
    @Override
    public void windowDeiconified(WindowEvent e){}
    @Override
    public void windowClosing(WindowEvent e)
    {
        int option = JOptionPane.showConfirmDialog(
                                            this,
                                            "Are you sure you want to exit?",
                                            "Confirm exit",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION)
        {
            outputData(); 
            System.exit(0);
        }
    }
}
