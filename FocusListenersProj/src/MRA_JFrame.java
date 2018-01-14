import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MRA_JFrame extends JFrame implements FocusListener
{
    private JTextField ageField;
    private JTextField smokesField;
    private JTextField overweightField;
    private JButton reportButton;
    private JTextArea log;
    private int score = 0;
    
    public MRA_JFrame()
    {
        super("Chris's Medical risk assessment");
        setSize(500, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setupGUI();
        
        setVisible(true);
        ageField.requestFocus();
    }
    
    public void setupGUI()
    {
        JPanel westPanel = setupWestPanel();
        JPanel centrePanel = setupCenterPanel();
        
        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().add(westPanel, BorderLayout.WEST);
        getContentPane().add(centrePanel, BorderLayout.CENTER);
    }
    
    public JPanel setupCenterPanel()
    {
        Font f = new Font("Courier New", Font.PLAIN, 12);
        
        log = new JTextArea(5, 20);
        log.setEditable(false);
        log.setFont(f);
        
        JPanel p = new JPanel(new GridLayout(1, 1));
        p.add(new JScrollPane(log));
        return p;
    }
    
    public JPanel setupWestPanel()
    {
        JPanel wnPanel = setupWestNorthPanel();
        JPanel wsPanel = setupWestSouthPanel();
        
        JPanel p = new JPanel(new BorderLayout());
        p.add(wnPanel, BorderLayout.NORTH);
        p.add(wsPanel, BorderLayout.SOUTH);
        return p;
    }
    
    public JPanel setupWestNorthPanel()
    {
        ageField = new JTextField(5);
        smokesField = new JTextField(5);
        overweightField = new JTextField(5);
        
        JPanel agePanel = new JPanel(new GridLayout(1, 2));
        agePanel.add(new JLabel("Age: ", JLabel.RIGHT));
        JPanel p = new JPanel();
        p.add(ageField);
        ageField.addFocusListener(this);
        agePanel.add(p);
        
        JPanel smokesPanel = new JPanel(new GridLayout(1, 2));
        smokesPanel.add(new JLabel("Smokes: ", JLabel.RIGHT));
        p = new JPanel();
        p.add(smokesField);
        smokesField.addFocusListener(this);
        smokesPanel.add(p);
        
        JPanel overweightPanel = new JPanel(new GridLayout(1, 2));
        overweightPanel.add(new JLabel("Overweight: ", JLabel.RIGHT));
        p = new JPanel();
        p.add(overweightField);
        overweightField.addFocusListener(this);
        overweightPanel.add(p);
        
        JPanel np = new JPanel();
        np.setLayout(new BoxLayout(np, BoxLayout.Y_AXIS));
        np.add(agePanel);
        np.add(smokesPanel);
        np.add(overweightPanel);
        
        return np;
    }
    
    public JPanel setupWestSouthPanel()
    {
        reportButton = new JButton("Report");
        JPanel p = new JPanel();
        
        return p;
    }
    
    private void checkData()
    {
        String t = "Medical Report\n=======\nAge: " + checkDOB()+"\nSmokes: " + checkSmokes() + "\nOverweight: " + checkOverweight() + "\n\n" + checkScore();
        log.setText(t);
        score = 0;
        
    }
    
    private String checkScore()
    {
        String scoreS ="";
        if (score == 0)
        {
            scoreS = "Low Risk";
        } else if (score == 1){
            scoreS = "Medium Risk";
        } else if (score == 2){
            scoreS = "High Risk";
        } else {
            scoreS = "Very High Risk";
        }
        return scoreS;
    }
    
    private String checkDOB()
    {
        String theAge="";
        try
          {
            int age = Integer.parseInt(ageField.getText());
            if (age < 0 || age > 116)
            {
                theAge="Age must be between 0-116";
            }
            else
            {
                theAge = String.valueOf(age);
                if (age >= 70)
                {
                    score = score + 1;
                }
            }

           }
            catch (NumberFormatException nfe)
            {
                theAge = "Must use integers please";
                ageField.requestFocus();
                
            }
        return theAge;
    }
    
    private String checkSmokes()
    {
        String theSmokes ="";
        if(smokesField.getText().equalsIgnoreCase("y") || smokesField.getText().equalsIgnoreCase("n"))
        {
            theSmokes = smokesField.getText();
            if(smokesField.getText().equalsIgnoreCase("y"))
            {
                score = score + 1;
            }
        }
        else
        {
            theSmokes = "Please enter either Y and N as any other input is invalid.";
        }
        
        return theSmokes;
    }
    
     private String checkOverweight()
    {
        String theOweight ="";
        if(overweightField.getText().equalsIgnoreCase("y") || overweightField.getText().equalsIgnoreCase("n"))
        {
            theOweight = overweightField.getText();
            if (overweightField.getText().equalsIgnoreCase("y"))
            {
                score = score + 1;
            }
        }
        else
        {
            theOweight = "Please enter either Y and N as any other input is invalid.";
        }
        return theOweight;
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        checkData();
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        checkData();
    }
   
}
