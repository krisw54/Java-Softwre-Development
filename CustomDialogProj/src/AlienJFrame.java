import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlienJFrame extends JFrame implements ActionListener
{
    private AlienCanvas canvas;
    private JButton randomColourChange;
    private JButton sameColourChange;
    private JButton alienColourChange;
    private JButton helpBut;
    private JTextField alienName;
    private String[] name;

    public AlienJFrame(Alien[] alien)
    {
        super("Message dialogs");

        setSize(420, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new AlienCanvas(alien);

        getContentPane().setBackground(new Color(0xabcdef));
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(setupSouthPanel(), BorderLayout.SOUTH);

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
        
        helpBut = new JButton("Help");
        helpBut.addActionListener(this);

        alienName = new JTextField(5);

        JPanel p = new JPanel();
        p.setOpaque(true);
        //p.add(new JLabel("Alien name:", JLabel.RIGHT));
        //p.add(alienName);
        p.add(alienColourChange);
        p.add(helpBut);
        return p;
    }
    
//    private String[] inputName()
//    {
//       String nameTitle = "Change Alien Colour";
//       AlienColourDialog dialog = new AlienColourDialog(null, nameTitle);
//       return dialog.getUsername();
//    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == randomColourChange)
        {
            canvas.randomColourChange();
        }
        else if (e.getSource() == helpBut)
        {
        String msg = "To Change the aliens body colour:\n*enter the alien's name in the text box\n*click the \"Change alien colour  button\"";
        String title = "Help - Change Colours";
        JOptionPane.showMessageDialog(this,
                                           msg,
                                           title,
                                           JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getSource() == sameColourChange)
        {
            canvas.sameColourChange();
        }
        else
        {
            if (name == null)
            {
                 String nameTitle = "Change Alien Colour";
                 AlienColourDialog dialog = new AlienColourDialog(null, nameTitle);
                 Color c = dialog.getColourChoice();
                 String s = dialog.getAlienName();
                try
                {
                   //canvas.alienColourChange(name);
                   canvas.alienColourChange(s, c);
                   System.out.println(c + s);
                   name = null;
                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                    name = null;
                }
            }
        }
    }
}
