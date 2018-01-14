import java.awt.*;
import javax.swing.*;

public class ListsJFrame extends JFrame
{
    String[] fruit = {"Apples", "Oranges", "Bananas", "Pears", "Cucumbers", "Tomatoes", "Cherries", "Pumpkins"};
    String[] animals = {"Pigs", "Cows", "Sheep", "Chickens", "Ducks", "Geese", "Goats"};
    String[] stationery = {"Pens", "Pencils", "Notepads", "Stickers", "Erasers"};
    
    JList fruitList;
    JList animalList;
    JList stationeryList;
    
    public ListsJFrame()
    {
        super("GDM's JList comparison");
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
        JPanel animalP = setupAnimalPane();
        JPanel stationeryP = setupStationeryPane();
        
        JPanel p = new JPanel(new GridLayout(1, 3, 20, 0));
        p.setOpaque(false);
        p.add(fruitP);
        p.add(animalP);
        p.add(stationeryP);
        return p;
    }
    
    private JPanel setupFruitPane()
    {
        fruitList = new JList(fruit);
        fruitList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane jsp = new JScrollPane(fruitList);
        
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Fruit"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel setupAnimalPane()
    {
        animalList = new JList(animals);
        animalList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane jsp = new JScrollPane(animalList);
        
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Animals"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel setupStationeryPane()
    {
        stationeryList = new JList(stationery);
        stationeryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jsp = new JScrollPane(stationeryList);
        
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(new JLabel("Stationery"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);
        
        return p;
    }
}
