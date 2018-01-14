/**
 *
 * @author krisw
 */
public class TestAccount {
    
    public static void main(String[] args) {
        
        Account myAccount  = new Account();
        
        myAccount.setAccountNumber("4545332");
        printDetails (myAccount);
        
        myAccount.deposit(50.00);
        printDetails (myAccount);
        
        myAccount.withdraw(50.00);
        printDetails (myAccount);
        
        myAccount.deposit(50.00);
        printDetails (myAccount);
        
        if (myAccount.withdraw(50.01))
        {
            System.out.println("Success!\n");
            printDetails (myAccount);
        }
        else
        {
            System.out.println("Sorry!\nYou Dont Have Enough Money To Widthdraw:");
            System.out.println("Not Sucessfull!\n");
        }
        
        myAccount.setOverdraft(150.00);
        printDetails (myAccount);
        
        myAccount.deposit(50.00);
        printDetails (myAccount);
        
        if (myAccount.withdraw(50.01))
        {
            System.out.println("Success!\n");
            printDetails (myAccount);
        }
        else
            System.out.println("Not Sucessfull!\n");
        
    }
    
    public static void printDetails(Account acc1)
    {
        System.out.println("Account Number is: " + acc1.getAccountNumber());
        System.out.println("Balance is: £" + acc1.getBalance());
        System.out.println("Overdraft is: £" + acc1.getOverdraft());
        System.out.println("");
    }      
       
}
