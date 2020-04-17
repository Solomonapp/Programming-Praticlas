package date.form;

import java.util.Date;

/**
 *
 * @author x0v20
 */
public class DateForm {

    public static void main(String[] args) {
        // TODO code application logic here
        Date timestamp = new Date();
        String timestampAsString = timestamp.toString();
        System.out.println(timestampAsString);
    }

    static String getDayString(String dateString) {
        String[] words = dateString.split(" ");
        
        if (words[0].equals("Mon")){
        return "Monday";} 
        else if(words[0].equals("Tue")){
            return "Tuesday";}
        else if(words[0].equals("Wed")){
            return "Wednesday";}
        else if(words[0].equals("Thu")){
            return "Thursday";}
        else if(words[0].equals("Fri")){
            return "Friday";}
        else if(words[0].equals("Sat")){
            return "Saturday";}
        else if(words[0].equals("Sun")){
            return "Sunday";}
        
    return null;
    }
    
    

}
