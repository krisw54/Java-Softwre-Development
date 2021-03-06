import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlienJFrame extends JFrame implements ActionListener
{
    private AlienCanvas canvas;
    private JButton randomColourChange;
    private JButton sameColourChange;
    private JButton alienColourChange;
    private JTextField alienName;
    private JTextArea log;
    
    public AlienJFrame(Alien[] alien)
    {
        super("JLabels and JTextFields example");
        
        setSize(600, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        log = new JTextArea("Colour changes", 5, 15);
        log.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(log);
        
        canvas = new AlienCanvas(alien, log);
        
        JPanel southPanel = setupSouthPanel();
        
        getContentPane().setBackground(new Color(0xabcdef));
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        getContentPane().add(scrollpane, BorderLayout.EAST);
        
        setVisible(true);
        
        alienName.requestFocus();
    }
    
    private JPanel setupSouthPanel()
    {
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(createButtonPanel());
        southPanel.add(createColourChangePanel());
        return southPanel;
    }
    
    private JPanel createButtonPanel()
    {
        randomColourChange = new JButton("Random colours");
        randomColourChange.addActionListener(this);
        
        sameColourChange = new JButton("Same colour");
        sameColourChange.addActionListener(this);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        buttonPanel.add(randomColourChange);
        buttonPanel.add(sameColourChange);
        return buttonPanel;
    }
    
    private JPanel createColourChangePanel()
    {
        alienColourChange = new JButton("Change alien colour");
        alienColourChange.addActionListener(this);
        
        alienName = new JTextField(5);
        
        JPanel p = new JPanel();
        p.setOpaque(true);
        p.add(new JLabel("Alien name:", JLabel.RIGHT));
        p.add(alienName);
        p.add(alienColourChange);
        return p;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == randomColourChange)
        {
            canvas.randomColourChange();
        }
        else if (e.getSource() == sameColourChange)
        {
            canvas.sameColourChange();
        }
        else
        {
            canvas.alienColourChange(alienName.getText());
        }
    }
}
