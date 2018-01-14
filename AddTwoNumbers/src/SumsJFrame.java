import java.awt.*;
import javax.swing.*;

public class SumsJFrame extends JFrame
{
    private JButton calculate;
    private JLabel sumLabel;
    private String sumText = "num1 + num2 = ";
    private JTextField num1;
    private JTextField num2;
    
    public SumsJFrame()
    {
        super("Coding a GUI plan");
        
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
        return south;
    }
    
    private JPanel setupSumPanel()
    {
        sumLabel = new JLabel(sumText + "?", JLabel.CENTER);
        
        JPanel sumPanel = new JPanel();
        sumPanel.add(sumLabel);
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
}
