import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NameAndAgeJApplet extends JApplet implements ActionListener
{
    private JTextField nameField;
    private JTextField ageField;
    private JLabel errorLabel;
    
    @Override
    public void init()
    {
        getContentPane().setBackground(new Color(0xabcdef));
        getContentPane().add(setupNorthPanel(), BorderLayout.NORTH);
        getContentPane().add(setupSouthPanel(), BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    private JPanel setupNorthPanel()
    {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(createNamePanel());
        northPanel.add(createAgePanel());
        return northPanel;
    }
    
    private JPanel setupSouthPanel()
    {
        Font f = new Font("Times New Roman", Font.BOLD, 14);
        
        errorLabel = new JLabel(" ", JLabel.LEFT);
        errorLabel.setFont(f);
        errorLabel.setForeground(Color.RED);
        
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(errorLabel);
        return southPanel;
    }
    
    private JPanel createNamePanel()
    {
        nameField = new JTextField(10);
        nameField.addActionListener(this);
        
        JPanel p = new JPanel();
        p.setOpaque(true);
        p.add(new JLabel("Name:", JLabel.RIGHT));
        p.add(nameField);
        return p;
    }
    
    private JPanel createAgePanel()
    {
        ageField = new JTextField(10);
        ageField.addActionListener(this);
        
        JPanel p = new JPanel();
        p.setOpaque(true);
        p.add(new JLabel("Age:", JLabel.RIGHT));
        p.add(ageField);
        return p;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String name = nameField.getText();
        String ageStr = ageField.getText();
        int age = 0;
        String errorMessage = " ";
        
        if (name.length() == 0)
        {
            errorMessage = "Please enter a name";
            nameField.requestFocus();
        }
        else if (ageStr.length() == 0)
        {
            errorMessage = name + ", please enter an age";
            ageField.requestFocus();
        }
        else
        {
            try
            {
                age = Integer.parseInt(ageStr);
                if (age < 1)
                {
                    errorMessage = name + ", age must be more than zero";
                    ageField.requestFocus();
                }
            }
            catch (NumberFormatException nfe)
            {
                errorMessage = name + ", age must be an integer";
                ageField.requestFocus();
            }
        }
        errorLabel.setText(errorMessage);
    }
}
