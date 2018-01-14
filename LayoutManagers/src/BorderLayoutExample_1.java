import java.awt.*;
import javax.swing.*;

public class BorderLayoutExample_1 extends JApplet
{
    private JButton[] myButton;
    
    public void init()
    {
        myButton = new JButton[5];
        for (int i=0; i<myButton.length; i++)
        {
            myButton[i] = new JButton("Button " + (i+1));
        }
        getContentPane().setBackground(new Color(0xfedcba));
        getContentPane().add(myButton[0], BorderLayout.NORTH);
        getContentPane().add(myButton[1], BorderLayout.SOUTH);
        getContentPane().add(myButton[2], BorderLayout.EAST);
        getContentPane().add(myButton[3], BorderLayout.WEST);
        getContentPane().add(myButton[4], BorderLayout.CENTER);
    }
}