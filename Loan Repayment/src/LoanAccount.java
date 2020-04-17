/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x0v20
 */
public class LoanAccount {

    private float interestRate = 0.006F;
    private float balance = 0.0F;

   public LoanAccount(float loan) {
        balance = loan;
    }

    public float getBalance() {
        return balance;
    }

    public void addInterest() {
       float interest = balance *  interestRate;
        balance = balance + interest; 
    }
    void makePayment(float payment){
    balance = balance - payment;
    }
}
