/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x0v20
 */
public class CurrentAccount {

    private float interestRate = 0.0008F;
    private float balance = 0.0F;
    
    public CurrentAccount(){
        balance = 0.0F;
    }
    //public CurrentAccount(float Value){
        
    //}

    public float getBalance() {
        return balance;
    }

    public void addInterest() {
        float interest = balance *  interestRate;
        balance = balance + interest; 
        
    }

    public void makeDeposit(float Value) {
        balance = balance + Value;
    }

}
