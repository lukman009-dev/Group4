
/**
 * Write a description of class Exercise9_NumberGuessingGame here.
 *
 * @author LUKMAN KHAMIS MUSSA 24BIA009
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random;

public class Exercise9_NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //THE EXTENSION CHALLENGE

        System.out.println("===Number Guessing Game==\n");

        boolean playAgain= true;

        while (playAgain) {

            // DIFFICULTY LEVEL 
            System.out.println("Choose difficulty level:");
            System.out.println("1- Easy(1 to 50)");
            System.out.println("2- Normal(1 to 100)");
            System.out.println("3- Hard(1 to 1000)");
            System.out.print("Enter choice (1-3): ");
            int level = scanner.nextInt();
            int maxNumber;
            if (level == 1) {
                maxNumber = 50; } 
                else if (level == 2) {
                maxNumber = 100;     }
                else {maxNumber = 1000;
            }

            System.out.println("\nI am thinking of a number between 1 and" + maxNumber + ".");
            System.out.println("Try to guess it!\n");

            // Generate number based on difficulty
            int secretNumber = random.nextInt(maxNumber) + 1;
            int guess = 0;
            int attempts = 0;

            // TO ADD MAXIMUM ATTEMPTS 
            int maxAttempts = 10;

            // Game loop
            while (guess != secretNumber && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.\n");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.\n");
                } else {
                    System.out.println("\n🎉 Congratulations!");
                    System.out.println("You guessed it in " + attempts + " attempts!");

                    // Rating based on attempts
                    if (attempts <= 5) {
                        System.out.println("Rating:Excellent! You're a mind reader!");
                    } else if (attempts <= 10) {
                        System.out.println("Rating: Good job!");
                    } else {
                        System.out.println("Rating:You got it eventually!");
                    }
                }
            }

            // If user fails within max attempts
            if (guess != secretNumber) {
                System.out.println("\n Game Over! You used all " +maxAttempts + " attempts.");
                System.out.println("The correct number was: " +secretNumber);
            }

            // TO PLAY AGAIN WITHOUT RESTART
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response =scanner.next();

            if (!response.equalsIgnoreCase("yes")) {
                playAgain =false;
                System.out.println("Thanks for playing!");
            }

            System.out.println();
        }

        scanner.close();
    }
}
