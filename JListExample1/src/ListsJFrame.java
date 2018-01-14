import java.awt.*;
import javax.swing.*;

public class ListsJFrame extends JFrame
{
    String[] fruit =
    {
        "Apples", "Oranges", "Bananas"
    };
    Player[] players =
    {
        new Player("Player 1"),
        new Player("Player 2"),
        new Player("Player 3"),
        new Player("Player 4"),
        new Player("Player 5")
    };
    
    JList fruitList;
    JList playerList;

    public ListsJFrame()
    {
        super("GDM's JList example 1");
        setSize(600, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        JPanel centreP = setupListPane();

        getContentPane().setBackground(new Color(0xfedcba));
        getContentPane().add(centreP, BorderLayout.CENTER);
    }

    private JPanel setupListPane()
    {
        JPanel fruitP = setupFruitPane();
        JPanel playerP = setupPlayerPane();

        JPanel p = new JPanel(new GridLayout(1, 2, 20, 0));
        p.setOpaque(false);
        p.add(fruitP);
        p.add(playerP);
        return p;
    }

    private JPanel setupFruitPane()
    {
        fruitList = new JList(fruit);
        JScrollPane jsp = new JScrollPane(fruitList);

        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Fruit"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);

        return p;
    }

    private JPanel setupPlayerPane()
    {
        playerList = new JList(players);
        JScrollPane jsp = new JScrollPane(playerList);

        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Players"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);

        return p;
    }
}
