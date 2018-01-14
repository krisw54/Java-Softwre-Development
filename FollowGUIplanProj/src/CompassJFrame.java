import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author chriswood
 */
public class CompassJFrame extends JFrame implements ActionListener {
    private JButton[] myButton = new JButton[9];
    private int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    public CompassJFrame()
    {
               
        super("Compass Program GUI");
       
        setSize(500, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        setupGUI();

        for (JButton b : myButton)
        {
           b.addActionListener(this);
        }
        
        setVisible(true);
    }
    
    private JPanel setupSouthPanel()
    {
        myButton[6] = new JButton("Move to south-west");
        myButton[7] = new JButton("Move to south");
        myButton[8] = new JButton("Move to south-east");

        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
        south.setOpaque(false);
        south.add(myButton[6]);
        south.add(Box.createVerticalStrut(10));
        south.add(Box.createGlue());
        south.add(myButton[7]);
        south.add(Box.createVerticalStrut(10));
        south.add(Box.createGlue());
        south.add(myButton[8]);
        return south;
    }
    
    private JPanel setupNorthPanel()
    {
        myButton[0] = new JButton("Move to north-west");
        myButton[1] = new JButton("Move to north");
        myButton[2] = new JButton("Move to north-east");
        
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
        north.setOpaque(false);
        north.add(myButton[0]);
        north.add(Box.createVerticalStrut(10));
        north.add(Box.createGlue());
        north.add(myButton[1]);
        north.add(Box.createVerticalStrut(10));
        north.add(Box.createGlue());
        north.add(myButton[2]);
        return north;
    }
    
    private JPanel setupCentrePanel()
    {
        myButton[3] = new JButton("Move to west");
        myButton[4] = new JButton("Move to centre");
        myButton[5] = new JButton("Move to east");
        
        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.X_AXIS));
        centre.setOpaque(false);
        centre.add(myButton[3]);
        centre.add(Box.createVerticalStrut(10));
        centre.add(Box.createGlue());
        centre.add(myButton[4]);
        centre.add(Box.createVerticalStrut(10));
        centre.add(Box.createGlue());
        centre.add(myButton[5]);
        return centre;
    }
    
    private void setupGUI()
    {
        JPanel northPanel = setupNorthPanel();
        JPanel centrePanel = setupCentrePanel();
        JPanel southPanel = setupSouthPanel();
        
        getContentPane().setBackground(new Color(0x1f497d));
        getContentPane().setLayout(new BorderLayout(10, 10));
        
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centrePanel, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
       
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == myButton[0])
        {
         setLocation(0,0);   
        }
        if (e.getSource() == myButton[1])
        {
           //North
            setLocation((screenWidth - this.getWidth())/2, 0);            
        }
        if (e.getSource() == myButton[2])
        {
            setLocation(screenWidth - this.getWidth(),0);
        }
        if (e.getSource() == myButton[3])
        {
           //West
            setLocation(0, (screenHeight - this.getHeight())/2);
        }
        if (e.getSource() == myButton[4])
        {
           //Centre
            setLocation((screenWidth- this.getWidth())/2, (screenHeight - this.getHeight())/2);
        }
        
        if (e.getSource() == myButton[5])
        {
           //East
            setLocation(screenWidth - this.getWidth(), (screenHeight - this.getHeight())/2);  
        }
        if (e.getSource() == myButton[6])
        {
          setLocation(0,screenHeight - this.getHeight() - 68);
        }
        if (e.getSource() == myButton[7])
        {
         //South
           setLocation((screenWidth - this.getWidth())/2, screenHeight - this.getHeight() - 68);  
        }
        if (e.getSource() == myButton[8])
        {
           setLocation(screenWidth - this.getWidth(),(screenHeight - this.getHeight())-68);
        }
    }
    
}
