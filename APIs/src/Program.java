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
public class Program {
    public static void main(String[] args) throws IOException{
         
        InputStreamReader isr = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader(isr);
        
        System.out.print("Enter some text: ");
        String text = br .readLine();
        
 System.out.println("The text contains " + text.length() +
" characters.");
 System.out.println(text.toUpperCase());
 System.out.println(text.toLowerCase());
 System.out.println(text.charAt(0));
 System.out.println(text.charAt(text.length() -1)); 
            }

}

