import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ExampleJFrame extends JFrame implements ActionListener
{
    private AlienCanvas alienCanvas;
    private AlienCanvas crewCanvas;
    private JTextField alienName;
    private JButton addToCrew;
    private JButton reset;

    public ExampleJFrame(ArrayList<Alien> aliens)
    {
        super("GDM's crew picker example");

        setSize(400, 310);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        alienCanvas = new AlienCanvas(aliens);
        crewCanvas = new AlienCanvas(new ArrayList<Alien>());

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        getContentPane().setLayout(new BorderLayout(0, 10));
        getContentPane().setBackground(new Color(0xabcdef));

        JScrollPane northPane = setupNorthPane();
        JScrollPane centrePane = setupCentrePane();
        JPanel southPanel = setupSouthPanel();

        getContentPane().add(northPane, BorderLayout.NORTH);
        getContentPane().add(centrePane, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }

    private JScrollPane setupNorthPane()
    {
        JScrollPane jsp = new JScrollPane(alienCanvas,
                                          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.getViewport().setOpaque(false);
        jsp.setOpaque(false);
        return jsp;
    }

    private JScrollPane setupCentrePane()
    {
        JScrollPane jsp = new JScrollPane(crewCanvas,
                                          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.getViewport().setBackground(new Color(0xffeedc));
        return jsp;
    }

    private JPanel setupSouthPanel()
    {
        alienName = new JTextField(5);
        alienName.addActionListener(this);

        addToCrew = new JButton("Add to crew");
        addToCrew.addActionListener(this);

        reset = new JButton("Reset");
        reset.addActionListener(this);

        JPanel southPanel = new JPanel();
        southPanel.setOpaque(true);
        southPanel.add(new JLabel("Name:", JLabel.RIGHT));
        southPanel.add(alienName);
        southPanel.add(addToCrew);
        southPanel.add(reset);
        return southPanel;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reset)
        {
            crewCanvas.setAlienList(new ArrayList<Alien>());
            crewCanvas.revalidate();
            repaint();
        }
        else
        {
            if (!alienName.getText().isEmpty())
            {
                Alien a = alienCanvas.getAlien(alienName.getText());
                if (a != null)
                {
                    if (crewCanvas.addAlien(a))
                    {
                        crewCanvas.revalidate();
                        repaint();
                    }
                }
            }
        }
    }
}
