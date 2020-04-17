package menu;

import java.io.*;

public class Menu {

    public double subTotal;
    private static double itemPrice;
    public static double runningTotal;
  
    

    public static void main(String[] args) throws IOException {
        System.out.println("PIZZA MENU  \n1. Cheese and tomato £6.00 \n2. Pepperoni and mozzarella £8.50\n3. Bacon and cheese £9.25 \n4. Chicken and mushroom £9.00 \n5. Hawaiian £7.25 ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String input = null;
        int foodItem = 0;
        int menu = 0;
        boolean validInput = true;
        double distance = 0;
        int miles;
        double deliveryfee;
        //String choice_string = null;

        System.out.print("What pizza would you like (? (1, 2, 3, 4 or 5) ");
        input = br.readLine();
        System.out.print("\n");
        //menu = Integer.parseInt(input);

        do {
            System.out.print("Enter order number: ");
            input = br.readLine();
            System.out.print("\n");

            try {
                menu = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Input order number 1 to 5! Please try again.");
                validInput = false;
            }

            if (validInput) {
                if ((menu < 1) || (menu > 5)) {
                    System.out.println("Input must be between 1 and 5! Please try again.");
                    validInput = false;
                } else {
                    validInput = true;
                }
            }

        } while (!validInput);

        System.out.print("You ordered a ");
        switch (menu) {

            case 1:
                System.out.println("Cheese and tomato");
                itemPrice = 6.00F;
                break;
            case 2:
                System.out.println("Pepperoni and mozzarella");
                itemPrice = 8.50F;
                break;
            case 3:
                System.out.println("Bacon and cheese");
                itemPrice = 9.25F;
                break;
            case 4:
                System.out.println("Chicken and mushroom");
                itemPrice = 9.00F;
                break;
            case 5:
                System.out.println("Chicken and mushroom");
                itemPrice = 7.25F;
                break;
        }
                System.out.println("Please enter your delivey distance ");
                miles = Integer.parseInt(br.readLine());
                
                if (miles <= 1 && miles >= 0){
                deliveryfee = 0;
                System.out.println("There is no delivery fee.");
                }
                else if (miles <= 3 && miles >= 1){
                deliveryfee = 3.00F;
                System.out.println("The delivery fee is £3 .");
                 }
                else if (miles <= 6 && miles >= 3){
                deliveryfee = 6.00F;
                System.out.println("The delivery fee is £6 .");
                 }

        }
    }


