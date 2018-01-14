import java.awt.*;
import javax.swing.*;

public class BoxLayoutExample_3 extends JApplet
{
    private JButton[] myButton;

    public void init()
    {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(new Color(0xfedcba));
        
        myButton = new JButton[5];
        for (int i = 0; i < myButton.length; i++)
        {
            String name = i%2==0 ? "Button " : "Long button name ";
            myButton[i] = new JButton(name + (i + 1));
            getContentPane().add(myButton[i]);
            getContentPane().add(Box.createVerticalStrut(5));
        }
    }
}