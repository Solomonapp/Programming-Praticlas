package birthday;



public class Birthday {

    public static void main(String[] args) {
        
        int population = 40;
        int experiments = 10000;

        int[] birthday = new int[population];

        for (int i = 0; i <experiments ; i++) {
            for (int s = 0; s <population ; s++) {

                birthday[s] = (int) Math.floor((Math.random() * 365.0) + 1);
            }
            int commonBirthdays = 0;
            for (int k = 0; k < population; k++) {

                for (int j = k + 1; j < population; j++) {

                    //System.out.println(birthday[k]);
                    if (birthday[k] == birthday[j]) {
                        commonBirthdays++;
                      
                    }
                   System.out.println("In " + experiments + " throws of a birthday " + commonBirthdays + " were sixes.");
        float doubleprobability = (float)commonBirthdays / experiments;
        System.out.println("Therefore, the probability of a 6 in a double throw of a die is " + doubleprobability + " (or " + (doubleprobability * 100.0) + " per cent).");
 
                }
            }
        }
        
        
    }
}
