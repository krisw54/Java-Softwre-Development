package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.*;
import javax.swing.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorJFrameTest
{
    private CalculatorJFrame f;
    private JButton[] digitButtons;

    /**
     * This method runs immediately before each test ensuring that
     * the starting point for each is the same
     */
    @Before
    public void setupCalculatorJFrame()
    {
        f = new CalculatorJFrame();
        digitButtons = findDigitButtons();
    }

    /**
     * This method runs immediately after each test ensuring that
     * the frame and its components are garbage-collected
     */
    @After
    public void disposeOfCalculatorJFrame()
    {
        f.setVisible(false);
        f.dispose();
    }

    /**
     * This method locates the button in the JFrame, if any, that has the 
     * specified text as its label
     * 
     * @param text The text to search for
     * @return The reference to any button that is found; {@code null} otherwise
     */
    private JButton findButton(String text)
    {
        JButton btn = null;

        for (int i = 0; btn == null && i < f.buttons.length; i++)
        {
            JButton b = f.buttons[i];
            if (b.getText().equals(text))
            {
                btn = b;
            }
        }

        return btn;
    }

    /**
     * This method locates all buttons in the JFrame that have a digit as 
     * its label
     * 
     * @return An array of JButton objects containing all buttons that have
     * a digit as its label
     */
    private JButton[] findDigitButtons()
    {
        JButton[] digitBtns =
        {
            findButton("0"),
            findButton("1"),
            findButton("2"),
            findButton("3"),
            findButton("4"),
            findButton("5"),
            findButton("6"),
            findButton("7"),
            findButton("8"),
            findButton("9")
        };
        return digitBtns;
    }

    /**
     * This test method ensures that the GUI structure is correct. 
     * <ul>
     *   <li>There is a JLabel object in the north panel</li>
     *   <li>There are 20 JButton objects in the south panel with the 
     *       correct labels in the correct order</li>
     * </ul>
     */
    @Test
    public void test_GUI_structure()
    {
        /* 
         * Test the structure of the north panel
         */
        Component panel = f.getContentPane().getComponent(0);
        assertTrue("panel should be a JPanel object", panel instanceof JPanel);

        JPanel northP = (JPanel) panel;
        Component label = northP.getComponent(0);
        assertTrue("label should be a JLabel object", label instanceof JLabel);

        /* 
         * Test the structure of the south panel
         */
        List<String> expectedStrings = Arrays.asList("C", "M+", "MC", "MR",
                                                     "7", "8", "9", "+",
                                                     "4", "5", "6", "-",
                                                     "1", "2", "3", "x",
                                                     "0", ".", "=", "/");
        List<String> actualStrings = new ArrayList<String>();

        panel = f.getContentPane().getComponent(1);
        assertTrue("panel should be a JPanel object", panel instanceof JPanel);

        JPanel southP = (JPanel) panel;
        Component[] buttons = southP.getComponents();

        for (Component c : buttons)
        {
            assertTrue("c should be a JButton object", c instanceof JButton);

            JButton b = (JButton) c;

            assertTrue("The button text should be valid", expectedStrings.contains(b.getText()));

            actualStrings.add(b.getText());
        }

        assertEquals("The buttons should be in the correct order", expectedStrings, actualStrings);
    }

    /**
     * This test method ensures that the digit buttons cause the 
     * correct display in the JLabel
     */
    @Test
    public void test_displayOfDigits()
    {
        digitButtons[1].doClick();
        assertEquals("display should be '1'", "1", f.display.getText());
        
        digitButtons[2].doClick();
        assertEquals("display should be '12'", "12", f.display.getText());
        
        digitButtons[3].doClick();
        assertEquals("display should be '123'", "123", f.display.getText());
        
        digitButtons[4].doClick();
        assertEquals("display should be '1234'", "1234", f.display.getText());
        
        digitButtons[5].doClick();
        assertEquals("display should be '12345'", "12345", f.display.getText());
        
        digitButtons[6].doClick();
        assertEquals("display should be '123456'", "123456", f.display.getText());
        
        digitButtons[7].doClick();
        assertEquals("display should be '1234567'", "1234567", f.display.getText());
        
        digitButtons[8].doClick();
        assertEquals("display should be '12345678'", "12345678", f.display.getText());
        
        digitButtons[9].doClick();
        assertEquals("display should be '123456789'", "123456789", f.display.getText());
        
        digitButtons[0].doClick();
        assertEquals("display should be '1234567890'", "1234567890", f.display.getText());
    }

    /**
     * This test method ensures that the decimal-point button causes the 
     * correct display in the JLabel
     */
    @Test
    public void test_displayOfDecimalPointDigits()
    {
        digitButtons[1].doClick();
        digitButtons[2].doClick();
        findButton(".").doClick();
        assertEquals("display should be '12.0'", "12.0", f.display.getText());
        
        digitButtons[5].doClick();
        assertEquals("display should be '12.5'", "12.5", f.display.getText());
        
        digitButtons[8].doClick();
        assertEquals("display should be '12.58'", "12.58", f.display.getText());
    }

    /**
     * This test method ensures that
     * <ul>
     *   <li>the addition button causes the correct display in the JLabel</li>
     *   <li>the equals button causes the correct display in the JLabel</li>
     * </ul>
     */
    @Test
    public void test_addition()
    {
        digitButtons[1].doClick();
        digitButtons[2].doClick();
        findButton(".").doClick();
        digitButtons[5].doClick();
        assertEquals("display should be '12.5'", "12.5", f.display.getText());
        
        findButton("+").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
        
        digitButtons[8].doClick();
        assertEquals("display should be '8'", "8", f.display.getText());
        
        findButton("=").doClick();
        assertEquals("display should be '20.5'", "20.5", f.display.getText());
    }

    /**
     * This test method ensures that
     * <ul>
     *   <li>the subtraction button causes the correct display in the JLabel</li>
     *   <li>the equals button causes the correct display in the JLabel</li>
     * </ul>
     */
    @Test
    public void test_subtraction()
    {
        digitButtons[1].doClick();
        digitButtons[2].doClick();
        findButton(".").doClick();
        digitButtons[5].doClick();
        findButton("-").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
        
        digitButtons[1].doClick();
        digitButtons[8].doClick();
        findButton("=").doClick();
        assertEquals("display should be '-5.5'", "-5.5", f.display.getText());
    }

    /**
     * This test method ensures that
     * <ul>
     *   <li>the multiplication button causes the correct display in the JLabel</li>
     *   <li>the equals button causes the correct display in the JLabel</li>
     * </ul>
     */
    @Test
    public void test_multiplication()
    {
        digitButtons[1].doClick();
        digitButtons[2].doClick();
        findButton(".").doClick();
        digitButtons[5].doClick();
        findButton("x").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
        
        findButton(".").doClick();
        digitButtons[5].doClick();
        findButton("=").doClick();
        assertEquals("display should be '6.25'", "6.25", f.display.getText());
    }

    /**
     * This test method ensures that
     * <ul>
     *   <li>the division button causes the correct display in the JLabel</li>
     *   <li>the equals button causes the correct display in the JLabel</li>
     * </ul>
     */
    @Test
    public void test_division()
    {
        digitButtons[1].doClick();
        digitButtons[2].doClick();
        findButton(".").doClick();
        digitButtons[5].doClick();
        findButton("/").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
        
        digitButtons[2].doClick();
        findButton("=").doClick();
        assertEquals("display should be '6.25'", "6.25", f.display.getText());
    }

    /**
     * This test method ensures that pressing the equals button twice without
     * any other button press in between causes the last operation to be
     * performed again with
     * <ul>
     *   <li>operand1 = the total from the previous operation</li>
     *   <li>operand2 = operand2 from the previous operation</li>
     * </ul>
     */
    @Test
    public void test_two_equals()
    {
        digitButtons[1].doClick();
        digitButtons[2].doClick();
        findButton(".").doClick();
        digitButtons[5].doClick();
        findButton("+").doClick();
        digitButtons[3].doClick();
        findButton("=").doClick();
        assertEquals("display should be '15.5'", "15.5", f.display.getText());
        findButton("=").doClick();
        assertEquals("display should be '18.5'", "18.5", f.display.getText());
    }

    /**
     * This test method ensures that the clear button
     * <ul>
     *   <li>resets the display to zero</li>
     *   <li>causes the underlying calculator to be reset</li>
     * </ul>
     */
    @Test
    public void test_clear()
    {
        digitButtons[1].doClick();
        findButton("+").doClick();
        digitButtons[3].doClick();
        findButton("=").doClick();
        assertEquals("display should be '4'", "4", f.display.getText());
        
        findButton("C").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
        
        findButton("=").doClick();
        assertEquals("display should be '---'", "---", f.display.getText());
        assertEquals("display background should be red", Color.RED, f.display.getBackground());

        findButton("C").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
        assertFalse("display background should not be red", f.display.getBackground().equals(Color.RED));
        
        digitButtons[2].doClick();
        findButton("+").doClick();
        digitButtons[6].doClick();
        findButton(".").doClick();
        digitButtons[4].doClick();
        findButton("=").doClick();
        assertEquals("display should be '8.4'", "8.4", f.display.getText());
    }

    /**
     * This test method ensures that the memory function buttons perform
     * correctly
     */
    @Test
    public void test_memory_functions()
    {
        digitButtons[1].doClick();
        findButton("+").doClick();
        digitButtons[3].doClick();
        findButton("=").doClick();
        assertEquals("display should be '4'", "4", f.display.getText());
        JButton btn = findButton("M+");
        btn.doClick();
        assertEquals("display should be '4'", "4", f.display.getText());
        assertEquals("M+ button should be light green", new Color(0xbbffbb), btn.getBackground());
        
        findButton("C").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
        assertEquals("M+ button should be light green", new Color(0xbbffbb), btn.getBackground());
        
        digitButtons[3].doClick();
        findButton("+").doClick();
        findButton("MR").doClick();
        assertEquals("display should be '4'", "4", f.display.getText());
        findButton("=").doClick();
        assertEquals("display should be '7'", "7", f.display.getText());
        assertEquals("M+ button should be light green", new Color(0xbbffbb), btn.getBackground());

        findButton("MC").doClick();
        assertEquals("display should be '7'", "7", f.display.getText());
        assertFalse("M+ button should not be light green", btn.getBackground().equals(new Color(0xbbffbb)));

        findButton("MR").doClick();
        assertEquals("display should be '0'", "0", f.display.getText());
    }
}
