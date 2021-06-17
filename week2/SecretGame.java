import java.util.Scanner;
import java.util.Random;

public class SecretGame {
    public static void main(String[] args) throws Exception {
        /**
         * This method starts the guessing game. It uses the java.util.Random class
         * to generate a random number. As the nextInt method in the Random class only
         * allows us to indicate an upper bound, we add one to the generated number
         * to make sure that the generated int is between 1 and 10
         * 
         *  */
        Random randomGen = new Random();
        int randomNum = randomGen.nextInt(10) + 1;
        boolean keepGuessing = true;
        Scanner keyboard = new Scanner(System.in);

        while (keepGuessing){
            System.out.println("Please choose a number between 1 and 10 or type quit:");
            String answerS = keyboard.nextLine();
            if (answerS.equalsIgnoreCase("quit")) {
                System.out.printf("You should try again, the answer was %d.%n", randomNum);
                keepGuessing = false;
            } else {
                int answer = Integer.parseInt(answerS);
                if (answer == randomNum){
                    keepGuessing = false;
                    System.out.printf("Yay! You guessed it. It was %d.%n", answer);
                } else if (answer > randomNum) {
                    System.out.println("Lower");
                } else if (answer < randomNum) {
                    System.out.println("Higher");
                }
            }
        }
    }
}