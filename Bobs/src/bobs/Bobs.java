package bobs;

public class Bobs {

    public static void main(String[] args) {

        //int age = 22;
        double salary = 26000.0; //Bob’s starting salary
        double yearlyIncrease = 300; // increase rate yearly 
        double mortgagePaymentcount = 0;
        int totalmortgagePayment = 480;
        double totalmortgage = 432000; //full mortgage 
        int monthlyexpenses = 750;//monthly
        double mortgage = 900;
        double savings = 0;
        int lastage = 65 - 1;
        double tax = 0;

        for (int age = 22; age <= 65; age++) {
            for (int month = 1; month <= 12; month++) {

                double reminder = salary/12.0;
                if (mortgagePaymentcount < totalmortgagePayment){
                    reminder -= mortgage;
                    mortgagePaymentcount++;}
                else if (mortgagePaymentcount == totalmortgagePayment){
                    System.out.println("Mortgage been Paid");
                    mortgagePaymentcount++;
                }
                reminder -= monthlyexpenses;
                savings += reminder;
                
                salary += yearlyIncrease;
                
               System.out.println(age + "years saving is " +savings);
                }
                

            }

        }
    }
