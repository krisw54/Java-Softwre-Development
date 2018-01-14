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
               
        super("Compass Program Extra");
       
        setSize(400, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.BLUE);
        
        getContentPane().setLayout(new GridLayout(3, 3, 5, 5));
        getContentPane().setBackground(Color.BLUE);
        
        myButton[0] = new JButton("Move to north-west");
        myButton[1] = new JButton("Move north");
        myButton[2] = new JButton("Move north-east");
        myButton[3] = new JButton("Move west");
        myButton[4] = new JButton("Move centre");
        myButton[5] = new JButton("Move to east");
        myButton[6] = new JButton("Move to south-west");
        myButton[7] = new JButton("Move to south");
        myButton[8] = new JButton("Move south-east");
        
        for (JButton b : myButton)
        {
           JPanel p = new JPanel(new FlowLayout());
           p.setOpaque(false);
           p.add(b);
           getContentPane().add(p);
           b.addActionListener(this);
        }
        setVisible(true);
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
