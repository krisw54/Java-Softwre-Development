import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ExampleJFrame extends JFrame implements ActionListener, WindowListener
{
    private static Color FIRST_BACKGROUND = new Color(0xffeedc);
    private ArrayList<Alien> aliens;
    private AlienCanvas alienCanvas;
    private JMenuItem exitApp, changeBackground, resetBackground, clearDisplay;
    private JMenu viewMenu;
    private JScrollPane scrollPane;
    
    public ExampleJFrame(ArrayList<Alien> aliens)
    {
        super("GDM's Menu example");
        this.aliens = aliens;

        setSize(300, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);

        alienCanvas = new AlienCanvas(new ArrayList<Alien>());

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        setJMenuBar(setupMenuBar());
        getContentPane().setLayout(new BorderLayout(0, 10));
        getContentPane().setBackground(new Color(0xabcdef));

        JScrollPane centrePane = setupCentrePane();

        getContentPane().add(centrePane, BorderLayout.CENTER);
    }

    private JScrollPane setupCentrePane()
    {
        scrollPane = new JScrollPane(alienCanvas,
                                          JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                          JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getViewport().setBackground(FIRST_BACKGROUND);
        return scrollPane;
    }

    public void actionPerformed(ActionEvent e)
    {
        JMenuItem item = (JMenuItem) e.getSource();
        if (item == changeBackground)
        {
            Color bg = JColorChooser.showDialog(this, 
                                                "Choose background colour", 
                                                scrollPane.getViewport().getBackground());
            if (bg != null)
            {
                scrollPane.getViewport().setBackground(bg);
            }
        }
        else if (item == resetBackground)
        {
            scrollPane.getViewport().setBackground(FIRST_BACKGROUND);
        }
        else if (item == clearDisplay)
        {
            alienCanvas.setAlienList(new ArrayList<Alien>());
            alienCanvas.revalidate();
            repaint();
        }
        else if (item == exitApp)
        {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        else
        {
            Alien a = null;
            int i = 0;

            while (a == null && i < aliens.size())
            {
                if (aliens.get(i).getName().equalsIgnoreCase(item.getText()))
                {
                    a = aliens.get(i);
                }
                i++;
            }

            if (a != null)
            {
                alienCanvas.addAlien(a);
                alienCanvas.revalidate();
                repaint();
            }
        }
    }

    private String[] getAlienNames()
    {
        String[] names = new String[aliens.size()];
        
        for (int i=0; i<names.length; i++)
        {
            names[i] = aliens.get(i).getName();
        }
        
        return names;
    }

    private JMenuBar setupMenuBar()
    {
        JMenu appMenu = setupApplicationMenu();
        viewMenu = setupViewMenu();

        JMenuBar bar = new JMenuBar();
        bar.add(appMenu);
        bar.add(viewMenu);
        return bar;
    }

    private JMenu setupViewMenu()
    {
        JMenu menu = new JMenu("View");
        menu.setMnemonic(KeyEvent.VK_V);

        for (String name : getAlienNames())
        {
            JMenuItem jmi = new JMenuItem(name);
            jmi.addActionListener(this);
            menu.add(jmi);
        }

        return menu;
    }

    private JMenu setupBackgroundMenu()
    {
        changeBackground = new JMenuItem("Change background");
        changeBackground.setMnemonic(KeyEvent.VK_B);
        changeBackground.addActionListener(this);
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        changeBackground.setAccelerator(key);

        resetBackground = new JMenuItem("Reset background");
        resetBackground.setMnemonic(KeyEvent.VK_R);
        resetBackground.addActionListener(this);
        key = KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        resetBackground.setAccelerator(key);

        JMenu menu = new JMenu("Background");
        menu.setMnemonic(KeyEvent.VK_B);
        menu.add(changeBackground);
        menu.add(resetBackground);

        return menu;
    }

    private JMenu setupApplicationMenu()
    {
        JMenu bgMenu = setupBackgroundMenu();

        clearDisplay = new JMenuItem("Clear display");
        clearDisplay.setMnemonic(KeyEvent.VK_C);
        clearDisplay.addActionListener(this);
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        clearDisplay.setAccelerator(key);

        exitApp = new JMenuItem("Exit");
        exitApp.setMnemonic(KeyEvent.VK_X);
        exitApp.addActionListener(this);
        key = KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        exitApp.setAccelerator(key);

        JMenu menu = new JMenu("Application");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.add(bgMenu);
        menu.add(clearDisplay);
        menu.addSeparator();
        menu.add(exitApp);
        return menu;
    }

    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowClosing(WindowEvent e)
    {
        String title = "Confirm exit";
        String msg = "Are you sure you want to exit?";
        int option = JOptionPane.showConfirmDialog(this,
                                                   msg,
                                                   title,
                                                   JOptionPane.YES_NO_OPTION,
                                                   JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
}
