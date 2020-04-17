/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x0v20
 */
public class SavingsAccount {

    private float interestRate = 0.004F;//savingsaccount atribute
    private float balance = 0.0F;

  public SavingsAccount(){
       balance = 0.0F;
   }

    SavingsAccount(float startBal) {
    balance = startBal;
    }
 
    public float getBalance() {
        return balance;
    }

    public void addInterest() {
        float interest =  interestRate * balance;
        balance = balance + interest; 
    }

    public void makeDeposit(float Value) {
        balance = balance + Value;
    }
}
