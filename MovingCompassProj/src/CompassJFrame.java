import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author chriswood
 */
public class CompassJFrame extends JFrame implements ActionListener {
    private JButton[] myButton = new JButton[5];
    private int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    public CompassJFrame()
    {
               
        super("Compass Program");
       
        
        setSize(400, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.BLUE);
        
        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.BLUE);
        
        myButton[0] = new JButton("Move North");
        myButton[1] = new JButton("Move South");
        myButton[2] = new JButton("Move East");
        myButton[3] = new JButton("Move West");
        myButton[4] = new JButton("Move Centre");
        
        for (JButton b : myButton)
        {
           b.addActionListener(this);
        }

        
        getContentPane().add(myButton[0], BorderLayout.NORTH);
        getContentPane().add(myButton[1], BorderLayout.SOUTH);
        getContentPane().add(myButton[2], BorderLayout.EAST);
        getContentPane().add(myButton[3], BorderLayout.WEST);
        getContentPane().add(myButton[4], BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == myButton[0])
        {
           setLocation((screenWidth - this.getWidth())/2, 0);
        }
        if (e.getSource() == myButton[1])
        {
           setLocation((screenWidth - this.getWidth())/2, screenHeight - this.getHeight() - 68);
        }
        if (e.getSource() == myButton[2])
        {
           setLocation(screenWidth - this.getWidth(), (screenHeight - this.getHeight())/2);
        }
        if (e.getSource() == myButton[3])
        {
           setLocation(0, (screenHeight - this.getHeight())/2);
        }
        if (e.getSource() == myButton[4])
        {
           setLocation((screenWidth- this.getWidth())/2, (screenHeight - this.getHeight())/2);
        }
    }
    
}
