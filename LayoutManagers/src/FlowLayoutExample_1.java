import java.awt.*;
import javax.swing.*;

public class FlowLayoutExample_1 extends JApplet
{
    private JButton[] myButton;

    public void init()
    {
        getContentPane().setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(0xfedcba));
        
        myButton = new JButton[5];
        for (int i = 0; i < myButton.length; i++)
        {
            myButton[i] = new JButton("Button " + (i + 1));
            getContentPane().add(myButton[i]);
        }
    }
}