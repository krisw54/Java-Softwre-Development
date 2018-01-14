import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SumsJFrame extends JFrame implements ActionListener
{
    private JButton calculate;
    private JLabel sumLabel, errorLabel;
    private String sumText = "num1 + num2 = ";
    private JTextField num1;
    private JTextField num2;
    
    public SumsJFrame()
    {
        super("Chris's add 2 numbers");
        
        setSize(220, 250);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setupGUI();
        
        setVisible(true);
    }
    
    private JPanel setupSouthPanel()
    {
        calculate = new JButton("Calculate");
        
        JPanel south = new JPanel();
        south.setBackground(Color.yellow);
        south.setOpaque(true);
        south.add(calculate);
        calculate.addActionListener(this);
        return south;
    }
    
    private JPanel setupSumPanel()
    {
        sumLabel = new JLabel(sumText + "?", JLabel.CENTER);
        errorLabel = new JLabel("", JLabel.CENTER);
        
        JPanel sumPanel = new JPanel();
        sumPanel.add(sumLabel);
        sumPanel.add(errorLabel);
        errorLabel.setForeground(Color.RED);
        
        return sumPanel;
    }
    
    private JPanel setupCentrePanel()
    {
        JPanel sumPanel = setupSumPanel();
        
        JPanel cp = new JPanel();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(Box.createVerticalStrut(10));
        cp.add(sumPanel);
        cp.add(Box.createGlue());
        return cp;
    }
    
    private JPanel setupNum2Panel()
    {
        JLabel num2Label = new JLabel("Num 2:", JLabel.RIGHT);
        num2 = new JTextField(5);
        
        JPanel num2Panel = new JPanel();
        num2Panel.add(num2Label);
        num2Panel.add(num2);
        return num2Panel;
    }
    
    private JPanel setupNum1Panel()
    {
        JLabel num1Label = new JLabel("Num 1:", JLabel.RIGHT);
        num1 = new JTextField(5);
        
        JPanel num1Panel = new JPanel();
        num1Panel.add(num1Label);
        num1Panel.add(num1);
        return num1Panel;
    }
    
    private JPanel setupTitlePanel()
    {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Sums example", JLabel.CENTER));
        return titlePanel;
    }
    
    private JPanel setupNorthPanel()
    {
        JPanel titlePanel = setupTitlePanel();
        JPanel num1Panel = setupNum1Panel();
        JPanel num2Panel = setupNum2Panel();
        
        JPanel np = new JPanel();
        np.setLayout(new BoxLayout(np, BoxLayout.Y_AXIS));
        np.add(titlePanel);
        np.add(num1Panel);
        np.add(num2Panel);
        np.add(Box.createVerticalStrut(10));
        return np;
    }
    
    private void setupGUI()
    {
        JPanel northPanel = setupNorthPanel();
        JPanel centrePanel = setupCentrePanel();
        JPanel southPanel = setupSouthPanel();
        
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setLayout(new BorderLayout(5, 5));
        
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centrePanel, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String num1t = num1.getText();
        String num2t = num2.getText();
        
        if (e.getSource() == calculate)
        {
            if (num1t.length() == 0)
            {
                errorLabel.setText("Please enter a number in box 1");
                num1.requestFocus();
            }
            else if (num2t.length() == 0)
            {
                errorLabel.setText("Please enter a number in box 2");
                num2.requestFocus();
            }
            else
            {
                try
                {
                    int num11 = Integer.parseInt(num1t);
                    int num22 = Integer.parseInt(num2t);
                    int ans = num11 + num22;
                    errorLabel.setText("");
                    sumLabel.setText(num11 + " + " + num22 + " = " + ans);
                }
            catch (NumberFormatException nfe)
            {
                errorLabel.setText("Must use integers please");
                num1.requestFocus();
            }
         }       
       }
    }
}
