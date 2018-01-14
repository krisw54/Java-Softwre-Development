import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author chriswood
 */
public class AlienColourDialog extends JDialog implements ActionListener {
    
    private JTextField alienName;
    private String prompt;
    private JButton OK, cancel;
    private Color[] colourBoxes;
    private ButtonGroup colourBoxesGroup;
    private boolean cancelled;
    private JRadioButton bColour;
    private Color rColour;
    private String missing;

    public AlienColourDialog(Frame owner, String title)
    {
        super(owner, title, true);
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.prompt = prompt;
        cancelled = true;
        
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
        alienName = new JTextField(10);
        
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Alien name: "));
        p1.add(alienName);
        JPanel p2 = new JPanel();
        p2.add(new JLabel("Body Colour: "));
        
        colourBoxes = new Color[Alien.COLOUR_PALETTE.length];
        
        colourBoxesGroup = new ButtonGroup();

        int i = 0;
        for (Color b : colourBoxes)
        {
            JRadioButton bu = new JRadioButton("");
            bu.setOpaque(true);
            bu.setBackground(Alien.COLOUR_PALETTE[i]);
            colourBoxesGroup.add(bu);
            bu.addActionListener(this);
            p2.add(bu);
            
            i++;
        }
        
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(p1);
        p.add(p2);
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
    
    public String getAlienName()
    {
        return cancelled ? null :  alienName.getText();
    }
    
    public Color getColourChoice()
    {
        return cancelled ? null : rColour;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        cancelled = e.getSource() == cancel;
        if (e.getSource() instanceof JRadioButton)
        {
            bColour = (JRadioButton)e.getSource();
        }
        else if (e.getSource() == OK)
        {
            if (alienName.getText().equalsIgnoreCase(""))
            {
                missing = "* Alien Name\n";
            }
            if (bColour == null)
            {
                missing += "* Alien Body Colour\n";
                String msg = "The following data as not been provided:\n" + missing;
                String title = "Error - Colour Missing";
                JOptionPane.showMessageDialog(this,
                                           msg,
                                           title,
                                           JOptionPane.ERROR_MESSAGE);
                missing ="";
            }
            else
            {
                missing ="";
                rColour = bColour.getBackground();
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        } 
        else if (e.getSource() == cancel)
        {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
         
    }
    
}
