import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ExampleJFrame extends JFrame
{
    private AlienCanvas alienCanvas;

    public ExampleJFrame(ArrayList<Alien> aliens)
    {
        super("GDM's Abstract aliens example");

        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        alienCanvas = new AlienCanvas(aliens);

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        getContentPane().setLayout(new BorderLayout(0, 10));
        getContentPane().setBackground(new Color(0xabcdef));
        
        JScrollPane centrePane = setupCentrePanel();

        getContentPane().add(centrePane, BorderLayout.CENTER);
    }

    private JScrollPane setupCentrePanel()
    {
        JScrollPane jsp = new JScrollPane(alienCanvas,
                                          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.getViewport().setBackground(new Color(0xffeedc));
        return jsp;
    }
}
