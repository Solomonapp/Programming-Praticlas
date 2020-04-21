package uni;

import java.io.*;

/**
 *
 * @author x0v20
 */
public class Uni {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String input = null;
        int mark = 0;
        boolean validInput = true;
        do {
            System.out.print("Enter course mark (0-100): ");
            input = br.readLine();
            System.out.print("\n");
            try {
                mark = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Bad input data type.");
                validInput = false;
            }
            if (validInput) {
                if ((mark < 0) || (mark > 100)) {
                    System.out.println("Input out of [0, 100] range!.");
                    validInput = false;
                } else {
                    validInput = true;

                }

            }
        } while (!validInput);

    

        if (mark >= 70) {
            System.out.println("You got a firstclass ");
        }
        else if ((mark >=60 )) { //&& (mark >=60)){
            System.out.println("Second class, division 1 ");
                    }
        else if ((mark >=50 )) { //&& (mark >=50)){
            System.out.println("You got a secondclass, devision 2.2 ");
                    }
        else if ((mark >=40 )) { // && (mark >=40)){
            System.out.println("You got a Third class ");
                    }
        else if ((mark <40 )) { //&& (mark >=39)){
            System.out.println("You failed ");
                   }
    }
    
}
