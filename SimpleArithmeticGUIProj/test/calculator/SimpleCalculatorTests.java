package calculator;

import org.junit.*;
import static org.junit.Assert.*;

public class SimpleCalculatorTests
{
    @Test
    public void test_UT1() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        assertNotNull("The calculator has not been created", c);

        assertEquals("The result should be zero", 0, c.getResult(), 0);
        assertEquals("The memory should be zero", 0, c.getMemory(), 0);

        c.setOperator('+');
        c.calculate();

        assertEquals("The result should be zero after the calculation", 0, c.getResult(), 0);
    }

    @Test
    public void test_UT2() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.setOperand1("3.6");
        c.setOperand2("5.5");
        c.setOperator('+');
        c.calculate();

        assertEquals("The result should be 9.1", 9.1, c.getResult(), 0);
    }

    @Test
    public void test_UT3() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('-');
        c.calculate();

        assertEquals("The result should be -2.5", -2.5, c.getResult(), 0);
    }

    @Test
    public void test_UT4() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('x');
        c.calculate();

        assertEquals("The result should be 16.5", 16.5, c.getResult(), 0);
    }

    @Test
    public void test_UT5() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.setOperand1("3");
        c.setOperand2("2");
        c.setOperator('/');
        c.calculate();

        assertEquals("The result should be 1.5", 1.5, c.getResult(), 0);
    }

    @Test (expected=Exception.class)
    public void test_UT6() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('*');
        c.calculate();
    }

    @Test (expected=Exception.class)
    public void test_UT7() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.setOperand1("3");
        c.setOperator('/');
        c.calculate();
    }

    @Test
    public void test_UT8() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('x');
        c.calculate();
        
        assertEquals("The result should be 16.5", 16.5, c.getResult(), 0);
        
        c.clear();
        
        assertEquals("The result should be 0", 0, c.getResult(), 0);
        
        c.setOperator('+');
        c.calculate();
        
        assertEquals("The result should be 0", 0, c.getResult(), 0);
    }

    @Test
    public void test_UT9() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.addToMemory("3");
        
        assertEquals("The value in memory should be 3.0", 3.0, c.getMemory(), 0);
    }

    @Test
    public void test_UT10() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();

        c.addToMemory("3");
        c.clearMemory();
        
        assertEquals("The value in memory should be 0", 0, c.getMemory(), 0);
    }
}
