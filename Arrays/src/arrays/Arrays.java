package arrays;

/**
 *
 * @author x0v20
 */
public class Arrays {

    public static void main(String[] args) {
        int die[] = new int[13];
        Die die1 = new Die();
        Die die2 = new Die();

        long experiments = 10000;

        for (int i = 0; i <= experiments; i++) {

            die1.roll();
            die2.roll();

            int sum = die1.outcome + die2.outcome;

            die[sum]++;
        }
        int max = 0;
        int imax = 0;

        for (int i = 2; i < 13; i++) {
            System.out.println(i + " the outcome is " + die[i]);
            if (max <= die[i]) {
                imax = i;
                max = die[i];
                
            }
        }
    }

}

