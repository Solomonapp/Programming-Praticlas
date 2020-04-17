
import java.io.*;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        Poster myPoster = new Poster();  // Create new poster.

        float red, green, blue;
        int width = 84;
        int height = 59;
        Random rand = new Random();
        int x = 0;
        int y = 0;

        // Paint poster.
        for (x = 0; x < myPoster.width; x++) {
            for (y = 0; y < myPoster.height; y++) {
                red = (float)Math.random();
                green = (float)Math.random();
                blue =(float)Math.random();
             
                myPoster.setTileColour(1, 1, red, green, blue);

            }
            myPoster.displayAndSave();  // Display the image and write to file.
        }
    }
}
