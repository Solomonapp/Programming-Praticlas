

/**
 *
 * @author x0v20
 */
public class Application {

    public static void main(String[] args) {
        // John
        //variables for john
        float Johnmonthlyincome = 2000F; //Monthly income for john
        float Johnmonthlyexpense = 1200F; //monthly expenses
        float Johnpaymonthly = 200F; // monthly loan payment 
        int johnMonthcount = 0;
// This is johns account without any intrest or expencse
        LoanAccount JohnLoanAccount = new LoanAccount(20000F);
        CurrentAccount JohnCurrentAccount = new CurrentAccount();
//this while loop stops when there account reaches the month that they will finish paying thier loan
        while (JohnLoanAccount.getBalance() >= 0.0F) {

            Johnmonthlyincome = 2000F;// johns income 
            Johnmonthlyincome -= Johnpaymonthly; // this is johns income minus hos loan repayment
            JohnLoanAccount.makePayment(Johnpaymonthly);

            Johnmonthlyincome -= Johnmonthlyexpense;// this is john income mínus his monthly expenses such as bills and light
            JohnCurrentAccount.makeDeposit(Johnmonthlyincome);
            //end month
            JohnLoanAccount.addInterest();//this method adds loan intrest from the loanaccount class 
            JohnCurrentAccount.addInterest();//this method adds loan intrest from the loanaccount class to johns loan account account
            johnMonthcount++;
        //adds 1 to everymonth until johns payments reaches the while loop
        }
        // Mary
        //variables for mary
        float maryincome;
        float maryOutgoing = 1000F;
        float maryRepayment = 300F;
        int maryMonthcount = 0;
        
        LoanAccount MaryLoanAccount = new LoanAccount(20000F);
        SavingsAccount MarySavingsAccount = new SavingsAccount(100F);
        // this while loop stops when there account reaches the month that they will finish paying thier loan
        while (MaryLoanAccount.getBalance() >= 0.0F) {

        maryincome = 2000F;
        maryincome -= maryRepayment;// this is marys income minus hos loan repayment
        MaryLoanAccount.makePayment(maryRepayment);
        
        maryincome -= maryOutgoing;// this is mary income mínus his monthly expenses such as bills and light
        MarySavingsAccount.makeDeposit(maryincome);
        
        MaryLoanAccount.addInterest(); //this method adds loan intrest from the loanaccount class to marys savings account
        MarySavingsAccount.addInterest();
        maryMonthcount++;
        
        }
        // this statement produces john and mmarys payment of how long is gonn take them to pay their loan with thier given accounts
        System.out.println("John repaid his loan after " + johnMonthcount + " months. His current account balance at that time was £"+ JohnCurrentAccount.getBalance());
        System.out.println("Mary repaid his loan after " + maryMonthcount + " months. His current account balance at that time was £"+ MarySavingsAccount.getBalance());
}
    
    
    
    
    
}