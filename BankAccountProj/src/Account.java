/**
 *
 * @author krisw
 */
public class Account {
    
    private String accountNumber;
    private double balance = 0;
    private double overdraft = 0;
    
    public void setAccountNumber(String accNo)
    {
        accountNumber = accNo;
    }
    
    public String getAccountNumber()
    {
        return accountNumber;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public void setOverdraft(double overD) 
    {
        overdraft = overD;
    }
    
    public double getOverdraft()
    {
        return overdraft;
    }
    
    public void deposit(double depos)
    {
        balance = balance + depos;
    }
    
    public boolean withdraw(double withd)
    {
        boolean yes  = false;
        if (balance + overdraft >= withd)
        {
            balance = balance - withd;
            yes = true;
        }
       return yes;
    }
}
