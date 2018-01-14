package calculator;

public class SimpleCalculator
{
    public final static char ADD_OPERATOR = '+';
    public final static char SUBTRACT_OPERATOR = '-';
    public final static char MULTIPLY_OPERATOR = 'x';
    public final static char DIVIDE_OPERATOR = '/';
    
    private double operand1, operand2;
    private double result;
    private char operator;
    private double memory;
    
    public SimpleCalculator()
    {
        operand1 = 0;
        operand2 = 0;
        result = 0;
        memory = 0;
        operator = ' ';
    }
    
    public void calculate() throws Exception
    {
        switch (operator)
        {
            case ADD_OPERATOR:
                result = operand1 + operand2;
                break;
            case SUBTRACT_OPERATOR:
                result = operand1 - operand2;
                break;
            case MULTIPLY_OPERATOR:
                result = operand1 * operand2;
                break;
            case DIVIDE_OPERATOR:
                if (operand2 == 0)
                {
                    throw new Exception("The divisor cannot be zero");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new Exception("Invalid operator");
        }
    }

    public void setOperand1(String stringValue) throws NumberFormatException
    {
        operand1 = Double.parseDouble(stringValue);
    }

    public void setOperand2(String stringValue) throws NumberFormatException
    {
        operand2 = Double.parseDouble(stringValue);
    }

    public boolean setOperator(char operator)
    {
        boolean operatorSet = false;
        
        switch (operator)
        {
            case ADD_OPERATOR:
            case SUBTRACT_OPERATOR:
            case MULTIPLY_OPERATOR:
            case DIVIDE_OPERATOR:
                this.operator = operator;
                operatorSet = true;
                break;
        }
            
        return operatorSet;
    }

    public void clear()
    {
        operand1 = 0;
        operand2 = 0;
        result = 0;
        operator = ' ';
    }

    public double getResult()
    {
        return result;
    }

    public void addToMemory(String stringValue)
    {
        memory += Double.parseDouble(stringValue);
    }

    public void clearMemory()
    {
        memory = 0;
    }

    public double getMemory()
    {
        return memory;
    }
}
