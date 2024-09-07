import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int targetNumber = random.nextInt(100) + 1;
        int maxAttempts = 4;
        int attempts = 0;
        boolean guessedCorrectly = false;
        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.println("Guess a number between 1 and 100");
            int userguess = sc.nextInt();
            attempts++;
            if (userguess < targetNumber) {
                System.out.println("Two low");
            } else if (userguess > targetNumber) {
                System.out.println("Two high");
            } else {
                System.out.println("congratulations You've guessed the correct number");
                guessedCorrectly = true;
            }
        }
        if (!guessedCorrectly) {
            System.out.println("Sorry you've used all your attempts");
        }
        sc.close();
    }
}
