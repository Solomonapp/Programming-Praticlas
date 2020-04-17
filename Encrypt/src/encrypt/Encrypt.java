package encrypt;

import java.util.Random;


/**
 *
 * @author x0v20
 */

public class Encrypt {

    static void shuffle(String sequence) { //String
        Random rgen = new Random();

        char[] sequenceAsArray = sequence.toCharArray();

        for (int i = 0; i < sequenceAsArray.length; i++) {
            int randomPosition = rgen.nextInt(sequenceAsArray.length);
            char temp = sequenceAsArray[i];
            sequenceAsArray[i] = sequenceAsArray[randomPosition];
            sequenceAsArray[randomPosition] = temp;
        }

        System.out.println(new String(sequenceAsArray));
        //return new String(sequenceAsArray);
    }

    public static void main(String[] args) {
       
        String Text = "The IPCC's measured assessment shows that the world needs to"
                + "face up to the challenge of climate change, and to do so now";
        String Characters = "`1234567890-=+_)( *&^%$£\"QWERTYUIOP{}qwertyuiop[]ASDFGHJKL:@~asdfghjkl;'#|ZXCVBNM<>?\\zxcvbnm,./"; 
        String Key = " =)tvR-Ql]H_e8Twj5N`sadKAx;4|FO,C:\"B}&$YMPDJ(m%+p.?nifkS2U7q#3~L£c/hXWr6{y<ug@^>*0IE1[ZV9o'G\\bz ";

        String encodedtext = encode(Text, Characters, Key);
        System.out.println("En TEXT:\n" + encodedtext + "\n");
        
        //String dencodedtext = decode(Text, Characters, Key);
        //System.out.println("de TEXT:\n" + decode(dencodedtext, Characters, Key) +"\n");
   
           }

    public static String decode(String encodedtext, String Characters, String Key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
     public static String encode(String text, String Characters, String Key){
            String encryptedText ="";
            for(int i=0; i<text.length(); i++){
                //char checking = text.charAt(i);
            encryptedText = encryptedText + Key.charAt(Characters.indexOf(text.charAt(i)));
                    }
            return encryptedText;
        }


}
