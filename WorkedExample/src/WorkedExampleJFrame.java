import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WorkedExampleJFrame extends JFrame implements ActionListener
{
    private JTextField text;
    private JTextArea log;
    private JTextField searchField;

    public WorkedExampleJFrame()
    {
        super("GDM's worked example");
        setSize(400, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setupGUI();
        
        setVisible(true);
        text.requestFocus();
    }

    private void setupGUI()
    {
        setupTextField();
        JScrollPane centrePanel = setupCenterPanel();
        JPanel southPanel = setupSouthPanel();
        
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(text, BorderLayout.NORTH);
        getContentPane().add(centrePanel, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }

    public void setupTextField()
    {
        Font f = new Font("Lucida Calligraphy", Font.PLAIN, 20);
        
        text = new JTextField("The cat sat on the mat");
        text.setFont(f);
        text.setEditable(false);
        text.setSelectionColor(Color.YELLOW);
    }

    public JScrollPane setupCenterPanel()
    {
        log = new JTextArea("Log of searches\n");
        log.setEditable(false);

        return new JScrollPane(log);
    }

    public JPanel setupSouthPanel()
    {
        searchField = new JTextField(10);
        searchField.addActionListener(this);
        
        JPanel findPanel = new JPanel();
        findPanel.add(new JLabel("Search for:", JLabel.RIGHT));
        findPanel.add(searchField);

        return findPanel;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (!searchField.getText().equals(""))
        {
            int startPos = text.getText().indexOf(searchField.getText());
            
            if (startPos > -1)
            {
                log.append("\n   Found '" + searchField.getText() + 
                        "' beginning at position " + (startPos+1));
                text.select(startPos, startPos+searchField.getText().length());
                text.requestFocus();
            }
            else
            {
                log.append("\n   Could not find '" + searchField.getText() + "'");
            }
        }
    }
}