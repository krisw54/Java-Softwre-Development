import java.awt.*;
import javax.swing.*;

public class GridLayoutExample_1 extends JApplet
{
    private JButton[] myButton;

    public void init()
    {
        getContentPane().setLayout(new GridLayout(4, 3, 20, 5));
        getContentPane().setBackground(new Color(0xfedcba));
        myButton = new JButton[10];
        for (int i = 0; i < myButton.length; i++)
        {
            myButton[i] = new JButton("Button " + (i + 1));
            getContentPane().add(myButton[i]);
        }
    }
}