import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author chriswood
 */
public class AddTeamDialog extends JDialog implements ActionListener {
    
    private JTextField teamName, teamSize;
    private String prompt;
    private JButton OK, cancel;
    private boolean cancelled;
    private ArrayList teams;
    //private InputOutputManager ioMgr;

    public AddTeamDialog(Frame owner, String title, ArrayList t)
    {
        super(owner, title, true);
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.prompt = prompt;
        cancelled = true;
        teams = t;
        
        setupGUI();
        
        setVisible(true);
    }
    
    private void setupGUI()
    {
        JPanel centreP = setupCentrePanel();
        JPanel southP = setupSouthPanel();

        getContentPane().add(centreP, BorderLayout.CENTER);
        getContentPane().add(southP, BorderLayout.SOUTH);
    }

    private JPanel setupCentrePanel()
    {
        teamName = new JTextField(10);
        teamSize = new JTextField(5);
        
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Please enter a team name: "));
        p1.add(teamName);

        p1.add(new JLabel("Please enter a team size: "));
        p1.add(teamSize);
        
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(p1);
        p.add(Box.createVerticalGlue());
        return p;
    }

    private JPanel setupSouthPanel()
    {
        OK = new JButton("OK");
        OK.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);

        JPanel p = new JPanel();
        p.add(OK);
        p.add(cancel);
        return p;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == OK)
        {
            if (teamName.getText().equals(""))
            {
                String msg = "You Did Not Enter a Team Name";
                String title = "Data Error";
                JOptionPane.showMessageDialog(this,
                                          msg,
                                          title,
                                          JOptionPane.ERROR_MESSAGE);
            }
            else if (teamSize.getText().equals(""))
            {
                String msg = "You Did Not Enter a Team Size";
                String title = "Data Error";
                JOptionPane.showMessageDialog(this,
                                          msg,
                                          title,
                                          JOptionPane.ERROR_MESSAGE);
            }
            else
            {   
                try
                {
                    if (Integer.parseInt(teamSize.getText()) > 0)
                    {
                        inputTeam(teamName.getText(), Integer.parseInt(teamSize.getText()));
                        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                    }
                    else
                    {
                        String msg = "Please type an Integer > 0";
                        String title = "Data Error";
                        JOptionPane.showMessageDialog(this,
                                          msg,
                                          title,
                                          JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex)
                {
                    String msg = "Please type an Integer";
                    String title = "Data Error";
                    JOptionPane.showMessageDialog(this,
                                          msg,
                                          title,
                                          JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else
        {
            cancelled = e.getSource() == cancel;
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void inputTeam(String teamNameS, int teamSizeI)
    {
        Team t = new Team(teamNameS, teamSizeI);
        teams.add(t);
    }
    
    public boolean wasCancelled()
    {
        return cancelled;
    }
    
}
