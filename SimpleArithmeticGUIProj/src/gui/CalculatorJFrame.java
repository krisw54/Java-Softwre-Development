package gui;

import calculator.SimpleCalculator;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class CalculatorJFrame extends JFrame implements ActionListener, MouseListener
{
    JLabel display;
    private Color buttonBackground, oldBackground, memoryBackground;
    private Color normalBackground, errorBackground;
    private JButton memoryPlus;
    JButton[] buttons;
    private boolean pointPressed = false;
    private boolean operatorPressed = false;
    private SimpleCalculator calculator;
    private DecimalFormat sdf = new DecimalFormat("0.########");

    public CalculatorJFrame()
    {
        super("Chris's simple calculator");
        setSize(350, 370);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        calculator = new SimpleCalculator();

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        JPanel northP = setupNorthPanel();
        JPanel southP = setupSouthPanel();

        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().add(northP, BorderLayout.NORTH);
        getContentPane().add(southP, BorderLayout.SOUTH);
    }

    private JPanel setupNorthPanel()
    {
        display = new JLabel("0", JLabel.RIGHT);
        display.setOpaque(true);
        display.setFont(new Font("Courier", Font.BOLD, 60));

        normalBackground = display.getBackground();
        errorBackground = Color.RED;

        JPanel p = new JPanel(new GridLayout(1, 1));
        p.add(display);
        return p;
    }

    private JPanel setupSouthPanel()
    {
        Font buttonFont = new Font("Courier", Font.BOLD, 24);
        buttonBackground = (new JButton()).getBackground();
        memoryBackground = new Color(0xbbffbb);
        memoryPlus = setupButton("M+", buttonFont);

        buttons = new JButton[20];
        buttons[0] = setupButton("C", buttonFont);
        buttons[1] = memoryPlus;
        buttons[2] = setupButton("MC", buttonFont);
        buttons[3] = setupButton("MR", buttonFont);

        buttons[4] = setupButton("7", buttonFont);
        buttons[5] = setupButton("8", buttonFont);
        buttons[6] = setupButton("9", buttonFont);
        buttons[7] = setupButton("-", buttonFont);

        buttons[8] = setupButton("4", buttonFont);
        buttons[9] = setupButton("5", buttonFont);
        buttons[10] = setupButton("6", buttonFont);
        buttons[11] = setupButton("+", buttonFont);

        buttons[12] = setupButton("1", buttonFont);
        buttons[13] = setupButton("2", buttonFont);
        buttons[14] = setupButton("3", buttonFont);
        buttons[15] = setupButton("x", buttonFont);

        buttons[16] = setupButton("0", buttonFont);
        buttons[17] = setupButton(".", buttonFont);
        buttons[18] = setupButton("=", buttonFont);
        buttons[19] = setupButton("/", buttonFont);
        
        JPanel p = new JPanel(new GridLayout(5, 4, 10, 10));
        p.setOpaque(false);
        for (JButton b : buttons)
        {
            p.add(b);
        }

        return p;
    }

    private JButton setupButton(String text, Font f)
    {
        JButton btn = new JButton(text);
        btn.setFont(f);
        btn.addActionListener(this);
        btn.addMouseListener(this);

        return btn;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        JButton b = (JButton) e.getSource();
        oldBackground = b.getBackground();
        b.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        JButton b = (JButton) e.getSource();
        b.setBackground(oldBackground);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String buttonText = ((JButton) e.getSource()).getText();
        String strValue = display.getText();
        double value = 0;
        try
        {
            value = Double.parseDouble(strValue);
        }
        catch (NumberFormatException nfe){}

        if (buttonText.equals("C"))
        {
            calculator.clear();
            strValue = "0";
            pointPressed = false;
            operatorPressed = false;
            if (!memoryPlus.isEnabled())
            {
                for (int i=1; i<buttons.length; i++)
                {
                    buttons[i].setEnabled(true);
                }
            }
            display.setBackground(normalBackground);
        }
        else if (buttonText.equals("M+"))
        {
            if (value != 0)
            {
                calculator.addToMemory(strValue);
                oldBackground = memoryBackground;
                memoryPlus.setBackground(memoryBackground);
            }
        }
        else if (buttonText.equals("MC"))
        {
            calculator.clearMemory();
            memoryPlus.setBackground(buttonBackground);
        }
        else if (buttonText.equals("MR"))
        {
            strValue = "" + calculator.getMemory();
            if (strValue.indexOf(".") != -1 &&
                strValue.charAt(strValue.length()-1) == '0')
            {
                strValue = strValue.substring(0, strValue.length()-2);
            }
            if (operatorPressed)
            {
                calculator.setOperand2(strValue);
            }
            else
            {
                calculator.setOperand1(strValue);
            }
        }
        else if (buttonText.equals("+")
                 || buttonText.equals("-")
                 || buttonText.equals("x")
                 || buttonText.equals("/"))
        {
            operatorPressed = true;
            pointPressed = false;
            calculator.setOperator(buttonText.charAt(0));
            strValue = "0";
        }
        else if (buttonText.equals("="))
        {
            try
            {
                calculator.calculate();
                strValue = sdf.format(calculator.getResult());
                calculator.setOperand1(strValue);
            }
            catch (Exception ex)
            {
                strValue = "---";
                display.setBackground(errorBackground);
                for (int i=1; i<buttons.length; i++)
                {
                    buttons[i].setEnabled(false);
                }
            }
        }
        else if (buttonText.equals("."))
        {
            if (!pointPressed)
            {
                strValue += ".";
                pointPressed = true;
                if (operatorPressed)
                {
                    calculator.setOperand2(strValue);
                }
                else
                {
                    calculator.setOperand1(strValue);
                }
            }
        }
        else            // a digit button was pressed
        {
            if (!pointPressed && value == 0)
            {
                strValue = buttonText;
            }
            else
            {
                if (pointPressed
                    && strValue.indexOf(".") == strValue.length() - 2
                    && strValue.charAt(strValue.length() - 1) == '0')
                {
                    strValue = strValue.substring(0, strValue.length() - 1) + buttonText;
                }
                else
                {
                    strValue = buttonText + strValue;
                }
            }
            if (operatorPressed)
            {
                calculator.setOperand2(strValue);
            }
            else
            {
                calculator.setOperand1(strValue);
            }
        }

        display.setText(strValue);
    }
}
