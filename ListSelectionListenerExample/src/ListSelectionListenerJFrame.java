import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListSelectionListenerJFrame extends JFrame implements ActionListener, ListSelectionListener
{
    String[] fruit =
    {
        "Apples", "Oranges", "Bananas", "Pears", "Lychees", "Cherries"
    };
    JList fruitList;
    JButton reset;
    
    private JTextArea log;

    public ListSelectionListenerJFrame()
    {
        super("GDM's order of valueChanged() calls");
        setSize(800, 400);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        JScrollPane logPanel = setupLogPanel();
        JPanel fruitPanel = setupFruitPanel();
        JPanel resetPanel = setupResetPanel();

        getContentPane().add(fruitPanel, BorderLayout.CENTER);
        getContentPane().add(logPanel, BorderLayout.EAST);
        getContentPane().add(resetPanel, BorderLayout.SOUTH);
    }

    private JPanel setupFruitPanel()
    {
        fruitList = new JList(fruit);
        fruitList.addListSelectionListener(this);
        JScrollPane jsp = new JScrollPane(fruitList);

        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Fruit"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);

        return p;
    }

    private JScrollPane setupLogPanel()
    {
        Font f = new Font("Console", Font.PLAIN, 20);

        log = new JTextArea("Report of valueChanged() calls\n", 5, 30);
        log.setFont(f);
        log.setOpaque(false);

        JScrollPane jsp = new JScrollPane(log);

        return jsp;
    }
    
    private JPanel setupResetPanel()
    {
        reset = new JButton("Reset");
        reset.addActionListener(this);

        JPanel p = new JPanel();
        p.add(reset);
        return p;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        log.append("\n    value adjusting: " + e.getValueIsAdjusting());
        if (!e.getValueIsAdjusting())
        {
            log.append("\n");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        fruitList.clearSelection();
    }
}
