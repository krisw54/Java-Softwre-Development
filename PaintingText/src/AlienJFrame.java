import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlienJFrame extends JFrame implements ActionListener
{
    private AlienCanvas canvas;
    private JButton randomColourChange;
    private JButton sameColourChange;
    
    public AlienJFrame(Alien[] alien)
    {
        super("Painting text example");
        
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        canvas = new AlienCanvas(alien);
        
        getContentPane().setBackground(new Color(0xabcdef));
        getContentPane().add(canvas, BorderLayout.CENTER);
        
        createButtons();
        
        setVisible(true);
    }
    
    private void createButtons()
    {
        randomColourChange = new JButton("Random colours");
        randomColourChange.addActionListener(this);
        
        sameColourChange = new JButton("Same colour");
        sameColourChange.addActionListener(this);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(true);
        buttonPanel.add(randomColourChange);
        buttonPanel.add(sameColourChange);
        
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == randomColourChange)
        {
            canvas.randomColourChange();
        }
        else
        {
            canvas.sameColourChange();
        }
    }
}
