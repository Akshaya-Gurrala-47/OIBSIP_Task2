import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int round = 1;
        char playAgain;

        System.out.println("=== Guess The Number Game ===");

        do {

            int number = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    guessed = true;
                    break;
                }

                else if (guess > number) {
                    System.out.println("Too High!");
                }

                else {
                    System.out.println("Too Low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            int score = 0;

            if (guessed) {

                if (attempts <= 2)
                    score = 100;
                else if (attempts <= 4)
                    score = 70;
                else if (attempts <= 6)
                    score = 50;
                else
                    score = 30;

                System.out.println("You guessed in " + attempts + " attempts.");
                System.out.println("Score this round: " + score);
            }

            else {
                System.out.println("You lost! The correct number was: " + number);
            }

            totalScore += score;

            System.out.println("Total Score: " + totalScore);

            System.out.print("Play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

            round++;

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nGame Over!");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}