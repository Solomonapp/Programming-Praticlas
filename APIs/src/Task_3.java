/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x0v20
 */

import java.io.*;
public class Task_3 {
    public static void main(String[] args) throws IOException{
         
        InputStreamReader isr = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader(isr);
        
   
        System.out.print("Enter number: ");
        String sometext = br.readLine();
        int number = Integer.parseInt(sometext); 
System.out.println(number + 100);

}
}