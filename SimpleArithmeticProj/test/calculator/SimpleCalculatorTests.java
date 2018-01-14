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

        assertEquals("The result of the calculation is 9.1", 9.1, c.getResult(), 0.01);
    }
    
    @Test
    public void test_UT3() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('-');
        
        c.calculate();

        assertEquals("The result of the calculation is -2.5", -2.5, c.getResult(), 0.01);
    }
    
    @Test
    public void test_UT4() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('x');
        
        c.calculate();

        assertEquals("The result of the calculation is 16.5", 16.5, c.getResult(), 0.01);
    }
    
    @Test
    public void test_UT5() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.setOperand1("3");
        c.setOperand2("2");
        c.setOperator('/');
        
        c.calculate();

        assertEquals("The result of the calculation is 1.5", 1.5, c.getResult(), 0.01);
    }
    
    @Test (expected=Exception.class)
    public void test_UT6() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('*');
        
        c.calculate();
        
        assertEquals("The calculation is not performed", 0, c.getResult(), 0);

    }
    
    @Test (expected=Exception.class)
    public void test_UT7() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.setOperand1("3");
        c.setOperator('/');
        
        c.calculate();
        
        assertEquals("The calculation is not performed", 0, c.getResult(), 0);
    }
    
    @Test
    public void test_UT8() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.setOperand1("3");
        c.setOperand2("5.5");
        c.setOperator('x');
        
        c.calculate();

        assertEquals("After (1), the result is 16.5", 16.5, c.getResult(), 0.01);
        
        c.clear();
        
        assertEquals("After (2), the result is zero", 0, c.getResult(), 0);
        
        c.setOperator('+');
        assertEquals("After (3), the result is zero", 0, c.getResult(), 0);
    }
    
    @Test
    public void test_UT9() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.addToMemory("3");
        c.getMemory();
        
        assertEquals("The value in memory is 3", 3, c.getMemory(), 0);
    }
    
    @Test
    public void test_UT10() throws Exception
    {
        SimpleCalculator c = new SimpleCalculator();
        
        c.addToMemory("3");
        c.clearMemory();
        
        assertEquals("The value in memory is zero", 0, c.getMemory(), 0);
    }
}
